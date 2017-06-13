package kostyle.search.persistence;

import java.util.List;

import kostyle.search.domain.SearchVO;

public interface SearchDAO {
	public List<String> getSearchUrl();
	
	public List<SearchVO> searchProduct(String keyword);
	
	public void insertproduct(SearchVO searchVO);
}
