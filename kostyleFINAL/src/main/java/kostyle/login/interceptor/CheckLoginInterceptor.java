package kostyle.login.interceptor;

import java.util.Date;

import javax.inject.Inject;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.util.WebUtils;

import kostyle.login.domain.AdShopVO;
import kostyle.login.domain.CustomerVO;
import kostyle.login.service.LoginService;

public class CheckLoginInterceptor extends HandlerInterceptorAdapter {
	@Inject
	LoginService service;
	
	private static final String LOGIN = "login";
	private static final Logger logger = LoggerFactory.getLogger(CheckLoginInterceptor.class);
	
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
		logger.info("CheckLoginIntercepter   preHandle진입");
		HttpSession session = request.getSession();
		
		System.out.println("CheckLoginIntercepter session.login: "+session.getAttribute(LOGIN));
	
		
		//어디에서 들어왔는지에 따라 shop로그인으로 갈분기와, cus로그인으로 갈 분기 나눌if-else문 나중에 맨밖에 하나 추가해야한다. ->no. 아예 shop인터셉터 따로만듦.
		if(session.getAttribute(LOGIN) == null){
			
			logger.info("current user is lot logined");
			saveDest(request);
			Cookie loginCookie = WebUtils.getCookie(request, "loginCookie");
			
			//쿠키가 있으면 자동로그인~
			if(loginCookie != null){
				System.out.println("로그인쿠키.getName(): "+loginCookie.getName());
				System.out.println("로그인쿠키.getValue(): "+loginCookie.getValue());
				Object userVO = service.checkCusSessionKey(loginCookie.getValue());
				logger.info("USERVO: "+userVO);
				
				//자동로그인성공, 세션기한늘리고 고객과 쇼핑몰분기.
				if(userVO != null){
					int oneweek = 60 * 60 * 24 * 7;
					Date sessionLimit = new Date(System.currentTimeMillis()+(1000*oneweek)); //   1/1000초니까 *1000
					
					//고객 자동로그인
					service.keepCusLoginLimit(((CustomerVO)userVO).getC_id(), session.getId(),sessionLimit);
					session.setAttribute(LOGIN, (CustomerVO)userVO);
					return true;
				}
			}else{
		//쿠키가없으면
				System.out.println("세션도 쿠키도 없음. 로그인폼으로이동");
			response.sendRedirect("/cuslogin/login");
			return false;
			}//endCookie
		
	}else{
		System.out.println("CheckLoginInterceptor: 처음부터 로그인되어있음(session있음)");
			return true;//처음부터 로그인 되어있는상태. 당연히 그냥통과.
	}
		return true;
	}//preHandle

}//class


	/*		//로그아웃시 이전경로저장. 제대로된 경로가되도록 자바스크립트로 구현 후 수정해야함.
	String uri = request.getRequestURI();
	if(uri.equals("/cuslogin/logout") || uri.equals("/shoplogin/logout")){
		saveDest(request);
	}*/



