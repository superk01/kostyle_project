<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>

    <link href="../../../resources/css/bootstrap/bootstrap.min.css" rel="stylesheet">
    <link href="../../../resources/css/admin/shopJoin.css" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
</head>
<body>
	<div>
	<table class="table table-hover">
		<tr>
			<th>번호</th>
			<th>쇼핑몰명</th>
		</tr>
		
		<c:forEach items="${list }" var="ShoppingMall">
			<tr>
			<td>${ShoppingMall.s_num }</td>
			<td><a href='/admin/shopDetail?s_num=${ShoppingMall.s_num }'>${ShoppingMall.s_sname }</a></td>
			</tr>
		</c:forEach>
	
	</table>
	</div>

</body>
</html>