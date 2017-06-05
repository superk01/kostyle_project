package kostyle.search.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
@Repository
public class SearchDAOImpl implements SearchDAO{
	
	@Inject
	private SqlSession session;

	private static String namespace="kostyle.search.mappers.searchMapper";
	
	@Override
	public List<String> getSearchUrl() {
		return session.selectList(namespace+".getSearchUrl");
	}

}
