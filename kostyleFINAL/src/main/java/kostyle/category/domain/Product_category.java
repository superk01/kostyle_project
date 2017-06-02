package kostyle.category.domain;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Product_category implements Serializable{
    
    private String product_link = ""; //臾쇨굔 留곹겕媛�
    //臾쇨굔 �꽕紐낃컪
    private String product_name = "";//臾쇨굔 �씠由꾧컪
    private String product_price = "";//臾쇨굔 湲덉븸 媛�
    private String product_ImageLink = "";//臾쇨굔 �씠誘몄� 留곹겕媛�
    private String product_shopurl = "";
    private String product_shopname="";
    
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
	
	public Product_category(String product_shopurl, String product_link, String product_name, String product_price, String product_ImageLink) {
		super();
		this.product_link = product_link;
		this.product_name = product_name;
		this.product_price = product_price;
		this.product_ImageLink = product_ImageLink;
		this.product_shopurl = product_shopurl;
		this.setProduct_shopname(searchshopname(product_shopurl));
	}
	
	public String searchshopname(String product_shopurl){
		//shopurl濡� �눥�븨紐� �씠由� 李얠븘�빞�븿
		String name = "";
		if(product_shopurl.indexOf("www.stylenanda.com") != -1 ){
			name = "�뒪���씪�궃�떎";
		}else if(product_shopurl.indexOf("www.66girls.co.kr") != -1){
			name = "�쑁�쑁嫄몄쫰";
		}else if(product_shopurl.indexOf("ggsing.com") != -1){
			name = "怨좉퀬�떛";
		}else if(product_shopurl.indexOf("imvely.com") != -1){
			name = "�엫釉붾━";
		}else if(product_shopurl.indexOf("loveloveme.com") != -1){
			name = "�윭釉뚮윭釉뚮��";
		}else if(product_shopurl.indexOf("hotping.co.kr") != -1){
			name = "�빂�븨";
		}else if(product_shopurl.indexOf("www.dejou.co.kr") != -1){
			name = "�뜑�뜲�씠利�";
		}
		return name;
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
