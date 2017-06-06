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

public class LoginInterceptor extends HandlerInterceptorAdapter {

	private static final String LOGIN = "login";
	private static final Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);
	
	

	//로그인시 고객,쇼핑몰,관리자에따라 첫페이지가 달라야한다. + 다른페이지에서 인터셉터를 타고왔으면 이전경로가 있으므로 그페이지로 돌아가도록..
	public String setDest(HttpServletRequest request, String who){
		HttpSession session = request.getSession();
		Object dest=session.getAttribute("dest");//CheckLoginInterceptor를거쳐와다면 dest가 이미있을것임.
		
		//CheckLoginInterceptor없이 바로 로그인으로 왔을경우에는 dest가 없음.
		if(dest == null){	
			if(who.equals("C")){
				dest = "/home/";
			}else if(who.equals("A")){
				dest = "/home/";
			}else if(who.equals("S")){
				dest = "/home/";
				
			}
		}
		return (String) dest;
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		super.postHandle(request, response, handler, modelAndView);
		
		System.out.println();
		System.out.println("로그인인터셉트-PostHandle");
		
		HttpSession session = request.getSession();
		ModelMap modelMap = modelAndView.getModelMap();
		Object userVO = modelMap.get("userVO");
		logger.info("메소드타입: "+request.getMethod());
		logger.info("userVO: "+userVO);
		Object dest=session.getAttribute("dest"); //CheckLoginInterceptor를 거쳐왔다면 dest가있음.
		
		if(userVO != null){ //로그인성공
			System.out.println("로그인성공: new login success");
			logger.info("new login suㄴccess");
			
			System.out.println("LoginInterceptor의 destURL: "+dest);
			
				
				//customer , shop +관리자까지 회원 구분후 경로지정.
				if(userVO instanceof CustomerVO ){
					System.out.println("userVO의타입: CustomerVO진입");
					session.setAttribute(LOGIN, (CustomerVO)userVO);
					System.out.println("세션값확인: "+session.getAttribute("login"));
					
					if(request.getParameter("useCookie") != null){ 
						//자동로그인시에 쇼핑몰로그인인지 고객로그인인지 구분필요. LoginDTO에 cus_id 와 adshop_id 중 뭐가는지여부.
						
						logger.info("자동로그인 체크......");
						
						Cookie loginCookie = new Cookie("loginCookie", session.getId());
						Cookie loginPowerCookie = new Cookie("CusPowerCookie", ((CustomerVO) userVO).getP_powernum()+"");
						loginCookie.setPath("/");
						loginCookie.setMaxAge(60 * 60 * 24 * 7); //로그인은 1주일간유지.
						response.addCookie(loginCookie);
						
					}
					
					System.out.println("userVO의 p_powernum: "+((CustomerVO) userVO).getP_powernum());
						if(((CustomerVO) userVO).getP_powernum() == 2){
							System.out.println("개인고객 분기 진입");
							dest =setDest(request, "C");
						//	dest =( dest != null) ? (String)dest:"/home/";
						}else if(((CustomerVO) userVO).getP_powernum() == 0){
							System.out.println("관리자 분기 진입");
							dest = setDest(request,"A");
						//	dest = (dest != null) ? (String)dest:"/home/";
						}
							
				}
				else if(userVO instanceof AdShopVO){ //로그인성공
					System.out.println("userVO의타입: AdShopVO진입");
					session.setAttribute(LOGIN, (AdShopVO)userVO);
					System.out.println("세션값확인: "+session.getAttribute("login"));
					dest = setDest(request,"S");
					//System.out.println("판별 후의 URL: "+(dest != null ? (String)dest:"/home/"));
				}
				
		}else{ //로그인실패
			request.getSession().setAttribute("msg", "회원 아이디 또는 비밀번호가 일치하지 않습니다.(5회 이상 로그인 오류시 본인확인 후 로그인 가능합니다.)");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/cuslogin/login");
			 dispatcher.forward(request, response);
/*				if(dest ==null){
					System.out.println("dest값은 null이다.");
					dest="login";
				}
*/		}
		System.out.println("최종 dest값: "+dest);
		 //RequestDispatcher dispatcher = request.getRequestDispatcher((String) dest);
        // dispatcher.forward(request, response);
	     response.sendRedirect((String)dest);
		//response.sendRedirect((String)dest);
		return;
		
		
		//System.out.println("실행되면안되는 dispatcher, response다음구문.");
	}

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

}
