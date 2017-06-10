package kostyle.discount.service;

import java.util.List;

import kostyle.discount.domain.DiscountVO;
import kostyle.search.domain.SearchVO;

public interface DiscountService {
	/*	public List<String> getSearchUrl();
	
	public List<SearchVO> doSearch(String keyword);*/
	
	public List<String> getNewSaleUrlList();
	public List<String> getDiscountUrlList();
	
	public List<DiscountVO> discountUrlCrolling();
	public List<DiscountVO> newSaleUrlCrolling();
	
	public String urlFix(String url);
	
	
	
	
}//interface
