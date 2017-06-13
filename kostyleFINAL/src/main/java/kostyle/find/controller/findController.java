package kostyle.find.controller;


import javax.inject.Inject;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kostyle.find.domain.FindInfo;
import kostyle.find.service.FindService;


@Controller
@RequestMapping("/find/*")
public class findController {
	
	private static final Logger logger = LoggerFactory.getLogger(findController.class);
	
	@Inject
	private FindService service;
	
	@Autowired
	private JavaMailSender mailSender;

	//아이디 찾기
	@RequestMapping(value = "/id", method = RequestMethod.GET)
	   public void findID() throws Exception {
		System.out.println("아이디 찾기 정보 입력 (컨트롤러)");
		System.out.println("");
	   }
	
	
	//찾은 아이디 출력
	@RequestMapping(value = "/idFindResult", method = RequestMethod.POST)
	   public void idFindResult(FindInfo find, Model model) throws Exception{
		System.out.println("입력 정보 일치 여부에 따라 아이디 알려주기 (컨트롤러-POST)");
		
		find.setC_id(service.idFind(find));
		model.addAttribute("find", find);
		System.out.println(find.toString());
		System.out.println("");
	   }
	
	
	
		//비밀번호 찾기
		@RequestMapping(value = "/password", method = RequestMethod.GET)
		   public void findPW() throws Exception {
			System.out.println("비밀번호 찾기 정보 입력 (컨트롤러)");
		   }
	
		
		//찾은 비밀번호 출력
		@RequestMapping(value = "/pwFindResult", method = RequestMethod.POST)
		   public void pwFindResult(FindInfo find, Model model) throws Exception{
			System.out.println("입력 정보 일치 여부에 따라 비밀번호 알려주기 (컨트롤러-POST)");
			
			find.setC_pass(service.pwFind(find));
			model.addAttribute("find", find);
			System.out.println(find.toString());
			System.out.println("");
		   }
		
		
		//메일보내기
		@RequestMapping(value="/mail", method = RequestMethod.GET)
	    public String sendMail()throws Exception{
	        System.out.println("메일보내기");
			
	        MimeMessage message = mailSender.createMimeMessage();
	        try {
	            message.setSubject("스프링으로 메일보내기");
	            message.setText("메일본문입니다.");
	            message.setRecipients(MimeMessage.RecipientType.TO, InternetAddress.parse("lees5351@hanmail.net"));
	            
	            System.out.println("메일 : " +  message);
	            mailSender.send(message);
	            System.out.println("성공");
	        } catch (MessagingException e) {
	            e.printStackTrace();
	        }
	        
	        return "mailSuccess";
	    }
	
}
