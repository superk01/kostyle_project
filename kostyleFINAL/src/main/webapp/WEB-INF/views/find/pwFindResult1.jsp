<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>KOStylemall 비밀번호 찾기</title>
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<!-- Bootstrap -->
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
<!-- font awesome -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">    
<!-- Custom style -->
<link rel="stylesheet" href="../../../resources/css/find/id_p.css"	media="screen" title="no title" charset="utf-8">

<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script src="http://code.jquery.com/jquery-3.2.1.min.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

</head>
<body>


<article class="container">

	<div class="col-md-12">

		<div class="page-header">
			<h1><i class="fa fa-info-circle"></i> 회원 비밀번호 찾기 <small>KOStyle</small></h1>
		</div>
		
		<div id="memberJoin">
			
					<h3> 회원님의 비밀번호를 </h3>
					<h3>${find.c_email}로</h3>
					<h3> 전송했습니다. </h3>
					
					<br><br>
					<div class="form-group">
					<div class="col-sm-12 text-center">
					<button id="btn-cancle" class="btn btn-default btn-lg"  onclick="location.href='/'">
						코스타일몰 홈 <i class="glyphicon glyphicon-home"></i>
					</button>
					<br><br>
					</div>
					</div>

			<br><br>
			
			
		</div>	
	</div>
	</article>

	
</body>
</html>