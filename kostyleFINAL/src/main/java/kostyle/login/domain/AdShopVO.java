package kostyle.login.domain;

import java.io.Serializable;

public class AdShopVO implements Serializable {
	private String s_num;
	private int ad_id;
	private String ad_pass;
	private int p_powernum;
	private String s_sname;
/*	private int ad_hitcount;
	private int s_grade;
*/
	public AdShopVO(){}
	public AdShopVO(String s_num, int ad_id, String ad_pass, int p_powernum, String s_sname) {
		super();
		this.s_num = s_num;
		this.ad_id = ad_id;
		this.ad_pass = ad_pass;
		this.p_powernum = p_powernum;
		this.s_sname = s_sname;
	}
	public String getS_num() {
		return s_num;
	}
	public void setS_num(String s_num) {
		this.s_num = s_num;
	}
	public int getAd_id() {
		return ad_id;
	}
	public void setAd_id(int ad_id) {
		this.ad_id = ad_id;
	}
	public String getAd_pass() {
		return ad_pass;
	}
	public void setAd_pass(String ad_pass) {
		this.ad_pass = ad_pass;
	}
	public int getP_powernum() {
		return p_powernum;
	}
	public void setP_powernum(int p_powernum) {
		this.p_powernum = p_powernum;
	}
	public String getS_sname() {
		return s_sname;
	}
	public void setS_sname(String s_sname) {
		this.s_sname = s_sname;
	}
	@Override
	public String toString() {
		return "AdShopVO [s_num=" + s_num + ", ad_id=" + ad_id + ", ad_pass=" + ad_pass + ", p_powernum=" + p_powernum
				+ ", s_sname=" + s_sname + "]";
	}

	
	
	
}
