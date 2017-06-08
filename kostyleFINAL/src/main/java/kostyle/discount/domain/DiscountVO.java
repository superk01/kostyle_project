package kostyle.discount.domain;

import java.io.Serializable;

public class DiscountVO implements Serializable {
	private String sale_prdUrl;
	private String sale_imgUrl;
	private String sale_beforeDiscountprice;
	private String sale_afterDiscountprice;
	private String sale_name;
	private String s_sname;
	private int clo_zzim;
	
	public DiscountVO(){}

	public DiscountVO(String sale_prdUrl, String sale_imgUrl, String sale_beforeDiscountprice,
			String sale_afterDiscountprice, String sale_name, String s_sname, int clo_zzim) {
		super();
		this.sale_prdUrl = sale_prdUrl;
		this.sale_imgUrl = sale_imgUrl;
		this.sale_beforeDiscountprice = sale_beforeDiscountprice;
		this.sale_afterDiscountprice = sale_afterDiscountprice;
		this.sale_name = sale_name;
		this.s_sname = s_sname;
		this.clo_zzim = clo_zzim;
	}

	public String getSale_prdUrl() {
		return sale_prdUrl;
	}

	public void setSale_prdUrl(String sale_prdUrl) {
		this.sale_prdUrl = sale_prdUrl;
	}

	public String getSale_imgUrl() {
		return sale_imgUrl;
	}

	public void setSale_imgUrl(String sale_imgUrl) {
		this.sale_imgUrl = sale_imgUrl;
	}

	public String getSale_beforeDiscountprice() {
		return sale_beforeDiscountprice;
	}

	public void setSale_beforeDiscountprice(String sale_beforeDiscountprice) {
		this.sale_beforeDiscountprice = sale_beforeDiscountprice;
	}

	public String getSale_afterDiscountprice() {
		return sale_afterDiscountprice;
	}

	public void setSale_afterDiscountprice(String sale_afterDiscountprice) {
		this.sale_afterDiscountprice = sale_afterDiscountprice;
	}

	public String getSale_name() {
		return sale_name;
	}

	public void setSale_name(String sale_name) {
		this.sale_name = sale_name;
	}

	public String getS_sname() {
		return s_sname;
	}

	public void setS_sname(String s_sname) {
		this.s_sname = s_sname;
	}

	public int getClo_zzim() {
		return clo_zzim;
	}

	public void setClo_zzim(int clo_zzim) {
		this.clo_zzim = clo_zzim;
	}

	@Override
	public String toString() {
		return "DiscountVO [sale_prdUrl=" + sale_prdUrl + ", sale_imgUrl=" + sale_imgUrl + ", sale_beforeDiscountprice="
				+ sale_beforeDiscountprice + ", sale_afterDiscountprice=" + sale_afterDiscountprice + ", sale_name="
				+ sale_name + ", s_sname=" + s_sname + ", clo_zzim=" + clo_zzim + "]";
	}

	
	
}//class
