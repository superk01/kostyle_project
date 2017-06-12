<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ include file="main/kostyleHeader.jsp" %>

<html>
<head>
<script src="../../../resources/jquery/jquery-3.2.1.js"></script>
<script type="text/javascript">
	 $(document).ready(function(){ 
		var returnPath1 = jQuery(location).attr('pathname')+"";
		var returnPath2 = location.pathname+"";
		console.log("returnPath= "+returnPath1);
		
		
 		$('#cuslogout a').on('click',function(){
// 			$.post("/cuslogin/logout", { returnPath: returnPath1+"" });
 			$.post("/cuslogin/logout", { returnPath: "${path}/logintest/testpage1" },function(result){
 				if(result == "SUCCESS"){
	 				console.log("logout ajax 성공");
 					location.href=returnPath1;
 					
 				}
 			});
//			location.href = $(this).attr("href");
			//location.href = "/cuslogin/logout/"+returnPath1;
			return false;
		});
		
		$('#shoplogout ').on('click', function(){
//			location.href = $(this).attr("href");
			//location.href = "/shoplogin/logout/"+currentPath1;
			console.log("shoplogout event+ path: "+"/shoplogin/logout/"+currentPath1);
			return false;
		}); 
		
	});
</script>
	<title>Home</title>
</head>


<body>

<h1>
	Hello world!  
</h1>
<c:set var="currentPath" value="${requestScope.currentPath }"></c:set>
<c:set var="loginSession" value="${sessionScope.login }"></c:set>
<c:set var="shoploginSession" value="${sessionScope.shoplogin }"></c:set>

<c:if test="${empty sessionScope.login && empty sessionScope.shoplogin}">
	<a href="/cuslogin/login">고객로그인</a>
	<a href="/shoplogin/login">쇼핑몰로그인</a>
	<a href="/find/id">아이디 찾기</a>
	<a href="/find/password">비밀번호 찾기</a>
</c:if>

<c:choose>
	<c:when test="${not empty login}">
		<p>고객세션있음</p>
		<!-- <div id="cuslogout">고객로그아웃</div> -->
 		<div id="cuslogout"><a href="/cuslogin/logout/"+${currentPath }>고객로그아웃</a></div> 
	</c:when>
	<c:when test="${not empty shoplogin}">
		<p>쇼핑몰세션있음</p>
		<div id="shoplogout">쇼핑몰로그아웃</div>
 		<div id="shoplogout"><a href="/shoplogin/logout/"+${currentPath }>쇼핑몰로그아웃</a></div> 
		
	</c:when>
<%-- 	<c:when test="${not empty sessionScope.login}">
		<p>고객세션있음</p>
		<div id="cuslogout"><a href="/cuslogin/logout/${currentPath }">고객로그아웃</a></div>
	</c:when>
	<c:when test="${not empty sessionScope.shoplogin}">
		<p>쇼핑몰세션있음</p>
		<div id="shoplogout"><a href="/shoplogin/logout/${currentPath }">쇼핑몰로그아웃</a></div>
		
	</c:when> --%>
</c:choose>
<div>
<div>${login.getC_name() }님 환영합니다.</div>
	고객세션: ${login.c_name }
	<br>
	고객세션: ${sessionScope.login.c_name }
	<br>
	고객세션: ${loginSession.c_name }
	<br>
	쇼핑몰세션: ${sessionScope.shoplogin }
</div>

<br><br><a href="/admin/shopList">shoppingMall List</a>

<P>  The time on the server is ${serverTime}. </P>
<P>  "${path }" </P>

<br><br><br><br><br><br><br><br><br><br><br><br>
	<div class="search_field">
	<form action="search/do" method="post">
		<div class="search_box">
			<dl class="clear_float">
				<dt><input type="text" name="search"></dt>
				<dd><input type="image" src="../resources/images/mainImg/mainsearch.png" alt="검색" title="검색"></dd>
			</dl>
		</div>
	</form>
	</div>
<div>
	<a href="history/list/${login.c_num}">히스토리로 이동</a><br>
	<a href="remocon/list/${login.c_num}">리모콘 보기</a>
</div>
</body>
</html>