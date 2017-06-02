package kostyle.admin.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kostyle.admin.domain.ShoppingMall;
import kostyle.admin.service.ShopAdminService;

@Controller
@RequestMapping("/admin")
public class shopAdminController {
	private static final Logger logger = LoggerFactory.getLogger(shopAdminController.class);
	
	@Inject
	private ShopAdminService service;
	
	@RequestMapping(value="/joinForm", method=RequestMethod.GET)
	public void insertShopGET(ShoppingMall shop, Model model)throws Exception{
		logger.info("insert get.......");
	}
	
	@RequestMapping(value="/joinForm", method=RequestMethod.POST)
	public String insertShopPOST(ShoppingMall shop, RedirectAttributes rttr)throws Exception{
		logger.info("insert post");
		logger.info(shop.toString());
		
		int countShop = service.countShoppingMall()+1;
		String s_Num;
		
		if(countShop < 10){
			System.out.println("s_0"+countShop);
			s_Num = "s_0"+countShop;
		}else{
			System.out.println("s_"+countShop);
			s_Num = "s_"+countShop;
		}
		
		shop.setS_num(s_Num);
		
		service.insertShoppingMall(shop);
		rttr.addFlashAttribute("msg", "SUCCESS");
		return "redirect:/admin/shopList";
	}
	
	@RequestMapping(value="/shopList", method=RequestMethod.GET)
	public void shopList(ShoppingMall shop, Model model)throws Exception{
		model.addAttribute("list", service.shopList());
	}
	
	@RequestMapping(value="/shopDetail", method=RequestMethod.GET)
	public void shopDetail(@RequestParam("s_num") String s_num, Model model) throws Exception{
		model.addAttribute("ShoppingMall",service.shopDetail(s_num));
	}
			
	@RequestMapping(value="/adShop", method=RequestMethod.GET)
	public String adShop(@RequestParam("s_num") String s_num)throws Exception{
		return "adShopList";
	}
	
}
