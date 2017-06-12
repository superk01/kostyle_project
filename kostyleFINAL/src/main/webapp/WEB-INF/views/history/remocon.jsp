<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%-- <%@ include file="../main/kostyleHeader.jsp" %> --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>리모콘</title>
<link rel="stylesheet" type="text/css" href="/resources/css/history/remocon.css">
<script src="../../../resources/jquery/jquery-3.2.1.js"></script>
<script type="text/javascript">

/* function fn_deleteHistory(){
	location.href = "deleteAction.history?h_num=${remocon.h_Num}&c_num=${c_Num}"
}
 */
 $(document).ready(function(){
	 
	 	/* if(${not empty login}){
	 		self.location ="/remocon/list/${login.c_num}"; 
	 		$.ajax({
	 			url : "/remocon/list/${login.c_num}",
	 			type: 'get',
	 			headers: {
	 				"Content-Type":"application/json",
					"X-HTTP-Method-Override":"GET"
	 			},
	 			dataType:'text',
	 			success: function(data){
	 				if(data=="success"){
	 					alert("컨트롤러 로직 처리 완료!!!");
	 				}
	 			}
	 		})
	 	} */
 
		/* 리모콘에서 히스토리 상품삭제. */
	 	var ind=0;
	 	$('ul').each(function(index){
	 		ind=index+1;
	 	})//이건 뭐하는 건지?
	 	console.log(ind);
		 $('button.wing_btn_delete').on('click',function(){
			 var h_num=$(this).val();
			 $.ajax({
				url : "${path}/history/delete?h_num="+h_num,
				type : 'get',
				headers:{
					"Content-Type":"application/json",
					"X-HTTP-Method-Override":"GET"
				},
				dataType:'text',
				success : function(){
					/* alert('success'); */
					location.href="${path}/remocon/list/"+${login.c_num};
				}					
			});
			return false;
		}); 
		 /* $('.wing_btn_next').on('click', function(){
			 alert($('#wingRecentPrd').size);
			 var index=0;
			 for(int i=0; i<$('#wingRecentPrd').size; i++){
				 alert("for문");
				 if($('#wingRecentPrd').eq(i).attr('class')!=disable){
					 alert("if문");
					 index=i;
					 alert(index);
				 }
				
			 }
			 $('#wingRecentPrd').eq(index).setAttribute('class', disable);
			 $('#wingRecentPrd').eq(index+1).setAttribute('class', "");
			 
			 
		 }); */
		 
		 $('button.wing_btn_next').on('click',function(){
			 /* alert("1111"); */
			 /* if(int i=0; i<5; i++){
			 console.log($('.wingRecentPrd').eq(i).attr('id'));
			  alert($('#wingRecentPrd').eq(1).attr('class')); 
			 } */
			 /* alert($('.wingRecentPrd').eq(1).attr('style')); */
			 var index = 0;
			 for(var i=-1; i<ind; i++){
				if($('.wingRecentPrd').eq(i).attr('style')!='display:none'){
					 index = i;
					 console.log('index'+index);
					 break;
				};
			 };
			 $('.wingRecentPrd').eq(index).attr('style',"display:none");
			 $('.wingRecentPrd').eq(index+1).attr('style',"");
			
		 });
		 $('button.wing_btn_prev').on('click',function(){
			var index = 0;
			for(var i=0; i<ind; i++){
				if($('.wingRecentPrd').eq(i).attr('style')!='display:none'){
					 index = i;
					 break;
				};
			};
			 $('.wingRecentPrd').eq(index).attr('style',"display:none");
			 $('.wingRecentPrd').eq(index-1).attr('style',"");
		 });
		 
		});


</script>
</head>
<body>
<c:if test="${not empty login }">
<div id = "windBanner" class = "wing_banner"> <!-- 리모콘 전제 -->
	<!-- //최근 본 상품 -->
	<div id = "wingRecentWrap" class = "wing_prd_wrap" style = ""> <!-- 리모콘 외부 -->
		<div class="hwrap">											<!-- 히스토리로 이동 -->
			<strong class = "tit">
				<a id = "wingRecentCount" href = "/history/list/${c_num }">				
					<span class = "tx">최근 본상품</span>
					<span class="count">${history_Num }</span>				<!-- 최대상품은 15개까지. -->
					<span class = "ico"></span>	
				</a>
			</strong>
		</div>
		
		
		<%-- <div id = "windRecnetPrdList" class="wing_prd_list">			<!-- 상품리스트 전체 -->
			<c:forEach var="outerList" items="${outerList }" varStatus="status">
				<ul id = "wingRecentPrd_" style="" class = "">						<!-- 1번리스트 그룹 -->
					<c:forEach var="remocon" items="${outerList.ListModel }" >
					<li id = "1-1" class="wing_prd" >						<!-- 1번그룹의 첫번째 상품 -->
						<a href="${remocon.h_Prdurl }" target="_blank">					<!-- 해당상품의 상세페이지 주소 -->
							<span class="wing_prd_img">
								<img alt="" src="${remocon.h_Imgurl }">
							</span>
							<span class="wing_prd_info">					<!-- 상품의 정보 -->
								<span class="p_name">${remocon.h_Name }</span>	<!-- 상품의 이름? -->
							</span>
						</a>				
						<button class="wing_btn_delete" value="${remocon.h_Num }">상품제거 버튼</button>
					</li>
					</c:forEach>	
				</ul>
			</c:forEach>
		
		</div>	 --%>
		
		
		<div id = "windRecnetPrdList" class="wing_prd_list">			<!-- 상품리스트 전체 -->
		
			<ul id = "1234" style="" class = "wingRecentPrd" >
		
									<!-- 1번리스트 그룹 -->
					<c:forEach var="remocon" items="${remoconList }" varStatus="status" >
					
					<li id = "${Math.floor((status.index)/3)+1 }-${(status.index)%3+1 }" class="wing_prd" >						<!-- 1번그룹의 첫번째 상품 -->
						<a href="${remocon.h_Prdurl }" target="_blank">					<!-- 해당상품의 상세페이지 주소 -->
							<span class="wing_prd_img">
								<img alt="" src="${remocon.h_Imgurl }">
							</span>
							<span class="wing_prd_info">					<!-- 상품의 정보 -->
								<span class="p_name">${remocon.h_Name }</span>	<!-- 상품의 이름? -->
							</span>
						</a>				
						<button class="wing_btn_delete" value="${remocon.h_Num }">상품제거 버튼</button>
					</li>
					<c:if test="${(status.index%3)+1==3 }" >
						</ul><ul style="display:none" class="wingRecentPrd" id="${Math.floor((status.index)+1/3) }"> 
					</c:if>
					</c:forEach>
						
				</ul>
		</div>
		<div class="wing_paging">
			<div class="wing_btn">
				<button id = "wb_btn_recentPrd_prev" class="wing_btn_prev" type="button">이전 상품 목록</button>
				<button id = "wb_btn_recentPrd_next" class="wing_btn_next" type="button">다음 상품 목록</button>
			</div>
		</div>
	</div>
	<div>
		<div>
		<button id="closet_btn">
			찜하기
		</button>
		</div>
		<div>
		<button >
			즐겨찾기
		</button>
		</div>
	</div>
	<div class = "btn_top">
		<a href="#">
			<img alt="페이지 상단으로 이동" src="/resources/images/historyImg/img_top.gif">
		</a>
	</div>
</c:if>
</body>
</html>