<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
${reply.as_Num }<br><!-- 댓글 번호 -->
<textarea id="as_Content" rows="3" cols="40">${reply.as_Content}</textarea><br>
<button id="btnRelpyUpdate" type="button">수정</button>
<!-- <button id="btnRelpyDelete" type="button">삭제</button>
<button id="btnRelpyClose" type="button">닫기</button> -->
</body>
</html>