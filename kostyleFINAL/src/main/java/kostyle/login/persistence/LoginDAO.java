package kostyle.login.persistence;

import kostyle.login.domain.AdShopVO;
import kostyle.login.domain.CustomerVO;
import kostyle.login.domain.LoginDTO;

public interface LoginDAO {
	public CustomerVO cusLogin(LoginDTO dto)throws Exception;
	public AdShopVO shopLogin(LoginDTO dto)throws Exception;
	
	public void cusLogout() throws Exception;
	public void shopLogout() throws Exception;
}
