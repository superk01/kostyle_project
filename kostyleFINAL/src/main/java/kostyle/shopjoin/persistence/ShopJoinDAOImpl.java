package kostyle.shopjoin.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kostyle.shopjoin.domain.ShoppingMall;

@Repository
public class ShopJoinDAOImpl implements ShopJoinDAO{
	
	@Inject
	private SqlSession session;
	
	private static String namespace = "kostyle.shopjoin.mappers.shopjoinMapper";
	
	@Override
	public void insertShoppingMall(ShoppingMall shop) throws Exception {
		session.insert(namespace+".insertShoppingMall", shop);
	}

	@Override
	public int countShoppingMall() throws Exception {
		return session.selectOne(namespace+".countShoppingMall");
	}

}
