package kostyle.help.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kostyle.help.domain.AdShoppingMall;
import kostyle.help.domain.BoardVO;
import kostyle.help.domain.Criteria;
import kostyle.help.persistence.BoardDAO;

@Service
public class BoardServiceImpl implements BoardService {

	@Inject
	private BoardDAO dao;
	
	@Override
	public List<BoardVO> list(Criteria cri)throws Exception {

		return dao.list(cri);
	}

	@Override
	public void insert(BoardVO boardVO)throws Exception {
		boardVO.setS_Num(dao.getS_Num(boardVO));
		boardVO.setC_Num((int)((Math.random()*10)+1)+"");
		System.out.println("BoardServiceImpl:"+boardVO);
		dao.insert(boardVO);
		

	}

	@Override
	public void delete(int q_Num)throws Exception {
		dao.delete(q_Num);

	}

	@Override
	public void update(BoardVO boardVO)throws Exception {
		dao.update(boardVO);

	}

	@Override
	public BoardVO detail(int q_Num)throws Exception {
		/*System.out.println("BoardServiceImpl:"+dao.detail());*/
		return dao.detail(q_Num);

	}

	@Override
	public List<AdShoppingMall> adShoppingMallList() throws Exception{
		
		return dao.adShoppingMallList();
	}

	@Override
	public int totalCount() throws Exception {
		
		return dao.totalCount();
	}
	
	
	
	

}
