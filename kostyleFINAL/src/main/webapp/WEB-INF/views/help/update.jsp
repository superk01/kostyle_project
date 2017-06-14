<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %> 
    <%@ taglib prefix="fmt" uri = "http://java.sun.com/jsp/jstl/fmt"%>
    <%@ include file="../main/kostyleHeader.jsp" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<form action="update" method="post">
	제목 : <input type="text" name="q_Title" value="${board.q_Title }"><br>
		 <input type="hidden" value = "${board.q_Num}" name = "q_Num">
			
			
	내용 <br>
	<textarea rows="6" cols="70" name="q_Content">${board.q_Content }</textarea>
	<br>
	<%-- 패스워드 : <input type="text" name = "c_Id" value="${board.c_Id }"> --%>
	<input type="submit" value="수정">
</body>
</html>