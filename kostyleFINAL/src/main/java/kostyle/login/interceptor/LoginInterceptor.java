package kostyle.login.interceptor;

import static org.hamcrest.CoreMatchers.instanceOf;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import kostyle.login.domain.AdShopVO;
import kostyle.login.domain.CustomerVO;

public class LoginInterceptor extends HandlerInterceptorAdapter {

	private static final String LOGIN = "login";
	private static final Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		System.out.println("로그인인터셉트-preHandle");
		//세션의 "login"이 null이아니면 세션삭제.
		if(session.getAttribute(LOGIN) != null){
			logger.info("clear login data before");
			session.removeAttribute(LOGIN);
		}
		
		return true;
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		System.out.println("로그인인터셉트-PostHandle");
		HttpSession session = request.getSession();
		ModelMap modelMap = modelAndView.getModelMap();
		Object userVO = modelMap.get("userVO");
		logger.info("메소드타입: "+request.getMethod());
		logger.info("userVO: "+userVO);
		Object dest=session.getAttribute("dest");
		
		if(userVO != null){ //로그인성공
			System.out.println("로그인성공: new login success");
			logger.info("new login success");
			
			System.out.println("LoginInterceptor의 destURL: "+dest);

				if(dest ==null){
					System.out.println("dest값은 null이다.");
					dest="/";
				}
				
				//customer , shop 회원 구분후 경로지정.
				if(userVO instanceof CustomerVO ){
					System.out.println("userVO의타입: CustomerVO진입");
					session.setAttribute(LOGIN, (CustomerVO)userVO);
					System.out.println("세션값확인: "+session.getAttribute("login"));
					//System.out.println("판별 후의 URL: "+(dest != null ? (String)dest:"/"));
	
				}
				else if(userVO instanceof AdShopVO){ //로그인성공
					System.out.println("userVO의타입: AdShopVO진입");
					session.setAttribute(LOGIN, (AdShopVO)userVO);
					System.out.println("세션값확인: "+session.getAttribute("login"));
	
					//System.out.println("판별 후의 URL: "+(dest != null ? (String)dest:"/home/"));
				}
				
		}else{ //로그인실패
				if(dest ==null){
					System.out.println("dest값은 null이다.");
					dest="login";
				}
		}
		System.out.println("최종 dest값: "+dest);
		 RequestDispatcher dispatcher = request.getRequestDispatcher((String) dest);
         dispatcher.forward(request, response);
		response.sendRedirect((String)dest);
	}


	
	
	
}//end class
