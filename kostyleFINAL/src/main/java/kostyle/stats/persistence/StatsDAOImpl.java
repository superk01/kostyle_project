package kostyle.stats.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kostyle.stats.domain.HitcountStats;
import kostyle.stats.domain.HitcountStatsChart;
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

	@Override
	public List<HitcountStatsChart> statsDate_gender(String s_sname, String statsSearchStartDate,
			String statsSearchEndDate) throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		
		paramMap.put("s_sname", s_sname);
		paramMap.put("statsSearchStartDate", statsSearchStartDate);
		paramMap.put("statsSearchEndDate", statsSearchEndDate);
		
		return session.selectList(namespace+".statsDate_gender", paramMap);
	}

	@Override
	public List<HitcountStatsChart> statsDate_adr(String s_sname, String statsSearchStartDate,
			String statsSearchEndDate) throws Exception {
		return session.selectList(namespace+"statsDate_adr");
	}
	
	
}
