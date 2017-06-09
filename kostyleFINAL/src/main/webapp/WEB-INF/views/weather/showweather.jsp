<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
<title>테스트</title>
<link rel="stylesheet" type="text/css" href="/resources/css/CategoryResult/CategoryResult.css" />
<script src="../../../resources/jquery/jquery-3.2.1.js"></script>
<script type="text/javascript">
$(function(){
	$('.test').click(function(){
		var value = "value=" + $('#check_type option:selected').val();		
		$.ajax({
			url : "/weather/showweather",
			type : 'POST',
			data : value,
			success : function(data){
				var text = "";
				for(var i=0; i<data.length; i++){
					var product_link = data[i].product_link;
					var product_ImageLink = data[i].product_ImageLink;
					var product_name = data[i].product_name;
					var product_price = data[i].product_price;
					
					text += '<div class="CategoryResult_oneItemBox">';
					text += '<div class="CategoryResult_oneItemBox_child_Img"><a href="http://' + product_link + '" class="countShoppingmall"><img src="http://' + product_ImageLink + '" class="CategoryResultImgSize"></a></div>';					
					text += '</div>';
				}
				$('#TotalCategoryResult_Box').append(text);	
			}
		});
	});
});	
</script>
</head>
<body>
	
	<div>
		<select id="check_type">
			<option value="보통" class="test">보통</option>
			<option value="추위 잘 타는편" class="test">추위 잘 타는편</option>
			<option value="추위 조금 타는편" class="test">추위 조금 타는편</option>
			<option value="더위 조금 타는편" class="test">더위 조금 타는편</option>
			<option value="더위 잘 타는편" class="test">더위 잘 타는편</option>
		</select>
	</div>
	
	<div id="TotalCategoryResult_Box">	
	
	</div>
</body>
</html>