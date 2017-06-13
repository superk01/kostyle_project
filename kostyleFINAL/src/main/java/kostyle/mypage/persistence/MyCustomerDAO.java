package kostyle.mypage.persistence;



import kostyle.mypage.domain.MyCustomerVO;

public interface MyCustomerDAO {
	public boolean loginCheck(MyCustomerVO vo);
	public MyCustomerVO viewMember(MyCustomerVO vo);
	public boolean passCheck(
			MyCustomerVO vo);
	public MyCustomerVO read(String c_id);
	public void deleteMember(String c_id);
	public void updateMember(MyCustomerVO vWo);
	
}
