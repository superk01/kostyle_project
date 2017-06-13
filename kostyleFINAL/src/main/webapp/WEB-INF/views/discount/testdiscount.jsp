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
<link rel="stylesheet" type="text/css" href="../resources/css/CategoryResult/CategoryResult.css" />
<!-- <script type="text/javascript" src="../resources/js/jquery.js"></script> -->
<script src="../../../resources/jquery/jquery-3.2.1.js"></script>
<script type="text/javascript"  src="../resources/js/CategorysearchResult/CategorysearchResult2.js"></script>
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
			url : '${path}/history/insert',
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
				alert('히스토리에 추가');
				if(result!=null){
					location.href="${path}/history/list/"+result;
				}
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