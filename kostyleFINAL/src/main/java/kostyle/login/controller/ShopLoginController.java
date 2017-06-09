package kostyle.login.controller;

import java.util.Date;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kostyle.login.domain.AdShopVO;
import kostyle.login.domain.CustomerVO;
import kostyle.login.domain.LoginDTO;
import kostyle.login.service.LoginService;

@Controller
@RequestMapping("/shoplogin")
public class ShopLoginController {
	@Inject
	private LoginService service;
	private static final Logger logger= LoggerFactory.getLogger(CusLoginController.class);

	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String loginGET(@ModelAttribute("dto") LoginDTO dto, Model model){
		model.addAttribute("dto", dto);
		
		return "/login/tempLoginShop";
	}
	
	@RequestMapping(value="/loginCheck", method=RequestMethod.POST)
	public String loginPOST(@ModelAttribute LoginDTO dto,  HttpSession session, Model model) throws Exception{
		
		System.out.println("샵로그인컨트롤러 보낸 LoginDTO: "+dto);

		AdShopVO vo = service.shopLogin(dto);
		System.out.println("샵로그인컨트롤러 받은 AdShopVO: "+vo);
		
		if(vo == null){ // null이라면 회원이 아님.
			System.out.println("로그인실패");
			//request.setAttribute("msg", "회원 아이디 또는 비밀번호가 일치하지 않습니다.(5회 이상 로그인 오류시 본인확인 후 로그인 가능합니다.)");
			return "/login/tempLoginShop";
		}
		
		//----------
		if(dto.isUseCookie()){ //로그인성공_자동로그인체크되어있으면
			System.out.println("로그인성공.컨트롤러>");
			int oneweek = 60 * 60 * 24 * 7;
			Date sessionLimit = new Date(System.currentTimeMillis()+(1000*oneweek)); //   1/1000초니까 *1000
			System.out.println("keepCuLoginLimit에 보내는값- vo.getAd_id():  "+vo.getAd_id()+"   /  session.getId(): "+session.getId());
			service.keepShopLoginLimit(vo.getAd_id(), session.getId(),sessionLimit);
		}
		
		model.addAttribute("dto",dto);
		model.addAttribute("userVO", vo);

		System.out.println("loginCheck인데 설마 postHandle다 뜬다음에 또 뜨는거 아니죠?");
		return "/login/loginCheck";
		
	}
	

	@ResponseBody
	@RequestMapping(value="/logout")
	public String logout(@RequestParam("returnPath") String returnPath, HttpServletRequest  request )throws Exception{
		
		System.out.println("shopLogout진입");
		System.out.println("shopLogout returnPath= "+returnPath);
		request.getSession().removeAttribute("shoplogin");
		
		String refererPath = request.getHeader("referer");
		System.out.println("referer값: "+request.getHeader("referer"));

		
		returnPath = returnPath.trim();
		String path = "redirect:" + returnPath;
		System.out.println("로그아웃최종경로: "+path);
		/*ModelAndView mav = new ModelAndView();

		RedirectView redirectView = new RedirectView(); // redirect url 설정
		redirectView.setUrl(path);
		redirectView.setExposeModelAttributes(false);

		mav.setView(redirectView);

		return mav;
*/
		return "SUCCESS";
	}
	
	
	
	
}//class
