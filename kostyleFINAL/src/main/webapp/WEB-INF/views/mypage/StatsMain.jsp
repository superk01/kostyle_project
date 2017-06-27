<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="../main/kostyleHeader.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
    <link rel="stylesheet" type="text/css" href="/resources/css/mypage/MypageBody.css" />
    <link rel="stylesheet" type="text/css" href="/resources/css/mypage/MypageStats.css" />
</head>
<body>
<div id=hd></div>
<div id="page-content-wrapper">
	<div class="container">
	<jsp:include page="menu.jsp"/>
		<div class="row" id="contents">
			<div id="cont_area">

				<div class="listContainer" id="list1">
					<div class="listTitleContainer">
						<span class="listTitle">많이 본 상품</span>
					</div>
					<div class="listBody">
					
						<c:forEach items="${prdList }" var="CustomerStats" varStatus="status">
							<div class="listItemContainer">
								<span Class="listRank">${ status.index +1}</span>
								<span class="listImg"><img alt="" src="http:${ CustomerStats.h_imgurl}" width="138px" height="138px"></span>
								<span Class="listItem">${ CustomerStats.h_name}</span>
							</div>
						</c:forEach>
					

					</div>
				</div>



				<div class="listContainer" id="list2">
					<div class="listTitleContainer">
						<span class="listTitle">많이 검색한 키워드</span>
					</div>
					<div class="listBody">
					
						<c:forEach items="${searchKeyList }" var="CustomerStats" varStatus="status">
							<div class="listItemContainer">
								<span Class="listRank">${ status.index +1}</span>
								<span Class="listItem">${ CustomerStats.sk_searchkey}</span>
							</div>
						</c:forEach>
						
					</div>
				</div>



				<div class="listContainer" id="list3">
					<div class="listTitleContainer">
						<span class="listTitle">많이 방문한 쇼핑몰</span>
					</div>
					<div class="listBody">
					
						<c:forEach items="${shopList }" var="CustomerStats" varStatus="status">
							<div class="listItemContainer">
								<span Class="listRank">${ status.index +1}</span>
								<span Class="listItem">${ CustomerStats.s_sname}</span>
							</div>
						</c:forEach>

					</div>
				</div>

 	</div>
		</div>
	</div>
</div>
</body>
      <%@ include file="../main/footer.jsp" %>

</html>