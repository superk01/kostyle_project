package kostyle.join.persistence;

import kostyle.join.domain.JoinJoin;

public interface JoinDAO {

	public void insertJoin(JoinJoin join)throws Exception;
	
	public String autoNum()throws Exception;
	
	public int overlapId(String c_id)throws Exception;

}
