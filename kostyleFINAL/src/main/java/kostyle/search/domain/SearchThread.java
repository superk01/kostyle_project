package kostyle.search.domain;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.plaf.synth.SynthSeparatorUI;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.select.Elements;

public class SearchThread extends Thread {
	private String path;
	private List<SearchVO> result;
	
	
	
	public String getPath() {
		return path;
	}



	public void setPath(String path) {
		this.path = path;
	}



	public List<SearchVO> getResult() {
		return result;
	}



	public void setResult(List<SearchVO> result) {
		this.result = result;
	}



	public SearchThread(String path) {
		super();
		this.path = path;
		result = new ArrayList<>();
	}



	@Override
	public void run() {
		List<String> thumbnail = new ArrayList<String>();
		List<String> prdUrl = new ArrayList<String>();
		List<String> prdPrice = new ArrayList<String>();
		List<String> prdName = new ArrayList<String>();
		/*상품 하나를 기준으로 다시 크롤링*/
		//예시는 66걸즈 부터!!!
		try {
			
			System.out.println("path확인:"+path);
			Document doc = Jsoup.connect(path).get();
			/*System.out.println("전체 html:"+doc);*/
			//썸네일 이미지 추출.
			Elements perPageProduct = doc.select(".prdList>li.xans-record-");						// Elements는 list와 같다. 각상품에 맞는 li태그에 접근하여 element형태로 list에 감겨 있음.
			/*System.out.println("perPageProduct의 크기:"+perPageProduct.size());
			System.out.println("가져온 상품의 개수:"+perPageProduct.size());*/
			/*List<Element> listImgEl = new ArrayList<>();*/
			Elements listImgEl = null;
			for(int i=0; i<perPageProduct.size(); i++){
				listImgEl = perPageProduct.get(i).select("div.box a");
			}
			/*System.out.println(listImgEl);*/
			String str = listImgEl.get(0).attr("href");
		/*	System.out.println("썸네일 이미지 주소 하나:"+str);*/
			
			
			//가격추출.
			
			List<String> innerList = new ArrayList<>();											//한 상품의 가격을 저장하는 list
			List<List<String>> outerList = new ArrayList<>();									//각 상품의 가격을 담는 list
			List<String> finalPriceList = new ArrayList<>();									//최종 가격을 담는 list
			
			List<Elements> list= new ArrayList<>();												//엘레먼트를 담을 list
			for(int i=0; i<perPageProduct.size(); i++){
				list.add(perPageProduct.get(i).select("li.xans-record- span"));			//한 상품에 해당하는 태그들(Element) 중에서 ul태그의 클래스명이  "xans-element-"이면서 그 자손태그들 중에 첫 번째 span태그를 가져옴.
				/*System.out.println("list:"+list.get(i));*/
			}
			for(int i=0; i<list.size(); i++){													//위에서 뽑아온 span태그들을 반복문 돌림.
				innerList.add(list.get(i).html());												//span태그의 html값을 받아서 innerList에 저장.
				/*System.out.println("innerList:"+innerList.get(i));*/
			}
			
			
			String reg = "[ㄱ-ㅎ가-힣]";															//한글 삭제를 위한 정규표현식.
			/*String regPrice = "((\\d{1,3})(,\\d{3})|(\\d{1,2}0)+원)";*/
			String regPrice = "(\\d{1,3})(,\\d{3})";											//가격을 뽑기위한 정규표현식.
		
			for(int i=0; i<innerList.size(); i++){
			String regEx=innerList.get(i).replaceAll(reg, "");									//한글을 삭제
		
			Pattern pattern = Pattern.compile(regPrice);										//가격을 뽑기위해 Pattern클래스 사용.
			
			Matcher matcher = pattern.matcher(regEx);											//가격을 뽑기위해 Matcher클래스 사용
			
			List<String> perPriceList = new ArrayList<>();										//각 제품의 가격을 받는 list
			while(matcher.find()){																//위에서 지정한 가격을 뽑는 정규표현식과 매칭되는 것이 있다면?
				System.out.println("가격이 나오는지?: "+matcher.group());								//표현이 매칭되는 문자열을 출력하고,
				perPriceList.add(matcher.group());												//list에 추가
			}
			System.out.println("리스트:"+perPriceList);
			outerList.add(perPriceList);														//각 상품이 담긴 list를 outerList에 추가
			}
			if(path.indexOf("hotping")!=-1){
				for(int i=0; i<outerList.size(); i++){
					int num=outerList.get(i).size();
					outerList.get(i).remove(num-1);
				}
			}
			
			System.out.println("바깥리스트:"+outerList);											//결과를 출력하면?[[18,000], [12,000], [16,900], [18,000], [19,900], [12,000], [16,000], [14,000, 9,800]]
			/*}*/																				//path=http://66girls.co.kr/product/search.html?banner_action=&keyword=바지&page=2
			int num=9999999;
			int num1 = 0;
			for(int i=0; i<outerList.size(); i++){
				System.out.println("각 리스트의 사이즈:"+outerList.get(i).size());
				if(outerList.get(i).size()>1){
					/*for(int j=0; j<outerList.get(i).size(); j++){
						System.out.println("innerfor문 진입.");
						num1 = Integer.parseInt(outerList.get(i).get(j)); 
						System.out.println("num1출력:"+num1);
						if(num>num1){
							num=num1;
							System.out.println("현재 num값 출력:"+num);
						}
					}*/
					finalPriceList.add(outerList.get(i).get(1)+"원");
				
				}else{
					finalPriceList.add(outerList.get(i).get(0)+"원");
				}
				
			}
			System.out.println("최종 가격:"+finalPriceList);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
public static void main(String[] args) {
		/*span:eq(0)*/
			/*String[] path = {"http://66girls.co.kr/product/search.html?banner_action=&keyword=바지", 
				"http://www.stylenanda.com/product/search.html?banner_action=&keyword=바지",
				"http://ggsing.com/product/search.html?banner_action=&keyword=바지",
				"http://loveloveme.com/product/search.html?banner_action=&keyword=바지",
				"http://hotping.co.kr/product/search.html?banner_action=&order_by=favor&keyword=바지",
				"http://www.dejou.co.kr/product/search.html?banner_action=&keyword=바지",
				"http://imvely.com/product/search.html?view_type=&supplier_code=&category_no=&search_type=product_name&keyword=바지" };
			for(int i=0; i<path.length; i++){
				SearchThread thread = new SearchThread(path[i]);
				thread.run();
			}*/
		String path = "http://hotping.co.kr/product/search.html?banner_action=&order_by=favor&keyword=바지";
		/*String path[] = "http://imvely.com/product/search.html?view_type=&supplier_code=&category_no=&search_type=product_name&keyword=바지";*/
		SearchThread thread = new SearchThread(path);
		thread.run();
	}
	
	
}
