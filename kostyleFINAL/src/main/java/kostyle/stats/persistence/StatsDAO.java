package kostyle.stats.persistence;

import kostyle.stats.domain.SearchKeywordStats;

public interface StatsDAO {
	public void insertSearchKeyword(SearchKeywordStats sks)throws Exception;
}
