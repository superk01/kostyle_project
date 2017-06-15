package kostyle.ranking.domain;

public class RankList {
	private String s_num;
	private Integer s_rank;
	
	public String getS_num() {
		return s_num;
	}
	public void setS_num(String s_num) {
		this.s_num = s_num;
	}
	public Integer getS_rank() {
		return s_rank;
	}
	public void setS_rank(Integer s_rank) {
		this.s_rank = s_rank;
	}
	@Override
	public String toString() {
		return "RankList [s_num=" + s_num + ", s_rank=" + s_rank + "]";
	}
	
	public RankList(String s_num, Integer s_rank) {
		super();
		this.s_num = s_num;
		this.s_rank = s_rank;
	}
	
	
	
	

}
