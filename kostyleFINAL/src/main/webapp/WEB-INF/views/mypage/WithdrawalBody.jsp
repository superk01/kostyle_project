<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String body = request.getParameter("body");

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%-- <%@ include file="session_check.jsp" %> --%>
<style type="text/css">
	@IMPORT url("../resources/css/mypage/MypageBody.css");
</style>	
</head>


<body>
<c:if test="${message == 'success' }">
<h2>
		${sessionScope.login.c_name}(${sessionScope.login.c_id})님  
		환영합니다.
</h2>
</c:if>
<header>
	<jsp:include page="header.jsp"/>
</header>	
<section>
	<div id="container">
	
 			<jsp:include page="menu.jsp"/>
 			
	<%-- 		<% if(body == null){
				response.sendRedirect("sessionTestForm.mypage");
			}else{%>
			<jsp:include page="<%=body %>"/>
			<%} %> 
	--%>
			 
			  <jsp:include page="WithdrawalCheck.jsp"/>
	</div>
</section>

</body>
</html>