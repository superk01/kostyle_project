package kostyle.category.bo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

public class SubActionThread extends Thread{ 
	private String productURL;
	private String product_color = "None";
	
	
	
	public String getProductURL() {
		return productURL;
	}



	public void setProductURL(String productURL) {
		this.productURL = productURL;
	}



	public String getProduct_color() {
		return product_color;
	}



	public void setProduct_color(String product_color) {
		this.product_color = product_color;
	}



	@Override
	public void run(){
		 try {
	         URL url = new URL("http://" +productURL);
	         System.out.println("연결중....url = " + productURL);
	         URLConnection con = url.openConnection();
	         BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
	         String tmp;

	         while ((tmp = br.readLine()) != null) {
	        	 String searchValue = "<option value=";
	        	 int tmp_indexOf = tmp.indexOf(searchValue);
	        	 if( tmp.indexOf("additional") != -1){
	        		 break;
	        	 }else if(tmp.indexOf("xans-element- xans-product xans-product-addproduct productSet") != -1){
	        		break; 
	        	 }else if(tmp_indexOf != -1){
	        		 System.out.println(tmp);
        			product_color += tmp.replaceAll("[^가-힣]", "");
	        	 }
	         }
	      } catch (Exception e) {
	         e.printStackTrace();
	      }finally{
	    	  System.out.println("완료");
	      }
	}
}
