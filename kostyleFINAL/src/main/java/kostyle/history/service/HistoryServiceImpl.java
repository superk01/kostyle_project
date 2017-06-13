package kostyle.history.service;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import kostyle.history.domain.HistoryCriteria;
import kostyle.history.domain.HistoryVO;
import kostyle.history.persistence.HistoyDAO;
import kostyle.login.domain.CustomerVO;

@Service
public class HistoryServiceImpl implements HistoryService{

	@Inject
	private HistoyDAO dao;
	
	@Override
	public List<HistoryVO> listHistory(int c_Num, HistoryCriteria cri) {
		
		return dao.listHistory(c_Num, cri);
	}

	@Override
	public void insertHistory(HistoryVO historyVO, HttpSession session) {
		Object userVO = session.getAttribute("login");
		CustomerVO customerVO=null;
		if(userVO instanceof CustomerVO){
			customerVO = (CustomerVO)userVO;
		}
		System.out.println(customerVO.getC_num());
		historyVO.setC_Num(customerVO.getC_num());
		
		dao.insertHistory(historyVO);
		
	}

	@Override
	public void deleteHistoy(int h_Num) {
		dao.deleteHistoy(h_Num);
		
	}

	@Override
	public int countHistory(int c_num) {
		return dao.countHistory(c_num);
	}

	@Override
	public List<HistoryVO> listHistory(int c_Num) {
		
		return dao.listHistory(c_Num);
	}

}
