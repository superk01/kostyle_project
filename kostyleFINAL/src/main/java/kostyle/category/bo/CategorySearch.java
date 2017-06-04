package kostyle.category.bo;

import java.lang.Thread.State;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpSession;

import kostyle.category.domain.Adshoppingmall_category;
import kostyle.category.domain.Product_category;
import kostyle.category.domain.Product_list;

public class CategorySearch {
	private List<Product_category> product_list = new ArrayList<Product_category>();
	private List<Product_list> product_list_total = new ArrayList<Product_list>();
	private Map<String, Object> product_list_map = new HashMap<String, Object>();
	
	
	public void CategorySearch_start2(String keyword, List<Adshoppingmall_category> adsList, HttpSession session){
		if(search_StartCheck(keyword, session)){
			CategorySearch_main(keyword, adsList, session);
		}
	}
	
	//사용자가 검색했던 기록을 본다 만약 검색하는 키워드가 검색했던 기록에 남아있으면 다시 크롤링 할 필요없이 바로 데이터 가져온다
	public boolean search_StartCheck(String keyword, HttpSession session){
		if( session.getAttribute("product_list") != null){
			session.removeAttribute("product_list");
		}
		
		if( session.getAttribute("product_list_map") != null){
			product_list_map = (Map<String, Object>)session.getAttribute("product_list_map");
			// product_list_map 라는 검색 기록에서 검색했던 내용이 있는지 검사한다 있으면 바로 검색된내용을 찾아준다
			for( String key : product_list_map.keySet() ){
				if(keyword.equals(key)){	
					session.setAttribute("product_list",product_list_map.get(keyword));
					return false;
				}
			}
		}		
		return true;
	}
	
	
	public void CategorySearch_main(String keyword, List<Adshoppingmall_category> adsList, HttpSession session){
		List<MainActionThread> threadList = new ArrayList<MainActionThread>();
		int threadcount = 0;
		
		for(int i = 0; i<adsList.size(); i++){
				String frontURL =  adsList.get(i).getS_searchurl(); 
				String shopurl = adsList.get(i).getS_shopurl();
				frontURL = urlFix(frontURL)+keyword;
				shopurl = urlFix(shopurl);				
										
				threadList.add(new MainActionThread(frontURL,shopurl));
				threadList.get(threadcount).start();	
				threadcount ++;
		}
	
		while(  threadList.size() != 0){
			for(int i=0; i<threadList.size(); i++){
				if(threadList.get(i).getState() == State.TERMINATED){
					System.out.println(i + " 번째 쇼핑몰 완료 ThreadList 삭제");
					product_list_total.add(new Product_list(threadList.get(i).getMain_product_list()));
					threadList.remove(i);
				}
			}
		}		
		 for(int z=0; z<product_list_total.size(); z++){
			 for(int x=0; x<product_list_total.get(z).getList().size(); x++){
				 product_list.add(product_list_total.get(z).getList().get(x));
			 }
		 }
		 //옷 재정렬		 
		 System.out.println("카테고리 검색 결과 재정렬");
		 Collections.shuffle(product_list);
		 //검색 기록들 저장
		 product_list_map.put(keyword, product_list);
		 //데이터 세션에 저장			 
		 session.setAttribute("product_list", product_list);
		 session.setAttribute("product_list_size", product_list.size());
		 session.setAttribute("product_list_map", product_list_map);
		 //리턴
	}
	
	//url 양쪽공백, 개행 제거
	public String urlFix(String url){
		url = url.replace("\\n", "");
		url = url.replace("\n", "");
		url = url.trim();
		return url;
	}
}
