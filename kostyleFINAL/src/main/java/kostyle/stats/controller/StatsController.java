package kostyle.stats.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kostyle.login.domain.CustomerVO;
import kostyle.stats.domain.SearchKeywordStats;
import kostyle.stats.service.StatsService;

@Controller
@RequestMapping("/stats")
public class StatsController {

	@Inject
	private StatsService service;
	
	@RequestMapping(value="/statsindex", method=RequestMethod.GET)
	public void statsIndexGET()throws Exception{
	}
	@RequestMapping(value="/statsSide", method=RequestMethod.GET)
	public void statssideGET()throws Exception{
	}
	@RequestMapping(value="/statsSide2", method=RequestMethod.GET)
	public void statsside2GET()throws Exception{
	}

	@RequestMapping(value="/test", method=RequestMethod.GET)
	public void test()throws Exception{
	}

	//검색 시 키워드 저장
	@RequestMapping(value="/insertstats", method=RequestMethod.POST)
	public void statstestPOST(String search, HttpSession session)throws Exception{
		
		String cnum="";
		CustomerVO customerVO = null;
		
		Object userVO = session.getAttribute("login");
		if(userVO == null){
			cnum= "";
		}else{
			if(userVO instanceof CustomerVO){
				customerVO = (CustomerVO)userVO;
				cnum = customerVO.getC_num();
			}
		}
		
		System.out.println("~~STATS C_NUM: "+cnum);
		System.out.println("~~STATS SEARCH: "+search);
		
		SearchKeywordStats sks = new SearchKeywordStats();
		
		sks.setC_num(cnum);
		sks.setSk_searchkey(search);
		
		service.insertSearchKeyword(sks);
	
	}
	
}
