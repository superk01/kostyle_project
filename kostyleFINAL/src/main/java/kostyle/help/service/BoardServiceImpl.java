package kostyle.help.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kostyle.help.domain.BoardVO;
import kostyle.help.persistence.BoardDAO;

@Service
public class BoardServiceImpl implements BoardService {

	@Inject
	private BoardDAO dao;
	
	@Override
	public List<BoardVO> list() {

		return dao.list();
	}

	@Override
	public void insert(BoardVO baBoardVO) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(int bno) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(BoardVO boardVO) {
		// TODO Auto-generated method stub

	}

	@Override
	public void detail(int bno) {
		// TODO Auto-generated method stub

	}

}
