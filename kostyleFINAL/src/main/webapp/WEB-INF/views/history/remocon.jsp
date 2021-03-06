<%@page import="kostyle.login.domain.CustomerVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>리모콘</title>
<!-- <link rel="stylesheet" type="text/css" href="/resources/css/history/remocon.css">
<script src="/resources/jquery/jquery-3.2.1.js"></script> -->


<script type="text/javascript">
<%-- <%Object userVO = session.getAttribute("login"); %>
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
<%}%> --%>
 $(document).ready(function(){
	 	var ind=0;
	 	$('ul').each(function(index){
	 		ind=index+1;
	 	})//이건 뭐하는 건지?
		/* 리모콘에서 히스토리 상품삭제. */
		/*  $('button.wing_btn_delete').on('click',function(){
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
						location.href="/remocon/list/"+${login.c_num}; 
					}
				}					
			});
			return false;
		}); */ 
		
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
	      var url1 = document.getElementById("CategorysearchIframe").src;
	      
	      var url2 = url1.substring(7);
	      var url3 = url2.split('/');
	      var url4 = url3[0]+"/";
	      //alert(url4);
	      
	      self.location = "/favorite/addFavorite?s_shopurl="+url4;
	      
	   });
	
});
 /* 찜상품추가 버튼 */

 $(function(){
    $('#closet_btn').on('click',function(){
       var ajaxNum = -1; //연쇄적ajax를 위한 기반변수
       var prdUrl = $('#CategorysearchIframe').attr('src');
/*        var prdUrl = "http:"+$('#CategorysearchIframe').attr('src'); */
       //alert("아이프레임에서 따온 상품url: "+prdUrl);
       
       var currentUrl = document.location.href;
       //alert("currentUrl: "+currentUrl);

       //즐겨찾기 등 아이프레임은있는데 상품이 없는 경우
       var prdNameVal = $('input#prdName').val();
       
       
       var param = "prdUrl="+prdUrl+"&currentUrl="+currentUrl;
       if(prdUrl == undefined){
          alert("찜할 상품이 존재하지 않습니다.");
       }else if(prdNameVal == undefined || prdNameVal == null){
          alert("찜할 상품이 존재하지 않습니다.");
       } else{
    	   
    	   
         /*  prdUrl = "prdUrl="+prdUrl; */
          
          //ajax를 비동기식(async : false)으로 사용해서 뒤의 ajax연쇄실행
          $.ajax({
              headers: { 
                     'Accept': 'application/json',
                     'Content-Type': 'application/json; charset=UTF-8'
                 },
             type: "post",
             url: "/closet/duplicationCheckClosetPrd",
/*              data : {
                 prdUrl : prdUrl
                   }, */
              data : JSON.stringify({
            	  prdUrl_Map : prdUrl
                   }), 
             async: false,
             success: function(data){
                //alert("ajax중복회신결과: "+data);
                if(data >0){
                   alert("이미 찜한 상품입니다♥");
                }else if(data==0){
                   ajaxNum = data;
                   ////alert("ajaxNum?: "+ajaxNum);
                }
             },
             error: function(data){
             //   //alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);

             }
          });
          
          var prdName = $('#prdName').val();
          //alert("if진입직전ajaxNum?: "+ajaxNum);
          if(ajaxNum == 0){
             //alert("ajaxNum == 0.중복없음ajax if진입");
             //alert(prdName);
             ////alert("insertAjax함수 진입.");
             $.ajax({
                headers: { 
                     'Accept': 'application/json',
                     'Content-Type': 'application/json; charset=UTF-8'
                 },
                type:"post",
                url:"/closet/insertPrd",
                data : JSON.stringify({
                   prdUrl : prdUrl,
                   currentUrl : currentUrl,
                   prdName : prdName
                   }),
                success: function(result){
                   ////alert("insertAjax결과: "+result);
                   if(result == 1 || result.equals("1")){
                      alert("해당상품이 옷장에 추가되었습니다");
                   }else{
                      alert("찜추가실패");
                   }
                },
                error: function(data){
             //      //alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
                }
             });
             ////alert("insertAjax함수 끝.");
             
          }
       }
       
    });
 });
		 
		

 

</script>
</head>
<body>
<div class="wing_fixed">
	<div id="wingBanner" class="wing_relative">
		<c:if test="${not empty login }">
			<div id = "wingBanner" class = "wing_banner"> <!-- 리모콘 전제 -->
				<!-- //최근 본 상품 -->
				<div id = "wingRecentWrap" class = "wing_prd_wrap" style = ""> <!-- 리모콘 외부 -->
					<div class="hwrap">											<!-- 히스토리로 이동 -->
						<strong class = "tit">
							<a id = "wingRecentCount" href = "/history/list/${login.c_num }">				
								<span class = "tx" style="font-size: 11px;">최근 본상품</span>
								<span class="count">${history_Num }</span>				<!-- 최대상품은 15개까지. -->
								<span class = "ico"></span>	
							</a>
						</strong>
					</div>
					<div id = "wingRecnetPrdList" class="wing_prd_list">			<!-- 상품리스트 전체 -->
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
							<button id = "wb_btn_recentPrd_prev" class="wing_btn_prev" type="button" style="border: 0px;">이전 상품 목록</button>
							<button id = "wb_btn_recentPrd_next" class="wing_btn_next" type="button" style="border: 0px;">다음 상품 목록</button>
						</div>
					</div>
				</div>
				<div class="buttons">
					<div class="btns">
						<div class="closet_btn">
							<button id="closet_btn" style="border: 0px;">
								찜하기
							</button>
						</div>
						<div class="favorite_btn">
							<button id="favorite_btn" style="border: 0px;">
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