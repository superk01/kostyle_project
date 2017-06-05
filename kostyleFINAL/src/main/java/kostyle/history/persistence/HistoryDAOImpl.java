package kostyle.history.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kostyle.history.domain.HistoryVO;

@Repository
public class HistoryDAOImpl implements HistoyDAO{

	@Inject
	private SqlSession session;
	
	private static String namespace="kostyle.history.mappers.HistoryMapper";
	
	@Override
	public List<HistoryVO> listHistory(int c_Num) {
		return session.selectList(namespace+".listHistory", c_Num);
	}

	@Override
	public void insertHistory(HistoryVO historyVO) {
		session.insert(namespace+".insertHistory",historyVO);
		
	}

	@Override
	public void deleteHistoy(int h_Num) {
		session.delete(namespace+".deleteHistory", h_Num);
		
	}

}
