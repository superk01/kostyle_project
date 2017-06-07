package kostyle.category.service;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kostyle.category.domain.Adshoppingmall_category;
import kostyle.category.domain.Product_category;
import kostyle.category.persistence.CategoryDAO;

@Service
public class CategoryServiceImpl implements CategoryService {
	
	@Inject
	private CategoryDAO dao;
	
	@Override
	public List<Adshoppingmall_category> adsList() throws Exception {
		return dao.adsList();
	}

	@Override
	public List<Product_category> product_Search(String keyword) throws Exception {
		return dao.product_Search(keyword);
	}

	@Override
	public void product_list_insert(Map<String, Object> map) throws Exception {
		dao.product_list_insert(map);
	}

}
