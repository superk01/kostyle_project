package kostyle.closet.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import kostyle.closet.domain.Closet;
import kostyle.closet.service.ClosetService;
import kostyle.login.controller.CusLoginController;

@RestController
@RequestMapping("/closetfolder/*")
public class ClosetFolderController {
	
	@Inject
	ClosetService service;
	private static final Logger logger= LoggerFactory.getLogger(ClosetFolderController.class);
	/*
	@RequestMapping(value="/all/{bno}", method=RequestMethod.GET)
	public ResponseEntity<List<ReplyVO>> list(@PathVariable("bno") Integer bno){
		ResponseEntity<List<ReplyVO>> entity = null;
		
		try{
			entity = new ResponseEntity<>(service.listReply(bno), HttpStatus.OK);
			
		}catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	 * */

	@RequestMapping(value="/cdSessionAttribute" , method=RequestMethod.POST)
	public ResponseEntity<String> cdSessionAttribute(@RequestBody Map<Object,Object> param, HttpServletRequest request){
		ResponseEntity<String> entity = null;
		HttpSession session = request.getSession();
		
		List<Closet> closetTab = service.cdSessionAttribute(request, param);
		
		try{
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
			
		}catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	@RequestMapping(value="/saveCloset" , method=RequestMethod.POST)
	public void SaveCloset(@RequestBody Map<Object,Object> param, HttpServletRequest request){
		ResponseEntity<String> entity = null;
		
		System.out.println("");
		System.out.println("saveCloset컨트롤러 진입");
		try{
			service.saveCloset(request, param);
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
			
		}catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	
}//class
