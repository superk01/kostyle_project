<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String statsbody = request.getParameter("statsbody");
	if(statsbody==null){
		statsbody = "statsMain.jsp";
	}
%>
<%@ include file="../main/kostyleHeader.jsp" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
      .jbFixed {
        position: fixed;
        top: 0px;
        width: 100%;
        z-index:10000;
      }
</style>
    <script>
      $(document).ready( function() {
        var jbOffset = $('.hamburgerSticky').offset();
        $(window).scroll(function(){
          if ($(document).scrollTop() > jbOffset.top) {
            $('.hamburgerSticky').addClass('jbFixed');
          }
          else {
            $('.hamburgerSticky').removeClass( 'jbFixed');
          }
        });
      });
    </script>
<title>Insert title here</title>


   <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
   <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
 
	<script src="../../../resources/js/stats/statsside2.js"></script>

	<link rel="stylesheet" href="../../../resources/css/stats/statsside2.css">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
	
</head>
<body>

    <div id="wrapper">
        <div class="overlay"></div>
    
        <!-- Sidebar -->
        <nav class="navbar-inverse navbar-fixed-top" id="sidebar-wrapper" role="navigation">
            <ul class="nav sidebar-nav">
                <li class="sidebar-brand">
                </li>
                <li>
                    <a href="statsSide">
                	<span class="ifont"><i class="fa fa-bar-chart" style="font-size:19px"></i></span>
                    HOME</a>
                </li>
                
                <li class="dropdown">
                    <a href="#" data-toggle="collapse" data-target="#dropdown-visitor">
                    <span class="ifont"><i class="fa fa-female" style="font-size:23px"></i></span>
                         방문자 <span class="caret"></span></a>
                  
                  <div class="panel-body">
                  	<ul class="collapse" id="dropdown-visitor">
                  		<li><a href="statsSide?statsbody=statsVisitor.jsp">방문자수 분석</a></li>
                  	</ul>
                  </div>
                  
                </li>
                
                <li class="dropdown">
                    <a href="#" data-toggle="collapse" data-target="#dropdown-shop">
					<span class="ifont"><i class="material-icons" style="font-size:25px">store</i></span>
                        쇼핑몰 <span class="caret"></span></a>
                  
                  <div class="panel-body">
                  	<ul class="collapse" id="dropdown-shop">
                  		<li><a href="#">전체 쇼핑몰 분석</a></li>
                  	</ul>
                  </div>
                  
                </li>
                
                <li class="dropdown">
                    <a href="#" data-toggle="collapse" data-target="#dropdown-product">
                   <span class="ifont"><i class="material-icons" style="font-size:24px">redeem</i></span>
                        상품 <span class="caret"></span></a>
                  
                  <div class="panel-body">
                  	<ul class="collapse" id="dropdown-product">
                  		<li><a href="#">검색어 분석</a></li>
                  		<li><a href="#">찜하기 분석</a></li>
                  	</ul>
                  </div>
                  
                </li>

                <li class="dropdown">
                  <a href="#" data-toggle="collapse" data-target="#dropdown-user">
                  <span class="ifont"><i class="fa fa-user" style="font-size:22px"></i></span>
                  	회원 <span class="caret"></span></a>
                
                  <div class="panel-body">
                  	<ul class="collapse" id="dropdown-user">
	                <li><a href="#">신규 회원 분석</a></li>
	                <li><a href="#">전체 회원 분석</a></li>
	                <li><a href="#">상세 회원 분석</a></li>
	                </ul>
                  </div>
                </li>
       

            </ul>
        </nav>
        <!-- /#sidebar-wrapper -->

        <!-- Page Content -->
        <div id="page-content-wrapper">
        	<div class="hamburgerSticky">
            <button type="button" class="hamburger is-closed" data-toggle="offcanvas">
                <span class="hamb-top"></span>
    			<span class="hamb-middle"></span>
				<span class="hamb-bottom"></span>
            </button>
            </div>
            <div class="container">
                <div class="row">
                    <div class="col-lg-8 col-lg-offset-2">
						
						<div id="statsbody">
						
							<jsp:include page="<%= statsbody %>"/>
						 
						</div>


                    </div>
                </div>
            </div>
        </div>
        <!-- /#page-content-wrapper -->

    </div>
    <!-- /#wrapper -->
    


</body>
</html>