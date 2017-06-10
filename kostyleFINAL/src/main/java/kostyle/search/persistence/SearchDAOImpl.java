package kostyle.search.persistence;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kostyle.search.domain.SearchVO;
@Repository
public class SearchDAOImpl implements SearchDAO{
	
	@Inject
	private SqlSession session;

	private static String namespace="kostyle.search.mappers.searchMapper";
	
	@Override
	public List<String> getSearchUrl() {
		return session.selectList(namespace+".getSearchUrl");
	}

	@Override
	public List<SearchVO> searchProduct(String keyword) {
		List<SearchVO> list = null;
		list = session.selectList(namespace+".searchproduct", keyword);
		System.out.println("DAO에서 리스트 확인:"+list);
		if(list.size()==0){
			System.out.println("null 입니다....");
		}else{
			System.out.println("null이 아닙니다....");
		}
		return list;
	}

	@Override
	public void insertproduct(SearchVO searchVO) {
		session.insert(namespace+".insertproduct", searchVO);
		
	}

}
