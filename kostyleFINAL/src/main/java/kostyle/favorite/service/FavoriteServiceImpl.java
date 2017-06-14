package kostyle.favorite.service;

import java.util.List;
import javax.inject.Inject;
import org.springframework.stereotype.Service;
import kostyle.favorite.domain.Favorite;
import kostyle.favorite.domain.FavoriteAdd;
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
	public String autoF_num() throws Exception {
		return dao.autoF_num();
	}
	

	@Override
	public String iframeS_num(String s_shopurl) throws Exception {
		return dao.iframeS_num(s_shopurl);
	}


	@Override
	public int overlapFavorite(String s_num, String c_num) throws Exception {
		return dao.overlapFavorite(s_num, c_num);
	}
	
	
	@Override
	public void addFavorite(FavoriteAdd favoriteAdd) throws Exception {
		//즐겨찾기 추가할 때 f_num, s_num, c_num필요
		dao.addFavorite(favoriteAdd);
	}
	

	@Override
	public Favorite comentRead(String f_num) throws Exception {
		return dao.comentRead(f_num);
	}


	@Override
	public void comentModify(Favorite favorite) throws Exception {
		dao.comentModify(favorite);
		System.out.println("서비스1 : " + favorite.toString());
		favorite.setF_coment("11111");
		System.out.println("서비스 2 : " + favorite.toString());
	}


	@Override
	public void deleteFavorite(String c_num, String f_num) throws Exception {
		dao.deleteFavorite(c_num, f_num);
	}


	

}
