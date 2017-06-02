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
import kostyle.help.service.BoardService;

@RestController
@RequestMapping("/help/*")
public class HelpController {
	
	@Inject
	private BoardService service;
	
	@RequestMapping(value="list", method=RequestMethod.GET)
	public ModelAndView list(@ModelAttribute("cri") Criteria cri, HttpServletRequest request)throws Exception {
		ModelAndView mav = new ModelAndView();
		HttpSession session = request.getSession();
		Object userVO = session.getAttribute("login");
		System.out.println("HelpController-list():"+userVO);
		mav.addObject("list", service.list(cri,session));
		
		PageMaker maker = new PageMaker();
		maker.setCri(cri);
		maker.setTotalCount(service.totalCount());
		System.out.println("HelpController-PageMaker:"+maker);
		System.out.println("HelpController-Criteria:"+cri);
		mav.addObject("pageMaker", maker);
		mav.setViewName("/help/list");
		return mav;
	}
	@RequestMapping(value="insert", method=RequestMethod.GET)
	public ModelAndView insertGET()throws Exception{
		ModelAndView mav = new ModelAndView();
		mav.addObject("list", service.adShoppingMallList());
		/*mav.setViewName("help/insert");*/
		return mav;
		
	}
	@RequestMapping(value="insert", method=RequestMethod.POST)
	public void insertPOST(@ModelAttribute BoardVO boardVO, HttpServletResponse response)throws Exception{
		System.out.println(boardVO);
		service.insert(boardVO);
		response.sendRedirect("/help/list");
	}
	@RequestMapping(value="detail", method=RequestMethod.GET)
	public ModelAndView detail(@RequestParam("q_num") int q_Num, HttpSession session)throws Exception{
		ModelAndView mav = new ModelAndView();
		System.out.println("HelpController:"+q_Num);
		System.out.println("HelpController:"+service.detail(q_Num,session));
		mav.addObject("board", service.detail(q_Num,session));
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
