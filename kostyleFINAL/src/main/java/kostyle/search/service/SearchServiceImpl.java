package kostyle.search.service;

import java.lang.Thread.State;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kostyle.search.domain.GetColorThread;
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
<<<<<<< HEAD
		List<JsoupThread> subThreads = new ArrayList<>();
		/*for(int i=0; i<url.size(); i++){
			System.out.println("url"+i+"번지 주소 확인:"+url.get(i));*/
			threads.add(new JsoupThread(url.get(0)+keyword));
			threads.get(0).start();
		/*}*/
		List<SearchVO> result = new ArrayList<>();
		List<SearchVO> resultList = null;
=======
		/*List<JsoupThread> subThreads = new ArrayList<>();*/
		/*for(int i=0; i<url.size(); i++){
			System.out.println("url"+i+"번지 주소 확인:"+url.get(i));
			threads.add(new JsoupThread(url.get(i)+keyword));
			threads.get(0).start();
		}*/
		
		/*List<SearchVO> resultList = null;*/
>>>>>>> branch 'master' of https://github.com/superk01/kostyle_project
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
<<<<<<< HEAD
=======
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
		/*while(threads.size()!=0){
			for(int i=0; i<threads.size(); i++){
				System.out.println("스레드 삭제 확인1111:"+threads.size());
				if(threads.get(i).getState()==State.TERMINATED){
					resultList=threads.get(i).getResult();
					for(int j=0; j<resultList.size();j++){
						result.add(resultList.get(j));
>>>>>>> branch 'master' of https://github.com/superk01/kostyle_project
					}
<<<<<<< HEAD
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
=======
					threads.remove(i);
					System.out.println("스레드 삭제 확인1111:"+threads.size());
							
				}
			}
		}*/
	/*	while(threads.size()!=0){
			for (int i=0 ; i<threads.size(); i++){
				if(threads.get(i).getState()==State.TERMINATED){
					System.out.println("******"+i+"번째 스레드 종료*********");
					resultList=threads.get(i).getResult();					 	//리스트에 스레드가 반환하는 리스트를 받음
					nextPages = threads.get(i).getNextPages();
>>>>>>> branch 'master' of https://github.com/superk01/kostyle_project
					for(int j=0; j<resultList.size(); j++){						//반환값안에 상품객체들이 여러개 있는데...
						result.add(resultList.get(j));							//각 객체들을 다른 리스트안에 순차적으로 넣음.
					}
					nextPages = threads.get(i).getNextPages();
					threads.get(i).interrupt();
					threads.remove(i);
					if(nextPages != null){
						for(int in=0; in<nextPages.size(); in++){
							subThreads.add(new JsoupThread(nextPages.get(in)));
<<<<<<< HEAD
							subThreads.get(in).run();
						}
						while(subThreads.size()!=0){
							for (int in=0 ; in<subThreads.size(); in++){
								if(subThreads.get(in).getState()==State.TERMINATED){
									System.out.println("******"+in+"번째 스레드 종료*********");
									resultList=subThreads.get(in).getResult();					 	//리스트에 스레드가 반환하는 리스트를 받음
									/*nextPages = threads.get(i).getNextPages();*/
=======
							subThreads.get(in).start();
						}
						while(subThreads.size()!=0){
							for (int in=0 ; in<subThreads.size(); in++){
								if(subThreads.get(in).getState()==State.TERMINATED){
									System.out.println("******"+in+"번째 스레드 종료*********");
									resultList=subThreads.get(in).getResult();					 	//리스트에 스레드가 반환하는 리스트를 받음
									nextPages = threads.get(i).getNextPages();
>>>>>>> branch 'master' of https://github.com/superk01/kostyle_project
									for(int j=0; j<resultList.size(); j++){						//반환값안에 상품객체들이 여러개 있는데...
										result.add(resultList.get(j));							//각 객체들을 다른 리스트안에 순차적으로 넣음.
									}
									subThreads.get(in).interrupt();
									subThreads.remove(in);
									break;
								}
							}
						}
						System.out.println("과연 페이지를 이동하여 크롤링을 할 수 있는가?ㅋㅋㅋ:"+result);
					}
					break;
				}
			}
		}*/
		/*List<GetColorThread> getColorListThread = new ArrayList<>();
		List<String> colorList = new ArrayList<>();
		for(int i=0; i<result.size(); i++){
			getColorListThread.add(new GetColorThread(result.get(i).getProduct_link()));
			getColorListThread.get(i).start();
		}
<<<<<<< HEAD
		
		
=======
		while(getColorListThread.size() !=0){
			for(int i=0; i<getColorListThread.size(); i++){
				if(getColorListThread.get(i).getState()==State.TERMINATED){
					colorList.add(getColorListThread.get(i).getColorList());
				}
				getColorListThread.get(i).interrupt();
				getColorListThread.remove(i);
				break;
			}
		}
		for(int i=0; i<colorList.size(); i++){
			result.get(i).setProduct_color(colorList.get(i));
		}*/
		/*for(int i=0; i<url.size(); i++){
			System.out.println("url"+i+"번지 주소 확인:"+url.get(i));
			threads.add(new JsoupThread(url.get(i)+keyword));
			threads.get(0).start();
		}*/
		List<JsoupThread> threadList = new ArrayList<>();
		for(int i=0; i<url.size(); i++){
			threadList.add(new JsoupThread(url.get(i)+keyword));
			threadList.get(i).start();
		}
		List<SearchVO> resultList = new ArrayList<>();
		List<SearchVO> result = new ArrayList<>();
		while(threadList.size() !=0){
			for(int i=0; i<threadList.size(); i++){
				/*System.out.println(threadList.get(i).getState());*/
				if(threadList.get(i).getState()==State.TERMINATED){
					/*System.out.println("333333어디서 에러남3333333?");*/
					/*System.out.println("색상 추출하는 "+i+"번째 스레드 종료!!!");*/
					resultList=threadList.get(i).getResult();
					/*System.out.println("resultList확인:"+resultList);*/
					
					for(int j=0; j<resultList.size(); j++){
						result.add(resultList.get(j));
					}
					/*System.out.println("4444444어디서 에러남4444444?");*/
					threadList.remove(i);
					break;
				}
			}
		
	}
		System.out.println("최종결과:"+result);
>>>>>>> branch 'master' of https://github.com/superk01/kostyle_project
		return result;
	}
}
