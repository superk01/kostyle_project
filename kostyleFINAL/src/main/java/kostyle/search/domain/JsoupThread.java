package kostyle.search.domain;

import java.io.IOException;
import java.lang.Thread.State;
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
	/*private List<String> nextPages;*/
	private List<GetColorThread> getColorListThread;
	
	
	
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
	
	public JsoupThread(String path){
		this.path = path;
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
			/*System.out.println("thread안에 path:"+path);*/
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
			/*System.out.println("썸네일 이미지 검색수:"+thumbnail.size());*/
			/*System.out.println("thumbnail:"+thumbnail);*/
			/*System.out.println("thumbnail:"+thumbnail.size());*/
			/*System.out.println(doc);*/
			System.out.println("썸네일 이미지 추출 완료");
			//제품명 추출
			Elements prdNameEl = doc.select("p.name span:eq(0)");
			/*System.out.println(prdNameEl);*/
			String prePrdName = "";
			for(int i=0; i<prdNameEl.size(); i++){
				prePrdName=prdNameEl.get(i).html();
				int index=0;
				if(prePrdName.indexOf("<br>") != -1){
					index=prdName.get(i).indexOf("<br>");
					System.out.println("이전 prePrdName:"+prePrdName);
					prePrdName=prePrdName.substring(index, prePrdName.length());
					System.out.println("이후 prePrdName:"+prePrdName);
					prdName.add(prePrdName);
					
				}else if(prePrdName.indexOf("(") != -1){
					System.out.println("이전 prePrdName:"+prePrdName);
					index=prdName.get(i).indexOf("(");
					prePrdName=prePrdName.substring(index, prePrdName.length());
					System.out.println("이후 prePrdName:"+prePrdName);
					prdName.add(prePrdName);
				}else{
					prdName.add(prePrdName);
				}
			}
			/*System.out.println("제품명:"+prdName);*/
			
			System.out.println("잡스러운거 날리고 다시 제품명 출력:"+prdName);
			System.out.println("제품명 추출 완료");
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
			
			/*System.out.println("검색된 상품 url숫자:"+prdUrl.size());*/
			/*System.out.println("검색된 상품 url내용:"+prdUrl);*/
			/*for(int i=0; i<prdUrl.size(); i++){
				System.out.println(i+"번째 링크:"+prdUrl.get(i));
			}*/
			/*for(int i=0; i<prdUrl.size(); i++){
				System.out.println(prdUrl.get(i));
			}*/
			/*System.out.println(prdUrl);*/
			/*System.out.println("prdUrl:"+prdUrl.size());*/
			
			
			//색상추출.
			/*List<GetColorThread> getColorThread = new ArrayList<>();
			List<String> colorList = new ArrayList<>();
			String colorResult="";
			List<String> colorResult1= new ArrayList<>();
			for(int i=0; i<prdUrl.size(); i++){
				getColorThread.add(new GetColorThread(prdUrl.get(i)));
				getColorThread.get(i).run();
			}
			int count=0;
				for(int i=0; i<prdUrl.size(); i++){
					while(count<prdUrl.size()){
					System.out.println("********"+i+"번째 스레드 실행중.");
					if(getColorThread.get(i).getState()==State.TERMINATED){
						System.out.println("******"+i+"번째 스레드 종료*********");
						colorList=getColorThread.get(i).getColorList();
						for(int j=0; j<colorList.size(); j++){						//반환값안에 상품객체들이 여러개 있는데...
							colorResult+=colorList.get(j);							//각 객체들을 다른 리스트안에 순차적으로 넣음.
						}
						colorResult1.add(colorResult);
						colorResult="";
					}
					
					getColorThread.get(i).interrupt();									//스레드 종료....
					getColorThread.remove(i);
					count++;													//count변수 1증가
					break;
				}

			}
*/			
			//제품의 색상 추출
			
			
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
				prdPriceEl = doc.select("ul.xans-element- span");
				/*System.out.println("prdPriceEl:"+prdPriceEl);*/
				for(int i=0; i<prdPriceEl.size(); i++){
					if(!(prdPriceEl.get(i).html().equals(""))){
						prdPrice.add(prdPriceEl.get(i).html());
						/*System.out.println(i+"번째 가격정보: "+prdPriceEl.get(i).html());*/
						
					}
				}
			}
			
			//색상 추출 하기
			
			List<String> colorList = new ArrayList<>();
			
			for(int i=0; i<prdUrl.size(); i++){
				getColorListThread.add(new GetColorThread(prdUrl.get(i)));
				/*System.out.println("색상 추출하는 "+i+"번째 스레드 시작!!!");*/
				getColorListThread.get(i).start();
			}
			while(getColorListThread.size() !=0){
				for(int i=0; i<getColorListThread.size(); i++){
					/*System.out.println(getColorListThread.get(i).getState());*/
					if(getColorListThread.get(i).getState()==State.TERMINATED){
						/*System.out.println("333333어디서 에러남3333333?");
						System.out.println("색상 추출하는 "+i+"번째 스레드 종료!!!");*/
						colorList.add(getColorListThread.get(i).getColorList());
						/*System.out.println("4444444어디서 에러남4444444?");*/
						getColorListThread.remove(i);
						break;
					}
					
					
				}
			}
			/*System.out.println("색상 추출 잘 됐나 확인:"+getColorListThread);*/
			
			
			/*System.out.println("검색된 가격 숫자:"+prdPrice.size());*/
			
			/*System.out.println("검색된 가격 정보:"+prdPrice);*/
			
			/*for(int i=0; i<prdPrice.size(); i++){
				System.out.println(i+"번째 가격:"+prdPrice.get(i));
			}*/
			
			/*System.out.println(prdPrice);*/		
			/*System.out.println("prdPrice:"+prdPrice.size());	*/	
			
			
			for(int i=0; i<prdName.size(); i++){
				/*생성자 4개*/
				/*System.out.println(i+"번째 결과 출력:"+thumbnail.get(i)+","+prdUrl.get(i)+","+prdPrice.get(i)+","+prdName.get(i));*/
				/*result.add(new SearchVO(thumbnail.get(i), prdUrl.get(i), prdPrice.get(i), prdName.get(i)));*/
				
				/*생성자 5개*/
				/*System.out.println(thumbnail.get(i)+","+prdUrl.get(i)+","+prdPrice.get(i)+","+prdName.get(i)+","+colorList.get(i));*/
				result.add(new SearchVO(thumbnail.get(i), prdUrl.get(i), prdPrice.get(i), prdName.get(i), colorList.get(i)));
			}
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
	
	//테스트 하는 곳!!!
/*public static void main(String[] args){
		String path = "http://hotping.co.kr/product/search.html?banner_action=&order_by=favor&keyword=바지";
		String path = "http://66girls.co.kr/product/search.html?view_type=&supplier_code=&category_no=306&keyword=&product_price1=&product_price2=&order_by=&x=108&y=22";
		String path = "http://66girls.co.kr/product/search.html?banner_action=&keyword=바지&page=2";
		JsoupThread thread = new JsoupThread(path);
		thread.start();
	}*/
	
	/*public static void main(String[] args) {
		String[] path={ "http://66girls.co.kr/product/search.html?banner_action=&keyword=바지",
			  "http://www.stylenanda.com/product/search.html?banner_action=&keyword=바지",
				"http://ggsing.com/product/search.html?banner_action=&keyword=바지",
				"http://loveloveme.com/product/search.html?banner_action=&keyword=바지",
				"http://hotping.co.kr/product/search.html?banner_action=&order_by=favor&keyword=바지",
				"http://www.dejou.co.kr/product/search.html?banner_action=&keyword=바지",
				"http://imvely.com/product/search.html?view_type=&supplier_code=&category_no=&search_type=product_name&keyword=바지 "};
		String path = "http://hotping.co.kr/product/search.html?banner_action=&order_by=favor&keyword=바지";
		List<JsoupThread> threadList = new ArrayList<>();
		for(int i=0; i<path.length; i++){
		threadList.add(new JsoupThread(path[i]));
		threadList.get(i).start();
		}
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
