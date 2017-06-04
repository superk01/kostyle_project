package kostyle.category.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kostyle.category.domain.Adshoppingmall_category;
import kostyle.category.persistence.CategoryDAO;

@Service
public class CategoryServiceImpl implements CategoryService {
	
	@Inject
	private CategoryDAO dao;
	
	@Override
	public List<Adshoppingmall_category> adsList() throws Exception {
		return dao.adsList();
	}

}
