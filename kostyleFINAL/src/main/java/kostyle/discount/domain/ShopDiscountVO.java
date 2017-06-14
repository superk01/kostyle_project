package kostyle.discount.domain;

import java.io.Serializable;

public class ShopDiscountVO implements Serializable {

	private String s_num;
	private String s_shopurl;
	private String s_sname;
	private String s_newsaleurl;
	private String s_discounturl;
	
	public ShopDiscountVO(){}
	public ShopDiscountVO(String s_num, String s_shopurl, String s_sname) {
		super();
		this.s_num = s_num;
		this.s_shopurl = s_shopurl;
		this.s_sname = s_sname;
	}
	public String getS_num() {
		return s_num;
	}
	public void setS_num(String s_num) {
		this.s_num = s_num;
	}
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
	public String getS_newsaleurl() {
		return s_newsaleurl;
	}
	public void setS_newsaleurl(String s_newsaleurl) {
		this.s_newsaleurl = s_newsaleurl;
	}
	public String getS_discounturl() {
		return s_discounturl;
	}
	public void setS_discounturl(String s_discounturl) {
		this.s_discounturl = s_discounturl;
	}
	@Override
	public String toString() {
		return "ShopDiscountVO [s_num=" + s_num + ", s_shopurl=" + s_shopurl + ", s_sname=" + s_sname
				+ ", s_newsaleurl=" + s_newsaleurl + ", s_discounturl=" + s_discounturl + "]";
	}
	
	
	
}
