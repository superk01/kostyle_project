package kostyle.find.persistence;

import kostyle.find.domain.FindInfo;

public interface FindDAO {

	public String idFind(FindInfo find)throws Exception;
	
	public int pwFind(FindInfo find)throws Exception;
	
	public void randomPassword(FindInfo find) throws Exception;
	
}
