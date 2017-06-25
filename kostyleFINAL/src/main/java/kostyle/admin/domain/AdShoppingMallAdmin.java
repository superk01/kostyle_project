package kostyle.admin.domain;

import java.util.Date;

public class AdShoppingMallAdmin {
	
	private String s_num;
	private String ad_id;
	private String ad_pass;
	private int s_grade;
	private int p_powernum;
	private Date ad_sessionlimit;
	private String ad_sessionkey;
	
	public String getS_num() {
		return s_num;
	}
	public void setS_num(String s_num) {
		this.s_num = s_num;
	}
	public String getAd_id() {
		return ad_id;
	}
	public void setAd_id(String ad_id) {
		this.ad_id = ad_id;
	}
	public String getAd_pass() {
		return ad_pass;
	}
	public void setAd_pass(String ad_pass) {
		this.ad_pass = ad_pass;
	}
	public int getS_grade() {
		return s_grade;
	}
	public void setS_grade(int s_grade) {
		this.s_grade = s_grade;
	}
	public int getP_powernum() {
		return p_powernum;
	}
	public void setP_powernum(int p_powernum) {
		this.p_powernum = p_powernum;
	}
	public Date getAd_sessionlimit() {
		return ad_sessionlimit;
	}
	public void setAd_sessionlimit(Date ad_sessionlimit) {
		this.ad_sessionlimit = ad_sessionlimit;
	}
	public String getAd_sessionkey() {
		return ad_sessionkey;
	}
	public void setAd_sessionkey(String ad_sessionkey) {
		this.ad_sessionkey = ad_sessionkey;
	}
	
		

}
