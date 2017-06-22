<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>KOStylemall 아이디 찾기</title>
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<!-- Bootstrap -->
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
<!-- font awesome -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">    
<!-- Custom style -->
<link rel="stylesheet" href="../../../resources/css/find/id_s.css"	media="screen" title="no title" charset="utf-8">

<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script src="http://code.jquery.com/jquery-3.2.1.min.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

<style type="text/css">

#findID{
	color: red;
}

</style>


</head>
<body>


<article class="container">

	<div class="col-md-12">

		<div class="page-header">
			<h1><i class="fa fa-info-circle"></i> 쇼핑몰 아이디 찾기 <small>KOStyle</small></h1>
		</div>
		
		<div id="memberJoin">
			
			<c:choose>
				<c:when test="${not empty findshop.ad_id}">
					<h3> 쇼핑몰의 아이디는 </h3>
					<h3 id="findID">${findshop.ad_id}</h3>
					<h3> 입니다. </h3>
					
					<div class="form-group">
					<div class="col-sm-12 text-center">
					<button id="btn-cancle" class="btn btn-default btn-lg"  onclick="location.href='/'">
						코스타일몰 홈 <i class="glyphicon glyphicon-home"></i>
					</button>
					<br><br>
					</div>
					</div>
				</c:when>



				<c:when test="${empty find.c_id}">
					<h3> 입력한 정보와 일치하는 id를 찾지 못하였습니다. </h3>
					
					<br><br>
					<div class="form-group">
					<div class="col-sm-12 text-center">
					<button id="btn-join" class="btn btn-default btn-lg" onclick="location.href='/findshop/idshop'">
						쇼핑몰 아이디찾기 <i class="fa fa-info-circle"></i>
					</button>
					<button id="btn-cancle" class="btn btn-default btn-lg" onclick="location.href='/'">
						코스타일몰 홈 <i class="glyphicon glyphicon-home"></i>
					</button>
					</div>
					</div>
				</c:when>
				</c:choose>
			
			
			
			<br><br>
			
			
		</div>	
	</div>
	</article>

	
</body>
</html>