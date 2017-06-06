package kostyle.closet.persistence;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import kostyle.closet.domain.Closet;
import kostyle.closet.domain.ClosetPrd;
import kostyle.login.controller.CusLoginController;

@Repository
public class ClosetDAOImpl implements ClosetDAO {
	
	@Inject
	private SqlSession session;

	private static String namespace="kostyle.login.mappers.loginMapper";

	private static final Logger logger= LoggerFactory.getLogger(CusLoginController.class);

		
//-------------------------folder------------------------------
	//조회해온 옷장상품의 clo_num으로 clo_name얻어오기
	@Override
	public String cloNumTocloName(Closet closet) {
		logger.info("cloNumToCloName: "+session.selectOne(namespace+".cloNumTocloName", closet));
		return session.selectOne(namespace+".cloNumTocloName", closet);
	}
	
	//모든 '옷장'폴더를 리스트로 반환... navigation에 사용
	@Override
	public List<Closet> closetList(String c_num) {
		logger.info("closetList: "+session.selectList(namespace+ ".tabCloset", c_num));
		return session.selectList(namespace+ ".tabCloset", c_num) ;
	}

	//사용자의 모든 옷장에 들어있는 상품들을 전부 출력	
	@Override
	public List<ClosetPrd> fullCloset(ClosetPrd closetPrd) {
		logger.info("fullCloset: "+session.selectList(namespace +".fullCloset", closetPrd));
		return session.selectList(namespace +".fullCloset", closetPrd);
	}
	
	
	//사용자가 선택한 옷장의 상품들만 출력
	@Override
	public List<ClosetPrd> selectCloset(ClosetPrd closetPrd) {
		logger.info("selectCloset: "+session.selectList(namespace+".selectCloset", closetPrd));

		return session.selectList(namespace+".selectCloset", closetPrd);
	}


	//옷장폴더 추가
	@Override
	public void insertCloset(Closet closet) {
		 session.insert(namespace+".insertCloset",closet);
	}
	
	//가장 큰 옷장번호 구하기. 폴더추가시 max(clo_num)+1로
	@Override
	public int max_clo_num(String c_num) {
		logger.info("max_clo_num: "+session.selectOne(namespace+".max_clo_num",c_num));
		return session.selectOne(namespace+".max_clo_num",c_num);
	}
	
	//폴더이름 수정
	@Override
	public void updateCloset(Closet closet) {
		session.update(namespace+".updateCloset",closet);
	}
	
	//옷장폴더 삭제를 위한 해당옷장상품들 먼저 삭제 -> 옷장삭제)
	@Override
	public void deleteSameCloset_prds(Closet closet) {
		session.delete(namespace+".deleteSameCloset_prds",closet);
	}

	//옷장삭제
	@Override
	public void deleteCloset(Closet closet) {
		session.delete(namespace+".deleteCloset",closet);
	}

	//삭제를 위해 c_num으로 clo_num 가져오기
	@Override
	public List<Integer> cNumTocloNum(String c_num) {
		return session.selectList(namespace+".cNumTocloNum",c_num);
	}

	
//-------------------prd------------------------------------------------------
	
	//찜상품추가
	@Override
	public void insertClosetPrd(ClosetPrd closetPrd) {
		session.insert(namespace +".insertClosetPrd", closetPrd );
	}
	
	//해당상품의 중복여부 우선확인
	@Override
	public int check_duplication(ClosetPrd closetPrd) {
		logger.info("check_duplication중복여부: "+session.selectOne(namespace+".check_duplication",closetPrd));
		return session.selectOne(namespace+".check_duplication",closetPrd);
	}

	//가장 큰 clo_detail_num구하기. 찜상품추가시 +1해서 clo_detail_num으로사
	@Override
	public int max_detail_num() {
		logger.info("가장 큰 detail_num: "+session.selectOne(namespace+".max_detail_num"));
		return session.selectOne(namespace+".max_detail_num");
	}

	//해당상품zzim횟수 구하기 보완필요. 찜추가/삭제시 다른사람한테도 카운트반영되도록.
	@Override
	public int count_zzim(ClosetPrd closetPrd) {
		logger.info("보완필요한count_zzim: "+session.selectOne(namespace+".count_zzim",closetPrd));
		return session.selectOne(namespace+".count_zzim",closetPrd);
	}

	//(찜추가시)밑의 getImgURL,Price,Name 합쳐서 해시맵에.
	@Override
	public HashMap urlRepair(String prdUrl) {
		//class="xans-element- xans-product xans-product-detail" 쪽이 상단 상품정보 위치임.
		//가격: <string id="span_product_price_text" 이후 ',000원'이면 추출!
		/*       String strResult = num; //출력할 결과를 저장할 변수
        Pattern p = Pattern.compile("(^[+-]?\\d+)(\\d{3})"); //정규표현식 
        Pattern p = Pattern.compile("(^[+-]?\\d+,)*(\\d{3})")원$; //정규표현식 
        Matcher regexMatcher = p.matcher(num); 
[출처] [Java] 숫자에 쉼표(콤마;Comma) 넣기, 천(1000) 단위 구분 (정규표현식이용, replaceAll())|작성자 자바킹
*/

		//class="xans-element- xans-product xans-product-action " 이전까지 인덱스로 끊으면 상단상품 계산 위쪽까지 모아짐.
		
		
		//자바의 줄바꿈은 시스템마다 달라진다. 현재 운영체제의 줄바꿈 문자 얻는법.
		String line = System.getProperty("line.separator");
		System.out.println("dao에서 받은 prdUrl: "+prdUrl);

		URL url =null;
		BufferedReader br =null;
		//String address="http://66girls.co.kr/product/detail.html?product_no=67185&cate_no=81&display_group=2";
		String address="http://hotping.co.kr/product/detail.html?product_no=19218&cate_no=26&display_group=1";
		
		/*String address2= "http://66girls.co.kr/product/search.html?banner_action=&keyword=%EA%B0%80%EB%94%94%EA%B1%B4";
		address2 = URLDecoder.decode(address2);
		System.out.println("디코딩된 값: "+address2);*/
		
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
		HashMap<String,String> hash = new HashMap<String,String>();
		hash.put("imgUrl", imgUrl);
		hash.put("price", price);
		hash.put("prdName", prdName);
		
		logger.info("HashMap urlRepair: "+hash);

		return hash;
	}
	
	//찜상품 이미지url따오기
	@Override
	public String getImgURL(String source) {
		  String imgUrl = null;
		  int index1 = source.indexOf("keyImg");
		   System.out.println("이미지url인덱스: "+index1);
		   if(index1 != -1){
			   source = source.substring(index1);
			  /* int index2 = sb.indexOf("alt");
			   
			   code = code.substring(0, index2);*/
	        //StringBuffer sb = new StringBuffer();
	        //String regex ="(http|https|ftp)://[^\\s^\\.]+(\\.[^\\s^\\.^\"^\']+)*"; //공백문자,백슬러시,따옴표 등으로 시작하지 않는
	
	        Pattern pattern = Pattern.compile("<img[^>]*src=[\"']?([^>\"']+)[\"']?[^>]*>"); //img 태그 src 추출 정규표현식
	        Matcher matcher = pattern.matcher(source);
	         
	        //while(matcher.find()){//여러개다뽑으면 while+스트링버퍼. 리턴도 스트링버퍼로.
	        if(matcher.find()){//첫번째 것만 뽑을거니 if에 String하나로. 
	        	imgUrl = matcher.group(1) ; //어우헷갈... 여기서 그룹1은  ([^>\"']+) 이다.  그룹(0)은 매칭된 전체.)
	        	System.out.println(imgUrl);
	        }
	    }	
		   logger.info("getImgURL: "+imgUrl);
		   return imgUrl;
	}
	
	//찜상품 가격 가져오기
	@Override
	public String getPrice(String source) {
		  String price = null;
		  int index1 = source.indexOf("span_product_price_text");
		  System.out.println("가격추출인덱스결과: "+index1);
		  
		  if(index1 != -1){
			  source = source.substring(index1);
		  } 
		  System.out.println("가격추출할 소스: "+source);
		  //상품이름의 정규표현식...필요.. 전부 실패!
		  // Pattern pattern = Pattern.compile("(^[+-]?\\d+)*(,\\d{3})*원$");
		  //Pattern pattern = Pattern.compile("^[\\d]{1}([\\d,])*(\\s)*(원)$");
		  //Pattern pattern = Pattern.compile("(^[\\d])+[,]*[\\d]*");
		  //Pattern pattern = Pattern.compile("(^[\\d])+(,\\d{3})*(원)$");
		  //Pattern pattern = Pattern.compile("\\b(?:\\d{1,3})(?:,\\d{3})*(?:\\.\\d+)?\\b");
		 // Pattern pattern = Pattern.compile("(^[\\d])+([,][\\d]{3})*");
		  Pattern pattern = Pattern.compile("(\\d{1,3})+(,\\d{3})*");
		  //도대체 왜 시작태그인 ^나 원$으로 끝나는 것을 찾으면 전부 null? 
		  Matcher matcher = pattern.matcher(source);
		  
		  if(matcher.find()){
			  System.out.println("매치되는 가격을 찾긴찾았다!");
			  price = matcher.group(); //매칭된부분 전체반환
		  }
		  System.out.println("최종추출가격: "+price);
		  
		  return price+"원";
	}

	//찜상품 이름 가져오기
	@Override
	public String getPrdName(String source) {
		String prdName = null;
		
		  int index1 = 0;
		  System.out.println("'상품명'추출인덱스결과: "+index1);
		  
		  if(index1 != -1){
			  source = source.substring(index1);
		  }
		  
		  Pattern pattern = Pattern.compile(""); //상품이름 가져올 정규표현식 알아야..
		  Matcher matcher = pattern.matcher(source);
		  
		  if(matcher.find()){
			  prdName = matcher.group(); //매칭된부분 전체반환
			  System.out.println("최종추출'상품명': "+prdName);
		  }
		  
		  return prdName;
	}

	//url에서 http://떼기
	@Override
	public String prdUrlRepair(String prdUrl) {
		 int index = -1;
		  index = prdUrl.indexOf("http://");
		  
		  if(index != -1){
			  index = index +7;
			  prdUrl = prdUrl.substring(index);
			  System.out.println("http://뗀 prdUrl: "+prdUrl);
		  }
		  return prdUrl;
	  }

	//쇼핑몰 도메인 가져오기
	@Override
	public String getShopUrl(String prdUrl) {
		  String shopUrl = "";
		  
		  ClosetDAO dao = new ClosetDAOImpl();
		  prdUrl = dao.prdUrlRepair(prdUrl);
		  
		  int index = prdUrl.indexOf("/product/");
		  if(index != -1 ){
			  shopUrl = prdUrl.substring(0, index);
			  logger.info("얻은 shopUrl: "+shopUrl);
		  }
		  
		  return shopUrl;
	}

	//꼭 DB로 해야하나.. 등록시 url로 쇼핑몰이름따오기
	@Override
	public String getS_name(String closetPrd_shopUrl) {
		String s_name = "";
		if(closetPrd_shopUrl.indexOf("66girls.co.kr") != -1){
			s_name = "66걸즈";
		}else if(closetPrd_shopUrl.indexOf("www.stylenanda.com") != -1 ){
			s_name = "스타일난다";
		}else if(closetPrd_shopUrl.indexOf("ggsing.com") != -1){
			s_name = "고고싱";
		}else if(closetPrd_shopUrl.indexOf("loveloveme.com") != -1){
			s_name = "러브러브미";
		}else if(closetPrd_shopUrl.indexOf("hotping.co.kr") != -1){
			s_name = "핫핑";
		}else if(closetPrd_shopUrl.indexOf("www.dejou.co.kr") != -1){
			s_name = "더데이즈";
		}else if(closetPrd_shopUrl.indexOf("imvely.com") != -1){
			s_name = "임블리";
		}
		return s_name;
	}

	
	
	//상품의 옷장(폴더)이동
	@Override
	public void moveClosetPrd(ClosetPrd closetPrd) {
		session.update(namespace+".moveClosetPrd",closetPrd);
	}

	//상품 삭제
	@Override
	public void deleteClosetPrd(int clo_detail_num) {
		session.delete(namespace+".deleteClosetPrd", clo_detail_num);
		
	}
	
	
	
}//class