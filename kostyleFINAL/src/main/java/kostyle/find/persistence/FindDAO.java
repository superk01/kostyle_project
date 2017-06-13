package kostyle.find.persistence;

import kostyle.find.domain.FindInfo;

public interface FindDAO {

	public String idFind(FindInfo find)throws Exception;
	
	public String pwFind(FindInfo find)throws Exception;
	
	
	
}
