package kostyle.stats.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import kostyle.stats.service.StatsService;

@Controller
@RequestMapping("/stats")
public class StatsController {

	@Inject
	private StatsService service;
	
	
}
