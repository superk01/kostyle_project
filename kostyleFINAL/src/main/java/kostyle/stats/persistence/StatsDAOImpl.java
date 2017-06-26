package kostyle.stats.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kostyle.stats.domain.CustomerStats;
import kostyle.stats.domain.HitcountStats;
import kostyle.stats.domain.HitcountStatsChart;
import kostyle.stats.domain.SearchKeywordChart;
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
		Map<String, Object> paramMap = new HashMap<String, Object>();
		
		paramMap.put("s_sname", s_sname);
		paramMap.put("statsSearchStartDate", statsSearchStartDate);
		paramMap.put("statsSearchEndDate", statsSearchEndDate);
		
		return session.selectList(namespace+".statsDate_adr", paramMap);
	}

	@Override
	public List<HitcountStatsChart> statsDate_age(String s_sname, String statsSearchStartDate,
			String statsSearchEndDate) throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		
		paramMap.put("s_sname", s_sname);
		paramMap.put("statsSearchStartDate", statsSearchStartDate);
		paramMap.put("statsSearchEndDate", statsSearchEndDate);
		
		return session.selectList(namespace+".statsDate_age", paramMap);
	}

	@Override
	public List<SearchKeywordChart> statsSearchRank() throws Exception{
		return session.selectList(namespace+".getSearchRank", new RowBounds(1, 5));
	}

	@Override
	public List<CustomerStats> customerSearchKeyAll(String c_num) throws Exception {
		RowBounds rowbounds = new RowBounds(0, 5);
		return session.selectList(namespace+".customerSearchKeyAll", c_num, rowbounds);
	}

	@Override
	public List<CustomerStats> customerVisitShopAll(String c_num) throws Exception {
		RowBounds rowbounds = new RowBounds(0, 5);
		return session.selectList(namespace+".customerVisitShopAll", c_num, rowbounds);
	}

	@Override
	public List<CustomerStats> customerVisitPrdAll(String c_num) throws Exception {
		RowBounds rowbounds = new RowBounds(0, 5);
		return session.selectList(namespace+".customerVisitPrdAll", c_num, rowbounds);
	}

	@Override
	public List<CustomerStats> getSimilar(String cnt_prdurl) throws Exception {
		RowBounds rowbounds = new RowBounds(0, 5);
		return session.selectList(namespace+".getSimilar", cnt_prdurl, rowbounds);
	}
	
	
}
