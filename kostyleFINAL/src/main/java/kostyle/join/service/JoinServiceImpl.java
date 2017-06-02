package kostyle.join.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kostyle.join.domain.JoinJoin;
import kostyle.join.persistence.JoinDAO;

@Service
public class JoinServiceImpl implements JoinService {

	@Inject
	private JoinDAO dao;

	@Override
	public void insertJoin_S(JoinJoin join) throws Exception {
		
		String num1 = dao.autoNum();//String 0
		System.out.println("num1 : " + num1);
		
		int num2 = Integer.parseInt(num1);//int 0
		System.out.println("num2 : " + num2);
		
		int num3 = num2 + 1;//int 1
		System.out.println("num3 : " + num3);
		
		String num4 = num3 + "";//String 1
		System.out.println("num4 : " + num4);
		
		join.setC_num(num4);
		
		System.out.println("고객 : " + join.toString());
		
		dao.insertJoin(join);
	}

	@Override
	public int overlapId_S(String c_id) throws Exception {
		return dao.overlapId(c_id);
	}

	
	
	
}
