package kostyle.find.service;


import kostyle.find.domain.FindInfo;
import kostyle.find.domain.FindshopInfo;

public interface FindService {

	public String idFind(FindInfo find)throws Exception;

	public int pwFind(FindInfo find)throws Exception;
	
	public void randomPassword(FindInfo find)throws Exception;
	
	public String idshopFind(FindshopInfo findshop)throws Exception;
	
	public int pwshopFind(FindshopInfo findshop)throws Exception;
	
	public void randomshopPassword(FindshopInfo findshop)throws Exception;
	
	
	
}
