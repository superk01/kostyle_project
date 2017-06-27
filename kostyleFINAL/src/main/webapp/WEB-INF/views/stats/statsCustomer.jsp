<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="statsSide.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="../resources/css/stats/stats.css">
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


								<div id="statsbody">
								<h3 class="page-header">상세 회원 분석</h3>
								<form acton="#" method="post" id="statsCustomerForm">
								<div>
								<label>회원<span>
								<input type="text" name="statsCustomer" id="statsCustomer">
								</span></label>
								</div>
								<button type="submit" class="btn btn-default" id="statsCustomerBtn">조회</button>
								
								</form>
								</div>
								<h3 class="page-header"></h3>


                    </div>
                </div>
            </div>
        </div>
</body>

<script>

$("#statsCustomerForm").submit(function(event){
	event.preventDefault();
	
	$.ajax({
		type:'post',
		url:'/stats/statsCustomer',
		dataType:'text',
		data: {statsCustomer:$("#statsCustomer").val()},
		success:function(result){
			location.href="statsCustomerChart";
		}
	});
});

</script>

</html>