<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- session(세션) - 서버에서 사용자를 인증하는 기술 -->
<%
/* // 세션 객체에 변수 저장(사용자 단위 변수)
session.setAttribute("name", "김철수");//변수, 값
session.setAttribute("age", 20);
//다른 페이지로 이동해도 세션 객체에 값이 유지됨
response.sendRedirect("session_result.jsp"); */
%>

<form method="post" 
action="sessionTestForm.mypage">
<!-- 	아이디 <input name="id"> <br>
	비밀번호 <input type="password" name="pass"><br>
	<input type="submit" value="로그인"> -->
	
c_num 입력 : <input name="c_num"><br>
<input type="submit" value="확인">
</form>
<!-- param.변수 => request.getParameter("변수") -->
<span style="color:red;">${param.message}</span>

</body>
</html>