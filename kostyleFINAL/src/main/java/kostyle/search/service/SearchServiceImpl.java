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
		for(int i=0; i<url.size()-1; i++){
			threads.add(new JsoupThread(url.get(i)+keyword));
			threads.get(i).start();
		}
		List<SearchVO> result = new ArrayList<>();
		List<SearchVO> resultList = null;
		for(int i=0; i<url.size()-1; i++){
			int count=0;
			while(count<url.size()){
				if(threads.get(i).getState()==State.TERMINATED){
					resultList=threads.get(i).getResult();
					for(int j=0; j<resultList.size(); j++){
						result.add(resultList.get(j));
					}
					threads.get(i).interrupt();
					count++;
					break;
				}
			}
		}
		return result;
	}

}
