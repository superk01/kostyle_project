<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String statsbody = request.getParameter("statsbody");
	if(statsbody==null){
		statsbody = "statsMain.jsp";
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<style type="text/css">
	body{
		position: relative ;
		width: 100%;
		height : auto;
		float: none;
		margin:0px;
	}
</style>
<title>Insert title here</title>

<link rel="stylesheet" type="text/css" href="../resources/css/stats/stats.css">
<script type="text/javascript"></script>
<script src="../../../resources/js/jquery.js" type="text/javascript"></script>
<script src="../../../resources/js/stats/statsmain.js" type="text/javascript"></script>






    
</head>
<body>
<div id="statsMain">

<!--  ---------------------------------side bar-------------------------------------- -->
	<div id="statsMenuBar" class="">
	<nav class="c-primary-nav" data-reactid="13">
		<div id="statsMenu">
		<div class="barMenuDiv">
			<a class="barMenuA">
				<img alt="" src="../resources/image/stats/bar_dashboard.png" class="barMenuImg" height="24" width="24">
				<span class="barMenuText hidden">Dash Board</span>
			</a>
		</div>
		
		<div class="barMenuDiv">
			<a class="barMenuA" href="statsindex?statsbody=statsVisitor.jsp">
				<img alt="" src="../resources/image/stats/bar_chart.png" class="barMenuImg" height="24" width="24">
				<span class="barMenuText hidden">방문자</span>
			</a>
			<div class="barMenuSubDiv hidden">
				<a class="barMenuSubA">
					<span class="barMenuSubText">방문자수 분석</span>
				</a>
				<a class="barMenuSubA">
					<span class="barMenuSubText">유입경로 분석</span>
				</a>
			</div>
		</div>
		
		<div class="barMenuDiv">
			<a class="barMenuA">
				<img alt="" src="../resources/image/stats/bar_shop.png" class="barMenuImg" height="24" width="24">
				<span class="barMenuText hidden">쇼핑몰</span>
			</a>
			<div class="barMenuSubDiv hidden">
				<a class="barMenuSubA">
					<span class="barMenuSubText">전체 쇼핑몰 분석</span>
				</a>
			</div>
		</div>
		
		<div class="barMenuDiv">
			<a class="barMenuA">
				<img alt="" src="../resources/image/stats/bar_cloth.png" class="barMenuImg" height="24" width="24">
				<span class="barMenuText hidden">상품</span>
			</a>	
			<div class="barMenuSubDiv hidden">
				<a class="barMenuSubA">
					<span class="barMenuSubText">전체 상품 분석</span>
				</a>
				<a class="barMenuSubA">
					<span class="barMenuSubText">카테고리 분석</span>
				</a>
				<a class="barMenuSubA">
					<span class="barMenuSubText">검색어 분석</span>
				</a>
				<a class="barMenuSubA">
					<span class="barMenuSubText">찜하기 분석</span>
				</a>
			</div>
		</div>
		
		<div class="barMenuDiv">
			<a class="barMenuA">
				<img alt="" src="../resources/image/stats/bar_user.png" class="barMenuImg" height="24" width="24">
				<span class="barMenuText hidden">회원</span>
			</a>	
			<div class="barMenuSubDiv hidden">
				<a class="barMenuSubA">
					<span class="barMenuSubText">신규 회원 분석</span>
				</a>
				<a class="barMenuSubA">
					<span class="barMenuSubText">전체 회원 분석</span>
				</a>	
				<a class="barMenuSubA">
					<span class="barMenuSubText">상세 회원 분석</span>
				</a>
			</div>
		</div>
		
		</div>
		<div id="statsMenuSlider">
			<img alt="" src="../resources/image/stats/bar_right.png" id="barOpenIcon" class="barMenuImg" height="24" width="24" >
			<img alt="" src="../resources/image/stats/bar_left.png" id="barCloseIcon" class="barMenuImg hidden" height="24" width="24" >
		</div>
		</nav>
	</div>
<!--  ---------------------------------side bar-------------------------------------- -->
	
	
<!--  ---------------------------------stats main-------------------------------------- -->
	<div id="statsbody">
	
	<jsp:include page="<%= statsbody %>"/>
	 
	</div>
<!--  ---------------------------------stats main-------------------------------------- -->
		
</div>

</body>
</html>