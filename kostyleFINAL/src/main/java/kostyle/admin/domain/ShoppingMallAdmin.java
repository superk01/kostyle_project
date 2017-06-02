package kostyle.admin.domain;

public class ShoppingMallAdmin {
	private String s_num;
	private String s_manager;
	private String s_shopurl;
	private String s_searchurl;
	private String s_shopreg;
	private String s_sname;
	private String s_email;
	private String s_age;
	private String s_phonenumber;
	private String s_image;
	

	public String getS_num() {
		return s_num;
	}


	public void setS_num(String s_num) {
		this.s_num = s_num;
	}


	public String getS_manager() {
		return s_manager;
	}


	public void setS_manager(String s_manager) {
		this.s_manager = s_manager;
	}


	public String getS_shopurl() {
		return s_shopurl;
	}


	public void setS_shopurl(String s_shopurl) {
		this.s_shopurl = s_shopurl;
	}


	public String getS_searchurl() {
		return s_searchurl;
	}


	public void setS_searchurl(String s_searchurl) {
		this.s_searchurl = s_searchurl;
	}


	public String getS_shopreg() {
		return s_shopreg;
	}


	public void setS_shopreg(String s_shopreg) {
		this.s_shopreg = s_shopreg;
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


	public String getS_age() {
		return s_age;
	}


	public void setS_age(String s_age) {
		this.s_age = s_age;
	}


	public String getS_phonenumber() {
		return s_phonenumber;
	}


	public void setS_phonenumber(String s_phonenumber) {
		this.s_phonenumber = s_phonenumber;
	}


	public String getS_image() {
		return s_image;
	}


	public void setS_image(String s_image) {
		this.s_image = s_image;
	}


	@Override
	public String toString() {
		return "shoppingMall: "+s_num+s_manager+s_shopurl+s_searchurl+s_shopreg+s_sname+s_email+s_age+s_phonenumber+s_image;
	}
	
}
