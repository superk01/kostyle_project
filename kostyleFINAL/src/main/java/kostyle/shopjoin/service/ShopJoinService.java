package kostyle.shopjoin.service;

import kostyle.shopjoin.domain.ShoppingMall;

public interface ShopJoinService {
	public void insertShoppingMall(ShoppingMall shop)throws Exception;
	public int countShoppingMall()throws Exception;
}
