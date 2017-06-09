package kostyle.discount.domain;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MywayThread extends Thread {
	private String crollUrl;
	private String shopUrl;
	private int pagecount = 0;
	private List<DiscountVO> resultVOList;
	
	public MywayThread(String crollUrl, String shopurl){
		this.crollUrl = crollUrl;
		this.shopUrl = shopurl;
		resultVOList = new ArrayList<DiscountVO>();
	}

	public List<DiscountVO> getResultVOList() {
		return resultVOList;
	}

	//이전의 closet은 한상품이라서 list에 한줄씩담지않고 stringBuffer로 몽땅 한곳에 넣고 검사했었고, 여기서는 한줄씩 list에 쪼개어담아서 검출하낟.
	@Override
	public void run() {
	//	while(running){
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
		   List<String> product_NameList = new ArrayList<String>(); //최종 물품이름목록
		   List<String> product_PriceList = new ArrayList<String>();//최종 물품가격목록
 //	   List<String> product_BeforeSalePriceList = new ArrayList<String>();//최종 물품가격목록
//		   List<String> product_AfterSalePriceList = new ArrayList<String>();//최종 물품가격목록
		   List<String> product_LinkList = new ArrayList<String>();//최종 물품링크목록
		   List<String> product_ImgLinkList = new ArrayList<String>(); //최종 물품이름목록
		   List<String> rowList = new ArrayList<String>();   //페이지row 저장
		   
			URL url =null;
			BufferedReader br =null;
			try {
				url = new URL(crollUrl);
				System.out.println("연결중....url = " + crollUrl);
				URLConnection conn = url.openConnection(); 
			//	br = new BufferedReader(new InputStreamReader(url.openStream()));
				 br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			    String code;
				//StringBuffer sb = new StringBuffer();

				while((code=br.readLine())!=null){
					rowList.add(code);
					//System.out.println(code);
				}
			}catch (Exception e) {
					e.printStackTrace();
			}finally{
			    	  System.out.println("코드추출완료");
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
		       if(startLiRowNum.size() == 0 && endLiRowNum.size() == 0 ){
		    	   System.out.println("-------검색끝 " + (pagecount-1) + " 개 페이지 검색-------");
		    	   return;
		       }else if(pagecount == 2){ //느려서 최대9페이지까지만 받아옴
		    	   System.out.println("페이지 초과");
		    	   return;
		       }
//----------------------------------------  myWay --body --------------------------
		       List<StringBuffer> sbList = new ArrayList<StringBuffer>(); //상품하나 ==하나의 stirngBuffer(string하나처럼 한문장으로 뭉치기.)
		    	
		       
		       //상품하나하나를 각각의 스트링버퍼에 담기. //rowList에 전체코드 들어있음. 인덱스를 기준으로 한상품씩 스트링버퍼로 합칠것.
		       for (int i = 0; i < startLiRowNum.size(); i++) {
			          int startrow = startLiRowNum.get(i);
			          int endrow = endLiRowNum.get(i);      
			          StringBuffer sb = new StringBuffer();
			         
			          
			          for(int j=startrow; j<=endrow; j++){
			        	  sb.append(rowList.get(j));
			        	  //System.out.println("rowList.get("+j+"):  "+rowList.get(j));
			        	  //System.out.println("sb("+j+"):  "+sb);
			        	  
			        	  if(j == endrow){//마지막에 한번만 sbList(상품하나가 하나의 sb인목록)에 추가
			        		  sbList.add(sb);
			        		//  System.out.println(j+"번째 sbList에 추가된 sb내용: "+sb);
			        	  }
			          }
			          //System.out.println("sbList의 ("+i+")번째 sb:  "+sbList.get(i));
		       }        
			          
		      //한 상품마다 원하는 값 추출.
		       //뽑을값:  상품url, 이미지url, 상품할인전가격. 할인후가격, 이름
		       // DiscountVO vo  = new DiscountVO(product_LinkList.get(i), product_ImgLinkList.get(i), product_BeforeSalePriceList.get(i), "2원", product_NameList.get(i));          
			  for(int i=0; i<sbList.size(); i++){
				  String prdUrl = "";
				  String imgUrl = "";
				  List<String> priceList = new ArrayList<String>();
				  String prdName="";
				  StringBuffer sb = sbList.get(i);
				  
				  //상품Url찾기
				  prdUrl = findPrdUrl(sb);
				  
				  //이미지Url찾기
				 // imgUrl = findImgUrl(sb, prdUrl);
				  
				  //가격찾기 (할인전/ 할인후)
				  //priceList = findPrice(sb);
				  
				  //상품명 추출
				  prdName = findprdName(sb, prdUrl);
				  

	  
				  
				  
				  
				  
			  }
		       
		       
		       
			          
			          
			          
			       /*   List<String> oneBoxProduct_price = new ArrayList<String>();
			          List<String> oneBoxProduct_price_reset = new ArrayList<String>();
		       		
			          //상품Box에서 데이터뽑기
			          for(int j=startrow; j<endrow; j++){
			        	  String row = rowList.get(i);
			        	  
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
				              
				              
				         //상품이름 추출     
				              for(int p=0; p<productLink.length; p++){ //String productLink[] = { "a href=\"/product/detail", "a href=\"/shop/view" };
				            	  int pLinkNum = row.indexOf(productLink[p]);
				                 
				            	  if( pLinkNum != -1 && row.replaceAll("[^가-힣]","").length() > 0){ //이 줄에 링크가 있고 한글이 있으면  '상품이름'임.                                   
				                      product_name = searchProduct_Name(row);   //한글 값 추출
				                       product_link = searchProduct_Link(row, shopUrl); //링크 값 추출
				                       product_NameList.add(product_name);
				                       product_LinkList.add(product_link);                                
				                      
				                    }else if(row.indexOf(shopUrl) != -1){ //만약에 링크만 있고 한글이 없으면 이미지 링크도 있으니 이미지 링크 추출                    
				                       product_ImageLink= searchImgLink(row, shopUrl);      //상품 이미지 링크 함수
				                       product_ImgLinkList.add(product_ImageLink);
				                    }
				                 }           
				              }
			          
			             //돈 추가(찾은가격을 가격리스트에 추가)
                      
			             if(oneBoxProduct_price.size() > 0 ){
			                if(oneBoxProduct_price.get(0).length() > 6){
			                   oneBoxProduct_price.set(0,oneBoxProduct_price.get(0).substring(0, 7));
			                }             
			                product_PriceList.add(oneBoxProduct_price.get(0)+"원");     
			                oneBoxProduct_price = oneBoxProduct_price_reset;
			             }else if(oneBoxProduct_price.size() == 0){
			                product_PriceList.add("");
			             }
		       		}//리스트 하나(상품하나)에대한 맨바깥for  
		       
		       System.out.println("중복제거구문"+ pagecount);
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
			      
		          
		          System.out.println("값 넣기 직전"+pagecount);
			     //실제로 VO객체에 값넣기
		          for(int i=0; i<saveSize; i++){
		        	//public Product_category(String product_shopurl, String product_link, String product_name, String product_price, String product_ImageLink, String keyword) {
		        	//public DiscountVO(String sale_prdUrl, String sale_imgUrl, String sale_beforeDiscountprice, String sale_afterDiscountprice, String sale_name)
		        	
		        	  
		        	    Product_category pro  = new Product_category(shopurl, product_LinkList.get(i), product_NameList.get(i), product_PriceList.get(i), product_ImgLinkList.get(i), keyword);
            			main_product_list.add(pro);        
		        	   
		        	  
		        	  DiscountVO vo  = new DiscountVO(product_LinkList.get(i), product_ImgLinkList.get(i), "1원", "2원", product_NameList.get(i));
				      	System.out.println("결과 DiscountVO: "+ vo);
		          }*/
		        
		          run(); //재귀함수로 다음페이지도 돌아가도록.
	//	}while
	}//function
	
	public String findPrdUrl(StringBuffer sb){
		  String prdUrl = "";
	//상품url뽑기
		  String pattern ="a href=\"/product/detail[^\"]*|a href=\"/shop/view[^\"]*";
		//  System.out.println("indexof로 정규표현식이 뽑히나? : "+sb.indexOf(pattern));
		  
		  Pattern p = Pattern.compile(pattern); 
		  Matcher matcher = p.matcher(sb);

       //while(matcher.find()){//여러개다뽑으면 while+스트링버퍼. 리턴도 스트링버퍼로.
       if(matcher.find()){//첫번째 것만 뽑을거니 if에 String하나로.
           prdUrl = matcher.group() ; //어우헷갈... 여기서 그룹1은  ([^>\"']+) 이다.  그룹(0)은 매칭된 전체.)
       }
       //System.out.println("찾은 상품 prdUrl: "+prdUrl);
       
       return prdUrl;
	}
	
	/*
파라미터 sb: <li id="anchorBoxId_30137" class="item xans-record-">                <div class="box">                    <span class="chk"><input type="checkbox" class="ProductCompareClass xECPCNO_30137 displaynone"/></span>                    <a href="/product/detail.html?product_no=30137&cate_no=345&display_group=1" name="anchorBoxName_30137"><img src="//ggsing.com/web/product/medium/201601/30137_shop1_335264.jpg" alt="" class="thumb"/></a>                    <p class="name">                        <a href="/product/detail.html?product_no=30137&cate_no=345&display_group=1"><span style="font-size:12px;color:#000000;font-weight:bold;"><b>코팅 기모스키니</b></span></a><br/>                           </p>                    <ul class="xans-element- xans-product xans-product-listitem"><li class=" xans-record-"><strong class="title displaynone review_판매가"><span style="font-size:12px;color:#000000;font-weight:bold;">판매가</span> :</strong> <span style="font-size:12px;color:#000000;font-weight:bold;">8,800원</span><span id="span_product_tax_type_text" style=""> </span></li></ul><div class="crema-product-reviews-count" data-product-id="30137" data-format="리뷰 : {{{count}}}"></div>                    <p class="button">                        <span class="bag"><img src="http://img.echosting.cafe24.com/design/skin/default/product/btn_list_cart.gif" alt="장바구니넣기" onclick="" class="displaynone"/></span>                        <span class="option"><img src="http://img.echosting.cafe24.com/design/skin/default/product/btn_list_option.gif" alt="옵션보기" onclick="" onmouseout="" class="displaynone" id="btn_preview_listmain30137"/></span>                    </p>                </div>            </li>
파라미터 prdUrla href="/product/detail.html?product_no=30137&cate_no=345&display_group=1
	 * 
	 */
	public String findImgUrl(StringBuffer sb, String prdUrl){
		String imgUrl = "";
		int prdIndex = sb.indexOf(prdUrl);
		int endIndex = sb.indexOf("</a>");
		String subString = sb.substring(prdIndex, endIndex);
		System.out.println("파라미터 prdUrl: " +prdUrl);
		System.out.println("자른문자열: "+subString);
		
//		 String pattern ="<img[^>]*src=[\"']?([^>\"']+)[\"']?[^>]*>";
		 String pattern ="<img[^>]*src=[\"']?([^>\"']+)[.jpg|.gif|.png]{1}";
		  Pattern p = Pattern.compile(pattern); 
		  Matcher matcher = p.matcher(subString);

     //while(matcher.find()){//여러개다뽑으면 while+스트링버퍼. 리턴도 스트링버퍼로.
     if(matcher.find()){//첫번째 것만 뽑을거니 if에 String하나로.
         imgUrl = matcher.group() ; //어우헷갈... 여기서 그룹1은  ([^>\"']+) 이다.  그룹(0)은 매칭된 전체.)
         int colonIndex = imgUrl.indexOf("\"");
         imgUrl = imgUrl.substring(colonIndex+1);
     }
     System.out.println("찾은 상품 imgUrl: "+imgUrl);
     
		return imgUrl;
	}	
		
	
	//가격추출(할인전, 할인후)
	public List<String> findPrice(StringBuffer sb){
		List<String> priceList = new ArrayList<String>();
		List <String> tempList = new ArrayList<String>();
		String beforePrice = "";
		String afterPrice="";
		
		String nanda = "stylenanda"; //스타일난다는 클래스이름 price인 p태그
		//String spanRegex = "(<span )[^<]*(</span>)";
		//String spanRegex = "(<span )(.)*+[^<]";
		String spanRegex = "(<span )[^<]*(</span>)";
		String priceRegex = "((\\d{1,3})(,\\d{2})0|(\\d{1,2}0))";
//		String removeRegex = "<(/)?([a-zA-Z]*)(\\s[a-zA-Z]*=[^>]*)?(\\s)*(/)?>";
		String removeRegex = "<[^>]*>"; 
		
		Pattern spanP = Pattern.compile(spanRegex); 
		Matcher spanM = spanP.matcher(sb);
		String span ="";
	     //while(matcher.find()){//여러개다뽑으면 while+스트링버퍼. 리턴도 스트링버퍼로.
		while(spanM.find()){
			String tempStr = spanM.group();
			tempStr = tempStr.trim();
			System.out.println("뽑은 span: "+tempStr);
			tempStr.replaceAll(removeRegex, "");
			tempList.add(tempStr);
			System.out.println("<>제거한 값: "+tempStr);
	     }
		System.out.println("span 전부 뽑은 결과: "+tempList);
		
		return priceList;
	}
	

	//상품명추출1
	public String findprdName(StringBuffer sb, String prdUrl){
		System.out.println("파라미터sb : "+sb);
		String prdName = "";
		int prdIndex = sb.indexOf(prdUrl, 2);
		System.out.println("sb.indexOf(prdUrl): "+sb.indexOf(prdUrl));
		System.out.println("sb.indexOf(prdUrl,2): "+sb.indexOf(prdUrl,2));
		int endIndex = sb.indexOf("</a>",2);
		System.out.println("sb.indexOf('</a>', ): "+ sb.indexOf("</a>"));
		System.out.println("sb.indexOf('</a>',2 ): "+ sb.indexOf("</a>",2));
		String subString = sb.substring(prdIndex, endIndex);
		System.out.println("파라미터 prdUrl: " +prdUrl);
		System.out.println("자른문자열: "+subString);
		
		return prdName;
	}
	
	
	

	
	//-----------------------------------------------myway
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

public static void main(String[] args) {
		//MywayThread thread = new MywayThread("http://66girls.co.kr/product/list.html?cate_no=306", "66girls.co.kr/");
		//MywayThread thread = new MywayThread("http://www.stylenanda.com/product/list03.html?cate_no=613", "www.stylenanda.com/"); 
		MywayThread thread = new MywayThread("http://ggsing.com/product/list.html?cate_no=345", "ggsing.com/");
		//MywayThread thread = new MywayThread("http://loveloveme.com/product/list.html?cate_no=884", "loveloveme.com/");
		//MywayThread thread = new MywayThread("http://hotping.co.kr/product/list.html?cate_no=42", "hotping.co.kr/");
	//MywayThread thread = new MywayThread("http://www.dejou.co.kr/product/list.html?cate_no=34", "www.dejou.co.kr/"); 
		thread.start();
		
		
	}
	
	
}//class
