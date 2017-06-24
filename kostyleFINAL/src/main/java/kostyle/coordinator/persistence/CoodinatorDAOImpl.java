package kostyle.coordinator.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.sun.mail.imap.protocol.Namespaces.Namespace;

import kostyle.coordinator.domain.CoordinatorVO;

@Repository
public class CoodinatorDAOImpl implements CoordinatorDAO {
	
	@Inject
	private SqlSession session;
	
	private String Namespace = "kostyle.admin.mappers.coordinatorMapper";

	@Override
	public void insert_coordi(CoordinatorVO coordinatorVO) {
		session.insert(Namespace+".insert_coordi", coordinatorVO);
	}

	@Override
	public void insert_detail(CoordinatorVO coordinatorVO) {
		session.insert(Namespace+".insert_detail", coordinatorVO);
	}

	@Override
	public List<CoordinatorVO> coordiList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(CoordinatorVO coordinatorVO) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete_coordi(String cd_num) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete_detail(String cdprd_num) {
		// TODO Auto-generated method stub
		
	}
    
	
}
