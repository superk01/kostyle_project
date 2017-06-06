package kostyle.login.controller;

import java.util.Date;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
	
	@RequestMapping(value="/preloginCus")
	public String preCus(){
//		return "/login/loginCustomer";
		return "/login/colorLogin";
		
	}
	@RequestMapping(value="/preloginShop")
	public String preShop(){
		return "/login/loginCustomer";
	}
	

	
	//로그인실패시 에러메시지 띄우기 추가해야함.
	@RequestMapping("/login")
	public String login(@ModelAttribute("dto") LoginDTO dto, Model model){
		model.addAttribute("dto", dto);
		return "/login/tempLoginCustomer";
/*		return "/login/loginCustomer";
*/
	}
	
	@RequestMapping(value="/loginCheck", method=RequestMethod.POST)
	public void loginCheck(@ModelAttribute LoginDTO dto,  HttpSession session, Model model) throws Exception{
		
		System.out.println("cus로그인컨트롤러 보낸 LoginDTO: "+dto);

		CustomerVO vo = service.cusLogin(dto);
		System.out.println("cus로그인컨트롤러 받은 CustomerVO: "+vo);
		
		if(vo == null){ // null이라면 회원이 아님.
			//request.setAttribute("msg", "회원 아이디 또는 비밀번호가 일치하지 않습니다.(5회 이상 로그인 오류시 본인확인 후 로그인 가능합니다.)");
			//postHandle에서 sednRedirect로보내서 전달안됨.
			return;
		}
		
		if(dto.isUseCookie()){ //로그인성공_자동로그인체크되어있으면
			System.out.println("로그인성공.컨트롤러>");
			int oneweek = 60 * 60 * 24 * 7;
			Date sessionLimit = new Date(System.currentTimeMillis()+(1000*oneweek)); //   1/1000초니까 *1000
			System.out.println("keepCuLoginLimit에 보내는값- vo.getC_id():  "+vo.getC_id()+"   /  session.getId(): "+session.getId());
			service.keepCusLoginLimit(vo.getC_id(), session.getId(),sessionLimit);
		}
		
		model.addAttribute("dto",dto);
		model.addAttribute("userVO", vo);
		
		System.out.println("loginCheck인데 설마 postHandle다 뜬다음에 또 뜨는거 아니죠?");
	}
	
	
	
//  이전url설정하면, /logout검사문 지우고 경로는 메인으로 가게 설정해야함...
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String logout(HttpServletRequest  request )throws Exception{
		
		request.getSession().removeAttribute("login");
		request.getSession().removeAttribute("shoplogin");
		
		String path = request.getHeader("referer");
		System.out.println("referer값: "+request.getHeader("referer"));
		if(request.getHeader("referer") == null){
			path = "redirect:/home/"; //이전url이 없을시, 메인으로 가도록.
			System.out.println("referer == null진입 + referer값: "+request.getHeader("referer"));
			//path = "redirect:/";
		}
		
		return path;
		
		/*String dest= null;
		String tempPath=(String)session.getAttribute("dest");
		if(tempPath.equals("/cuslogin/logout") || tempPath.equals("/shoplogin/logout") || tempPath==null){
			//"redirect:/board/listAll";
			dest="redirect:/home/";  
		}else{
			dest = (String)session.getAttribute("dest");
		}
		System.out.println("로그아웃후dest경로: "+dest);
		return dest;*/
	}
	
	//자동로그인은 customer와 shop을 한번에 같이만든다. 분기는 
	
}//class
