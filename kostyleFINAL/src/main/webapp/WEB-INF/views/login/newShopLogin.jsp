<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ include file="../main/kostyleHeader.jsp" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
    <meta charset="utf-8">

    <title></title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="http:////maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <link rel="stylesheet" type="text/css" href="/resources/css/login/newCusLogin.css" />

    <style type="text/css">
    .btn-lg, .btn-group-lg>.btn {
    padding: 10px 16px;
    font-size: 18px;
    line-height: 1.33;
    border-radius: 6px;
}
.colorgraph {
  height: 5px;
  border-top: 0;
  background: #FF9600;
    margin: 40px 0;
}

.login h2{
    font-weight:bold;
display: inline;
    color: #FF9600;
    font-size: 30px;
    margin-top: 20px;
    margin-bottom: 10px;
    font-family: inherit;
    line-height: 1.1;
    box-sizing: border-box;
        -webkit-margin-before: 0.83em;
    -webkit-margin-after: 0.83em;
    -webkit-margin-start: 0px;
    -webkit-margin-end: 0px;
    
}
    </style>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
    <script src="../../../resources/jquery/jquery-3.2.1.js"></script></script>
	<script type="text/javascript"  src="/../../resources/js/login/newCusLogin.js"></script>
    <script type="text/javascript">
        window.alert = function(){};
        var defaultCSS = document.getElementById('bootstrap-css');
        function changeCSS(css){
            if(css) $('head > link').filter(':first').replaceWith('<link rel="stylesheet" href="'+ css +'" type="text/css" />'); 
            else $('head > link').filter(':first').replaceWith(defaultCSS); 
        }

    </script>
</head>

<body>

<section id="fullContainer">
	<section id="rightContainer"></section>
	
	<section id="leftContainer">
		
	
<div class="container login">

<div class="row" style="margin-top:20px">
    <div class="col-xs-12 col-sm-8 col-md-6 col-sm-offset-2 col-md-offset-3">
		<!-- <fieldset> -->
		<div class="uldiv">	
				<ul id="top-bar" class="nav  nav-justified col-xs-6 col-sm-6 col-md-6">
							<li class="col-xs-6 col-sm-6 col-md-6"><a href="/cuslogin/login">개인 회원</a></li>
							<li class="active col-xs-6 col-sm-6 col-md-6"><a href="#">쇼핑몰 회원</a></li>
				</ul>
		</div>
    	<div class="boxdiv col-xs-12 col-sm-12 col-md-12">
    	<form id="loginForm" action="/shoplogin/loginCheck" method="post">
			<fieldset>
				<div class="logindiv">
				<img class="logoimg" src="../../../resources/images/mainImg/kostyle.png"><h2>로그인</h2>
				</div>
				<hr class="colorgraph">
			<div class="textboxdiv">	
				<div class="form-group">
                    <input type="text" name="adshop_id" id="email"  value="${adshop_id.cus_id }" class="form-control input-lg" placeholder="SHOP ID">
				</div>
				<div class="form-group">
                    <input type="password" name="user_pass" id="password" class="form-control input-lg" placeholder="Password">
				</div>
			</div>
				
					<span class="button-checkbox">
					<button type="button" class="btn"  data-color="warning"> 자동 로그인</button>
                    <input type="checkbox" name="useCookie" id="remember_me" checked="checked" class="hidden">
					<a href="" id="forgotPass" class="btn btn-link pull-right">아직 회원이 아니신가요?</a>
				</span>
				<hr class="colorgraph">
				<div class="row" id="doingButton">
					<div class="col-xs-12 col-sm-12 col-md-12">
						<button type="submit" class="btn btn-lg btn-default btn-block" >로그인</button>
					</div>
				</div>
		</form>
		<div class="findbtn">
					<span class="findbtn col-xs-6 col-sm-6 col-md-6">
						<a href="/findshop/idshop"><div class="btn btn-lg btn-default btn-block" >아이디 찾기 <i class="fa fa-info-circle"></i></div></a>
					</span>
					<span class="findbtn col-xs-6 col-sm-6 col-md-6">
						<a href="/findshop/passwordshop"><div class="btn btn-lg btn-default btn-block" >비밀번호 찾기 <i class="fa fa-lock"></i></div></a>
					</span>
			</div>
			</fieldset>
		</div>
	<!-- 	</fieldset> -->
	</div>
</div>
	<br><br><br><br>
	</section>


</section>


</body>
</html>