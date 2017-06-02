package kostyle.join.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kostyle.join.domain.JoinVO;
import kostyle.join.service.JoinService;

@Controller
@RequestMapping("/join/*")
public class joinController {
	
	private static final Logger logger = LoggerFactory.getLogger(joinController.class);
	
	@Inject
	private JoinService service;

	@RequestMapping(value = "/join", method = RequestMethod.GET)
	   public void registerGET(JoinVO join, Model model) throws Exception {//회원가입 폼을 보여줌
	      logger.info("join get ..........");
	   }
	
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	   public String registPOST(JoinVO join, RedirectAttributes rttr) throws Exception {
	      logger.info("join post ...........");
	      logger.info(join.toString());
	      
	      service.insertJoin_S(join);
	      
	      System.out.println("###########회원가입성공###########");
	      return "redirect:/join/test";
	   }
	
}
