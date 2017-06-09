package kostyle.category.bo;

import java.util.HashMap;
import java.util.Map;

import kostyle.category.domain.Weather;
import kostyle.category.domain.WeatherSearch;

public class Weather_pick_keyword {
	
	private int level = 0;
	private int user_bb = 0;
	private String user_type = "";
	private int result = 0;
	public String getWeather_pick_Data(Weather weather, String User_type){
		this.user_type = User_type;
				// 불쾌지수에 따라 각 조건 충족시 level 1상승
				// 80이상 더위 잘탐
				// 75~80미만 더위 조금 타는편
				// 68~75미만 더위 안타는편
				// 사용자 성향 체크하고 체감온도에서 옷 구하기
				// 만약 불쾌지수가 68 이상이면 사용자 성향에 따라 옷 레벨 증가
				// 옷 레벨 = 옷 타입
				//체감온도 13.12 + 0.6215 x T - 11.37v^0.16 + 0.3965v^0.16 x T			
				//불쾌지수 1.8t-0.55(1-rh)(1.8t-26)+32
				
			
				double t = weather.getTemp();
				double vms = weather.getWind_ms();
				double v2 = weather.getVher();
				
				double v = vms*3600/1000;					
				double oo= 13.12 + 0.6215 * t - 11.37 * Math.pow(v, 0.16) + 0.3965 * Math.pow(v, 0.16) * t; 		
				double bb = (1.8*t)-(0.55*(1-v2/100)*(1.8*t-26))+32;	
				
				//
				System.out.println("체감온도 :" + oo + " 불쾌지수 : " + bb);
				//소숫점 두자리부터 정수까지 반올림
				level = (int) mathRound2(oo);
				user_bb = (int) mathRound2(bb);
				//체감온도, 불쾌지수, 사용자 타입으로  온도레벨 생성
				int User_level = getUserLevel(level, user_bb, User_type);
				
				//온도 레벨에따른 옷 키워드 
		return getWeather_pick_keyword(User_level);
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
	
	public String getWeather_pick_keyword(int User_level){
		
	
		return "맨투맨";
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
