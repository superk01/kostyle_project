package kostyle.help.service;

import static org.hamcrest.CoreMatchers.instanceOf;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import javax.swing.plaf.synth.SynthSeparatorUI;

import org.springframework.stereotype.Service;
import org.w3c.dom.css.CSSUnknownRule;

import kostyle.help.domain.AdShoppingMallHelp;
import kostyle.help.domain.BoardVO;
import kostyle.help.domain.Criteria;
import kostyle.help.domain.SearchCriteria;
import kostyle.help.persistence.BoardDAO;
import kostyle.login.domain.CustomerVO;

@Service
public class BoardServiceImpl implements BoardService {

	@Inject
	private BoardDAO dao;
	
	@Override
	public List<BoardVO> list(SearchCriteria cri, HttpSession session)throws Exception {
		List<BoardVO> list = dao.list(cri);
		System.out.println("BoardServiceImpl-list:"+list);
		Object userVO = session.getAttribute("login");
		/*cri.setKeyWord("%"+cri.getKeyWord()+"%");*/
		CustomerVO customerVO = null;
		if(userVO instanceof CustomerVO){
			customerVO = (CustomerVO)userVO;
		}
		
		for(BoardVO vo:list){
			System.out.println("BoardServiceImpl-c_id:"+vo.getC_Id());
			System.out.println("BoardServiceImpl-q_secret:"+vo.getQ_Secret());
			String writer = vo.getC_Id();
			String q_Secret = vo.getQ_Secret();
			if(q_Secret== null){
				q_Secret = "n";
			}
			if(q_Secret.equals("y")){
				if(userVO==null){
					vo.setQ_Title("비밀 글입니다.");
				}else if(userVO != null && !(customerVO.getC_id().equals(writer))){
					vo.setQ_Title("비밀 글입니다.");
				}
			}
		}
		return list;
	}

	@Override
	public void insert(BoardVO boardVO, HttpSession session)throws Exception {
		boardVO.setS_Num(dao.getS_Num(boardVO));									//폼에서 쇼핑몰 이름을 받아 쇼핑몰의 s_Num값을 가져옴.
		
		Object userVO = session.getAttribute("login");
		CustomerVO customerVO = null;
		if(userVO instanceof CustomerVO){
			customerVO = (CustomerVO)userVO;
		}																			//세션에서 로그인 정보를 가져옴.
		System.out.println("BoardServiceImpl-세션정보확인:"+customerVO);
		
		boardVO.setC_Num(customerVO.getC_num());
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
		BoardVO boardVO = dao.detail(q_Num);																				//클릭한 게시판 하나를 받아옴.
		Object userVO = session.getAttribute("login");																		//세션에서 로그인 정보를 받아옴.
		CustomerVO customerVO=null;
		if(userVO instanceof CustomerVO){
			customerVO=(CustomerVO)userVO;
		}																													//로그인 정보가 고객정보이면 고객 객체로 변환
	/*	if(userVO !=null){
			if(boardVO.getQ_Secret().equals("y")&&boardVO.getC_Id().equals(customerVO.getC_id())){							//boardVO의 아이디 값과, 세션의 id값이 같으면 boardVO객체를 반환
				return boardVO;
			}else {
				return null;																								//아니면 널을 반환.
			}
			
		}else{return null;}*/
		if(boardVO.getQ_Secret().equals("y")){																				//비밀글이면?
			if(userVO !=null){																								//비밀글이면서 로그인 중이면?
				if(boardVO.getC_Id().equals(customerVO.getC_id())){															//비밀글이면서 로그인하고 있는 사용자가 글의 작성자 이면?
					return boardVO;																							//글을 보여주기 위하여 boardVO객체를 반환.
				}else{																										//로그인 중이긴 한데 글 작성자가 아님...
					return null;
				}
					
			}else{																											//로그인 중이 아님...
				return null;
			}
		}else{																												//비밀글이 아니면 누구나 볼 수 있으므로...
			return boardVO;																									//boardVO객체를 반환하여 상세글을 볼 수 있도록...
		}
	}

	@Override
	public List<AdShoppingMallHelp> adShoppingMallList() throws Exception{
		
		return dao.adShoppingMallList();
	}

	@Override
	public int totalCount() throws Exception {
		
		return dao.totalCount();
	}
	
	
	
	

}
