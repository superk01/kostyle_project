<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ include file="../main/kostyleHeader.jsp" %> 
<html>
<head>
<title>테스트</title>
<style type="text/css">
	#weather_box{
	background-color: #ad82ab;
		margin-left	: 200px;
		color: window;
		font-weight: bold;
		border : 1px solid #ad82ab;
		padding : 10px;
		float : left;
	}
	
	#title{
		padding  : 10px;
		color : gray;
		font-size: 20px;
		font-weight: bold;
		width : 300px;
		margin-left : 250px;
	}
	
	#body_select{
    background-color: #ad82ab;
    border: 1px solid #ad82ab;
    color: window;
    float: none;
    font-weight: bold;
    height: 82px;
    margin-left: 500px;
    padding: 20px;
    width: 450px
	}
	
	#check_type{
		color : #ad82ab;
	}
</style>
<link rel="stylesheet" type="text/css" href="/resources/css/CategoryResult/CategoryResult.css" />
<script src="../../../resources/jquery/jquery-3.2.1.js"></script>
<script type="text/javascript">
var mydata = "null";

$(function(){
	if(mydata == "null"){
		getProductList();
	}
	
	$('.test').click(function(){
		getProductList();
	});
	
	
});	

function getProductList(){
	  var value = "value=" + $('#check_type option:selected').val();		
		$.ajax({
			url : "/weather/showweather",
			type : 'POST',
			data : value,
			success : function(data){
				$('.CategoryResult_oneItemBox').remove();
				var text = "";
				for(var i=0; i<data.length; i++){
					var product_link = data[i].product_link;
					var product_ImageLink = data[i].product_ImageLink;
					var product_name = data[i].product_name;
					var product_price = data[i].product_price;
					
					text += '<div class="CategoryResult_oneItemBox">';
					text += '<div class="CategoryResult_oneItemBox_child_Img"><a href="http://' + 
								product_link + '" class="countShoppingmall"><img src="http://' +
								product_ImageLink + '" class="CategoryResultImgSize"></a></div>';					
					text += '</div>';
				}
				$('#TotalCategoryResult_Box').append(text);	
			}
		});
}
</script>
</head>
<body>
	<div id="title">날씨에 맞는 옷 추천</div>
	<div>
		<div id="weather_box">
			날씨 : ${weather } <br> 체감 온도 : ${level}  　　 불쾌 지수 : ${user_bo} <br> ${user_angry }
		</div>
	</div>
	<div id="body_select">
		<div> 추위나 더위 얼마나 민감한가요 ?
		<select id="check_type">
			<option value="보통" class="test">보통</option>
			<option value="추위 잘 타는편" class="test">추위 잘 타는편</option>
			<option value="추위 조금 타는편" class="test">추위 조금 타는편</option>
			<option value="더위 조금 타는편" class="test">더위 조금 타는편</option>
			<option value="더위 잘 타는편" class="test">더위 잘 타는편</option>
		</select>
		</div>
	</div>
	
	<div id="TotalCategoryResult_Box">	
	
	</div>
</body>
</html>