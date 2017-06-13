package kostyle.stats.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class StatsDAOImpl implements StatsDAO{

	@Inject
	private SqlSession session;
	
	private static String namespace = "kostyle.stats.mappers.statsMapper";
}
