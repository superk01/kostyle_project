package kostyle.stats.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kostyle.stats.domain.HitcountStats;
import kostyle.stats.domain.HitcountStatsChart;
import kostyle.stats.domain.SearchKeywordChart;
import kostyle.stats.domain.SearchKeywordStats;
import kostyle.stats.persistence.StatsDAO;

@Service
public class StatsServiceImpl implements StatsService{
	
	@Inject
	public StatsDAO dao;

	@Override
	public void insertSearchKeyword(SearchKeywordStats sks) throws Exception {
		dao.insertSearchKeyword(sks);
	}

	@Override
	public List<HitcountStatsChart> statsDate(String s_sname, String statsSearchStartDate, String statsSearchEndDate, String chartFor)
			throws Exception {
		
		List<HitcountStatsChart> list = null;
		if(chartFor.equals("gender")){
			list = dao.statsDate_gender(s_sname, statsSearchStartDate, statsSearchEndDate);
		}else if(chartFor.equals("adr")){
			list = dao.statsDate_adr(s_sname, statsSearchStartDate, statsSearchEndDate);
		}else if(chartFor.equals("age")){
			list = dao.statsDate_age(s_sname, statsSearchStartDate, statsSearchEndDate);
		}
		
		return list;
	}

	@Override
	public List<SearchKeywordChart> statsSearchRank()throws Exception {
		return dao.statsSearchRank();
	}
	

	
}
