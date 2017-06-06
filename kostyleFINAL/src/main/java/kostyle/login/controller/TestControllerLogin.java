package kostyle.login.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import kostyle.login.service.LoginService;

@Controller
@RequestMapping("/logintest")
public class TestControllerLogin {

	@Inject
	private LoginService service;
	
	private static final Logger logger= LoggerFactory.getLogger(CusLoginController.class);
	
	
	@RequestMapping(value="/preloginCus")
	public String preCus(){
//		return "/login/loginCustomer";
		return "/login/colorLogin";
		
	}
	
	@RequestMapping(value="/testpage1")
	public String mevetest1(){
		return "/login/testpage1";
		
	}
	@RequestMapping(value="/testpage2")
	public String mevetest2(){
		return "/login/testpage2";
		
	}
	
	
	
	
	
	
}//class
