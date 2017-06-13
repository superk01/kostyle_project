package kostyle.stats.domain;

import java.util.Date;

public class HitcountStats {
	private String s_num;
	private String cnt_prdurl;
	private Date cnt_date;
	private String c_num;
	private int hit_num;
	public String getS_num() {
		return s_num;
	}
	public void setS_num(String s_num) {
		this.s_num = s_num;
	}
	public String getCnt_prdurl() {
		return cnt_prdurl;
	}
	public void setCnt_prdurl(String cnt_prdurl) {
		this.cnt_prdurl = cnt_prdurl;
	}
	public Date getCnt_date() {
		return cnt_date;
	}
	public void setCnt_date(Date cnt_date) {
		this.cnt_date = cnt_date;
	}
	public String getC_num() {
		return c_num;
	}
	public void setC_num(String c_num) {
		this.c_num = c_num;
	}
	public int getHit_num() {
		return hit_num;
	}
	public void setHit_num(int hit_num) {
		this.hit_num = hit_num;
	}
	
	
}
