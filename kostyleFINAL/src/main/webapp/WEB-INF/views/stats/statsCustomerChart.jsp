<%@page import="kostyle.stats.domain.CustomerStats"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="statsCustomer.jsp" %>
<%
	HttpSession statsCustomerSession = request.getSession();
	
	List<CustomerStats> searchKeyList= (List) statsCustomerSession.getAttribute("customerStatsSearchKeyAllJ");
	List<CustomerStats> shopList= (List) statsCustomerSession.getAttribute("customerStatsShopAllJ");
	List<CustomerStats> prdList= (List) statsCustomerSession.getAttribute("customerStatsPrdAllJ");

%>
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
						
							<%for(int i=0;i<prdList.size();i++){ %>
							<div class="listItemContainer">
								<span class="listRank"><%= i+1%></span>
								<span class="listImg"><img alt="" src="http:<%=prdList.get(i).getH_imgurl() %>" width="138px" height="138px"></span>
								<span Class="listItem"><%=prdList.get(i).getH_name() %></span>
							</div>
							<%} %>

						</div>
					</div>
				</div>



				<div class="listContainer">
					<div class="listTitleContainer">
						<span class="listTitle">많이 검색한 키워드</span>
						<div class="listBody">
						
							<%for(int i=0;i<prdList.size();i++){ %>
							<div class="listItemContainer">
								<span class="listRank"><%= i+1%></span>
								<span Class="listItem"><%=searchKeyList.get(i).getSk_searchkey() %></span>
							</div>
							<%} %>

						</div>
					</div>
				</div>



				<div class="listContainer">
					<div class="listTitleContainer">
						<span class="listTitle">많이 방문한 쇼핑몰</span>
						<div class="listBody">
						
							<%for(int i=0;i<prdList.size();i++){ %>
							<div class="listItemContainer">
								<span class="listRank"><%= i+1%></span>
								<span Class="listItem"><%=shopList.get(i).getS_sname() %></span>
							</div>
							<%} %>

						</div>
					</div>
				</div>


			</div>
		</div>
	</div>
</div>
</body>

</html>