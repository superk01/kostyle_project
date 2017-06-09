package kostyle.help.persistence;

import java.util.List;

import kostyle.help.domain.AdShoppingMallHelp;
import kostyle.help.domain.BoardVO;
import kostyle.help.domain.Criteria;
import kostyle.help.domain.SearchCriteria;

public interface BoardDAO {
	
	public List<BoardVO> list(SearchCriteria cri)throws Exception;							//게시판 리스트(쇼핑몰 이름 나오는 거 까지...)
	
	public void insert(BoardVO baBoardVO)throws Exception;									//글 추가

	public void delete(int q_Num)throws Exception;					
	
	public void update(BoardVO boardVO)throws Exception;				
	
	public BoardVO detail(int q_Num)throws Exception;										//상세 글 보기
	
	public List<AdShoppingMallHelp> adShoppingMallList()throws Exception; 						//글 쓰기 할때 쇼핑몰 리스트 나오게 하는 거.
	
	public String getS_Num(BoardVO boardVO)throws Exception;								//문의 글을 db에 넣을때 데이터 베이스 컬럼값에 쇼핑몰의 이름만 있는 관계로, 쇼핑몰의 이름을 가지고 쇼핑몰의 번호를 구하는 메소드
																							//서비스에서 insert에 쓰임.
	public int totalCount(SearchCriteria cri)throws Exception;												//페이징 처리를 위해 PageMaker객체에 totalCount를 구하기 위하여 사용함.
																							//서비스의 list메소드에서 호출함.
}
