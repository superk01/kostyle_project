<%@page import="kostyle.stats.domain.SearchKeywordChart"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="statsSide.jsp" %>     
<%
	HttpSession searchkeyRankSession = request.getSession();
	
	List<SearchKeywordChart> list = (List) searchkeyRankSession.getAttribute("searchkeyRankingJ");
	List<SearchKeywordChart> list2 = (List) searchkeyRankSession.getAttribute("todayShopRankJ");
	
	

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="../resources/css/stats/stats.css">
<script type="text/javascript"></script>
<script src="../resources/js/jquery.js" type="text/javascript"></script>
<script src="../resources/js/stats/statsmain.js" type="text/javascript"></script>
</head>
<body>
        <!-- Page Content -->
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
						
						<div id="statsbody">
						
								<div class="table-responsive" id="searchkeyRankTableMain">
								<h3 class="page-header">검색어 순위<span>최근 7일</span></h3>
								
								<table class="table table-striped">
									<thead>
										<tr>
											<td></td>
											<td colspan="2">검색어</td>
										</tr>
									</thead>
									<tbody>
										<%for(int i=0;i<list.size();i++){ %>
										<tr>
											<td><%=i+1 %></td>
											<td><%=list.get(i).getSk_searchkey() %></td>
										</tr>
										<%} %>
									
									</tbody>
								</table>
								</div>
								
								<div class="table-responsive" id="todayShopRankTableMain">
								<h3 class="page-header">쇼핑몰 방문 순위<span>오늘</span></h3>
								
								<table class="table table-striped">
									<thead>
										<tr>
											<td></td>
											<td colspan="2">쇼핑몰</td>
										</tr>
									</thead>
									<tbody>
										<%for(int i=0;i<list2.size();i++){ %>
										<tr>
											<td><%=i+1 %></td>
											<td><%=list2.get(i).getS_sname() %></td>
										</tr>
										<%} %>
									
									</tbody>
								</table>
								</div>								
								

						</div>


                    </div>
                </div>
            </div>
        </div>
        <!-- /#page-content-wrapper -->
	

	
</body>
</html>