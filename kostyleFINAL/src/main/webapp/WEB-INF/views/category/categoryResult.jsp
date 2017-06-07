<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="/resources/css/CategoryResult/CategoryResult.css" />
<script type="text/javascript" src="/resources/js/jquery.js"></script>
<script type="text/javascript"  src="/resources/js/CategorysearchResult/CategorysearchResult.js"></script>
<script type="text/javascript"  src="/resources/js/customer_taste_stack/customer_taste_stack.js"></script>
<title>Insert title here</title>
</head>
<body>
	<div id="CategoryBody">
		<div id="CategoryResult_top"></div>
		<div id="CategoryFilter">
			<div id="CategoryFilterBox">
				<div class="CategoryFilterListFirst" id="CategoryResulttop"><a href="#" id="" class="filteraclass">상품 필터　　　　　|　　　　</a></div>
				<div class="CategoryFilterList" id="CateogyrFilterColor">
					<a href="#" class="filteraclass">색상</a>
				</div>
		
				<div class="CategoryFilterList"><a href="#" id="CategoryFilterrandom" class="filteraclass">무작위로 보기</a></div>
				<div class="CategoryFilterList"><a href="#" id="CategoryFilterhotproduct" class="filteraclass">인기상품 보기</a></div>
				<div class="CategoryFilterList"><a href="#" id="CategoryFilterminprice" class="filteraclass">낮은 가격 순</a></div>
				<div class="CategoryFilterList"><a href="#" id="CategoryFilterdefault" class="filteraclass">필터 초기화</a></div>
				<div class="CategoryFilterListEnd"><a href="#" id="CategoryFiltermaxprice" class="filteraclass">높은 가격 순</a></div>
												
			</div>
		</div>
		
		<div id="TotalCategoryResult_size">${product_list.size()} 개 상품 찾음</div>
		<div id="TotalCategoryResult_Box">	
				<c:forEach var="product" items="${product_list}">
					<div class="CategoryResult_oneItemBox">
						<div class="CategoryResult_oneItemBox_child_Img"><a href="http://${product.product_link}" class="countShoppingmall"><img src="http://${product.product_ImageLink}" class="CategoryResultImgSize"></a></div>
						<div class="CategoryResult_oneItemBox_child_Name"><a href="http://${product.product_link}" class="countShoppingmall">${product.product_name}</a></div>
						<div class="CategoryResult_oneItemBox_child_price"><a href="http://${product.product_link}" class="countShoppingmall">${product.product_price}</a></div>
					</div>
				</c:forEach>
		</div>
	</div>
</body>
</html>