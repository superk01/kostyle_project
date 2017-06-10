package kostyle.search.domain;

import java.io.IOException;
import java.lang.Thread.State;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class JsoupThread extends Thread{
	
	private String path;
	private List<SearchVO> result;
	/*private List<String> nextPages;*/
	private List<GetColorThread> getColorListThread;
	private String keyword;
	private String shopURL;
	
	
	
	public List<GetColorThread> getGetColorListThread() {
		return getColorListThread;
	}

	public void setGetColorListThread(List<GetColorThread> getColorListThread) {
		this.getColorListThread = getColorListThread;
	}

	public List<SearchVO> getResult() {
		return result;
	}

	public void setResult(List<SearchVO> result) {
		this.result = result;
	}
	
/*	public List<String> getNextPages() {
		return nextPages;
	}

	public void setNextPages(List<String> nextPages) {
		this.nextPages = nextPages;
	}*/

	public JsoupThread() {}
	
	public JsoupThread(String path, String keyword){
		this.path = path;
		this.keyword = keyword;
		result = new ArrayList<SearchVO>();
		getColorListThread = new ArrayList<>();
		/*nextPages = new ArrayList<String>();*/
	}
	
	@Override
	public void run() {
		List<String> thumbnail = new ArrayList<String>();
		List<String> prdUrl = new ArrayList<String>();
		List<String> prdPrice = new ArrayList<String>();
		List<String> prdName = new ArrayList<String>();
		
		
		try {
			
			Document doc = Jsoup.connect(path+keyword).get();
			
			//썸네일 이미지 추출
			Elements thumbnailEl = doc.select("img.thumb");
			for(int i=0; i<thumbnailEl.size(); i++){
				thumbnail.add(thumbnailEl.get(i).attr("src"));
			}
			System.out.println("썸네일 이미지 주소:"+thumbnail);
			
			//제품명 추출
			Elements prdNameEl = doc.select("p.name span:eq(0)");
			String prePrdName = "";
			for(int i=0; i<prdNameEl.size(); i++){
				prePrdName=prdNameEl.get(i).html();
				/*System.out.println("이전 prePrdName:"+prePrdName);*/
				
				if(prePrdName.indexOf("<") != -1){
					/*System.out.println("if문 진입");*/
					int index=prePrdName.indexOf("<");
					String postPrdName=prePrdName.substring(0, index);
					/*System.out.println("이후 prePrdName:"+postPrdName);*/
					prdName.add(postPrdName);
					
				}else if(prePrdName.indexOf("(") != -1){
					/*System.out.println("else if문 진입");*/
					int index=prePrdName.indexOf("(");
					String postPrdName=prePrdName.substring(0, index);
					System.out.println("이후 prePrdName:"+postPrdName);
					prdName.add(postPrdName);
				}else{
					prdName.add(prePrdName);
				}
			}
			
			/*System.out.println("잡스러운거 날리고 다시 제품명 출력:"+prdName);
			System.out.println("제품명 추출 완료");*/
			
			//제품 링크 추출
			int index = 0;
			
			if(path.indexOf(".com/")>0){
				index = path.indexOf(".com/");
			}else{
				index = path.indexOf("o.kr/");
			}
			
			shopURL=path.substring(7, index+5);
			Elements prdUrlEl = doc.select("div.box a");
			
			List<String> list = new ArrayList<String>();
		
			for(int i=0; i<prdUrlEl.size(); i++){
				list.add(shopURL+prdUrlEl.get(i).attr("href"));
			}
			prdUrl = new ArrayList<String>(new LinkedHashSet<String>(list));
					
			//제품 가격 추출
			List<List<String>> outerList = new ArrayList<>();									//각 상품의 가격을 담는 list
			List<String> finalPriceList = new ArrayList<>();
			Elements prdPriceEl = null;
			
			prdPriceEl = doc.select("ul.prdList li.item");
			List<String> shoppingmallStrList = new ArrayList<String>();
			
			for(int i=0; i<prdPriceEl.size(); i++){
				shoppingmallStrList.add(prdPriceEl.get(i).html());
			}
			/*System.out.println("priceListResult:"+shoppingmallStrList);*/
			
			for(int i=0; i<shoppingmallStrList.size(); i++){
				outerList.add(getPrice(shoppingmallStrList.get(i)));
			}
			
			for(int i=0; i<outerList.size(); i++){
				int num=outerList.get(i).size();
				outerList.get(i).remove(num-1);
				if(outerList.size()>3){
					outerList.get(i).remove(0);
				}
			}
			
			
			/*System.out.println("바깥리스트:"+outerList);*/											//결과를 출력하면?[[18,000], [12,000], [16,900], [18,000], [19,900], [12,000], [16,000], [14,000, 9,800]]
																								//path=http://66girls.co.kr/product/search.html?banner_action=&keyword=바지&page=2
		
			for(int i=0; i<outerList.size(); i++){
				/*System.out.println("각 리스트의 사이즈:"+outerList.get(i).size());*/
				if(outerList.get(i).size()>1){
					finalPriceList.add(outerList.get(i).get(1)+"원");
				}else{
					finalPriceList.add(outerList.get(i).get(0)+"원");
				}
			}
			/*System.out.println("최종 가격:"+finalPriceList);*/
			
			//색상 추출 하기
			
			List<String> colorList = new ArrayList<>();
			
			for(int i=0; i<prdUrl.size(); i++){
				getColorListThread.add(new GetColorThread("http://"+prdUrl.get(i)));
				getColorListThread.get(i).start();
			}
			while(getColorListThread.size() !=0){
				for(int i=0; i<getColorListThread.size(); i++){
					if(getColorListThread.get(i).getState()==State.TERMINATED){
						colorList.add(getColorListThread.get(i).getColorList());
						getColorListThread.remove(i);
						break;
					}
				}
			}
			for(int i=0; i<prdName.size(); i++){
				/*생성자 4개*/
				/*System.out.println(i+"번째 결과 출력:"+thumbnail.get(i)+","+prdUrl.get(i)+","+prdPrice.get(i)+","+prdName.get(i));*/
				/*result.add(new SearchVO(thumbnail.get(i), prdUrl.get(i), prdPrice.get(i), prdName.get(i)));*/
				
				/*생성자 5개*/
				/*System.out.println(thumbnail.get(i)+","+prdUrl.get(i)+","+prdPrice.get(i)+","+prdName.get(i)+","+colorList.get(i));*/
				/*result.add(new SearchVO(thumbnail.get(i), prdUrl.get(i), finalPriceList.get(i), prdName.get(i), colorList.get(i)));*/
				result.add(new SearchVO(prdName.get(i), finalPriceList.get(i), thumbnail.get(i), shopURL, colorList.get(i), prdUrl.get(i), keyword));
			}
			/*System.out.println("최종 결과 리스트:"+result);*/
			/*System.out.println(result);*/
			
			//상품 검색을 두 페이지 이상 검색했을때...
			//일단 예시로 스타일 난다.
		/*	if(result.size()!=0){
			List<String> list31 = new ArrayList<String>();
			Elements nextPageEl = doc.select("div.xans-search-paging a.other");
			System.out.println("선택자 확인:"+nextPageEl);
			for(int i=0; i<nextPageEl.size(); i++){
				list31.add(nextPageEl.get(i).attr("href"));
			}
			String str1= null;
			String str2= null;
			if(list31 != null){
				System.out.println("페이징 잘 뽑힙니까?"+list31);
				if(path.indexOf(".com/")>0){
					index = path.indexOf(".com/");
				}else{
					index = path.indexOf("o.kr/");
				}
				
				str1 = path.substring(0, index+4);				//쇼핑몰 url: 예)http://www.stylenanda.com
				System.out.println(str1);
				int index1 = path.indexOf(".html?");			//	
				System.out.println(index1);
				str2 = path.substring(0, index1+5);
				System.out.println("/product/search.html? 이거 맞음???"+str2);
				int index2= list31.get(0).indexOf("word=");
				int index3= list31.get(0).indexOf("&page=");
				String forDeleteKeyword = list31.get(0).substring(index2+5, index3+1);
				System.out.println("forDeleteKeyword:"+forDeleteKeyword);
				String str11 = list31.get(0).replaceAll(forDeleteKeyword,""); 
				String str12 = list31.get(0).substring(0, index2+4);
				
				for(int i=0; i<list31.size(); i++){
					nextPages.add(str2+str12+"=바지&page="+(i+2));}
			}
			}*/
			
			
			/*---------------------------------------------------------------------------*/
			/*for(int i=0; i<list31.size(); i++){
				System.out.println("최종 다음 검색 주소:"+str1+str2+list31.get(i));
				nextPages.add(str1+str2+list31.get(i));
			}*/
			/*System.out.println("최종 다음 검색 주소:"+nextPages);*/
			
		} catch (Exception e) {
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
	
	//테스트 하는 곳!!!
public static void main(String[] args){
		/*String[] path = {"http://hotping.co.kr/product/search.html?banner_action=&order_by=favor&keyword=바지",
						"http://loveloveme.com/product/search.html?banner_action=&keyword=바지",
						"http://www.dejou.co.kr/product/search.html?banner_action=&keyword=바지"};
		String path = "http://66girls.co.kr/product/search.html?view_type=&supplier_code=&category_no=306&keyword=&product_price1=&product_price2=&order_by=&x=108&y=22";
		String path = "http://66girls.co.kr/product/search.html?banner_abction=&keyword=바지&";
		String path = "http://imvely.com/product/list.html?cate_no=72";*/
		JsoupThread thread = new JsoupThread("http://hotping.co.kr/product/search.html?banner_action=&order_by=favor&keyword=","바지");
		thread.start();
	}
	
	/*public static void main(String[] args) {
		String[] path={ "http://66girls.co.kr/product/search.html?banner_action=&keyword=바지",
			  "http://www.stylenanda.com/product/search.html?banner_action=&keyword=바지",
				"http://ggsing.com/product/search.html?banner_action=&keyword=바지",
				"http://loveloveme.com/product/search.html?banner_action=&keyword=바지",
				"http://hotping.co.kr/product/search.html?banner_action=&order_by=favor&keyword=바지",
				"http://www.dejou.co.kr/product/search.html?banner_action=&keyword=바지",
				"http://imvely.com/product/search.html?view_type=&supplier_code=&category_no=&search_type=product_name&keyword=바지 "};
		List<JsoupThread> threadList = new ArrayList<>();
		for(int i=0; i<path.length; i++){
		threadList.add(new JsoupThread(path[i]));
		threadList.get(i).start();
		}
	}*/
		/*public static void main(String[] args) {
		List<List<SearchVO>> resultList = new ArrayList<>();
		while(threadList.size() !=0){
			for(int i=0; i<threadList.size(); i++){
				System.out.println(threadList.get(i).getState());
				if(threadList.get(i).getState()==State.TERMINATED){
					System.out.println("333333어디서 에러남3333333?");
					System.out.println("색상 추출하는 "+i+"번째 스레드 종료!!!");
					resultList.add(threadList.get(i).getResult());
					System.out.println("4444444어디서 에러남4444444?");
					threadList.remove(i);
					break;
				}
			}
			
		}
		System.out.println("최종값:"+resultList);
	}*/


}
