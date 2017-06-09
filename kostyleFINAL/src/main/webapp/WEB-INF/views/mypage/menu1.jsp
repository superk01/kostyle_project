<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" 
uri="http://java.sun.com/jsp/jstl/core" %>
<!-- src/main/webapp/WEB-INF/views/include/menu.jsp -->

<%-- <a href="${path}/board/list.do">게시판</a>  --%>
<c:choose>
	<c:when test="${sessionScope.c_id == null }">
		<a href="${path}/mypage/login">로그인</a>
	</c:when>
	<c:otherwise>
		${sessionScope.c_name}님이 로그인중입니다.
		<a href="${path}/mypage/logout">로그아웃</a>
	</c:otherwise>
</c:choose>
<hr>