<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
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
    <script src="../../../resources/js/main/owl.carousel.min.js"></script>
    <script src="../../../resources/js/main/jquery.sticky.js"></script>
    
    <!-- Main Script -->
    <script src="../../../resources/js/main/main.js"></script>
    
    <!-- Custom CSS -->
    <link rel="stylesheet" type="text/css" href="../../../resources/css/main/owl.carousel.css" />
    <link rel="stylesheet" type="text/css" href="../../../resources/css/main/responsive.css" />
    <link rel="stylesheet" type="text/css" href="../../../resources/css/main/style.css" />

   
  </head>
  <body>

		<div class="header-area">
        <div class="container">
            <div class="row">
                <div class="col-md-8">
                    <div class="user">
                            <h5><i class="fa fa-heart"></i> ${sessionScope.login.c_name} 님 환영합니다.<i class="fa fa-heart"></i></h5>
                    </div>
                </div>
                
                <div class="col-md-4">
                    <div class="header-right">
                        <ul class="list-unstyled list-inline">
                            <li><a href="#"><i class="fa fa-user"></i> My Page</a></li>
                            <li><a href="../join/join"><i class="fa fa-pencil"></i> 회원가입</a></li>
                            <li><a href="../cuslogin/login"><i class="fa fa-user"></i> Login</a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div> <!-- End header area -->
   
   
    
    
    <div class="site-branding-area">
        <div class="container">
            <div class="row">
            <a href="/"><img class="logoimg" src="../../../resources/images/mainImg/kostyle.png"></a>
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
                        <li><a href="#">DISCOUNT RANKING</a></li>
                        <li><a href="../favorite/favoriteList">FAVORITE</a></li>
                        <li><a href="#">ZZIM</a></li>
                        <li><a href="#">SERVICE CENTER</a></li>
                    </ul>
                </div>  
            </div>
        </div>
    </div> <!-- End mainmenu area -->


  </body>
</html>