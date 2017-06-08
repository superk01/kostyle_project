package kostyle.favorite.persistence;

import java.util.List;
import javax.inject.Inject;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import kostyle.favorite.domain.Favorite;
import kostyle.favorite.domain.FavoriteCriteria;
import kostyle.favorite.domain.FavoriteSearchCriteria;

@Repository
public class FavoriteDAOImpl implements FavoriteDAO {

	@Inject
	private SqlSession session;
	   
	private static String namespace = "kostyle.favorite.mappers.favoriteMapper";

	
	@Override
	public List<Favorite> listFavorite() throws Exception {
		System.out.println("dao###############");
		return session.selectList(namespace+".listFavorite");
	}
	
	
	@Override
	public List<Favorite> listFavoriteCriteria(FavoriteCriteria cri) throws Exception {
		 return session.selectList(namespace+".listFavorite", cri, new RowBounds(cri.getPageStart(), cri.getPerPageNum()));
	}


	@Override
	public List<Favorite> listFavoritePage(int page) throws Exception {
		if(page <= 0){
			page = 1;
		}
		page = (page-1) * 5;
		
		return session.selectList(namespace+".listFavorite",page);
	}

	
	@Override
	public int countPaging(FavoriteCriteria cri) throws Exception {
		return session.selectOne(namespace+".countPaging", cri);
	}


	@Override
	public Favorite comentRead(String f_num) throws Exception {
		return session.selectOne(namespace+".comentRead", f_num);
	}


	@Override
	public void comentModify(Favorite favorite) throws Exception {
		session.update(namespace+".comentModify", favorite);
	}


	@Override
	public void deleteFavorite(String f_num) throws Exception {
		session.delete(namespace+".deleteFavorite", f_num);
	}

	
	
}
