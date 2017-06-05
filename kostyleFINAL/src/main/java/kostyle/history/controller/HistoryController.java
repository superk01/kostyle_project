package kostyle.history.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import javax.xml.ws.Response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

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
	public ModelAndView listHistory(@PathVariable("c_Num") int c_Num){
		return new ModelAndView("history/history", "list", service.listHistory(c_Num));
	}
	
	@RequestMapping(value="delete/{h_Num}", method=RequestMethod.DELETE)
	public ResponseEntity<String> deleteHistory(@PathVariable("h_Num") int h_Num){
		System.out.println("deleteHistory진입");
		ResponseEntity<String> entity= null;
		try {
			service.deleteHistoy(h_Num);
			entity = new ResponseEntity<String>("delete",HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
}
