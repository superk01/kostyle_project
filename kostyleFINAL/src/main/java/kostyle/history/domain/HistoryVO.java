package kostyle.history.domain;

import java.io.Serializable;
import java.sql.Date;

public class HistoryVO implements Serializable{
	private String h_Num;
	private String c_Num;
	private String h_Name;
	private String h_Prdurl;
	private String h_Imgurl;
	private String h_Price;
	private Date h_Date;
	
	public HistoryVO(){}

	public HistoryVO(String h_Num, String c_Num, String h_Name, String h_Prdurl, String h_Imgurl, Date h_Date, String h_Price) {
		super();
		this.h_Num = h_Num;
		this.c_Num = c_Num;
		this.h_Name = h_Name;
		this.h_Prdurl = h_Prdurl;
		this.h_Imgurl = h_Imgurl;
		this.h_Date = h_Date;
		this.h_Price = h_Price;
	}

	public String getH_Num() {
		return h_Num;
	}

	public void setH_Num(String h_Num) {
		this.h_Num = h_Num;
	}

	public String getC_Num() {
		return c_Num;
	}

	public void setC_Num(String c_Num) {
		this.c_Num = c_Num;
	}

	public String getH_Name() {
		return h_Name;
	}

	public void setH_Name(String h_Name) {
		this.h_Name = h_Name;
	}

	public String getH_Prdurl() {
		return h_Prdurl;
	}

	public void setH_Prdurl(String h_Prdurl) {
		this.h_Prdurl = h_Prdurl;
	}

	public String getH_Imgurl() {
		return h_Imgurl;
	}

	public void setH_Imgurl(String h_Imgurl) {
		this.h_Imgurl = h_Imgurl;
	}

	public Date getH_Date() {
		return h_Date;
	}

	public void setH_Date(Date h_Date) {
		this.h_Date = h_Date;
	}

	public String getH_Price() {
		return h_Price;
	}

	public void setH_Price(String h_Price) {
		this.h_Price = h_Price;
	}

	@Override
	public String toString() {
		return "HistoryVO [h_Num=" + h_Num + ", c_Num=" + c_Num + ", h_Name=" + h_Name + ", h_Prdurl=" + h_Prdurl
				+ ", h_Imgurl=" + h_Imgurl + ", h_Price=" + h_Price + ", h_Date=" + h_Date + "]";
	}

	
}
