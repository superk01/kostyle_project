package kostyle.admin.service;

import java.util.List;

import kostyle.admin.domain.AdShoppingMallAdmin;
import kostyle.admin.domain.CriteriaAdmin;
import kostyle.admin.domain.SearchCriteriaAdmin;
import kostyle.admin.domain.ShoppingMallAdmin;

public interface ShopAdminService {
	public void insertShoppingMall(ShoppingMallAdmin shop)throws Exception;
	public int countShoppingMall(CriteriaAdmin cri)throws Exception;
	public int countSearchShop(SearchCriteriaAdmin cri)throws Exception;
	public List<ShoppingMallAdmin> shopList(CriteriaAdmin cri)throws Exception;
	public ShoppingMallAdmin getShoppingMall(String s_num)throws Exception;
	public void insertAdShoppingMall(ShoppingMallAdmin shop)throws Exception;
	public List<AdShoppingMallAdmin> adShopList()throws Exception;
	public void deleteAdShop(String s_num)throws Exception;
}
