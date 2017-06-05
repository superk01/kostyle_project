package kostyle.search.service;

import java.util.List;

import kostyle.search.domain.SearchVO;

public interface SearchService {
	public List<String> getSearchUrl();
	
	public List<SearchVO> doSearch(String keyword);
}
