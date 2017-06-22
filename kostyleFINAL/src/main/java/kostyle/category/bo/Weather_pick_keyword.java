package kostyle.category.bo;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import kostyle.category.domain.Weather;
import kostyle.category.domain.WeatherSearch;
import kostyle.category.service.CategoryService;

public class Weather_pick_keyword {

	private int level = 0;
	private int user_bb = 0;
	private String user_type = "";
	private int result = 0;
	public int[] getWeather_pick_Data(Weather weather, String User_type){
		this.user_type = User_type;
				double t = weather.getTemp();  //온도
				double vms = weather.getWind_ms(); //풍속
				double v2 = weather.getVher(); //습도
				
				double v = vms*3600/1000;	 //풍속 km으로 변환
				double oo= 13.12 + 0.6215 * t - 11.37 * Math.pow(v, 0.16) + 0.3965 * Math.pow(v, 0.16) * t;  //체감온도
				double bb = (1.8*t)-(0.55*(1-v2/100)*(1.8*t-26))+32;	 //불쾌지수
				
				level = (int) mathRound2(oo);
				user_bb = (int) mathRound2(bb);
				//체감온도, 불쾌지수, 사용자 타입으로  온도레벨 생성
				int User_level = getUserLevel(level, user_bb, User_type);
				int data[] = {User_level,level,user_bb};
				//온도 레벨에따른 옷 키워드 
		return data;
	}
	
	public int getUserLevel(int level, int User_bb, String User_type){
		String types[] = {"추위 잘 타는편","추위 조금 타는편","더위 조금 타는편", "더위 잘 타는편"};
		int User_type_level = 0;
		int level_plus_data = 0;
		
		for(int i=0; i<types.length; i++){
			if(User_type.equals(types[i])){
				if( i== 0){
					User_type_level = -2;
				}else if( i== 1){
					User_type_level = -1;
				}else if( i== 2){
					User_type_level = 1;
				}else if( i== 3){
					User_type_level = 2;
				}else{
					User_type_level = 0;
				}				
				break;
			}
		}
		
		if(User_bb >= 80){
			level_plus_data = 2;
		}else if( User_bb < 80 && User_bb >= 75 ){
			level_plus_data = 1;
		}else if( User_bb < 75 && User_bb >= 68){
			level_plus_data = 0;
		}else{
			level_plus_data = -1;
		}
		System.out.println("계산 시작 : " + level + "+" + level_plus_data + "+" +  User_type_level);
		int result = level + level_plus_data + User_type_level;
		System.out.println("결과 : " + result);
		this.result = result;
		return result;
	}
	
	public String getUser_angry(int User_bb){
		if(User_bb >= 80){
			return "전원 불쾌감을 느끼는 날씨입니다.";
		}else if( User_bb < 80 && User_bb >= 75 ){
			return "50%정도 불쾌감을 느끼는 날씨입니다.";
		}else if( User_bb < 75 && User_bb >= 68){
			return "불쾌감을 나타내는 날씨입니다.";
		}else{
			return "전원 쾌적함을 느끼는 날씨입니다.";
		}
	}
	
	public double mathRound2(double data){
		double bb = Math.round(data*10);
		double cc = bb/10;
		data = Math.round(cc);
		return data;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getUser_bb() {
		return user_bb;
	}

	public void setUser_bb(int user_bb) {
		user_bb = user_bb;
	}

	public String getUser_type() {
		return user_type;
	}

	public void setUser_type(String user_type) {
		this.user_type = user_type;
	}
}
