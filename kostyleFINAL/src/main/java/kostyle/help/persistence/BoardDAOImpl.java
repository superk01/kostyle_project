package kostyle.help.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kostyle.help.domain.BoardVO;

@Repository
public class BoardDAOImpl implements BoardDAO {

	@Inject
	private SqlSession session;
	
	private static String namespace="kostyle.mapper.BoardMapper";
	@Override
	public List<BoardVO> list() {
		
		return session.selectList(namespace+".list");
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
