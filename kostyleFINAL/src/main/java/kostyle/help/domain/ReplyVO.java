package kostyle.help.domain;

import java.sql.Date;

public class ReplyVO {
	private String as_Num;
	private String as_Content;
	private String as_Title;
	private Date as_Date;
	private String c_Id;
	private int q_Num;
	
	public ReplyVO(){}

	public ReplyVO(String as_Num, String as_Content, String as_Title, Date as_Date, int q_Num, String c_Id) {
		super();
		this.as_Num = as_Num;
		this.as_Content = as_Content;
		this.as_Title = as_Title;
		this.as_Date = as_Date;
		this.q_Num = q_Num;
		this.c_Id = c_Id;
	}

	public String getC_Id() {
		return c_Id;
	}

	public void setC_Id(String c_Id) {
		this.c_Id = c_Id;
	}

	public String getAs_Num() {
		return as_Num;
	}

	public void setAs_Num(String as_Num) {
		this.as_Num = as_Num;
	}

	public String getAs_Content() {
		return as_Content;
	}

	public void setAs_Content(String as_Content) {
		this.as_Content = as_Content;
	}

	public String getAs_Title() {
		return as_Title;
	}

	public void setAs_Title(String as_Title) {
		this.as_Title = as_Title;
	}

	public Date getAs_Date() {
		return as_Date;
	}

	public void setAs_Date(Date as_Date) {
		this.as_Date = as_Date;
	}

	public int getQ_Num() {
		return q_Num;
	}

	public void setQ_Num(int q_Num) {
		this.q_Num = q_Num;
	}

	@Override
	public String toString() {
		return "ReplyVO [as_Num=" + as_Num + ", as_Content=" + as_Content + ", as_Title=" + as_Title + ", as_Date="
				+ as_Date + ", c_Id=" + c_Id + ", q_Num=" + q_Num + "]";
	}

	
	
}
