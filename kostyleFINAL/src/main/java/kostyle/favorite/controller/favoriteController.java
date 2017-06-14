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
		   
		   
		   @RequestMapping(value="/addFavorite/{s_shopurl}", method=RequestMethod.POST)
		   public void addFavorite(Favorite favorite, HttpSession session)throws Exception{
			   
			   CustomerVO login = (CustomerVO) session.getAttribute("login");
			   System.out.println(login.getC_num());
			   String c_num = login.getC_num();
			   favorite.setC_num(c_num);
			   
			   service.addFavorite(favorite);
			   
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










