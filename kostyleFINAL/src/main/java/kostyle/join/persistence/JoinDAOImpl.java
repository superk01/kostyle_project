package kostyle.join.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kostyle.join.domain.JoinVO;

@Repository
public class JoinDAOImpl implements JoinDAO {
	
	@Inject
	private SqlSession session;
	
	private static String namespace = "kostyle.join.mappers.joinMapper";

	@Override
	public void insertJoin(JoinVO join) throws Exception {
		session.insert(namespace+".insertJoin", join);
	}

}
