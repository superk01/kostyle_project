<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function fn_history(){
	location.href = "listAction.history?c_num=7"
}
function fn_remocon(){
	location.href = "remoconAction.history?c_num=1"
}
</script>
</head>
<body>
	<input type="button" value="최근본 상품" onclick="fn_history()">
	<input type="button" value="리모컨" onclick="fn_remocon()"> 
</body>
</html>