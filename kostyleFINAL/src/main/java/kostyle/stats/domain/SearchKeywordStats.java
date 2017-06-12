package kostyle.stats.domain;

import java.util.Date;

public class SearchKeywordStats {
	private String c_num;
	private String sk_searchkey;
	private Date sk_date;
	private int sk_num;
	public String getC_num() {
		return c_num;
	}
	public void setC_num(String c_num) {
		this.c_num = c_num;
	}
	public String getSk_searchkey() {
		return sk_searchkey;
	}
	public void setSk_searchkey(String sk_searchkey) {
		this.sk_searchkey = sk_searchkey;
	}
	public Date getSk_date() {
		return sk_date;
	}
	public void setSk_date(Date sk_date) {
		this.sk_date = sk_date;
	}
	public int getSk_num() {
		return sk_num;
	}
	public void setSk_num(int sk_num) {
		this.sk_num = sk_num;
	}
	
}
