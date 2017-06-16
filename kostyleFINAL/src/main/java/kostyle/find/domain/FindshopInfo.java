package kostyle.find.domain;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

public class FindshopInfo implements Serializable{
	
	private String s_sname;
	private String s_email;
	private String ad_id;
	private String ad_pass;
	
	public FindshopInfo(){}

	public FindshopInfo(String s_sname, String s_email, String ad_id, String ad_pass) {
		super();
		this.s_sname = s_sname;
		this.s_email = s_email;
		this.ad_id = ad_id;
		this.ad_pass = ad_pass;
	}

	public String getS_sname() {
		return s_sname;
	}

	public void setS_sname(String s_sname) {
		this.s_sname = s_sname;
	}

	public String getS_email() {
		return s_email;
	}

	public void setS_email(String s_email) {
		this.s_email = s_email;
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

	@Override
	public String toString() {
		return "FindshopInfo [s_sname=" + s_sname + ", s_email=" + s_email + ", ad_id=" + ad_id + ", ad_pass=" + ad_pass
				+ "]";
	}

	

}


