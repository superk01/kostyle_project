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
			entity = new ResponseEntity<String>("success", HttpStatus.OK);
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
		String[] str = request.getParameter("h_num").toString().split(",");
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
