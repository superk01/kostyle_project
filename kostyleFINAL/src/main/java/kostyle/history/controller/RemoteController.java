package kostyle.history.controller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import kostyle.history.domain.HistoryVO;
import kostyle.history.service.HistoryService;
import kostyle.login.domain.CustomerVO;

@RestController
@RequestMapping("/remocon/*")
public class RemoteController {

	@Inject
	private HistoryService service;
	
	/*@RequestMapping(value="list/{c_num}", method=RequestMethod.GET)
	public ResponseEntity<String> remoconList(HttpSession session, @PathVariable("c_num") int c_num){
		ResponseEntity<String> entity = null;
		try {
			List<HistoryVO> list = service.listHistory(c_num);
			session.setAttribute("remoconList", list);
			entity = new ResponseEntity<String>("success", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return entity;
	}*/
	@RequestMapping(value="list/{c_num}", method=RequestMethod.GET)
	public ResponseEntity<String> remoconList(HttpSession session, @PathVariable("c_num") int c_num){
		ResponseEntity<String> entity = null;
		List<HistoryVO> list = new ArrayList<>(); 
		try {
			list = service.listHistory(c_num);
			session.setAttribute("remoconList", list);
			entity = new ResponseEntity<String>("success", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
/*	@RequestMapping(value="list/{c_num}", method=RequestMethod.GET)
	public ModelAndView remoconList(HttpSession session, @PathVariable("c_num") int c_num){
		System.out.println("리모콘 리스트 컨트롤러 호출!!!");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("history/remocon");
		List<HistoryVO> list = service.listHistory(c_num);
		System.out.println("remocon컨트롤러에서 list찍어보기:"+list);
		mav.addObject( "remoconList", list);
		mav.addObject("history_Num", service.countHistory(c_num));
		mav.addObject("c_num", c_num);
		return mav;
	}
*/}
