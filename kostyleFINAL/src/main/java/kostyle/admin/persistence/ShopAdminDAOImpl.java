package kostyle.admin.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kostyle.admin.domain.ShoppingMall;

@Repository
public class ShopAdminDAOImpl implements ShopAdminDAO{
	
	@Inject
	private SqlSession session;
	
	private static String namespace = "kostyle.admin.mappers.adminMapper";
	
	@Override
	public void insertShoppingMall(ShoppingMall shop) throws Exception {
		session.insert(namespace+".insertShoppingMall", shop);
	}

	@Override
	public int countShoppingMall() throws Exception {
		return session.selectOne(namespace+".countShoppingMall");
	}

	@Override
	public List<ShoppingMall> shopList() throws Exception {
		return session.selectList(namespace+".shopList");
	}

	@Override
	public ShoppingMall shopDetail(String s_num) throws Exception {
		return session.selectOne(namespace+".shopDetail", s_num);
	}
	

}
