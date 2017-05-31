package kostyle.help.service;

import java.util.List;

import kostyle.help.domain.BoardVO;

public interface BoardService {
	
	public List<BoardVO> list();						//리스트
	
	public void insert(BoardVO baBoardVO);				//글쓰기
	
	public void delete(int bno);						//삭제
	
	public void update(BoardVO boardVO);				//수정
	
	public void detail(int bno);						//글보기
	
}
