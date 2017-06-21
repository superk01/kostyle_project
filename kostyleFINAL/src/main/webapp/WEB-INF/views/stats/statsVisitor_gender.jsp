<%@page import="kostyle.stats.domain.HitcountStatsChart"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
				<input type="radio" name="chartFor" value="area">
				지역별</label>
			</span>
		</div>
		
		<div id="statsSubmitbt">
			<a href="#" class="btn-header" id="statsSubmit">조회</a>
		</div>
	</fieldset>
	</form>
	</div>

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
				location.href='/stats/statsSide?statsbody=statsVisitor_gender.jsp';
			}
		});
	});





</script>


  
  
  
</html>