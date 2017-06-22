package kostyle.login.interceptor;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.Cookie;
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

public class ShopLoginInterceptor extends HandlerInterceptorAdapter {
	private static final String SHOPLOGIN = "shoplogin";
	private static final String LOGIN = "login";
	private static final Logger logger = LoggerFactory.getLogger(ShopLoginInterceptor.class);

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		super.postHandle(request, response, handler, modelAndView);
		
		System.out.println();
		System.out.println("shop로그인인터셉트-PostHandle");
		
		HttpSession session = request.getSession();
		ModelMap modelMap = modelAndView.getModelMap();
		Object userVO = modelMap.get("userVO");
		logger.info("메소드타입: "+request.getMethod());
		logger.info("userVO: "+userVO);
		String dest=(String)session.getAttribute("dest"); //CheckLoginInterceptor를 거쳐왔다면 dest가있음.
		
		if(userVO != null){ //로그인성공
			System.out.println("로그인성공: new SHOPlogin success");
			logger.info("new SHOPlogin success");
			
			System.out.println("LoginInterceptor의 destURL: "+dest);
			
			 if(userVO instanceof AdShopVO){ //로그인성공
					System.out.println("userVO의타입: AdShopVO진입");
					session.setAttribute(SHOPLOGIN, (AdShopVO)userVO);
/*					System.out.println("세션값확인: "+session.getAttribute(SHOPLOGIN));
					if(session.getAttribute(LOGIN) != null){
						session.removeAttribute(LOGIN);
					}*/
					if(dest == null){
						dest =  "/";
					}
					//System.out.println("판별 후의 URL: "+(dest != null ? (String)dest:"/"));
					
					if(request.getParameter("useCookie") != null){ 
						//자동로그인시에 쇼핑몰로그인인지 고객로그인인지 구분필요. LoginDTO에 cus_id 와 adshop_id 중 뭐가는지여부.
						
						logger.info("자동로그인 체크......");
						
						Cookie shopCookie = new Cookie("shopCookie", session.getId());
						shopCookie.setPath("/");
						shopCookie.setMaxAge(60 * 60 * 24 * 7); //로그인은 1주일간유지.
						response.addCookie(shopCookie);
						
					}
				}
			 response.sendRedirect((String)dest);
			return;
		}else{ //로그인실패
			request.getSession().setAttribute("msg", "회원 아이디 또는 비밀번호가 일치하지 않습니다.(5회 이상 로그인 오류시 본인확인 후 로그인 가능합니다.)");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/shoplogin/login");
			 dispatcher.forward(request, response);
		}
		
		System.out.println("최종 dest값: "+dest);
		 //RequestDispatcher dispatcher = request.getRequestDispatcher((String) dest);
        // dispatcher.forward(request, response);
		//response.sendRedirect((String)dest);
		
		//System.out.println("실행되면안되는 dispatcher, response다음구문.");
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		
		HttpSession session = request.getSession();
		System.out.println("shop로그인인터셉트-preHandle");
		//세션의 "login"이 null이아니면 세션삭제.
		if(session.getAttribute(SHOPLOGIN) != null){
			logger.info("clear login data before");
			System.out.println("clear login data before");
			session.removeAttribute(SHOPLOGIN);
		}
		System.out.println("end prehandle");
		return true;
		
	}
	
}

