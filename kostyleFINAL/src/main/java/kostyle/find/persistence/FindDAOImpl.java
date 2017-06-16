package kostyle.find.persistence;

import javax.inject.Inject;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import kostyle.find.domain.FindInfo;
import kostyle.find.domain.FindshopInfo;

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
	public int pwFind(FindInfo find) throws Exception {
		System.out.println("비밀번호 찾기 DAO : "+find);
		return session.selectOne(namespace+".pwFind", find);
	}

	@Override
	public void randomPassword(FindInfo find) throws Exception {
		session.update(namespace+".randomPassword", find);
	}

	@Override
	public String idshopFind(FindshopInfo findshop) throws Exception {
		return session.selectOne(namespace+".idshopFind", findshop);
	}

	@Override
	public int pwshopFind(FindshopInfo findshop) throws Exception {
		System.out.println("쇼핑몰비밀번호 찾기 DAO : "+findshop);
		return session.selectOne(namespace+".pwshopFind", findshop);
	}

	@Override
	public void randomshopPassword(FindshopInfo findshop) throws Exception {
		session.update(namespace+".randomshopPassword", findshop);
	}

	
}
