package kostyle.favorite.service;

import java.util.List;
import kostyle.favorite.domain.Favorite;

public interface FavoriteService {

	public List<Favorite> favoriteList()throws Exception;
	
}
