<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css"	href="../../../resources/css/closet/closet.css" />
<script src="../../../resources/jquery/jquery-3.2.1.js"></script>
<script src="../../../resources/js/closet/closet.js"></script>

<script type="text/javascript"> 
$(function(){ //최초실행시 전체폴더로가도록. trig라는 속성을 주어서 액션에서 "not"주입.
	var trig = '<c:out value="${trig}"/>'; 
	if ( trig == "" ) {
	//	 alert("trig==공백");
		$('#0').trigger('click');
	}
});
</script>
<title>Insert title here</title>

</head>


<body id="closetBody">
	<div id="closetbackground">
		<div id="closetBodyTop"></div>
		<div id="closetContainer">
			<%-- <jsp:forward page = "../main/template.jsp">
	<jsp:param value="../closet/closet.jsp" name="body"/> --%>

			<!-- 테스트주소 -->

			<c:set var="trig" value="${requestScope.trig }"></c:set>
			<h1><%-- ${requestScope.trig }  || <c:out value="${trig}"/> --%>
				<img src="../resources/images/closetImg/closethanger.png"
					alt="옷장페이지">&nbsp;나만의 옷장
			</h1>
			<br>
			<nav id="closetNavi">

			<ul id="naviUL">
				<c:choose>
					<c:when test="${0 == select_clo_num || select_clo_num == null}">
						<li class="tabClick" id="0"><span class="tab_span_01"><img
								alt="" src="../resources/images/closetImg/checked-2.png"></span><span
							class="tab_span_02">전체상품</span></li>
					</c:when>
					<c:otherwise>
						<li class="tabClick" id="0">전체상품</li>
					</c:otherwise>
				</c:choose>
				<!-- 옷장 탭 Loop!!!!!!!!!!!!!!!!!!!!!!!! -->

				<c:forEach var="tab" items="${closetTab}">
					<c:set value="${tab.clo_num}" var="tab_clo_num" />
					<c:set value="${requestScope.select_clo_num}" var="select_clo_num" />
					<c:choose>

						<c:when test="${tab_clo_num == select_clo_num}">
							<li class="selectTab tabClick" id="${tab.clo_num }"><span
								class="tab_span_01"><img alt=""
									src="../resources/images/closetImg/checked-2.png"></span><span
								class="tab_span_02">${tab.clo_name }</span></li>
						</c:when>
						<c:otherwise>
							<li class="tabClick" id="${tab.clo_num }"><span
								class="tab_span_01"><img alt=""
									src="../resources/images/closetImg/folder.png"></span><span
								class="tab_span_02">${tab.clo_name }</span></li>
						</c:otherwise>
					</c:choose>
				</c:forEach>
				<li id="manage"><span>My옷장 관리</span><img id="manageImg" alt=""
					src="../resources/images/closetImg/btn_after_open.gif"></li>

			</ul>
			<form name="cloForm" id="cloForm" method="post">
				<input type="hidden" name="cloTabParam" id="cloTabParam" value="${requestScope.closetTab}">
			</form>
			</nav>

			<section id="prdSection">
			<div class="pickButton">
				<!-- 히든으로 c_num값을 보내야... 아니면 jstl로 c:set해놓고 스크립트에서 c:out으로 받을 수 있음.-->
				<input type="hidden" name="c_num" value="${sessionScope.c_num }">
				<input type="hidden" name="clo_num" value="${requestScope.clo_num }">
				<input type="checkbox" class="check" id="checkAll" value="0"
					name="check" style="display: none" />
				<button type="button" value="전체선택" id="checkAllBtn">전체선택</button>
				<button type="button" value="삭제" id="deleteBtn">상품삭제</button>
				<button type="button" value="이동" id="moveBtn1">폴더이동</button>
			</div>

			<!-- 이동폴더선택란 접었다폈다토글 -->
			<div id="hidden_move_prd">
				<ul>
					<li class="move_prd_li" id="move_prd_navi"><span>이동할 폴더
							선택</span>
						<button id="moveBtn2">이동</button></li>
					<c:forEach var="tab" items="${closetTab}">
						<li class="move_prd_li"><input type="radio" name="selet_move"
							value="${tab.clo_num }"><span>${tab.clo_name }</span></li>
					</c:forEach>
				</ul>
			</div>


			<ul id="prdUL">
				<!-- 상품Loop !!!!!!!!!!!!!!!!!!!!!!!! -->
				<c:set var="listLength" value="${fn:length(cloList)}"></c:set>
				<c:forEach var="closetPrd" items="${cloList }" varStatus="status">
					<li class="onePrd">
						<div>
							<div class="numCheck">
								<!-- 체크박스 들어갈 공간 -->
								&nbsp<em class="pickNum">${(listLength)-(status.index)}.</em> 
								<input type="checkbox" class="check"
									value="${closetPrd.clo_detail_num }" name="check" />
								${closetPrd.clo_name }
								<span style= "display:none">${closetPrd.clo_num}</span>
							</div>
							<div class="prdPhoto">
								<!-- 이미지and URL -->
								<a href="http://${closetPrd.clo_prdUrl}"><img
									src="${closetPrd.clo_imgUrl }"></a>
							</div>
							<div class="introPrd">
								<div class="prdName">
									<a href="http://${closetPrd.clo_prdUrl}">${closetPrd.clo_prdName }</a>
									<!-- 상품이름 -->
								</div>
								<div class=prdPrice>
									<img alt="" src="../resources/images/closetImg/won_green01.png">
									${closetPrd.clo_price }
									<!--  할 수 있으면 가격 -->
								</div>
								<div class=prdPickNum>
									<img alt=""
										src="../resources/images/kostyle_icon/031-heart.png">
									${closetPrd.clo_zzim  }
									<!--  상품 찜갯수도 가능하면 -->
								</div>
								<div class=shopName>${closetPrd.s_sname }</div>
								<!-- 쇼핑몰이름 -->
							</div>
						</div>
					</li>
				</c:forEach>

			</ul>
		</div>
		<div id="test"></div>
</body>
</html>