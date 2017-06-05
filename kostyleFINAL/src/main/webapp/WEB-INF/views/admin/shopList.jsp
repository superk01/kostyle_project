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

��û��¥, ���� �ٿ�ε�, ���û���, ����
<br><br><br>
<!-- shoppingmall list -->
	<div id="shopList">
	 <form role="form" method="post" id="adShopList">
 	<div>
 		<span></span>
 		<span>��ȣ</span>
 		<span>���θ���</span>
 		<span>���θ� URL</span>
 		<span>��Ͽ���</span>
 	</div>
 	
 	<c:forEach items="${list }" var="ShopStateAdmin">
 		<div>
 			<span>
 				<input type="checkbox" name="s_num" id="check" value="${ShopStateAdmin.shop.s_num }">
 			</span>
 			
 			<span class="shopInfo" id="s_num">${ShopStateAdmin.shop.s_num }</span>
 			<span class="shopInfo" id="s_sname">
 				<a class="s_sname" data-toggle="modal" data-target="#myModal">${ShopStateAdmin.shop.s_sname }</a>
 			</span>
 			<span class="shopInfo" id="s_shopurl">
 				<a href="${ShopStateAdmin.shop.s_shopurl }"> ${ShopStateAdmin.shop.s_shopurl }</a>
 			</span>
			<span class="shopInfo" id="shopstate">${ShopStateAdmin.shopState }</span>
 			<span style="display: none;" class="shopInfo" id="s_image" >${ShopStateAdmin.shop.s_image }</span>
 			<span style="display: none;" class="shopInfo" id="s_shopreg" >${ShopStateAdmin.shop.s_shopreg }</span>
 			<span style="display: none;" class="shopInfo" id="s_age" >${ShopStateAdmin.shop.s_age }</span>
 			<span style="display: none;" class="shopInfo" id="s_searchurl" >${ShopStateAdmin.shop.s_searchurl }</span>
 			<span style="display: none;" class="shopInfo" id="s_manager" >${ShopStateAdmin.shop.s_manager }</span>
 			<span style="display: none;" class="shopInfo" id="s_phonenumber" >${ShopStateAdmin.shop.s_phonenumber }</span>
 			<span style="display: none;" class="shopInfo" id="s_email" >${ShopStateAdmin.shop.s_email }</span>
 			<span style="display: none;" class="shopInfo" id="ad_hitcount">${ShopStateAdmin.adShop.ad_hitcount }</span>
 			<span style="display: none;" class="shopInfo" id="s_grade">${ShopStateAdmin.adShop.s_grade }</span>
 		</div>
 	</c:forEach>
 	
 		<div>
 			<button type="button" class="btn btn-primary" id="adShop" >���θ� ���</button>
	        <button type="button" class="btn btn-danger" id="delAdShop">��� ���</button>
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
							<span aria-hidden="true">��</span>
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
								<div class="col-md-12" id="m_image">�̹���</div>
							</div>
							<div class="row">
								<div class="col-md-12 m_midtitle">�⺻����</div>
							</div>
							<div class="row">
								<div class="col-md-3">���θ� ��ȣ</div>
								<div class="col-md-3" id="m_num"></div>
								<div class="col-md-3">��� ����</div>
								<div class="col-md-3" id="m_shopstate"></div>
							</div>
							<div class="row">
								<div class="col-md-3">���θ���</div>
								<div class="col-md-9" id="m_sname"></div>
							</div>
							<div class="row">
								<div class="col-md-3">����Ʈ URL</div>
								<div class="col-md-9" id="m_shopurl">${ShopStateAdmin.shop.s_shopurl }</div>
							</div>
							<div class="row">
								<div class="col-md-3">����ڹ�ȣ</div>
								<div class="col-md-9" id="m_shopreg"></div>
							</div>
							<div class="row">
								<div class="col-md-3">���ɴ�</div>
								<div class="col-md-9" id="m_age"></div>
							</div>
							<div class="row">
								<div class="col-md-3">�˻�URL</div>
								<div class="col-md-12" id="m_searchurl"></div>
							</div>
							<div class="row">
								<div class="col-md-12 m_midtitle">�����</div>
							</div>
							<div class="row">
								<div class="col-md-3">�����</div>
								<div class="col-md-9" id="m_manager"></div>
							</div>
							<div class="row">
								<div class="col-md-3">����ó</div>
								<div class="col-md-9" id="m_phonenumber"></div>
							</div>
							<div class="row">
								<div class="col-md-3">Email</div>
								<div class="col-md-9" id="m_email"></div>
							</div>
							<div class="row">
								<div class="col-md-12 m_midtitle">�߰�����</div>
							</div>
							<div class="row">
								<div class="col-md-3">�湮�ڼ�</div>
								<div class="col-md-3" id="m_hitcount"></div>
								<div class="col-md-3">�ɻ�����</div>
								<div class="col-md-3" id="m_grade"></div>
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


//���â�� ������ �ֱ�
	$("#shopList .shopInfo").on("click", function(event){

		$(".modal-title").html($(this).parent().find(".s_sname").text());
		$("#m_image").html($(this).parent().find("#s_image").text());
		$("#m_num").html($(this).parent().find("#s_num").text());
		$("#m_shopstate").html($(this).parent().find("#shopstate").text());
		$("#m_sname").html($(this).parent().find(".s_sname").text());
		$("#m_shopurl").html($(this).parent().find("#s_shopurl").text());
		$("#m_shopreg").html($(this).parent().find("#s_shopreg").text());
		$("#m_age").html($(this).parent().find("#s_age").text());
		$("#m_searchurl").html($(this).parent().find("#s_searchurl").text());
		$("#m_manager").html($(this).parent().find("#s_manager").text());
		$("#m_phonenumber").html($(this).parent().find("#s_phonenumber").text());
		$("#m_email").html($(this).parent().find("#s_email").text());
		$("#m_hitcount").html($(this).parent().find("#ad_hitcount").text());
		$("#m_grade").html($(this).parent().find("#s_grade").text());
	});
	

//���â���� adshoppingmall ����ϱ�
	$("#adshopModal").on("click", function(){
		
		var s_num = $("#m_num").html();
		var checkState = $("#m_shopstate").html();
		
		if(checkState == "���"){
			alert("�̹� ��ϵ� ���θ��Դϴ�.");
		}else{
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
		}
	});
	
	
	//����Ʈ���� adshoppingmall ����ϱ�
	$("#adShop").on("click",function(){
		
		if($("#shopList :checked").size()<1){
			alert("���ä���");
		}else{
			var check = true;
			$("#shopList :checked").each(function(i,item){
				var checkState = $(this).parent().nextAll("#shopstate").text();
				if(checkState == "���"){
					check=false;
				}
			});
			if(check){
				$("#adShopList").submit();
			}else{
				alert("�ٽ� ����");
			}
		};
	});

	
	$("#delAdShop").on("click", function(){

		if($("#shopList :checked").size()<1){
			alert("���ä���");
		}else{
			var check = true;
			$("#shopList :checked").each(function(i,item){
				var checkState = $(this).parent().nextAll("#shopstate").text();
				if(checkState == "�̵��"){
					check=false;
				}
			});
			if(check){
				$("#adShopList").attr("action","/admin/deleteAdShop");
				$("#adShopList").submit();
			}else{
				alert("�ٽ� ����");
			}
		};
		
	});
	
	
	
/* 	
	$("#adShopList").submit(function(event){
		event.preventDefault();
		
		alert("ddd");
	}); 
*/
	
</script>

</html>