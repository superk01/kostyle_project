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
	
	
	@ResponseBody
	@RequestMapping(value="do", method=RequestMethod.GET)
	public ModelAndView doDiscount(HttpServletRequest request){
		System.out.println("doDiscount호출");
		//String keyword=(String)request.getParameter("search");					//검색어 받음
		List<DiscountVO> list = new ArrayList<DiscountVO>(); 
		list = service.discountUrlCrolling();
		return new ModelAndView("/discount/testdiscount", "list", list);
	}
	
	
}//class
