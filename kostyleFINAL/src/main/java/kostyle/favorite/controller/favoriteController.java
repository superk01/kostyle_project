package kostyle.favorite.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import kostyle.favorite.service.FavoriteService;

@Controller
@RequestMapping("/favorite/*")
public class favoriteController {
	
	private static final Logger logger = LoggerFactory.getLogger(favoriteController.class);

	private FavoriteService service;
	
	//즐겨찾기 리스트를 보여줌
		@RequestMapping(value = "/favoriteList", method = RequestMethod.GET)
		   public void favoriteList(Model model) throws Exception {
			
			System.out.println("favorite List(controller) ..........");
			//model.addAttribute("list", service.favoriteList());
			
		   }

}
