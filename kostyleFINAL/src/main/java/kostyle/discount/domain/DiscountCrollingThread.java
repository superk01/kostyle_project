package kostyle.discount.domain;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

public class DiscountCrollingThread extends Thread {
	
	private String path;
	private List<DiscountVO> resultVOList;
	
	public DiscountCrollingThread(){}
	
	public DiscountCrollingThread(String path){
		this.path = path;
		resultVOList = new ArrayList<DiscountVO>();
	}
	

	

	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}

	public List<DiscountVO> getResultVOList(){
		return resultVOList;
	}
	public void setResultVOList(List<DiscountVO> resultVOList) {
		this.resultVOList = resultVOList;
	}

	@Override
	public String toString() {
		return "DiscountCrollingThread [path=" + path + ", resultVOList=" + resultVOList + "]";
	}

	@Override
	public void run() {
	}
	
	

	
	
	/*		//자바의 줄바꿈은 시스템마다 달라진다. 현재 운영체제의 줄바꿈 문자 얻는법.
		String line = System.getProperty("line.separator");
		System.out.println("dao에서 받은 prdUrl: "+prdUrl);

		//String address="http://66girls.co.kr/product/detail.html?product_no=67185&cate_no=81&display_group=2";
		//String address="http://hotping.co.kr/product/detail.html?product_no=19218&cate_no=26&display_group=1";
		
		//String address2= "http://66girls.co.kr/product/search.html?banner_action=&keyword=%EA%B0%80%EB%94%94%EA%B1%B4";
		//address2 = URLDecoder.decode(address2);
		//System.out.println("디코딩된 값: "+address2);
		
		URL url =null;
		BufferedReader br =null;
		String imgUrl ="";
		String price="";
		String prdName="";
		try {
			url = new URL(prdUrl);
			URLConnection con = url.openConnection(); 
			br = new BufferedReader(new InputStreamReader(url.openStream()));
		    String code;
			StringBuffer sb = new StringBuffer();

			while((code=br.readLine())!=null){
				sb.append(code+line); // 문자열을 합칠 때 append가 속도가 빠름
			}
			code = sb.substring(0);
			
			
				imgUrl = getImgURL(code); 
				price = getPrice(code);
				prdName = "";
			
			} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if( br !=null){
					br.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
 */
	
	
}
