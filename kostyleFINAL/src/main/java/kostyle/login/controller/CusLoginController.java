package kostyle.login.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kostyle.login.domain.CustomerVO;
import kostyle.login.domain.LoginDTO;
import kostyle.login.service.LoginService;

@Controller
@RequestMapping("/cuslogin")
public class CusLoginController {
	
	@Inject
	private LoginService service;
	
	private static final Logger logger= LoggerFactory.getLogger(CusLoginController.class);
	
	@RequestMapping(value="/login")
	public String login(@ModelAttribute("dto") LoginDTO dto, Model model){
		model.addAttribute("dto", dto);

		return "/login/tempLoginCustomer";
/*		return "/login/loginCustomer";
*/
	}
	
	@RequestMapping(value="/loginCheck", method=RequestMethod.POST)
	public void loginCheck(@ModelAttribute LoginDTO dto, HttpSession session, Model model) throws Exception{
		
		System.out.println("cus로그인컨트롤러 보낸 LoginDTO: "+dto);

		CustomerVO vo = service.cusLogin(dto);
		System.out.println("cus로그인컨트롤러 받은 CustomerVO: "+vo);
		
		if(vo == null){ // null이라면 회원이 아님.
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
