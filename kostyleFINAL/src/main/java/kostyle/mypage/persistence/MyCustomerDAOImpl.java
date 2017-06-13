package kostyle.mypage.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kostyle.mypage.domain.MyCustomerVO;

@Repository
public class MyCustomerDAOImpl implements MyCustomerDAO{

	@Inject
	private SqlSession session;
	
	private static String namespace="kostyle.mypage.mappers.mypageMapper";

	@Override
	public boolean loginCheck(MyCustomerVO vo) {
		String name
		=session.selectOne(namespace + ".login_check", vo);
				return (name == null) ? false : true;
	}

	@Override
	public MyCustomerVO viewMember(MyCustomerVO vo) {
		return 
				session.selectOne(namespace + ".viewMember", vo);
		
	}

	@Override
	public boolean passCheck(MyCustomerVO vo) {
				String name
				=session.selectOne(namespace + ".pass_check", vo);
		return (name == null) ? false : true;
	}

	@Override
	public MyCustomerVO read(String c_id) {
		return session.selectOne(namespace + ".view", c_id);
	}

	@Override
	public void deleteMember(String c_id) {
		session.delete(namespace + ".deleteMember", c_id);
		
	}

	@Override
	public void updateMember(MyCustomerVO vo) {
		session.update(namespace + ".updateMember", vo);
		
	}
	
	
}
