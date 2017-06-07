package kostyle.discount.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kostyle.discount.domain.TempShopVO;
import kostyle.login.domain.CustomerVO;
import kostyle.login.domain.LoginDTO;

@Repository
public class DiscountDAOImpl implements DiscountDAO {

	@Inject
	private SqlSession session;
	
	private static String namespace="kostyle.discount.mappers.discountMapper";

	

	@Override
	public void addSaleUrlInfoShop(TempShopVO vo) throws Exception{
		
		try{
			session.update(namespace+ ".addSaleUrlInfoShop", vo);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

	
	
	
	
	
	
}//class