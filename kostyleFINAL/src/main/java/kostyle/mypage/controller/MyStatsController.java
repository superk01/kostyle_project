package kostyle.mypage.controller;

import java.io.PrintWriter;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.tribes.MembershipService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import javafx.scene.control.Alert;
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
		}else {	//로그인 실패
					//login.jsp로 이동
			mav.setViewName("mypage/login");
		}
		return mav;
	}
	
	@RequestMapping(value="modi_pass_check", method=RequestMethod.POST)
	public ModelAndView ModifyMyInfo(@RequestParam String c_id,
			@ModelAttribute MyCustomerVO vo, Model model) {
		System.out.println("되냐?");
		boolean result = service.passCheck(vo);

		ModelAndView mav = new ModelAndView();

		if(result == true) {
			System.out.println("아");
			System.out.println(c_id);

		mav.setViewName("/mypage/ModifyMyInfoIn");
		mav.addObject("dto",service.read(c_id));
		}else {
			mav.setViewName("/mypage/MypageMain");
			model.addAttribute("message","비밀번호가 일치하지 않습니다.");
		}
		return mav;
	}
	
	@RequestMapping(value="with_pass_check", method=RequestMethod.POST)
	public String Withdrawal(@RequestParam String c_id,
			@RequestParam String c_pass, @ModelAttribute MyCustomerVO vo,
			Model model, HttpSession session) throws Exception {
			System.out.println("회원탈퇴");
				boolean result = service.passCheck(vo);
				if(result){
					//삭제 처리
					service.DeleteMember(c_id);
					//메인으로 이동
					session.invalidate();
					return "redirect:/";
				}else {
					//비번이 틀렷을 때
					model.addAttribute("message", "비밀번호가 일치하지 않습니다.");
					//WithdrawalMain.jsp로 포워드.
					return  "/mypage/WithdrawalMain";
				}
	}
	
	@RequestMapping(value="modifyMyInfo", method=RequestMethod.POST)
	public String update(@ModelAttribute MyCustomerVO vo, Model  model, 
			@RequestParam String c_id) {

			service.UpdateMember(vo);
			return "/mypage/MypageMain";
	
		
		
	}
	

}
