package favorite.persistence;

import java.util.List;

import javax.inject.Inject;

import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import kostyle.favorite.domain.Favorite;
import kostyle.favorite.domain.FavoriteCriteria;
import kostyle.favorite.persistence.FavoriteDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class FavoriteDAOTest{
	
	@Inject
	private FavoriteDAO dao;
	
	 private static Logger logger = LoggerFactory.getLogger(FavoriteDAOTest.class);
	
	 public void testListCriteria() throws Exception{
		   FavoriteCriteria cri = new FavoriteCriteria();
		   cri.setPage(1);
		   cri.setPerPageNum(2);
		   
		   List<Favorite> list = dao.listFavoriteCriteria(cri);
		   
		   for(Favorite favorite : list){
			   logger.info(favorite.getF_num() + ":" + favorite.getS_sname());
		   }
	   }
	
	
}