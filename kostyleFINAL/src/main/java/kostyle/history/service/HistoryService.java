package kostyle.history.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import kostyle.history.domain.HistoryVO;

public interface HistoryService {

	public List<HistoryVO> listHistory(int c_Num);
	
	public void insertHistory(HistoryVO historyVO, HttpSession session);
	
	public void deleteHistoy(int h_Num);
}
