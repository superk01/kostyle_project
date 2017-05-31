package kostyle.login.interceptor;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class SampleInterceptor extends HandlerInterceptorAdapter {

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		System.out.println("post handle.....");
		
		//+추가 
		Object result = modelAndView.getModel().get("result"); //ModelAndView.getModel()하면 모델호출.
		
		if(result != null){
			request.getSession().setAttribute("result", result);
			response.sendRedirect("/doA");
		}
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		/*System.out.println("pre handle.....");
		
		return true;*/
		
		System.out.println("pre handle.....");
		
		HandlerMethod method = (HandlerMethod) handler;
		Method methodobj = method.getMethod();
		
		System.out.println("Bean: "+ method.getBean());
		System.out.println("Method: "+ methodobj);
		
		return true;
		
		
		
		
	}
	
}
