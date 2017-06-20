<%@page import="kostyle.stats.domain.HitcountStatsChart"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	HttpSession statsVisitorSession = request.getSession();

	List<HitcountStatsChart> list = (List) statsVisitorSession.getAttribute("statsVisitorJ");
	
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="../resources/css/stats/stats.css">
<title>Insert title here</title>
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">
      google.charts.load('current', {'packages':['corechart']});
      google.charts.setOnLoadCallback(drawChart);
		
      function drawChart() {
          var data = new google.visualization.DataTable();
          data.addColumn('string', 'Date');
          data.addColumn('number', 'Seoul');
          data.addColumn('number', 'Busan');
          data.addColumn('number', 'Jeju');
          data.addRows([
        	  <% for(int i=0;i<list.size();i++){%>
	          ['<%=list.get(i).getCnt_date()%>' , <%=list.get(i).getSeoul()%>, <%=list.get(i).getBusan()%>, <%=list.get(i).getJeju()%>],
	          <%}%>
          ]);   


        var options = {
          title: '지역별 방문자수',
          curveType: 'none',
          legend: { position: 'right' }
        };

        var chart = new google.visualization.LineChart(document.getElementById('curve_chart'));

        chart.draw(data, options);
      }
    </script>
</head>
   <body>
   	<form action="../statsVisitor.ju" method="post">
	<fieldset>
		<legend>필터</legend>
		<div>
			<label>쇼핑몰</label>
			<span>
				<input type="text" name="statsSearchShop">
			</span>
		</div>
		
		<div>
			<label>조회 기간</label>
			<span>
				<input type="date" name="statsSearchStartDate">~
				<input type="date" name="statsSearchEndDate">
			</span>
		</div>
		
		<div>
			<span>
				<label>성별</label>
				<input type="radio" name="chartFor" value="gender">&nbsp&nbsp&nbsp
				<label>지역별</label>
				<input type="radio" name="chartFor" value="area">
			</span>
		</div>
		
		<div>
			<input type="submit" value="조회">
		</div>
	</fieldset>
	</form>


	<br><br><br>
   
    	<div id="curve_chart" style="width: 900px; height: 300px"></div>
	<br><br><br>
	
	<div id="statsTableDiv">
		<table class="statsTable">
			<thead>
				<tr class="statsTableThead">
					<th></th>
					<%for(int j=0;j<list.size();j++){ %>
					<th><%= list.get(j).getCnt_date()%></th>
					<%} %>
				</tr>
			</thead>
			<tbody class="statsTableTbody">
				<tr>
					<td>Seoul</td>
					<%for(int j=0;j<list.size();j++){ %>
					<td><%= list.get(j).getSeoul()%></td>
					<%} %>
				</tr>
				<tr>
					<td>Busan</td>
					<%for(int j=0;j<list.size();j++){ %>
					<td><%= list.get(j).getBusan()%></td>
					<%} %>
				</tr>
				<tr>
					<td>Jeju</td>
					<%for(int j=0;j<list.size();j++){ %>
					<td><%= list.get(j).getJeju()%></td>
					<%} %>
				</tr>
			</tbody>
		</table>
	
	</div>
	
	<br><br><br><br>
  </body>
</html>