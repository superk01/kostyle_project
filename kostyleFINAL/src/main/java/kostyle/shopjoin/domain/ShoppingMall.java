package kostyle.shopjoin.domain;

public class ShoppingMall {
	private String s_Num;
	private String s_Manager;
	private String s_ShopUrl;
	private String s_SearchUrl;
	private String s_ShopReg;
	private String s_Sname;
	private String s_Email;
	private String s_Age;
	private String s_PhoneNumber;
	private String s_Image;
	
	public String getS_Num() {
		return s_Num;
	}
	public void setS_Num(String s_Num) {
		this.s_Num = s_Num;
	}
	public String getS_Manager() {
		return s_Manager;
	}
	public void setS_Manager(String s_Manager) {
		this.s_Manager = s_Manager;
	}
	public String getS_ShopUrl() {
		return s_ShopUrl;
	}
	public void setS_ShopUrl(String s_ShopUrl) {
		this.s_ShopUrl = s_ShopUrl;
	}
	public String getS_SearchUrl() {
		return s_SearchUrl;
	}
	public void setS_SearchUrl(String s_SearchUrl) {
		this.s_SearchUrl = s_SearchUrl;
	}
	public String getS_ShopReg() {
		return s_ShopReg;
	}
	public void setS_ShopReg(String s_ShopReg) {
		this.s_ShopReg = s_ShopReg;
	}
	public String getS_Sname() {
		return s_Sname;
	}
	public void setS_Sname(String s_Sname) {
		this.s_Sname = s_Sname;
	}
	public String getS_Email() {
		return s_Email;
	}
	public void setS_Email(String s_Email) {
		this.s_Email = s_Email;
	}
	public String getS_Age() {
		return s_Age;
	}
	public void setS_Age(String s_Age) {
		this.s_Age = s_Age;
	}
	public String getS_PhoneNumber() {
		return s_PhoneNumber;
	}
	public void setS_PhoneNumber(String s_PhoneNumber) {
		this.s_PhoneNumber = s_PhoneNumber;
	}
	public String getS_Image() {
		return s_Image;
	}
	public void setS_Image(String s_Image) {
		this.s_Image = s_Image;
	}
	@Override
	public String toString() {
		return "ShoppingMall= "+s_Num+s_ShopUrl+s_SearchUrl+s_ShopReg+s_Sname+s_Email+s_Age+s_PhoneNumber+s_Image;
	}
	
	
}
