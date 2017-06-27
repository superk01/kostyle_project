<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page import="kostyle.stats.domain.SearchKeywordChart"%>
<%@page import="java.util.List"%>
<%@ include file="statsSide.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="../resources/css/stats/stats.css">
<title>Insert title here</title>

</head>
<body>
        <div id="page-content-wrapper">
            <div class="container">
                <div class="row">
                    <div class="col-lg-8 col-lg-offset-2">
                    
<div id="statsbody">
<h3 class="page-header">연령대별 검색어 순위</h3>

<div class="table-responsive searchkeyRankTable">

<div id="searchAge1" class="searchAge">
<table class="table table-striped">
	<thead>
		<tr>
			<td></td>
			<td colspan="2">10대 검색어 순위</td>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${listTeen }" var="SearchKeywordChart" varStatus="status">
			<tr>
				<td>${status.index+1 }</td>
				<td>${SearchKeywordChart.sk_searchkey }</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
</div>


<div id="searchAge2" class="searchAge">
<table class="table table-striped">
	<thead>
		<tr>
			<td></td>
			<td colspan="2">20대 검색어 순위</td>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${listTwenty}" var="SearchKeywordChart" varStatus="status">
			<tr>
				<td>${status.index+1 }</td>
				<td>${SearchKeywordChart.sk_searchkey }</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
</div>

<div id="searchAge3" class="searchAge">
<table class="table table-striped">
	<thead>
		<tr>
			<td></td>
			<td colspan="2">30대 검색어 순위</td>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${listThirty}" var="SearchKeywordChart" varStatus="status">
			<tr>
				<td>${status.index+1 }</td>
				<td>${SearchKeywordChart.sk_searchkey }</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
</div>


</div>

</div>







                    </div>
                </div>
            </div>
        </div>
        <!-- /#page-content-wrapper -->

</body>

</html>