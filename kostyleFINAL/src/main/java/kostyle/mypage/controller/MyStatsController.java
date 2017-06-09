package kostyle.mypage.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import kostyle.login.controller.CusLoginController;
import kostyle.login.service.LoginService;
import kostyle.mypage.domain.MyCustomerVO;
import kostyle.mypage.service.MyCustomerService;

@Controller
@RequestMapping("/mypage/*")
public class MyStatsController {
	
	@Inject
	private MyCustomerService service;
	
	private static final Logger logger = LoggerFactory.getLogger(MyStatsController.class);
	
	
	@RequestMapping("/MypageMain")
	public String mypageMain() throws Exception{
				
		return "mypage/MypageMain";
		
	}
	
	@RequestMapping("/StatMain")
	public String StatMain() throws Exception{
				
		return "mypage/StatMain";
		
	}
	
	@RequestMapping("/WithdrawalMain")
	public String WithdrawalMain() throws Exception{
				
		return "mypage/WithdrawalMain";
		
	}
	
	@RequestMapping("/InitMain")
	public String InitMain() throws Exception{
				
		return "mypage/InitMain";
		
	}
	
	@RequestMapping("/login")
	public String login() {
		return "mypage/login";
	}
	
	
	@RequestMapping("login_check")
	public ModelAndView login_check(
			@ModelAttribute MyCustomerVO vo
			, HttpSession session) {
		boolean result=service.loginCheck(vo, session);
		ModelAndView mav = new ModelAndView();
		if( result == true) {		//로그인 성공
			//home.jsp로 이동
			mav.setViewName("mypage/MypageMain");
			mav.addObject("message", "success");
		}else {	//로그인 실패
					//login.jsp로 이동
			mav.setViewName("mypage/login");
			mav.addObject("message", "error");
		}
		return mav;
	}
	

	
/*	
	@RequestMapping("member/view.do")
	public String view(Model model, String userid) {
		//System.out.println("클릭한 아이디:"+userid);
		//info, debug, warn, error 
		logger.info("클릭한 아이디:" + userid);
		// 회원 정보를 모델에 저장
		//view.jsp로 포워딩
		
		model.addAttribute("dto"
				, memberService.viewMember(userid));
		return "member/view";
	}*/
	
	
	@RequestMapping(value="pass_check", method=RequestMethod.POST)
	public ModelAndView ModifyMyInfo(@RequestParam String c_id,
			@ModelAttribute MyCustomerVO vo) {
		System.out.println("되냐?");
		boolean result = service.passCheck(vo);
		ModelAndView mav = new ModelAndView();
		System.out.println(c_id);
		if(result == true) {
		mav.setViewName("/mypage/ModifyMyInfoIn");
		mav.addObject("dto",service.read(c_id));
		}else {
			mav.setViewName("/mypage/MypageMain");
		}
		return mav;
	}
	
	

}
