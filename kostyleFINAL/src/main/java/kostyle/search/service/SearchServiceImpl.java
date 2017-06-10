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
		
		List<SearchVO> result = new ArrayList<>();
		if(searchDao.searchProduct(keyword).size() >0){
			result = searchDao.searchProduct(keyword);
			System.out.println("디비에 데이터가 있음요~:"+result);
		}else {
			List<String> url = searchDao.getSearchUrl();
			List<JsoupThread> threadList = new ArrayList<>();
			for(int i=0; i<url.size(); i++){
				threadList.add(new JsoupThread(url.get(i),keyword));
				threadList.get(i).start();
			}
			List<SearchVO> resultList = new ArrayList<>();
			while(threadList.size() !=0){
				for(int i=0; i<threadList.size(); i++){
					if(threadList.get(i).getState()==State.TERMINATED){
						resultList=threadList.get(i).getResult();
						
						for(int j=0; j<resultList.size(); j++){
							result.add(resultList.get(j));
						}
						
						threadList.remove(i);
						break;
					}
				}
			}
			for(int k=0; k<result.size(); k++){
				searchDao.insertproduct(result.get(k));
			}
		}
		System.out.println("최종결과:"+result);
		return result;
	}
}
