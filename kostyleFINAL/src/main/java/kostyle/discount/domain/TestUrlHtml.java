package kostyle.discount.domain;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestUrlHtml{
private List<String> htmlList = null;
	private  URL url = null;
	private  String address = null;

	public TestUrlHtml(){}

	public TestUrlHtml(String address) {
		super();
		this.address = address;
	}

	public URL getUrl() {
		return url;
	}

	public void setUrl(URL url) {
		this.url = url;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

/*	public List<String> urlHtml(String address){
		try {
			   url = new URL(address);
		       URLConnection con = url.openConnection();
		        BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
		        String tmp;

		        while ((tmp = br.readLine()) != null) {
		           htmlList.add(tmp);
		           System.out.println(tmp);
		        }
		        System.out.println("완료");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return htmlList;
	}*/
		
/*	public static void main(String[] args){
		String line = System.getProperty("line.separator");

		URL url =null;
		BufferedReader br =null;*/
		//String address="http://66girls.co.kr/product/detail.html?product_no=67185&cate_no=81&display_group=2";
		//String address="http://hotping.co.kr/product/detail.html?product_no=19218&cate_no=26&display_group=1";
		
		/*String address2= "http://66girls.co.kr/product/search.html?banner_action=&keyword=%EA%B0%80%EB%94%94%EA%B1%B4";
		address2 = URLDecoder.decode(address2);
		System.out.println("디코딩된 값: "+address2);*/
		
	
		
	
		
	//보낼 때는... Searchurl+키값    인코딩 후 넣고, String SearchUrl = SearchUrl+key ; SearchUrl=URLEnncoder.encode(SearchUrl);
		/*String key = URLEncoder.encode("키워드", "UTF-8");
		String searchUrl = "https://검색할url자리";
		URL url = new URL(searchUrl+key);*/
/*		try {
			url = new URL(address);
			URLConnection con = url.openConnection(); 
			br = new BufferedReader(new InputStreamReader(url.openStream()));
	        String tmp;

	        while ((tmp = br.readLine()) != null) {
	           //htmlList.add(tmp);
	          // System.out.println(tmp);
	        }
	        br.close();
	        System.out.println("완료");
			
			System.out.println("conn.toString(): "+con);
			System.out.println("getAllowserInteration(): "+con.getAllowUserInteraction());
			System.out.println("getConnectTimeout(): "+ con.getConnectTimeout());
			System.out.println("getContent(): "+con.getContent());
			System.out.println("getContentEncoding(): "+con.getContentEncoding());
		} catch (Exception e) {
			e.printStackTrace();
		}
		*/
		/*String address="http://www.stylenanda.com/product/search.html?banner_action=&keyword=바지";
		
		
		try {
			url = new URL(address);
			URLConnection con = url.openConnection(); 
			br = new BufferedReader(new InputStreamReader(url.openStream()));
		    String code;
			StringBuffer sb = new StringBuffer();

			while((code=br.readLine())!=null){
				sb.append(code+line); // 문자열을 합칠 때 append가 속도가 빠름
				System.out.println(code+line);
			}*/
			//System.out.println(sb);
		   //int index1 = sb.indexOf("class=\"keyImg\"><img")+21;
		   /*int index1 = sb.indexOf("keyImg");
		   System.out.println("인덱스: "+index1);
		   if(index1 != -1){
			   code = sb.substring(index1);*/
			  /* int index2 = sb.indexOf("alt");
			   
			   code = code.substring(0, index2);*/
/*			   code = getImgURL(code);
			   
		   }*/
			
			//http:주소뽑아오기테스트
/*			Pattern pattern = Pattern.compile("(http|https)://[^\\s^\\.]+(\\.[^\\s^\\.^\"^\']+)*"); //img 태그 src 추출 정규표현식
	        Matcher matcher = pattern.matcher(sb);
	        List<String> resultList = new ArrayList<>();
	        String result0608="";
	        int listCount=0;*/
	        
	      //while(matcher.find()){//여러개다뽑으면 while+스트링버퍼. 리턴도 스트링버퍼로.
	       // if(matcher.find()){//첫번째 것만 뽑을거니 if에 String하나로. 
	       // 	result0608 = matcher.group() ; //어우헷갈... 여기서 그룹1은  ([^>\"']+) 이다.  그룹(0)은 매칭된 전체.)
	        	//System.out.println(result0608);
	      //  }
	        
/*			} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if( br !=null){
					br.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}*/
		
	//}
	
//	  public static String getImgURL(String str){
/*	public static void getImgURL(String str){
		  String imgUrl = null;
	        StringBuffer sb = new StringBuffer();*/
	        //String regex ="(http|https)://[^\\s^\\.]+(\\.[^\\s^\\.^\"^\']+)*";

	       // Pattern pattern = Pattern.compile("<img[^>]*src=[\"']?([^>\"']+)[\"']?[^>]*>"); //img 태그 src 추출 정규표현식
	        //Matcher matcher = pattern.matcher(str);
	         
	        //while(matcher.find()){//여러개다뽑으면 while+스트링버퍼. 리턴도 스트링버퍼로.
	  /*      if(matcher.find()){//첫번째 것만 뽑을거니 if에 String하나로. 
	        	imgUrl = matcher.group(1) ; //어우헷갈... 여기서 그룹1은  ([^>\"']+) 이다.  그룹(0)은 매칭된 전체.)
	        	System.out.println(imgUrl);
	        }
	        return imgUrl;*/
	    //}
	
	
	public static void main(String[] args){
		String crollUrl ="http://www.stylenanda.com/product/search.html?banner_action=&keyword=바지";
	    String shopUrl = "http://www.stylenanda.com";
		int pagecount = 0;
		
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
				System.out.println(code);
			}
		}catch (Exception e) {
				e.printStackTrace();
		}finally{
		    	  System.out.println("코드buffering완료");
	   }
			
	}
}//classBody
