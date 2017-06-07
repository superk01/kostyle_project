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
	
	public List<Product_category> CategorySearch_main(String keyword, List<Adshoppingmall_category> adsList, HttpSession session){
		List<MainActionThread> threadList = new ArrayList<MainActionThread>();
		int threadcount = 0;
		
		for(int i = 0; i<adsList.size(); i++){
				String frontURL =  adsList.get(i).getS_searchurl(); 
				String shopurl = adsList.get(i).getS_shopurl();
				frontURL = urlFix(frontURL)+keyword;
				shopurl = urlFix(shopurl);				
										
				threadList.add(new MainActionThread(frontURL,shopurl, keyword));
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
		 Collections.shuffle(product_list);
		 //검색 기록들 저장
		
		 //데이터 세션에 저장			 
		 session.setAttribute("product_list", product_list);
		 //데이터 DB에 저장할거 리턴
		 return product_list;
	}
	
	//url 양쪽공백, 개행 제거
	public String urlFix(String url){
		url = url.replace("\\n", "");
		url = url.replace("\n", "");
		url = url.trim();
		return url;
	}
}
