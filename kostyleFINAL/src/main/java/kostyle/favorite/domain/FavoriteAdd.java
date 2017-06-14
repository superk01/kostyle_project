package kostyle.favorite.domain;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

public class FavoriteAdd implements Serializable{
	
	private Timestamp f_date;
	private String f_num;
	private String f_coment;
	private String s_num;
	private String c_num;
	
	
	public FavoriteAdd(){}


	public FavoriteAdd(Timestamp f_date, String f_num, String f_coment, String s_num, String c_num) {
		super();
		this.f_date = f_date;
		this.f_num = f_num;
		this.f_coment = f_coment;
		this.s_num = s_num;
		this.c_num = c_num;
	}


	public Timestamp getF_date() {
		return f_date;
	}


	public void setF_date(Timestamp f_date) {
		this.f_date = f_date;
	}


	public String getF_num() {
		return f_num;
	}


	public void setF_num(String f_num) {
		this.f_num = f_num;
	}


	public String getF_coment() {
		return f_coment;
	}


	public void setF_coment(String f_coment) {
		this.f_coment = f_coment;
	}


	public String getS_num() {
		return s_num;
	}


	public void setS_num(String s_num) {
		this.s_num = s_num;
	}


	public String getC_num() {
		return c_num;
	}


	public void setC_num(String c_num) {
		this.c_num = c_num;
	}


	@Override
	public String toString() {
		return "FavoriteAdd [f_date=" + f_date + ", f_num=" + f_num + ", f_coment=" + f_coment + ", s_num=" + s_num
				+ ", c_num=" + c_num + "]";
	}



}


