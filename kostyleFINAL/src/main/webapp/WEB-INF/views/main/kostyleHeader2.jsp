<%@page import="kostyle.login.domain.CustomerVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
  <head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>KOStyle mall</title>
    
    <!-- Bootstrap -->
    <!-- <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css"> -->
    <link rel="stylesheet" href="/resources/css/main/bootstrap.min.css" media="screen" title="no title" charset="utf-8">
    
    <!-- Font Awesome -->
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">    
   
    <!-- Latest jQuery form server -->
    <script src="https://code.jquery.com/jquery.min.js"></script>
    
    <!-- Bootstrap JS form CDN -->
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
    
    <!-- jQuery sticky menu -->
    <script src="../../../resources/js/main/owl.carousel.min.js"></script>
    <script src="../../../resources/js/main/jquery.sticky.js"></script>
    
    <!-- Main Script -->
    <script src="../../../resources/js/main/main.js"></script>
       
    <!-- Custom CSS -->
    <link rel="stylesheet" type="text/css" href="../../../resources/css/main/responsive.css" />
    <link rel="stylesheet" type="text/css" href="../../../resources/css/main/kostyleHeader.css" />
 	<link rel="stylesheet" type="text/css" href="/resources/css/history/remocon.css">
 	<link rel="stylesheet" type="text/css" href="/resources/css/search/searchiFrame.css" />
<script type="text/javascript">
<%Object userVO = session.getAttribute("login"); %>
<%CustomerVO customerVO = null; %>
<%String c_num = null; %>
<%if(userVO instanceof CustomerVO){ 
	customerVO = (CustomerVO)userVO; 
	c_num = customerVO.getC_num();%>
	$(document).ready(function(){
		remoconList();
	});
<%}%>
 
	
	 $(document).ready(function(){ 
		var returnPath1 = jQuery(location).attr('pathname')+"";
		var returnPath2 = location.pathname+"";
		console.log("returnPath= "+returnPath1);
		
		
 		$('#cuslogout').on('click',function(){
 			$.post("../cuslogin/logout", { returnPath: "/${path}/logintest/testpage1" },function(result){
 				if(result == "SUCCESS"){
	 				console.log("logout ajax 성공");
 					location.href=returnPath1;
 					
 				}
 			});
			return false;
		});
 		
 		 $('body').on('click','button.wing_btn_delete',function(){
 			 
			 var h_num=$(this).val();
			 $.ajax({
				url : "/history/delete?h_num="+h_num,
				type : 'get',
				headers:{
					"Content-Type":"application/json",
					"X-HTTP-Method-Override":"GET"
				},
				dataType:'text',
				success : function(data){
					if(data=='delete'){
						$('.wing_fixed').remove();
						remoconList();
					}
				}					
			});
			return false;
		});
 		   /* 리모컨의 상품을 클릭하였을때 iFrame으로 상품의 링크를  띄움. */
 		   $('body').on('click','li.wing_prd a',function(event) {
 			var link = $(this).attr('href');
 			location.href = "#CategoryResult_top";
 			event.preventDefault();
 			if ($('#CategorysearchIframe').length > 0) {
 				$('#CategorysearchIframe').attr("src", link);
 			} else {
 				$('#CategoryResult_top').remove();
 				$('.remocon').prepend(' <div id="IframeRemocon">쇼핑몰 닫기</div> ');
 				$('.remocon').prepend('<iframe id="CategorysearchIframe" width="100%" height="900" src="'+link+ '">');
 				$('.remocon').prepend('<div id="#CategoryResult_top"></div>');
 			}
 			$('#IframeRemocon').click(function() {
 				$('#CategorysearchIframe').remove();
 				$('#IframeRemocon').remove();
 			});
 		});
 		 
	});
		/* 사용자의 히스토리내역을 리모컨에 띄우는 함수 */
 		function remoconList(){
 			$.ajax({
 				url: '/remocon/list/'+${login.c_num},
	 			type: 'post',
				headers:{
					"Content-Type":"application/json",
					"X-HTTP-Method-Override":"POST"
				},
				dataType:'text',
				success : function(data) {
					
					$('.remocon').after(data);
				}
 			});
 		}
</script>


   
  </head>
  <body>

		<div class="header-area">
        <div class="container">
            <div class="row">
                <c:choose>
				<c:when test="${empty sessionScope.login}">
				<div class="row">
					<div class="col-md-8">
    					<div class="user">
       				 </div>
   				 </div>
    				<div class="col-md-4">
    					<div class="header-right">
         					<ul class="list-unstyled list-inline">
                				<li><a href="../join/join"><i class="fa fa-list-ul"></i> 회원가입 </a></li>
                				<!-- <li><a href="../mypage/login/"><i class="fa fa-id-badge"></i> My Page </a></li> -->
                				<li><a href="../cuslogin/login"><i class="fa fa-user-o"></i> Login </a></li>
            				</ul>
        				</div>
    				</div>
				</div>
				</c:when>

				<c:when test="${not empty sessionScope.login}">
				<div class="row">
					<div class="col-md-8">
    					<div class="user">
        					<h5><i class="fa fa-heart" style=""></i> ${login.c_name}님 환영합니다. <i class="fa fa-heart"></i></h5>
        				</div>
    				</div>
    				<div class="col-md-4">
    					<div class="header-right">
         					<ul class="list-unstyled list-inline">
            					<li><a href="../mypage/MypageMain/"><i class="fa fa-id-badge"></i> My Page</a></li>
                 				<li><a id="cuslogout" href="../cuslogin/logout/"+${currentPath }><i class="fa fa-user"></i> Logout</a></li>
            				</ul>
        				</div>
    					</div>
				</div>
				</c:when>
				</c:choose>
            </div>
		</div>
		</div> <!-- End header area -->
   
   
    
    
    <div class="site-branding-area">
        <div class="container">
            <div class="search-row">
            
            <a href="/"><img class="logoimg" src="../../../resources/images/mainImg/kostyle.png"></a>
            
            <div class="header_search">
				<form class="search-form" action="/search/do" method="post">
					<div class="search-box">
						<dl class="clear">
						<dt class="search1"><input id="search-text" type="text" name="search"></dt>
						<dd class="search2"><input id="search-icon" type="image" src="../../../resources/images/mainImg/kostylesearch.png" alt="검색" title="검색"></dd>
						</dl>
					</div>
				</form>
            </div>
            
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
                        <li><a href="#">RANKING</a></li>
                        
                        <li class="dropdown">
                        <a class="dropdown-toggle" data-toggle="dropdown" href="#">DISCOUNT RANKING</a>
                        <ul class="dropdown-menu">
            				<li><a href="#">기획할인</a></li>
            				<li><a href="#">신상품할인</a></li>
          				</ul>
                        </li>
                        
                        <li><a href="../favorite/favoriteList">FAVORITE</a></li>
                        <li><a href="#">ZZIM</a></li>
                        <li><a href="/help/list">SERVICE CENTER</a></li>
                    </ul>
                </div>  
            </div>
        </div>
    </div> <!-- End mainmenu area -->

	<div class="remocon"></div>

  </body>
</html>
<%--  <%@ include file="../history/remocon.jsp" %>  --%>