package kostyle.login.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
	public void loginPOST(LoginDTO dto, HttpServletRequest request ,Model model) throws Exception{
		
		System.out.println("샵로그인컨트롤러 보낸 LoginDTO: "+dto);

		AdShopVO vo = service.shopLogin(dto);
		System.out.println("샵로그인컨트롤러 받은 AdShopVO: "+vo);
		
		if(vo == null){ // null이라면 회원이 아님.
			//request.setAttribute("msg", "회원 아이디 또는 비밀번호가 일치하지 않습니다.(5회 이상 로그인 오류시 본인확인 후 로그인 가능합니다.)");
			return;
		}
		
		model.addAttribute("dto",dto);
		model.addAttribute("userVO", vo);

		
	}
	

	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String logout(HttpSession session)throws Exception{
		
		session.removeAttribute("login");
		
		String dest = (String)session.getAttribute("dest");
		System.out.println("로그아웃후dest경로: "+dest);
		return dest;
	}
	
}//class
