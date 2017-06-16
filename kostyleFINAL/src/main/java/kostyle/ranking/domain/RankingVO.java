package kostyle.ranking.domain;

public class RankingVO {
	private String s_num;
	private String s_shopurl;
	private String s_sname;
	private String s_age;
	private String s_image;
	private String s_rank;
	
	public String getS_shopurl() {
		return s_shopurl;
	}
	public void setS_shopurl(String s_shopurl) {
		this.s_shopurl = s_shopurl;
	}
	public String getS_sname() {
		return s_sname;
	}
	public void setS_sname(String s_sname) {
		this.s_sname = s_sname;
	}
	public String getS_age() {
		return s_age;
	}
	public void setS_age(String s_age) {
		this.s_age = s_age;
	}
	public String getS_image() {
		return s_image;
	}
	public void setS_image(String s_image) {
		this.s_image = s_image;
	}
	
	
	public String getS_num() {
		return s_num;
	}
	public void setS_num(String s_num) {
		this.s_num = s_num;
	}
	public String getS_rank() {
		return s_rank;
	}
	public void setS_rank(String s_rank) {
		this.s_rank = s_rank;
	}
	@Override
	public String toString() {
		return "RankingVO [s_num=" + s_num + ", s_shopurl=" + s_shopurl + ", s_sname=" + s_sname + ", s_age=" + s_age
				+ ", s_image=" + s_image + ", s_rank=" + s_rank + "]";
	}
	
	
	
	
	

}
