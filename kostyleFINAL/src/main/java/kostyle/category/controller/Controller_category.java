package kostyle.category.controller;

import java.nio.file.attribute.FileTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
		model.addAttribute("keyword", keyword);
		return "/category/categoryResult";
	}
	
	@RequestMapping(value="/categoryResult/filter", method=RequestMethod.POST)
	public String categoryResult_fitlerPOST(@RequestBody String vo, HttpSession session)throws Exception{
		
		return "redirect:/category/categoryResult";
	}
	
	
}
