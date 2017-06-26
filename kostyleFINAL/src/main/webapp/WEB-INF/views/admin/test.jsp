<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% String cp = request.getContextPath(); %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ko-kr">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>부트스트랩</title>
<script type="text/javascript" src="<%=cp %>/js/jquery-1.8.0.min.js" ></script>
<script type="text/javascript" src="<%=cp %>/js/jquery-ui-1.8.23.custom.min.js" ></script>
<script type="text/javascript" src="<%=cp %>/js/jquery.ui.datepicker-ko.js" ></script>
  </head>
<body>
<input type="text" id="term" />

</body>

<script type="text/javascript">

$("#term").keyup(function(){
	
	var sk_searchkey = $("#term").val();
	
	$.ajax({
		type:'post',
		url:'/admin/test',
		headers:{
			"Content-Type":"application/json"},
		dataType:'text',
		data: JSON.stringify({sk_searchkey:sk_searchkey}),
		success:function(result){
			alert(result);
		}
	});
        	
        	
        	
        	
        	
        	
});
</script>



</html>