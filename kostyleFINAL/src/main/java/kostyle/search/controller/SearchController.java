package kostyle.search.controller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import kostyle.login.domain.CustomerVO;
import kostyle.search.domain.SearchVO;
import kostyle.search.service.SearchService;
import kostyle.stats.domain.SearchKeywordStats;
import kostyle.stats.service.StatsService;

@Controller
@RequestMapping("/search/*")
public class SearchController {
   
   @Inject
   private SearchService service;
   
   @Inject
   private StatsService statsService;

   @RequestMapping("go")
   public ModelAndView goSearch(){
      return new ModelAndView("/main/header");
   }
   
   @RequestMapping(value="do", method=RequestMethod.GET)
   public ModelAndView doSearch(HttpServletRequest request, @RequestParam("search") String keyword, HttpSession session){
      System.out.println("doSearch호출");
      /*String keyword=(String)request.getParameter("search");*/               //검색어 받음
      
      List<SearchVO> list = new ArrayList<SearchVO>(); 
      /*System.out.println("SearchController에서 리스트를 만들었습니다.");*/
      list = service.doSearch(keyword);
      /*System.out.println("searchController에서 데이터를 수집하여 리스트에 담았습니다.");*/
      for(int i=0; i<list.size(); i++){
         list.get(i).setProduct_ImageLink("//"+list.get(i).getProduct_ImageLink());
         list.get(i).setProduct_link("//"+list.get(i).getProduct_link());
         System.out.println("컨트롤러에서 받은 리스트 중 이미지url: "+list.get(i).getProduct_ImageLink());
      }
      /*System.out.println("이제 그 리스트를 가지고 view로 이동합니다.");*/
      /*HttpSession session = request.getSession();
      session.setAttribute("list", list);*/
      
      
      
      
      //검색어 저장하기
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
      System.out.println("~~STATS SEARCH: "+keyword);
      
      SearchKeywordStats sks = new SearchKeywordStats();
      
      sks.setC_num(cnum);
      sks.setSk_searchkey(keyword);
      
      try {
         statsService.insertSearchKeyword(sks);
      } catch (Exception e) {
         e.printStackTrace();
      }
      //검색어 저장하기
      
      
      
      
      
      return new ModelAndView("search/result", "list", list);
   }
}