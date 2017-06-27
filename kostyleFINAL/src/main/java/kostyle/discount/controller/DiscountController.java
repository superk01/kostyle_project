package kostyle.discount.controller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import kostyle.discount.domain.DiscountVO;
import kostyle.discount.service.DiscountService;
import kostyle.search.domain.SearchVO;

@Controller
@RequestMapping("/discount/*")
public class DiscountController {

	@Inject
	DiscountService service;
	private static final Logger logger= LoggerFactory.getLogger(DiscountController.class);
	
	@RequestMapping(value="/")
	public String basicDiscount(HttpServletRequest request){
		List<DiscountVO> discountList = service.discountUrlCrolling();
		request.setAttribute("discountList", discountList);

		List<DiscountVO> newSaleList = service.newSaleUrlCrolling();
		request.setAttribute("newSaleList", newSaleList);
		
		return "/discount/discount";
	}
	
	//discountUrlCrolling    과   newSaleUrlCrolling 두개 만들어야함.
	@ResponseBody
	@RequestMapping(value="planning", method=RequestMethod.GET)
	public ModelAndView doDiscountCrolling(HttpServletRequest request){
		System.out.println("doDiscount호출");
		//String keyword=(String)request.getParameter("search");					//검색어 받음
		List<DiscountVO> list = new ArrayList<DiscountVO>(); 
		list = service.discountUrlCrolling();
		return new ModelAndView("/discount/planningDiscount", "list", list);
	}
	@ResponseBody
	@RequestMapping(value="new", method=RequestMethod.GET)
	public ModelAndView doNewSaleCrolling(HttpServletRequest request){
		System.out.println("doNewSale호출");
		//String keyword=(String)request.getParameter("search");					//검색어 받음
		List<DiscountVO> list = new ArrayList<DiscountVO>(); 
		list = service.newSaleUrlCrolling();
		return new ModelAndView("/discount/newDiscount", "list", list);
	}
	
	
}//class
