<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN""http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="../resources/css/login/loginStyle.css">
<script type="text/javascript">
	$(function(){
		$('#loginForm > input[type=submit]').on
		
		
	});
</script>
</head>
<body>
<div id="bodys">
<%-- 	<c:if test=${sessionScope.loginId !=null}>
		<script>
			history.go(-1);
		</script>
	</c:if> --%>

	<section id="leftSection">
		<div>
			<a href="../main.csh" id="homeIcon"><div><img src="/../../resources/images/kostyle_icon/개인.png"></div></a>
		</div>
		<section id="joinSection">
	         <h3 class="menuText">JOIN US</h3>
			<div>
				<a href=""><img id="joinCustomer" src="../resources/images/login/003-customerIcon.png" onclick="window.location='개인회원가입페이지'"></a>
				<p><b>개인회원</b></p>
			</div>
			<div>
				<a href=""><img id="joinShop" src="../resources/images/login/002-shopIcon.png" onclick="window.location='사업자회원가입페이지'"></a>
				<p><b>사업자회원</b></p>
			</div>		
		</section>
	</section>
	
	<section id="rightSection">
		
		<div id="loginDiv">
			<form id="loginForm"action="/login/loginPost"method="post">
	                            <h3 class="menuText">SIGN IN</h3>
	                           	<ul id="typeUL">
	                           		<li class=""><img alt="" src="../resources/images/kostyle_icon/026-checked.png"><a href="loginCustomer.jsp">개인</a></li>
	                           		<li class=""><a href="loginShop.jsp">쇼핑몰</a></li>
	                           	</ul>
	                            <div>
	                            <label for="id_label">아이디</label>
	                            <input id="id" required=""type="text"name="c_id" value="" class="">
	                            <span class="text_right" id="msg_empty_id">* 아이디를 입력해주세요.</span>
	                            <span class="text_right" id="msg_wrong_id">* 존재하지 않는 아이디입니다.</span>
	
	                            <label class="password_label" for="password">비밀번호</label>
	                            <input id="password" required="" type="password" name="c_pass"class="">
	                            <span class="text_right" id="msg_empty_pw" >* 비밀번호를 입력해주세요.</span>
	                            <span class="text_right" id="msg_wrong_pw" >* 비밀번호를 다시 확인해주세요.</span>
							
								<input type="hidden" name="preURL" value="${request.getRequestURL()}">
	                            <input id="customerBtn" type="submit" value="로그인" >
	                        	</div>
	                        </form>		
	                        <%session.setAttribute("c_num", "3"); %>
		</div>
                        
                        
		
	</section>
</div>
</body>
</html>