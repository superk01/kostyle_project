package kostyle.favorite.controller;


import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kostyle.favorite.domain.Favorite;
import kostyle.favorite.domain.FavoriteAdd;
import kostyle.favorite.domain.FavoriteCriteria;
import kostyle.favorite.domain.FavoritePageMaker;
import kostyle.favorite.service.FavoriteService;
import kostyle.help.domain.Criteria;
import kostyle.login.domain.CustomerVO;

@Controller
@RequestMapping("/favorite/*")
public class favoriteController {
	
	private static final Logger logger = LoggerFactory.getLogger(favoriteController.class);

	@Inject
	private FavoriteService service;
	
	//즐겨찾기 리스트를 보여줌
		/*@RequestMapping(value = "/favoriteList", method = RequestMethod.GET)
		   public void favoriteList(Model model) throws Exception {
			
			System.out.println("favorite List(controller) ..........");
			model.addAttribute("list", service.listFavorite_S());
		   }*/
	
	
	
		   @RequestMapping(value = "/favoriteList", method = RequestMethod.GET)
		   public String favoriteList(@ModelAttribute("Cri")FavoriteCriteria cri,
				   Model model, HttpSession session) throws Exception {
			   System.out.println("controller###############"); 
			   try {
				   CustomerVO login = (CustomerVO) session.getAttribute("login");
				   System.out.println(login.getC_num());
				   String c_num = login.getC_num();
				   model.addAttribute("list", service.listFavoriteCriteria(c_num, cri));
				   
				   FavoritePageMaker pageMaker = new FavoritePageMaker();
				   pageMaker.setCri(cri);
				      
				   pageMaker.setTotalCount(service.listCountCriteria(c_num, cri));
				      
	        	   model.addAttribute("pageMaker", pageMaker);
	        	   return null;
			} catch (Exception e) {
				return "redirect:/cuslogin/login";
			}
			   
		   }
		   
		   
		   @RequestMapping(value="/addFavorite", method=RequestMethod.GET)
		   public String addFavorite(@RequestParam("s_shopurl") String s_shopurl, FavoriteAdd favoriteAdd, HttpSession session)throws Exception{
			   
			   System.out.println("즐겨찾기 추가 컨트롤러");
			   
			   //1. f_num 자동으로 insert
				String num1 = service.autoF_num();
				System.out.println("즐겨찾기 f_num1 : " + num1);
				
				int num2 = Integer.parseInt(num1);
				System.out.println("즐겨찾기 f_num2 : " + num2);
				
				int num3 = num2 + 1;
				System.out.println("즐겨찾기 f_num3 : " + num3);
				
				String num4 = num3 + "";
				System.out.println("즐겨찾기 f_num4 : " + num4);
				
				favoriteAdd.setF_num(num4);
				System.out.println("1 : " + favoriteAdd.toString());
			   
			   //2. s_num (iframe의 s_shopurl에 따른 s_num)
			   String s_num = service.iframeS_num(s_shopurl);
			   System.out.println("즐겨찾기 s_num : " + s_num);
				
			   favoriteAdd.setS_num(s_num);
			   System.out.println("2 : " + favoriteAdd.toString());
				
			   //3. c_num 
			   CustomerVO login = (CustomerVO) session.getAttribute("login");
			   System.out.println(login.getC_num());
			   String c_num = login.getC_num();
			   favoriteAdd.setC_num(c_num);
			   
			   System.out.println("즐겨찾기 추가 : " + favoriteAdd.toString());
			   System.out.println("중복 : " + service.overlapFavorite(s_num, c_num));
			   if(service.overlapFavorite(s_num, c_num) == 0){
				  
				   System.out.println("#########즐겨찾기 추가 완료전#########");
				   service.addFavorite(favoriteAdd);
				   //즐겨찾기에 추가되었다는 알림이 떠야함
				   System.out.println("#########즐겨찾기 추가 완료#########");
			   }else{
				   System.out.println("#########즐겨찾기 이미 추가#########");
			   }
			   
			   return "redirect:/favorite/favoriteList";
			   
		   }
	
		   
		   @RequestMapping(value="/comentRead", method=RequestMethod.GET)
		   public void comentRead(@RequestParam("f_num") String f_num, @ModelAttribute("cri")FavoriteCriteria cri,
				   Model model) throws Exception{
			   model.addAttribute(service.comentRead(f_num));
		   }
		   
		   
		   @RequestMapping(value = "/comentModify", method = RequestMethod.GET)
		   public void comentModify(@RequestParam("f_num") String f_num, @ModelAttribute("cri")Criteria cri,
				   Model model)throws Exception{
			   model.addAttribute(service.comentRead(f_num));
		   }
		   
		   
		   @RequestMapping(value = "/comentModify", method = RequestMethod.POST)
		   public String modifyPOST(Favorite favorite, FavoriteCriteria cri, RedirectAttributes rttr)throws Exception{
			   service.comentModify(favorite);
			   System.out.println("컨트롤러 : " + favorite.toString());
			   rttr.addFlashAttribute("page", cri.getPage());
			   rttr.addFlashAttribute("perPageNum", cri.getPerPageNum());
			   rttr.addFlashAttribute("msg", "SUCCESS");
			   
			   return "redirect:/favorite/favoriteList";
		   }
		  // @PathVariable("bno") Integer bno
		   
		   @RequestMapping(value="/deleteFavorite", method=RequestMethod.GET)
		   public String deleteFavorite(@RequestParam("f_num") String f_num, FavoriteCriteria cri, 
				   HttpSession session, RedirectAttributes rttr) throws Exception{
			   
			   CustomerVO login = (CustomerVO) session.getAttribute("login");
			   System.out.println(login.getC_num());
			   String c_num = login.getC_num();
			   
			   service.deleteFavorite(c_num, f_num);
			   rttr.addFlashAttribute("page", cri.getPage());
			   rttr.addFlashAttribute("perPageNum", cri.getPerPageNum());
			   rttr.addFlashAttribute("msg", "SUCCESS");
			   
			   return "redirect:/favorite/favoriteList";
		   }


		   
}










