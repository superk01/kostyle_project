package kostyle.coordinator.persistence;

import java.util.List;

import kostyle.coordinator.domain.CoordinatorVO;

public interface CoordinatorDAO {
	public void insert_coordi(CoordinatorVO coordinatorVO);
	
	public void insert_detail(CoordinatorVO coordinatorVO);
	
	public List<CoordinatorVO> coordiList();
	
	public void update(CoordinatorVO coordinatorVO);
	
	public void delete_coordi(String cd_num);
	
	public void delete_detail(String cdprd_num);
}
