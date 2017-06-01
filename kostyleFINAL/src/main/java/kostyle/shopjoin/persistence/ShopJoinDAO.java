package kostyle.shopjoin.persistence;

import kostyle.shopjoin.domain.ShoppingMall;

public interface ShopJoinDAO {
	public void insertShoppingMall(ShoppingMall shop)throws Exception;
	public int countShoppingMall()throws Exception;
}
