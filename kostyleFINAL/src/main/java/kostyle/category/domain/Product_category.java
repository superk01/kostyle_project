package kostyle.category.domain;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Product_category implements Serializable{
    
    private String product_link = ""; 
    private String product_name = "";
    private String product_price = "";
    private String product_ImageLink = "";
    private String product_shopurl = "";
    private String product_shopname="";
    private String product_color="None";
    private String product_keyword ="";
    
    
	public String getProduct_color() {
		return product_color;
	}
	public void setProduct_color(String product_color) {
		this.product_color = product_color;
	}
	public String getProduct_link() {
		return product_link;
	}
	public void setProduct_link(String product_link) {
		this.product_link = product_link;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public String getProduct_price() {
		return product_price;
	}
	public void setProduct_price(String product_price) {
		this.product_price = product_price;
	}
	public String getProduct_ImageLink() {
		return product_ImageLink;
	}
	public void setProduct_ImageLink(String product_ImageLink) {
		this.product_ImageLink = product_ImageLink;
	}
	
	public Product_category(String product_shopurl, String product_link, String product_name, String product_price, String product_ImageLink, String keyword) {
		super();
		this.product_link = product_link;
		this.product_name = product_name;
		this.product_price = product_price;
		this.product_ImageLink = product_ImageLink;
		this.product_shopurl = product_shopurl;
		this.setProduct_shopname(searchshopname(product_shopurl));
		this.product_keyword = keyword;
	}
	
	public String getProduct_shopurl() {
		return product_shopurl;
	}
	public void setProduct_shopurl(String product_shopurl) {
		this.product_shopurl = product_shopurl;
	}
	public String searchshopname(String product_shopurl){
		//
		String name = "";
		if(product_shopurl.indexOf("www.stylenanda.com") != -1 ){
			name = "스타일난다";
		}else if(product_shopurl.indexOf("www.66girls.co.kr") != -1){
			name = "66걸즈";
		}else if(product_shopurl.indexOf("ggsing.com") != -1){
			name = "고고싱";
		}else if(product_shopurl.indexOf("imvely.com") != -1){
			name = "임블리";
		}else if(product_shopurl.indexOf("loveloveme.com") != -1){
			name = "러브러브미";
		}else if(product_shopurl.indexOf("hotping.co.kr") != -1){
			name = "핫핑";
		}else if(product_shopurl.indexOf("www.dejou.co.kr") != -1){
			name = "더데이즈";
		}
		return name;
	}
	
	
	
	public String getProduct_keyword() {
		return product_keyword;
	}
	public void setProduct_keyword(String product_keyword) {
		this.product_keyword = product_keyword;
	}
	public Product_category(){}
	@Override
	public String toString() {
		return "Product [product_link=" + product_link + ", product_name=" + product_name + ", product_price="
				+ product_price + ", product_ImageLink=" + product_ImageLink + ", product_shopurl=" + product_shopurl
				+ "]";
	}
	public String getProduct_shopname() {
		return product_shopname;
	}
	public void setProduct_shopname(String product_shopname) {
		this.product_shopname = product_shopname;
	}

}
