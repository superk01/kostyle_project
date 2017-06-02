package kostyle.help.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import kostyle.help.domain.AdShoppingMall;
import kostyle.help.domain.BoardVO;
import kostyle.help.domain.Criteria;

public interface BoardService {
	
	public List<BoardVO> list(Criteria cri, HttpSession session)throws Exception;					
	
	public void insert(BoardVO baBoardVO)throws Exception;				

	public void delete(int q_Num)throws Exception;						
	
	public void update(BoardVO boardVO)throws Exception;				
	
	public BoardVO detail(int q_Num, HttpSession session)throws Exception;						
	
	public List<AdShoppingMall> adShoppingMallList()throws Exception; 
	
	public int totalCount()throws Exception;
}
