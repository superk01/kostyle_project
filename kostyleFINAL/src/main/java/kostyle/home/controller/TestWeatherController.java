package kostyle.home.controller;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kostyle.category.bo.MS949_CategoryWeatherGet;
import kostyle.category.bo.Weather_pick_keyword;
import kostyle.category.domain.Product_category;
import kostyle.category.domain.Weather;
import kostyle.category.service.CategoryService;

@Controller
@RequestMapping("/weather/*")
public class TestWeatherController {
	
	@Inject
	CategoryService service;
	
	MS949_CategoryWeatherGet getWeather = new MS949_CategoryWeatherGet();
	
	@RequestMapping(value = "/showweather", method=RequestMethod.GET	)
	public void getWeatherGET(){}
	
	@RequestMapping(value = "/showweather")
	public ResponseEntity<List<Product_category>> getWeatherPOST(@RequestParam(value="value", required = false) String value, Model model) throws Exception{
		Weather_pick_keyword wpk = new Weather_pick_keyword();
		Weather weather = getWeather.start();	
		String keyword = wpk.getWeather_pick_Data(weather, value);
		List<Product_category> list = service.product_Search(keyword);
		System.out.println(list.size());
		ResponseEntity<List<Product_category>> ent = new ResponseEntity<List<Product_category>>(list, HttpStatus.ACCEPTED);
		return ent;
	}
}
