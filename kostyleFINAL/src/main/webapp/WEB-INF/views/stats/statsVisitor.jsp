<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="../resources/css/stats/stats.css">
</head>
<body>
		조회 단위
		<br><br><br><br>
	<h3 class="page-header">일자별 방문자수</h3>
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
	<br>
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