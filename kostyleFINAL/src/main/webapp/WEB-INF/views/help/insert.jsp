<%-- <%@page import="Customer.model.AdShoppingMall"%> --%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
    
  
    
<!DOCTY PE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>문의글 작성 폼</title>
<!-- <link rel="stylesheet" type="text/css" href="write.css"> -->
</head>
<body>

	<form action="/help/insert" method = "post">
		<table border="1px solid">
			<tr>
				<td id = "category">쇼핑몰 선택</td>
				<td>
					<div style="width: 95px">
						<select id="shoppingmall" name = "s_Name">
							<option>선택</option>
							<c:forEach var="shoppingMall" items="${list }">
								<option>${shoppingMall.s_Name }</option>
							</c:forEach>
						
					<!-- 		<option>1</option>
							<option>2</option>
							<option>3</option> -->
						</select>
					</div> 
				</td>
				<td id = "category">문의 종류 선택</td>
				<td>
					<div style="width: 100px">
						<select id="q_sort" name = "selectsort">
							<option>선택</option>
							<option>주문/결제</option>
							<option>배송</option>
							<option>취소</option>
							<option>반품</option>
							<option>교환</option>
						</select> 
					</div>
				</td>
			</tr>
			<tr>
				<td id = "category">문의 제목</td>
				<td colspan="3">
					<input type="text" name="q_Title" style="width:305px">
				</td>
				
				
			</tr>
			<tr>
				<td id = "category">문의 내용</td>
				<td colspan="3"><textarea rows="7" cols="60" name="q_Content"></textarea></td>
			</tr>
			<tr>
				<td colspan="4" align="center">
				<input type="checkbox" name="q_Secret">비밀글
				<input type="submit" value="제  출">
				<input type="reset" value="내용삭제">
				 
				</td>
			</tr>
		</table>	
	</form>
	<a href = "/help/list"><button>목록보기</button></a>
</body>
</html>