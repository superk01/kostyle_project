package kostyle.stats.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kostyle.stats.domain.SearchKeywordStats;

@Repository
public class StatsDAOImpl implements StatsDAO{

	@Inject
	private SqlSession session;
	
	private static String namespace = "kostyle.stats.mappers.statsMapper";

	@Override
	public void insertSearchKeyword(SearchKeywordStats sks) throws Exception {
		session.insert(namespace+".insertSearchKeyword", sks);
	}
	
	
}
