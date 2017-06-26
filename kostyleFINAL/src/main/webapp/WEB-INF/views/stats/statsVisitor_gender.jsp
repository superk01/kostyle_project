<%@page import="kostyle.stats.domain.HitcountStatsChart"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="statsVisitor.jsp" %>    
<%
	HttpSession statsVisitorSession = request.getSession();

	List<HitcountStatsChart> list = (List) statsVisitorSession.getAttribute("statsVisitorJ");
	
	int fSum = 0;
	int mSum = 0;
	
	for(int i=0;i<list.size();i++){
		fSum += list.get(i).getFemale();
		mSum += list.get(i).getMale();
	}
	
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="../resources/css/stats/stats.css">
<link rel="stylesheet" type="text/css" href="../resources/css/stats/dashboard.css">
<title>Insert title here</title>
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">
      google.charts.load('current', {'packages':['corechart']});
      google.charts.setOnLoadCallback(drawChart);
		
      
      function drawChart() {
    	  
    	  /* 원형차트 */
          var data2 = google.visualization.arrayToDataTable([
              ['Gender', 'Rate'],
              ['Female', <%=fSum %>],
              ['Male', <%=mSum %>]
            ]);
	      var options2 = {
	    		  chartArea:{top:10,width:'60%',height:'60%'},
	    		  legend : 'bottom'
	    		  };

      
     	 var chart_pie = new google.visualization.PieChart(document.getElementById('piechart'));
    	  chart_pie.draw(data2, options2);
      
    	  
    	  
    	  /* 꺾은선 차트 */
    	  var data = new google.visualization.DataTable();
          data.addColumn('string', 'Date');
          data.addColumn('number', 'Female');
          data.addColumn('number', 'Male');
          data.addRows([
        	  <% for(int i=0;i<list.size();i++){%>
	          ['<%=list.get(i).getCnt_date()%>' , <%=list.get(i).getFemale()%>, <%=list.get(i).getMale()%>],
	          <%}%>
          ]);   


        var options = {
          title: '성별 방문자수',
          curveType: 'none',
          legend: { position: 'right' }
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
						
   

	<br><br><br>
	<h3 class="page-header">남녀 비율</h3>
	<div id="piechartbox">
   		<div id="piechart" style="width:600px; height: 400px;"></div>
	</div>
   		
   		<div class="table-responsive">
            <table class="table table-striped">
              <thead>
                <tr>
                  <th colspan="2">성별</th>
                  <th colspan="2">합계</th>
                </tr>
              </thead>
              <tbody>
                <tr>
                  <td colspan="2">여성</td>
                  <td colspan="2"><%=fSum %></td>
                </tr>
                <tr>
                  <td colspan="2">남성</td>
                  <td colspan="2"><%=mSum %></td>
                </tr>
              </tbody>
            </table>
          </div>
	<br><br><br>
	<br><br><br>
	<br><br><br>
	<br><br><br>
	<br><br><br>
	<h3 class="page-header">일자별 방문자수</h3>
    	<div id="curve_chart" style="width: 1200px; height: 300px"></div>
	<br><br><br>
	
	<div class="table-responsive">
		<table class="statsTable table table-striped">
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
					<td>Female</td>
					<%for(int j=0;j<list.size();j++){ %>
					<td><%= list.get(j).getFemale()%></td>
					<%} %>
				</tr>
				<tr>
					<td>Male</td>
					<%for(int j=0;j<list.size();j++){ %>
					<td><%= list.get(j).getMale()%></td>
					<%} %>
				</tr>
			</tbody>
		</table>
	
	</div>
	

                    </div>
                </div>
            </div>
        </div>
        <!-- /#page-content-wrapper -->
  </body>
  



  
  
  
</html>