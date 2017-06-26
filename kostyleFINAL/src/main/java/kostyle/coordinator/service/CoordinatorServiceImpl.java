package kostyle.coordinator.service;

import java.lang.annotation.Inherited;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kostyle.coordinator.domain.CoordinatorVO;
import kostyle.coordinator.persistence.CoordinatorDAO;
@Service
public class CoordinatorServiceImpl implements CoordinatorService {
	
	@Inject
	private CoordinatorDAO dao;

	@Transactional
	@Override
	public void register(CoordinatorVO coordinatorVO) {
		System.out.println("서비스 진입.");
		dao.insert_coordi(coordinatorVO);
		System.out.println("insert_coordi 끝남.");
		dao.insert_detail(coordinatorVO);
	}

	@Override
	public List<CoordinatorVO> coordiList() {
		List<CoordinatorVO> list = dao.coordiList();
		System.out.println("DAO에서 list:"+list);
		return list;
	}

	@Override
	public void update(CoordinatorVO coordinatorVO) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(String cdprd_num) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public CoordinatorVO coordiDetail(String cd_num) {
		return dao.coordiDetail(cd_num);
	}

	
}
