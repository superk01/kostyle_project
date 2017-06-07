package kostyle.login.service;

import java.util.Date;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kostyle.login.domain.AdShopVO;
import kostyle.login.domain.CustomerVO;
import kostyle.login.domain.LoginDTO;
import kostyle.login.persistence.LoginDAO;

public interface LoginService {
	
	public CustomerVO cusLogin(LoginDTO dto)throws Exception;
	public AdShopVO shopLogin(LoginDTO dto)throws Exception;
	
	public void cusLogout() throws Exception;
	public void shopLogout() throws Exception;
	
	
	public void keepCusLoginLimit(String cus_id, String sessionId, Date next);
	public CustomerVO checkCusSessionKey(String cookieVal);
	
	public void keepShopLoginLimit(int adshop_id, String sessionId, Date next);
	public AdShopVO checkShopSessionKey(String cookieVal);
	
}
