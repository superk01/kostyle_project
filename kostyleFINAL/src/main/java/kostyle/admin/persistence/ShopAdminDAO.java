package kostyle.admin.persistence;

import java.util.List;

import kostyle.admin.domain.ShoppingMall;

public interface ShopAdminDAO {
	public void insertShoppingMall(ShoppingMall shop)throws Exception;
	public int countShoppingMall()throws Exception;
	public List<ShoppingMall>shopList()throws Exception;
	public ShoppingMall shopDetail(String s_num)throws Exception;
}
