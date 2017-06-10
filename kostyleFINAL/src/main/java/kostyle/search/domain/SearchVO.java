package kostyle.search.domain;

import java.io.Serializable;

public class SearchVO implements Serializable{
	private String product_name;
	private String product_price;
	private String product_ImageLink;
	private String product_shopurl;
	private String product_shopname;
	private String product_color;
	private String product_link;
	private String product_keyword;
	
	
	public SearchVO() {
		super();
	}

	
	
	public SearchVO(String product_ImageLink, String product_link, String product_price, String product_name) {
		super();
		this.product_ImageLink = product_ImageLink;
		this.product_link = product_link;
		this.product_price = product_price;
		this.product_name = product_name;
	}
	public SearchVO(String product_ImageLink, String product_link, String product_price, String product_name, String product_color) {
		super();
		this.product_ImageLink = product_ImageLink;
		this.product_link = product_link;
		this.product_price = product_price;
		this.product_name = product_name;
		this.product_color = product_color;
	}
	
	public SearchVO(String product_name, String product_price, String product_ImageLink, String product_shopurl,
			 String product_color, String product_link, String product_keyword) {
		super();
		this.product_name = product_name;
		this.product_price = product_price;
		this.product_ImageLink = product_ImageLink;
		this.product_shopurl = product_shopurl;
		this.product_color = product_color;
		this.product_link = product_link;
		this.product_keyword = product_keyword;
	}



	public String getProduct_shopurl() {
		return product_shopurl;
	}



	public void setProduct_shopurl(String product_shopurl) {
		this.product_shopurl = product_shopurl;
	}



	public String getProduct_shopname() {
		return product_shopname;
	}



	public void setProduct_shopname(String product_shopname) {
		this.product_shopname = product_shopname;
	}



	public String getProduct_keyword() {
		return product_keyword;
	}



	public void setProduct_keyword(String product_keyword) {
		this.product_keyword = product_keyword;
	}



	public String getProduct_ImageLink() {
		return product_ImageLink;
	}


	public void setProduct_ImageLink(String product_ImageLink) {
		this.product_ImageLink = product_ImageLink;
	}


	public String getProduct_link() {
		return product_link;
	}


	public void setProduct_link(String product_link) {
		this.product_link = product_link;
	}


	public String getProduct_price() {
		return product_price;
	}


	public void setProduct_price(String product_price) {
		this.product_price = product_price;
	}


	public String getProduct_name() {
		return product_name;
	}


	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}



	public String getProduct_color() {
		return product_color;
	}



	public void setProduct_color(String product_color) {
		this.product_color = product_color;
	}



	@Override
	public String toString() {
		return "SearchVO [product_name=" + product_name + ", product_price=" + product_price + ", product_ImageLink="
				+ product_ImageLink + ", product_shopurl=" + product_shopurl + ", product_shopname=" + product_shopname
				+ ", product_color=" + product_color + ", product_link=" + product_link + ", product_keyword="
				+ product_keyword + "]";
	}

	

}
