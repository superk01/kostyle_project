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
	public void addFavorite(Favorite favorite) throws Exception {
		//즐겨찾기 추가할 때 f_num, s_num, c_num필요
		
		//1. f_num 자동으로 insert
		String num1 = dao.autoF_num();
		System.out.println("즐겨찾기 f_num1 : " + num1);
		
		int num2 = Integer.parseInt(num1);
		System.out.println("즐겨찾기 f_num2 : " + num2);
		
		int num3 = num2 + 1;
		System.out.println("즐겨찾기 f_num3 : " + num3);
		
		String num4 = num3 + "";
		System.out.println("즐겨찾기 f_num4 : " + num4);
		
		favorite.setF_num(num4);
		
		//2. s_num (iframe의 s_shopurl에 따른 s_num)
		String s_num = dao.iframeS_num();
		System.out.println("즐겨찾기 s_num : " + s_num);
		
		favorite.setS_num(s_num);
		
		//3. c_num => 컨트롤러
		
		dao.addFavorite(favorite);
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
