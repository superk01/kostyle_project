package kostyle.login.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kostyle.login.domain.AdShopVO;
import kostyle.login.domain.CustomerVO;
import kostyle.login.domain.LoginDTO;

@Repository
public class LoginDAOImpl implements LoginDAO{
	
	@Inject
	private SqlSession session;
	
	private static String namespace="kostyle.login.mappers.loginMapper";
	
	@Override
	public CustomerVO cusLogin(LoginDTO dto) throws Exception {
		System.out.println("daoCusVO: "+session.selectOne(namespace+".cuslogin",dto));
		return session.selectOne(namespace+ ".cuslogin", dto) ;
	}

	@Override
	public AdShopVO shopLogin(LoginDTO dto) throws Exception {
		System.out.println("daoShopVO: "+session.selectOne(namespace+".shoplogin",dto));
		return session.selectOne(namespace+ ".shoplogin", dto) ;
	}

	@Override
	public void cusLogout() throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void shopLogout() throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
}
