package kostyle.category.persistence;

import java.util.List;
import java.util.Map;

import kostyle.category.domain.Adshoppingmall_category;
import kostyle.category.domain.FilterVO;
import kostyle.category.domain.Product_category;

public interface CategoryDAO {
	public List<Adshoppingmall_category> adsList() throws Exception;
	public List<Product_category> product_Search(String keyword) throws Exception;
	public void product_list_insert(Map<String, Object> map) throws Exception;
	public List<Product_category> product_Filter_color(FilterVO filterVO) throws Exception;
}
