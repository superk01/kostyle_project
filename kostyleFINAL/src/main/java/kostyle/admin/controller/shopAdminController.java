package kostyle.admin.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import kostyle.admin.domain.AdShoppingMallAdmin;
import kostyle.admin.domain.PageMakerAdmin;
import kostyle.admin.domain.SearchCriteriaAdmin;
import kostyle.admin.domain.ShopStateAdmin;
import kostyle.admin.domain.ShoppingMallAdmin;
import kostyle.admin.service.ShopAdminService;

@Controller
@RequestMapping("/admin")
public class shopAdminController {
	private static final Logger logger = LoggerFactory.getLogger(shopAdminController.class);
	
	@Inject
	private ShopAdminService service;
	
	
	//쇼핑몰 입점 신청 form
	@RequestMapping(value="/joinForm", method=RequestMethod.GET)
	public void insertShopGET(ShoppingMallAdmin shop, Model model)throws Exception{
		logger.info("insert get.......");
	}
	
	//쇼핑몰 입점 신청 등록
	@RequestMapping(value="/joinForm", method=RequestMethod.POST)
	public String insertShopPOST(ShoppingMallAdmin shop, RedirectAttributes rttr)throws Exception{
		logger.info("insert post");
		logger.info(shop.toString());
		
		service.insertShoppingMall(shop);
		rttr.addFlashAttribute("msg", "SUCCESS");
		return "redirect:/admin/shopList";
	}
	
	
	//shoppingmall list
	@RequestMapping(value="/shopList", method=RequestMethod.GET)
	public void shopListGET(@ModelAttribute("cri") SearchCriteriaAdmin cri, Model model)throws Exception{
		
		List<ShoppingMallAdmin> shopList = service.shopList(cri);
		List<AdShoppingMallAdmin> adShopList = service.adShopList();
		List<ShopStateAdmin> stateList = new ArrayList<ShopStateAdmin>();
		
		for(int i=0;i<shopList.size();i++){
			ShopStateAdmin shopState = new ShopStateAdmin();
			shopState.setShop(shopList.get(i));
			shopState.setShopState("unregistered");
			stateList.add(shopState);
		}
		
		for(int i=0;i<stateList.size();i++){
			for(int j=0;j<adShopList.size();j++){
				if(stateList.get(i).getShop().getS_num().equals(adShopList.get(j).getS_num())){
					stateList.get(i).setAdShop(adShopList.get(j));
					stateList.get(i).setShopState("registered");
				}
			}
		}
		
		model.addAttribute("list", stateList);
		
		//페이징
		PageMakerAdmin pm = new PageMakerAdmin();
		
		pm.setCri(cri);
		pm.setTotalCount(service.countSearchShop(cri));
		
		model.addAttribute("page", pm);
	}
	
	//shoppingmall 리스트에서 adshoppingmall로 등록하기
	@RequestMapping(value="/shopList", method=RequestMethod.POST)
	public String shopListPOST(String[] s_num, RedirectAttributes rttr)throws Exception{
		
		logger.info("adShoppingMall post/s_num: "+s_num);

		for(int i=0;i<s_num.length;i++){
			System.out.println(s_num[i]+" 등록합니다");
			ShoppingMallAdmin shop = service.getShoppingMall(s_num[i]);
			
			AdShoppingMallAdmin adShop = new AdShoppingMallAdmin();
			
			adShop.setS_num(shop.getS_num());
			adShop.setAd_id(shop.getS_email());
			
			service.insertAdShoppingMall(adShop);
		}

		rttr.addFlashAttribute("msg", "SUCCESS");
		return "redirect:/admin/shopList";
	}
	
	//모달창에서 adshoppingmall 등록하기
	@RequestMapping(value="/shopModal", method=RequestMethod.POST)
	public ResponseEntity<String> shopModal(@RequestBody Map<String, Object> paramMap){
		ResponseEntity<String> entity = null;
		try {
			
			Map<String, Object> shopMap = new HashMap<String, Object>();
			ObjectMapper mapper = new ObjectMapper();
			String shopJson = (String) paramMap.get("shop");
			shopMap = mapper.readValue(shopJson, new TypeReference<Map<String, String>>(){});
			
			System.out.println("controller: adshopping mall 등록---------");
			System.out.println("s_num: "+shopMap.get("s_num"));
			System.out.println("s_sname: "+shopMap.get("s_sname"));
			System.out.println("s_shopurl: "+shopMap.get("s_shopurl"));
			System.out.println("s_searchurl: "+shopMap.get("s_searchurl"));
			System.out.println("s_shopreg: "+shopMap.get("s_shopreg"));
			System.out.println("s_age: "+shopMap.get("s_age"));
			System.out.println("s_manager: "+shopMap.get("s_manager"));
			System.out.println("s_phonenumber: "+shopMap.get("s_phonenumber"));
			System.out.println("s_email: "+shopMap.get("s_email"));
			System.out.println("s_image: "+shopMap.get("s_image"));
			System.out.println("s_grade: "+paramMap.get("s_grade"));
			

			String num = (String) shopMap.get("s_num");
			ShoppingMallAdmin shop = service.getShoppingMall(num);
			
			shop.setS_num((String)shopMap.get("s_num"));
			shop.setS_sname((String)shopMap.get("s_sname"));
			shop.setS_shopurl((String)shopMap.get("s_shopurl"));
			shop.setS_searchurl((String)shopMap.get("s_searchurl"));
			shop.setS_shopreg((String)shopMap.get("s_shopreg"));
			shop.setS_age(Integer.parseInt((String) shopMap.get("s_age")));
			shop.setS_manager((String)shopMap.get("s_manager"));
			shop.setS_phonenumber((String)shopMap.get("s_phonenumber"));
			shop.setS_email((String)shopMap.get("s_email"));
			shop.setS_image((String)shopMap.get("s_image"));
			
			service.updateShopInfo(shop);

			
			AdShoppingMallAdmin adShop = new AdShoppingMallAdmin();
			
			adShop.setS_num(shop.getS_num());
			adShop.setAd_id(shop.getS_email());
			adShop.setS_grade(Integer.parseInt((String) paramMap.get("s_grade")));
			
			service.insertAdShoppingMall(adShop);
			
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	//리스트에서 adshoppingmall 등록 취소하기
	@RequestMapping(value="/deleteAdShop", method=RequestMethod.POST)
	public String deleteAdShop(String[] s_num, RedirectAttributes rttr)throws Exception{
		
		for(int i=0;i<s_num.length;i++){
			System.out.println(s_num[i]+" 등록 취소합니다");
			service.deleteAdShop(s_num[i]);
		}
		
		rttr.addFlashAttribute("msg", "SUCCESS");
		return "redirect:/admin/shopList";
	}
	
	//모달창에서 adshoppingmall 등록취소하기
	@RequestMapping(value="/deleteAdShopModal", method=RequestMethod.POST)
	public ResponseEntity<String> deleteAdShopModal(@RequestBody AdShoppingMallAdmin adShopModal){
		ResponseEntity<String> entity = null;
		try {
			System.out.println(adShopModal.getS_num()+" 등록 취소합니다");
			service.deleteAdShop(adShopModal.getS_num());
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	//모달창에서 shop 정보 수정하기
	@RequestMapping(value="/modifyShopModal", method=RequestMethod.POST)
	public ResponseEntity<String> modifyShopModal(@RequestBody Map<String, Object> paramMap){
		
		ResponseEntity<String> entity = null;
		
		try {
			Map<String, Object> modifyMap = new HashMap<String, Object>();
			ObjectMapper mapper = new ObjectMapper();
			String shopJson = (String) paramMap.get("shop");
			modifyMap = mapper.readValue(shopJson, new TypeReference<Map<String, String>>(){});
			
			String s_num = (String) modifyMap.get("s_num");
			ShoppingMallAdmin shop = service.getShoppingMall(s_num);
			
			shop.setS_num((String) modifyMap.get("s_num"));
			shop.setS_sname((String) modifyMap.get("s_sname"));
			shop.setS_shopurl((String) modifyMap.get("s_shopurl"));
			shop.setS_searchurl((String) modifyMap.get("s_searchurl"));
			shop.setS_shopreg((String) modifyMap.get("s_shopreg"));
			shop.setS_age(Integer.parseInt((String) modifyMap.get("s_age")));
			shop.setS_manager((String) modifyMap.get("s_manager"));
			shop.setS_phonenumber((String) modifyMap.get("s_phonenumber"));
			shop.setS_email((String) modifyMap.get("s_email"));
			shop.setS_image((String) modifyMap.get("s_image"));			
			
			System.out.println("shoppingmall 정보수정: "+shop.getS_num());
			service.updateShopInfo(shop);
			
			String s_grade = (String) paramMap.get("s_grade");

			if(s_grade == null || s_grade ==""){
				System.out.println("s_grade is null");
			}else if(s_grade != null || s_grade != ""){
				AdShoppingMallAdmin adShop = service.getAdShoppingMall(shop.getS_num());
				
				adShop.setS_grade(Integer.parseInt(s_grade));
				
				System.out.println("adshoppingmall 정보 수정: "+shop.getS_num());
				service.updateAdShopInfo(adShop);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	

	
	@RequestMapping(value="/test", method=RequestMethod.GET)
	public void test(Model model)throws Exception{
		logger.info("ddd");
	}
	
	@RequestMapping(value="/admintest", method=RequestMethod.POST)
	public void testPOST(String search)throws Exception{
		System.out.println("admin: "+search);
	}
	
}
