package kostyle.join.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kostyle.join.domain.JoinJoin;

@Repository
public class JoinDAOImpl implements JoinDAO {
	
	@Inject
	private SqlSession session;
	
	private static String namespace = "kostyle.join.mappers.joinMapper";

	@Override
	public void insertJoin(JoinJoin join) throws Exception {
		session.insert(namespace+".insertJoin", join);
	}

	@Override
	public String autoNum() throws Exception {

		if(session.selectOne(namespace+".autoNum") == null){
			return "0";
		}else{
			return session.selectOne(namespace+".autoNum");
		}
	}

	@Override
	public int overlapId(String c_id) throws Exception {
		return session.selectOne(namespace+".overlapId", c_id);
	}

}
