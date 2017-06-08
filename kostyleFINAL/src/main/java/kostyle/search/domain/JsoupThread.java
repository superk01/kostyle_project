package kostyle.search.domain;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class JsoupThread extends Thread{
	
	private String path;
	private List<SearchVO> result;
	private List<String> nextPages;
	
	
	
	public List<SearchVO> getResult() {
		return result;
	}

	public void setResult(List<SearchVO> result) {
		this.result = result;
	}
	
	public List<String> getNextPages() {
		return nextPages;
	}

	public void setNextPages(List<String> nextPages) {
		this.nextPages = nextPages;
	}

	public JsoupThread() {}
	
	public JsoupThread(String path){
		this.path = path;
		result = new ArrayList<SearchVO>();
		nextPages = new ArrayList<String>();
	}
	
	@Override
	public void run() {
		List<String> thumbnail = new ArrayList<String>();
		List<String> prdUrl = new ArrayList<String>();
		List<String> prdPrice = new ArrayList<String>();
		List<String> prdName = new ArrayList<String>();
		
		try {
			Document doc = Jsoup.connect(path).get();
			/*System.out.println(doc);*/
			/*String path1 = "http://66girls.co.kr/product/search.html?banner_action=&keyword=바지";*/
		/*	http://66girls.co.kr/product/search.html?banner_action=&keyword=바지
		 * http://www.stylenanda.com/product/search.html?banner_action=&keyword=바지
			http://ggsing.com/product/search.html?banner_action=&keyword=바지	
			http://loveloveme.com/product/search.html?banner_action=&keyword=바지
			http://hotping.co.kr/product/search.html?banner_action=&order_by=favor&keyword=바지
			http://www.dejou.co.kr/product/search.html?banner_action=&keyword=바지
			http://imvely.com/product/search.html?view_type=&supplier_code=&category_no=&search_type=product_name&keyword=바지 */
			/*Document doc = Jsoup.connect(path1).get();*/
			
			//썸네일 이미지 추출
			Elements thumbnailEl = doc.select("img.thumb");
			for(int i=0; i<thumbnailEl.size(); i++){
				thumbnail.add(thumbnailEl.get(i).attr("src"));
			}
			System.out.println("썸네일 이미지 검색수:"+thumbnail.size());
			/*System.out.println("thumbnail:"+thumbnail);*/
			/*System.out.println("thumbnail:"+thumbnail.size());*/
			/*System.out.println(doc);*/
			
			//제품명 추출
			Elements prdNameEl = doc.select("p.name span:eq(0)");
			/*System.out.println(prdNameEl);*/
			for(int i=0; i<prdNameEl.size(); i++){
				prdName.add(prdNameEl.get(i).html());
			}
			System.out.println("제품명 검색수:"+prdName.size());
			/*System.out.println("prdName:"+prdName);*/
			/*System.out.println("prdName:"+prdName.size());*/
			
			//제품 링크 추출
			
			int index = 0;
			
			if(path.indexOf(".com/")>0){
				index = path.indexOf(".com/");
			}else{
				index = path.indexOf("o.kr/");
			}
			
			String str = path.substring(0, index+4);
			Elements prdUrlEl = doc.select("div.box a");
			/*System.out.println(prdUrlEl);
			System.out.println(prdUrlEl.size());*/
			List<String> list = new ArrayList<String>();
			/*System.out.println(prdUrlEl.get(2).attr("href"));*/
			for(int i=0; i<prdUrlEl.size(); i++){
				list.add(str+prdUrlEl.get(i).attr("href"));
			}
			prdUrl = new ArrayList<String>(new LinkedHashSet<String>(list));
			
			System.out.println("검색된 상품 url숫자:"+prdUrl.size());
			/*System.out.println("검색된 상품 url내용:"+prdUrl);*/
			for(int i=0; i<prdUrl.size(); i++){
				System.out.println(i+"번째 링크:"+prdUrl.get(i));
			}
			/*for(int i=0; i<prdUrl.size(); i++){
				System.out.println(prdUrl.get(i));
			}*/
			/*System.out.println(prdUrl);*/
			/*System.out.println("prdUrl:"+prdUrl.size());*/
			
			
			
			//제품 가격 추출
			
			
			
			
			Elements prdPriceEl = null;
			int arr[] = null;
			List<String> priceList = new ArrayList<String>();
			if(path.indexOf("stylenanda")>0){
				prdPriceEl = doc.select("p.price");
				for(int i=0; i<prdPriceEl.size(); i++){
					priceList.add(prdPriceEl.get(i).html());
				}
			
				/*System.out.println(list);*/
				for(int i=0; i<priceList.size();i++){
					/*System.out.println("for문"+i+"번째");*/
					arr = new int[priceList.size()];
					arr[i]=priceList.get(i).indexOf("<span");
				/*	System.out.println(arr[i]);
					System.out.println(list.get(i).substring(0,arr[i]));*/
					prdPrice.add(priceList.get(i).substring(0,arr[i])+"원");
				}
			}else if(path.indexOf("imvely")>0){
				prdPriceEl = doc.select("strong.grid");
				for(int i=0; i<prdPriceEl.size(); i++){
					prdPrice.add(prdPriceEl.get(i).html());
				}
			
				
				/*for(int i=0; i<list.size();i++){
					System.out.println("for문"+i+"번째");
					arr = new int[list.size()];
					arr[i]=list.get(i).indexOf("<span");
					System.out.println(arr[i]);
					System.out.println(list.get(i).substring(0,arr[i]));
					prdPrice.add(list.get(i).substring(0,arr[i]));
				}*/
			}else{
				prdPriceEl = doc.select("li.xans-record-:eq(0)>span");
				for(int i=0; i<prdPriceEl.size(); i++){
					/*if(!(prdPriceEl.get(i).html().equals(""))){*/
						prdPrice.add(prdPriceEl.get(i).html());
						System.out.println(i+"번째 가격정보: "+prdPriceEl.get(i).html());
						
					/*}*/
				}
			}
			
			System.out.println("검색된 가격 숫자:"+prdPrice.size());
			/*System.out.println("검색된 가격 정보:"+prdPrice);*/
			for(int i=0; i<prdPrice.size(); i++){
				System.out.println(i+"번째 가격:"+prdPrice.get(i));
			}
			/*System.out.println(prdPrice);*/		
			/*System.out.println("prdPrice:"+prdPrice.size());	*/	
			
			
			for(int i=0; i<prdName.size(); i++){
				result.add(new SearchVO(thumbnail.get(i), prdUrl.get(i), prdPrice.get(i), prdName.get(i)));
				/*System.out.println(thumbnail.get(i)+","+prdUrl.get(i)+","+prdPrice.get(i)+","+prdName.get(i));*/
			}
			/*System.out.println(result);*/
			
			//상품 검색을 두 페이지 이상 검색했을때...
			//일단 예시로 스타일 난다.
			List<String> list31 = new ArrayList<String>();
			Elements nextPageEl = doc.select("div.xans-search-paging a.other");
			System.out.println("선택자 잘 잡았습니까?"+nextPageEl);
			for(int i=0; i<nextPageEl.size(); i++){
				list31.add(nextPageEl.get(i).attr("href"));
			}
			String str1= null;
			String str2= null;
			if(list31 != null){
				/*System.out.println("페이징 잘 뽑힙니까?"+list31);*/
				if(path.indexOf(".com/")>0){
					index = path.indexOf(".com/");
				}else{
					index = path.indexOf("o.kr/");
				}
				
				str1 = path.substring(0, index+4);				//쇼핑몰 url: 예)http://www.stylenanda.com
				System.out.println(str1);
				int index2 = path.indexOf(".html?");
				System.out.println(index2);
				str2 = path.substring(index2-15, index2+5);
				System.out.println("/product/search.html? 이거 맞음???"+str2);
			}
			for(int i=0; i<list31.size(); i++){
				System.out.println("최종 다음 검색 주소:"+str1+str2+list31.get(i));
				nextPages.add(str1+str2+list31.get(i));
			}
			/*System.out.println("최종 다음 검색 주소:"+nextPages);*/
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
	}
	
	//테스트 하는 곳!!!
public static void main(String[] args){
		/*String path = "http://hotping.co.kr/product/search.html?banner_action=&order_by=favor&keyword=바지";*/
		String path = "http://www.stylenanda.com/product/search.html?banner_action=&keyword=바지";
		JsoupThread thread = new JsoupThread(path);
		thread.start();
	}
	
	/*public static void main(String[] args) {
		http://66girls.co.kr/product/search.html?banner_action=&keyword=바지"; 통과
			  http://www.stylenanda.com/product/search.html?banner_action=&keyword=바지 통과
				http://ggsing.com/product/search.html?banner_action=&keyword=바지	
				http://loveloveme.com/product/search.html?banner_action=&keyword=바지
				http://hotping.co.kr/product/search.html?banner_action=&order_by=favor&keyword=바지
				http://www.dejou.co.kr/product/search.html?banner_action=&keyword=바지
				http://imvely.com/product/search.html?view_type=&supplier_code=&category_no=&search_type=product_name&keyword=바지 
		String path = "http://hotping.co.kr/product/search.html?banner_action=&order_by=favor&keyword=바지";
		JsoupThread thread = new JsoupThread(path);
		thread.start();
	}*/
	
}
