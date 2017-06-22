package kostyle.ranking.domain;

import java.util.List;

public class RankingUpdateVO {
	
	private List<Integer> s_rank ;

	public List<Integer> getS_rank() {
		return s_rank;
	}

	public void setS_rank(List<Integer>  s_rank) {
		this.s_rank = s_rank;
	}

	@Override
	public String toString() {
		return "RankingUpdateVO [s_rank=" + s_rank + "]";
	}
	

}
