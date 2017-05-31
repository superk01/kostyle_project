package kostyle.login.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class cg_LoginInterceptor extends HandlerInterceptorAdapter {
	
	private static final String LOGIN = "login";
	private static final Logger logger = LoggerFactory.getLogger(cg_LoginInterceptor.class);
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		HttpSession session = request.getSession();
		ModelMap modelMap = modelAndView.getModelMap();
		Object userVO = modelMap.get("userVO");
		logger.info("userVO: "+userVO);
		
		if(userVO != null){ //로그인성공
			System.out.println("로그인성공: new login success");
			logger.info("new login success");
			session.setAttribute(LOGIN, userVO);
			//response.sendRedirect("/");
			
			//추가
			Object dest=session.getAttribute("dest");
			System.out.println("LoginInterceptor의 destURL: "+dest);
			System.out.println("판별 후의 URL: "+(dest != null ? (String)dest:"/"));
			response.sendRedirect(dest != null ? (String)dest:"/");
		}
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		HttpSession session = request.getSession();
		
		if(session.getAttribute(LOGIN) != null){
			logger.info("clear login data before");
			session.removeAttribute(LOGIN);
		}
		
		return true;
	}

	
}//class
