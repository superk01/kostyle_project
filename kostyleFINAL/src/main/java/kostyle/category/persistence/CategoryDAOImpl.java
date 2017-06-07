package kostyle.category.persistence;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kostyle.category.domain.Adshoppingmall_category;
import kostyle.category.domain.Product_category;

@Repository
public class CategoryDAOImpl implements CategoryDAO {

	@Inject
	private SqlSession session;
	
	private static String namespace = "kostyle.category.mapper.CategoryMapper";
	
	@Override
	public List<Adshoppingmall_category> adsList() throws Exception {
		return session.selectList(namespace + ".adsList"); 
	}

	@Override
	public List<Product_category> product_Search(String keyword) throws Exception {
		return session.selectList(namespace + ".product_Search", keyword);
	}
	
	@Override
	public void product_list_insert(Map<String, Object> map) throws Exception {
		session.insert(namespace + ".product_list_insert", map);		
	}
}
