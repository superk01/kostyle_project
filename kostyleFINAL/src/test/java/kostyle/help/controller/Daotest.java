package kostyle.help.controller;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kostyle.help.domain.BoardVO;
import kostyle.help.persistence.BoardDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class Daotest {

	
	@Inject
	private BoardDAO dao;
	
	@Test
	public void daoTest() {
		List<BoardVO> list = dao.list();
		System.out.println("daoTest:"+list);
	}
}
