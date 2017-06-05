<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String body = request.getParameter("body");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="../resources/js/main/zzim.js"></script>
<title>Insert title here</title>
</head>
<body id="templateBody">
	<jsp:include page="header.jsp"/>
	<jsp:include page="menu.jsp"/>
	<%
		if(body==null){	
		response.sendRedirect("../main.csh");
	}else{ %>
	<jsp:include page="<%= body %>"/>
	<%} %> 
	<jsp:include page="footer.jsp"></jsp:include>
	<% if(session.getAttribute("c_num") != null){%>
		<%-- <jsp:include page="../sidebar/sidebar2.jsp"/> --%>
	<%}%>
	<% if(body != null){if(body.indexOf("search") != -1){ %>
	<%-- <jsp:include page="../history/test.jsp"></jsp:include> --%>
	<%}} %>
</body>
</html>