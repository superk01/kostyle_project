package kostyle.ranking.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kostyle.ranking.domain.RankList;
import kostyle.ranking.domain.RankingCountVO;
import kostyle.ranking.domain.RankingVO;
import kostyle.ranking.persistence.RankingDAO;

@Service
public class RankingServiceImpl implements RankingService{

	@Inject
	private RankingDAO RankingDao;

	@Override
	public List<RankingVO> listRanking() {
		
		return RankingDao.listRanking();
	}

	@Override
	public List<Integer> favoriteScore() {
		return RankingDao.favoriteScore();
	}

	@Override
	public List<Integer> sumclickScore() {
		return RankingDao.sumclickScore();
	}

	@Override
	public List<Integer> showRank() {
		return RankingDao.showRank();
	}



	@Override
	public List<String> showsnum() {
		return RankingDao.showsnum();
	}

	@Override
	public void updateRank(RankList rankList) {
		RankingDao.updateRank(rankList);
		
	}

	
}
