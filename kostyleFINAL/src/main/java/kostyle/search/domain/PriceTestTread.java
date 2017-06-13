package kostyle.search.domain;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class PriceTestTread extends Thread {

	private String path;
	
	public PriceTestTread(String path) {
		super();
		this.path = path;
	}

	
	public String getPath() {
		return path;
	}


	public void setPath(String path) {
		this.path = path;
	}


	@Override
	public void run() {
		
		Document doc;
		try {
			System.out.println("지금 크롤링 하는 곳은?:"+path);
			doc = Jsoup.connect(path).get();
			
			//쇼핑몰 url주소 substring
			int index = 0;
			if(path.indexOf(".com/")>0){
				index = path.indexOf(".com/");
			}else{
				index = path.indexOf("o.kr/");
			}
			
			String shoppingUrl = path.substring(0, index+4);
		
			List<List<String>> outerList = new ArrayList<>();									//각 상품의 가격을 담는 list
			List<String> finalPriceList = new ArrayList<>();
			Elements prdPriceEl = null;
			
			if(path.indexOf("stylenanda")>0){
				prdPriceEl = doc.select("ul.prdList li.item");
				List<String> stylenandaList = new ArrayList<String>();
				System.out.println(shoppingUrl+"의 size:"+prdPriceEl.size());
				
				for(int i=0; i<prdPriceEl.size(); i++){
					stylenandaList.add(prdPriceEl.get(i).html());
				}
				System.out.println("priceListResult:"+stylenandaList);
				
				for(int i=0; i<stylenandaList.size(); i++){
					outerList.add(getPrice(stylenandaList.get(i)));
				}
			}else if(path.indexOf("imvely")>0){
				prdPriceEl = doc.select("ul.prdList li.item");
				System.out.println(shoppingUrl+"의 size:"+prdPriceEl.size());
				
				List<String> imvStrList = new ArrayList<>();
				for(int i=0; i<prdPriceEl.size(); i++){
					imvStrList.add(prdPriceEl.get(i).html());
				}
				
				for(int i=0; i<imvStrList.size(); i++){
					outerList.add(getPrice(imvStrList.get(i)));
				}
			}else{
				prdPriceEl = doc.select("ul.prdList li.item");
				List<String> otherStrList = new ArrayList<>();
				System.out.println(shoppingUrl+"의 size:"+prdPriceEl.size());
				
				for(int i=0; i<prdPriceEl.size(); i++){
					otherStrList.add(prdPriceEl.get(i).html());
				}
				
				for(int i=0; i<otherStrList.size(); i++){
					outerList.add(getPrice(otherStrList.get(i)));
				}
			}
			if(path.indexOf("hotping")!=-1){
				for(int i=0; i<outerList.size(); i++){
					int num=outerList.get(i).size();
					outerList.get(i).remove(num-1);
				}
			}
			
			System.out.println("바깥리스트:"+outerList);											//결과를 출력하면?[[18,000], [12,000], [16,900], [18,000], [19,900], [12,000], [16,000], [14,000, 9,800]]
																								//path=http://66girls.co.kr/product/search.html?banner_action=&keyword=바지&page=2
			for(int i=0; i<outerList.size(); i++){
				System.out.println("각 리스트의 사이즈:"+outerList.get(i).size());
				if(outerList.get(i).size()>1){
					finalPriceList.add(outerList.get(i).get(1)+"원");
				}else{
					finalPriceList.add(outerList.get(i).get(0)+"원");
				}
			}
			System.out.println("최종 가격:"+finalPriceList);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public List<String> getPrice(String element){
		String removeTagEl = element.replaceAll("<[^>]*>", "");								//태그와 태그안의 문자들을 삭제
		String forRemoveKR = "[ㄱ-ㅎ가-힣]";													//한글 삭제를 위한 정규표현식.
		String removeKR=removeTagEl.replaceAll(forRemoveKR, "");							//한글을 삭제
																							/*String regPrice = "((\\d{1,3})(,\\d{3})|(\\d{1,2}0)+원)";*/
		String extractPrice = "(\\d{1,3})(,\\d{3})";										//가격을 뽑기위한 정규표현식.
		
		Pattern pattern = Pattern.compile(extractPrice);									//가격을 뽑기위해 Pattern클래스 사용.
		Matcher matcher = pattern.matcher(removeKR);											//가격을 뽑기위해 Matcher클래스 사용
		
		List<String> result = new ArrayList<>();
		
		while(matcher.find()){																//위에서 지정한 가격을 뽑는 정규표현식과 매칭되는 것이 있다면?
			System.out.println("가격이 나오는지?: "+matcher.group());								//표현이 매칭되는 문자열을 출력하고,
			result.add(matcher.group());													//list에 추가
		}
		return result;
	}
	
	public static void main(String[] args) {
		/*완료된 목록: 스타일 난다, 임블리, */
		/*String[] path={ "http://66girls.co.kr/product/search.html?banner_action=&keyword=바지",
			  "http://www.stylenanda.com/product/search.html?banner_action=&keyword=바지",
				"http://ggsing.com/product/search.html?banner_action=&keyword=바지",
				"http://loveloveme.com/product/search.html?banner_action=&keyword=바지",
				"http://hotping.co.kr/product/search.html?banner_action=&order_by=favor&keyword=바지",
				"http://www.dejou.co.kr/product/search.html?banner_action=&keyword=바지",
				"http://imvely.com/product/search.html?view_type=&supplier_code=&category_no=&search_type=product_name&keyword=바지"};*/
		PriceTestTread thread = new PriceTestTread("http://66girls.co.kr/product/search.html?banner_action=&keyword=바지");
		thread.start();
		
	}
}
