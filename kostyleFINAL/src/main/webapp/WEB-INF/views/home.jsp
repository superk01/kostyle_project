<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ include file="main/kostyleHeader.jsp" %>

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
	width: 50%;
	text-align: center;
	vertical-align: middle;
}
#today{
	width: 50%;
	text-align: center;
	vertical-align: middle;
}

.main button{
	background: black;
	color: white;
	border: none;
	font-size: 30px;
	position: absolute;
	top: 350px;
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


</style>


   <title>여성 통합 쇼핑몰 KOSTYLE</title>
</head>

<div class="main">
<div class="col-sm-6" id="weather"><img alt="" src="/resources/images/mainImg/main1.jpg"><button><i class="fa fa-cloud"></i> 날씨별 옷 추천</button></div>
<div class="col-sm-6" id="today"><img alt="" src="/resources/images/mainImg/main2.jpg"><button><i class="fa fa-shopping-bag"></i> 오늘의 코디</button></div>
</div>

<body>

</html>