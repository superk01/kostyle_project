package kostyle.admin.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kostyle.admin.domain.AdShoppingMallAdmin;
import kostyle.admin.domain.ShoppingMallAdmin;
import kostyle.admin.service.ShopAdminService;

@Controller
@RequestMapping("/admin")
public class shopAdminController {
	private static final Logger logger = LoggerFactory.getLogger(shopAdminController.class);
	
	@Inject
	private ShopAdminService service;
	
	@RequestMapping(value="/joinForm", method=RequestMethod.GET)
	public void insertShopGET(ShoppingMallAdmin shop, Model model)throws Exception{
		logger.info("insert get.......");
	}
	
	@RequestMapping(value="/joinForm", method=RequestMethod.POST)
	public String insertShopPOST(ShoppingMallAdmin shop, RedirectAttributes rttr)throws Exception{
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
	
	public void shopListGET(ShoppingMallAdmin shop, Model model)throws Exception{
		model.addAttribute("list", service.shopList());
	}
	
	@RequestMapping(value="/shopList", method=RequestMethod.POST)
	public String shopListPOST(String s_num, RedirectAttributes rttr)throws Exception{
		logger.info("adShoppingMall post/s_num: "+s_num);
		System.out.println(s_num);
		
		ShoppingMallAdmin shop = service.getShoppingMall(s_num);
		service.insertAdShoppingMall(shop);
		System.out.println(shop.getS_sname());
		
		rttr.addFlashAttribute("msg", "SUCCESS");
		return "redirect:/admin/adShopList";
	}
	
	@RequestMapping(value="/shopModal", method=RequestMethod.POST)
	public ResponseEntity<String> shopModal(@RequestBody ShoppingMallAdmin shopModal){
		ResponseEntity<String> entity = null;
		try {
			ShoppingMallAdmin shop = service.getShoppingMall(shopModal.getS_num());
			service.insertAdShoppingMall(shop);
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	@RequestMapping(value="/adShopList", method=RequestMethod.GET)
	public void adShopList(AdShoppingMallAdmin adshop, Model model)throws Exception{
		model.addAttribute("list", service.adShopList());
	}
	
//	@RequestMapping(value="/shopDetail", method=RequestMethod.GET)
//	public void shopDetail(@RequestParam("s_num") String s_num, Model model) throws Exception{
//		model.addAttribute("ShoppingMallAdmin",service.shopDetail(s_num));
//	}
			
//	@RequestMapping(value="/adShop", method=RequestMethod.GET)
//	public String adShop(@RequestParam("s_num") String s_num)throws Exception{
//		return "adShopList";
//	}
	
//	@RequestMapping(value="/test", method=RequestMethod.GET)
//	public void test(Model model)throws Exception{
//		logger.info("ddd");
//	}
//	
//	@RequestMapping(value="/test", method=RequestMethod.POST)
//	public String testPOST(ShoppingMallAdmin shop, RedirectAttributes rttr)throws Exception{
//		
//		System.out.println(shop.getS_num());
//		rttr.addFlashAttribute("msg", "SUCCESS");
//		
//		return "redirect:/admin/shopList";
//	}
	
}
