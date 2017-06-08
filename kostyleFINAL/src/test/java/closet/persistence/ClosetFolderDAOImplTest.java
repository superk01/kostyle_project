/*package closet.persistence;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kostyle.closet.persistence.ClosetDAO;
import kostyle.login.domain.CustomerVO;
import kostyle.login.domain.LoginDTO;
import kostyle.login.persistence.LoginDAO;
import login.persistence.LoginDAOImplTest;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/*root-context.xml"})
public class ClosetFolderDAOImplTest {
	@Inject
	private ClosetDAO dao;
	
	
	private static Logger logger = LoggerFactory.getLogger(ClosetFolderDAOImplTest.class);
	
	@Test
	public void testCusLogin() throws Exception {
		LoginDTO dto = new LoginDTO();
		dto.setCus_id("poi");
		dto.setUser_pass("1234");
		
		CustomerVO vo = dao.cusLogin(dto);
		System.out.println("뽑아온 VO: "+vo);
	}
	
	@Test
	public void testCloNumTocloName() throws Exception{
		
	}
	
	@Test
	public void testClosetList() throws Exception{
		
	}
	
	@Test
	public void testFullCloset() throws Exception{
		
	}
	
	@Test
	public void testSelectCloset() throws Exception{
		
	}
	
	@Test
	public void testInsertCloset() throws Exception{
		
	}
	@Test
	public void testMax_clo_num() throws Exception{
		
	}
	@Test
	public void testUpdateCloset() throws Exception{
		
	}
	@Test
	public void testDeleteSameCloset_prds() throws Exception{
		
	}
	@Test
	public void testDeleteCloset() throws Exception{
		
	}
	@Test
	public void testCNumTocloNum() throws Exception{
		
	}



	
	
}//class
*/