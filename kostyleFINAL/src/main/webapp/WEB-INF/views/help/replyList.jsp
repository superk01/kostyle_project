<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- <script src="/resources/jquery/jquery-3.2.1.js"></script> -->
<!-- <script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script> -->
<!-- <link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css"> -->

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
h3{
	font-size: 15px !important; 
	font-weight: normal !important;
}
.timeline-body{
	font-size: 20px !important;
	font-weight: bold;
}
/* #btnUpdateForm{
	width: 22px !important;
	height: 27px !important;
	font-size: 100% !important;
	text-align: center !important;
	vertical-align: middle !important;
} */
</style>
<script type="text/javascript">
	$(document).ready(function() {
		
		/* 댓글 수정폼 소환 */
		/* $('#btnUpdateForm').on('click',function(){
			alert('클릭확인!!!');
			var as_Num = $(this).parent().attr('data-rno');
			alert(as_Num);
			$.ajax({
				url:"${path}/replies/"+as_Num,
				type : 'post',
				headers:{
					"Content-Type":"application/json"
				},
				dataType:"text",
				success: function(result){
					alert("success:"+result);
					$(this).parent().after(result).slideDown();
				}
				
			})
		});	 */
		/* $('#btnRelpyDelete').on('click',function(){
			alert('클릭확인');
		}); */
		
		/* $('.timeline').on('click', '.replyLi #btnUpdateForm', function(){
			alert('클릭확인!!!');
			var as_Num = $(this).parent().attr('data-rno');
			alert(as_Num);
			$.ajax({
				url:"${path}/replies/"+as_Num,
				type : 'post',
				headers:{
					"Content-Type":"application/json"
				},
				dataType:"text",
				success: function(result){
					alert("success:"+result);
					$(this).parent().after(result).slideDown();
				}
				
			});
		}); */
		/* $('.timeline').on('click', '.replyLi #btnRelpyDelete', function(){
			alert('클릭확인!!!');
			var as_Num = $(this).parent().attr('data-rno');
			alert(as_Num);
			$.ajax({
				url:"${path}/replies/"+as_Num,
				type : 'delete',
				headers:{
					"Content-Type":"application/json",
					"X-HTTP-Method-Override":"DELETE"
				},
				dataType:"text",
				success: function(result){
					/* alert("success:"+result);
					$('#repliesDiv').after(data); 
					if(result=="delete"){
						getPage("${path}/replies/${board.q_Num}");
					}
				}
				
			});
		}); */
	});
</script>
</head>
<body>

		<c:forEach var="row" items="${list}">
	
			<li class="replyLi" data-rno="${row.as_Num}">
				<i class="fa fa-comments bg-blue pull-left"></i>
					<c:set var="val" value="${row.c_Id }" /> 
					<c:set var="val2" value="${login.c_id}" /> 
					<%-- <span>${val},${val2}</span> --%> 
					<%-- <c:choose> --%>
					<c:if test="${val == val2 }">
						<div class="replyDynamicBtnGroup1">
							<input id="btnUpdateForm" type="button" class="btn btn-default pull-right" value="수정">
							<input id="btnRelpyDelete" type="button" class="btn btn-warning pull-right" value="삭제">
						</div>
						<div class="replyDynamicBtnGroup2" style="display: none">
							<input id="btnCancel" type="button" class="btn btn-default pull-right" value="취소">
							<input id="btnSubmit" type="button" class="btn btn-warning pull-right" value="확인">
						</div>
					</c:if>
				<%-- </c:choose>  --%>
				<div class="timeline-item">
					<span class="time pull-right"> <i class="fa fa-clock-o"></i>${row.as_Date }</span>
					<h3 class="timeline-header">
						${row.c_Id }
					</h3>
					<div class="timeline-body">${row.as_Content}</div>
					<textarea rows="3" class="form-control" placeholder="${row.as_Content}" style="display: none" id="replyUpdate"></textarea>
					<div class="timeline-footer"></div>
				</div></li>
		</c:forEach>


</body>
</html>