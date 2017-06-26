package kostyle.coordinator.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import kostyle.coordinator.domain.CoordinatorVO;
import kostyle.coordinator.service.CoordinatorService;
import kostyle.coordinator.util.UploadFileUtils;

@Controller
@RequestMapping("/coordinator/*")
public class CoordinatorController {
	


	/*@Resource(name="uploadPath")
	private String uploadPath;*/
	
	/*private String uploadPath;*/
	
	@Inject
	private CoordinatorService service;
	
	@RequestMapping(value="coordiregister", method=RequestMethod.GET)
	public String coordiregisterGET(HttpSession session){
		/*if(session.getAttribute("shoplogin")==null){										//쇼핑몰 로긴이 아니면 로그인 창으로 보내려고 했는데
			return "/login/newShopLogin";													//인터셉터 쓰면 되겠네;;;
		}*/
		return "coordinator/coordiregister";
	}
	
	@RequestMapping(value="coordiregister", method=RequestMethod.POST)
	public String coordiregisterPOST(CoordinatorVO coordinatorVO, HttpServletRequest request){
		String contextPath = request.getSession().getServletContext().getRealPath("/");											//톰캣 서버의 context경로
		String uploadPath = contextPath+"resources/images/coordiuploadimg";														//이미지업로드 주소
		System.out.println("contnextPath:"+contextPath);								
		System.out.println("coordiregisterPOST:"+coordinatorVO);
		MultipartFile uploadfile = coordinatorVO.getUploadFile();																//폼에서 받은 파일
		if(uploadfile != null){
			String fileName = uploadfile.getOriginalFilename();																	//그 파일의 이름
			UUID uid = UUID.randomUUID();																						//업로드시 랜덤한 이름을 부여하기 위한 객체
			String savedName = uid.toString()+"_"+fileName;
			System.out.println("coordiregisterPOST:"+fileName);
			coordinatorVO.setCd_img(savedName);
			try {
				File file = new File(uploadPath+"/"+savedName);
				/*File file = new File(uploadPath+"/"+fileName);*/
				uploadfile.transferTo(file);
				service.register(coordinatorVO);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return "redirect:/coordinator/list";
	}
	@RequestMapping("list")
	public ModelAndView coordiList(HttpServletRequest request){
		/*String contextPath = request.getSession().getServletContext().getRealPath("/");*/
		String realPath = "resources/images/coordiuploadimg";
		List<CoordinatorVO> list = new ArrayList<>();
		list = service.coordiList();
		for(int i=0; i<list.size(); i++){
			list.get(i).setCd_img(realPath+"/"+list.get(i).getCd_img());
		}
		return new ModelAndView("coordinator/coordiLIst", "list", list);
		
	}

	
	
}
