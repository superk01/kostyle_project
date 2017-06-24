package kostyle.coordinator.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kostyle.coordinator.domain.CoordinatorVO;
import kostyle.coordinator.service.CoordinatorService;

@Controller
@RequestMapping("/coordinator/*")
public class CoordinatorController {
	
	@Inject
	private CoordinatorService service;
	
	@RequestMapping(value="coordiregister", method=RequestMethod.GET)
	public String coordiregisterGET(HttpSession session){
		/*if(session.getAttribute("shoplogin")==null){										//쇼핑몰 로긴이 아니면 로그인 창으로 보내려고 했는데
			return "/login/newShopLogin";													//인터셉터 쓰면 되겠네;;;
		}*/
		return "coordinator/coordiregister";
	}
	@RequestMapping(value="coordiregister", method=RequestMethod.POST)
	public void coordiregisterPOST(@ModelAttribute CoordinatorVO coordinatorVO){
		coordinatorVO.setCd_img("1111");
		System.out.println("coord컨트롤러 등록POST메소드:"+coordinatorVO);
		service.register(coordinatorVO);
		
	}
}
