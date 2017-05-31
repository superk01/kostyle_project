<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %> 
    <%@ taglib prefix="fmt" uri = "http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<form action="updateAction.a" method="post">
	제목 : <input type="text" name="q_title" value="${board.getC_Title() }"><br>
			<input type="hidden" value = "${board.getC_Num()}" name = "c_num">
			
			
	내용 <br>
	<textarea rows="6" cols="70" name="q_content">${board.getC_content() }</textarea>
	<br>
	패스워드 : <input type="text" name = "${board.getC_Id() }" value="${board.getC_Id() }">
	<input type="submit" value="수정">
</body>
</html>