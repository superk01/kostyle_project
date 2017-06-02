package kostyle.category.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kostyle.category.domain.Adshoppingmall_category;

@Repository
public class CategoryDAOImpl implements CategoryDAO {

	@Inject
	private SqlSession session;
	
	private static String namespace = "kostyle.category.mapper.CategoryMapper";
	
	@Override
	public List<Adshoppingmall_category> adsList() throws Exception {
		return session.selectList(namespace + ".adsList"); 
	}

}
