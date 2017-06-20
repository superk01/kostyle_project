package kostyle.find.service;

import javax.inject.Inject;
import org.springframework.stereotype.Service;
import kostyle.find.domain.FindInfo;
import kostyle.find.domain.FindshopInfo;
import kostyle.find.persistence.FindDAO;

@Service
public class FindServiceImpl implements FindService {

	@Inject
	private FindDAO dao;

	@Override
	public String idFind(FindInfo find) throws Exception {
		System.out.println("아이디 찾기 Service : "+find);
		return dao.idFind(find);
	}

	@Override
	public int pwFind(FindInfo find) throws Exception {
		System.out.println("비밀번호 찾기 Service : "+find);
		return dao.pwFind(find);
	}

	@Override
	public void randomPassword(FindInfo find) throws Exception {
		dao.randomPassword(find);
	}

	@Override
	public String idshopFind(FindshopInfo findshop) throws Exception {
		System.out.println("쇼핑몰아이디 찾기 Service : "+ findshop);
		return dao.idshopFind(findshop);
	}

	@Override
	public int pwshopFind(FindshopInfo findshop) throws Exception {
		System.out.println("쇼핑몰비밀번호 찾기 Service : "+findshop);
		return dao.pwshopFind(findshop);
	}

	@Override
	public void randomshopPassword(FindshopInfo findshop) throws Exception {
		dao.randomshopPassword(findshop);
	}

	
	

}
