<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="../resources/css/main/header.css" />
<title>Insert title here</title>
<script type="text/javascript" src="../resources/js/main/logindetail.js"></script>
</head>

<body>
<div id="heads">

	<div class="logo_field">
		<a href="template.jsp?body=main.jsp"><img src="../resources/images/mainImg/kostyle1.png"></a>
	</div>
	
	<div class="search_field">
	<form action="searchAction.search" method="get">
		<div class="search_box">
			<dl class="clear_float">
				<dt><input type="text" name="search"></dt>
				<dd><input type="image" src="../resources/images/mainImg/mainsearch.png" alt="검색" title="검색"></dd>
			</dl>
		</div>
	</form>
	</div>
	
	<div class="log_field">
      <a href="template.jsp?body=../stats/statsindex.jsp" id="login_id" onmouseover="m_over(1);" onmouseout="closetime();"><img src="../resources/images/mainImg/log1.png"></a>
		   <div class="log_field">

		<div id="mouse_id" onmouseover="cancelclosetime()" onmouseout="closetime();">
   			<a href="../login/loginCustomer.jsp">로그인</a> /
   			<a href="../join/join.jsp">회원가입</a> /
   			<a href="../mypage/sessionTestForm.jsp">my page</a>
  		</div>
	</div>
	</div>
	
	
  
	
</div>
</body>
</html>