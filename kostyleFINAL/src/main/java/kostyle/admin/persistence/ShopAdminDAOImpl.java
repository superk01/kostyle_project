package kostyle.admin.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kostyle.admin.domain.AdShoppingMallAdmin;
import kostyle.admin.domain.CriteriaAdmin;
import kostyle.admin.domain.SearchCriteriaAdmin;
import kostyle.admin.domain.ShoppingMallAdmin;

@Repository
public class ShopAdminDAOImpl implements ShopAdminDAO{
	
	@Inject
	private SqlSession session;
	
	private static String namespace = "kostyle.admin.mappers.adminMapper";
	
	@Override
	public void insertShoppingMall(ShoppingMallAdmin shop) throws Exception {
		session.insert(namespace+".insertShoppingMall", shop);
	}

	@Override
	public int countShoppingMall(CriteriaAdmin cri) throws Exception {
		return session.selectOne(namespace+".countShoppingMall", cri);
	}

	@Override
	public int countSearchShop(SearchCriteriaAdmin cri) throws Exception {
		return session.selectOne(namespace+".countSearchShop", cri);
	}

	@Override
	public List<ShoppingMallAdmin> shopList(CriteriaAdmin cri) throws Exception {
		return session.selectList(namespace+".shopList", cri, new RowBounds(cri.getPageStart(), cri.getPerPageNum()));
	}

	@Override
	public ShoppingMallAdmin getShoppingMall(String s_num) throws Exception {
		return session.selectOne(namespace+".getShoppingMall", s_num);
	}

	@Override
	public AdShoppingMallAdmin getAdShoppingMall(String s_num) throws Exception {
		return session.selectOne(namespace+".getAdShoppingMall", s_num);
	}

	@Override
	public void insertAdShoppingMall(AdShoppingMallAdmin adShop) throws Exception {
		session.insert(namespace+".insertAdShoppingMall", adShop);
	}

	@Override
	public List<AdShoppingMallAdmin> adShopList() throws Exception {
		return session.selectList(namespace+".adShopList");
	}

	@Override
	public void deleteAdShop(String s_num) throws Exception {
		session.delete(namespace+".deleteAdShop", s_num);
	}

	@Override
	public void updateAdShopInfo(AdShoppingMallAdmin adShop) throws Exception {
		session.update(namespace+".updateAdShopInfo", adShop);
	}

	@Override
	public void updateShopInfo(ShoppingMallAdmin shop) throws Exception {
		session.update(namespace+".updateShopInfo", shop);
	}
	

}
