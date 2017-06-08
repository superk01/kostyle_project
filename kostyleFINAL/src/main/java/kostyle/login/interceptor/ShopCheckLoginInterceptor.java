package kostyle.login.interceptor;

import java.util.Date;

import javax.inject.Inject;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.util.WebUtils;

import kostyle.login.domain.AdShopVO;
import kostyle.login.domain.CustomerVO;
import kostyle.login.service.LoginService;

//정책을 바꾸기로... 인터셉터자체를 customer용과 shop용을 따로 만들자. mappingurl부터 아예 통째로 구분해서 원하는 곳으로 가도록.
public class ShopCheckLoginInterceptor extends HandlerInterceptorAdapter {
	@Inject
	LoginService service;
	
	private static final String SHOPLOGIN = "shoplogin";
	private static final Logger logger = LoggerFactory.getLogger(ShopCheckLoginInterceptor.class);
	

	private void saveDest(HttpServletRequest request){
		System.out.println("saveDest진입");
		String uri = request.getRequestURI();
		System.out.println("원래 이동해야 할 url: "+ uri);
		String query = request.getQueryString();
		System.out.println("원래 query: "+ query);
		
		if(query == null || query.equals(null)){
			query = "";
		}else{
			query = "?"+query;
		}
		
		if(request.getMethod().equals("GET")){
			request.getSession().setAttribute("dest", uri+query);
		}
		
	}
	
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		logger.info("ShopCheckLoginIntercepter   preHandle진입");
		HttpSession session = request.getSession();
		
		System.out.println("session.login: "+session.getAttribute(SHOPLOGIN));
	
		
		//어디에서 들어왔는지에 따라 shop로그인으로 갈분기와, cus로그인으로 갈 분기 나눌if-else문 나중에 맨밖에 하나 추가해야한다. ->제외. 아예 shop인터셉터 새로생성.
		//세션에 샵로그인상태아님. + 쿠키가있으면 자동로그인 / 쿠키없으면 login폼으로 이동.
		if(session.getAttribute(SHOPLOGIN) == null){
			
			logger.info("current user is lot logined");
			saveDest(request);
			Cookie shopCookie = WebUtils.getCookie(request, "shopCookie");
			
			
			//쿠키가 있으면 자동로그인~
			if(shopCookie != null){
				System.out.println("로그인쿠키.getName(): "+shopCookie.getName());
				System.out.println("로그인쿠키.getValue(): "+shopCookie.getValue());
				Object userVO = service.checkCusSessionKey(shopCookie.getValue());
				logger.info("USERVO: "+userVO);
				
				//자동로그인성공, 세션기한늘리고 고객과 쇼핑몰분기.
				if(userVO != null){
					int oneweek = 60 * 60 * 24 * 7;
					Date sessionLimit = new Date(System.currentTimeMillis()+(1000*oneweek)); //   1/1000초니까 *1000
					
					//쇼핑몰자동로그인
					service.keepShopLoginLimit(((AdShopVO)userVO).getAd_id(), session.getId(), sessionLimit);
					session.setAttribute(SHOPLOGIN, (AdShopVO)userVO);
					return true;
				}
			}else{
			
		//쿠키가없으면
			response.sendRedirect("/shoplogin/login");
			return false;
		}//endcookie
	}else{
		System.out.println("ShopCheckLoginInterceptor: 처음부터 로그인되어있음(session있음)");
		return true;//애초에 처음부터 로그인 되어있는 상태.
	}
		return true;


	}//preHandle
	
	
}//class
