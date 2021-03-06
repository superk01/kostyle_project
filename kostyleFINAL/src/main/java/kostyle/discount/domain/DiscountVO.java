package kostyle.discount.domain;

import java.io.Serializable;

public class DiscountVO implements Serializable {
	private String sale_prdUrl;
	private String sale_imgUrl;
	private String sale_beforeDiscountprice;
	private String sale_afterDiscountprice;
	private int sale_discountRate; //1+1할인표시를위해 String으로바꾼다. 할인율 비교가 필요할시에 Integer로 바꿀수 있는지 없는지부터 판별해야함
	private String sale_onePlusOne; 


	public String getSale_onePlusOne() {
		return sale_onePlusOne;
	}

	public void setSale_onePlusOne(String sale_onePlusOne) {
		this.sale_onePlusOne = sale_onePlusOne;
	}

	private String sale_name;
	private String s_sname;
	private int clo_zzim;
	
	public DiscountVO(){}

	public DiscountVO(String sale_prdUrl, String sale_imgUrl, String sale_beforeDiscountprice,
			String sale_afterDiscountprice, int sale_discountRate, String sale_onePlusOne, String sale_name, String s_sname) {
		super();
		this.sale_prdUrl = sale_prdUrl;
		this.sale_imgUrl = sale_imgUrl;
		this.sale_beforeDiscountprice = sale_beforeDiscountprice;
		this.sale_afterDiscountprice = sale_afterDiscountprice;
		this.sale_discountRate =sale_discountRate;
		this.sale_onePlusOne = sale_onePlusOne;
		this.sale_name = sale_name;
		this.s_sname = s_sname;

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

	public int getSale_discountRate() {
		return sale_discountRate;
	}

	public void setSale_discountRate(int sale_discountRate) {
		this.sale_discountRate = sale_discountRate;
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
				+ sale_beforeDiscountprice + ", sale_afterDiscountprice=" + sale_afterDiscountprice
				+ ", sale_discountRate=" + sale_discountRate + ", sale_onePlusOne=" + sale_onePlusOne + ", sale_name="
				+ sale_name + ", s_sname=" + s_sname + ", clo_zzim=" + clo_zzim + "]";
	}




	
	
}//class
