<%-- <%@page import="history.model.HistoryDao"%> --%>
<%@page import="java.util.ArrayList"%>
<%-- <%@page import="Category.model.Product_list"%> --%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%-- <% if(session.getAttribute("c_num") != null){
		int c_num = Integer.parseInt((String)session.getAttribute("c_num"));
		HistoryDao dao = HistoryDao.getInstance();
		session.setAttribute("list", dao.listHistory(c_num));
		
	}	
%> --%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
	body{
		margin : 0px;
	}
	#main A:link{
		text-decoration: none;
		color : black;
	}
	#main A:hover{
		text-decoration: none;
		color : black;
	}
	
	#main A:active{
		text-decoration: none;
		color : black;
	}
	
	#main A:VISITED{
		text-decoration: none;
		color : black;
	}


	#main{
		background-color : #E8E7E0;
		font-family: 'Noto Sans', sans-serif;
		width: 100%;
	}
	
	#mainshowpage{
		width : 100%;
		height : 700px;
		background-image: url("../resources/images/mainImg/background_2.jpg");
		background-size : cover;
		background-repeat : no-repeat;
	}
	

	#mainshowpage_TotalContent{
		padding-top: 200px;
		color: white;
		font-style: italic;
		font-weight: bold;
		text-align: center;
		font-size : 20px;
	}
	
	#mainshowpage_Title_one{
		font-size	: 60px;
		
	}
	
	#mainshowpage_view{
		margin-left : 44%;
		font-style : normal;	
		font-size : 20px;
		margin-top : 50px;
		border : 4px solid white;
		border-radius: 20px;
		padding : 5px;
		padding-left : 15px;
		padding-right : 15px;
		width : 10%;
		height : 25px;
	}
	
	#contentBox{
		display : none;
		color:black;
		margin-left: 3%;
		width : 97%;		
	}
	
	#fristContent{
		width : 97%;
		margin-right : 50px;
		margin-bottom : 100px;
		font-size: 30px;
	}
	
	#middleContent{
		width : 97%;
		margin-right : 50px;
		margin-bottom : 100px;
		
	}
	#lastContent{
		width : 97%;
	}
	
	#fristContent_title{
		float : left;
	}
	
	#fristContent_title_box{
		background-color: #F2F2F2;
		margin-top : 15px;
	}
	#fristContent_Total_Img_Box{
		margin-top : 15px;
	}
	#maintime{
		margin-left : 17%;
	 	font-size: 30px;
  		font-style: oblique;
  		width : 150px;
  		float: left;
	}
	
	#maintimesec{
		font-size : 0px;
	}
	
	#weatherContent{
		margin-left : 5%;
	}
	
	#weatherImg{
		float:left;	
	}
	
	.fristContent_img_Box{
		width: 19.8%;
		float: left;
		font-size: 10px;
		border: 1px solid white;
		background: white;
		margin-bottom: 20px;
	}
	
	.fristContent_img_first{
		height : 350px;
	}
	
	.fristContent_img_first_name{
		text-align : center;
				font-size:15px;
	}
	
	.fristContent_img_first_price{
		text-align : center;
		font-size:15px;		
	}
	
	
	.fristContent_img_first_Size{
		width : 100%;
		height : 100%;
	}

	
</style>
<script type="text/javascript" src="../resources/js/jquery.js"></script>
<script type="text/javascript"  src="../resources/js/mainpage/mainpage.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>

<body>
	<div id ="mainshowpage" >
		<div id="mainshowpage_TotalContent">
			<div id="mainshowpage_Title">
				<div id="mainshowpage_Title_one">Kostyle Mall</div>
				<div id="mainshowpage_Title_two">여성 쇼핑몰을 이곳에 모으다</div>
				<div id="mainshowpage_Title_three">원하는 옷을 검색창에 검색해 주세요</div>
				<div id="mainshowpage_view">오늘의 코디</div>
			</div>
		</div>
		<div id="mainshowpage_Content"></div>
	</div>
	<div id= "main">
	 	<div id="contentBox">
	 		<div id="fristContent">
	 			<div id="fristContent_title_box">
	 				<div id="fristContent_title">오늘 입기 좋은 옷</div>
					<div id="maintime"><span id="maintimehr">00</span><span class="maintimefilter">:</span><span id="maintimemin">00</span><span class="maintimefilter">:</span><span id="maintimesec_first"></span><span id="maintimesec">00</span>
					</div>
	 				<div id="weatherContent">	
	 					<div id="weatherbox">
	 						 날씨-${csh_weather.resultweather } ${csh_weather.resultC}℃
		 				</div> 			 				 			
	 				</div>		 				
	 			</div>
	 			<div id="fristContent_Total_Img_Box">
	 				<div id="fristContent_img">
		 				<c:forEach var="product" items="${main_product_list}">		 				
							<div class="fristContent_img_Box"> 					
 								<div class="fristContent_img_first_name"><a href="http://${product.product_link}" class="countShoppingmall">${product.product_shopname}</a></div>
								<div class="fristContent_img_first"><a href="http://${product.product_link}" class="countShoppingmall"><img src="http://${product.product_ImageLink}" class="fristContent_img_first_Size"></a></div>
							<!-- <div class="fristContent_img_first_price"><a href="http://${product.product_link}" class="countShoppingmall">${product.product_price}</a></div> -->	
							</div>						
						</c:forEach>
	 				</div>
	 			</div>
	 		</div>
	 		
	 		<div id="middleContent">
	 			<div>
	 			
	 			</div>
	 		</div>
	 		
	 		<div id="lastContent">
	 			<div>
	 			
	 			</div>
	 		</div>
	 	</div>
	</div>


</body>
</html>