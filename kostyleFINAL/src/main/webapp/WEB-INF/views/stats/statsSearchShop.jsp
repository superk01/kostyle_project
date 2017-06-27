<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page import="kostyle.stats.domain.SearchKeywordChart"%>
<%@page import="java.util.List"%>
<%@ include file="statsSideShop.jsp" %>
<%
	HttpSession searchkeyRankSession = request.getSession();
	
	List<SearchKeywordChart> list = (List) searchkeyRankSession.getAttribute("searchkeyRankingJ");
	List<SearchKeywordChart> chart = (List) searchkeyRankSession.getAttribute("searchkeyRankChartJ");

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
 	  
    	  /* 꺾은선 차트 */
    	  var data = new google.visualization.DataTable();
          data.addColumn('string', 'Date');
          <% for(int i=0;i<list.size();i++){%>
          data.addColumn('number', '<%=list.get(i).getSk_searchkey()%>');
          <%}%>
          data.addRows([
        	  <% for(int i=0;i<chart.size();i++){%>
        	  ['<%=chart.get(i).getCnt_date()%>' , 
        	  	<%=chart.get(i).getSk1()%>, 
        	  	<%=chart.get(i).getSk2()%>, 
        	  	<%=chart.get(i).getSk3()%>, 
        	  	<%=chart.get(i).getSk4()%>, 
        	  	<%=chart.get(i).getSk5()%>, 
        	  	<%=chart.get(i).getSk6()%>, 
        	  	<%=chart.get(i).getSk7()%>, 
        	  	<%=chart.get(i).getSk8()%>
        	  	],
	          <%}%>
          ]);   


        var options = {
          curveType: 'none',
          legend: { position: 'bottom' }
        };

        var chart = new google.visualization.LineChart(document.getElementById('curve_chart'));

        chart.draw(data, options);
      }
      
      </script>
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
                    
<div id="statsbody">
<h3 class="page-header">검색어 순위</h3>

<div class="table-responsive" id="searchkeyRankTable">
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

<div id="curve_chart" style="width: 900px; height: 340px"></div>
</div>







                    </div>
                </div>
            </div>
        </div>
        <!-- /#page-content-wrapper -->

</body>

<script>

$(document).ready(function(){

	$.ajax({
		type:'post',
		url:'/stats/statsSearch',
		success:function(result){
			alert(result);

		}
	});
	
});


</script>
</html>