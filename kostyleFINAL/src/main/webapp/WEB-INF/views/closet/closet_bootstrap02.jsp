<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ko">
<head>
    <meta charset="utf-8">
    <meta name="robots" content="noindex">

    <title>Product Design... - Bootsnipp.com</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    
    
    <style type="text/css">
    @import url('https://fonts.googleapis.com/css?family=Quicksand:300,400,500,700&subset=latin-ext,vietnamese');   
body{font-family: 'Quicksand', sans-serif;}
ul, ol, li {
    list-style: none;
}
	a{
		text-decoration: none;
		color: black;
	}
   #prd_h4{
    	font-weight: 600;
	}
.product_container h4{
margin-top:30px; margin-bottom:10px;
}
	.prd_p{
		font-size: 12px;
		margin-top: 5px;
	}
	.price{
		font-size: 110%;
    	margin: 0 auto;
    	color: #333;
	}

	.prd_thumbnail{
		opacity:0.70;
		-webkit-transition: all 0.5s; 
		transition: all 0.5s;
	}
	.prd_thumbnail:hover{
		opacity:1.00;
		box-shadow: 0px 0px 10px #4bc6ff;
	}

    .prd_thumbnail a{
	    width: 100%;
    }
	.line{
		margin-bottom: 5px;
	}
	@media screen and (max-width: 770px) {
		.right{
			float:left;
			width: 100%;
		}
	}
	span.prd_thumbnail {
        border: 1px solid #00c4ff !important;
    border-radius: 0px !important;
    -webkit-box-shadow: 0px 0px 14px 0px rgba(0,0,0,0.16);
    -moz-box-shadow: 0px 0px 14px 0px rgba(0,0,0,0.16);
    box-shadow: 0px 0px 14px 0px rgba(0,0,0,0.16);
	padding: 10px;
}

.right {
    float: right;
    border-bottom: 2px solid #0a5971;
}
.btn-info {
    color: #fff;
    background-color: #19b4e2;
    border-color: #19b4e2;
	font-size:13px;
	font-weight:600;
}
.btn {
	margin-left : 10px;
}
    </style>
    
    
    <script src="//code.jquery.com/jquery-1.10.2.min.js"></script>
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>

</head>
<body>
	

     
		<meta name="viewport" content="width=device-width, initial-scale=1">


		<!-- Website CSS style -->
		<link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=Pacifico&amp;subset=latin-ext,vietnamese" rel="stylesheet">
		<!-- Website Font style -->
	    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.1/css/font-awesome.min.css">
		<link rel="stylesheet" href="product.css">
		<!-- Google Fonts -->
		<link href="https://fonts.googleapis.com/css?family=Quicksand:300,400,500,700&amp;subset=latin-ext,vietnamese" rel="stylesheet">


		<title>Product Shop Responsive </title>
	
	
		<div class="product_container">
		<h4>나의 옷장</h4>
	
	
			
<!-- BEGIN PRODUCTS -->
<%--  <ul id="prdUL">
		<!-- 상품Loop !!!!!!!!!!!!!!!!!!!!!!!! -->
		<c:set var="listLength" value="${fn:length(cloList)}"></c:set>
		<c:forEach var="closetPrd" items="${cloList }" varStatus="status">
			<li class="onePrd col-xs-12 col-sm-6 col-md-3 ">
				<div>
					<div class="numCheck row"><!-- bootstrap row속성추가  -->
							<!-- 체크박스 들어갈 공간 -->
							&nbsp<em class="pickNum">${(listLength)-(status.index)}.</em> 
							<input type="checkbox" class="check"
								value="${closetPrd.clo_detail_num }" name="check" />
							${closetPrd.clo_name }
							<span style= "display:none">${closetPrd.clo_num}</span>
						</div> 	
  				
  				
				<div class="prdPhoto prd_thumbnail">
					<!-- 이미지and URL -->
					<a href="http://${closetPrd.clo_prdUrl}">
							<img	class="center-block" src="${closetPrd.clo_imgUrl }"></a>
				</div>
  		
  				
  			<!--상품정보시작  -->
			<div class="introPrd">
					
					<div class="prdName">
						<!-- 상품이름 -->
						<h4 id="prd_h4" class="text-center"><a href="http://${closetPrd.clo_prdUrl}">${closetPrd.clo_prdName }</a></h4>
					</div>
					
					<div class="row">
						<div class="prdPrice col-xs-6 col-sm-6 col-md-6 col-xs-offset-3 col-sm-offset-3 col-md-offset-3 text-center">
								<span class="fa fa-krw"></span><span class="price prd_p"> ${closetPrd.clo_price }</span>
						</div>
					</div>
					
<hr class="line">
					
					<div class="row">
						<div class="prdPickNum col-xs-6 col-sm-6 col-md-6">
							<span class="glyphicon glyphicon-heart"></span>
							<span class="text-left"> ${closetPrd.clo_zzim  }</span>
							<!--  상품 찜갯수도 가능하면 -->
						</div>
						<div class="shopName col-xs-6 col-sm-6 col-md-6 text-right">
							<span class="glyphicon glyphicon-home"></span><span> ${closetPrd.s_sname }</span>
						</div>
					</div>
						<!-- 쇼핑몰이름 -->
				</div>
			</div>
		</li>
	</c:forEach>

</ul>				
<!-- END PRODUCTS -->

</div><!-------product_container----->
 --%>
 <ul id="prdUL">
		<!-- 상품Loop !!!!!!!!!!!!!!!!!!!!!!!! -->
		
			<li class="onePrd col-xs-12 col-sm-6 col-md-3 ">
				<div>
					<div class="numCheck row"><!-- bootstrap row속성추가  -->
							<!-- 체크박스 들어갈 공간 -->
							&nbsp<em class="pickNum">${(listLength)-(status.index)}.</em> 
							<input type="checkbox" class="check"
								value="${closetPrd.clo_detail_num }" name="check" />
							${closetPrd.clo_name }
							<span style= "display:none">${closetPrd.clo_num}</span>
						</div> 	
  				
  				
				<div class="prdPhoto prd_thumbnail">
					<!-- 이미지and URL -->
					<a href="http://${closetPrd.clo_prdUrl}">
							<img class="center-block" src="https://s12.postimg.org/41uq0fc4d/item_2_180x200.png" alt="..."></a>
				</div>
  		
  				
  			<!--상품정보시작  -->
			<div class="introPrd">
					
					<div class="prdName">
						<!-- 상품이름 -->
						<h4 id="prd_h4" class="text-center"><a href="http://${closetPrd.clo_prdUrl}">라이브로브트렌치</a></h4>
					</div>
					
					<div class="row">
						<div class="prdPrice col-xs-6 col-sm-6 col-md-6 col-xs-offset-3 col-sm-offset-3 col-md-offset-3 text-center">
								<span class="	fa fa-krw"></span><span class="price prd_p"> 39000원</span>
						</div>
					</div>
					
<hr class="line">
					
					<div class="row">
						<div class="prdPickNum col-xs-6 col-sm-6 col-md-6">
							<span class="glyphicon glyphicon-heart"></span>
							<span class="text-left">찜갯수</span>
							<!--  상품 찜갯수도 가능하면 -->
						</div>
						<div class="shopName col-xs-6 col-sm-6 col-md-6 text-right">
							<span class="glyphicon glyphicon-home"></span><span> 스타일난다</span>
						</div>
					</div>
						<!-- 쇼핑몰이름 -->
				</div>
			</div>
		</li>
			<li class="onePrd col-xs-12 col-sm-6 col-md-3 ">
				<div>
					<div class="numCheck row"><!-- bootstrap row속성추가  -->
							<!-- 체크박스 들어갈 공간 -->
							&nbsp<em class="pickNum">${(listLength)-(status.index)}.</em> 
							<input type="checkbox" class="check"
								value="${closetPrd.clo_detail_num }" name="check" />
							${closetPrd.clo_name }
							<span style= "display:none">${closetPrd.clo_num}</span>
						</div> 	
  				
  				
				<div class="prdPhoto prd_thumbnail">
					<!-- 이미지and URL -->
					<a href="http://${closetPrd.clo_prdUrl}">
							<img class="center-block" src="https://s12.postimg.org/41uq0fc4d/item_2_180x200.png" alt="..."></a>
				</div>
  		
  				
  			<!--상품정보시작  -->
			<div class="introPrd">
					
					<div class="prdName">
						<!-- 상품이름 -->
						<h4 id="prd_h4" class="text-center"><a href="http://${closetPrd.clo_prdUrl}">라이브로브트렌치</a></h4>
					</div>
					
					<div class="row">
						<div class="prdPrice text-center col-xs-6 col-sm-6 col-md-6 col-xs-offset-3 col-sm-offset-3 col-md-offset-3 ">
								<span class="	fa fa-krw"></span><span class="price prd_p"> 39000원</span>
						</div>
					</div>
					
<hr class="line">
					
					<div class="row">
						<div class="prdPickNum col-xs-6 col-sm-6 col-md-6">
							<span class="glyphicon glyphicon-heart"></span>
							<span class="text-left">찜갯수</span>
							<!--  상품 찜갯수도 가능하면 -->
						</div>
						<div class="shopName col-xs-6 col-sm-6 col-md-6 text-right">
							<span class="glyphicon glyphicon-home"></span><span> 스타일난다</span>
						</div>
					</div>
						<!-- 쇼핑몰이름 -->
				</div>
			</div>
		</li>
			<li class="onePrd col-xs-12 col-sm-6 col-md-3 ">
				<div>
					<div class="numCheck row"><!-- bootstrap row속성추가  -->
							<!-- 체크박스 들어갈 공간 -->
							&nbsp<em class="pickNum">${(listLength)-(status.index)}.</em> 
							<input type="checkbox" class="check"
								value="${closetPrd.clo_detail_num }" name="check" />
							${closetPrd.clo_name }
							<span style= "display:none">${closetPrd.clo_num}</span>
						</div> 	
  				
  				
				<div class="prdPhoto prd_thumbnail">
					<!-- 이미지and URL -->
					<a href="http://${closetPrd.clo_prdUrl}">
							<img class="center-block"  src="https://s12.postimg.org/41uq0fc4d/item_2_180x200.png" alt="..."></a>
				</div>
  		
  				
  			<!--상품정보시작  -->
			<div class="introPrd">
					
					<div class="prdName">
						<!-- 상품이름 -->
						<h4 id="prd_h4" class="text-center"><a href="http://${closetPrd.clo_prdUrl}">라이브로브트렌치</a></h4>
					</div>
					
					<div class="row">
						<div class="prdPrice text-center col-xs-6 col-sm-6 col-md-6 col-xs-offset-3 col-sm-offset-3 col-md-offset-3 ">
								<span class="fa fa-krw"></span><span class="price prd_p"> 139000원</span>
						</div>
					</div>
					
<hr class="line">
					
					<div class="row">
						<div class="prdPickNum col-xs-6 col-sm-6 col-md-6">
							<span class="glyphicon glyphicon-heart"></span>
							<span class="text-left">찜갯수</span>
							<!--  상품 찜갯수도 가능하면 -->
						</div>
						<div class="shopName col-xs-6 col-sm-6 col-md-6 text-right">
							<span class="glyphicon glyphicon-home"></span><span> 스타일난다</span>
						</div>
					</div>
						<!-- 쇼핑몰이름 -->
				</div>
			</div>
		</li>


</ul>				
<!-- END PRODUCTS -->

</div><!-------product_container----->



<!--  ----------------------------------------------------------------------------------------------------원본  -->
<!--
  		<div class="col-xs-12 col-sm-6 col-md-3 ">
    		<span class="prd_thumbnail">
      			<img src="https://s12.postimg.org/41uq0fc4d/item_2_180x200.png" alt="...">
      			<h4>Product Tittle</h4>
      			<div class="ratings">
                    <span class="glyphicon glyphicon-star"></span>
                    <span class="glyphicon glyphicon-star"></span>
                    <span class="glyphicon glyphicon-star"></span>
                    <span class="glyphicon glyphicon-star"></span>
                    <span class="glyphicon glyphicon-star-empty"></span>
                </div>
      			<p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. </p>
      			<hr class="line">
      			<div class="row">
      				<div class="col-md-6 col-sm-6">
      					<p class="price">$29,90</p>
      				</div>
      				<div class="col-md-6 col-sm-6">
      				 <a href="http://cookingfoodsworld.blogspot.in/" target="_blank">	<button class="btn btn-info right"> BUY ITEM</button></a>
      				</div>
      				
      			</div>
    		</span>
  		</div>



  -->
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="js/bootstrap.min.js"></script>
	

	<script type="text/javascript">
	
	</script>


</body></html>