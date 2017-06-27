package kostyle.stats.service;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kostyle.stats.domain.CustomerStats;
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

	@Override
	public List<SearchKeywordChart> searchRankChart(List<SearchKeywordChart> list) throws Exception {
		
		String sk1 = list.get(0).getSk_searchkey();
		String sk2 = list.get(1).getSk_searchkey();
		String sk3 = list.get(2).getSk_searchkey();
		String sk4 = list.get(3).getSk_searchkey();
		String sk5 = list.get(4).getSk_searchkey();
		String sk6 = list.get(5).getSk_searchkey();
		String sk7 = list.get(6).getSk_searchkey();
		String sk8 = list.get(7).getSk_searchkey();
		
		return dao.searchRankChart(sk1, sk2, sk3, sk4, sk5, sk6, sk7, sk8);
	}

	@Override
	public List<CustomerStats> customerSearchKeyAll(String c_num) throws Exception {
		return dao.customerSearchKeyAll(c_num);
	}

	@Override
	public List<CustomerStats> customerVisitShopAll(String c_num) throws Exception {
		return dao.customerVisitShopAll(c_num);
	}

	@Override
	public List<CustomerStats> customerVisitPrdAll(String c_num) throws Exception {
		return dao.customerVisitPrdAll(c_num);
	}

	@Override
	public List<CustomerStats> getSimilar(String c_num) throws Exception {
		
		List<CustomerStats> prdlist = dao.customerVisitPrdAll(c_num);
		List<CustomerStats> similarCustomerList = new ArrayList<CustomerStats>();
		List<String> prdurlList = new ArrayList<String>();
		
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		for(int i=0;i<prdlist.size();i++){
			prdurlList.add(prdlist.get(i).getH_prdurl());
		}
		
		for(int i=0;i<prdurlList.size();i++){
			similarCustomerList = dao.getSimilar(prdurlList.get(i));
		}
		
		System.out.println("c_num list");
		for(int i=0;i<similarCustomerList.size();i++){
			System.out.println(similarCustomerList.get(i).getC_num());
		}
		
		
		return null;
	}

	

	
}
