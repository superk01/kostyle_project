<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ include file="main/kostyleHeader.jsp" %>
<script type="text/javascript" src="/resources/js/main/main.js"></script>


<html>
<head>
<script src="../../../resources/jquery/jquery-3.2.1.js"></script>
<!-- <script type="text/javascript">
    $(document).ready(function(){ 
      var returnPath1 = jQuery(location).attr('pathname')+"";
      var returnPath2 = location.pathname+"";
      console.log("returnPath= "+returnPath1);
      
      
       $('#cuslogout a').on('click',function(){
//          $.post("/cuslogin/logout", { returnPath: returnPath1+"" });
          $.post("/cuslogin/logout", { returnPath: "${path}/logintest/testpage1" },function(result){
             if(result == "SUCCESS"){
                console.log("logout ajax 성공");
                location.href=returnPath1;
                
             }
          });
//         location.href = $(this).attr("href");
         //location.href = "/cuslogin/logout/"+returnPath1;
         return false;
      });
      
      $('#shoplogout ').on('click', function(){
//         location.href = $(this).attr("href");
         //location.href = "/shoplogin/logout/"+currentPath1;
        // console.log("shoplogout event+ path: "+"/shoplogin/logout/"+currentPath1);
         return false;
      }); 
      
   });
</script> -->

<style type="text/css">
#weather{
	text-align: center;
	vertical-align: middle;
}
#today{
	text-align: center;
	vertical-align: middle;
}

.main button{
	background: white;
	color: black;
	border: 3px solid black;
	border-radius;
	font-size: 30px;
	position: absolute;
	top: 320px;
	right: 200px;
}	

.col-sm-6{
	padding-left: 0px;
	padding-right: 0px;
}

button:focus {
  outline: none;
  font-size: 32px;
}

.img-responsive, .thumbnail>img, .thumbnail a>img, .carousel-inner>.item>img, .carousel-inner>.item>a>img{
	height: 400px;
	width: 100%;
}

.mainImg{
	width: 100% !important;
}


#iframeRemove{
 	width : 2%;
 	height : 135px;
 	position: fixed;
 	overflow: hidden;
 	background: #3C3C3C;
 	bottom: 30%;
 	z-index: 10000;
 	font-size : 17px;
 	color: white;
 	font-weight : bold;
 	padding: 7px;
 }
 
 
.body {
	margin: 0 5%;
	font-family: 맑은 고딕;
}



</style>


   <title>여성 통합 쇼핑몰 KOSTYLE</title>
</head>

<div class="body">

<div id="favoritebackground">
<div id="favoriteBodyTop"></div>

<div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
  <!-- Indicators -->
  <ol class="carousel-indicators">
    <li data-target="#carousel-example-generic" data-slide-to="0" class="active" data-interver="1000"></li>
    <li data-target="#carousel-example-generic" data-slide-to="1"></li>
    <li data-target="#carousel-example-generic" data-slide-to="2"></li>
    <li data-target="#carousel-example-generic" data-slide-to="3"></li>
    <li data-target="#carousel-example-generic" data-slide-to="4"></li>
    <li data-target="#carousel-example-generic" data-slide-to="5"></li>
    <li data-target="#carousel-example-generic" data-slide-to="6"></li>
  </ol>

  <!-- Wrapper for slides -->
  <div class="carousel-inner" role="listbox">
  
    <div class="item active">
      <a class="shopLink" href="http://66girls.co.kr/"><img class="imgAd" src="/resources/images/mainImg/shop_66.jpg" alt="..."></a>
      <div class="carousel-caption">
      </div>
    </div>
    
    <div class="item">
      <a class="shopLink" href="http://www.dejou.co.kr/"><img class="imgAd" src="/resources/images/mainImg/shop_deju.png" alt="..."></a>
      <div class="carousel-caption">
      </div>
    </div>
    
    <div class="item">
      <a class="shopLink" href="htt=://ggsing.com"><img class="imgAd" src="/resources/images/mainImg/shop_go.jpg" alt="..."></a>
      <div class="carousel-caption">
      </div>
    </div>
    
    <div class="item">
      <a class="shopLink" href="http://hotping.co.kr/"><img class="imgAd" src="/resources/images/mainImg/shop_hot.jpg" alt="..."></a>
      <div class="carousel-caption">
      </div>
    </div>
    
    <div class="item">
      <a class="shopLink" href="http://imvely.com/"><img class="imgAd" src="/resources/images/mainImg/shop_im.PNG" alt="..."></a>
      <div class="carousel-caption">
      </div>
    </div>
    
    <div class="item">
      <a class="shopLink" href="http://loveloveme.com/"><img class="imgAd" src="/resources/images/mainImg/shop_luv.jpg" alt="..."></a>
      <div class="carousel-caption">
      </div>
    </div>
    
    <div class="item">
      <a class="shopLink" href="http://www.stylenanda.com/"><img class="imgAd" src="/resources/images/mainImg/shop_style.jpg" alt="..."></a>
      <div class="carousel-caption">
      </div>
    </div>
    
  </div>

  <!-- Controls -->
  <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
    <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
    <span class="sr-only">Previous</span>
  </a>
  <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
    <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
    <span class="sr-only">Next</span>
  </a>
</div>

<br><br>

<div class="main">
<div class="col-sm-6" id="weather"><img class="mainImg" alt="" src="/resources/images/mainImg/main3.jpg"><a href=""><button><i class="fa fa-cloud"></i> 날씨별 옷 추천</button></a></div>
<div class="col-sm-6" id="today"><img class="mainImg" alt="" src="/resources/images/mainImg/main4.jpg"><a href="/coordinator/list"><button><i class="fa fa-shopping-bag"></i> 오늘의 코디</button></a></div>
</div>

<div class="form-group">
  <div class="col-sm-12" style="height:50px;">
</div>

</div>

</div>

<body>

</html>