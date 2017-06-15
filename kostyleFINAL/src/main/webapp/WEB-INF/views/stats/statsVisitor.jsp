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
	<div id="statsVisitorFilter">
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
				<input type="radio" name="chartFor" value="gender">
				<label>성별</label>&nbsp&nbsp&nbsp
				<input type="radio" name="chartFor" value="age">
				<label>연령별</label>&nbsp&nbsp&nbsp
				<input type="radio" name="chartFor" value="area">
				<label>지역별</label>
			</span>
		</div>
		
		<div>
			<input type="submit" value="조회">
		</div>
	</fieldset>
	</form>
	</div>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
</body>
</html>