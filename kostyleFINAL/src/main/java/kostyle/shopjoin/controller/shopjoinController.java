package kostyle.shopjoin.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kostyle.shopjoin.domain.ShoppingMall;
import kostyle.shopjoin.service.ShopJoinService;

@Controller
@RequestMapping("/shopJoin")
public class shopjoinController {
	private static final Logger logger = LoggerFactory.getLogger(shopjoinController.class);
	
	@Inject
	private ShopJoinService service;
	
	@RequestMapping(value="/joinForm", method=RequestMethod.GET)
	public void insertShopGET(ShoppingMall shop, Model model)throws Exception{
		System.out.println("ddddddd");
		logger.info("insert get.......");
	}
	
	@RequestMapping(value="/joinForm", method=RequestMethod.POST)
	public String insertShopPOST(ShoppingMall shop, RedirectAttributes rttr)throws Exception{
		logger.info("insert post");
		logger.info(shop.toString());
		
		int countShop = service.countShoppingMall();
		
		System.out.println(countShop);
		
		if(countShop < 10){
			System.out.println("s_0"+countShop);
		}else{
			System.out.println("s_"+countShop);
		}
		
		//service.insertShoppingMall(shop);
		//rttr.addFlashAttribute("msg", "SUCCESS");
//		return "redirect:/shopJoin/test";
		return "test";
	}
	
			
			
}
