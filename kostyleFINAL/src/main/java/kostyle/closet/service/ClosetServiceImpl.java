package kostyle.closet.service;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import kostyle.closet.domain.Closet;
import kostyle.closet.domain.ClosetPrd;
import kostyle.closet.persistence.ClosetDAO;
import kostyle.closet.persistence.ClosetDAOImpl;
import kostyle.login.controller.CusLoginController;

@Service
public class ClosetServiceImpl implements ClosetService {
	@Inject
	ClosetDAO dao;
	
	private static final Logger logger= LoggerFactory.getLogger(CusLoginController.class);

	
	@Override
	public void CDSessionAttribute() {
		// TODO Auto-generated method stub
		
	}

	
	//처음 클릭해서 옷장에 들어왔을 때
	@Override
	public void Closet(HttpServletRequest request) {
		ClosetPrd closetPrd = new ClosetPrd();
		HttpSession session = request.getSession();
		List<ClosetPrd> cloList = new ArrayList<ClosetPrd>();
		List<Closet> cloTab= new ArrayList<Closet>();

			request.removeAttribute("select_clo_num"); //일단 비워야 이전값이 남지않음.
			System.out.println("클로젯액션의 clo_num은? : "+request.getParameter("clo_num"));
			
			if(request.getParameter("clo_num").equals("0")){
				
				System.out.println("ClosetAction clo_num == full진입");
				closetPrd.setC_num((String)session.getAttribute("c_num"));
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
				
				request.setAttribute("select_clo_num", "0");
				
		
				
			}else{
				System.out.println("ClosetAction clo_num != full진입");
				closetPrd.setC_num((String)session.getAttribute("c_num"));
			
				System.out.println("셀렉터클로젯액션의 c_num: "+ session.getAttribute("c_num"));
				closetPrd.setC_num((String)session.getAttribute("c_num"));
				closetPrd.setClo_num(Integer.parseInt(request.getParameter("clo_num")));		
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
				
				request.setAttribute("select_clo_num", request.getParameter(("clo_num"))+"");
				
				//List<ClosetPrd> cloList = dao.selectCloset(closetPrd);
			}
			//최초실행시 전체옷장으로 진입하게했지만, 무한대로 실행되는 것을 끊기위해
			request.setAttribute("trig", "not");
			System.out.println("action에서의 trig값: "+request.getAttribute("trig"));
			//cloTab = dao.closetList(session.getAttribute("c_num").toString());
			cloTab = dao.closetList((String)session.getAttribute("c_num"));
			System.out.println("받은 탭리스트: "+cloTab);

			request.setAttribute("cloList", cloList);
			request.setAttribute("closetTab", cloTab);
			
			forward.setRedirect(false);
			forward.setPath("main/template.jsp?body=../closet/closet.jsp");
		}
		
	
		//----------------
		
		/*List<Board> list = dao.listBoard(search);
		   request.setAttribute("list", list);
		   
		   ActionForward forward = new ActionForward();
		  forward.setRedirect(false);
		  forward.setPath("/list.jsp");*/
		
	}

	//옷장(폴더)전체추출
	@Override
	public void TabCloset() {
		ClosetDao dao = ClosetDao.getInstance();
		Closet closet= new Closet();
		HttpSession session = request.getSession();
		ActionForward forward = new ActionForward();
		List<Closet> cloTab= new ArrayList<Closet>();
		
		request.setAttribute("cloTab", "");

		return forward;
		
	}

	//선택한 옷장만 보이게
	@Override
	public void SelectCloest() {
		// TODO Auto-generated method stub
		
	}

	//실제로 폴더변경사항 적용.
	@Override
	public void SaveCloset() {
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

	// 찜상품추가
	@Override
	public void InsertPrd() {
		ClosetDao dao = ClosetDao.getInstance();
		ClosetPrd closetPrd = new ClosetPrd();
		HttpSession session = request.getSession();
		ActionForward forward = new ActionForward();
		List<ClosetPrd> cloList = new ArrayList<ClosetPrd>();
		List<Closet> cloTab= new ArrayList<Closet>();
		int re = -1;
		
		//1.prdUrl 정상으로 냅두고 해시맵을 구한 후에, http://잘라야함.
		String clo_prdUrl = request.getParameter("prdUrl");
		
		//5. clo_price , imgUrl , prdName
			/*
			hash.put("imgUrl", imgUrl);
			hash.put("price", price);
			hash.put("prdName", prdName); 한 결과를 넘겨받음.*/
		HashMap hash = dao.urlRepair(clo_prdUrl);
		String clo_price = (String) hash.get("price");
		String clo_imgUrl = (String) hash.get("imgUrl");
		String clo_prdName = (String) hash.get("prdName");
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
		System.out.println("c_num변환: "+ request.getSession().getAttribute("c_num").toString());
		String c_num = request.getSession().getAttribute("c_num").toString();
		//String c_num =(String)request.getSession().getAttribute("c_num");
		//System.out.println("c_num캐스팅...테스트 String "+c_num);
		
		
		
		//마지막.zzim갯수(순서상 prdUrl가공 후에 해야함. prdUrl과 c_num이 들은 ClosetPrd객체 필요)
		closetPrd.setC_num(c_num);
		closetPrd.setClo_prdUrl(clo_prdUrl);		
		int count_zzim = dao.count_zzim(closetPrd) +1; //자기자신포함위해 +1
		
		
		closetPrd.setClo_detail_num(max_detail_num +1);
		closetPrd.setClo_imgUrl(clo_imgUrl);
		closetPrd.setClo_prdName("임시상품명");
		closetPrd.setClo_price(clo_price); 
		closetPrd.setS_sname(s_sname); //db조회하는것 나중에 xml파일엮으면 그때. 지금은 일단 함수로.
		closetPrd.setClo_zzim(count_zzim); //만약 hit가 조회가안된다면 기본은 0.
		
		closetPrd.setClo_num(1); //사실 무조건 1(기본폴더) db자동입력 .
		//closetPrd.setClo_date(clo_date); 날짜는 안해도된다. sysdate로 db자동입력.
		//이걸 다 해야!!! 추가할 수 있어!!
		
		System.out.println("현재까지 완성된 clostPrd: "+closetPrd);
		re = dao.insertClosetPrd(closetPrd);
		
		try {
			//에이작스에 보낼 데이터 심기.
			response.getWriter().print(re);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

		
	}

	//찜추가시 중복체크
	@Override
	public void DuplicationCheckClosetPrd() {
		System.out.println("실제액션클래스: DuplicationCheckClosetPrdAction진입");
		ClosetDao dao = ClosetDao.getInstance();
		ClosetPrd closetPrd = new ClosetPrd();
		HttpSession session = request.getSession();
		int dupliCount = -1;

		//6. 미친건지.. c_num이 인식이 안된다! Integer로 잡혀서 일단은 인티저->스트링으로 변환
		System.out.println("c_num변환: "+ request.getSession().getAttribute("c_num").toString());
		String c_num = session.getAttribute("c_num").toString();
		//String c_num =(String)request.getSession().getAttribute("c_num");
		//System.out.println("c_num캐스팅...테스트 String "+c_num);
		
		String prdUrl = request.getParameter("prdUrl");
		//prdUrl의 http://자르기(순서상 다른것들 구한 후에 해야함.)
		prdUrl = dao.prdUrlRepair(prdUrl);
		System.out.println("자른 prdUrl: "+prdUrl);
		closetPrd.setClo_prdUrl(prdUrl);
		
		closetPrd.setC_num(c_num);
		
		System.out.println("dupllicationCheck 보낼 closetPrd값: "+closetPrd);
		
		dupliCount = dao.check_duplication(closetPrd);
		System.out.println("받은 dupliCount: "+dupliCount);
		
		try {
			//에이작스에 보낼 데이터 심기.
			response.getWriter().print(dupliCount);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

		
	}

	//상품의 폴더이동
	@Override
	public void MoveClosetPrd() {
		ClosetDao dao = ClosetDao.getInstance();
		ClosetPrd closetPrd = new ClosetPrd();
		HttpSession session = request.getSession();
		ActionForward forward = new ActionForward();
		int re = -1;
		int move_clo_num = Integer.parseInt(request.getParameter("move_clo_num"));
		
		//넘어오는 값 : clo_detail_nums, move_clo_num
		String clo_detail_nums = (String)request.getParameter("clo_detail_nums");
		System.out.println("Move클로젯Prd액션의 clo_detail_nums: "+clo_detail_nums);
		System.out.println("Move클로젯Prd액션의 move_clo_num: "+request.getParameter("move_clo_num"));
		
		closetPrd.setClo_num(move_clo_num);
		closetPrd.setC_num((String)session.getAttribute("c_num"));
		
		String[] clo_detail_numArray = clo_detail_nums.split(",");
		for(int i=0; i<clo_detail_numArray.length; i++){
			System.out.println("clo_detail_numArray쪼개기: "+clo_detail_numArray[i]);
			closetPrd.setClo_detail_num(Integer.parseInt(clo_detail_numArray[i]));
			System.out.println("MoveClosetPrd 보낼 prd정보: "+closetPrd);
			re = dao.moveClosetPrd(closetPrd);
			
		}
	}

		
	}


	//상품삭제
	@Override
	public void DeleteClosetPrd() {
		ClosetDao dao = ClosetDao.getInstance();
		ClosetPrd closetPrd = new ClosetPrd();
		HttpSession session = request.getSession();
		ActionForward forward = new ActionForward();
		int re = -1;

		//받은값: clo_detail_nums 배열
	/*	String[] clo_detail_numArray = request.getParameterValues("clo_detail_nums");
		System.out.println("String배열 clo_detail_numArray: "+clo_detail_numArray);
		for(int i=0; i<clo_detail_numArray.length; i++){
			System.out.println("for문진입+실행중인clo_detail_num: "+clo_detail_numArray[i]);
			
			re = dao.deleteClosetPrd(Integer.parseInt(clo_detail_numArray[i]));
			if( re > 0){
				forward.setRedirect(true);
				forward.setPath("ClosetAction.closet");
			}else{
				request.setAttribute("msg", "오류가 발생했습니다. re: "+re);
				forward.setRedirect(true);
				forward.setPath("ClosetAction.closet");
			}
		}*/
		
		//받은값 : clo_detail_nums 문자열
		String clo_detail_nums = (String)request.getParameter("clo_detail_nums");
		System.out.println("Delete클로젯Prd액션의 clo_detail_nums: "+clo_detail_nums);
		System.out.println("Delete클로젯Prd액션의 clo_num: "+request.getParameter("clo_num"));
		
		String[] clo_detail_numArray = clo_detail_nums.split(",");

		for(int i=0; i<clo_detail_numArray.length; i++){
			System.out.println("clo_detail_numArray쪼개기: "+clo_detail_numArray[i]);
			re = dao.deleteClosetPrd(Integer.parseInt(clo_detail_numArray[i]));
			
		}

	}

		
	}


	
	
	
	
	
}//class



