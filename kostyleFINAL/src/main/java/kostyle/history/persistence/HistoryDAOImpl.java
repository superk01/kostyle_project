package kostyle.history.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kostyle.history.domain.HistoryCriteria;
import kostyle.history.domain.HistoryVO;

@Repository
public class HistoryDAOImpl implements HistoyDAO{

	@Inject
	private SqlSession session;
	
	private static String namespace="kostyle.history.mappers.HistoryMapper";
	
	@Override
	public List<HistoryVO> listHistory(int c_Num, HistoryCriteria cri) {
		return session.selectList(namespace+".listHistory", c_Num, new RowBounds(cri.getPageStart(), cri.getPerPageNum()));
	}

	@Override
	public void insertHistory(HistoryVO historyVO) {
		session.insert(namespace+".insertHistory",historyVO);
		
	}

	@Override
	public void deleteHistoy(int h_Num) {
		session.delete(namespace+".deleteHistory", h_Num);
		
	}

	@Override
	public int countHistory(int c_num) {
		
		return session.selectOne(namespace+".countHistory", c_num);
	}

	@Override
	public List<HistoryVO> listHistory(int c_Num) {
		
		return session.selectList(namespace+".listHistory", c_Num);
	}

}
