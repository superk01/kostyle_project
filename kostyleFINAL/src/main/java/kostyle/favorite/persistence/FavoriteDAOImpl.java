package kostyle.favorite.persistence;

import java.util.List;
import javax.inject.Inject;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import kostyle.favorite.domain.Favorite;

@Repository
public class FavoriteDAOImpl implements FavoriteDAO {

	@Inject
	private SqlSession session;
	   
	private static String namespace = "kostyle.favorite.mappers.favoriteMapper";
	
	@Override
	public List<Favorite> favoriteList() throws Exception {
		System.out.println("dao###############");
		return session.selectList(namespace+".favoriteList");
	}
}
