/*package kostyle.closet.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import kostyle.closet.domain.Closet;
import kostyle.closet.service.ClosetService;

@RestController
@RequestMapping("/closetfolder")
public class ClosetFolderController {
	
	@Inject
	private ClosetService service;
	
	
	@RequestMapping(value="/all/{bno}", method=RequestMethod.GET)
	public ResponseEntity<List<ReplyVO>> list(@PathVariable("bno") Integer bno){
		ResponseEntity<List<ReplyVO>> entity = null;
		
		try{
			entity = new ResponseEntity<>(service.listReply(bno), HttpStatus.OK);
			
		}catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	 * 
	
	@RequestMapping(value="/CDSessionAttribute" , method=RequestMethod.POST)
	public ResponseEntity<List<Closet>> CDSessionAttribute(HttpServletRequest request){
		ResponseEntity<List<Closet>> entity = null;
		System.out.println("실제세션함수진입!");
		HttpSession session = request.getSession();
		List<Closet> closetTab = new ArrayList<Closet>();
		
		//지울때는 이름과 삭제여부만존재. value는 create쪽 진입해서 선언.
		String attriName = request.getParameter("attriName");
		String attriCD = request.getParameter("attriCD");
		System.out.println(attriCD);
		
		if(attriCD.equals("delete")){
			System.out.println("deleteSessionAttri진입");
			session.removeAttribute(attriName);
			System.out.println("session.removeAttribute(attriName);");
		}else if(attriCD.equals("create")){
			System.out.println("createSessionAttri진입");
		
			String attriValue = request.getParameter("attriValue");
		
		 // Pattern p = Pattern.compile("(^[+-]?\\d+)(\\d{3})"); //정규표현식 
	      Pattern p1 = Pattern.compile("(clo_num=)(\\d*)[^,]"); //정규표현식 
	      Matcher m1 = p1.matcher(attriValue); 

	      Pattern p2 = Pattern.compile("(clo_name=)[^]]*"); //정규표현식 
	      Matcher m2 = p2.matcher(attriValue); 
	      
	      Pattern p3 = Pattern.compile("(c_num=)[^,]*"); //정규표현식 
	      Matcher m3 = p3.matcher(attriValue); 
	      
	      List<Integer> clo_nums = new ArrayList<Integer>();
	      List<String> clo_names = new ArrayList<String>();
	      String c_num = "";
	      
	      while(m1.find()){
	    	  int clo_num;
	    	  	//System.out.println("매치되는 clo_num찾음.");
				String temp = m1.group(); //매칭된부분 전체반환
				temp = temp.trim();
				temp = temp.replaceAll("clo_num=", "");
				clo_num = Integer.parseInt(temp);
				System.out.println("list객체에 넣을 clo_num=" +clo_num);
				clo_nums.add(clo_num);
		  }
	      
	      while(m2.find()){
	    	  //System.out.println("매치되는 clo_name찾음.");
	    	  String clo_name = m2.group(); 
	    	  clo_name = clo_name.trim();
	    	  clo_name = clo_name.replaceAll("clo_name=", "");
	    	 System.out.println("list객체에 넣을 clo_name:" +clo_name);
	    	  clo_names.add(clo_name);
	      }
	      if(m3.find()){
	    	  //System.out.println("매치되는 c_num찾음.");
	    	  c_num = m3.group();
	    	  c_num = c_num.trim();
	    	  c_num = c_num.replaceAll("c_num=", "");
	    	  System.out.println("변환한 c_num: "+c_num);
	      }
	      
	      if(clo_nums.size() == clo_names.size()){
	    	  System.out.println("clo_nums.size == clo_names.size");
	    	  for(int i=0; i<clo_nums.size(); i++){
	    		  closetTab.add(new Closet(clo_nums.get(i),c_num,clo_names.get(i)));
	    		  System.out.println("closetTab정보: "+closetTab);
	    	  }
	      }
	      
	      for(int i=0; i<closetTab.size(); i++){
	    	  System.out.println(closetTab.get(i));
	      }
		//System.out.println("List변환: value: "+attriValue);
		if(attriValue instanceof List){
			attriValue = (List)request.getAttribute("attriValue");
			System.out.println("변환한attriValue: "+attriValue);
		}
		
	      //최종목적인 세션에 저장. foreach작동하도록.
			session.setAttribute(attriName, closetTab);
			System.out.println("session.setAttribute(attriName, closetTab)실행");
			System.out.println("값: "+session.getAttribute("closetTab"));
	}	

		try{
			entity = new ResponseEntity<>((List<Closet>)session.getAttribute(attriName), HttpStatus.OK);
			
		}catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	@RequestMapping(value="/SaveCloset" , method=RequestMethod.POST)
	public ResponseEntity<List<Closet>> SaveCloset(HttpServletRequest request){
		ResponseEntity<List<Closet>> entity = null;
		ClosetDao dao = ClosetDao.getInstance();
		Closet closet = new Closet();
		HttpSession session = request.getSession();
		
		int re = -1;
		
		//받은값 : clo_nums 문자열
		System.out.println("request.getParameter_clo_nums값: "+request.getParameter("folder_clo_nums"));
		String folder_clo_nums = request.getParameter("folder_clo_nums");
		System.out.println("request.getParameter_폴더이름값: "+request.getParameter("closet_titles"));
		String closet_titles= request.getParameter("closet_titles");
		System.out.println("Save클로젯액션의 folder_clo_nums: "+folder_clo_nums);
		System.out.println("Save클로젯액션의 closet_titles: "+closet_titles);
		
		//배열 제대로된 형태로.
		String[] folder_clo_numArray = folder_clo_nums.split(",");
		String[] closet_titleArray = closet_titles.split(",");
		
		String c_num = (String)session.getAttribute("c_num");
		System.out.println("SaveCloset보낼c_num: "+c_num);
		
		int maxClo_num = dao.max_clo_num(c_num); 
		
		List<Integer> pWin_clo_numList = dao.cNumTocloNum(c_num); //c_num으로 얻어온 clo_num리스트
		System.out.println("구해온 parentWin_clo_numList: "+pWin_clo_numList);
		
	//1빠로 폴더삭제부터.
	//먼저 dao에서 c_num으로 clo_num을 싹가져오게한다음에 비교 후 일치하면 dao쪽의 값을-1로 변경(-1인것은 DB에남고,아닌것은삭제)
		//삭제해야할것은 정확히 값이 남아야함+삭제하지않을것은 DB에접근하지않기때문에 숫자를바꿔도 상관없으니
		if(pWin_clo_numList.size() >= folder_clo_numArray.length){
			for(int i=0; i<pWin_clo_numList.size(); i++){
				for(int j=0; j<folder_clo_numArray.length; j++){
					if(pWin_clo_numList.get(i) == Integer.parseInt(folder_clo_numArray[j])){
						pWin_clo_numList.set(i, -1); 
						break; //?? 왜 j루프탈출?
					}
				}
			}
		}else{ //pWin_clo_numList의 clo_num갯수가 folder에서 받아온 clo_num갯수보다 작을경우
			for(int i=0; i<folder_clo_numArray.length; i++){
				for(int j=0; j<pWin_clo_numList.size(); j++){
					if(Integer.parseInt(folder_clo_numArray[i]) == pWin_clo_numList.get(j)){
						pWin_clo_numList.set(j, -1);
						break;
					}
				}
			}
		}
		
		for(int i=0; i<pWin_clo_numList.size(); i++){
			if(pWin_clo_numList.get(i) != -1){//-1인 것은 DB에 남아있어야하고, 아닌것은 삭제해야.
				Closet tempCloset = new Closet();
				int re1 = -1; //결과알아볼 int값. 서로 다른 값을 준건 오류시 어디가 안되었는지보려고.
				int re2 = -2;
				tempCloset.setC_num(c_num);
				tempCloset.setClo_num(pWin_clo_numList.get(i));
				
				re1 = dao.deleteSameCloset_prds(tempCloset);
				re2 = dao.deleteCloset(tempCloset);
				System.out.println("폴더삭제결과값 PRDre1= "+re1+"Closet re2= "+re2);
			}
		}
	
	//폴더추가와 폴더이름수정
		if(folder_clo_numArray.length == closet_titleArray.length){
			closet.setC_num(c_num);//어차피c_num은 동일
			
			
			for(int i=0; i<folder_clo_numArray.length; i++){
				//해당사용자의 c_num으로 조회해온 옷장번호의 제일큰값보다 작으면 수정, 크면 추가
				if(Integer.parseInt(folder_clo_numArray[i]) <= maxClo_num){
					System.out.println("clo_numArray쪼개기: "+folder_clo_numArray[i]);
					System.out.println("closet_titleArray쪼개기: "+closet_titleArray[i]);
					closet.setClo_num(Integer.parseInt(folder_clo_numArray[i]));
					closet.setClo_name(closet_titleArray[i]);
					re = dao.updateCloset(closet);
				}else{
					//maxClo_num보다 큰 폴더가 있다면 '폴더 새로 추가'
					closet.setClo_num(Integer.parseInt(folder_clo_numArray[i]));
					closet.setClo_name(closet_titleArray[i]);
					closet.setC_num((String)session.getAttribute("c_num"));
					System.out.println("새로 생성할 옷장카테고리정보: "+closet);
					re = dao.insertCloset(closet);
					System.out.println("insert결과re: "+re);
				}
			
		}
	}

}
	}
	
	
}//class
*/