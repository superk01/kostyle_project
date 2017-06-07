package kostyle.category.bo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.servlet.http.HttpSession;

import org.eclipse.core.internal.runtime.Product;

import kostyle.category.domain.Product_category;

public class CategoryFilter{
	//세션셋팅
	private void setSession(HttpSession session, List<Product_category> product_list){
		session.removeAttribute("product_list");
		session.setAttribute("product_list", product_list);		
	}
	
	public void setCategoryResult(List<Product_category> product_list, HttpSession session, String filter){		
		
		List<Product_category> list2 = (List<Product_category>) session.getAttribute("product_list");
		
		if(filter.equals("random")){
			Collections.shuffle(product_list);
			setSession(session,product_list);
		}else if(filter.equals("maxprice")){
			Product_compare pcomp = new Product_compare();
			Collections.sort(product_list,pcomp);
			setSession(session,product_list);
		}else if(filter.equals("minprice")){
			Product_compare_min pcomp_min = new Product_compare_min();
			Collections.sort(product_list,pcomp_min);
			setSession(session,product_list);
		}else if(filter.indexOf("color") != -1){
			String color = "화이트";
			for(int i=0; i<product_list.size(); i++){			
				if(product_list.get(i).getProduct_color().indexOf(color) == -1){
					product_list.remove(i);
				}
			}			//
			setSession(session, product_list);
		}else if(filter.equals("default")){
			
			
		}
	}
}
