<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>eElectronics - HTML eCommerce Template</title>
    
    <!-- Google Fonts -->
    <link href='http://fonts.googleapis.com/css?family=Titillium+Web:400,200,300,700,600' rel='stylesheet' type='text/css'>
    <link href='http://fonts.googleapis.com/css?family=Roboto+Condensed:400,700,300' rel='stylesheet' type='text/css'>
    <link href='http://fonts.googleapis.com/css?family=Raleway:400,100' rel='stylesheet' type='text/css'>
    
    <!-- Bootstrap -->
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
    
    <!-- Font Awesome -->
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
    
    <!-- Latest jQuery form server -->
    <script src="https://code.jquery.com/jquery.min.js"></script>
    
    <!-- Bootstrap JS form CDN -->
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
    
    <!-- jQuery sticky menu -->
    <script src="../resources/js/main/owl.carousel.min.js"></script>
    <script src="../resources/js/main/jquery.sticky.js"></script>
    
    <!-- jQuery easing -->
    <script src="../resources/js/main/jquery.easing.1.3.min.js"></script>
    
    <!-- Main Script -->
    <script src="../resources/js/main/main.js"></script>
    
    <!-- Custom CSS -->
    <link rel="stylesheet" type="text/css" href="../resources/css/main/owl.carousel.css" />
    <link rel="stylesheet" type="text/css" href="../resources/css/main/responsive.css" />
    <link rel="stylesheet" type="text/css" href="../resources/css/main/style.css" />

<script src="../../../resources/jquery/jquery-3.2.1.js"></script>
<script type="text/javascript">
	 $(document).ready(function(){ 
		var returnPath1 = jQuery(location).attr('pathname')+"";
		var returnPath2 = location.pathname+"";
		console.log("returnPath= "+returnPath1);
		
		
 		$('#cuslogout a').on('click',function(){
// 			$.post("/cuslogin/logout", { returnPath: returnPath1+"" });
 			$.post("/cuslogin/logout", { returnPath: "${path}/logintest/testpage1" },function(result){
 				if(result == "SUCCESS"){
	 				console.log("logout ajax 성공");
 					location.href=returnPath1;
 					
 				}
 			});
//			location.href = $(this).attr("href");
			//location.href = "/cuslogin/logout/"+returnPath1;
			return false;
		});
		
		$('#shoplogout ').on('click', function(){
//			location.href = $(this).attr("href");
			//location.href = "/shoplogin/logout/"+currentPath1;
			console.log("shoplogout event+ path: "+"/shoplogin/logout/"+currentPath1);
			return false;
		}); 
		
	});
</script>
	<title>Home</title>
</head>

<header>
<div class="header-area">
        <div class="container">
            <div class="row">
                <div class="col-md-8">
                    <div class="user-menu">
                            <h5><i class="fa fa-heart"></i> ${login.getC_name() }님 환영합니다.<i class="fa fa-heart"></i></h5>
                    </div>
                </div>
                
                <div class="col-md-4">
                    <div class="header-right">
                        <ul class="list-unstyled list-inline">
                            <li><a href="#"><i class="fa fa-user"></i> My Page</a></li>
                            <li><a href="../join/join"><i class="fa fa-pencil"></i> 회원가입</a></li>
                            <li><a href="#"><i class="fa fa-user"></i> Login</a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div> <!-- End header area -->
    
    <div class="site-branding-area">
        <div class="container">
            <div class="row">
                        <a href="header"><img class="logoimg" src="../resources/images/mainImg/kostyle.png"></a>
            </div>
        </div>
    </div> <!-- End site branding area -->
    
    <div class="mainmenu-area">
        <div class="container">
            <div class="row">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                </div> 
                <div class="navbar-collapse collapse">
                    <ul class="nav navbar-nav">
                        <li class="active"><a href="index.html">Home</a></li>
                        <li><a href="shop.html">Shop page</a></li>
                        <li><a href="single-product.html">Single product</a></li>
                        <li><a href="cart.html">Cart</a></li>
                        <li><a href="checkout.html">Checkout</a></li>
                        <li><a href="#">Category</a></li>
                        <li><a href="#">Others</a></li>
                        <li><a href="#">Contact</a></li>
                    </ul>
                </div>  
            </div>
        </div>
    </div> <!-- End mainmenu area -->
</header>



<body>
<h1>
	Hello world!  
</h1>
<c:set var="currentPath" value="${requestScope.currentPath }"></c:set>
<c:set var="loginSession" value="${sessionScope.login }"></c:set>
<c:set var="shoploginSession" value="${sessionScope.shoplogin }"></c:set>

<c:if test="${empty sessionScope.login && empty sessionScope.shoplogin}">
	<a href="/cuslogin/login">고객로그인</a>
	<a href="/shoplogin/login">쇼핑몰로그인</a>
	<a href="/find/id">아이디 찾기</a>
	<a href="/find/password">비밀번호 찾기</a>
</c:if>

<c:choose>
	<c:when test="${not empty login}">
		<p>고객세션있음</p>
		<!-- <div id="cuslogout">고객로그아웃</div> -->
 		<div id="cuslogout"><a href="/cuslogin/logout/"+${currentPath }>고객로그아웃</a></div> 
	</c:when>
	<c:when test="${not empty shoplogin}">
		<p>쇼핑몰세션있음</p>
		<div id="shoplogout">쇼핑몰로그아웃</div>
 		<div id="shoplogout"><a href="/shoplogin/logout/"+${currentPath }>쇼핑몰로그아웃</a></div> 
		
	</c:when>
<%-- 	<c:when test="${not empty sessionScope.login}">
		<p>고객세션있음</p>
		<div id="cuslogout"><a href="/cuslogin/logout/${currentPath }">고객로그아웃</a></div>
	</c:when>
	<c:when test="${not empty sessionScope.shoplogin}">
		<p>쇼핑몰세션있음</p>
		<div id="shoplogout"><a href="/shoplogin/logout/${currentPath }">쇼핑몰로그아웃</a></div>
		
	</c:when> --%>

</c:choose>
<div>
<div>${login.getC_name() }님 환영합니다.</div>
	고객세션: ${login.c_name }
	<br>
	고객세션: ${sessionScope.login.c_name }
	<br>
	고객세션: ${loginSession.c_name }
	<br>
	쇼핑몰세션: ${sessionScope.shoplogin }
</div>

<br><br><a href="/admin/shopList">shoppingMall List</a>
<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
<P>  The time on the server is ${serverTime}. </P>
<P>  "${path }" </P>
	<div class="search_field">
	<form action="${path }/search/do" method="get">
		<div class="search_box">
			<dl class="clear_float">
				<dt><input type="text" name="search"></dt>
				<dd><input type="image" src="../resources/images/mainImg/mainsearch.png" alt="검색" title="검색"></dd>
			</dl>
		</div>
	</form>
	</div>
</body>
</html>