package kostyle.help.controller;

import java.util.HashMap;
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

import kostyle.help.domain.ReplyVO;
import kostyle.help.service.ReplyService;

@RestController
@RequestMapping("/replies")
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
	
	@RequestMapping(value="/{q_Num}", method=RequestMethod.GET)
	public ResponseEntity<Map<String, Object>> ReplyList(@PathVariable("q_Num") int q_Num){
		ResponseEntity<Map<String, Object>> entity = null;
		Map<String, Object> map = new HashMap<>();
		try {
			map.put("list",service.ReplyList(q_Num));
			entity= new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<Map<String,Object>>(HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}
}
