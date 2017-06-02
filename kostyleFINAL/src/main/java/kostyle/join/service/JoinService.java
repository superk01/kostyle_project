package kostyle.join.service;

import kostyle.join.domain.JoinJoin;

public interface JoinService {

	public void insertJoin_S(JoinJoin join)throws Exception;
	
	public int overlapId_S(String c_id)throws Exception;
}
