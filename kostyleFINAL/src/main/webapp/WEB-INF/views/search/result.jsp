<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ include file="../main/kostyleHeader.jsp" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/../../resources/css/CategoryResult/CategoryResult.css" />
<!-- <script type="text/javascript" src="../resources/js/jquery.js"></script> -->
<script src="../../../resources/jquery/jquery-3.2.1.js"></script>
<script type="text/javascript"  src="/../../resources/js/CategorysearchResult/CategorysearchResult2.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$('div.CategoryResult_oneItemBox').on('click',function(event){
		alert("이벤트 걸림?");
		event.preventDefault();
		/* var product_link=$(this).eq(0).find('a').attr('href');
		var product_ImageLink=$(this).eq(0).find('img').attr('src');
		var product_name=$(this).children().eq(1).find('a').html();
		var product_price=$(this).children().eq(2).find('a').html(); */
		
/* 		alert($(this).eq(0).find('img').attr('src'));
		alert($(this).eq(0).find('a').attr('href'));
		alert($(this).children().eq(1).find('a').html());
		alert($(this).children().eq(2).find('a').html()); */
		
		/* var nodes=$(this).children();
		alert(nodes.length); */
		
		$.ajax({
			url : '/history/insert',
			type : 'post',
			headers:{
				"Content-Type":"application/json",
				"X-HTTP-Method-Override":"POST"
			},
			data : JSON.stringify(
					{h_Prdurl:$(this).eq(0).find('a').attr('href'),
					h_Imgurl:$(this).eq(0).find('img').attr('src'),
					h_Name:$(this).children().eq(1).find('a').html(),
					h_Price:$(this).children().eq(2).find('a').html()}),
			success : function(){
				/* alert('히스토리에 추가');
				if(result!=null){
					location.href="${path}/history/list/"+result;
				} */
			}		
			});
		});
	});
	


</script>
</head>
<body>

<div id="CategoryBody">
      <div id="CategoryResult_top"></div>
      <div id="CategoryFilter">
         <div id="CategoryFilterBox">
            <div class="CategoryFilterListFirst" id="CategoryResulttop"><a href="#" id="" class="filteraclass">상품 필터　　　　　|　　　　</a></div>
            <div class="CategoryFilterList"><a href="#" id="CategoryFilterrandom" class="filteraclass">무작위로 보기</a></div>
            <div class="CategoryFilterList"><a href="#" id="CategoryFilterhotproduct" class="filteraclass">인기상품 보기</a></div>
            <div class="CategoryFilterList"><a href="#" id="CategoryFilterminprice" class="filteraclass">낮은 가격 순</a></div>
            <div class="CategoryFilterListEnd"><a href="#" id="CategoryFiltermaxprice" class="filteraclass">높은 가격 순</a></div>                        
         </div>
      </div>	
      <div id="TotalCategoryResult_Box">
			<c:forEach var="product" items="${list}">
				<div class="CategoryResult_oneItemBox">
					<div class="CategoryResult_oneItemBox_child_Img"><a href="${product.product_link}" class="countShoppingmall"><img src="${product.product_ImageLink}" class="CategoryResultImgSize"></a></div>
					<div class="CategoryResult_oneItemBox_child_Name"><a href="${product.product_link}" class="countShoppingmall">${product.product_name}</a></div>
					<div class="CategoryResult_oneItemBox_child_price"><a href="${product.product_link}" class="countShoppingmall">${product.product_price}</a></div>
				</div>
			</c:forEach>
		</div>
	</div>
</body>
</html>