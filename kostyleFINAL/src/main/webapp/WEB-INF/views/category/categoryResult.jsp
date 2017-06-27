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
<script type="text/javascript" src="/resources/js/jquery.js"></script>
<script type="text/javascript"  src="/resources/js/CategorysearchResult/CategorysearchResult.js"></script>
<script type="text/javascript"  src="/resources/js/customer_taste_stack/customer_taste_stack.js"></script>
<title>Insert title here</title>
<script type="text/javascript">
$(document).ready(function(){
	//히스토리 상품 추가
		$('.CategoryResult_oneItemBox').on('click',function(event){
			alert('히스토리');
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
		//아이프레임 추가
		$('.CategoryResult_oneItemBox').click(function(event){
			alert('아이프레임');
			event.preventDefault();
			var link = $(this).find('a').eq(1).attr('href');
			var h_Name = $(this).children().eq(1).find('a').html();
			if($('#CategorysearchIframe').length>0){
				$('#CategorysearchIframe').remove();
			}
			location.href = "#CategoryResult_top";
			$('#TotalCategoryResult_Box').parent().prepend(' <div id="IframeRemocon">쇼핑몰 닫기</div> ');
			$('#TotalCategoryResult_Box').parent().prepend('<iframe id="CategorysearchIframe" width="100%" height="900" src="'+link +'">');
			$('#TotalCategoryResult_Box').parent().prepend('<input type="hidden" name="productName" id="prdName" value="'+h_Name+'">');
			
			$('#IframeRemocon').click(function(){
				$('#CategorysearchIframe').remove();
				$('#IframeRemocon').remove();
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
				<div class="CategoryFilterList" id="CateogyrFilterColor">
					<div class="categoryOn"><a href="#">색상</a></div>
					<div class="categoryOff">						
						<c:forEach items="${colorList}" var="item" varStatus="colorList_status">
							<c:if test="${colorList_status.count % 5 != 0}">						
								<div class="filteraclass categoryColor filterclassNext" data-k="${keyword}" data-f="${item}">${item}</div>
							</c:if>
							<c:if test="${colorList_status.count % 5 == 0}">
								<div class="filteraclass categoryColor" data-k="${keyword}" data-f="${item}">${item}</div>	
							</c:if>
						</c:forEach>					
					</div>
				</div>
		
				<div class="CategoryFilterList"><a href="#" id="CategoryFilterrandom" class="filteraclass" data-f="random" data-k="${keyword}">무작위로 보기</a></div>
				<div class="CategoryFilterList"><a href="#" id="CategoryFilterhotproduct" class="filteraclass" data-f="hit" data-k="${keyword}">인기상품 보기</a></div>
				<div class="CategoryFilterList"><a href="#" id="CategoryFilterminprice" class="filteraclass" data-f="min" data-k="${keyword}">낮은 가격 순</a></div>
				<div class="CategoryFilterList"><a href="#" id="CategoryFilterdefault" class="filteraclass" data-f="" data-k="${keyword}">필터 초기화</a></div>
				<div class="CategoryFilterListEnd"><a href="#" id="CategoryFiltermaxprice" class="filteraclass" data-f="max" data-k="${keyword}">높은 가격 순</a></div>
												
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