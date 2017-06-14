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
import kostyle.help.persistence.ReplyDAO;
import kostyle.login.domain.CustomerVO;

@Service
public class BoardServiceImpl implements BoardService {

	@Inject
	private BoardDAO boardDAO;
	
	@Inject
	private ReplyDAO replyDAO;
	
	@Override
	public List<BoardVO> list(SearchCriteria cri, HttpSession session)throws Exception {
		/*System.out.println("서비스에서 cri객체 확인:"+cri);*/
		//검색을 안 하고 있는 경우 페이지를 바꿨을때 keyWord값과 searchType값이 공백으로 들어가 공백인 경우 null로 바꿔주는 코드
		if(cri.getKeyWord()==""){
			cri.setKeyWord(null);
		}
		if(cri.getSearchType()==""){
			cri.setSearchType(null);
		}
		/*System.out.println("서비스에서 cri객체 다시 확인:"+cri);*/
		/*System.out.println("BoardServiceImpl-list:"+list);*/
		Object userVO = session.getAttribute("login");
		/*cri.setKeyWord("%"+cri.getKeyWord()+"%");*/
		CustomerVO customerVO = null;
		if(userVO instanceof CustomerVO){
			customerVO = (CustomerVO)userVO;
		}
		if(userVO != null){
			cri.setC_Id(customerVO.getC_id());
		}
		List<BoardVO> list = boardDAO.list(cri);
		for(int i=0; i<list.size(); i++){
			/*System.out.println("BoardServiceImpl-c_id:"+vo.getC_Id());
			System.out.println("BoardServiceImpl-q_secret:"+vo.getQ_Secret());*/
			String writer = list.get(i).getC_Id();
			String q_Secret = list.get(i).getQ_Secret();
			
			if(cri.getSearchType() ==null){													//검색어가 없는 경우..
				if(q_Secret.equals("y")){													//비밀글인 경우에...
					if(userVO==null){														//로그인 상태가 아니면?
						list.get(i).setQ_Title("비밀 글입니다.");								//그 글의 제목을 "비밀 글입니다."로 표시
					}else if(userVO != null && !(customerVO.getC_id().equals(writer))){		//로그인을 했는데 글 작성자와 로그인한 사용자가 다른 경우->즉 글쓴이가 로그인 한 경우가 아님.
						list.get(i).setQ_Title("비밀 글입니다.");								//역시, 글 제목을 "비밀 글입니다."로 표시									
					}
				}
			}/*else{
				if(q_Secret.equals("y")){													//검색을 통하여 list를 뽑은 경우.
					if(userVO==null){													    //로그인 상태를 확인.
						list.remove(i);														//로그인 한 상태가 아니면 해당 boardVO객체를 list에서 삭제
					}else if(userVO != null && !(customerVO.getC_id().equals(writer))){		//로그인을 했는데 글 작성자와 로그인한 사용자가 다른 경우->즉 글쓴이가 로그인 한 경우가 아님.
						list.remove(i);														//로그인 한 상태가 아니면 해당 boardVO객체를 list에서 삭제									
					}
				}
			}*/
		}
		System.out.println("서비스에서 list확인:"+list);
		return list;
	}

	@Override
	public void insert(BoardVO boardVO, HttpSession session)throws Exception {
		boardVO.setS_Num(boardDAO.getS_Num(boardVO));									//폼에서 쇼핑몰 이름을 받아 쇼핑몰의 s_Num값을 가져옴.
		
		Object userVO = session.getAttribute("login");
		CustomerVO customerVO = null;
		if(userVO instanceof CustomerVO){
			customerVO = (CustomerVO)userVO;
		}																			//세션에서 로그인 정보를 가져옴.
		/*System.out.println("BoardServiceImpl-세션정보확인:"+customerVO);*/
		
		boardVO.setC_Num(customerVO.getC_num());
		/*System.out.println("BoardServiceImpl:"+boardVO);*/
		if(boardVO.getQ_Secret()==null){
			boardVO.setQ_Secret("n");
		}else{
			boardVO.setQ_Secret("y");
		}
		boardDAO.insert(boardVO);
		

	}

	@Override
	public void delete(int q_Num)throws Exception {
		boardDAO.delete(q_Num);

	}

	@Override
	public void update(BoardVO boardVO)throws Exception {
		boardDAO.update(boardVO);

	}

	@Override
	public BoardVO detail(int q_Num, HttpSession session)throws Exception {
		/*System.out.println("BoardServiceImpl:"+boardDAO.detail());*/
		BoardVO boardVO = boardDAO.detail(q_Num);																			//클릭한 게시판 하나를 받아옴
		int replyCount = replyDAO.ReplyCount(q_Num);
		boardVO.setAnswerNum(replyCount);
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
		
		return boardDAO.adShoppingMallList();
	}

	@Override
	public int totalCount(SearchCriteria cri) throws Exception {
		
		return boardDAO.totalCount(cri);
	}
	
	
	
	

}
