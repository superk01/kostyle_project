package kostyle.admin.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kostyle.admin.domain.AdShoppingMallAdmin;
import kostyle.admin.domain.ShoppingMallAdmin;
import kostyle.admin.persistence.ShopAdminDAO;

@Service
public class ShopAdminServiceImpl implements ShopAdminService{

	@Inject
	public ShopAdminDAO dao;
	
	@Override
	public void insertShoppingMall(ShoppingMallAdmin shop) throws Exception {
		dao.insertShoppingMall(shop);
	}

	@Override
	public int countShoppingMall() throws Exception {
		return dao.countShoppingMall();
	}

	@Override
	public List<ShoppingMallAdmin> shopList() throws Exception {
		return dao.shopList();
	}

	@Override
	public ShoppingMallAdmin getShoppingMall(String s_num) throws Exception {
		return dao.getShoppingMall(s_num);
	}

	@Override
	public void insertAdShoppingMall(ShoppingMallAdmin shop) throws Exception {
		dao.insertAdShoppingMall(shop);
	}

	@Override
	public List<AdShoppingMallAdmin> adShopList() throws Exception {
		return dao.adShopList();
	}
	
	

}
