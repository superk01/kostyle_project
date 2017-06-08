<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<!-- Bootstrap -->
<link rel="stylesheet" href="../../../resources/css/favorite/bootstrap.min.css"	media="screen" title="no title" charset="utf-8">
<!-- font awesome -->
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css">
<!-- Custom style -->
<link rel="stylesheet" href="../../../resources/css/favorite/favoriteCommentStyle.css"	media="screen" title="no title" charset="utf-8">


<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script src="http://code.jquery.com/jquery-3.2.1.min.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
</head>

<div class="page-header">
			<h1>
				즐겨찾기
			</h1>
</div>
		

<div class="box">

		<form role="form" action="comentModify" method="post">
		<input type='hidden' name='f_num' value="${favorite.f_num}">
		<input type='hidden' name='page' value="${cri.page}">
		<input type='hidden' name='perPageNum' value="${cri.perPageNum}">
		</form>

		<div class="box-body">
		<br><br>
		<div class="form-group">
			<label for="exampleInputEmail1">즐겨찾기 추가 날짜</label> 
			
			<input type="text" name='f_date' class="form-control" value="${favorite.f_date}" readonly="readonly">
		</div>
		<br><br>
		<div class="form-group">
			<label for="exampleInputPassword1">Comment</label>
			
			<textarea class="form-control" name="f_coment" rows="5" readonly="readonly">${favorite.f_coment}</textarea>
		<br><br>
		</div>
		</div>
</div>
<!-- /.box-body -->

<br><br>
<div class="box-footer">
	<button type="submit" id="btn-modify" class="btn btn-default">수정하기</button>
	<button type="submit" id="btn-list" class="btn btn-default">즐겨찾기</button>
	<br><br>
</div>


<script>
$(document).ready(function(){
	
	var formObj = $("form[role='form']");
	
	console.log(formObj);
	
	$("#btn-modify").on("click", function(){
		formObj.attr("action", "/favorite/comentModify");
		formObj.attr("method", "get");		
		formObj.submit();
	});
	
	$("#btn-list").on("click", function(){
		formObj.attr("action", "/favorite/favoriteList");
		formObj.attr("method", "get");		
		formObj.submit();
	});
	
});
</script>



