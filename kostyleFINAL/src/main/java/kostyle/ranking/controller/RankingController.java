package kostyle.ranking.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kostyle.ranking.domain.RankList;
import kostyle.ranking.domain.RankingCountVO;
import kostyle.ranking.domain.RankingUpdateVO;
import kostyle.ranking.service.RankingService;

@Controller
@RequestMapping("/ranking/*")
public class RankingController {
	
	@Inject
	private RankingService service;
	
	private static final Logger logger = LoggerFactory.getLogger(RankingController.class);
	
	@RequestMapping("/RankingMain")
	public String RankingMain(Model model) throws Exception{
		
		
		model.addAttribute("list", service.listRanking());


		
		return "ranking/RankingMain";
		
	}
	
	@RequestMapping("/Rankingsort") 
	public String Rankingsort() throws Exception {
		
		List<Integer> totalScore = new ArrayList<Integer>();
		List<RankList> updateRank = new ArrayList<RankList>();
		
		
		List<Integer> sumclickScore = service.sumclickScore();			//총 클릭된 점수
		List<Integer> favoriteScore = service.favoriteScore();			//즐겨찾기 한 점수
		
		List<String> showSnum = service.showsnum();		//snum 보여주기위한리스트.			
		List<Integer> showRank = service.showRank();		//s_rank에 넣을 리스트
		
		
		
		
		for(int i=0; i<sumclickScore.size(); i++) {
			int sum  = sumclickScore.get(i) + favoriteScore.get(i);
			totalScore.add(i, sum);
		
			System.out.println("리스트"+ i + ": " + totalScore.get(i));
			
			showRank.set(i, sum);
			System.out.println("진짜리스트"+ i + ": " + showRank.get(i));
			
			System.out.println("snum:" + showSnum.get(i));
			
			updateRank.add(new RankList(showSnum.get(i),showRank.get(i)));
			System.out.println(updateRank.get(i));

			service.updateRank(updateRank.get(i));			
		}
		System.out.println("완료");
		
		
		
		
		 

		
		return "redirect:/ranking/RankingMain";
		
	}
}
