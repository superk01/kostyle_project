package category;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kostyle.category.domain.Product_category;
import kostyle.category.persistence.CategoryDAO;


//root-context.xml과 servlet-context.xml을 다 가져와야 그 안의 내용을 사용가능하다.
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class sungho {

	@Inject
	private CategoryDAO dao;
	
	private static Logger logger = LoggerFactory.getLogger(sungho.class);
	/*
	@Test
	public void testCusLogin() throws Exception {
		List<Product_category> product_list = new ArrayList<Product_category>();
		for(int i=0; i<1000; i++){
			String st = "" + i;
			product_list.add(new Product_category(st, st, st, st, st));
		}
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", product_list);
		dao.product_list_insert(map);
	}
	*/
	@Test
	public void stst(){
		try {
			List<Product_category> list = dao.product_Search("검");
			System.out.println(list.size());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
