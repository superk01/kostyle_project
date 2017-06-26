<%@page import="kostyle.stats.domain.HitcountStatsChart"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	HttpSession statsVisitorSession = request.getSession();

	List<HitcountStatsChart> list = (List) statsVisitorSession.getAttribute("statsVisitorJ");
	
	int teenSum = 0;
	int twentySum = 0;
	int thirtySum = 0;
	
	for(int i=0;i<list.size();i++){
		teenSum += list.get(i).getTeen();
		twentySum += list.get(i).getTwenty();
		thirtySum += list.get(i).getThirty();
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
          var data_age = google.visualization.arrayToDataTable([
              ['AGE', 'Rate'],
              ['10대', <%=teenSum %>],
              ['20대', <%=twentySum %>],
              ['30대', <%=thirtySum %>]
            ]);
	      var options_age = {
	    		  chartArea:{top:10,width:'60%',height:'60%'},
	    		  legend : 'bottom'
	    		  };

      
     	 var chart_pie_age = new google.visualization.PieChart(document.getElementById('piechart'));
    	  chart_pie_age.draw(data_age, options_age);
      
    	  
    	  
    	  /* 꺾은선 차트 */
    	  var data = new google.visualization.DataTable();
          data.addColumn('string', 'Date');
          data.addColumn('number', '10대');
          data.addColumn('number', '20대');
          data.addColumn('number', '30대');
          data.addRows([
        	  <% for(int i=0;i<list.size();i++){%>
        	  ['<%=list.get(i).getCnt_date()%>' , <%=list.get(i).getTeen()%>, <%=list.get(i).getTwenty()%>,<%=list.get(i).getThirty()%>],
	          <%}%>
          ]);   


        var options = {
          title: '연령대별 방문자수',
          curveType: 'none',
          legend: { position: 'right' }
        };

        var chart = new google.visualization.LineChart(document.getElementById('curve_chart'));

        chart.draw(data, options);
      }
    </script>
</head>
   <body>
   
	<div id="statsVisitorFilter">
	<form action="../statsVisitor" method="post">
	<fieldset>
		<legend>필터</legend>
		<div>
			<label>쇼핑몰</label>
			<span>
				<input type="text" name="statsSearchShop" id="statsSearchShop">
			</span>
		</div>
		
		<div>
			<label>조회 기간</label>
			<span>
				<input type="date" name="statsSearchStartDate" id="statsSearchStartDate">~
				<input type="date" name="statsSearchEndDate" id="statsSearchEndDate">
			</span>
			
			<div class="btn-group js-dateperiod-statistics" id="dateOptGrp" data-toggle="buttons">
	            <label class="btn btn-white btn-sm hand ">
	                <input type="radio" name="searchPeriod" value="0">오늘
	            </label>
	            <label class="btn btn-white btn-sm hand ">
	                <input type="radio" name="searchPeriod" value="1">어제
	            </label>
	            <label class="btn btn-white btn-sm hand active">
	                <input type="radio" name="searchPeriod" value="7">7일
	            </label>
	            <label class="btn btn-white btn-sm hand ">
	                <input type="radio" name="searchPeriod" value="30">1개월
	            </label>
	            <label class="btn btn-white btn-sm hand ">
	                <input type="radio" name="searchPeriod" value="90">3개월
	            </label>
            </div>
			
		</div>
		
		<div>
			<span id="statsType">
				<label>
				<input type="radio" name="chartFor" value="gender">
				성별</label>&nbsp&nbsp&nbsp
				<label>
				<input type="radio" name="chartFor" value="age">
				연령별</label>&nbsp&nbsp&nbsp
				<label>
				<input type="radio" name="chartFor" value="adr">
				지역별</label>&nbsp&nbsp&nbsp
			</span>
		</div>
		
		<div id="statsSubmitbt">
			<a href="#" class="btn-header" id="statsSubmit">조회</a>
		</div>
	</fieldset>
	</form>
	</div>

	<br><br><br>
	<h3 class="page-header">연령대 비율</h3>
	<div id="piechartbox">
   		<div id="piechart" style="width:600px; height: 400px;"></div>
	</div>
   		
   		<div class="table-responsive">
            <table class="table table-striped">
              <thead>
                <tr>
                  <th colspan="2">연령대</th>
                  <th colspan="2">합계</th>
                </tr>
              </thead>
              <tbody>
                <tr>
                  <td colspan="2">10대</td>
                  <td colspan="2"><%=teenSum %></td>
                </tr>
                <tr>
                  <td colspan="2">20대</td>
                  <td colspan="2"><%=twentySum %></td>
                </tr>
                <tr>
                  <td colspan="2">30대</td>
                  <td colspan="2"><%=thirtySum %></td>
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
					<td>10대</td>
					<%for(int j=0;j<list.size();j++){ %>
					<td><%= list.get(j).getTeen()%></td>
					<%} %>
				</tr>
				<tr>
					<td>20대</td>
					<%for(int j=0;j<list.size();j++){ %>
					<td><%= list.get(j).getTwenty()%></td>
					<%} %>
				</tr>
				<tr>
					<td>30대</td>
					<%for(int j=0;j<list.size();j++){ %>
					<td><%= list.get(j).getThirty()%></td>
					<%} %>
				</tr>
			</tbody>
		</table>
	
	</div>
	
	<br><br><br><br>
  </body>
  


<script>

//날짜 선택 옆에 radio클릭하면 날짜 선택에 입력
	$("#dateOptGrp input:radio").on("change", function(){
		var getValue = $(this).val();
		var startObj = new Date();
		var endObj = new Date();
		
			
		var startDate = "";
		var endDate = "";
		
		if(getValue == "0"){
		}else if(getValue =="1"){
			startObj.setDate(startObj.getDate()-1);
			endObj.setDate(endObj.getDate()-1);
		}else if(getValue =="7"){
			startObj.setDate(startObj.getDate()-7);
			endObj.setDate(endObj.getDate()-1);
		}else if(getValue =="30"){
			startObj.setMonth(startObj.getMonth()-1);
			endObj.setDate(endObj.getDate()-1);
		}else if(getValue =="90"){
			startObj.setMonth(startObj.getMonth()-3);
			endObj.setDate(endObj.getDate()-1);
		}
		
		startDate = startObj.toISOString().substring(0,10);
		endDate = endObj.toISOString().substring(0,10);
 
		$("#statsSearchStartDate").val(startDate);
		$("#statsSearchEndDate").val(endDate);
		
	});
	
	
	
	$("#statsSubmit").on("click", function(){
		
		var statsOpt = {};
		statsOpt["statsSearchShop"] = $("#statsSearchShop").val();
		statsOpt["statsSearchStartDate"]=$("#statsSearchStartDate").val();
		statsOpt["statsSearchEndDate"]=$("#statsSearchEndDate").val();
		statsOpt["chartFor"]=$("#statsType").find("input:radio:checked").val();
		
		$.ajax({
			type:'post',
			url:'/stats/statsVisitor',
			headers:{
				"Content-Type":"application/json"},
			dataType:'text',
			data: JSON.stringify(statsOpt),
			success:function(result){
				location.href=result;
			}
		});
	});





</script>


  
  
  
</html>