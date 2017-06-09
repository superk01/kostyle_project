package kostyle.search.controller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import kostyle.search.domain.SearchVO;
import kostyle.search.service.SearchService;

@RestController
@RequestMapping("/search/*")
public class SearchController {
	
	@Inject
	private SearchService service;

	@RequestMapping("go")
	public ModelAndView goSearch(){
		return new ModelAndView("/main/header");
	}
	
	@RequestMapping(value="do", method=RequestMethod.GET)
	public ModelAndView doSearch(HttpServletRequest request){
		System.out.println("doSearch호출");
		String keyword=(String)request.getParameter("search");					//검색어 받음
		List<SearchVO> list = new ArrayList<SearchVO>(); 
		System.out.println("SearchController에서 리스트를 만들었습니다.");
		list = service.doSearch(keyword);
		System.out.println("searchController에서 데이터를 수집하여 리스트에 담았습니다.");
		System.out.println(list);
		System.out.println("이제 그 리스트를 가지고 view로 이동합니다.");
		return new ModelAndView("search/result", "list", list);
	}
}
