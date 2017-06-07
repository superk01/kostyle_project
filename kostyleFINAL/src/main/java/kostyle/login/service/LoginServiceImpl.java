package kostyle.login.service;

import java.util.Date;

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
	
	//로그인
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

	//로그아웃
	@Override
	public void cusLogout() throws Exception {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void shopLogout() throws Exception {
		// TODO Auto-generated method stub
		
	}


	
	//쿠키로로그인
	@Override  //고객자동로그인한계갱신
	public void keepCusLoginLimit(String cus_id, String sessionId,Date next) {
		dao.keepCusLoginLimit(cus_id, sessionId,next);
	}
	@Override //고객자동로그인
	public CustomerVO checkCusSessionKey(String cookieVal) {
		return dao.checkCusSessionKey(cookieVal);
	}
	@Override  //쇼핑몰자동로그인한계갱신
	public void keepShopLoginLimit(int adshop_id, String sessionId,Date next){
		dao.keepShopLoginLimit(adshop_id, sessionId, next);
	}
	@Override //쇼핑몰자동로그인
	public AdShopVO checkShopSessionKey(String cookieVal) {
		return dao.checkShopSessionKey(cookieVal);
	}



	
}
