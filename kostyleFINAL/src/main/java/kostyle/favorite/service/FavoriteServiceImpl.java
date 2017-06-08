package kostyle.favorite.service;

import java.util.List;
import javax.inject.Inject;
import org.springframework.stereotype.Service;
import kostyle.favorite.domain.Favorite;
import kostyle.favorite.domain.FavoriteCriteria;
import kostyle.favorite.domain.FavoriteSearchCriteria;
import kostyle.favorite.persistence.FavoriteDAO;

@Service
public class FavoriteServiceImpl implements FavoriteService {

	@Inject
	private FavoriteDAO dao;


	@Override
	public List<Favorite> listFavorite_S() throws Exception {
		
		return dao.listFavorite();
	}
	
	
	@Override
	public List<Favorite> listFavoriteCriteria(String c_num, FavoriteCriteria cri) throws Exception {
		System.out.println("service###############"); 
		return dao.listFavoriteCriteria(c_num, cri);
	}

	
	@Override
	public int listCountCriteria(String c_num, FavoriteCriteria cri) throws Exception {
		return dao.countPaging(c_num, cri);
	}


	@Override
	public Favorite comentRead(String f_num) throws Exception {
		return dao.comentRead(f_num);
	}


	@Override
	public void comentModify(Favorite favorite) throws Exception {
		dao.comentModify(favorite);
	}


	@Override
	public void deleteFavorite(String c_num, String f_num) throws Exception {
		dao.deleteFavorite(c_num, f_num);
	}
	
	
	

}
