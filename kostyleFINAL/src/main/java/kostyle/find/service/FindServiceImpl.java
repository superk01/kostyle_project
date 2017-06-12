package kostyle.find.service;

import javax.inject.Inject;
import org.springframework.stereotype.Service;
import kostyle.find.domain.FindInfo;
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
	public String pwFind(FindInfo find) throws Exception {
		System.out.println("비밀번호 찾기 Service : "+find);
		return dao.pwFind(find);
	}

	
	

}
