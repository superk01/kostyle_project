<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" 
uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" 
value="${pageContext.request.contextPath}"/>

	
		<div id="select_mypage">
		
			<ul>
			<a href = "${path}/board/view.do?bno=${row.bno}">
				<li><a href="${path}/mypage/MypageMain">회원정보 관리</a>
				<li><a href="${path}/mypage/StatMain">통계</a>
				<li><a href="${path}/mypage/InitMain">데이터초기화</a>
				<li><a href="${path}/mypage/WithdrawalMain">탈퇴하기</a>
			</ul>
		
		</div>
