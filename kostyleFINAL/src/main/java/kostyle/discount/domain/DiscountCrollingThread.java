package kostyle.discount.domain;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.jasper.tagplugins.jstl.core.Catch;

import kostyle.category.domain.Product_category;

public class DiscountCrollingThread extends Thread {
	   private volatile boolean running = true;
	   
	    public void terminate() {
	        running = false;
	    }
	 
	    
	    
	private String crollUrl;
	private String shopUrl;
	private int pagecount = 0;
	
	private List<DiscountVO> resultVOList;
	
	
	public DiscountCrollingThread(String crollUrl, String shopurl){
		this.crollUrl = crollUrl;
		this.shopUrl = shopurl;
		resultVOList = new ArrayList<DiscountVO>();
	}
	
	public List<DiscountVO> getResultVOList() {
		return resultVOList;
	}

	@Override
	public String toString() {
		return "DiscountCrollingThread [crollUrl=" + crollUrl + ", resultVOList=" + resultVOList + "]";
	}
	
	

	
	//할인율 (A-B)/A*100
	// Pattern pattern = Pattern.compile("<img[^>]*src=[\"']?([^>\"']+)[\"']?[^>]*>"); //img 태그 src 추출 정규표현식
	//가격: Pattern pattern = Pattern.compile("(\\d{1,3})(,\\d{3})+");
	//String pattern[] = {"(\\d{1,3})(,\\d{3})+","(\\d{1,2}0)"};
	//String regex ="(http|https)://[^\\s^\\.]+(\\.[^\\s^\\.^\"^\']+)*";
	// 물품 바로가기 링크 페이지 인식 String productLink[] = { "a href=\"/product/detail", "a href=\"/shop/view" };


	@Override
	public void run() {
		while(running) {
		String crollUrl = this.crollUrl;
		String shopUrl = this.shopUrl;
		
		   //검색 페이지면 마지막 페이지 숫자 삭제
		   if(crollUrl.indexOf("&page="+pagecount) != -1){
			   crollUrl = crollUrl.substring(0, crollUrl.length() - 7);
		   }
		   //검색 페이지 처리
		   pagecount ++;
		   crollUrl = crollUrl + "&page=" + pagecount;	   			   
	   
	   List<Integer> startLiRowNum = new ArrayList<Integer>(); // 물품 시작 box 줄 모음
	   List<Integer> endLiRowNum = new ArrayList<Integer>(); // 물품 끝 box 줄 모음
	   List<String> product_NameList = new ArrayList<String>();
	   List<String> product_PriceList = new ArrayList<String>();
	   List<String> product_LinkList = new ArrayList<String>();
	   List<String> product_ImgLinkList = new ArrayList<String>();
	   List<String> rowList = new ArrayList<String>();   //페이지row 저장
		
		
		URL url =null;
		BufferedReader br =null;
		
		try {
			url = new URL(crollUrl);
			System.out.println("연결중....url = " + crollUrl);
			URLConnection conn = url.openConnection(); 
			br = new BufferedReader(new InputStreamReader(url.openStream()));
			
		    String code;
			StringBuffer sb = new StringBuffer();

			while((code=br.readLine())!=null){
				rowList.add(code);
				//System.out.println(code);
			}
		}catch (Exception e) {
				e.printStackTrace();
		}finally{
		    	  System.out.println("코드buffering완료");
	   }
			
		// 물품 하나 시작 태그 인식
	       String startLI = "<li id";
	       String startClass = "xans-record"; // 쇼핑몰 물품 박스 class 이름

	       // 물품 하나 끝 태그 인식
	       String endLI = "</li>"; // 이건 row 전체값이 </li>이여야 한다.

	       // 물품 바로가기 링크 페이지 인식
	       String productLink[] = { "a href=\"/product/detail", "a href=\"/shop/view" };
	       String product_NameCheck = "[가-힣]"; // 물품 이미지 검색 (한글 있으면 true 리턴)
	       int productImgLinkRowNum = 0;// 이미지 src 담겨있는 열 검사결과

	       String Not_product_NameCheck = "[^가-힣]"; // 물품 이름 추출 최대길이 10, 물품 금액은
	                                        // 한글 4글자 이하, 물품 설명은 한글
	                                        // 10자 이하 한글 검사 있으면
	                                        // false리턴
	       int productLinkRowNum = 0; // 결과값 저장

	       
	       //검색한 하나의 상품을 Box형태로 모으기
	       for (int i = 0; i < rowList.size(); i++) {
	          String row = rowList.get(i);
	          int startlicheck = -1;
	          int startliclasscheck = -1;
	          startlicheck = row.indexOf(startLI);
	          startliclasscheck = row.indexOf(startClass);

	          if (startlicheck != -1 && startliclasscheck != -1) {
	             startLiRowNum.add(i);
	          } else if (row.trim().equals(endLI) && startLiRowNum.size() > 0) {
	             if (startLiRowNum.get(0) < i) {
	                endLiRowNum.add(i);
	             }
	          }            
	       }
	       //검색한 상품이 없을때 재귀함수 중지
	       System.out.println("startLiRowNum.size() / endLiRowNum.size()= "+ startLiRowNum.size()+",  "+ endLiRowNum.size());
	       System.out.println("pagecount: "+pagecount);
	       if(pagecount >= 2){ //느려서 최대9페이지까지만 받아옴
	    	   System.out.println("페이지 초과");
	    	   running = false;
	    	   return;
	       }
	      else  if(startLiRowNum.size() == 0 && endLiRowNum.size() == 0 ){
	    	   System.out.println("-------검색끝 " + (pagecount-1) + " 개 페이지 검색-------");
	    	   running=false;
	    	   return;
	       }
	       
	       
	       System.out.println(getName() + "페이지초과 체크위치 지남.");
	       
	       
	       for (int i = 0; i < startLiRowNum.size(); i++) {
		          int startrow = startLiRowNum.get(i);
		          int endrow = endLiRowNum.get(i);            
		          
		          List<String> oneBoxProduct_price = new ArrayList<String>();
		          List<String> oneBoxProduct_price_reset = new ArrayList<String>();

		          //상품Box에서 데이터뽑기
		          for(int j=startrow; j<endrow; j++){
		             String row = rowList.get(j);
		             
		            String product_link = ""; //물건 링크값
		             //물건 설명값
		             String product_name = "";//물건 이름값
		             String product_price = "";//물건 금액 값
		             String product_ImageLink = "";//물건 이미지 링크값
		             
		             //가격찾기
		            	String pattern = "<(/)?([a-zA-Z]*)(\\s[a-zA-Z]*=[^>]*)?(\\s)*(/)?>";
		               	String price = row.replaceAll(pattern, "");	               	
		               	price = price.trim();   		             
		               	String price2 = price.replaceAll("[0-9]{1,3},[0-9]{1,3}", "");
		               	price2 = price2.trim();              	              
		               	List<String> fristrowList = new ArrayList<String>();
		               	List<String> LastrowList = new ArrayList<String>();
		               	
			              for(int s=0; s<price.length(); s++){
			            	  fristrowList.add(price.substring(s,s+1));
			              }
			              for(int s=0; s<price2.length(); s++){
			            	  LastrowList.add(price2.substring(s,s+1));
			              }
			              //두개의리스트를비교해중복값제거하고첫번째리스트에저장
			              fristrowList.removeAll(LastrowList);
			              for(int s=0; s<fristrowList.size(); s++){
			            	  product_price+=fristrowList.get(s);		            	
			              }
			              
			              if(!(product_price.equals(""))){		            	  
			            	  oneBoxProduct_price.add(product_price);
			              }
		              //가격찾기끝
		             
		             for(int p=0; p<productLink.length; p++){
		                int pLinkNum = row.indexOf(productLink[p]);
		                
		                if( pLinkNum != -1 && row.replaceAll("[^가-힣]","").length() > 0){ //이 줄에 링크가 있고 한글이 있으면                                     
		              	 product_name = searchProduct_Name(row);   //한글 값 추출함수
		                   product_link = searchProduct_Link(row, shopUrl); //링크 값 추출함수
		                   product_NameList.add(product_name);
		                   product_LinkList.add(product_link);                                
		                  
		                }else if(row.indexOf(shopUrl) != -1){ //만약에 링크만 있고 한글이 없으면 이미지 링크도 있으니 이미지 링크 추출                    
		                	  product_ImageLink= searchImgLink(row, shopUrl);      //상품 이미지 링크(sh)
		       	
/*			                	//상품이미지링크 (sy)
			       	        Pattern patternImg = Pattern.compile("<img[^>]*src=[\"']?([^>\"']+)[\"']?[^>]*>"); //img 태그 src 추출 정규표현식
			       	        Matcher matcherImg = patternImg.matcher(row);
			       	         
			       	        //while(matcher.find()){//여러개다뽑으면 while+스트링버퍼. 리턴도 스트링버퍼로.
			       	        if(matcherImg.find()){//첫번째 것만 뽑을거니 if에 String하나로. 
			       	        	product_ImageLink = matcherImg.group(1) ; //어우헷갈... 여기서 그룹1은  ([^>\"']+) 이다.  그룹(0)은 매칭된 전체.)
			       	        	product_ImageLink = product_ImageLink.trim();
			       	        	product_ImageLink = product_ImageLink.replace("//", "");
			       	        	System.out.println("product_ImgaeLink: "+product_ImageLink);
			       	        }*/
			       	     
		                   product_ImgLinkList.add(product_ImageLink);
		                }
		             }                    
		          }           
		          
		          
		          
		          
		          
		          
		          //돈 추가
		          	        System.out.println("oneBoxProduct_price.size() "+ oneBoxProduct_price.size());
		          if(oneBoxProduct_price.size() > 0 ){
		        	  for(int k=0; k<oneBoxProduct_price.size(); k++){
		        		  System.out.println("oneBoxProduct_price.get("+k+") : "+ oneBoxProduct_price.get(k)+"원");
			        	  if(oneBoxProduct_price.get(k).length() > 6){
			        		  System.out.println("oneBoxProduct_price.get(k).length() > 6 진입");
			        		  oneBoxProduct_price.set(k,oneBoxProduct_price.get(k).substring(0, 7));
			        	         	  
			        	//  product_PriceList.add(oneBoxProduct_price.get(k)+"원");     
			        		  System.out.println(oneBoxProduct_price.get(k)+"원");
			        	//  oneBoxProduct_price = oneBoxProduct_price_reset;
			          }else if(oneBoxProduct_price.size() == 0){
			        	 // product_PriceList.add("");
			          }
		       } //for
/*		          if(oneBoxProduct_price.get(0).length() > 6){
		        	  oneBoxProduct_price.set(0,oneBoxProduct_price.get(0).substring(0, 7));
		          }        	  
		          product_PriceList.add(oneBoxProduct_price.get(0)+"원");     
		          oneBoxProduct_price = oneBoxProduct_price_reset;
		          }else if(oneBoxProduct_price.size() == 0){
		        	  product_PriceList.add("");
		          }
*/		       }//if	         	      
		       
		       //중복제거 구문            	   
		       product_ImgLinkList = productStack_clear(product_ImgLinkList);
		       product_NameList = productStack_clear(product_NameList);	       	    	       
		       product_LinkList = productStack_clear(product_LinkList);
		       
		       //중복제거하고 구문 처리	      	      
		       int saveSize = product_LinkList.size();
		       if(saveSize > product_NameList.size()){
		    	   saveSize = product_NameList.size();
		       }else if(saveSize > product_PriceList.size()){
		    	   saveSize = product_PriceList.size();
		       }else if(saveSize > product_ImgLinkList.size()){
		    	   saveSize = product_ImgLinkList.size();
		       }
		       
		       for(int m=0; m<saveSize; m++){
//		      	DiscountVO vo  = new DiscountVO(shopurl, product_LinkList.get(i), product_NameList.get(i), product_PriceList.get(i), product_ImgLinkList.get(i), keyword);
		      	DiscountVO vo  = new DiscountVO(product_LinkList.get(m), product_ImgLinkList.get(m), "1원", "2원", product_NameList.get(m));
		      	System.out.println("결과 DiscountVO: "+ vo);
//public Product_category(String product_shopurl, String product_link, String product_name, String product_price, String product_ImageLink, String keyword) {
//	public DiscountVO(String sale_prdUrl, String sale_imgUrl, String sale_beforeDiscountprice, String sale_afterDiscountprice, String sale_name)
		      	
		      	resultVOList.add(vo);	     
		       }
		       
		       run();
	       }
		}
		/*		//자바의 줄바꿈은 시스템마다 달라진다. 현재 운영체제의 줄바꿈 문자 얻는법.
		String line = System.getProperty("line.separator");
		System.out.println("dao에서 받은 prdUrl: "+prdUrl);

		//String address="http://66girls.co.kr/product/detail.html?product_no=67185&cate_no=81&display_group=2";
		//String address="http://hotping.co.kr/product/detail.html?product_no=19218&cate_no=26&display_group=1";
		
		//String address2= "http://66girls.co.kr/product/search.html?banner_action=&keyword=%EA%B0%80%EB%94%94%EA%B1%B4";
		//address2 = URLDecoder.decode(address2);
		//System.out.println("디코딩된 값: "+address2);
		
		URL url =null;
		BufferedReader br =null;
		String imgUrl ="";
		String price="";
		String prdName="";
		try {
			url = new URL(prdUrl);
			URLConnection con = url.openConnection(); 
			br = new BufferedReader(new InputStreamReader(url.openStream()));
		    String code;
			StringBuffer sb = new StringBuffer();

			while((code=br.readLine())!=null){
				sb.append(code+line); // 문자열을 합칠 때 append가 속도가 빠름
			}
			code = sb.substring(0);
			
			
				imgUrl = getImgURL(code); 
				price = getPrice(code);
				prdName = "";
			
			} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if( br !=null){
					br.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		 */
		
		
	}
	//-------------------------------------------------------------------
	//물품 바로가기 링크 페이지 인식하면 이미지링크 추출메소드
   /* public String searchImgLink(String row, String shopurl){        
    	String pattern[] = {".gif\"",".jpg\"",".png\""};
    	
        int productImgLinkRow = row.indexOf("<img src");        //물품 바로가기에서 옷 이미지 링크 줄번호 가져오기

        String productLinkResult = "";        //물품 바로가기에서 옷 이미지 링크 가져오기
        if( productImgLinkRow != -1){
           String productLinkRow = row; //ex ) aaaaA<img src = "dddddd">ddd
           String productLinkRow_Frist_Cut = productLinkRow.substring(productImgLinkRow, productLinkRow.length()); //ex) <img src="ddddddd">ddd
           int productLinkRow_End_Cut_Index = -1;
           for(int i=0; i<pattern.length; i++){
        	   if( productLinkRow_Frist_Cut.indexOf(pattern[i]) != -1){
        	   productLinkRow_End_Cut_Index = productLinkRow_Frist_Cut.indexOf(pattern[i])+5; //끝값 식별 .gif .png .jpg
        	   }
           }
           productLinkResult = productLinkRow_Frist_Cut.substring(12, productLinkRow_End_Cut_Index-1); // <img src="ddddddd">
        }
        return productLinkResult;
    }*/
    
    public String searchProduct_Name(String row){
	   	 row = row.trim();
	     String start_Atag = "<a href=\"";
	     String end_Atag = "/>";
	     
	     int start_Atag_index = row.indexOf(start_Atag);
	     int end_Atag_index = -1;
	     String startRow = row.substring(start_Atag_index,row.length());
	     end_Atag_index = startRow.indexOf(end_Atag);
	     
	     
	     if(start_Atag_index < end_Atag_index){
	    	 startRow = row.substring(start_Atag_index, end_Atag_index);
	     }
	     
	     String product_name = startRow.replaceAll("[^가-힣]", ""); //상품 이름
	     return product_name;
    }
    
    public String searchProduct_Link(String row,String shopurl){
	   	 row = row.trim();
	     String start_Atag = "<a href=\"";
	     String end_Atag = ">";	     	

	     int start_Atag_index = row.indexOf(start_Atag);
	     String startRow = row.substring(start_Atag_index,row.length());
	     int end_Atag_index = startRow.indexOf(end_Atag);

	     String total_Atag = row.substring(start_Atag_index, end_Atag_index);
	                                      
	     String product_link = total_Atag.substring(10, total_Atag.length()-1); //상품 링크
	     product_link = shopurl + product_link;
	     
	     
	     //예외처리
	     if(product_link.indexOf("name=") != -1 ){
	    	 product_link = product_link.substring(0, product_link.indexOf("name="));
	     }
	     if(product_link.indexOf("\"") != -1){
	    	 product_link = product_link.substring(0, product_link.length()-2);
	     }
	     if(product_link.indexOf("\" class") != -1){
	    	 product_link = product_link.substring(0, product_link.indexOf("\" class"));
	     }
	     
	     return product_link;
	}
    
    //각 데이터 중복 제거
    public List<String> productStack_clear(List<String> saveList){
    	 List<String> defaultList = new ArrayList<String>();
	       for (int i = 0; i < saveList.size(); i++) {
	           if (!defaultList.contains(saveList.get(i))) {
	        	   defaultList.add(saveList.get(i));
	           }
	       }
	       saveList = defaultList;
	       return saveList;
    }
	
	//----------------------------------------------------------------------
	//url에서 http://, https://떼기
	public String prdUrlRepair(String prdUrl) {
		 int index1 = -1;
		 int index2 = -1; 
		 index1 = prdUrl.indexOf("http://");
		 index2 = prdUrl.indexOf("https://");
		  
		  if(index1 != -1){
			  index1 = index1 +7;
			  prdUrl = prdUrl.replace("http://", "");
			  //prdUrl = prdUrl.substring(index1);
			  System.out.println("http://뗀 prdUrl: "+prdUrl);
		  }else if(index2 != -1){
			  index2 = index1 +8;
			  prdUrl = prdUrl.replace("https://", "");
			//  prdUrl = prdUrl.substring(index2);
			  System.out.println("http://뗀 prdUrl: "+prdUrl);
		  }
		  
		  return prdUrl;
	  }
	
	//할인율계산
	public String calDiscountRate(String val1, String val2){
		int discountRate = 0;
		Pattern patternImg = Pattern.compile("[^\\d]"); //img 태그 src 추출 정규표현식
		
		val1.replaceAll("[^\\d]", "");
		val2.replaceAll("[^\\d]", "");
		int valInt1 = Integer.parseInt(val1);
		int valInt2 = Integer.parseInt(val2);
		
		//할인율 (A-B)/A*100이니까
	    if(valInt1 >= valInt2){
	    	discountRate = (int)((valInt1 - valInt2)/valInt1*100);
	    }else{
	    	discountRate = (int)((valInt2 - valInt1)/valInt2*100);
	    }
		
		return discountRate+"%";
	}
	
	
	//물품 바로가기 링크 페이지 인식하면 이미지링크 추출메소드
    public String searchImgLink(String row, String shopurl){        
	    	String pattern[] = {".gif\"",".jpg\"",".png\""};
	    	
	        int productImgLinkRow = row.indexOf("<img src");        //물품 바로가기에서 옷 이미지 링크 줄번호 가져오기

	        String productLinkResult = "";        //물품 바로가기에서 옷 이미지 링크 가져오기
	        if( productImgLinkRow != -1){
	           String productLinkRow = row; //ex ) aaaaA<img src = "dddddd">ddd
	           String productLinkRow_Frist_Cut = productLinkRow.substring(productImgLinkRow, productLinkRow.length()); //ex) <img src="ddddddd">ddd
	           int productLinkRow_End_Cut_Index = -1;
	           for(int i=0; i<pattern.length; i++){
	        	   if( productLinkRow_Frist_Cut.indexOf(pattern[i]) != -1){
	        	   productLinkRow_End_Cut_Index = productLinkRow_Frist_Cut.indexOf(pattern[i])+5; //끝값 식별 .gif .png .jpg
	        	   }
	           }
	           productLinkResult = productLinkRow_Frist_Cut.substring(12, productLinkRow_End_Cut_Index-1); // <img src="ddddddd">
	        }
	        return productLinkResult;
	    }
	
	public static void main(String[] args) {
		//DiscountCrollingThread thread = new DiscountCrollingThread("http://66girls.co.kr/product/list.html?cate_no=306", "66girls.co.kr/");
		//DiscountCrollingThread thread = new DiscountCrollingThread("http://www.stylenanda.com/product/list03.html?cate_no=57", "www.stylenanda.com/");
		DiscountCrollingThread thread = new DiscountCrollingThread("http://ggsing.com/product/list.html?cate_no=345", "ggsing.com/");
		//DiscountCrollingThread thread = new DiscountCrollingThread("http://loveloveme.com/product/list.html?cate_no=884", "loveloveme.com/");
	//	DiscountCrollingThread thread = new DiscountCrollingThread("http://hotping.co.kr/product/list.html?cate_no=42", "hotping.co.kr/");
	//	DiscountCrollingThread thread = new DiscountCrollingThread("http://www.dejou.co.kr/product/list.html?cate_no=34", "www.dejou.co.kr/");
		thread.start();
		
		
	}
	
	
}//class
