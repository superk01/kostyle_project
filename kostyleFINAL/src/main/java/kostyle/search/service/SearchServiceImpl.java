package kostyle.search.service;

import java.lang.Thread.State;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kostyle.search.domain.JsoupThread;
import kostyle.search.domain.SearchVO;
import kostyle.search.persistence.SearchDAO;
@Service
public class SearchServiceImpl implements SearchService{

	@Inject
	private SearchDAO searchDao;
	
	@Override
	public List<String> getSearchUrl() {
		
		return searchDao.getSearchUrl();
	}

	@Override
	public List<SearchVO> doSearch(String keyword) {
		List<String> url = searchDao.getSearchUrl();
		List<JsoupThread> threads = new ArrayList<>();
		List<JsoupThread> subThreads = new ArrayList<>();
		for(int i=0; i<url.size(); i++){
			System.out.println("url"+i+"번지 주소 확인:"+url.get(i));
			threads.add(new JsoupThread(url.get(i)+keyword));
			threads.get(i).start();
		}
		List<SearchVO> result = new ArrayList<>();
		List<SearchVO> resultList = null;
		List<String> nextPages = new ArrayList<>();
	
		/*for(int i=url.size(); i<0; i--){
			int count=0;
			while(count<url.size()){
				if(threads.get(i).getState()==State.TERMINATED){				//쇼핑몰을 검색하는 스레드 중에 종료된 것이 있다면?
					System.out.println("******"+i+"번째 스레드 종료*********");
					resultList=threads.get(i).getResult();					 	//리스트에 스레드가 반환하는 리스트를 받음
					nextPages = threads.get(i).getNextPages();
					for(int j=0; j<resultList.size(); j++){						//반환값안에 상품객체들이 여러개 있는데...
						result.add(resultList.get(j));							//각 객체들을 다른 리스트안에 순차적으로 넣음.
					}
					threads.get(i).interrupt();									//스레드 종료....
					count++;													//count변수 1증가
					break;														//while문으로~~
				}
			}
		}*/
		/*int count = 0;
		while(count<url.size()){
			for(int i=0; i<url.size(); i++){
				System.out.println("********"+i+"번째 스레드 실행중.");
				if(threads.get(i).getState()==State.TERMINATED){
					System.out.println("******"+i+"번째 스레드 종료*********");
					resultList=threads.get(i).getResult();
					for(int j=0; j<resultList.size(); j++){						//반환값안에 상품객체들이 여러개 있는데...
						result.add(resultList.get(j));							//각 객체들을 다른 리스트안에 순차적으로 넣음.
					}
				}
				
				threads.get(i).interrupt();									//스레드 종료....
				count++;													//count변수 1증가
				break;
			}

		}*/
		while(threads.size()!=0){
			for (int i=0 ; i<threads.size(); i++){
				if(threads.get(i).getState()==State.TERMINATED){
					System.out.println("******"+i+"번째 스레드 종료*********");
					resultList=threads.get(i).getResult();					 	//리스트에 스레드가 반환하는 리스트를 받음
					/*nextPages = threads.get(i).getNextPages();*/
					for(int j=0; j<resultList.size(); j++){						//반환값안에 상품객체들이 여러개 있는데...
						result.add(resultList.get(j));							//각 객체들을 다른 리스트안에 순차적으로 넣음.
					}
					nextPages = threads.get(i).getNextPages();
					threads.remove(i);
					break;
				}
			}
		}
		if(nextPages != null){
			for(int i=0; i<nextPages.size(); i++){
				subThreads.add(new JsoupThread(nextPages.get(i)));
				subThreads.get(i).run();
			}
		}
		while(subThreads.size()!=0){
			for (int i=0 ; i<subThreads.size(); i++){
				if(subThreads.get(i).getState()==State.TERMINATED){
					System.out.println("******"+i+"번째 스레드 종료*********");
					resultList=subThreads.get(i).getResult();					 	//리스트에 스레드가 반환하는 리스트를 받음
					/*nextPages = threads.get(i).getNextPages();*/
					for(int j=0; j<resultList.size(); j++){						//반환값안에 상품객체들이 여러개 있는데...
						result.add(resultList.get(j));							//각 객체들을 다른 리스트안에 순차적으로 넣음.
					}
					nextPages = threads.get(i).getNextPages();
					threads.remove(i);
					break;
				}
			}
		}
		System.out.println("과연 페이지를 이동하여 크롤링을 할 수 있는가?ㅋㅋㅋ:"+result);
		return result;
	}

}
