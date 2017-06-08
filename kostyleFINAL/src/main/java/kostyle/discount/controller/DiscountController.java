package kostyle.discount.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import kostyle.discount.domain.DiscountVO;
import kostyle.discount.service.DiscountService;

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
		
		return "discount/discount";
	}
	
	
	
}//class
