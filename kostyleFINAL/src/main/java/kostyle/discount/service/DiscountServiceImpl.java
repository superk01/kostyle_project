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
	
	//(A-B)/A*100
	
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
		List<String> discountUrlList = dao.getDiscountUrlList();
		List<DiscountCrollingThread> threads = new ArrayList<>();
		
		//shopUrl구해와야함!!!!!!!!!!!!!!!!!!!!!!!!!
		List<ShopDiscountVO> shopVOs = dao.getShopDiscountVOList();
		int forCount =0;
		
		Iterator<ShopDiscountVO> iter = shopVOs.iterator();
		while (iter.hasNext()) {
			ShopDiscountVO shopVO = iter.next();
			String crollUrl= shopVO.getS_discounturl();
		 
			if(crollUrl == null || crollUrl.equals("null")||crollUrl.equals("")||crollUrl.indexOf("stylenanda") != -1){
				iter.remove();
			}
		}
/*		label1:
		if(shopVOs.size() !=0){
			System.out.println("label1 분기");
			for(int i=shopVOs.size()-1; i>=0; i--){
				System.out.print(i+"  ");
				String crollUrl= shopVOs.get(i).getS_discounturl();
				if(crollUrl == null || crollUrl.equals("null")||crollUrl.equals("")){
					shopVOs.remove(i);
					if(shopVOs.size()==0){
						System.out.println("break label1");
						break label1;
					}
				}
			}
			
		}*/
		System.out.println("shopVO리스트 null제거값: "+shopVOs);
		
		for(int i=0; i<shopVOs.size(); i++){ 
			String crollUrl= shopVOs.get(i).getS_discounturl();
			String shopUrl = shopVOs.get(i).getS_shopurl();
			crollUrl = urlFix(crollUrl);
			shopUrl = urlFix(shopUrl);	
			
			threads.add(new DiscountCrollingThread(crollUrl, shopUrl)); 
			//				threadList.add(new MainActionThread(frontURL,shopurl, keyword));
			threads.get(i).start();
		}
		
		List<DiscountVO> resultList = new ArrayList<>();
		List<DiscountVO> tempList = null; //tempList는 한번받아오고 다시설정되고, resultList에 모든값이들어감.
		
		  while(threads.size()!=0){
		         for (int i=0 ; i<threads.size(); i++){
		            if(threads.get(i).getState()==State.TERMINATED){
		               System.out.println("******"+i+"번째 스레드 종료*********");
		               resultList=threads.get(i).getResultVOList();                   //리스트에 스레드가 반환하는 리스트를 받음
		               /*nextPages = threads.get(i).getNextPages();*/
		               for(int j=0; j<resultList.size(); j++){                  //반환값안에 상품객체들이 여러개 있는데...
		                  resultList.add(resultList.get(j));                     //각 객체들을 다른 리스트안에 순차적으로 넣음.
		               }
		               //nextPages = threads.get(i).getNextPages();
		               threads.remove(i);
		               break;
		            }
		         }
		      }
		/*while(threads.size() !=0){
			for(int i=0; i<shopVOs.size(); i++){
				int count=0;
				
					if(threads.get(i).getState() == State.TERMINATED){
						tempList = threads.get(i).getResultVOList(); //List안의 내용물 = 쓰레드에서찾아온 voList(리스트 내의 리스트)
						for(int j=0; j<tempList.size(); j++){
							resultList.add(tempList.get(j));
						}
						threads.remove(i); //i번째인덱스의 쓰레드 중지.
						count++;
						break;
					}
				}
		}*/
		return resultList;
	}

	@Override
	public List<DiscountVO> newSaleUrlCrolling() {
		List<String> newSaleUrlList = dao.getNewSaleUrlList();
		
		
		return null;
	}

	//url 양쪽공백, 개행 제거
	@Override
	public String urlFix(String url) {
		url = url.replace("\\n", "");
		url = url.replace("\n", "");
		url = url.trim();
		return url;
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
