package kostyle.ranking.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kostyle.ranking.domain.RankList;
import kostyle.ranking.domain.RankingCountVO;
import kostyle.ranking.domain.RankingVO;

@Repository
public class RankingDAOImpl implements RankingDAO{
	
	@Inject
	private SqlSession session;
	
	private static String namespace = "kostyle.ranking.mappers.rankingMapper";

	@Override
	public List<RankingVO> listRanking() {
		
		return session.selectList(namespace + ".list_Ranking");
		
	}

	@Override
	public List<Integer> favoriteScore() {
		return session.selectList(namespace + ".favorite_score");
	}

	@Override
	public List<Integer> sumclickScore() {
		return session.selectList(namespace + ".sumclick_score");
	}
	
	@Override
	public List<Integer> avgclickScore() {
		return session.selectList(namespace + ".avgclick_score");
	}

	@Override
	public List<Integer> showRank() {
		return session.selectList(namespace + ".show_rank");
	}

	

	@Override
	public List<String> showsnum() {
		return session.selectList(namespace + ".show_snum");
	}

	@Override
	public void updateRank(RankList rankList) {
		 session.update(namespace + ".update_rank", rankList);
		
	}
	
	
}
