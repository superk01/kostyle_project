package kostyle.favorite.service;

import java.util.List;

import kostyle.favorite.domain.Favorite;
import kostyle.favorite.domain.FavoriteCriteria;

public interface FavoriteService {

	public List<Favorite> listFavorite_S()throws Exception;
	
	public List<Favorite> listFavoriteCriteria(String c_num, FavoriteCriteria cri)throws Exception;
	
	public void addFavorite(Favorite favorite)throws Exception;
	
	public int listCountCriteria(String c_num, FavoriteCriteria cri)throws Exception;
	
	public Favorite comentRead(String f_num)throws Exception;
	
	public void comentModify(Favorite favorite)throws Exception;
	
	public void deleteFavorite(String c_num, String f_num)throws Exception;
	
	
	
}
