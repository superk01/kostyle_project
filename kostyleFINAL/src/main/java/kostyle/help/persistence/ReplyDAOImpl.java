package kostyle.help.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kostyle.help.domain.ReplyVO;

@Repository
public  class ReplyDAOImpl implements ReplyDAO {
	
	@Inject
	private SqlSession session;
	
	private static String namespace="kostyle.help.mappers.helpMapper";

	@Override
	public List<ReplyVO> ReplyList(int q_Num) {
		
		return session.selectList(namespace+".R_list", q_Num);
	}

	@Override
	public void ReplyInsert(ReplyVO replyVO) {
		
		System.out.println("ReplyDAOImpl-ReplyInsert:"+replyVO);
		session.insert(namespace+".R_insert", replyVO);
	}

	@Override
	public void ReplyUpdate(ReplyVO replyVO) {
		
		session.update(namespace+".R_update", replyVO);
	}

	@Override
	public void ReplyDelete(int as_Num) {
		
		session.delete(namespace+".R_delete", as_Num);
	}

	@Override
	public ReplyVO ReplyDetail(int as_Num) {
		
		return session.selectOne(namespace+".R_detail", as_Num);
	}

	@Override
	public int ReplyCount(int q_Num) {
		
		return session.selectOne(namespace+".R_count", q_Num);
	}

}
