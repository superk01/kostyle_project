package kostyle.login.domain;

public class LoginDTO {
	private String cus_id;
	private int adshop_id;
	private String user_pass;
	private boolean useCookie;

	

	public String getCus_id() {
		return cus_id;
	}


	public void setCus_id(String cus_id) {
		this.cus_id = cus_id;
	}


	public int getAdshop_id() {
		return adshop_id;
	}


	public void setAdshop_id(int adshop_id) {
		this.adshop_id = adshop_id;
	}


	public String getUser_pass() {
		return user_pass;
	}


	public void setUser_pass(String user_pass) {
		this.user_pass = user_pass;
	}


	public boolean isUseCookie() {
		return useCookie;
	}


	public void setUseCookie(boolean useCookie) {
		this.useCookie = useCookie;
	}


	@Override
	public String toString() {
		return "LoginDTO [cus_id=" + cus_id + ", adshop_id=" + adshop_id + ", user_pass=" + user_pass + ", useCookie="
				+ useCookie + "]";
	}


}
