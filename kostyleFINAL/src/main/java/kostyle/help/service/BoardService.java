package kostyle.help.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import kostyle.help.domain.AdShoppingMallHelp;
import kostyle.help.domain.BoardVO;
import kostyle.help.domain.Criteria;
import kostyle.help.domain.SearchCriteria;

public interface BoardService {
	
	public List<BoardVO> list(SearchCriteria cri, HttpSession session)throws Exception;					
	
	public void insert(BoardVO baBoardVO, HttpSession session)throws Exception;				

	public void delete(int q_Num)throws Exception;						
	
	public void update(BoardVO boardVO)throws Exception;				
	
	public BoardVO detail(int q_Num, HttpSession session)throws Exception;						
	
	public BoardVO detail(int q_Num)throws Exception;	
	
	public List<AdShoppingMallHelp> adShoppingMallList()throws Exception; 
	
	public int totalCount(SearchCriteria cri)throws Exception;
}
