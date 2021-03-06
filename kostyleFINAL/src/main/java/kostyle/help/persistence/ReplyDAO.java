package kostyle.help.persistence;

import java.util.List;

import kostyle.help.domain.ReplyVO;

public interface ReplyDAO {

	public List<ReplyVO> ReplyList(int q_Num);
	
	public void ReplyInsert(ReplyVO replyVO);
	
	public void ReplyUpdate(ReplyVO replyVO);
	
	public void ReplyDelete(int as_Num);
	
	public void ReplyDeletaAll(int q_Num);
	
	public ReplyVO ReplyDetail(int as_Num);
	
	public int ReplyCount(int q_Num);
}
