package kostyle.search.domain;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.plaf.synth.SynthSeparatorUI;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class GetColorThread extends Thread {
	private String colorList;
	private String path;
	
	public GetColorThread(){};
	
	public GetColorThread(String path) {
		this.path = path;
		this.colorList = colorList;
	}

	public String getColorList() {
		return colorList;
	}

	public void setColorList(String colorList) {
		this.colorList = colorList;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	@Override
	public void run() {
		
		
		List<String> list = new ArrayList<>();
	
		try {
			
			/*System.out.println("path:"+path);*/
			Document doc = Jsoup.connect(path).get();
			/*System.out.println("doc객체 출력:"+doc);*/
			Elements optionEl = doc.select(".ProductOption0 option");
		/*	System.out.println("optionEl:"+optionEl);*/
			for(int i=0; i<optionEl.size(); i++){
				list.add(optionEl.get(i).html());
			}
			/*System.out.println("색상값 추출:"+list);*/
			
			String reg = "[ㄱ-ㅎ가-힣]{1,5}";
			Pattern pattern = Pattern.compile(reg);										
			
			List<String> list1 = new ArrayList<>();
			for(int i=0; i<list.size(); i++){
				Matcher matcher = pattern.matcher(list.get(i));
				while(matcher.find()){																//위에서 지정한 가격을 뽑는 정규표현식과 매칭되는 것이 있다면?
					/*System.out.println("한글만 나오는지?: "+matcher.group());								//표현이 매칭되는 문자열을 출력하고,
*/					list1.add(matcher.group());														//list에 추가
				}		
			}
		
			List<String> list2 = new ArrayList<String>(new LinkedHashSet<String>(list1));
			System.out.println("중복제거 list:"+list2);
			for(int i=0; i<list2.size(); i++){
				colorList += list2.get(i);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
/*--------------------------------------메인 메소드-------------------------------------------------*/	
	
public static void main(String[] args) {
		String path = "hotping.co.kr/product/detail.html?product_no=15930&cate_no=29&display_group=1";
		GetColorThread thread = new GetColorThread(path);
		thread.run();
	}
	
	
}
