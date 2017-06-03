package kostyle.help.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import kostyle.help.domain.BoardVO;
import kostyle.help.domain.Criteria;
import kostyle.help.domain.PageMaker;
import kostyle.help.domain.SearchCriteria;
import kostyle.help.service.BoardService;

@RestController
@RequestMapping("/help/*")
public class HelpBoardController {
	
	@Inject
	private BoardService service;
	
	@RequestMapping(value="list", method=RequestMethod.GET)
	public ModelAndView list(@ModelAttribute("cri") SearchCriteria cri, HttpServletRequest request)throws Exception {
		ModelAndView mav = new ModelAndView();								//페이지 이동 및 데이터 전달을 위한 ModelAndView객체
		HttpSession session = request.getSession();							//비밀글 사용시 사용자를 확인하기 위해 세션을 사용.
		Object userVO = session.getAttribute("login");						//더 정확히는 세션의 login값!!!
		System.out.println("HelpController-list():"+userVO);
		mav.addObject("list", service.list(cri,session));					//세션을 전달하면 리스트를 받아올 때 비밀글들을 구분할 수 있음.
		
		PageMaker maker = new PageMaker();									//페이징 처리를 위한 객체(책의 내용과 동일하다.)		
		maker.setCri(cri);													//초기의 페이지 세팅.
		maker.setTotalCount(service.totalCount());							//모들 글 개수를 카운팅하여 페이지를 계산한다.
		System.out.println("HelpController-Page87Maker:"+maker);
		System.out.println("HelpController-Criteria:"+cri);
		mav.addObject("pageMaker", maker);									//데이터 전달.
		mav.setViewName("/help/list");										//view(view/help/list.jsp)로 이동
		return mav;															//리턴
	}//list()
	@RequestMapping(value="insert", method=RequestMethod.GET)
	public ModelAndView insertGET()throws Exception{						//글입력을 위한 폼으로 이동하는 메소드.
		ModelAndView mav = new ModelAndView();
		mav.addObject("list", service.adShoppingMallList());				//글 입력폼에 쇼핑몰들의 리스트가 사용되기 때문에 쇼핑몰들의 리스트를 넘겨준다.
		/*mav.setViewName("help/insert");*/									//요청주소가 따로 없으면 "컨트롤러가 받은 요청주소.jsp"를 찾아가기 때문에 주석처리
		return mav;															//리턴
		
	}//insertGET()
	@RequestMapping(value="insert", method=RequestMethod.POST)
	public void insertPOST(@ModelAttribute BoardVO boardVO, HttpServletResponse response, HttpSession session)throws Exception{
		System.out.println(boardVO);										//폼에서 받아온 데이터를 데이터베이스에 넣는 메소드
		service.insert(boardVO,session);											//디비에 데이터 입력
		response.sendRedirect("/help/list");								//list메소드로 이동
	}
	@RequestMapping(value="detail", method=RequestMethod.GET)
	public ModelAndView detail(@RequestParam("q_num") int q_Num, HttpSession session)throws Exception{
		ModelAndView mav = new ModelAndView();								//각 글의 상세내용을 보여주는 메소드
		/*System.out.println("HelpController:"+q_Num);
		System.out.println("HelpController:"+service.detail(q_Num,session));*/
		BoardVO boardVO = service.detail(q_Num, session);					//boardVO객체를 하나 가져옴.
		if(boardVO != null){												//비밀글인 경우에 권한 없는 사용자가 접근하면 boardVO객체를 반환하지 않음.
			mav.addObject("board", boardVO);								//따라서, boardVO객체가 null이 아니면 글 읽기가 가능
/*			return mav;*/
		}else{																//null이면 다른 페이지로 이동.
			mav.setViewName("/help/secret");								
		}
		return mav;
	}
	@RequestMapping(value="update", method=RequestMethod.GET)
	public ModelAndView updateGET(@RequestParam("q_Num") int q_Num, HttpSession session)throws Exception{
		ModelAndView mav = new ModelAndView();
		mav.addObject("board", service.detail(q_Num,session));
		System.out.println(service.detail(q_Num, session));
		return mav;
	}
	@RequestMapping(value="update", method=RequestMethod.POST)
	public void updatePOST(BoardVO boardVO, HttpServletResponse response)throws Exception{
		System.out.println(boardVO);
		service.update(boardVO);
		response.sendRedirect("/help/list");
	}
	@RequestMapping(value="remove", method=RequestMethod.GET)
	public void delete(@RequestParam("q_Num") int q_Num, HttpServletResponse response)throws Exception{
		System.out.println("delete");
		service.delete(q_Num);
		response.sendRedirect("/help/list");
	}
	
}
