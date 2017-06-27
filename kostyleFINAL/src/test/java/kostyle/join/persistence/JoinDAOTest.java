package kostyle.join.persistence;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kostyle.favorite.persistence.FavoriteDAO;
import kostyle.join.domain.JoinJoin;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class JoinDAOTest {

   @Inject
   private JoinDAO dao;
   
   private static Logger logger = LoggerFactory.getLogger(JoinDAOTest.class);
   
   
   @Test
   public void testJoin() throws Exception{
      JoinJoin join = new JoinJoin();
      
      join.setC_adress("구로동");
      join.setC_birth("19950603");
      join.setC_email("lees5351@naver.com");
      join.setC_gender("woman");
      join.setC_id("lees5351");
      join.setC_name("이승연");
      join.setC_pass("12345");
      join.setC_phonenumber("010-5248-3520");
      join.setC_sms("on");
      join.setC_zipcode(152055);
      join.setC_num("91");
      join.setP_powernum(2);

      dao.insertJoin(join);
   }
   
   
   
   /*@Test
   public void testRead() throws Exception{
      logger.info(dao.listFavorite().toString());
   }*/
   
   /*@Test
   public void testUpdate() throws Exception{
	   BoardVO board = new BoardVO();
	   board.setBno(1);
	   board.setTitle("수정된 글 title");
	   board.setContent("수정된 글 content");
	   dao.update(board);
   }*/
   
  /* @Test
   public void testDelete() throws Exception{
	   dao.delete(1);
   }*/
   
/*   @Test
   public void testListCriteria() throws Exception{
	   Criteria cri = new Criteria();
	   cri.setPage(1);
	   cri.setPerPageNum(2);
	   
	   List<BoardVO> list = dao.listCriteria(cri);
	   
	   for(BoardVO boardVO : list){
		   logger.info(boardVO.getBno() + ":" + boardVO.getTitle());
	   }
   }*/
   
 /*  @Test
   public void testURI() throws Exception{
	   UriComponents uriComponents = UriComponentsBuilder.newInstance()
			   .path("/board/read")
			   .queryParam("bno", 12)
			   .queryParam("perPageNum", 20)
			   .build();
	   logger.info("board/read?/bno=12&perPageNum=20");
	   logger.info(uriComponents.toString());
			   
   }*/
   
  /* @Test
   public void testURI2() throws Exception{
	   UriComponents uriComponents = UriComponentsBuilder.newInstance()
			   .path("/{module}/{page}")
			   .queryParam("bno", 12)
			   .queryParam("perPageNum", 20)
			   .build()
			   .expand("board", "read")
			   .encode();
	   logger.info("board/read?/bno=12&perPageNum=20");
	   logger.info(uriComponents.toString());
   }*/

}
