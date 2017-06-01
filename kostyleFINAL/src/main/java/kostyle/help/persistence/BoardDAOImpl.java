package kostyle.help.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kostyle.help.domain.AdShoppingMall;
import kostyle.help.domain.BoardVO;
import kostyle.help.domain.Criteria;

@Repository
public class BoardDAOImpl implements BoardDAO {

	@Inject
	private SqlSession session;
	
	private static String namespace="kostyle.mapper.BoardMapper";
	@Override
	public List<BoardVO> list(Criteria cri) {
		
		return session.selectList(namespace+".list",cri, new RowBounds(cri.getPageStart(), cri.getPerPageNum()));
	}

	@Override
	public void insert(BoardVO BoardVO) {
		session.insert(namespace+".insert", BoardVO);

	}

	@Override
	public void delete(int q_Num) {
		session.delete(namespace+".delete", q_Num);

	}

	@Override
	public void update(BoardVO boardVO) {
		session.insert(namespace+".update", boardVO);

	}

	@Override
	public BoardVO detail(int q_Num) {
	/*	Map<String, Integer> map = new HashMap<>();
		map.put("q_num1", q_Num);
		map.put("q_num2", q_Num);*/
		
		return session.selectOne(namespace+".detail", q_Num);

	}

	@Override
	public List<AdShoppingMall> adShoppingMallList() {
		
		return session.selectList(namespace+".adShoppingMallList");
	}

	@Override
	public String getS_Num(BoardVO boardVO) {
		
		return session.selectOne(namespace+".getS_Num", boardVO.getS_Name());
	}

	@Override
	public int totalCount() throws Exception {
		
		return session.selectOne(namespace+".totalCount");
	}
	
	
	

}
