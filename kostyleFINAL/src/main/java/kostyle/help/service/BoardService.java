package kostyle.help.service;

import java.util.List;

import kostyle.help.domain.BoardVO;

public interface BoardService {
	
	public List<BoardVO> list();						//����Ʈ
	
	public void insert(BoardVO baBoardVO);				//�۾���
	
	public void delete(int bno);						//����
	
	public void update(BoardVO boardVO);				//����
	
	public void detail(int bno);						//�ۺ���
	
}
