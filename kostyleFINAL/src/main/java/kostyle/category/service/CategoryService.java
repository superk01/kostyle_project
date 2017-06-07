package kostyle.category.service;

import java.util.List;
import java.util.Map;

import kostyle.category.domain.Adshoppingmall_category;
import kostyle.category.domain.Product_category;

public interface CategoryService {
	public List<Adshoppingmall_category> adsList() throws Exception;
	public List<Product_category> product_Search(String keyword) throws Exception;
	public void product_list_insert(Map<String, Object> map) throws Exception;
}
