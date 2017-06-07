package kostyle.help.service;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import kostyle.help.domain.ReplyVO;
import kostyle.help.persistence.ReplyDAO;
import kostyle.login.domain.CustomerVO;

@Service
public class ReplyServiceImpl implements ReplyService {
	
	@Inject
	private ReplyDAO replydao;

	@Override
	public List<ReplyVO> ReplyList(int q_Num) {
		
		return replydao.ReplyList(q_Num);
	}

	@Override
	public void ReplyInsert(ReplyVO replyVO) {
		
		replydao.ReplyInsert(replyVO);
	}

	@Override
	public void ReplyUpdate(ReplyVO replyVO) {
		
		replydao.ReplyUpdate(replyVO);
	}

	@Override
	public void ReplyDelete(int as_Num) {
		
		replydao.ReplyDelete(as_Num);
	}

	@Override
	public ReplyVO ReplyDetail(int as_Num, int q_Num, HttpSession session) {
		Object userVO = session.getAttribute("login");
		CustomerVO customerVO = null;
		if(userVO instanceof CustomerVO){
			customerVO = (CustomerVO)userVO;
		}
		if(customerVO.getC_num()==(q_Num+"")){
			return replydao.ReplyDetail(as_Num);
		}else{
			return null;
		}
		
		
	}

}
