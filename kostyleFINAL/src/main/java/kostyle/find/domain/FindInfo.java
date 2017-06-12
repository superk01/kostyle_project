package kostyle.find.domain;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

public class FindInfo implements Serializable{
	
	private String c_name;
	private String c_id;
	private String c_email;
	private String c_pass;
	
	
	public FindInfo(){}


	public FindInfo(String c_name, String c_id, String c_email, String c_pass) {
		super();
		this.c_name = c_name;
		this.c_id = c_id;
		this.c_email = c_email;
		this.c_pass = c_pass;
	}


	public String getC_name() {
		return c_name;
	}


	public void setC_name(String c_name) {
		this.c_name = c_name;
	}


	public String getC_id() {
		return c_id;
	}


	public void setC_id(String c_id) {
		this.c_id = c_id;
	}


	public String getC_email() {
		return c_email;
	}


	public void setC_email(String c_email) {
		this.c_email = c_email;
	}


	public String getC_pass() {
		return c_pass;
	}


	public void setC_pass(String c_pass) {
		this.c_pass = c_pass;
	}


	@Override
	public String toString() {
		return "Find [c_name=" + c_name + ", c_id=" + c_id + ", c_email=" + c_email + ", c_pass=" + c_pass + "]";
	}


}


