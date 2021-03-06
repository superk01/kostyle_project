package kostyle.history.persistence;

import java.util.List;

import kostyle.history.domain.HistoryCriteria;
import kostyle.history.domain.HistoryVO;

public interface HistoyDAO {

	public List<HistoryVO> listHistory(int c_Num, HistoryCriteria cri);
	
	public void insertHistory(HistoryVO historyVO);
	
	public void deleteHistoy(int h_Num);
	
	public int countHistory(int c_num);

	public List<HistoryVO> listHistory(int c_Num);
}