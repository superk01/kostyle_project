package kostyle.shopjoin.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kostyle.shopjoin.domain.ShoppingMall;
import kostyle.shopjoin.persistence.ShopJoinDAO;

@Service
public class ShopJoinServiceImpl implements ShopJoinService{

	@Inject
	public ShopJoinDAO dao;
	
	@Override
	public void insertShoppingMall(ShoppingMall shop) throws Exception {
		dao.insertShoppingMall(shop);
	}

	@Override
	public int countShoppingMall() throws Exception {
		return dao.countShoppingMall();
	}

}
