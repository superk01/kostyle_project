package kostyle.favorite.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import kostyle.favorite.domain.Favorite;
import kostyle.favorite.domain.FavoriteAdd;
import kostyle.favorite.domain.FavoriteCriteria;
import kostyle.favorite.domain.FavoriteSearchCriteria;

@Repository
public class FavoriteDAOImpl implements FavoriteDAO {

	@Inject
	private SqlSession session;
	   
	private static String namespace = "kostyle.favorite.mappers.favoriteMapper";

	
	@Override
	public List<Favorite> listFavorite() throws Exception {
		return session.selectList(namespace+".listFavorite");
	}
	
	
	@Override
	public List<Favorite> listFavoriteCriteria(String c_num, FavoriteCriteria cri) throws Exception {
		System.out.println("dao###############"); 
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("c_num", c_num);
		map.put("cri", cri);
		return session.selectList(namespace+".listFavorite", map, new RowBounds(cri.getPageStart(), cri.getPerPageNum()));
	}


	@Override
	public List<Favorite> listFavoritePage(int page) throws Exception {
		if(page <= 0){
			page = 1;
		}
		page = (page-1) * 5;
		
		return session.selectList(namespace+".listFavorite",page);
	}
	

	//1
	@Override
	public String autoF_num() throws Exception {
		if(session.selectOne(namespace+".autoF_num") == null){
			return "0";
		}else{
			return session.selectOne(namespace+".autoF_num");
		}
	}
	
	
	//2
	@Override
	public String iframeS_num(String s_shopurl) throws Exception {
		return session.selectOne(namespace+".iframeS_num", s_shopurl);
	}
	
	
	//3
	@Override
	public int overlapFavorite(String s_num, String c_num) throws Exception {
		Map<String , String> map = new HashMap<String, String>();
		map.put("s_num", s_num);
		map.put("c_num", c_num);
		
		return session.selectOne(namespace+".overlapFavorite", map);
	}
		

	//4
	@Override
	public void addFavorite(FavoriteAdd favoriteAdd) throws Exception {
		session.insert(namespace+".addFavorite", favoriteAdd);
	}

	
	@Override
	public int countPaging(String c_num, FavoriteCriteria cri) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("c_num", c_num);
		map.put("cri", cri);
		return session.selectOne(namespace+".countPaging", map);
	}


	@Override
	public Favorite comentRead(String f_num) throws Exception {
		return session.selectOne(namespace+".comentRead", f_num);
	}


	@Override
	public void comentModify(Favorite favorite) throws Exception {
		System.out.println("DAO : " +favorite.toString());
		session.update(namespace+".comentModify", favorite);
	}


	@Override
	public void deleteFavorite(String c_num, String f_num) throws Exception {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("c_num", c_num);
		map.put("f_num", f_num);
		session.delete(namespace+".deleteFavorite", map);
	}
	
	
}
