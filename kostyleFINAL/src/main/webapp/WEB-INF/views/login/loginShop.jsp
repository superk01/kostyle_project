<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN""http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="../resources/css/login/loginStyle.css">
</head> 
<body>
<div id="bodys">

	<section id="leftSection">
		<div>
			<a href="" id="homeIcon"><div><img src="../resources/images/kostyle_icon/쇼핑몰.png"></div></a>
		</div>
		<section id="joinSection">
	         <h3 class="menuText">JOIN US</h3>
			<div>
				<a href=""><img id="joinCustomer" src="../resources/images/login/003-customerIcon.png"></a>
				<p><b>개인회원</b></p>
			</div>
			<div>
				<a href=""><img id="joinShop" src="../resources/images/login/002-shopIcon.png"></a>
				<p><b>사업자회원</b></p>
			</div>		
		</section>
	</section>
	
	<section id="rightSection">
		
		<div id="loginDiv">
			<form id="loginForm"action="loginShopAction.bsylogin" method="post">
	                            <h3 class="menuText">SIGN IN</h3>
	                           	<ul id="typeUL">
	                           		<li class=""><a href="loginCustomer.jsp">개인</a></li>
	                           		<li class=""><a href="loginShop.jsp"><img alt="" src="../resources/images/kostyle_icon/026-checked.png" >쇼핑몰</a></li>
	                           	</ul>
	                            <div>
	                            <label for="id_label">아이디</label>
	                            <input id="id" required=""type="text"name="ad_id" value="" class="">
	                            <span class="text_right" id="msg_empty_id">* 이메일를 반드시 입력해주세요.</span>
	                            <span class="text_right" id="msg_wrong_id">* 가입되지 않은 이메일입니다.</span>
	                            <span class="text_right" id="msg_unable_id">* 사용할 수 없는 계정입니다</span>
	                            <label class="password_label" for="password">비밀번호</label>
	                            <input id="password" required="" type="password" name="ad_pass"class="">
	                            <span class="text_right" id="msg_empty_pw" >* 비밀번호를 반드시 입력해주세요.</span>
	                            <span class="text_right" id="msg_wrong_pw" >* 비밀번호를 다시 확인해주세요.</span>
	
								<input type="hidden" name="preURI" value="<%request.getRequestURI();%>">
	                            <input id="shopBtn" type="submit" value="로그인">
	                        	</div>
	                        </form>		
	                        	<c:if test="${sessionScope.c_num != null}"> 
	                        		<%=session.getAttribute("c_num") %>
	                        	</c:if>
	                        		<%=session.getAttribute("s_num") %>

		</div>
                        
                        
		
	</section>
</div>
</body>
</html>