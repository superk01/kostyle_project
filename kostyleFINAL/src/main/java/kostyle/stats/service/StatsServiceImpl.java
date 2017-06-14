package kostyle.stats.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

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
	
	
	
}
