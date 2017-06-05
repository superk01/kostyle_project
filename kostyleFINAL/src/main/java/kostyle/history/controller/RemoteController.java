package kostyle.history.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

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
	
	@RequestMapping(value="list/{c_num}", method=RequestMethod.GET)
	public ModelAndView remoconList(HttpSession session, @PathVariable("c_num") int c_num){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("history/remocon");
		List<HistoryVO> list = service.listHistory(c_num);
		mav.addObject( "list", list);
		mav.addObject("history_Num", service.countHistory(c_num));
		mav.addObject("c_num", c_num);
		return mav;
	}
}
