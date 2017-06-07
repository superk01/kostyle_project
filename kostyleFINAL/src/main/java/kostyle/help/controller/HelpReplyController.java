package kostyle.help.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.ws.Response;

import org.apache.catalina.tribes.group.interceptors.ThroughputInterceptor;
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
	
	/*댓글 등록 메소드*/
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
	

	/*@RequestMapping(value="/{q_Num}", method=RequestMethod.GET)
	public ResponseEntity<List<ReplyVO>> list(@PathVariable("q_Num") Integer q_Num)throws Exception {
		
		ResponseEntity<List<ReplyVO>> entity=null;
		
		try {
			entity=new ResponseEntity<>(service.ReplyList(q_Num), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity= new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			
		}
		
		return entity;
	}*/
	/*댓글 목록 뽑는 메소드*/
	@RequestMapping(value="/{q_Num}", method=RequestMethod.GET)
	public ModelAndView ReplyList(@PathVariable("q_Num") int q_Num){
		System.out.println("ReplyList진입.");
		List<ReplyVO> list = new ArrayList<>();
		list = service.ReplyList(q_Num);
		System.out.println("HelpReplyController-ReplyList:"+list);
		return new ModelAndView("help/replyList", "list", list);
	}
	
	/*댓글 상세 보기(일단은 필요 없는 걸로...)*/
	@RequestMapping(value="/{q_Num}/{as_Num}", method=RequestMethod.GET)
	public ModelAndView ReplyDetail(@PathVariable("as_Num") int as_Num, @PathVariable("q_Num") int q_Num, HttpSession session){
		System.out.println("ReplyDetail 진입");
		ReplyVO replyVO = service.ReplyDetail(as_Num,q_Num,session);
		return new ModelAndView("help/reply_detail","reply",replyVO);
	}
	/*댓글 수정 폼 가져오는 메소드*/
	/*@RequestMapping(value="/{as_Num}", method=RequestMethod.POST)
	public ResponseEntity<ReplyVO> ReplyUpatePOST(@PathVariable("as_Num") int as_Num){
		System.out.println("HelpReplyController-ReplyUpdatePOST진입");
		ResponseEntity<ReplyVO> entity = null;
		ReplyVO replyVO = service.ReplyDetail(as_Num);
		System.out.println("replyVO객체 생성 :"+replyVO);
		System.out.println("HelpReplyController-ReplyUpdatePOST:"+replyVO);
		
		try {
			entity = new ResponseEntity<ReplyVO>(replyVO, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<ReplyVO>(HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}*/
	
	/*댓글 수정폼 가져오는 메소드 another*/
	@RequestMapping(value="/{as_Num}", method=RequestMethod.POST)
	public ReplyVO ReplyUpatePOST(@PathVariable("as_Num") int as_Num){
		System.out.println("HelpReplyController-ReplyUpdatePOST진입");
		ReplyVO replyVO = service.ReplyDetail(as_Num);
		System.out.println("HelpReplyController-ReplyUpdatePOST에서 replyVO객체 가져옴:"+replyVO);
		return replyVO;
	}
	/*댓글을 삭제하는 메소드*/
	
	
	/*댓글 삭제 메소드*/
	@RequestMapping(value="/{as_Num}", method=RequestMethod.DELETE)
	public ResponseEntity<String> ReplyDelete(@PathVariable("as_Num") int as_Num, HttpServletResponse response)throws Exception{
		ResponseEntity<String> entity = null;
		try {
			service.ReplyDelete(as_Num);
			entity = new ResponseEntity<>("delete", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
		return entity;
		
		//아래는 삽질입니다;;;
		/*System.out.println("ReplyDelete진입");
		
		ReplyVO replyVO = service.ReplyDetail(as_Num);
		
		service.ReplyDelete(as_Num);
		System.out.println("ReplyDelete에서 댓글 삭제");
		System.out.println("ReplyDelete:"+replyVO.getQ_Num());
		return "redirect:/replies/"+replyVO.getQ_Num();
		return new ModelAndView(viewName)
		String path = "replies/"+replyVO;
		System.out.println("ReplyDelete-path:"+path);
		response.sendRedirect(path);*/
	}
}
