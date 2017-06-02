package kostyle.category.controller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kostyle.category.bo.CategoryFilter;
import kostyle.category.bo.CategorySearch;
import kostyle.category.domain.Adshoppingmall_category;
import kostyle.category.service.CategoryService;

@Controller
@RequestMapping("/category/*")
public class Controller_category {
	
	@Inject
	CategoryService service;
	
	@RequestMapping(value="/search", method = RequestMethod.GET)
	public void categorySearchGET(){}
	
	@RequestMapping(value="/search", method = RequestMethod.POST) 
	public String categorySearchPOST(@RequestParam("keyword") String keyword, HttpSession session)throws Exception{
		CategorySearch search = new CategorySearch();
		search.CategorySearch_start2(keyword, service.adsList(), session);
		return "redirect:/category/categoryResult";
	}
	 
	@RequestMapping(value="/categoryResult")
	public void categoryResult(){}
	
	@RequestMapping(value="/categoryResult/{filter}")
	public String categoryResult_fitlerGET(@PathVariable("filter") String filter, HttpSession session){
		CategoryFilter categoryFitler = new CategoryFilter();
		categoryFitler.setCategoryResult(session, filter);
		return "redirect:/category/categoryResult";
	}
	
	
}
