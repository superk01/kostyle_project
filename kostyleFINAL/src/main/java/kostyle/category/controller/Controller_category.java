package kostyle.category.controller;

import java.nio.file.attribute.FileTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.http.converter.json.GsonFactoryBean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sun.net.httpserver.Filter;

import kostyle.category.bo.CategoryFilter;
import kostyle.category.bo.CategorySearch;
import kostyle.category.domain.Adshoppingmall_category;
import kostyle.category.domain.FilterVO;
import kostyle.category.domain.Product_category;
import kostyle.category.service.CategoryService;

@Controller
@RequestMapping("/category/*")
public class Controller_category {
	////
	@Inject 
	CategoryService service;
	
	@RequestMapping(value="/search", method = RequestMethod.GET)
	public void categorySearchGET(){}
	//
	@RequestMapping(value="/search", method = RequestMethod.POST) 
	public String categorySearchPOST(@RequestParam("keyword") String keyword, HttpSession session, Model model)throws Exception{
		CategorySearch search = new CategorySearch();
		if(service.product_Search(keyword).size() == 0){
			Map<String, Object> map = new HashMap<String, Object>();
			List<Product_category> list = search.CategorySearch_main(keyword, service.adsList(), session);
			if(list.size() > 0){
				map.put("list", list);
				service.product_list_insert(map);
			}
		}else{
			session.setAttribute("product_list", service.product_Search(keyword));
		}
		String colorList[] = {"화이트","차콜","베이지","그레이","블랙","머스타드","아이보리","그린","블루","핑크","레드","오렌지","노랑","소라","파랑","카키","노르틴","검정","오트밀","딥프레소","버건디","착콜","네이비","곤색"	};
		session.setAttribute("keyword", keyword);
		session.setAttribute("colorList", colorList);
		return "/category/categoryResult";
	}
	
	@RequestMapping(value="/categoryResult/filter", method=RequestMethod.POST)
	public ResponseEntity<String> categoryResult_fitlerPOST(@RequestBody String vo, HttpSession session, Model model)throws Exception{
		JSONParser json = new JSONParser();
		Object obj = json.parse(vo); JSONObject jsonVO = (JSONObject) obj;
		FilterVO filterVO = new FilterVO((String)jsonVO.get("keyword"), (String)jsonVO.get("filter"));
		CategoryFilter filterBO = new CategoryFilter();
		if(filterBO.setCategoryResult(session, filterVO.getFilter())){
			System.out.println(filterVO.toString());
			session.setAttribute("product_list", service.product_Filter_color(filterVO));
		};
		ResponseEntity<String> ent = null;		
		return ent;
	}
	
	@RequestMapping(value="/categoryResult")
	public void categroyResultGET(){}
	
	
}
