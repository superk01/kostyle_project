package kostyle.help.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import kostyle.help.domain.BoardVO;
import kostyle.help.service.BoardService;

@RestController
@RequestMapping("/help/*")
public class HelpController {
	
	@Inject
	private BoardService service;
	
	@RequestMapping("list")
	public ModelAndView list() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("list", service.list());
		mav.setViewName("help/list");
		return mav;
	}
}
