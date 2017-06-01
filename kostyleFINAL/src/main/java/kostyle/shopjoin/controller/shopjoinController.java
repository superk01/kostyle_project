package kostyle.shopjoin.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/shopEntry")
public class shopjoinController {
	private static final Logger logger = LoggerFactory.getLogger(shopjoinController.class);
	
	@RequestMapping(value="/entry")
	public String entry(){
		return "/shopEntry/entryForm";
	}
	
			
			
}
