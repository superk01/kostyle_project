package kostyle.admin.service;

import java.util.List;

import kostyle.admin.domain.AdShoppingMallAdmin;
import kostyle.admin.domain.ShoppingMallAdmin;

public interface ShopAdminService {
	public void insertShoppingMall(ShoppingMallAdmin shop)throws Exception;
	public int countShoppingMall()throws Exception;
	public List<ShoppingMallAdmin> shopList()throws Exception;
	public ShoppingMallAdmin getShoppingMall(String s_num)throws Exception;
	public void insertAdShoppingMall(ShoppingMallAdmin shop)throws Exception;
	public List<AdShoppingMallAdmin> adShopList()throws Exception;
}
