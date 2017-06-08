package kostyle.login.domain;


public class CustomerVO {
	private String c_num;
	private String c_birth;
	private String c_phonenumber;
	private String c_gender;
	private String c_email;
	private int p_powernum;
	private String c_id;
	private String c_pass;
	private String c_name;
	private int c_zipcode;
	private String c_address;
	private int c_sms;
	
	public CustomerVO(){}

	public String getC_num() {
		return c_num;
	}

	public void setC_num(String c_num) {
		this.c_num = c_num;
	}

	public String getC_birth() {
		return c_birth;
	}

	public void setC_birth(String c_birth) {
		this.c_birth = c_birth;
	}

	public String getC_phonenumber() {
		return c_phonenumber;
	}

	public void setC_phonenumber(String c_phonenumber) {
		this.c_phonenumber = c_phonenumber;
	}

	public String getC_gender() {
		return c_gender;
	}

	public void setC_gender(String c_gender) {
		this.c_gender = c_gender;
	}

	public String getC_email() {
		return c_email;
	}

	public void setC_email(String c_email) {
		this.c_email = c_email;
	}

	public int getP_powernum() {
		return p_powernum;
	}

	public void setP_powernum(int p_powernum) {
		this.p_powernum = p_powernum;
	}

	public String getC_id() {
		return c_id;
	}

	public void setC_id(String c_id) {
		this.c_id = c_id;
	}

	public String getC_pass() {
		return c_pass;
	}

	public void setC_pass(String c_pass) {
		this.c_pass = c_pass;
	}

	public String getC_name() {
		return c_name;
	}

	public void setC_name(String c_name) {
		this.c_name = c_name;
	}

	public int getC_zipcode() {
		return c_zipcode;
	}

	public void setC_zipcode(int c_zipcode) {
		this.c_zipcode = c_zipcode;
	}

	public String getC_address() {
		return c_address;
	}

	public void setC_address(String c_address) {
		this.c_address = c_address;
	}

	public int getC_sms() {
		return c_sms;
	}

	public void setC_sms(int c_sms) {
		this.c_sms = c_sms;
	}

	@Override
	public String toString() {
		return "CustomerVO [c_num=" + c_num + ", c_birth=" + c_birth + ", c_phonenumber=" + c_phonenumber
				+ ", c_gender=" + c_gender + ", c_email=" + c_email + ", p_powernum=" + p_powernum + ", c_id=" + c_id
				+ ", c_pass=" + c_pass + ", c_name=" + c_name + ", c_zipcode=" + c_zipcode + ", c_address=" + c_address
				+ ", c_sms=" + c_sms + "]";
	}


}//Class
