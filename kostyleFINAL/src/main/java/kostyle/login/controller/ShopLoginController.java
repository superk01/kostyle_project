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
	public String loginGET(@ModelAttribute("dto") LoginDTO dto){
		return "/login/tempLoginShop";
	}
	
	@RequestMapping(value="/loginPost", method=RequestMethod.POST)
	public void loginPOST(LoginDTO dto, HttpSession session, Model model) throws Exception{
		
		System.out.println("샵로그인컨트롤러 보낸 LoginDTO: "+dto);

		AdShopVO vo = service.shopLogin(dto);
		System.out.println("샵로그인컨트롤러 받은 AdShopVO: "+vo);
		
		if(vo == null){ // null이라면 회원이 아님.
			return;
		}
		
		model.addAttribute("userVO", vo);
		
	}
	
	
}//class
