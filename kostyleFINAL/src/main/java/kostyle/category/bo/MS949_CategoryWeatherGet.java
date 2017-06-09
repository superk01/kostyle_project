package kostyle.category.bo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kostyle.category.domain.Weather;

public class MS949_CategoryWeatherGet {
	static String url_web = "http://www.kma.go.kr/weather/main.jsp";
	static Map<Integer,String> map = new HashMap<Integer,String>();
	
	public static Weather start(){
		map.put(01, "¸¼À½");
		map.put(02, "±¸¸§ Á¶±Ý");
		map.put(03, "±¸¸§ ¸¹À½");
		map.put(04, "Èå¸²");
		map.put(05, "ºñ");
		map.put(06, "´« ÀûÀ½, ºñ");
		map.put(07, "´« ¸¹À½, ºñ");
		map.put(10, "´«");
		
		List<String> list = new ArrayList<String>();
	   	double temp = 0;
		double wind_ms =0;
		double vher =0;
		double rainper =0;
		String weather = "";
		
		   try {
		         URL url = new URL(url_web);
		         URLConnection con = url.openConnection();
		         BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
		         String tmp;

		         int check_count = 0;
		         int check_close_div = 0;
		         while ((tmp = br.readLine()) != null) {
		            if( tmp.indexOf("wrap_weather_info") != -1 || check_count > 0){
		            	check_count ++;
		            	list.add(tmp);
		            	if(tmp.indexOf("</div>") != -1){
		            		check_close_div ++;
		            		if(check_close_div > 1){
		            			break;
		            		}
		            	}
		            }
		         }
		      } catch (Exception e) {
		         e.printStackTrace();
		      }
		   
		   for(String tmp : list){
			   if(tmp.indexOf("plus") != -1){
				   tmp = tmp.replaceAll("[^0-9]", "");
				   temp = Integer.parseInt(tmp);
			   }else if(tmp.indexOf("m/s") != -1){
				   tmp = tmp.replaceAll("[^0-9]", "");
				   wind_ms = Integer.parseInt(tmp);
			   }else if(tmp.indexOf("%") != -1){				 
				   tmp = tmp.replaceAll("[^0-9]", "");
				   vher = Integer.parseInt(tmp);
			   }else if(tmp.indexOf("°­¼ö·®") != -1){
				   System.out.println(tmp);
				   int index = tmp.indexOf("</strong>");
				   tmp = tmp.substring(index);
				   tmp = tmp.replaceAll("[^0-9]", "");
				   if(tmp.length() == 0){
					   tmp = "0";
				   }
				   rainper = Integer.parseInt(tmp);
			   }else if(tmp.indexOf("png25") != -1){
				   tmp = tmp.substring(0, tmp.indexOf("."));
				   tmp = tmp.replaceAll("[^0-9]", "");
				   Integer tmp_int = Integer.parseInt(tmp);
				   if(map.get(tmp_int) != null){
					   weather = map.get(tmp_int);
				   }else{
					   weather = map.get(10);
				   }
			   }
		   }
		   
		   Weather weatherVO = new Weather(temp, wind_ms, vher, rainper, weather);
		   System.out.println(weatherVO.toString());
		   return weatherVO;
	}
}
