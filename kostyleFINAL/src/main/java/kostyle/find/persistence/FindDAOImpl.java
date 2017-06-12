package kostyle.find.persistence;

import javax.inject.Inject;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import kostyle.find.domain.FindInfo;

@Repository
public class FindDAOImpl implements FindDAO {

	@Inject
	private SqlSession session;
	   
	private static String namespace = "kostyle.find.mappers.findMapper";

	@Override
	public String idFind(FindInfo find) throws Exception {
		System.out.println("아이디 찾기 DAO : "+find);
		return session.selectOne(namespace+".idFind", find);
	}

	@Override
	public String pwFind(FindInfo find) throws Exception {
		System.out.println("비밀번호 찾기 DAO : "+find);
		return session.selectOne(namespace+".pwFind", find);
	}

	
}
