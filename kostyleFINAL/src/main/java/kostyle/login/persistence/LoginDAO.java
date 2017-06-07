package kostyle.login.persistence;

import java.util.Date;

import kostyle.login.domain.AdShopVO;
import kostyle.login.domain.CustomerVO;
import kostyle.login.domain.LoginDTO;

public interface LoginDAO {
	public CustomerVO cusLogin(LoginDTO dto)throws Exception;
	public AdShopVO shopLogin(LoginDTO dto)throws Exception;
	
	
	
	public void keepCusLoginLimit(String cus_id, String sessionId, Date next);
	public CustomerVO checkCusSessionKey(String cookieVal);
	
	public void keepShopLoginLimit(int adshop_id, String sessionId, Date next);
	public AdShopVO checkShopSessionKey(String cookieVal);
}
