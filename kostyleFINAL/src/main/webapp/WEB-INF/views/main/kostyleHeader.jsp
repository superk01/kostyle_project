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
    <title>KOStyle</title>
   <!-- Bootstrap -->
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
    <!-- <link rel="stylesheet" href="/resources/css/main/bootstrap.min.css" media="screen" title="no title" charset="utf-8"> -->
    
    <!-- Font Awesome -->
   <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">    
   
    <!-- Latest jQuery form server -->
    <script src="http://code.jquery.com/jquery-3.2.1.min.js"></script>
    
    <!-- Bootstrap JS form CDN -->
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
    
    <!-- Custom CSS -->
    <link rel="stylesheet" type="text/css" href="/resources/css/main/kostyleHeader.css" />
    <link rel="stylesheet" type="text/css" href="/resources/css/history/remocon.css">
    <link rel="stylesheet" type="text/css" href="/resources/css/search/searchiFrame.css" />
    
    
<style type="text/css">
 
.table>thead>tr>th {
   vertical-align: bottom;
   border-bottom: 5px solid gray !important;
}


.dropdown-menu>li>a {
   display: block;
   padding: 12px 20px !important;
   clear: both;
   font-weight: 400;
   line-height: 1.42857143;
   color: #333;
   white-space: nowrap;
   font-size: 17px !important;
}


.navbar {
   position: relative;
   min-height: 50px;
   margin-bottom: 20px;
   border: 1px solid transparent;
}


@media ( min-width :768px) {
   .navbar {
   border-radius: 0px !important; 
   }
}

   
.navbar-default {
   background-color: #ad82ab !important;
   border-color: #ad82ab !important;
}

.navbar-default .navbar-brand {
   color: white !important;
}

.navbar-default .navbar-brand:hover, .navbar-default .navbar-brand:focus
   {
   color:  !important;
   background-color:  black !important;
}

.navbar-default .navbar-text {
   color: white !important;
}

.navbar-default .navbar-nav>li>a {
   color: white !important;
   font-family: sans-serif !important;
   font-size: 25px !important;
   font-weight: bold !important;
   padding: 20px 65px !important;
}

.navbar-default .navbar-nav>li>a:hover, .navbar-default .navbar-nav>li>a:focus
   {
   color: black !important;
   background-color: white !important;
}


.navbar-default .navbar-nav>.open>a, .navbar-default .navbar-nav>.open>a:hover,
   .navbar-default .navbar-nav>.open>a:focus {
   color: black !important;
   background: white !important;
}

@media ( max-width :767px) {
   .navbar-default .navbar-nav .open .dropdown-menu>li>a {
      font-family: 맑은 고딕 !important;
      font-size: 20px !important;
      padding: 10px 50px !important;
      font-weight: bold !important;
      color: white !important;
      padding-left: 70px !important;
   }
   .navbar-default .navbar-nav .open .dropdown-menu>li>a:hover,
      .navbar-default .navbar-nav .open .dropdown-menu>li>a:focus {
      color: black !important;
      background-color: white !important;
      padding-left: 70px !important;
   }
}

.pagination>li>a:hover, .pagination>li>span:hover, .pagination>li>a:focus,
   .pagination>li>span:focus {
   color: gray !important;
   background-color: #eee;
   border-color: #ddd
}

.pagination>.active>a, .pagination>.active>span, .pagination>.active>a:hover,
   .pagination>.active>span:hover, .pagination>.active>a:focus,
   .pagination>.active>span:focus {
   z-index: 2;
   color: #fff;
   cursor: default;
   background-color: gray !important;
   border-color: gray !important;
}

.navbar-nav>li>.dropdown-menu{
   width: 100% !important; 
}

.navbar-default .navbar-toggle{
   border-color: white !important;
}

.navbar-default .navbar-toggle .icon-bar{
   background-color: white !important;
}



</style>

<style>
      .jbFixed {
        position: fixed;
        top: 0px;
        width: 100%;
      }
</style>
    
    <script>
      $( document ).ready( function() {
        var jbOffset = $( '.navSticky' ).offset();
        $( window ).scroll( function() {
          if ( $( document ).scrollTop() > jbOffset.top ) {
            $( '.navSticky' ).addClass( 'jbFixed' );
          }
          else {
            $( '.navSticky' ).removeClass( 'jbFixed' );
          }
        });
      } );
    </script>
    
    
<script type="text/javascript">

 
   //로그아웃시 고객은 고객으로, 쇼핑몰은 쇼핑몰로.
    $(document).ready(function(){
      var returnPath1 = jQuery(location).attr('href')+"";
      var returnPath2 = location.pathname+"";
      console.log("returnPath= "+returnPath1);
      $('#shoplogout').on('click',function(){
          console.log("#shoplogout Event");
          $.post("../shoplogin/logout", { returnPath: "/${path}/logintest/testpage1" },function(result){
             if(result == "SUCCESS"){
                console.log("logout ajax 성공");
                location.href=returnPath1;
             }
          });
         return false;
      });
   }); 
    $(document).ready(function(){
      var returnPath1 = jQuery(location).attr('href')+"";
      var returnPath2 = location.pathname+"";
      console.log("returnPath= "+returnPath1);
      
      $('#cuslogout').on('click',function(){
  		$.ajax({

  			type: "post",
  			url:"/cuslogin/logout",
  			data : { "returnPath": "/${path}/logintest/testpage1" },
  			success: function (data){
  			//	alert("ajax결과: "+data);
  				//console.log("ajax결과: "+data);
  				if(returnPath2=="/favorite/favoriteList"){
  					location.href="/";
  				}else{
	    				location.href=returnPath1;
  				}
  			}  ,

  		}); 
/*           $.post("../cuslogin/logout", { returnPath: "/${path}/logintest/testpage1" },function(result){
           if(result == "SUCCESS"){
              console.log("logout ajax 성공");
              location.href=returnPath1;
              
           }
        }); */
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

         if(${login.c_num!=""}){
            
          $.ajax({
             url: '/remocon/list/${login.c_num}',
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
         }//if()

      } //remoconList()
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
</script>



<body>

<c:choose>

<c:when test="${sessionScope.shoplogin.p_powernum==1 }"><!-- 쇼핑몰고객 -->
<div class="header-area">
        <div class="container">
            
            <div class="row">
               <div class="col-md-8">
                   <div class="user">
                   <h5><i class="fa fa-heart" style=""></i> ${shoplogin.s_sname}님 환영합니다. <i class="fa fa-heart"></i></h5>
                    </div>
                </div>
                <div class="col-md-4">
                   <div class="header-right">
                        <ul class="list-unstyled list-inline">
                             <li><a id="shoplogout" ><i class="fa fa-user"></i> Logout</a></li>
                        </ul>
                    </div>
                   </div>
            </div>
      </div>
</div> <!-- End header area -->


<div class="site-branding-area" id="search-fixed-top">
        <div class="container">
            <div class="search-row">
            
            <a href="/"><img class="logoimg" src="/resources/images/mainImg/kostyle2.png"></a>
            
            <div class="header_search">
            <form class="search-form" action="#" method="get" name="searchForm">
               <div class="search-box">
                  <dl class="clear">
                  <dt class="search1"><input id="search-text" type="text" name="search" style="border:5px solid #EC971F;"></dt>
                  <dd class="search2"><input id="search-icon" type="image" src="/resources/images/mainImg/kostylesearch2.png" alt="검색" title="검색" onclick="sendtwo()" style="border:5px solid #EC971F;"></dd>
                  </dl>
               </div>
            </form>
            </div>
            
            </div>
        </div>
</div> <!-- End site branding area -->


<div class="navSticky">
<nav class="navbar navbar-default" style="background-color: #EC971F !important; border-color:  #EC971F !important;">
  <div class="container-fluid">
     <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span> 
      </button>
    </div>
  
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
      <li><a href="#" style="padding:20px 100px !important">R A N K I N G</a></li>
      
        <li class="dropdown">
          <a class="dropdown-toggle" data-toggle="dropdown" href="#" style="padding:20px 100px !important">D I S C O U N T</a>
          <ul class="dropdown-menu">
            <li><a href="#">기획할인</a></li>
            <li><a href="#">신상품할인</a></li>
          </ul>
        </li>
        
        <li><a href="/help/list" style="padding:20px 100px !important">S E R V I C E  C E N T E R</a></li>
      </ul>
    </div>
  </div>
</nav> 
</div>
</c:when>




<c:when test="${sessionScope.login.p_powernum==2 || sessionScope.login==null}"><!-- 일반고객 -->


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
                            <li><a href="/cuslogin/login"><i class="fa fa-user-o"></i> Login </a></li>
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
                           <li><a href="/mypage/MypageMain/"><i class="fa fa-id-badge"></i> My Page</a></li>
                             <li><a id="cuslogout" ><i class="fa fa-user"></i> Logout</a></li>
                        </ul>
                    </div>
                   </div>
            </div>
            </c:when>
            </c:choose>
            </div>
      </div>
</div> <!-- End header area -->


<div class="site-branding-area" id="search-fixed-top">
        <div class="container">
            <div class="search-row">
            
            <a href="/"><img class="logoimg" src="/resources/images/mainImg/kostyle.png"></a>
            
            <div class="header_search">
            <form class="search-form" action="#" method="get" name="searchForm">
               <div class="search-box">
                  <dl class="clear">
                  <dt class="search1"><input id="search-text" type="text" name="search"></dt>
                  <dd class="search2"><input id="search-icon" type="image" src="/resources/images/mainImg/kostylesearch.png" alt="검색" title="검색" onclick="sendtwo()"></dd>
                  </dl>
               </div>
            </form>
            </div>
            
            </div>
        </div>
</div> <!-- End site branding area -->


<div class="navSticky">
<nav class="navbar navbar-default">
  <div class="container-fluid">
     <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span> 
      </button>
    </div>
  
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
      <li><a href="#">RANKING</a></li>
      
        <li class="dropdown">
          <a class="dropdown-toggle" data-toggle="dropdown" href="#">DISCOUNT</a>
          <ul class="dropdown-menu">
            <li><a href="#">기획할인</a></li>
            <li><a href="#">신상품할인</a></li>
          </ul>
        </li>
        
        <li><a href="/favorite/favoriteList">FAVORITE</a></li>
        <li><a href="#">ZZIM</a></li>
        <li><a href="/help/list">SERVICE CENTER</a></li>
      </ul>
    </div>
  </div>
</nav> 
</div>

<div class="remocon"></div>
</c:when>


</c:choose>


<%-- <div class="header-area">
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
                           <li><a href="/mypage/MypageMain/"><i class="fa fa-id-badge"></i> My Page</a></li>
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


<div class="site-branding-area" id="search-fixed-top">
        <div class="container">
            <div class="search-row">
            
            <a href="/"><img class="logoimg" src="/resources/images/mainImg/kostyle.png"></a>
            
            <div class="header_search">
            <form class="search-form" action="#" method="post" name="searchForm">
               <div class="search-box">
                  <dl class="clear">
                  <dt class="search1"><input id="search-text" type="text" name="search"></dt>
                  <dd class="search2"><input id="search-icon" type="image" src="/resources/images/mainImg/kostylesearch.png" alt="검색" title="검색" onclick="sendtwo()"></dd>
                  </dl>
               </div>
            </form>
            </div>
            
            </div>
        </div>
</div> <!-- End site branding area -->


<div class="navSticky">
<nav class="navbar navbar-default">
  <div class="container-fluid">
     <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span> 
      </button>
    </div>
  
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
      <li><a href="#">RANKING</a></li>
      
        <li class="dropdown">
          <a class="dropdown-toggle" data-toggle="dropdown" href="#">DISCOUNT</a>
          <ul class="dropdown-menu">
            <li><a href="#">기획할인</a></li>
            <li><a href="#">신상품할인</a></li>
          </ul>
        </li>
        
        <li><a href="/favorite/favoriteList">FAVORITE</a></li>
        <li><a href="#">ZZIM</a></li>
        <li><a href="/help/list">SERVICE CENTER</a></li>
      </ul>
    </div>
  </div>
</nav> 
</div> --%>

<!-- <div class="remocon"></div> -->



</body>



<script>
function sendtwo(){
   
   document.searchForm.action='/stats/insertstats';
   document.searchForm.submit();
   
   document.searchForm.action='/search/do';
   /* document.searchForm.attr("method", "get"); */
   document.searchForm.submit();
}
</script>

</html>