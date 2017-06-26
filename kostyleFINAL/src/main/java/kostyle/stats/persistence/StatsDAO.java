package kostyle.stats.persistence;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import kostyle.stats.domain.HitcountStatsChart;
import kostyle.stats.domain.SearchKeywordChart;
import kostyle.stats.domain.SearchKeywordStats;

public interface StatsDAO {
	public void insertSearchKeyword(SearchKeywordStats sks)throws Exception;
	public List<HitcountStatsChart> statsDate_gender(String s_sname, String statsSearchStartDate, String statsSearchEndDate)throws Exception;
	public List<HitcountStatsChart> statsDate_adr(String s_sname, String statsSearchStartDate, String statsSearchEndDate)throws Exception;
	public List<HitcountStatsChart> statsDate_age(String s_sname, String statsSearchStartDate, String statsSearchEndDate)throws Exception;
	public List<SearchKeywordChart> statsSearchRank()throws Exception;
}
