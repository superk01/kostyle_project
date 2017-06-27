package kostyle.closet.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import kostyle.closet.domain.Closet;
import kostyle.closet.domain.ClosetPrd;
import kostyle.closet.service.ClosetService;
import kostyle.login.controller.CusLoginController;
import kostyle.login.domain.CustomerVO;

@Controller
@RequestMapping("/closet/*")
public class ClosetController {

	@Inject
	ClosetService service;
	private static final Logger logger= LoggerFactory.getLogger(ClosetController.class);
	
	@RequestMapping(value="/")
	public String basicCloset(){
		return "/closet/closet";
	}
	@RequestMapping(value="/new")
	public String newCloset(){
		return "/closet/closet_bootstrap";
	}
	@RequestMapping(value="/new2")
	public String newCloset2(){
		return "/closet/closet_bootstrap02";
	}
	@RequestMapping(value="/closetManager", method= RequestMethod.GET)
	public String closetmanager(){
		
		return "/closet/closetManager_bootstrap";
	}
/*	@RequestMapping(value="/closetfolder")
	public String basicClosetFilder(){
		return "/closet/myClosetManager";
	}*/
	
	//옷장폴더선택시, 해당폴더의 상품들 나오는.
	@RequestMapping(value="/closetbasic" , method=RequestMethod.POST)
	public String closet(@RequestBody Map<Object,Object> param, HttpServletRequest request) throws Exception{
		System.out.println("/closet의 param(map): "+param);
		
		ResponseEntity<String> entity = null;
		HttpSession session = request.getSession();
		//System.out.println("session.getAttri('login'): "+ (String)((CustomerVO) session.getAttribute("login")).getC_num());
		
		try{
			Map map = service.closet(request, param); //"select_clo_num", "cloList" = List<ClosetPrd>, "cloTab" = List<Closet> 
			System.out.println("/closet의 return map: "+map);
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
			System.out.println("try끝부분");
		}catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			System.out.println("catch끝부분");
		}
//		return entity;
		return "/closet/closet_bootstrap";
		
	}
	

	@ResponseBody
	@RequestMapping(value="/duplicationCheckClosetPrd", method=RequestMethod.POST)
	public ResponseEntity<Integer> duplicationCheckClosetPrd(@RequestBody HashMap<String, String> prdUrl_Map, HttpServletRequest request)throws Exception{
		System.out.println("/duplicationCheckClosetPrd의 param(prdUrl): "+prdUrl_Map.get("prdUrl_Map"));

		String prdUrl = prdUrl_Map.get("prdUrl_Map");
		ResponseEntity<Integer> entity = null;
		//	HttpSession session = request.getSession();
			
		try{
			int dupliCount = service.duplicationCheckClosetPrd(request, prdUrl);	
			entity = new ResponseEntity<Integer>(dupliCount, HttpStatus.OK);
			
		}catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return entity;
		
	}
	
	
	@ResponseBody
	@RequestMapping(value="/insertPrd", method=RequestMethod.POST)
	public ResponseEntity<Integer> insertPrd(@RequestBody Map<Object,Object> param, HttpServletRequest request)throws Exception{
		//var param = "prdUrl="+prdUrl+"&currentUrl="+currentUrl;
		System.out.println("closetController-insertPrd 진입");
		System.out.println("/insertPrd의 param(map): "+param);

		ResponseEntity<Integer> entity = null;
		//	HttpSession session = request.getSession();
		
		try{
			int result = service.insertPrd(request, param);	
			entity = new ResponseEntity<Integer>(result, HttpStatus.OK);
			
		}catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return entity;
		
	}
	
	
	@ResponseBody
	@RequestMapping(value="/deleteClosetPrd", method=RequestMethod.POST)
	public ResponseEntity<String> deleteClosetPrd(@RequestBody Map<Object,Object> param, HttpServletRequest request) throws Exception{
		
		System.out.println("/deleteClosetPrd의 param(map): "+param);

		ResponseEntity<String> entity = null;
	//	HttpSession session = request.getSession();
		try{
			service.deleteClosetPrd(request, param);
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
			
		}catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return entity;
		
	}
	
	@ResponseBody
	@RequestMapping(value="/moveClosetPrd", method=RequestMethod.POST)
	public ResponseEntity<String> moveClosetPrd(@RequestBody Map<Object,Object> param, HttpServletRequest request) throws Exception{
		//	var param = "clo_detail_nums="+clo_detail_nums+"&move_clo_num="+move_clo_num+"&clo_num="+clo_num;
		
		System.out.println("/moveClosetPrd의 param(map): "+param);

		ResponseEntity<String> entity = null;
		//	HttpSession session = request.getSession();
		try{
			service.moveClosetPrd(request, param);
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
			
		}catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return entity;
		
	}
	
	
	
	
}//class
