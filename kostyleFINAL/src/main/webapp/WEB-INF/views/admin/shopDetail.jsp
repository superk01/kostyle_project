<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>

    <link href="../../../resources/css/bootstrap/bootstrap.min.css" rel="stylesheet">
    <link href="../../../resources/css/admin/shopJoin.css" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    
</head>
<body>

    <div class="container">
    
    <form role="form" method="post">
    <input type='hidden' name='s_num' value='${ShoppingMall.s_num }'>
    </form>
    
    	<table class="table table-hover">
    		<tr>
    			<td>번호</td>
    			<td>${ShoppingMall.s_num }</td>
    		</tr>
    		<tr>
    			<td>쇼핑몰명</td>
    			<td>${ShoppingMall.s_sname }</td>
    		</tr>
    		<tr>
    			<td>쇼핑몰 URL</td>
    			<td>${ShoppingMall.s_shopurl }</td>
    		</tr>
    		<tr>
    			<td>검색 URL</td>
    			<td>${ShoppingMall.s_searchurl }</td>
    		</tr>
    		<tr>
    			<td>사업자등록번호</td>
    			<td>${ShoppingMall.s_shopreg }</td>
    		</tr>
    		<tr>
    			<td>연령대</td>
    			<td>${ShoppingMall.s_age }</td>
    		</tr>
    		<tr>
    			<td>담당자</td>
    			<td>${ShoppingMall.s_manager }</td>
    		</tr>
    		<tr>
    			<td>이메일</td>
    			<td>${ShoppingMall.s_email }</td>
    		</tr>
    		<tr>
    			<td>연락처</td>
    			<td>${ShoppingMall.s_phonenumber }</td>
    		</tr>
    	</table>
    	
    	<button class="btn btn-lg btn-primary btn-block" id="addShop" type="submit">등록하기</button>

    </div> <!-- /container -->



</body>
<script>
	$(document).ready(function(){
		
		var formObj = $("form[role='form']");
		
		$("#addShop").on("click", function(){
			formObj.attr("action", "/admin/adShop");
			formObj.attr("method", "get");
			formObj.submit();
		});
		
		
	})
</script>
</html>