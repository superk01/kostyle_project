package kostyle.find.controller;


import javax.inject.Inject;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.mindrot.jbcrypt.BCrypt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kostyle.find.domain.FindInfo;
import kostyle.find.domain.FindshopInfo;
import kostyle.find.domain.TempPassword;
import kostyle.find.service.FindService;


@Controller
@RequestMapping("/findshop/*")
public class findshopController {
	
	private static final Logger logger = LoggerFactory.getLogger(findshopController.class);
	
	@Inject
	private FindService service;
	
	@Autowired
	private JavaMailSender mailSender;

	//아이디 찾기
	@RequestMapping(value = "/idshop", method = RequestMethod.GET)
	   public void findIDshop() throws Exception {
		System.out.println("쇼핑몰아이디 찾기 정보 입력 (컨트롤러)");
		System.out.println("");
	   }
	
	
	//찾은 아이디 출력
	@RequestMapping(value = "/idshopFindResult", method = RequestMethod.POST)
	   public void idshopFindResult(FindshopInfo findshop, Model model) throws Exception{
		System.out.println("입력 정보 일치 여부에 따라 쇼핑몰아이디 알려주기 (컨트롤러-POST)");
		
		findshop.setAd_id(service.idshopFind(findshop));
		model.addAttribute("findshop", findshop);
		System.out.println(findshop.toString());
		System.out.println("");
	   }
	
	
	
		//비밀번호 찾기
	@RequestMapping(value = "/passwordshop", method = RequestMethod.GET)
		   public void findPWshop() throws Exception {
			System.out.println("쇼핑몰비밀번호 찾기 정보 입력 (컨트롤러)");
		   }
	
		
		//찾은 비밀번호 이메일로 보내기
		@RequestMapping(value = "/pwshopFindResult", method = RequestMethod.POST)
		   public String pwshopFindResult(FindshopInfo findshop, Model model) throws Exception{
			System.out.println("입력 정보 일치 여부에 따라 쇼핑몰비밀번호 알려주기 (컨트롤러-POST)");
			System.out.println("컨트롤러 findshop1 : " +findshop);//pass : null
			int count = service.pwshopFind(findshop);
			System.out.println(count);
			
			System.out.println("컨트롤러 findshop2 : " +findshop);
			String name = findshop.getS_sname();
			String email = findshop.getS_email();
			
			System.out.println("메일보내기");
			
	        MimeMessage message = mailSender.createMimeMessage();
	        
	        if(count == 1){
	        	
	        	TempPassword temp = new TempPassword();
	        	String s_pass = temp.temp_pw();
	        	
	        	//String hashPassword = BCrypt.hashpw(c_pass, BCrypt.gensalt());
	        	findshop.setAd_pass(s_pass);
	        	//db에 임시 비밀번호가 들어가야함
	        	service.randomshopPassword(findshop);
	        	
	            message.setSubject(name + "쇼핑몰의 KOStyleMall 비밀번호 찾기 메일입니다.");
	            message.setText("임시 비밀번호는 "+ s_pass + "입니다. " + "로그인 후 마이페이지에서 비밀번호를 꼭 변경해야합니다.", "utf-8", "html");
	            message.setFrom(new InternetAddress("lees5351@gmail.com"));  
	            message.addRecipient(RecipientType.TO, new InternetAddress(email));
	            
	            System.out.println("메일 : " +  message);
	            mailSender.send(message);
	            System.out.println("쇼핑몰비밀번호 찾기 성공~");
	            
	            model.addAttribute("findshop", findshop);
	            
	            return "/findshop/pwshopFindResult1";
	            
	        }else{
	        	return "/findshop/pwshopFindResult2";
	        }
	        
		   }
		
		
		//메일보내기
		/*@RequestMapping(value="/mail", method = RequestMethod.GET)
	    public String sendMail()throws Exception{
	        System.out.println("메일보내기");
			
	        MimeMessage message = mailSender.createMimeMessage();
	        try {
	            message.setSubject("스프링으로 메일보내기");
	            message.setText("메일본문입니다.", "utf-8", "html");
	            message.setFrom(new InternetAddress("lees5351@gmail.com"));  
	            message.addRecipient(RecipientType.TO, new InternetAddress("lees5351@naver.com"));
	            
	            System.out.println("메일 : " +  message);
	            mailSender.send(message);
	            System.out.println("성공");
	        } catch (MessagingException e) {
	            e.printStackTrace();
	        }
	        
	        return "mailSuccess";
	    }*/
	
}
