package kostyle.join.controller;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.mindrot.jbcrypt.BCrypt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import kostyle.join.domain.JoinJoin;
import kostyle.join.service.JoinService;

@Controller
@RequestMapping("/join/*")
public class joinController {
	
	private static final Logger logger = LoggerFactory.getLogger(joinController.class);
	
	@Inject
	private JoinService service;

	//회원가입 폼을 보여줌
	@RequestMapping(value = "/join", method = RequestMethod.GET)
	   public void registerGET(JoinJoin join, Model model) throws Exception {
		
		System.out.println("join get ..........");
	   }
	
	
	//회원가입이 이루어짐
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	   public String registPOST(JoinJoin join) throws Exception {
		
		System.out.println("join post ...........");
		System.out.println("암호화 전 : " + join.toString());
		
		
		String hashPassword = BCrypt.hashpw(join.getC_pass(), BCrypt.gensalt());
		join.setC_pass(hashPassword);
		System.out.println("암호화 후 : " + join.toString());
	      
	    service.insertJoin_S(join);
	      
	    System.out.println("###########회원가입성공###########");
	    return "redirect:/";
	   }
	
	
	//회원 아이디 중복 체크
	@RequestMapping(value = "/overlapId", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, String>overlapId(String c_id)throws Exception{
		Map<String, String>map = new HashMap<String, String>();
		
		int cnt = service.overlapId_S(c_id);
		
		String result="";
		String resultMsg="";
		
		if(cnt == 0){
			result="success"; 
			resultMsg="사용 가능한 아이디 입니다.";
		}else{
			result="fail";
			resultMsg="이미 사용중인 아이디 입니다.";
		}
		
		  map.put("result", result);
		  map.put("resultMsg", resultMsg);
		
		return map;
	}
	
}
