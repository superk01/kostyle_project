package kostyle.find.service;


import kostyle.find.domain.FindInfo;

public interface FindService {

	public String idFind(FindInfo find)throws Exception;

	public int pwFind(FindInfo find)throws Exception;
	
	public void randomPassword(FindInfo find)throws Exception;
	
}
