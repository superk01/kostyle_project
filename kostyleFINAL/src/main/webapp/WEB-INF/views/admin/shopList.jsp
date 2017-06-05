<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>

<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<script src="http://googledrive.com/host/0B-QKv6rUoIcGREtrRTljTlQ3OTg"></script>
<!-- ie10-viewport-bug-workaround.js -->
<script src="http://googledrive.com/host/0B-QKv6rUoIcGeHd6VV9JczlHUjg"></script>
<!-- holder.js -->

<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
<link href="../../../resources/css/admin/shopJoin.css" rel="stylesheet">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>

<style>
.row div{
	border : 1px solid;
}
</style>


</head>
<body>

등록여부, 신청날짜, 엑셀 다운로드, 선택삭제, 수정
<br><br><br>
<!-- shoppingmall list -->
	<div id="shopList">
	 <form role="form" method="post" id="adShopList">
 	<div>
 		<span></span>
 		<span>번호</span>
 		<span>쇼핑몰명</span>
 		<span>쇼핑몰 URL</span>
 	</div>
 	
 	<c:forEach items="${list }" var="ShoppingMallAdmin">
 		<div>
 			<span>
 				<input type="checkbox" name="s_num" id="check" value="${ShoppingMallAdmin.s_num }">
 			</span>
 			
 			<span class="shopInfo" id="s_num">${ShoppingMallAdmin.s_num }</span>
 			<span class="shopInfo" id="s_sname">
 				<a class="s_sname" data-toggle="modal" data-target="#myModal">${ShoppingMallAdmin.s_sname }</a>
 			</span>
 			<span style="display: none;" class="shopInfo" id="s_image" >${ShoppingMallAdmin.s_image }</span>
 			<span class="shopInfo" id="s_shopurl">
 				<a href="${ShoppingMallAdmin.s_shopurl }"> ${ShoppingMallAdmin.s_shopurl }</a>
 				</span>
 			<span style="display: none;" class="shopInfo" id="s_shopreg" >${ShoppingMallAdmin.s_shopreg }</span>
 			<span style="display: none;" class="shopInfo" id="s_age" >${ShoppingMallAdmin.s_age }</span>
 			<span style="display: none;" class="shopInfo" id="s_searchurl" >${ShoppingMallAdmin.s_searchurl }</span>
 			<span style="display: none;" class="shopInfo" id="s_manager" >${ShoppingMallAdmin.s_manager }</span>
 			<span style="display: none;" class="shopInfo" id="s_phonenumber" >${ShoppingMallAdmin.s_phonenumber }</span>
 			<span style="display: none;" class="shopInfo" id="s_email" >${ShoppingMallAdmin.s_email }</span>
 		</div>
 	</c:forEach>
 	
 		<div>
 			<button type="submit" id="adShop" class="btn btn-primary">ADSHOP</button>
		 </div>

	 </form>
 	</div>
 
 	

<!-- modal --> 	
	<div class="container">

		<div id="myModal" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="gridModalLabel" aria-hidden="true"
			style="display: none;">
			
			<div class="modal-dialog">
				<div class="modal-content">
				
					<div class="modal-header">					
						<button type="button" class="close" data-dismiss="modal" aria-label="Close">
							<span aria-hidden="true">×</span>
						</button>
						
						<h4 class="modal-title" id="gridModalLabel">
							<a class="anchorjs-link" href="#gridModalLabel">
							<span class="anchorjs-icon"></span>
							</a>
						</h4>
					</div>
					
					<div class="modal-body">
						<div class="container-fluid">
							<div class="row">
								<div class="col-md-12" id="m_image">이미지</div>
							</div>
							<div class="row">
								<div class="col-md-3">쇼핑몰 번호</div>
								<div class="col-md-9" id="m_num"></div>
							</div>
							<div class="row">
								<div class="col-md-3">쇼핑몰명</div>
								<div class="col-md-9" id="m_sname"></div>
							</div>
							<div class="row">
								<div class="col-md-3">사이트 URL</div>
								<div class="col-md-9" id="m_shopurl">${ShoppingMallAdmin.s_shopurl }</div>
							</div>
							<div class="row">
								<div class="col-md-3">사업자번호</div>
								<div class="col-md-9" id="m_shopreg"></div>
							</div>
							<div class="row">
								<div class="col-md-3">연령대</div>
								<div class="col-md-9" id="m_age"></div>
							</div>
							<div class="row">
								<div class="col-md-3">검색URL</div>
								<div class="col-md-12" id="m_searchurl"></div>
							</div>
							<div class="row">
								<div class="col-md-3">담당자</div>
								<div class="col-md-9" id="m_manager"></div>
							</div>
							<div class="row">
								<div class="col-md-3">연락처</div>
								<div class="col-md-9" id="m_phonenumber"></div>
							</div>
							<div class="row">
								<div class="col-md-3">Email</div>
								<div class="col-md-9" id="m_email"></div>
							</div>
							
								
							</div>
						</div>
						
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-info" id="adshopModal">ADSHOP</button>
						<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					</div>
					
				</div>
				<!-- /.modal-content -->
			</div>
			<!-- /.modal-dialog -->
		</div>
<!-- modal --> 	




lll
</body>

<script>


//모달창에 데이터 넣기
	$("#shopList .shopInfo").on("click", function(event){

		$(".modal-title").html($(this).parent().find(".s_sname").text());
		$("#m_image").html($(this).parent().find("#s_image").text());
		$("#m_num").html($(this).parent().find("#s_num").text());
		$("#m_sname").html($(this).parent().find(".s_sname").text());
		$("#m_shopurl").html($(this).parent().find("#s_shopurl").text());
		$("#m_shopreg").html($(this).parent().find("#s_shopreg").text());
		$("#m_age").html($(this).parent().find("#s_age").text());
		$("#m_searchurl").html($(this).parent().find("#s_searchurl").text());
		$("#m_manager").html($(this).parent().find("#s_manager").text());
		$("#m_phonenumber").html($(this).parent().find("#s_phonenumber").text());
		$("#m_email").html($(this).parent().find("#s_email").text());
	});
	
	
	$("#adshopModal").on("click", function(){
		
		var s_num = $("#m_num").html();
		alert(s_num);
		
		$.ajax({
			type:'post',
			url:'/admin/shopModal',
			headers:{
				"Content-Type":"application/json"},
			dataType:'text',
			data: JSON.stringify({s_num:s_num}),
			success:function(result){
				alert("dd");
			}
		});
		
		
	});

/* 	
	$("#adShopList").submit(function(event){
		event.preventDefault();
		
		alert("ddd");
	}); 
*/
	
</script>

</html>