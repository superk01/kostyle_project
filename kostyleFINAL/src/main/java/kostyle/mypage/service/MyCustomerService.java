package kostyle.mypage.service;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;


import kostyle.mypage.domain.MyCustomerVO;


public interface MyCustomerService {
	public boolean loginCheck(
			MyCustomerVO vo, HttpSession session);
	public MyCustomerVO viewMember(MyCustomerVO vo);
	public boolean passCheck(
			MyCustomerVO vo);
	public MyCustomerVO read(String c_id);
	
}
