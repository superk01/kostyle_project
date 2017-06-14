package kostyle.category.service;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kostyle.category.domain.Adshoppingmall_category;
import kostyle.category.domain.FilterVO;
import kostyle.category.domain.Product_category;
import kostyle.category.persistence.CategoryDAO;

@Service
public class CategoryServiceImpl implements CategoryService {
	
	@Inject
	private CategoryDAO dao;
	//
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

	@Override
	public List<Product_category> product_Filter_color(FilterVO filterVO) throws Exception {
		return dao.product_Filter_color(filterVO);
	}

	@Override
	public List<Product_category> weather_search(int level) throws Exception {
		return dao.weather_search(level);
	}

}
