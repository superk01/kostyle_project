package kostyle.discount.service;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import discount.persistence.DiscountDAOImplTest;
import kostyle.discount.domain.DiscountCrollingThread;
import kostyle.discount.domain.DiscountVO;
import kostyle.discount.persistence.DiscountDAO;

@Service
public class DiscountServiceImpl implements DiscountService {
	@Inject
	private DiscountDAO dao;
	
	private static Logger logger = LoggerFactory.getLogger(DiscountServiceImpl.class);
	
	//(A-B)/A*100
	
	@Override
	public List<String> getNewSaleUrlList() {
		return dao.getNewSaleUrlList();
	}

	@Override
	public List<String> getDiscountUrlList() {
		return dao.getDiscountUrlList();
	}

	@Override
	public List<DiscountVO> discountUrlCrolling() {
		List<String> discountUrlList = dao.getDiscountUrlList();
		List<DiscountCrollingThread> threads = new ArrayList<>();
		for(int i=0; i<discountUrlList.size(); i++){ 
			threads.add(new DiscountCrollingThread(discountUrlList.get(i)));
			threads.get(i).start();
		}
		
		List<DiscountVO> resultList = new ArrayList<>();
		List<DiscountVO> tempList = null;
		for(int i=0; i<discountUrlList.size(); i++){
			
		}
		
		
		
		
		return null;
	}

	@Override
	public List<DiscountVO> newSaleUrlCrolling() {
		List<String> newSaleUrlList = dao.getNewSaleUrlList();
		
		
		return null;
	}

	//할인율계산
	@Override
	public int discountRateCal(String sale_beforeDiscountprice, String sale_afterDiscountprice) {
		// TODO Auto-generated method stub
		return 0;
	}

	//쇼핑몰이름
	public String getS_name(String sale_prdUrl) {
		String s_name = "";
		if(sale_prdUrl.indexOf("66girls.co.kr") != -1){
			s_name = "66걸즈";
		}else if(sale_prdUrl.indexOf("www.stylenanda.com") != -1 ){
			s_name = "스타일난다";
		}else if(sale_prdUrl.indexOf("ggsing.com") != -1){
			s_name = "고고싱";
		}else if(sale_prdUrl.indexOf("loveloveme.com") != -1){
			s_name = "러브러브미";
		}else if(sale_prdUrl.indexOf("hotping.co.kr") != -1){
			s_name = "핫핑";
		}else if(sale_prdUrl.indexOf("www.dejou.co.kr") != -1){
			s_name = "더데이즈";
		}else if(sale_prdUrl.indexOf("imvely.com") != -1){
			s_name = "임블리";
		}
		return s_name;
	}


	
	
	
	
}//class
