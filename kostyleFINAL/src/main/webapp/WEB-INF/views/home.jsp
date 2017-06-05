<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>
<a href="/cuslogin/login">로그인</a>
<br><br><a href="/admin/shopList">shoppingMall List</a>

<P>  The time on the server is ${serverTime}. </P>
<P>  "${path }" </P>
	<div class="search_field">
	<form action="${path }/search/do" method="get">
		<div class="search_box">
			<dl class="clear_float">
				<dt><input type="text" name="search"></dt>
				<dd><input type="image" src="../resources/images/mainImg/mainsearch.png" alt="검색" title="검색"></dd>
			</dl>
		</div>
	</form>
	</div>
</body>
</html>
