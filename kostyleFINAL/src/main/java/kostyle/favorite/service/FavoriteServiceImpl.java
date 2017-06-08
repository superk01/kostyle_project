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
		
		System.out.println("service###############");
		return dao.listFavorite();
	}
	
	
	@Override
	public List<Favorite> listFavoriteCriteria(FavoriteCriteria cri) throws Exception {
		return dao.listFavoriteCriteria(cri);
	}

	
	@Override
	public int listCountCriteria(FavoriteCriteria cri) throws Exception {
		return dao.countPaging(cri);
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
	public void deleteFavorite(String f_num) throws Exception {
		dao.deleteFavorite(f_num);
	}
	
	
	

}
