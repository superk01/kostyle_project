package kostyle.help.service;

import java.util.List;

import kostyle.help.domain.ReplyVO;

public interface ReplyService {

	public List<ReplyVO> ReplyList(int q_Num);
	
	public void ReplyInsert(ReplyVO replyVO);
	
	public void ReplyUpdate(ReplyVO replyVO);
	
	public void ReplyDelete(int as_Num);
	
	public ReplyVO ReplyDetail(int as_Num);
}
