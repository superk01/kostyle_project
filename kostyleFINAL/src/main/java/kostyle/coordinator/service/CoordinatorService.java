package kostyle.coordinator.service;

import java.util.List;

import kostyle.coordinator.domain.CoordinatorVO;

public interface CoordinatorService {

	public void register(CoordinatorVO coordinatorVO);
	
	public List<CoordinatorVO> coordiList();
	
	public CoordinatorVO coordiDetail(String cd_num); 
	
	public void update(CoordinatorVO coordinatorVO);
	
	public void delete(String cdprd_num);
}
