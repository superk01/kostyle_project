package kostyle.admin.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kostyle.admin.domain.ShoppingMall;
import kostyle.admin.persistence.ShopAdminDAO;

@Service
public class ShopAdminServiceImpl implements ShopAdminService{

	@Inject
	public ShopAdminDAO dao;
	
	@Override
	public void insertShoppingMall(ShoppingMall shop) throws Exception {
		dao.insertShoppingMall(shop);
	}

	@Override
	public int countShoppingMall() throws Exception {
		return dao.countShoppingMall();
	}

	@Override
	public List<ShoppingMall> shopList() throws Exception {
		return dao.shopList();
	}

	@Override
	public ShoppingMall shopDetail(String s_num) throws Exception {
		return dao.shopDetail(s_num);
	}


}
