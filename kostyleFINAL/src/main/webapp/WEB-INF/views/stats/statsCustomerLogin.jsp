<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="../main/kostyleHeader.jsp"%>
<%@ include file="statsCustomer.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<div id="page-content-wrapper">
	<div class="hamburgerSticky">
		<button type="button" class="hamburger is-closed" data-toggle="offcanvas">
			<span class="hamb-top"></span>
			<span class="hamb-middle"></span>
			<span class="hamb-bottom"></span>
		</button>
	</div>
	<div class="container">
		<div class="row">
			<div class="col-lg-8 col-lg-offset-2">

				<div class="listContainer">
					<div class="listTitleContainer">
						<span class="listTitle">많이 본 상품</span>
						<div class="listBody">
						
							<c:forEach items="${searchKeyList }" var=CustomerStats>
								<div class="listItemContainer">
									<span class="listImg"><img alt="" src="http:${ CustomerStats.h_prdurl}" width="138px" height="138px"></span>
									<span Class="listItem">${ CustomerStats.h_name}</span>
								</div>
							</c:forEach>
						

						</div>
					</div>
				</div>



				<div class="listContainer">
					<div class="listTitleContainer">
						<span class="listTitle">많이 검색한 키워드</span>
						<div class="listBody">
						
							<c:forEach items="${shopList }" var=CustomerStats>
								<div class="listItemContainer">
									<span Class="listItem">${ CustomerStats.sk_searchkey}</span>
								</div>
							</c:forEach>
							
						</div>
					</div>
				</div>



				<div class="listContainer">
					<div class="listTitleContainer">
						<span class="listTitle">많이 방문한 쇼핑몰</span>
						<div class="listBody">
						
							<c:forEach items="${prdList }" var=CustomerStats>
								<div class="listItemContainer">
									<span Class="listItem">${ CustomerStats.prdList}</span>
								</div>
							</c:forEach>

						</div>
					</div>
				</div>


			</div>
		</div>
	</div>
</div>
</body>

</html>