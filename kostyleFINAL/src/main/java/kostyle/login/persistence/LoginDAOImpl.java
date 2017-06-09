package kostyle.login.persistence;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kostyle.login.domain.AdShopVO;
import kostyle.login.domain.CustomerVO;
import kostyle.login.domain.LoginDTO;

@Repository
public class LoginDAOImpl implements LoginDAO{
	
	@Inject
	private SqlSession session;
	
	private static String namespace="kostyle.login.mappers.loginMapper";

	
	@Override
	public CustomerVO cusLogin(LoginDTO dto) throws Exception {
		System.out.println("daoCusVO: "+session.selectOne(namespace+".cuslogin",dto));
		return session.selectOne(namespace+ ".cuslogin", dto) ;
	}

	@Override
	public AdShopVO shopLogin(LoginDTO dto) throws Exception {
		System.out.println("daoShopVO: "+session.selectOne(namespace+".shoplogin",dto));
		return session.selectOne(namespace+ ".shoplogin", dto) ;
	}



	//쿠키로 자동로그인
	@Override
	public CustomerVO checkCusSessionKey(String cookieVal) {
		CustomerVO vo = session.selectOne(namespace+".checkCusSessionKey", cookieVal);
		System.out.println("");
		System.out.println("checkShopSessionKey   DAO  반환받은 vo: "+vo);
		return vo;
	}
	@Override
	public void keepCusLoginLimit(String cus_id, String sessionId, Date next) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("cus_id", cus_id);
		paramMap.put("sessionId",  sessionId);
		paramMap.put("next", next);
		
		session.update(namespace+".keepCusLogin",paramMap);
	}


	@Override
	public AdShopVO  checkShopSessionKey(String cookieVal) {
		AdShopVO vo =  session.selectOne(namespace+".checkCusSessionKey", cookieVal);
		System.out.println("");
		System.out.println("checkShopSessionKey   DAO  반환받은 vo: "+vo);
		return vo;
	}
	@Override
	public void keepShopLoginLimit(String adshop_id, String sessionId,Date next) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("adshop_id", adshop_id);
		paramMap.put("sessionId",  sessionId);
		paramMap.put("next",  next);
		
		session.update(namespace+".keepShopLogin",paramMap);
		
	}
	
	//TO_CHAR(sysdate, 'YYYY-MM-DD HH24:MI:SS')
/*  	
 * 정상실행되는쿼리.
 * select s_num, ad_id, p_powernum, (select distinct s_sname from adshoppingmall ad INNER JOIN shoppingmall s ON ad.s_num = s.s_num 
  	  		where ad_id=#{adshop_id} and ad_pass = #{user_pass})as s_sname 
  	  		from adshoppingmall
  	  		where ad_id=#{adshop_id} and ad_pass = #{user_pass}*/
/* SELECT st.sno, st.sname, c.cname, sc.result
    FROM student st INNER JOIN score sc
    ON st.sno = sc.sno INNER JOIN course c
    ON sc.cno = c.cno
    WHERE major ='화학'       
    AND c.cname = '유기화학'
   ORDER BY result


	select s_num, ad_id, p_powernum  from adshoppingmall
		where ad_id=#{adshop_id} and ad_pass = #{user_pass} */
	
}
