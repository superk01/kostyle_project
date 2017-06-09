package kostyle.mypage.service;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import kostyle.mypage.domain.MyCustomerVO;
import kostyle.mypage.persistence.MyCustomerDAO;

@Service
public class MyCustomerServiceImpl implements MyCustomerService{

	
	@Inject
	private MyCustomerDAO myCustomerDao;
	
	@Override
	public boolean loginCheck(
			MyCustomerVO vo, HttpSession session) {
		boolean result=myCustomerDao.loginCheck(vo);
		if(result) {	//true  일 경우 세션 등록
			MyCustomerVO vo2 = viewMember(vo);
			//세션 변수 등록
			session.setAttribute("c_id", vo2.getC_id());
			session.setAttribute("c_name", vo2.getC_name());
			session.setAttribute("c_num", vo2.getC_num());
			session.setAttribute("c_birth", vo2.getC_birth());
			session.setAttribute("c_phonenumber", vo2.getC_phonenumber());
			session.setAttribute("c_gender", vo2.getC_gender());
			session.setAttribute("c_email", vo2.getC_email());
			session.setAttribute("p_powernum", vo2.getP_powernum());
			session.setAttribute("c_zipcode", vo2.getC_zipcode());
			session.setAttribute("c_adress", vo2.getC_adress());
			session.setAttribute("c_sms", vo2.getC_sms());		
		}
		return result;
	}

	@Override
	public MyCustomerVO viewMember(MyCustomerVO vo) {
		return myCustomerDao.viewMember(vo);
	}

	@Override
	public boolean passCheck(MyCustomerVO vo) {
		boolean result = myCustomerDao.passCheck(vo);
		return result;
	}

	@Override
	public MyCustomerVO read(String c_id) {
		return myCustomerDao.read(c_id);
	}
	
	

}
