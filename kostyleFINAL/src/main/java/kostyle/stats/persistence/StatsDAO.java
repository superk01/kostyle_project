package kostyle.stats.persistence;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import kostyle.stats.domain.CustomerStats;
import kostyle.stats.domain.HitcountStatsChart;
import kostyle.stats.domain.SearchKeywordChart;
import kostyle.stats.domain.SearchKeywordStats;

public interface StatsDAO {
	public void insertSearchKeyword(SearchKeywordStats sks)throws Exception;
	public List<HitcountStatsChart> statsDate_gender(String s_sname, String statsSearchStartDate, String statsSearchEndDate)throws Exception;
	public List<HitcountStatsChart> statsDate_adr(String s_sname, String statsSearchStartDate, String statsSearchEndDate)throws Exception;
	public List<HitcountStatsChart> statsDate_age(String s_sname, String statsSearchStartDate, String statsSearchEndDate)throws Exception;
	public List<SearchKeywordChart> statsSearchRank()throws Exception;
	public List<SearchKeywordChart> searchRankChart(String sk1, String sk2, String sk3, String sk4, String sk5, String sk6, String sk7, String sk8)throws Exception;
	public List<SearchKeywordChart> searchRankTeen()throws Exception;
	public List<SearchKeywordChart> searchRankTwenty()throws Exception;
	public List<SearchKeywordChart> searchRankThirty()throws Exception;
	public List<CustomerStats> customerSearchKeyAll(String c_num)throws Exception;
	public List<CustomerStats> customerVisitShopAll(String c_num)throws Exception;
	public List<CustomerStats> customerVisitPrdAll(String c_num)throws Exception;
	public List<SearchKeywordChart> todayShop()throws Exception;
	public List<CustomerStats> getSimilar(String cnt_prdurl)throws Exception;
}
