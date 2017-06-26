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
import kostyle.stats.domain.CustomerStats;
import kostyle.stats.domain.HitcountStatsChart;
import kostyle.stats.domain.SearchKeywordChart;
import kostyle.stats.domain.SearchKeywordStats;
import kostyle.stats.service.StatsService;

@Controller
@RequestMapping("/stats")
public class StatsController {

	@Inject
	private StatsService service;
	
	@RequestMapping(value="/statsMain", method=RequestMethod.GET)
	public void statsMainGET()throws Exception{
	}
	
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
				locate="/stats/statsVisitor_gender";
			}else if(chartFor.equals("age")){
				locate="/stats/statsVisitor_age";
			}else if(chartFor.equals("adr")){
				locate="/stats/statsVisitor_adr";
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
	
	
	
	
	
	//검색어 분석
	@RequestMapping(value="/statsSearch", method=RequestMethod.POST)
	public ResponseEntity<String> statsSearchPOST(HttpServletRequest request, HttpServletResponse response)throws Exception{
		ResponseEntity<String> entity = null;
		List<SearchKeywordChart> list = null;
		
		try {
			entity = new ResponseEntity<String>("hello", HttpStatus.OK);
			list = service.statsSearchRank();
			
			for(int i=0;i<list.size();i++){
				System.out.println(list.get(i).getSk_searchkey());
			}
			
			
			HttpSession session = request.getSession();
			
			if(session.getAttribute("statsSearchRankJ") != null){
				session.removeAttribute("statsSearchRankJ");
			}
			session.setAttribute("statsSearchRankJ", list);
			
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}
	
	
	
	
	
	
	//회원 분석
	@RequestMapping(value="/statsCustomer", method=RequestMethod.GET)
	public void statsCustomerGET()throws Exception{
	}
	
	
	@RequestMapping(value="/statsCustomer", method=RequestMethod.POST)
	public ResponseEntity<String> statsCustomerPOST(String statsCustomer, HttpServletRequest request, HttpServletResponse response)throws Exception{
		ResponseEntity<String> entity = null;
		List<CustomerStats> searchKeyList = null;
		List<CustomerStats> shopList = null;
		List<CustomerStats> prdList = null;
		List<CustomerStats> test = null;
		
		try {
			
			searchKeyList = service.customerSearchKeyAll(statsCustomer);
			shopList = service.customerVisitShopAll(statsCustomer);
			prdList = service.customerVisitPrdAll(statsCustomer);
			test = service.getSimilar(statsCustomer);
			
			HttpSession session = request.getSession();
			
			if(session.getAttribute("customerStatsSearchKeyAllJ") != null){
				session.removeAttribute("customerStatsSearchKeyAllJ");
			}
			session.setAttribute("customerStatsSearchKeyAllJ", searchKeyList);
			
			if(session.getAttribute("customerStatsShopAllJ") != null){
				session.removeAttribute("customerStatsShopAllJ");
			}
			session.setAttribute("customerStatsShopAllJ", shopList);
			
			if(session.getAttribute("customerStatsPrdAllJ") != null){
				session.removeAttribute("customerStatsPrdAllJ");
			}
			session.setAttribute("customerStatsPrdAllJ", prdList);
			
			entity = new ResponseEntity<String>("hello", HttpStatus.OK);
			
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	@RequestMapping(value="/statsCustomerChart", method=RequestMethod.GET)
	public void statsCustomerChartGET()throws Exception{
	}
	
}
