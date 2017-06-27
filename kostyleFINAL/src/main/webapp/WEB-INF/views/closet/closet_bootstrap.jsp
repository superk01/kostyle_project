<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ include file="../main/kostyleHeader.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- <title>KOStyle</title> -->
<link rel="stylesheet" href="http://netdna.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<!-- <link href="/resources/css/closet/closet_scrolling_tabs.css" rel="stylesheet" type="text/css"> -->
    <!-- Latest jQuery form server -->
    <script src="http://code.jquery.com/jquery-3.2.1.min.js"></script>
<!-- 리스트의 스타일 -->
<!--     <script src="//code.jquery.com/jquery-1.10.2.min.js"></script> -->
<!--     <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script> -->
		<!-- Website CSS style -->
		<link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=Pacifico&amp;subset=latin-ext,vietnamese" rel="stylesheet">
		<!-- Website Font style -->
	    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.1/css/font-awesome.min.css">
		<link rel="stylesheet" href="product.css">
		<!-- Google Fonts -->
		<link href="https://fonts.googleapis.com/css?family=Quicksand:300,400,500,700&amp;subset=latin-ext,vietnamese" rel="stylesheet">

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
	.btn_group_row{
	margin-bottom : 30px;
	}
#closet_h1{
	margin-top:50px;
	margin-bottom: 35px;
	font-size: 50px;
}
#prd_h4{
    	font-weight: 600;
	}
.folder_container{
	/* margin-top : 100px; */
}
.product_container h4{
margin-top:30px; margin-bottom:10px;
}
#closetNavi{
	margin-bottom: 30px;
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

.btn {
	margin-left : 10px !important;
}
.btn-info {
    color: #fff;
    background-color: #19b4e2;
    border-color: #19b4e2;
	font-size:13px;
	font-weight:600;
}

.onePrd{
	margin-bottom: 70px;
}
.prdPhoto{
	overflw: hidden;
}
.updateLine{
    padding: 10px 15px;
    background-color: #f5f5f5;
    border-top: 1px solid #ddd;
    border-bottom-right-radius: 3px;
    border-bottom-left-radius: 3px;
}
    </style>

<style>
.folder_container { 
	padding: 0 3%;}
</style>
<link rel="stylesheet" href="/resources/js/closet/jquery.scrolling-tabs.css">
<script src="/resources/js/closet/jquery.scrolling-tabs.js"></script>

<!-- <script src="http://code.jquery.com/jquery-1.12.0.min.js"></script>
<script src="http://netdna.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script> -->

<!-- <script src="/resources/js/closet/closet_scrolling_tabs.js"></script> -->
 <script src="/resources/js/closet/closet.js"></script>

<script type="text/javascript">
/* $('.nav-tabs').scrollingTabs(); */

$(function(){ //최초실행시 전체폴더로가도록. trig라는 속성을 주어서 액션에서 "not"주입.
	var trig = '<c:out value="${trig}"/>'; 
	if ( trig == "" ) {
	//	 alert("trig==공백");
		$('#0').trigger('click');
	}
});

</script>

</head>

<body  id="closetBody">
	<c:set var="trig" value="${requestScope.trig }"></c:set>

	<div id="closetbackground">
		<div id="closetBodyTop"></div>
		<div id="closetContainer">


<section class="folder_container">
	<h1 id="closet_h1">MY CLOSET</h1>
<!-- Nav tabs -->
<nav id="closetNavi" class="scrtabs-tab-container" style="visibility: visible;">
	<div class="scrtabs-tab-scroll-arrow scrtabs-js-tab-scroll-arrow-left">
		<span class="glyphicon glyphicon-chevron-left"></span>
	</div>
	<div class="scrtabs-tabs-fixed-container" style="width: 95%;">
		
		<div class="scrtabs-tabs-movable-container" style=" padding:0; margin:0px; width: 80%;">
			<ul id="naviUL" class="nav nav-tabs" role="tablist">
<!-- Tab panes -->
		<!-- 전체상품은 폴더에 상관없이 항상 붙박이로 있어야함.  -->		
				<c:choose>
					<c:when test="${0 == select_clo_num || select_clo_num == null}">
					  <li role="presentation" class="active tabClick" id="0">
					  	<a href="#tab_${tab.clo_num }" role="tab" data-toggle="tab">
					  		<span class="tab_span_01">
					  			<img alt="" src="/resources/images/closetImg/checked-2.png">
					  		</span>
					  		<span class="tab_span_02">전체상품</span></a>
					  </li>
					</c:when> 
					<c:otherwise>
						<li role="presentation"  class="tabClick" id="0"><a href="#tab2" role="tab" data-toggle="tab">전체상품</a></li>
					</c:otherwise>	
				</c:choose>
	<!--  옷장 '탭' 루프 -->
	<c:forEach var="tab" items="${closetTab}">
  		<c:set value="${tab.clo_num}" var="tab_clo_num" />
		<c:set value="${requestScope.select_clo_num}" var="select_clo_num" />
		<c:choose>
			<c:when test="${tab_clo_num == select_clo_num}">
							<li role="presentation" class="selectTab tabClick" id="${tab.clo_num }">
								<a href="#tab_${tab.clo_num }" role="tab" data-toggle="tab">
	 								<span	class="tab_span_01">
									<img alt="" src="../resources/images/closetImg/checked-2.png">
									</span>
									<span class="tab_span_02">${tab.clo_name }</span>
								</a>
							</li>
			</c:when>
			<c:otherwise>
							<li role="presentation" class="tabClick" id="${tab.clo_num }">
								<a href="#tab_${tab.clo_num }" role="tab" data-toggle="tab">
	<!-- 							<span class="tab_span_01">
									<img alt="" src="../resources/images/closetImg/folder.png">
								</span> -->
								<span class="tab_span_02">${tab.clo_name }</span>
								</a>
							</li>
			</c:otherwise>
		</c:choose>
	</c:forEach>		
	<!-- 			  <li role="presentation"><a href="#tab2" role="tab" data-toggle="tab">Tab Number 2</a></li>
				  <li role="presentation"><a href="#tab3" role="tab" data-toggle="tab">Tab Number 3</a></li>
				  <li role="presentation"><a href="#tab4" role="tab" data-toggle="tab">Tab Number 4</a></li>
				  <li role="presentation"><a href="#tab5" role="tab" data-toggle="tab">Tab Number 5</a></li>
				  <li role="presentation"><a href="#tab6" role="tab" data-toggle="tab">Tab Number 6</a></li>
	 -->		

		<li role="presentation" class="tabClick" id="manage" ><a href="" role="tab" data-toggle="tab"><span>My옷장 관리</span><img id="manageImg" alt=""
					src="/resources/images/closetImg/btn_after_open.gif"></a></li>

	</ul>	
	</div>
	
	</div>
	
	<div class="scrtabs-tab-scroll-arrow scrtabs-js-tab-scroll-arrow-right">
		<span class="glyphicon glyphicon-chevron-right"></span>
	</div>
	
	<!--히든으로 정보보내기  -->
	<form name="cloForm" id="cloForm" method="post">
				<input type="hidden" name="cloTabParam" id="cloTabParam" value="${requestScope.closetTab}">
	</form>
</nav>

                    <div class="btn_group_row panel-footer row col-xs-12 col-sm-12 col-md-12"  style="padding: 10px 15px;">
                        <div class="pickButton col-xs-12 col-sm-6 col-md-6  pull-right">
                        	<input type="hidden" name="c_num" value="${sessionScope.c_num }">
							<input type="hidden" name="clo_num" value="${requestScope.clo_num }">
							<input type="checkbox" class="check" id="checkAll" value="0"
								name="check"  style="display:none"/>
               <!--          </div>	
                        <div class="closet_btn_group col-xs-6 col-sm-6 col-md-6 col-md-offset-2 pull-right ">	 -->
							<button class="btn btn-warning col-xs-4 col-sm-2 col-md-2 pull-right " type="button" value="이동" id="moveBtn1">폴더이동</button>
							<button class="btn btn-danger col-xs-4 col-sm-2 col-md-2 pull-right " type="button" value="삭제" id="deleteBtn">상품삭제</button>
                        	<button class="btn btn-primary col-xs-4 col-sm-2 col-md-2  pull-right " type="button" value="전체선택" id="checkAllBtn">전체선택</button>
	                 </div>

                        </div>



<!-- 아코디언예시 -->
<!-- <div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">	
	<div class="panel panel-default">
	        <div class="panel-heading" role="tab" id="headingOne">
	          <h4 class="panel-title" id="-collapsible-group-item-#1-">
	            <a data-toggle="collapse" data-parent="#accordion" href="#collapseOne" aria-expanded="true" aria-controls="collapseOne" class="">
	              Collapsible Group Item #1
	            </a>
	          <a class="anchorjs-link" href="#-collapsible-group-item-#1-"><span class="anchorjs-icon"></span></a></h4>
	        </div>
	        <div id="collapseOne" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="headingOne" aria-expanded="true">
	          <div class="panel-body">
	            Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry richardson ad squid. 3 wolf moon officia aute, non cupidatat skateboard dolor brunch. Food truck quinoa nesciunt laborum eiusmod. Brunch 3 wolf moon tempor, sunt aliqua put a bird on it squid single-origin coffee nulla assumenda shoreditch et. Nihil anim keffiyeh helvetica, craft beer labore wes anderson cred nesciunt sapiente ea proident. Ad vegan excepteur butcher vice lomo. Leggings occaecat craft beer farm-to-table, raw denim aesthetic synth nesciunt you probably haven't heard of them accusamus labore sustainable VHS.
	          </div>
	        </div>
	      </div>
</div> -->


<!--  상품section -->
<section class="tab-content">
<!--     <div role="tabpanel" class="tab-pane active" id="tab1">	<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam congue laoreet magna. Nulla gravida est enim, at scelerisque ex fringilla vel. Quisque dolor mi, pulvinar eget eros non, condimentum placerat lorem. Proin quis dui molestie eros venenatis blandit vitae ut augue. Cras viverra nibh a augue congue, eget eleifend metus gravida. Etiam dui metus, pharetra vel efficitur at, convallis sed eros. Morbi mattis venenatis ipsum eget dignissim.</p></div>
 -->
	<div role="tabpanel" class="product_container">
		<ul id="prdUL">
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
							<img	class="center-block col-xs-12 col-sm-12" src="${closetPrd.clo_imgUrl }"></a>
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
</div>			
<!-- END PRODUCTS -->
 <!--        <div class="panel-footer" > -->
<%--                     <div class="panel-footer row col-xs-12 col-sm-12 col-md-12" style="padding: 10px 15px;">
                        <div class="pickButton col-xs-12 col-sm-6 col-md-6 pull-right">
                        	<input type="hidden" name="c_num" value="${sessionScope.c_num }">
							<input type="hidden" name="clo_num" value="${requestScope.clo_num }">
							<input type="checkbox" class="check" id="checkAll" value="0"
								name="check"  style="display:none"/>
               <!--          </div>	
                        <div class="closet_btn_group col-xs-6 col-sm-6 col-md-6 col-md-offset-2 pull-right ">	 -->
                         	<button class="btn btn-primary col-xs-4 col-sm-2 col-md-2  pull-right " type="button" value="전체선택" id="checkAllBtn">전체선택</button>
							<button class="btn btn-danger col-xs-4 col-sm-2 col-md-2 pull-right " type="button" value="삭제" id="deleteBtn">상품삭제</button>
							<button class="btn btn-warning col-xs-4 col-sm-2 col-md-2 pull-right " type="button" value="이동" id="moveBtn1">폴더이동</button>
	                 </div>

                        </div> --%>
           <!--          </div> -->
</section>
<%-- 			<div class="pickButton">
				<!-- 히든으로 c_num값을 보내야... 아니면 jstl로 c:set해놓고 스크립트에서 c:out으로 받을 수 있음.-->
				<input type="hidden" name="c_num" value="${sessionScope.c_num }">
				<input type="hidden" name="clo_num" value="${requestScope.clo_num }">
				<input type="checkbox" class="check" id="checkAll" value="0"
					name="check" style="display: none" />
				<button type="button" value="전체선택" id="checkAllBtn">전체선택</button>
				<button type="button" value="삭제" id="deleteBtn">상품삭제</button>
				<button type="button" value="이동" id="moveBtn1">폴더이동</button>
			</div> --%>
			
			
        
           
<!-- 
 <div class="panel-footer row col-xs-12 col-sm-12 col-md-12" style="padding: 10px 15px;">
 
                        <div class="checkbox col-xs-6 col-sm-6 col-md-4">
                        	<input type="checkbox" class="checkCloset allcheckCloset" value="allCheckCloset" />&nbsp&nbsp전체선택<b>(삭제시)</b>
                        </div>	
                        <div id="media_2_div">	
                        	<!--  <span>전체선택<b>(삭제시)</b></span>
	                         -->   
	                 </div>

                        </div>

	</section>

</div>
</div>

</div>
</div>

<!--  <script src="js/bootstrap.min.js"></script> -->
<script type="text/javascript">

/* 이미지 높이 일괄적용  */
$(document).ready(function() {
  var maxHeight = -1;

  $('.prdPhoto').each(function() {
  console.log("최대높이: "+maxHeight);
    maxHeight = maxHeight > $(this).height() ? maxHeight : $(this).height();
  });

  console.log("최대높이: "+maxHeight);
  $('.prdPhoto').each(function() {
    $(this).height(maxHeight);
  });
});
</script>

			}
			
		}//end else
		
	});
});









</script>
<footer>
<%@ include file="../main/footer.jsp" %>

</footer>

</body>

</html>

