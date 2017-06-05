package kostyle.help.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.xml.ws.Response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import kostyle.help.domain.ReplyVO;
import kostyle.help.service.ReplyService;

@RestController
@RequestMapping("/replies/*")
public class HelpReplyController {
	
	@Inject
	private ReplyService service;
	
	@RequestMapping(value="/", method=RequestMethod.POST)
	public ResponseEntity<String> register(@RequestBody ReplyVO replyVO){
		
		System.out.println("HelpReplyController-register:"+ replyVO);
		ResponseEntity<String> entity = null;
		
		try {
			service.ReplyInsert(replyVO);
			entity = new ResponseEntity<String>("success", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity= new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	/*@RequestMapping(value="/{q_Num}", method=RequestMethod.GET)
	public ResponseEntity<List<ReplyVO>> ReplyList(@PathVariable("q_Num") int q_Num){
		System.out.println("컨트롤러의 리스트 뽑는 메소드");
		
		ResponseEntity<Map<String, Object>> entity = null;
		List<ReplyVO> list = new ArrayList<>();
		try {
			list = service.ReplyList(q_Num);
			System.out.println("리플리스트의 맵:"+map);
			entity= new ResponseEntity<List<ReplyVO>>(HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<Map<String,Object>>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}*/
	

	@RequestMapping(value="/{q_Num}", method=RequestMethod.GET)
	public ResponseEntity<List<ReplyVO>> list(@PathVariable("q_Num") Integer q_Num)throws Exception {
		
		ResponseEntity<List<ReplyVO>> entity=null;
		
		try {
			entity=new ResponseEntity<>(service.ReplyList(q_Num), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity= new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			
		}
		
		return entity;
	}
/*	@RequestMapping(value="/{q_Num}", method=RequestMethod.GET)
	public ModelAndView ReplyList(@PathVariable("q_Num") int q_Num){
		List<ReplyVO> list = new ArrayList<>();
		list = service.ReplyList(q_Num);
		return new ModelAndView("help/replyList", "list", list);
	}
*/	
	@RequestMapping(value="/detail/{as_Num}", method=RequestMethod.GET)
	public ModelAndView ReplyDetail(@PathVariable("as_Num") int as_Num){
		System.out.println("ReplyDetail 진입");
		ReplyVO replyVO = service.ReplyDetail(as_Num);
		return new ModelAndView("help/reply_detail","reply",replyVO);
	}
}
