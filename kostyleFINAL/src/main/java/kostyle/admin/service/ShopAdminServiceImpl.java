package kostyle.admin.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kostyle.admin.domain.AdShoppingMallAdmin;
import kostyle.admin.domain.CriteriaAdmin;
import kostyle.admin.domain.SearchCriteriaAdmin;
import kostyle.admin.domain.ShoppingMallAdmin;
import kostyle.admin.persistence.ShopAdminDAO;
import kostyle.stats.domain.SearchKeywordStats;

@Service
public class ShopAdminServiceImpl implements ShopAdminService{

	@Inject
	public ShopAdminDAO dao;
	
	@Override
	public void insertShoppingMall(ShoppingMallAdmin shop) throws Exception {
		dao.insertShoppingMall(shop);
	}

	@Override
	public int countShoppingMall(CriteriaAdmin cri) throws Exception {
		return dao.countShoppingMall(cri);
	}

	@Override
	public int countSearchShop(SearchCriteriaAdmin cri) throws Exception {
		return dao.countSearchShop(cri);
	}

	@Override
	public List<ShoppingMallAdmin> shopList(CriteriaAdmin cri) throws Exception {
		return dao.shopList(cri);
	}

	@Override
	public ShoppingMallAdmin getShoppingMall(String s_num) throws Exception {
		return dao.getShoppingMall(s_num);
	}

	@Override
	public AdShoppingMallAdmin getAdShoppingMall(String s_num) throws Exception {
		return dao.getAdShoppingMall(s_num);
	}

	@Override
	public void insertAdShoppingMall(AdShoppingMallAdmin adShop) throws Exception {
		dao.insertAdShoppingMall(adShop);
	}

	@Override
	public List<AdShoppingMallAdmin> adShopList() throws Exception {
		return dao.adShopList();
	}

	@Override
	public void deleteAdShop(String s_num) throws Exception {
		dao.deleteAdShop(s_num);
	}

	@Override
	public void updateAdShopInfo(AdShoppingMallAdmin adShop) throws Exception {
		dao.updateAdShopInfo(adShop);
	}

	@Override
	public void updateShopInfo(ShoppingMallAdmin shop) throws Exception {
		dao.updateShopInfo(shop);
	}

	@Override
	public List<SearchKeywordStats> admintest(String sk_searchkey) throws Exception {
		return dao.admintest(sk_searchkey);
	}
	
	

}
