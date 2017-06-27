<%@page import="kostyle.stats.domain.HitcountStatsChart"%>
<%@page import="kostyle.stats.domain.SearchKeywordChart"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="statsSideShop.jsp" %>     
<%
	HttpSession searchkeyRankSession = request.getSession();
	
	List<SearchKeywordChart> list = (List) searchkeyRankSession.getAttribute("searchkeyRankingJ");
	List<HitcountStatsChart> agelist = (List) searchkeyRankSession.getAttribute("statsVisitorShopAgeJ");
	List<HitcountStatsChart> genderlist = (List) searchkeyRankSession.getAttribute("statsVisitorShopGenderJ");
	List<HitcountStatsChart> arealist = (List) searchkeyRankSession.getAttribute("statsVisitorShopAreaJ");
	
	int seoulSum = 0;
	int jejuSum = 0;
	int jeonlaSum = 0;
	int kyoungsangSum = 0;
	int chungcheongSum = 0;
	int kangwonSum = 0;
	int kyounggiSum = 0;
	int incheonSum = 0;
	
	for(int i=0;i<arealist.size();i++){
		seoulSum += arealist.get(i).getSeoul();
		jejuSum += arealist.get(i).getJeju();
		jeonlaSum += arealist.get(i).getJeonla();
		kyoungsangSum += arealist.get(i).getKyoungsang();
		chungcheongSum += arealist.get(i).getChungcheong();
		kangwonSum += arealist.get(i).getKangwon();
		kyounggiSum += arealist.get(i).getKyounggi();
		incheonSum += arealist.get(i).getIncheon();
	}
	
	int fSum = 0;
	int mSum = 0;
	
	for(int i=0;i<genderlist.size();i++){
		fSum += genderlist.get(i).getFemale();
		mSum += genderlist.get(i).getMale();
	}
	
	int teenSum = 0;
	int twentySum = 0;
	int thirtySum = 0;
	
	for(int i=0;i<agelist.size();i++){
		teenSum += agelist.get(i).getTeen();
		twentySum += agelist.get(i).getTwenty();
		thirtySum += agelist.get(i).getThirty();
	}	
	
	
	
	HttpSession loginSession = request.getSession();

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
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">
      google.charts.load('current', {'packages':['corechart']});
      google.charts.setOnLoadCallback(drawChart);
		
      
      function drawChart() {
 	 	  
    	  /* 지역원형차트 */
          var data2 = google.visualization.arrayToDataTable([
              ['지역', 'Rate'],
              ['서울', <%=seoulSum %>],
              ['경기', <%=kyounggiSum %>],
              ['인천', <%=incheonSum %>],
              ['충청', <%=chungcheongSum %>],
              ['강원', <%=kangwonSum %>],
              ['경상', <%=kyoungsangSum %>],
              ['전라', <%=jeonlaSum %>],
              ['제주', <%=jejuSum %>]
            ]);
    	  
	      var options2 = {
	    		  chartArea:{top:10,width:'60%',height:'60%'},
	    		  legend : 'bottom'
	    		  };
      
     	 var chart_pie = new google.visualization.PieChart(document.getElementById('piechart'));
    	  chart_pie.draw(data2, options2);

    	  
    	  /* 성별원형차트 */
           var datagender = google.visualization.arrayToDataTable([
              ['Gender', 'Rate'],
              ['Female', <%=fSum %>],
              ['Male', <%=mSum %>]
            ]);
	      var optionsgender = {
	    		  chartArea:{top:10,width:'60%',height:'60%'},
	    		  legend : 'bottom'
	    		  };

      
     	 var chart_pie = new google.visualization.PieChart(document.getElementById('piechartgender'));
    	  chart_pie.draw(datagender, optionsgender);
   	  
    	  
    	  /* 연령원형차트 */
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

      
     	 var chart_pie_age = new google.visualization.PieChart(document.getElementById('piechartage'));
    	  chart_pie_age.draw(data_age, options_age);
    	  
      }
    </script>
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
	<h3 class="page-header">방문자수 요약<span>최근 7일</span></h3>
						
	<div id="piechartbox">
	<h3 class="page-header">지역별 비율</h3>
   		<div id="piechart" style="width:350px; height: 400px;"></div>
	</div>						
						
	<div id="piechartbox">
	<h3 class="page-header">남녀 비율</h3>
   		<div id="piechartgender" style="width:350px; height: 400px;"></div>
	</div>						
						
	<div id="piechartbox">
	<h3 class="page-header">연령대 비율</h3>
   		<div id="piechartage" style="width:350px; height: 400px;"></div>
	</div>						
						
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
								
								
								

						</div>


                    </div>
                </div>
            </div>
        </div>
        <!-- /#page-content-wrapper -->
	

	
</body>
</html>