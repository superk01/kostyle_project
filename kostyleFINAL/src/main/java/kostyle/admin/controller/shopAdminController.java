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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import kostyle.admin.domain.AdShoppingMallAdmin;
import kostyle.admin.domain.CriteriaAdmin;
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
			shopState.setShopState("미등록");
			stateList.add(shopState);
		}
		
		for(int i=0;i<stateList.size();i++){
			for(int j=0;j<adShopList.size();j++){
				if(stateList.get(i).getShop().getS_num().equals(adShopList.get(j).getS_num())){
					stateList.get(i).setAdShop(adShopList.get(j));
					stateList.get(i).setShopState("등록");
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
			service.insertAdShoppingMall(shop);
		}

		rttr.addFlashAttribute("msg", "SUCCESS");
		return "redirect:/admin/adShopList";
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
			
			System.out.println("controller-----------------------------------");
			System.out.println(shopMap);
			System.out.println(shopMap.get("s_num"));
			System.out.println(shopMap.get("s_sname"));
			System.out.println(shopMap.get("s_shopurl"));
			System.out.println(shopMap.get("s_searchurl"));
			System.out.println(shopMap.get("s_shopreg"));
			System.out.println(shopMap.get("s_age"));
			System.out.println(shopMap.get("s_manager"));
			System.out.println(shopMap.get("s_phonenumber"));
			System.out.println(shopMap.get("s_email"));
			System.out.println(shopMap.get("s_image"));
			System.out.println(paramMap.get("s_grade"));
//			ShoppingMallAdmin shop = service.getShoppingMall(shopModal.getS_num());
//			service.insertAdShoppingMall(shop);
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

	
//	@RequestMapping(value="/test", method=RequestMethod.GET)
//	public void test(Model model)throws Exception{
//		logger.info("ddd");
//	}
//	
//	@RequestMapping(value="/test", method=RequestMethod.POST)
//	public Map<String, Object> testPOST(@RequestBody Map<String, Object> params)throws Exception{
//		
//		 Map<String, Object> resultMap = new HashMap<String,Object>();
//		 try{
//		 Map<String, Object> shopMap = new HashMap<String,Object>();
//		 Map<String, Object> adShopMap = new HashMap<String,Object>();
//		 
//		 ObjectMapper mapper = new ObjectMapper();
//		 String json = (String) params.get("shop");
//		 String adjson = (String) params.get("adshop");
//		 
//		 shopMap = mapper.readValue(json, new TypeReference<Map<String, String>>(){});
//		 adShopMap = mapper.readValue(adjson, new TypeReference<Map<String, String>>(){});
//		 		System.out.println(shopMap);
//		 		System.out.println(shopMap.get("name"));
//	            System.out.println(adShopMap);
//	            System.out.println(adShopMap.get("water"));
//	        }catch(Exception e){
//	            resultMap.put("message",e.getMessage());
//	            return resultMap;
//	        }        
//	        resultMap.put("message", "회원 정보가 정상적으로 변경되었습니다");
//	        return resultMap;
//	}
	
}
