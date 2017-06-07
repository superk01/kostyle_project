/*package closet.persistence;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kostyle.closet.persistence.ClosetDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/*root-context.xml"})
public class ClosetPrdDAOImplTest {
	@Inject
	private ClosetDAO dao;
	
	@Test
	public void testCusLogin() throws Exception {
		LoginDTO dto = new LoginDTO();
		dto.setCus_id("poi");
		dto.setUser_pass("1234");
		
		CustomerVO vo = dao.cusLogin(dto);
		System.out.println("뽑아온 VO: "+vo);
	}
	@Test
	public void testInsertClosetPrd() throws Exception{
		
	}
	
	@Test
	public void testCheck_duplication() throws Exception{
		
	}
	@Test
	public void testMax_detail_num() throws Exception{
		
	}
	@Test
	public void testCount_zzim() throws Exception{
		
	}
	@Test
	public void testMoveClosetPrd() throws Exception{
		
	}
	@Test
	public void testDeleteClosetPrd() throws Exception{
		
	}
	
	
}//class
*/