package kostyle.login.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class CheckILoginnterceptor extends HandlerInterceptorAdapter {
	
	
	private void saveDest(HttpServletRequest request){
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
		
		HttpSession session = request.getSession();
		
		if(session.getAttribute("login") == null){
			
			saveDest(request);
			response.sendRedirect("/user/login");
			
			return false;
		}
		
		return true;
	}


	

}











