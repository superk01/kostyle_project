package kostyle.favorite.service;

import java.util.List;
import javax.inject.Inject;
import org.springframework.stereotype.Service;
import kostyle.favorite.domain.Favorite;
import kostyle.favorite.persistence.FavoriteDAO;

@Service
public class FavoriteServiceImpl implements FavoriteService {

	@Inject
	private FavoriteDAO dao;
	
	@Override
	public List<Favorite> favoriteList() throws Exception {
		System.out.println("service###############");
		return dao.favoriteList();
	}

}
