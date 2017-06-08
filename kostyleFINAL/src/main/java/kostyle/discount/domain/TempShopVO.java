package kostyle.discount.domain;

import java.io.Serializable;

public class TempShopVO implements Serializable {
	private String s_num;
	private String s_newsaleurl;
	private String s_discounturl;
	
	
	public String getS_num() {
		return s_num;
	}
	public void setS_num(String s_num) {
		this.s_num = s_num;
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
		return "TempShopVO [s_num=" + s_num + ", s_newsaleurl=" + s_newsaleurl + ", s_discounturl=" + s_discounturl
				+ "]";
	}

	
	
	
}//class
