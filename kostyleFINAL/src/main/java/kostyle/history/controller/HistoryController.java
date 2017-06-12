package kostyle.history.controller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.xml.ws.Response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import kostyle.history.domain.HistoryCriteria;
import kostyle.history.domain.HistoryPageMaker;
import kostyle.history.domain.HistoryVO;
import kostyle.history.service.HistoryService;
import kostyle.login.domain.CustomerVO;

@RestController
@RequestMapping("/history/*")
public class HistoryController {

	@Inject
	private HistoryService service;
	
	@RequestMapping(value="insert", method=RequestMethod.POST)
	public ResponseEntity<String> insertHistory(@RequestBody HistoryVO historyVO, HttpSession session){
		System.out.println("insertHistory진입");
		System.out.println("insertHistory의 historyVO:"+historyVO);
		Object userVO=session.getAttribute("login");
		CustomerVO customerVO = null;
		if(userVO instanceof CustomerVO){
			customerVO = (CustomerVO)userVO;
		}
		
		ResponseEntity<String> entity =null;
		try {
			service.insertHistory(historyVO,session);
			entity = new ResponseEntity<String>(customerVO.getC_num(),HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	@RequestMapping(value="list/{c_Num}", method=RequestMethod.GET)
	public ModelAndView listHistory(@PathVariable("c_Num") int c_Num, @ModelAttribute("cri") HistoryCriteria cri){
		System.out.println("history컨트롤러에서 cri객체 확인"+cri);
		ModelAndView mav = new ModelAndView();
		List<HistoryVO> list = new ArrayList<>();
		list=service.listHistory(c_Num, cri);
		
		HistoryPageMaker maker = new HistoryPageMaker();
		maker.setCri(cri);
		maker.setTotalCount(service.countHistory(c_Num));
		mav.addObject("list", list);
		mav.addObject("pageMaker", maker);
		mav.setViewName("/history/history");
		
		return mav;
	}
	
	@RequestMapping(value="delete", method=RequestMethod.GET)
	public ResponseEntity<String> deleteHistory(HttpServletRequest request){
		System.out.println("deleteHistory진입");
		System.out.println("11111어디서 막힌건가11111?");
		String[] str = request.getParameter("h_num").toString().split(",");
		
		System.out.println("배열안의 데이터 숫자 확인: "+str.length);
		System.out.println("22222어디서 막힌건가22222?");
		for(int i=0; i<str.length-1; i++){
			System.out.println("deleteHistory-str("+(i+1)+") :"+str[i]);
			System.out.println("33333어디서 막힌건가33333?");
		}
		System.out.println("44444어디서 막힌건가44444?");
		ResponseEntity<String> entity= null;
		try {
			for(int i=0; i<str.length; i++){
				service.deleteHistoy(Integer.parseInt(str[i]));
			}
			entity = new ResponseEntity<String>("delete",HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
}
