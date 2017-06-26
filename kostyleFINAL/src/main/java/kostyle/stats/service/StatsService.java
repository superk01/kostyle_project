package kostyle.stats.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import kostyle.stats.domain.CustomerStats;
import kostyle.stats.domain.HitcountStats;
import kostyle.stats.domain.HitcountStatsChart;
import kostyle.stats.domain.SearchKeywordChart;
import kostyle.stats.domain.SearchKeywordStats;

public interface StatsService {
	public void insertSearchKeyword(SearchKeywordStats sks)throws Exception;
	public List<HitcountStatsChart> statsDate(String s_sname, String statsSearchStartDate, String statsSearchEndDate, String chartFor)throws Exception;
	public List<SearchKeywordChart> statsSearchRank()throws Exception;
	public List<SearchKeywordChart> searchRankChart(List<SearchKeywordChart> list)throws Exception;
	public List<CustomerStats> customerSearchKeyAll(String c_num)throws Exception;
	public List<CustomerStats> customerVisitShopAll(String c_num)throws Exception;
	public List<CustomerStats> customerVisitPrdAll(String c_num)throws Exception;
	public List<CustomerStats> getSimilar(String c_num)throws Exception;
}
