package kostyle.favorite.persistence;

import java.util.List;

import kostyle.favorite.domain.Favorite;
import kostyle.favorite.domain.FavoriteCriteria;

public interface FavoriteDAO {

	public List<Favorite> listFavorite()throws Exception;
	
	public List<Favorite> listFavoriteCriteria(String c_num, FavoriteCriteria cri)throws Exception;
	
	public List<Favorite> listFavoritePage(int page)throws Exception;
	
	public int countPaging(String c_num, FavoriteCriteria cri)throws Exception;
	
	public Favorite comentRead(String f_num)throws Exception;
	
	public void comentModify(Favorite favorite)throws Exception;
	
	public void deleteFavorite(String c_num, String f_num)throws Exception;
	
	
	
}
