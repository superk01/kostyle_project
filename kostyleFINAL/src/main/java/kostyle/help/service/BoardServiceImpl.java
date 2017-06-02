package kostyle.help.service;

import static org.hamcrest.CoreMatchers.instanceOf;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import javax.swing.plaf.synth.SynthSeparatorUI;

import org.springframework.stereotype.Service;

import kostyle.help.domain.AdShoppingMall;
import kostyle.help.domain.BoardVO;
import kostyle.help.domain.Criteria;
import kostyle.help.persistence.BoardDAO;
import kostyle.login.domain.CustomerVO;

@Service
public class BoardServiceImpl implements BoardService {

	@Inject
	private BoardDAO dao;
	
	@Override
	public List<BoardVO> list(Criteria cri, HttpSession session)throws Exception {
		List<BoardVO> list = dao.list(cri);
		Object userVO = session.getAttribute("login");
		CustomerVO customerVO = null;
		if(userVO instanceof CustomerVO){
			customerVO = (CustomerVO)userVO;
		}
		
		for(BoardVO vo:list){
			System.out.println(vo.getC_Id());
			System.out.println(vo.getQ_Secret());
			if(vo.getQ_Secret().equals("y")){
				if(userVO==null){
					vo.setQ_Title("비밀글입니다.");
				}else{
					String writer = vo.getC_Id();
					if(!customerVO.getC_id().equals(writer)){
						vo.setQ_Title("비밀글입니다.");
					}
				}
			}
		}
		return list;
	}

	@Override
	public void insert(BoardVO boardVO)throws Exception {
		boardVO.setS_Num(dao.getS_Num(boardVO));
		boardVO.setC_Num((int)((Math.random()*10)+1)+"");
		System.out.println("BoardServiceImpl:"+boardVO);
		if(boardVO.getQ_Secret()==null){
			boardVO.setQ_Secret("n");
		}else{
			boardVO.setQ_Secret("y");
		}
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
	public BoardVO detail(int q_Num, HttpSession session)throws Exception {
		/*System.out.println("BoardServiceImpl:"+dao.detail());*/
		BoardVO boardVO = dao.detail(q_Num);
		Object userVO = session.getAttribute("login");
		if(userVO instanceof CustomerVO){
			
		}
		return boardVO;

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
