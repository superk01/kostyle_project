package kostyle.discount.service;

import java.lang.Thread.State;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


import kostyle.category.bo.MainActionThread;
import kostyle.discount.domain.DiscountCrollingThread;
import kostyle.discount.domain.DiscountVO;
import kostyle.discount.domain.ShopDiscountVO;
import kostyle.discount.persistence.DiscountDAO;

@Service
public class DiscountServiceImpl implements DiscountService {
	@Inject
	private DiscountDAO dao;
	
	
	private static Logger logger = LoggerFactory.getLogger(DiscountServiceImpl.class);

	//쓰레드에 어떤url을써야하는지 판별시킬 키워드
	public static String DISURL ="DISURL";
	public static String NEWURL = "NEWURL";
	
	@Override
	public List<String> getNewSaleUrlList() {
		return dao.getNewSaleUrlList();
	}

	@Override
	public List<String> getDiscountUrlList() {
		return dao.getDiscountUrlList();
	}

	// Pattern pattern = Pattern.compile("<img[^>]*src=[\"']?([^>\"']+)[\"']?[^>]*>"); //img 태그 src 추출 정규표현식
	//가격: Pattern pattern = Pattern.compile("(\\d{1,3})+(,\\d{3})*");
	@Override
	public List<DiscountVO> discountUrlCrolling() {
		List<DiscountCrollingThread> threads = new ArrayList<DiscountCrollingThread>();
		List<DiscountVO> resultList = new ArrayList<DiscountVO>();
		
		//shopUrl구해와야함!!!!!!!!!!!!!!!!!!!!!!!!!
		List<ShopDiscountVO> shopVOs =  dao.getShopDiscountVOList();
		//List<ShopDiscountVO> shopVOs = new ArrayList<ShopDiscountVO>();
		System.out.println("shopVOs: "+shopVOs);
		int forCount =0;
		List<String> testList = dao.getNewSaleUrlList();
		
		//discountUrl이 null인값 VO미리 리스트에서 지우기
		Iterator<ShopDiscountVO> iter = shopVOs.iterator();
		while (iter.hasNext()) {
			ShopDiscountVO shopVO = iter.next();
			String crollUrl= shopVO.getS_discounturl();
		 
			if(crollUrl == null || crollUrl.equals("null")||crollUrl.equals("")||crollUrl.indexOf("stylenanda") != -1){
				iter.remove();
			}
		}
		System.out.println("shopVO리스트 null제거값: "+shopVOs);
		
		//쓰레드가 keyword와 shopVO객체 하나만받게하면?
		for(int i=0; i<shopVOs.size(); i++){
			threads.add(new DiscountCrollingThread(DISURL, shopVOs.get(i)));
			threads.get(i).start();
/*			String crollUrl= shopVOs.get(i).getS_discounturl();
			String shopUrl = shopVOs.get(i).getS_shopurl();
			String s_sname = shopVOs.get(i).getS_sname();
			crollUrl = urlFix(crollUrl);
			shopUrl = urlFix(shopUrl);	
			
			threads.add(new DiscountCrollingThread(crollUrl, shopUrl, s_sname)); 
			//				threadList.add(new MainActionThread(frontURL,shopurl, keyword));
*/		}
		
		List<DiscountVO> tempList = null; //tempList는 한번받아오고 다시반복설정되고, resultList에 모든값이들어감.
		
		  while(threads.size()!=0){
		         for (int i=0 ; i<threads.size(); i++){
		            if(threads.get(i).getState()==State.TERMINATED){
		               System.out.println("******"+i+"번째 스레드 종료*********");
		               tempList=threads.get(i).getResultVOList();                   //리스트에 스레드가 반환하는 리스트를 받음
		               /*nextPages = threads.get(i).getNextPages();*/
		               for(int j=0; j<tempList.size(); j++){                  //반환값안에 상품객체들이 여러개 있는데...
		                  resultList.add(tempList.get(j));                     //각 객체들을 다른 리스트안에 순차적으로 넣음.
		               }
		               //nextPages = threads.get(i).getNextPages();
		               threads.remove(i);
		               break;
		            }
		         }
		      }
	  System.out.println("DISURL크롤링 최종resultList: "+resultList);
		return resultList;
	}

	@Override
	public List<DiscountVO> newSaleUrlCrolling() {
		List<DiscountCrollingThread> threads = new ArrayList<DiscountCrollingThread>();
		List<DiscountVO> resultList = new ArrayList<DiscountVO>();
		
		//shopUrl구해와야함!!!!!!!!!!!!!!!!!!!!!!!!!
		List<ShopDiscountVO> shopVOs = dao.getShopDiscountVOList();
		int forCount =0;
		
		//discountUrl이 null인값 VO미리 리스트에서 지우기
		Iterator<ShopDiscountVO> iter = shopVOs.iterator();
		while (iter.hasNext()) {
			ShopDiscountVO shopVO = iter.next();
			String crollUrl= shopVO.getS_newsaleurl();
		 
			if(crollUrl == null || crollUrl.equals("null")||crollUrl.equals("")||crollUrl.indexOf("dejou") != -1){
				iter.remove();
			}
		}
		System.out.println("shopVO리스트 null제거값: "+shopVOs);
		
		//쓰레드가 keyword와 shopVO객체 하나만받게하면?
		for(int i=0; i<shopVOs.size(); i++){
			threads.add(new DiscountCrollingThread(NEWURL, shopVOs.get(i)));
			threads.get(i).start();

		}
		
		List<DiscountVO> tempList = null; //tempList는 한번받아오고 다시반복설정되고, resultList에 모든값이들어감.
		
		  while(threads.size()!=0){
		         for (int i=0 ; i<threads.size(); i++){
		            if(threads.get(i).getState()==State.TERMINATED){
		               System.out.println("******"+i+"번째 스레드 종료*********");
		               tempList=threads.get(i).getResultVOList();                   //리스트에 스레드가 반환하는 리스트를 받음
		               /*nextPages = threads.get(i).getNextPages();*/
		               for(int j=0; j<tempList.size(); j++){                  //반환값안에 상품객체들이 여러개 있는데...
		                  resultList.add(tempList.get(j));                     //각 객체들을 다른 리스트안에 순차적으로 넣음.
		               }
		               //nextPages = threads.get(i).getNextPages();
		               threads.remove(i);
		               break;
		            }
		         }
		      }
		  System.out.println("NEWURL크롤링 최종resultList: "+resultList);
		return resultList;
	}

	//url 양쪽공백, 개행 제거
	@Override
	public String urlFix(String url) {
		url = url.replace("\\n", "");
		url = url.replace("\n", "");
		url = url.trim();
		return url;
	}
	
/*	public static void main(String[] args) {
		DiscountServiceImpl service = new DiscountServiceImpl();
		service.discountUrlCrolling();
		service.newSaleUrlCrolling();
	}
	
	*/
	
	
}//class
