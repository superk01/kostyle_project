package kostyle.stats.domain;

/**
 * @author kosta
 *
 */
public class CustomerStats {
	private String sk_searchkey;
	private int key_count;
	
	private String s_sname;
	private int shop_count;
	
	private String h_name;
	private int prd_count;
	private String h_prdurl;
	private String h_imgurl;
	
	private String c_num;
	private int customer_count;
	
	public String getSk_searchkey() {
		return sk_searchkey;
	}
	public void setSk_searchkey(String sk_searchkey) {
		this.sk_searchkey = sk_searchkey;
	}
	public int getKey_count() {
		return key_count;
	}
	public void setKey_count(int key_count) {
		this.key_count = key_count;
	}
	public String getS_sname() {
		return s_sname;
	}
	public void setS_sname(String s_sname) {
		this.s_sname = s_sname;
	}
	public int getShop_count() {
		return shop_count;
	}
	public void setShop_count(int shop_count) {
		this.shop_count = shop_count;
	}
	public String getH_name() {
		return h_name;
	}
	public void setH_name(String h_name) {
		this.h_name = h_name;
	}
	public int getPrd_count() {
		return prd_count;
	}
	public void setPrd_count(int prd_count) {
		this.prd_count = prd_count;
	}
	public String getH_prdurl() {
		return h_prdurl;
	}
	public void setH_prdurl(String h_prdurl) {
		this.h_prdurl = h_prdurl;
	}
	public String getH_imgurl() {
		return h_imgurl;
	}
	public void setH_imgurl(String h_imgurl) {
		this.h_imgurl = h_imgurl;
	}
	public String getC_num() {
		return c_num;
	}
	public void setC_num(String c_num) {
		this.c_num = c_num;
	}
	public int getCustomer_count() {
		return customer_count;
	}
	public void setCustomer_count(int customer_count) {
		this.customer_count = customer_count;
	}
	
	
}
