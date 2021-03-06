<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="../main/kostyleHeader.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="http://googledrive.com/host/0B-QKv6rUoIcGREtrRTljTlQ3OTg"></script>
<!-- ie10-viewport-bug-workaround.js -->
<script src="http://googledrive.com/host/0B-QKv6rUoIcGeHd6VV9JczlHUjg"></script>
<!-- holder.js -->
<link href="../../../resources/css/admin/shopList.css" rel="stylesheet">


</head>
<body>
<br>
<div id="shopListCon">
<div id="searchShop">
	<span id="searchSelect" class="searchEl">
		<select name="searchType">
			<option value="none" <c:out value="${cri.searchType == null?'selected':'' }"/>>전체</option>
			<option value="snum" <c:out value="${cri.searchType eq 'snum'?'selected':''}"/>>쇼핑몰번호</option>
			<option value="sname" <c:out value="${cri.searchType eq 'sname'?'selected':''}"/>>쇼핑몰명</option>
			<option value="surl" <c:out value="${cri.searchType eq 'surl'?'selected':''}"/>>쇼핑몰 URL</option>
			<option value="sreg" <c:out value="${cri.searchType eq 'sreg'?'selected':''}"/>>사업자등록번호</option>
		</select>
	</span>
	
	<span class="searchEl">
		<input type="text" name="keyword" value='${cri.keyword }' id="searchText">
	</span>
	<br>
	<span id="searchRadio" class="searchEl">
		<label for="state_all">
		<input type="radio" name="shopState" value="all" id="state_all" checked="checked">전체
		</label>
		<label for="state_o">
		<input type="radio" name="shopState" value="o" id="state_o">등록
		</label>
		
		<label for="state_x">
		<input type="radio" name="shopState" value="x" id="state_x">미등록
		</label>
	</span>
	<br>
	<span>
		<input type="button" id="searchBtn" class="searchEl" value="Search">
	</span>
</div>



<br><br><br>
<!-- shoppingmall list -->
	<div id="shopList">
	 <form role="form" method="post" id="adShopList">
 	<div class="row divider_row">
 		<span class="colCheck col-md-1 col-sm-1 col-xs"></span>
 		<span class="colSmall col-md-1 col-sm-1 col-xs-1">번호</span>
 		<span class="colMid col-md-1 col-sm-1 col-xs-1">쇼핑몰명</span>
 		<span class="col-md-2 col-sm-2 col-xs-2">쇼핑몰 URL</span>
 		<span class="colMid col-md-2 col-sm-2 col-xs-2">사업자등록번호</span>
 		<span class="colSmall col-md-1 col-sm-1 col-xs-1">등록여부</span>
 		<span class="colSmall col-md-1 col-sm-1 col-xs-1">심사점수</span>
 		<span class="colSmall col-md-1 col-sm-1 col-xs-1">수정</span>
 	</div>
 	
 	<c:forEach items="${list }" var="ShopStateAdmin">
 		<div class="shopInfotr row divider_row">
 			<span class="colCheck col-md-1 col-sm-1 col-xs-1">
 				<input type="checkbox" name="s_num" id="check" value="${ShopStateAdmin.shop.s_num }">
 			</span>
 			
 			<span class="shopInfo colSmall col-md-1 col-sm-1 col-xs-1" id="s_num">${ShopStateAdmin.shop.s_num }</span>
 			<span class="shopInfo colMid col-md-1 col-sm-1 col-xs-1" id="s_sname">
 				<a class="s_sname" data-toggle="modal" data-target="#myModal">${ShopStateAdmin.shop.s_sname }</a>
 			</span>
 			<span class="shopInfo col-md-2 col-sm-2 col-xs-2" id="s_shopurl">
 				<a href="http://${ShopStateAdmin.shop.s_shopurl }" target="_blank"> ${ShopStateAdmin.shop.s_shopurl }</a>
 			</span>
 			<span class="shopInfo colMid col-md-2 col-sm-2 col-xs-2" id="s_shopreg" >${ShopStateAdmin.shop.s_shopreg }</span>
			<span class="shopInfo colSmall col-md-1 col-sm-1 col-xs-1 ${ShopStateAdmin.shopState }" id="shopstate"></span>
 			<span class="shopInfo colSmall col-md-1 col-sm-1 col-xs-1" id="s_grade">${ShopStateAdmin.adShop.s_grade }</span>
 			<span style="display: none;" class="shopInfo col-md-1 col-sm-1 col-xs-1" id="s_image" >${ShopStateAdmin.shop.s_image }</span>
 			<span style="display: none;" class="shopInfo col-md-1 col-sm-1 col-xs-1" id="s_age" >${ShopStateAdmin.shop.s_age }</span>
 			<span style="display: none;" class="shopInfo col-md-1 col-sm-1 col-xs-1" id="s_searchurl" >${ShopStateAdmin.shop.s_searchurl }</span>
 			<span style="display: none;" class="shopInfo col-md-1 col-sm-1 col-xs-1" id="s_manager" >${ShopStateAdmin.shop.s_manager }</span>
 			<span style="display: none;" class="shopInfo col-md-1 col-sm-1 col-xs-1" id="s_phonenumber" >${ShopStateAdmin.shop.s_phonenumber }</span>
 			<span style="display: none;" class="shopInfo col-md-1 col-sm-1 col-xs-1" id="s_email" >${ShopStateAdmin.shop.s_email }</span>
 			<span class="shopInfo colSmall col-md-1 col-sm-1 col-xs-1" id="modifyShop"><a data-toggle="modal" data-target="#myModal">수정</a></span>
 		</div>
 	</c:forEach>
 	
 		<div>
 			<button type="button" class="btn btn-primary" id="adShop" >쇼핑몰 등록</button>
	        <button type="button" class="btn btn-danger" id="delAdShop">등록 취소</button>
		 </div>

	 </form>
 	</div>
 <div class="box-footer">
 	<div class="text-center">
 		<ul class="pagination">
 			<c:if test="${page.prev}"><!-- pageMaker의 prev가 true이면=현재페이지가 1이아니면 -->
 				<li><a href="shopList${page.makeQuery(page.startPage - 1) }">&laquo;</a></li>
                                      <!-- url에 listPage=startPage-1 링크 걸어 -->
            </c:if>
            <c:forEach begin="${page.startPage }" end="${page.endPage }" var="idx"><!-- startPage~endPage 돌면서 -->
            	<li <c:out value="${page.cri.page == idx?'class=active':''}"/>><!-- 현재페이지에 active 클래스 추가 -->
                	<a href="shopList${page.makeQuery(idx)}">${idx}</a><!-- 각페이지번호에 링크 걸어 -->
                </li>
            </c:forEach>
            <c:if test="${page.next && page.endPage > 0}"><!-- pageMaker의 next가 true이고 endPage가 >0이면 -->
            	<li><a href="shopList${page.makeQuery(page.endPage +1) }">&raquo;</a></li>
                                      <!-- next에 endPage+1 링크 걸어 -->
            </c:if>
          </ul>
	</div>
</div>
 
 
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
								<div class="col-md-12">
								<img id="m_image" alt="" src="" width="157px">
								</div>
							</div>
							<div class="row">
								<div class="col-md-12 m_midtitle">기본정보</div>
							</div>
							<div class="row">
								<div class="col-md-3">쇼핑몰 번호</div>
								<div class="col-md-3 " id="m_num"></div>
								<div class="col-md-3">등록 여부</div>
								<div class="col-md-3" id="m_shopstate"></div>
							</div>
							<div class="row">
								<div class="col-md-3">쇼핑몰명</div>
								<div class="col-md-9">
									<input type="text"  id="m_sname" value="">
								</div>
							</div>
							<div class="row">
								<div class="col-md-3">사이트 URL</div>
								<div class="col-md-9">
									<input type="text" id="m_shopurl" value="">
								</div>
							</div>
							<div class="row">
								<div class="col-md-3">사업자번호</div>
								<div class="col-md-9" id="m_shopreg"></div>
							</div>
							<div class="row">
								<div class="col-md-3">연령대</div>
								<div class="col-md-9">
								<!-- 
									<input type="text" id="m_age" value="">
								 -->
									<select id="m_age" name="s_age">
							        	<option value="0" selected="selected">연령대</option>
							        	<option value="10">10대</option>
							        	<option value="20">20대</option>
							        	<option value="30">30대</option>
							        	<option value="40">40대</option>
									</select>
								</div>
							</div>
							<div class="row">
								<div class="col-md-3">검색URL</div>
								<div class="col-md-12">
									<input type="text" id="m_searchurl" value="" width="540px">
								</div>
							</div>
							<div class="row">
								<div class="col-md-12 m_midtitle">담당자</div>
							</div>
							<div class="row">
								<div class="col-md-3">담당자</div>
								<div class="col-md-9">
									<input type="text" id="m_manager" value="">
								</div>
							</div>
							<div class="row">
								<div class="col-md-3">연락처</div>
								<div class="col-md-9">
									<input type="text" id="m_phonenumber" value="">
								</div>
							</div>
							<div class="row">
								<div class="col-md-3">Email</div>
								<div class="col-md-9">
									<input type="text" id="m_email" value="">
								</div>
							</div>
							<div class="row">
								<div class="col-md-12 m_midtitle">추가정보</div>
							</div>
							<div class="row">
								<div class="col-md-3">심사점수</div>
								<div class="col-md-3">
									<a id="example" tabindex="0" data-toggle="popover" data-trigger="focus" data-content="숫자만 입력 가능합니다." >
									<input type="text" id="m_grade" value="" placeholder="1~100">
									</a>
								</div>
							</div>
							
								
							</div>
						</div>
						
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-info" id="adshopModal">쇼핑몰 등록</button>
						<button type="button" class="btn btn-danger" id="delAdShopModal">등록 취소</button>
						<button type="button" class="btn btn-info" id="modifyShopModal">저장</button>
						<button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>
					</div>
					
				</div>
				<!-- /.modal-content -->
			</div>
			<!-- /.modal-dialog -->
		</div>
<!-- modal --> 	
<br><br>
<br><br><br>
<br>
<div hidden="hidden">
신청날짜, 엑셀 다운로드, 메일등록/미등록 모달에서 셀렉트, 모달 연령대 select.
</div>
</body>
<%@ include file="../main/footer.jsp" %>
<script>

	$(document).ready(function(){
		$(".registered").html("등록");
		$(".unregistered").html("미등록");
	});



//모달창에 데이터 넣기
	$("#shopList .shopInfo").on("click", function(event){
			
		$(".modal-title").html($(this).parent().find(".s_sname").text());
		$("#m_image").attr("src","http://"+$(this).parent().find("#s_image").text());
		$("#m_num").html($(this).parent().find("#s_num").text());
		$("#m_shopstate").html($(this).parent().find("#shopstate").text());
		$("#m_sname").val($(this).parent().find(".s_sname").text());
		$("#m_shopurl").val($.trim($(this).parent().find("#s_shopurl").text()));
		$("#m_shopreg").html($(this).parent().find("#s_shopreg").text());
		//$("#m_age").attr("value",$(this).parent().find("#s_age").text());
		$("#m_searchurl").val($(this).parent().find("#s_searchurl").text());
		$("#m_manager").val($(this).parent().find("#s_manager").text());
		$("#m_phonenumber").val($(this).parent().find("#s_phonenumber").text());
		$("#m_email").val($.trim($(this).parent().find("#s_email").text()));
		$("#m_grade").val($(this).parent().find("#s_grade").text());
		
		
		//모달창의 옵션창 바꾸기(안됨)
		if($(this).parent().find("#s_age").html() === '10'){
			$("#m_age option").removeAttr("selected");
			$("#m_age [value='10']").attr("selected","selected");
		}else if($(this).parent().find("#s_age").html() === '20'){
			$("#m_age option").removeAttr("selected");
			$("#m_age [value='20']").attr("selected","selected");
		}else if($(this).parent().find("#s_age").html() === '30'){
			$("#m_age option").removeAttr("selected");
			$("#m_age [value='30']").attr("selected","selected");
		}else if($(this).parent().find("#s_age").html() === '40'){
			$("#m_age option").removeAttr("selected");
			$("#m_age [value='40']").attr("selected","selected");
		}
				
	});
	

//모달창에서 adshoppingmall 등록하기
	$("#adshopModal").on("click", function(){
		
		var inputGrade = $("#m_grade").val();
		var reg = /[A-Za-z가-힣]/g;
		if(reg.test(inputGrade) || inputGrade > 100){
			alert("심사 점수를 다시 입력하세요");
		}else{

			var shop = {};
			
			shop["s_num"] = $("#m_num").text();
			shop["s_manager"] = $("#m_manager").val();
			shop["s_shopurl"] = $("#m_shopurl").val();
			shop["s_searchurl"] = $("#m_searchurl").val();
			shop["s_shopreg"] = $("#m_shopreg").text();
			shop["s_sname"] = $("#m_sname").val();
			shop["s_email"] = $("#m_email").val();
			shop["s_age"] = $("#m_age option:selected").val();
			shop["s_phonenumber"] = $("#m_phonenumber").val();
			shop["s_image"] = $("#m_image").attr("src").substr(8);
			
			
			var jsonObj = {};
			jsonObj["shop"] = JSON.stringify(shop);
			jsonObj["s_grade"] = $("#m_grade").val();
			
			var checkState = $("#m_shopstate").html();
			
			if(checkState == "등록"){
				alert("이미 등록된 쇼핑몰입니다.");
			}else{
				
				$.ajax({
					type:'post',
					url:'/admin/shopModal',
					headers:{
						"Content-Type":"application/json"},
					dataType:'text',
					data: JSON.stringify(jsonObj),	
					success:function(result){
						alert("등록되었습니다.");
						$("#myModal").modal("hide");
						location.href="/admin/shopList";
					}
				});
				 
			}
		}
	});
	
	
	//리스트에서 adshoppingmall 등록하기
	$("#adShop").on("click",function(){
		if($("#shopList :checked").length<1){
			alert("쇼핑몰을 선택하세요");
		}else{
			var check = true;
			$("#shopList :checked").each(function(i,item){
				var checkState = $(this).parent().nextAll("#shopstate").text();
				if(checkState == "등록"){
					check=false;
				}
			});
			if(check){
				$("#adShopList").submit();
			}else{
				alert("다시 선택하세요");
			}
		};
	});

	
	//리스트에서 adshoppingmall 등록취소하기
	$("#delAdShop").on("click", function(){

		if($("#shopList :checked").length<1){
			alert("쇼핑몰을 선택하세요");
		}else{
			var check = true;
			$("#shopList :checked").each(function(i,item){
				var checkState = $(this).parent().nextAll("#shopstate").text();
				if(checkState == "미등록"){
					check=false;
				}
			});
			if(check){
				$("#adShopList").attr("action","/admin/deleteAdShop");
				$("#adShopList").submit();
			}else{
				alert("다시 선택하세요");
			}
		};
		
	});
	
	
	
//모달창에서 adshoppingmall 등록취소하기
	$("#delAdShopModal").on("click", function(){
		
		var s_num = $("#m_num").html();
		var checkState = $("#m_shopstate").html();
		
		if(checkState == "미등록"){
			alert("등록되지 않은 쇼핑몰입니다.");
		}else{
			$.ajax({
				type:'post',
				url:'/admin/deleteAdShopModal',
				headers:{
					"Content-Type":"application/json"},
				dataType:'text',
				data: JSON.stringify({s_num:s_num}),
				success:function(result){
					alert("등록 취소 되었습니다.");
					$(".modal").modal("hide");
					$("#myModal").modal("hide");
					location.href="/admin/shopList";
				}
			});
		}
	
	});
	
	//모달창에서 쇼핑몰 정보 수정
	$("#modifyShopModal").on("click", function(){
		
		var inputGrade = $("#m_grade").val();
		var reg = /[A-Za-z가-힣]/g;
		if(reg.test(inputGrade) || inputGrade > 100){
			alert("심사 점수를 다시 입력하세요");
		}else{
			var shop = {};
			
			shop["s_num"] = $("#m_num").text();
			shop["s_manager"] = $("#m_manager").val();
			shop["s_shopurl"] = $("#m_shopurl").val();
			shop["s_searchurl"] = $("#m_searchurl").val();
			shop["s_shopreg"] = $("#m_shopreg").text();
			shop["s_sname"] = $("#m_sname").val();
			shop["s_email"] = $("#m_email").val();
			shop["s_age"] = $("#m_age option:selected").val();
			shop["s_phonenumber"] = $("#m_phonenumber").val();
			shop["s_image"] = $("#m_image").attr("src");
			
			var jsonObj = {};
			jsonObj["shop"] = JSON.stringify(shop);
			jsonObj["s_grade"] = $("#m_grade").val();
			
			var checkState = $("#m_shopstate").html();
			
			$.ajax({
				type:'post',
				url:'/admin/modifyShopModal',
				headers:{
					"Content-Type":"application/json"},
				dataType:'text',
				data: JSON.stringify(jsonObj),	
				success:function(result){
					alert("등록되었습니다.");
					$("#myModal").modal("hide");
					location.href="/admin/shopList";
				}
	 		});
		}
		
	});
	
	
	//검색
	$("#searchBtn").on("click", function(event){
		self.location = "shopList"
						+'${page.makeQuery(1)}'
						+"&searchType="
						+$("select option:selected").val()
						+"&keyword="+$('#searchText').val();
						
	});
	
	$("input:radio").on("change", function(){
		$(".shopInfotr").removeClass("hidden");

		var checkedRadio = $("#searchRadio").find("input:radio:checked").attr("value");
		if(checkedRadio == "o"){
			$(".shopInfotr").removeClass("hidden");
			$(".unregistered").parent().addClass("hidden");
		}else if(checkedRadio == "x"){
			$(".shopInfotr").removeClass("hidden");
			$(".registered").parent().addClass("hidden");
		}else if(checkedRadio == "all"){
			$(".shopInfotr").removeClass("hidden");
		}

	});
	
	//모달창 닫을 때 age option 0으로 넣기
    $("#myModal").on("hide.bs.modal", function(){
		$("#m_age option").removeAttr("selected");
    	$("#m_age [value='0']").attr("selected","selected");
		$("#m_grade").removeAttr("disabled");
    });
	 	
	//심사점수 숫자인지 확인
	$("#m_grade").on("blur",function(){
		var inputGrade = $(this).val();
		var reg = /[A-Za-z가-힣]/g;
		if(reg.test(inputGrade) || inputGrade > 100){
			alert("심사 점수를 다시 입력하세요");
		}
	});

	//심사점수 옆에 팝오버 표시
 	$('#example').popover();


	
	</script>

    
</html>