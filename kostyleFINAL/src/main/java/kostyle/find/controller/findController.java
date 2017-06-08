package kostyle.find.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/find/*")
public class findController {
	
	private static final Logger logger = LoggerFactory.getLogger(findController.class);
	
	//@Inject
	//private JoinService service;

	//아이디 찾기
	@RequestMapping(value = "/id", method = RequestMethod.GET)
	   public void findID(Model model) throws Exception {
		
		System.out.println("find ID get ..........");
	   }
	
	//비밀번호 찾기
		@RequestMapping(value = "/password", method = RequestMethod.GET)
		   public void findPW(Model model) throws Exception {
			
			System.out.println("find PW get ..........");
		   }
	

	
}
