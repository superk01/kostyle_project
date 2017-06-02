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
    			<td>��ȣ</td>
    			<td>${ShoppingMall.s_num }</td>
    		</tr>
    		<tr>
    			<td>���θ���</td>
    			<td>${ShoppingMall.s_sname }</td>
    		</tr>
    		<tr>
    			<td>���θ� URL</td>
    			<td>${ShoppingMall.s_shopurl }</td>
    		</tr>
    		<tr>
    			<td>�˻� URL</td>
    			<td>${ShoppingMall.s_searchurl }</td>
    		</tr>
    		<tr>
    			<td>����ڵ�Ϲ�ȣ</td>
    			<td>${ShoppingMall.s_shopreg }</td>
    		</tr>
    		<tr>
    			<td>���ɴ�</td>
    			<td>${ShoppingMall.s_age }</td>
    		</tr>
    		<tr>
    			<td>�����</td>
    			<td>${ShoppingMall.s_manager }</td>
    		</tr>
    		<tr>
    			<td>�̸���</td>
    			<td>${ShoppingMall.s_email }</td>
    		</tr>
    		<tr>
    			<td>����ó</td>
    			<td>${ShoppingMall.s_phonenumber }</td>
    		</tr>
    	</table>
    	
    	<button class="btn btn-lg btn-primary btn-block" id="addShop" type="submit">����ϱ�</button>

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