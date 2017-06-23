package kostyle.stats.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import kostyle.login.domain.CustomerVO;
import kostyle.stats.domain.HitcountStatsChart;
import kostyle.stats.domain.SearchKeywordStats;
import kostyle.stats.service.StatsService;

@Controller
@RequestMapping("/stats")
public class StatsController {

	@Inject
	private StatsService service;
	
//	@RequestMapping(value="/statsindex", method=RequestMethod.GET)
//	public void statsIndexGET()throws Exception{
//	}
	@RequestMapping(value="/statsSide", method=RequestMethod.GET)
	public void statssideGET()throws Exception{
	}

//	@RequestMapping(value="/test", method=RequestMethod.GET)
//	public void test()throws Exception{
//	}

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
	
	//방문자수 통계
	@RequestMapping(value="/statsVisitor", method=RequestMethod.GET)
	public void statsVisitorGET()throws Exception{
		
	}
	
	@RequestMapping(value="/statsVisitor", method=RequestMethod.POST)
	public ResponseEntity<String> statsVisitorPOST(@RequestBody Map<String, Object> paramMap, HttpServletRequest request, HttpServletResponse response)throws Exception{
		ResponseEntity<String> entity = null;
		List<HitcountStatsChart> chartList = null;
		
		
		try {
			String s_sname = (String) paramMap.get("statsSearchShop");
			String statsSearchStartDate = (String) paramMap.get("statsSearchStartDate");
			String statsSearchEndDate = (String) paramMap.get("statsSearchEndDate");
			String chartFor = (String) paramMap.get("chartFor");
			
			chartList = service.statsDate(s_sname, statsSearchStartDate, statsSearchEndDate, chartFor);
			
			for(int i=0;i<chartList.size();i++){
				System.out.println("~~STATS/SUCCEED TO GET CHARTLIST: "+chartList.get(i).getCnt_date());
			}
			
			HttpSession session = request.getSession();
			
			if(session.getAttribute("statsVisitorJ") != null){
				session.removeAttribute("statsVisitorJ");
			}
			session.setAttribute("statsVisitorJ", chartList);
			
			String locate = "";
			
			if(chartFor.equals("gender")){
				locate="/stats/statsSide?statsbody=statsVisitor_gender.jsp";
			}else if(chartFor.equals("age")){
				locate="/stats/statsSide?statsbody=statsVisitor_age.jsp";
			}else if(chartFor.equals("adr")){
				locate="/stats/statsSide?statsbody=statsVisitor_adr.jsp";
			}
			
			System.out.println("~~STATS/이동: "+locate);
			entity = new ResponseEntity<String>(locate, HttpStatus.OK);
			
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		
		
		return entity;
	}
	
	//성별 방문자수 통계 출력
	@RequestMapping(value="/statsVisitor_gender", method=RequestMethod.GET)
	public void statsVisitor_genderGET()throws Exception{
		
	}
	
	@RequestMapping(value="/statsVisitor_age", method=RequestMethod.GET)
	public void statsVisitor_ageGET()throws Exception{
		
	}
	
	@RequestMapping(value="/statsVisitor_adr", method=RequestMethod.GET)
	public void statsVisitor_adrGET()throws Exception{
		
	}
	
	
	
	
	
}
