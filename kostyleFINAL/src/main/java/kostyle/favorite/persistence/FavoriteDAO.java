package kostyle.favorite.persistence;

import java.util.List;
import kostyle.favorite.domain.Favorite;

public interface FavoriteDAO {

	public List<Favorite> favoriteList()throws Exception;
	
}
