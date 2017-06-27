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
<link rel="stylesheet" type="text/css" href="/resources/css/CategoryResult/CategoryResult.css" />
<style>
#discount_h1{
	margin-left : 3%;
/* 	margin-top:50px;
	margin-bottom: 15px;
	font-size: 50px;
	font-family: 'Quicksand', sans-serif; */
	font-weight: 700;
    margin: 15px 3% ;
    
}

</style>
		<!-- Website Font style -->
	    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.1/css/font-awesome.min.css">
		<link rel="stylesheet" href="product.css">
		<!-- Google Fonts -->
		<link href="https://fonts.googleapis.com/css?family=Quicksand:300,400,500,700&amp;subset=latin-ext,vietnamese" rel="stylesheet">
<link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css"> 
<!-- <script type="text/javascript" src="../resources/js/jquery.js"></script> -->
<script src="/resources/jquery/jquery-3.2.1.js"></script>
<script type="text/javascript"  src="/resources/js/discount/discount.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$('div.CategoryResult_oneItemBox').on('click',function(event){
		event.preventDefault();
		$.ajax({
			url : '/history/insert',
			type : 'post',
			headers:{
				"Content-Type":"application/json",
				"X-HTTP-Method-Override":"POST"
			},
			data : JSON.stringify({h_Prdurl:$(this).eq(0).find('a').attr('href'),
					h_Imgurl:$(this).eq(0).find('img').attr('src'),
					h_Name:$(this).children().eq(1).find('a').html(),
					h_Price:$(this).children().eq(2).find('a').html()}),
			success : function(result){
				$('.wing_fixed').remove();
				remoconList();
			}		
			});
		});
	});
	


</script>
</head>
<body>
<h1 id="discount_h1">신상품 할인</h1>
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
					<div class="CategoryResult_oneItemBox_child_Img"><a href="${product.sale_prdUrl}" class="countShoppingmall"><img src="${product.sale_imgUrl}" class="CategoryResultImgSize"></a></div>
					<div class="CategoryResult_oneItemBox_child_Name"><a href="${product.sale_prdUrl}" class="countShoppingmall">${product.sale_name}</a></div>
					<div class="CategoryResult_oneItemBox_child_Name"><a href="${product.sale_prdUrl}" class="countShoppingmall">${product.s_sname}</a></div>
					<div class="CategoryResult_oneItemBox_child_price"><a href="${product.sale_prdUrl}" class="countShoppingmall">${product.sale_beforeDiscountprice }</a></div>
					<div class="CategoryResult_oneItemBox_child_price"><a href="${product.sale_prdUrl}" class="countShoppingmall">${product.sale_afterDiscountprice }</a></div>
					<c:choose>
					<c:when test="${product.sale_discountRate !=0}">
						<div class="CategoryResult_oneItemBox_child_price"><a href="${product.sale_prdUrl}" class="countShoppingmall">${product.sale_discountRate }%</a></div>
					</c:when>
					<c:otherwise>
						<p></p>
					</c:otherwise>
					</c:choose>
					
					
					<c:choose>
					<c:when test="${product.sale_onePlusOne != null}">
						<div class="CategoryResult_oneItemBox_child_price"><a href="${product.sale_prdUrl}" class="countShoppingmall">${product.sale_onePlusOne }</a></div>
					</c:when>
					<c:otherwise>
						<p></p>
					</c:otherwise>
					</c:choose>
				</div>
			</c:forEach>
		</div>
	</div>
</body>
</html>