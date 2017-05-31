package login.service;

import static org.junit.Assert.*;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kostyle.login.domain.AdShopVO;
import kostyle.login.domain.CustomerVO;
import kostyle.login.domain.LoginDTO;
import kostyle.login.service.LoginServiceImpl;
import login.persistence.LoginDAOImplTest;

//root-context.xml과 servlet-context.xml을 다 가져와야 그 안의 내용을 사용가능하다.
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class LoginServiceImplTest {
	@Inject
	private LoginServiceImpl service;
	
	
	private static Logger logger = LoggerFactory.getLogger(LoginDAOImplTest.class);
	
	
	@Test
	public void testCusLoginService() throws Exception {
		LoginDTO dto = new LoginDTO();
		dto.setCus_id("poi");
		dto.setUser_pass("1234");
		
		CustomerVO vo = service.cusLogin(dto);
		System.out.println("뽑아온 VO: "+vo);
	}
	
	@Test
	public void testShopLogin() throws Exception {
		LoginDTO dto = new LoginDTO();
		dto.setAdshop_id(1234);
		dto.setUser_pass("1234");
		
		AdShopVO vo = service.shopLogin(dto);
		System.out.println("뽑아온 AdShopVO: "+vo);
	}

}
