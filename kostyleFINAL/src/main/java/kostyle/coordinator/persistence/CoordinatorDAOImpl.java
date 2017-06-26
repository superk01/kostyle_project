package kostyle.coordinator.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.sun.mail.imap.protocol.Namespaces.Namespace;

import kostyle.coordinator.domain.CoordiDetailVO;
import kostyle.coordinator.domain.CoordinatorVO;

@Repository
public class CoordinatorDAOImpl implements CoordinatorDAO {
	
	@Inject
	private SqlSession session;
	
	private String Namespace = "kostyle.admin.mappers.coordinatorMapper";

	@Override
	public void insert_coordi(CoordinatorVO coordinatorVO) {
		session.insert(Namespace+".insert_coordi", coordinatorVO);
	}

	@Override
	public void insert_detail(List<CoordiDetailVO> list) {
		System.out.println("insert_detail:"+list);
		for(int i=0; i<list.size(); i++){
		session.insert(Namespace+".insert_detail", list.get(i));
		}
	}

	@Override
	public List<CoordinatorVO> coordiList() {
		return session.selectList(Namespace+".coordiList");
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

	@Override
	public CoordinatorVO coordiDetail(String cd_num) {
		CoordinatorVO coordinatorVO = session.selectOne(Namespace+".coordiDetail", cd_num);
		System.out.println("CoordinatorDAOImpl-coordiDetail:"+coordinatorVO);
		return coordinatorVO;
	}

	@Override
	public List<CoordiDetailVO> getCoordiDetail(String cd_num) {
		List<CoordiDetailVO> list = session.selectList(Namespace+".detailList", cd_num);
		System.out.println("CoordinatorDAOImpl-List:"+list);
		return list;
	}
    
	
}
