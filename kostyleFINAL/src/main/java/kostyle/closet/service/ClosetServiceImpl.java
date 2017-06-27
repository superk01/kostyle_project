package kostyle.closet.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kostyle.closet.domain.Closet;
import kostyle.closet.domain.ClosetPrd;
import kostyle.closet.persistence.ClosetDAO;
import kostyle.closet.persistence.ClosetDAOImpl;
import kostyle.login.controller.CusLoginController;
import kostyle.login.domain.CustomerVO;

@Service
public class ClosetServiceImpl implements ClosetService {
	
	@Inject
	ClosetDAO dao;
	
	private static final Logger logger= LoggerFactory.getLogger(ClosetServiceImpl.class);

	//폴더설정 창(자식창) 닫을때 session에서 제거이벤트. 열 때와비슷.  -ok
	@Override
	public List<Closet> cdSessionAttribute(HttpServletRequest request, Map<Object,Object> param) {
		System.out.println("실제세션함수진입!");
		HttpSession session = request.getSession();
		List<Closet> closetTab = new ArrayList<Closet>();
		
		//지울때는 이름과 삭제여부만존재. value는 create쪽 진입해서 선언.
		String attriName = (String)param.get("attriName"); //"delete"시 "cloestTab"들어있음.
		String attriCD = (String)param.get("attriCD"); // create or delete
		System.out.println(attriCD);
		
		if(attriCD.equals("delete")){
			System.out.println("deleteSessionAttri진입");
			session.removeAttribute(attriName);
			System.out.println("session.removeAttribute(attriName);");
		}else if(attriCD.equals("create")){
			System.out.println("createSessionAttri진입");
		
			//String attriValue = request.getParameter("attriValue");
			String attriValue = (String)param.get("attriValue");
		
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
		/*if(attriValue instanceof List){
			attriValue = (List)request.getAttribute("attriValue");
			System.out.println("변환한attriValue: "+attriValue);
		}*/
		
      //최종목적인 세션에 저장. foreach작동하도록.
			session.setAttribute(attriName, closetTab);
			System.out.println("session.setAttribute(attriName, closetTab)실행");
			System.out.println("값: "+session.getAttribute("closetTab"));
	}	
		return closetTab;
	}

	
	//처음 클릭해서 옷장에 들어왔을 때  -ok
	@Override
	public Map closet(HttpServletRequest request, Map<Object,Object> param) {
		System.out.println("serviceImpl의 closet함수진입");
		ClosetPrd closetPrd = new ClosetPrd();
		HttpSession session = request.getSession();
		List<ClosetPrd> cloList = new ArrayList<ClosetPrd>();
		List<Closet> cloTab= new ArrayList<Closet>();
		Map map = new HashMap();
		
			request.removeAttribute("select_clo_num"); //일단 비워야 이전값이 남지않음.
			System.out.println("클로젯액션의 clo_num은? : "+param.get("clo_num"));
//			System.out.println("클로젯액션의 clo_num은? : "+request.getParameter("clo_num"));
			
		if(param.get("clo_num").equals("0")){
				//if(param.getClo_num()==0){
				
				System.out.println("ClosetAction clo_num == full진입");
				closetPrd.setC_num(((CustomerVO) session.getAttribute("login")).getC_num());
				System.out.println("보낸 ClosetPrd정보: "+closetPrd);
				cloList = dao.fullCloset(closetPrd);
				System.out.println("받은 옷장: "+cloList);
				
				//우선 DB에서 closetPrd리스트를 받은 후에, 해당하는 상품의 옷장이름도 추가해야함.
				for(int i=0; i<cloList.size(); i++){
					Closet closet = new Closet();
					closet.setC_num(cloList.get(i).getC_num());
					closet.setClo_num(cloList.get(i).getClo_num());
					String clo_name = dao.cloNumTocloName(closet);
					System.out.println("받아온 clo_name: "+ clo_name);
					cloList.get(i).setClo_name(clo_name);
				}
				
				request.setAttribute("select_clo_num", "0");//전체옷장의 번호는 0으로지정.
				map.put("select_clo_num", "0");
		
				
			}else{
				System.out.println("ClosetAction clo_num != full진입");
				System.out.println("셀렉터클로젯액션의 c_num: "+ session.getAttribute("c_num"));
				closetPrd.setC_num(((CustomerVO) session.getAttribute("login")).getC_num());
//				closetPrd.setClo_num(Integer.parseInt(request.getParameter("clo_num")));		
				closetPrd.setClo_num(Integer.parseInt((String)param.get("clo_num")));		
				//closetPrd.setClo_num(param.getClo_num());		
				System.out.println("셀렉터클로젯액션 보낸closetPrd: "+closetPrd);
				cloList = dao.selectCloset(closetPrd);
				System.out.println("받은 옷장: "+cloList);
				//우선 DB에서 closetPrd리스트를 받은 후에, 해당하는 상품의 옷장이름도 추가해야함.
				for(int i=0; i<cloList.size(); i++){
					Closet closet = new Closet();
					closet.setC_num(cloList.get(i).getC_num());
					closet.setClo_num(cloList.get(i).getClo_num());
					String clo_name = dao.cloNumTocloName(closet);
					System.out.println("받아온 clo_name: "+ clo_name);
					cloList.get(i).setClo_name(clo_name);
				}
				
				//request.setAttribute("select_clo_num", request.getParameter(("clo_num"))+"");
				request.setAttribute("select_clo_num", param.get("clo_num")+"");
				map.put("select_clo_num", param.get("clo_num")+"");
				//request.setAttribute("select_clo_num", param.getClo_num());
				//map.put("select_clo_num", param.getClo_num());
			}
			//최초실행시 전체옷장으로 진입하게했지만, 무한대로 실행되는 것을 끊기위해
			request.setAttribute("trig", "not");
			System.out.println("action에서의 trig값: "+request.getAttribute("trig"));
			//cloTab = dao.closetList(session.getAttribute("c_num").toString());
			cloTab = dao.closetList(((CustomerVO) session.getAttribute("login")).getC_num());
			System.out.println("받은 탭리스트: "+cloTab);

			request.setAttribute("cloList", cloList);
			request.setAttribute("closetTab", cloTab);
			map.put("cloList", cloList);
			map.put("closetTab", cloTab);

			//map에보낸값: "select_clo_num", "cloList" = List<ClosetPrd>, "cloTab" = List<Closet> 
			return map;
		}
		
	

	//옷장(폴더)전체추출 ->없앰. closet에서 분기해서 통일
	@Override
	public void tabCloset(HttpServletRequest request, Map<Object,Object> param) {
		Closet closet= new Closet();
		HttpSession session = request.getSession();
		List<Closet> cloTab= new ArrayList<Closet>();
		
		request.setAttribute("cloTab", "");
	}

/*	//선택한 옷장만 보이게
	@Override
	public void selectCloset(HttpServletRequest request) {
		// TODO Auto-generated method stub
		
	}*/

	//실제로 폴더변경사항 적용.
	@Override
	public void saveCloset(HttpServletRequest request, Map<Object,Object> param) {
		Closet closet = new Closet();
		HttpSession session = request.getSession();
		
		int re = -1;
		
		//받은값 : clo_nums 문자열
		System.out.println("request.getParameter_clo_nums값: "+(String)param.get("folder_clo_nums"));
//		String folder_clo_nums = request.getParameter("folder_clo_nums");
		String folder_clo_nums = (String)param.get("folder_clo_nums");
		System.out.println("request.getParameter_폴더이름값: "+ (String)param.get("closet_titles"));
//		String closet_titles= request.getParameter("closet_titles");
		String closet_titles= (String)param.get("closet_titles");
		System.out.println("Save클로젯액션의 folder_clo_nums: "+folder_clo_nums);
		System.out.println("Save클로젯액션의 closet_titles: "+closet_titles);
		
		//배열 제대로된 형태로.
		String[] folder_clo_numArray = folder_clo_nums.split(",");
		String[] closet_titleArray = closet_titles.split(",");
		
		String c_num = ((CustomerVO) session.getAttribute("login")).getC_num();
		System.out.println("SaveCloset보낼c_num: "+c_num);
		
		int maxClo_num = dao.max_clo_num(c_num); 
		
		List<Integer> pWin_clo_numList = dao.cNumTocloNum(c_num); //c_num으로 얻어온 clo_num리스트
		System.out.println("구해온 parentWin_clo_numList: "+pWin_clo_numList);
		
	//1빠로 폴더삭제부터.
	//먼저 dao에서 c_num으로 clo_num을 싹가져오게한다음에 비교 후 일치하면 dao쪽의 값을-1로 변경(-1인것은 DB에남고,아닌것은삭제)
		//삭제해야할것은 정확히 값이 남아야함+삭제하지않을것은 DB에접근하지않기때문에 숫자를바꿔도 상관없으니 -1로.
		if(pWin_clo_numList.size() >= folder_clo_numArray.length){
			for(int i=0; i<pWin_clo_numList.size(); i++){
				for(int j=0; j<folder_clo_numArray.length; j++){
					if(pWin_clo_numList.get(i) == Integer.parseInt(folder_clo_numArray[j])){
						pWin_clo_numList.set(i, -1); 
						break; //하나만 일치하면되는데 일치했으니 안쪽 루프탈출.
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
				
				//int->void변경부분
				dao.deleteSameCloset_prds(tempCloset);
				dao.deleteCloset(tempCloset);
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
					//int->void변경부분
					dao.updateCloset(closet);
				}else{
					//maxClo_num보다 큰 폴더가 있다면 '폴더 새로 추가'
					closet.setClo_num(Integer.parseInt(folder_clo_numArray[i]));
					closet.setClo_name(closet_titleArray[i]);
					closet.setC_num(((CustomerVO) session.getAttribute("login")).getC_num());
					System.out.println("새로 생성할 옷장카테고리정보: "+closet);
					//int->void변경부분
					dao.insertCloset(closet);
					System.out.println("insert결과re: "+re);
				}
			
		}
	}

}

		
	
//-------------------------------------------------------------------------
	// 찜상품추가(추가하면서 다른사람의 같은상품 찜카운트도 변동시켜야함. 트랜잭션연동.)
	@Transactional
	@Override
	public int insertPrd(HttpServletRequest request, Map<Object,Object> param) {
		ClosetPrd closetPrd = this.insertPrdSub(request, param);
		String clo_prdUrl = (String)param.get("prdUrl");
		System.out.println("service transaction의 clo_prdUrl: "+clo_prdUrl);
		
		clo_prdUrl = dao.prdUrlRepair(clo_prdUrl);
		ClosetPrd tempPrd = new ClosetPrd();
		tempPrd.setClo_prdUrl(clo_prdUrl);
		int clo_zzim = dao.count_zzim(tempPrd) ;
		int re = dao.insertClosetPrd(closetPrd);
		clo_zzim +=1;
		tempPrd.setClo_zzim(clo_zzim);
		dao.zzimIncreaseTransaction(tempPrd); //http:붙여서보내도 알아서 떼고 검색함.
		return re;
	}
	
	//찜상품추가시 실제적으로 일하는 함수
	@Override
	public ClosetPrd insertPrdSub(HttpServletRequest request, Map<Object, Object> param) {
		ClosetPrd closetPrd = new ClosetPrd();
		HttpSession session = request.getSession();
		List<ClosetPrd> cloList = new ArrayList<ClosetPrd>();
		List<Closet> cloTab= new ArrayList<Closet>();
		
		//1.prdUrl 정상으로 냅두고 해시맵을 구한 후에, http://잘라야함.
	//	String clo_prdUrl = request.getParameter("prdUrl");
		String clo_prdUrl = (String)param.get("prdUrl");
		
		//5. clo_price , imgUrl , prdName
			/*
			hash.put("imgUrl", imgUrl);
			hash.put("price", price);
			hash.put("prdName", prdName); 한 결과를 넘겨받음.*/
		HashMap hash = dao.urlRepair(clo_prdUrl);
		String clo_price = (String) hash.get("price");
		String clo_imgUrl = (String) hash.get("imgUrl");
		/*String clo_prdName = (String) hash.get("prdName");*/
		String clo_prdName = (String)param.get("prdName");
		System.out.println("받아온 해시맵clo_price: "+clo_price);
		System.out.println("받아온 해시맵imgUrl: "+clo_imgUrl);
		System.out.println("받아온 해시맵 prdName: "+clo_prdName);
		
		//2.s_sname
		String shopUrl = dao.getShopUrl(clo_prdUrl);
		System.out.println("InsertClosetPrd얻어온 shopUrl: "+shopUrl);
		String s_sname =dao.getS_name(shopUrl);
		System.out.println("InsertClosetPrd얻어온 s_sname: "+s_sname);
		
		
		//4.clo_detail_num생성
		int max_detail_num = dao.max_detail_num();
		System.out.println("구해온 max_detail_num: "+max_detail_num);
		
		//마지막-1.prdUrl의 http://자르기(순서상 다른것들 구한 후에 해야함.)
		clo_prdUrl = dao.prdUrlRepair(clo_prdUrl);
		System.out.println("InsertClosetPrd의 prdUrl: "+clo_prdUrl);
		

		//6. 미친건지.. c_num이 인식이 안된다! Integer로 잡혀서 일단은 인티저->스트링으로 변환
		System.out.println("c_num변환: "+ (String)((CustomerVO) session.getAttribute("login")).getC_num());
		String c_num = (String)((CustomerVO) session.getAttribute("login")).getC_num();
		//String c_num =(String)request.getSession().getAttribute("c_num");
		//System.out.println("c_num캐스팅...테스트 String "+c_num);
		
		
		
		//마지막.zzim갯수(순서상 prdUrl가공 후에 해야함. prdUrl과 c_num이 들은 ClosetPrd객체 필요)
		closetPrd.setC_num(c_num);
		closetPrd.setClo_prdUrl(clo_prdUrl);		
		int count_zzim = dao.count_zzim(closetPrd) +1; //자기자신포함위해 +1
		
		
		closetPrd.setClo_detail_num(max_detail_num +1);
		closetPrd.setClo_imgUrl(clo_imgUrl);
		closetPrd.setClo_prdName(clo_prdName);
		closetPrd.setClo_price(clo_price); 
		closetPrd.setS_sname(s_sname); //db조회하는것 나중에 xml파일엮으면 그때. 지금은 일단 함수로.
		closetPrd.setClo_zzim(count_zzim); //만약 hit가 조회가안된다면 기본은 0.
		
		closetPrd.setClo_num(1); //사실 무조건 1(기본폴더) db자동입력 .
		//closetPrd.setClo_date(clo_date); 날짜는 안해도된다. sysdate로 db자동입력.
		//이걸 다 해야!!! 추가할 수 있음!!
		
		System.out.println("현재까지 완성된 clostPrd: "+closetPrd);
		
		return closetPrd;
	}

		
	

	//찜추가시 중복체크 void
	@Override
	public int duplicationCheckClosetPrd(HttpServletRequest request, String prdUrl) {
		System.out.println("실제액션클래스: DuplicationCheckClosetPrdAction진입");
		ClosetPrd closetPrd = new ClosetPrd();
		HttpSession session = request.getSession();
		int dupliCount = -1;

		//6.  c_num
		System.out.println("c_num변환: "+ (String)((CustomerVO) session.getAttribute("login")).getC_num());
		String c_num = ((CustomerVO) session.getAttribute("login")).getC_num();
		//System.out.println("c_num캐스팅...테스트 String "+c_num);
		
		//prdUrl의 http://자르기(순서상 다른것들 구한 후에 해야함.)
		prdUrl = (String)dao.prdUrlRepair(prdUrl);
		System.out.println("자른 prdUrl: "+prdUrl);
		closetPrd.setClo_prdUrl(prdUrl);
		closetPrd.setC_num(c_num);
		
		System.out.println("dupllicationCheck 보낼 closetPrd값: "+closetPrd);
		System.out.println("받은 dupliCount: "+dupliCount);
		
		return dao.check_duplication(closetPrd);
	}

		

	//상품의 폴더이동 void -ok
	@Override
	public void moveClosetPrd(HttpServletRequest request, Map<Object,Object> param) {
		//var param = "clo_detail_nums="+clo_detail_nums+"&move_clo_num="+move_clo_num+"&clo_num="+clo_num;
		ClosetPrd closetPrd = new ClosetPrd();
		HttpSession session = request.getSession();
//		int move_clo_num = Integer.parseInt(request.getParameter("move_clo_num"));
		int move_clo_num = Integer.parseInt((String)param.get("move_clo_num"));
		
		//넘어오는 값 : clo_detail_nums, move_clo_num
//		String clo_detail_nums = (String)request.getParameter("clo_detail_nums");
		String clo_detail_nums = (String)param.get("clo_detail_nums");
		System.out.println("Move클로젯Prd액션의 clo_detail_nums: "+clo_detail_nums);
//		System.out.println("Move클로젯Prd액션의 move_clo_num: "+request.getParameter("move_clo_num"));
		System.out.println("Move클로젯Prd액션의 move_clo_num: "+param.get("move_clo_num"));
		
		closetPrd.setClo_num(move_clo_num);
		closetPrd.setC_num(((CustomerVO) session.getAttribute("login")).getC_num());
		
		String[] clo_detail_numArray = clo_detail_nums.split(",");
		for(int i=0; i<clo_detail_numArray.length; i++){
			System.out.println("clo_detail_numArray쪼개기: "+clo_detail_numArray[i]);
			closetPrd.setClo_detail_num(Integer.parseInt(clo_detail_numArray[i]));
			System.out.println("MoveClosetPrd 보낼 prd정보: "+closetPrd);
			dao.moveClosetPrd(closetPrd);
		}
	}
		


	//상품삭제 void-ok
	@Transactional
	@Override
	public void deleteClosetPrd(HttpServletRequest request, Map<Object,Object> param){
		//var param = "clo_detail_nums="+clo_detail_nums+"&clo_num="+clo_num;
		ClosetPrd closetPrd = new ClosetPrd();

		//받은값 : clo_detail_nums 문자열
//		String clo_detail_nums = (String)request.getParameter("clo_detail_nums");
		String clo_detail_nums = (String)param.get("clo_detail_nums");
		System.out.println("Delete클로젯Prd액션의 clo_detail_nums: "+clo_detail_nums);
		System.out.println("Delete클로젯Prd액션의 clo_num: "+param.get("clo_num"));
		
		String[] clo_detail_numArray = clo_detail_nums.split(",");

		for(int i=0; i<clo_detail_numArray.length; i++){
			int clo_detail_num = Integer.parseInt(clo_detail_numArray[i]);
			System.out.println("clo_detail_numArray쪼개기: "+clo_detail_num);
			dao.zzimDecreaseTransaction(clo_detail_num);
			dao.deleteClosetPrd(clo_detail_num);
			
		}
		
	}


	
	
}//class



