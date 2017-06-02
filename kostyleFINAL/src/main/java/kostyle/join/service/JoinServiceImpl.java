package kostyle.join.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kostyle.join.domain.JoinVO;
import kostyle.join.persistence.JoinDAO;

@Service
public class JoinServiceImpl implements JoinService {

	@Inject
	private JoinDAO dao;

	@Override
	public void insertJoin_S(JoinVO join) throws Exception {
		
		
		dao.insertJoin(join);
	}
	
	
	
}
