<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ include file="../main/kostyleHeader.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:forEach var="coordi" items="${list}">
	<img alt="" src="/${coordi.cd_img}">
	<img alt="" src="F:\\workspace\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\kostyleFINAL\resources\images\coordiuploadimg\13393f7a-30bb-4012-bbef-9b8fe5875214_%EA%B4%91%EC%95%88%EB%8C%80%EA%B5%90.jpg">
</c:forEach>
</body>
</html>