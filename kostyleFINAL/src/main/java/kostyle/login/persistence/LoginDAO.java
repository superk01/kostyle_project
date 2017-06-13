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
	
	public void keepShopLoginLimit(String adshop_id, String sessionId, Date next);
	public AdShopVO checkShopSessionKey(String cookieVal);
	
	//로그인시 비밀번호 암호화 비교를 위해 아이디만가지고 Customer객체를 미리 가져옴
	public CustomerVO cusGetId(String cus_id);
	
}
