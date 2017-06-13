package kostyle.find.service;


import kostyle.find.domain.FindInfo;

public interface FindService {

	public String idFind(FindInfo find)throws Exception;

	public String pwFind(FindInfo find)throws Exception;
	
}
