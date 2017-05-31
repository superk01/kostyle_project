package kostyle.login.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kostyle.login.domain.AdShopVO;
import kostyle.login.domain.CustomerVO;
import kostyle.login.domain.LoginDTO;
import kostyle.login.persistence.LoginDAO;

@Service
public class LoginServiceImpl implements LoginService {

	@Inject
	private LoginDAO dao;
	
	@Override
	public CustomerVO cusLogin(LoginDTO dto) throws Exception {
		System.out.println("서비스가받은 customerVO: "+dao.cusLogin(dto));
		return dao.cusLogin(dto);
	}

	@Override
	public AdShopVO shopLogin(LoginDTO dto) throws Exception {
		System.out.println("서비스가받은shopVO: "+dao.shopLogin(dto));
		return dao.shopLogin(dto);
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
