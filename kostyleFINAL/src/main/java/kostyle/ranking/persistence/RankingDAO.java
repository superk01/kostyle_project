package kostyle.ranking.persistence;

import java.util.List;

import kostyle.ranking.domain.RankList;
import kostyle.ranking.domain.RankingCountVO;
import kostyle.ranking.domain.RankingVO;

public interface RankingDAO {
	
	public List<RankingVO> listRanking();
	public List<Integer> favoriteScore();
	public List<String> showsnum();
	public List<Integer> sumclickScore();
	public List<Integer> avgclickScore();
	public List<Integer> showRank();
	public void updateRank(RankList rankList);

}
