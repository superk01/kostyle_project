<%@page import="kostyle.history.persistence.HistoyDAO"%>
<%@page import="kostyle.history.persistence.HistoryDAOImpl"%>
<%@page import="kostyle.help.persistence.BoardDAOImpl"%>
<%@page import="kostyle.login.domain.CustomerVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>리모콘</title>
<link rel="stylesheet" type="text/css" href="/resources/css/history/remocon.css?ver=1">
<script src="/resources/jquery/jquery-3.2.1.js"></script>

<script type="text/javascript">
<%Object userVO = session.getAttribute("login"); %>
<%CustomerVO customerVO = null; %>
<%String c_num = null; %>
<%if(userVO instanceof CustomerVO){ 
	customerVO = (CustomerVO)userVO; 
	c_num = customerVO.getC_num();
  }%>
  <%if(userVO != null){%>
	$(document).ready(function(){
		$.ajax({
			url:'/remocon/list/'+<%=c_num%>,
			type: 'get',
			headers:{
				"Content-Type":"application/json",
				"X-HTTP-Method-Override":"GET"
			},
			dataType:'text',
			success : function() {
				
			}
		});
	});
<%}%>
 $(document).ready(function(){
	 	var ind=0;
	 	$('ul').each(function(index){
	 		ind=index+1;
	 	});
	 	//이건 뭐하는 건지?
		/* 리모콘에서 히스토리 상품삭제. */
		/* 헤더에 include하고 삭제 버튼을 눌렀을때 컨트롤러가 호출되면 페이지가 리프레시 되는 문제가 있음. */
		 $('button.wing_btn_delete').on('click',function(){
			 var h_num=$(this).val();
			 $.ajax({
				url : "/history/delete?h_num="+h_num,
				type : 'get',
				headers:{
					"Content-Type":"application/json",
					"X-HTTP-Method-Override":"GET"
				},
				dataType:'text',
				success : function(){
					 location.href="/remocon/list/"+${login.c_num}; 
				}					
			});
			return false;
		});  
		
		/* 그래서 일단 스크립틀릿을 이용해보기로... */
		
		<%-- $('button.wing_btn_delete').on('click',function(){
			var h_num = $(this).val();
			<%HistoryDAOImpl dao = new HistoryDAOImpl();%>
			
			
			
					
		}); --%>
		 /* 클릭이벤트로 페이지(?)넘기는 코드 */
		 $('button.wing_btn_next').on('click',function(){
			
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
		 
/* 즐겨찾기 추가 버튼 */
	   $('.favorite_btn').on('click',function(e){
	      e.preventDefault();
	      var url = document.getElementById("shopViewIframe").src;
	      alert(url);
	      
	      self.location = "/favorite/addFavorite?s_shopurl="+url;
	      
	   });
});
		 
		

 

</script>
</head>
<body>
<div class="wing_fixed">
	<div id="wingBanner" class="wing_relative">
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
					<div id = "windRecnetPrdList" class="wing_prd_list">			<!-- 상품리스트 전체 -->
						<ul id = "1234" style="" class = "wingRecentPrd" >
							<c:forEach var="remocon" items="${remoconList }" varStatus="status" >	<!-- 1번리스트 그룹 -->
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
				<div class="buttons">
					<div class="btns">
						<div class="closet_btn">
							<button id="closet_btn">
								찜하기
							</button>
						</div>
						<div class="favorite_btn">
							<button id="favorite_btn">
								즐겨찾기
							</button>
						</div>
					</div>
					<div class = "btn_top">
						<a href="#">
							<img alt="페이지 상단으로 이동" src="/resources/images/historyImg/img_top.gif">
						</a>
					</div>
				</div>
			</c:if>
		</div>
	</div>
</div>
</body>
</html>