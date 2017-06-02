package kostyle.admin.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kostyle.admin.domain.AdShoppingMallAdmin;
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
	public int countShoppingMall() throws Exception {
		return session.selectOne(namespace+".countShoppingMall");
	}

	@Override
	public List<ShoppingMallAdmin> shopList() throws Exception {
		return session.selectList(namespace+".shopList");
	}

	@Override
	public ShoppingMallAdmin getShoppingMall(String s_num) throws Exception {
		return session.selectOne(namespace+".getShoppingMall", s_num);
	}

	@Override
	public void insertAdShoppingMall(ShoppingMallAdmin shop) throws Exception {
		session.insert(namespace+".insertAdShoppingMall", shop);
	}

	@Override
	public List<AdShoppingMallAdmin> adShopList() throws Exception {
		return session.selectList(namespace+".adShopList");
	}
	

}
