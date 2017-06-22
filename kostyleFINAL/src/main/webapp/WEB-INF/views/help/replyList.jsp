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
					<c:set var="val" value="${row.c_Id }" /> 
					<c:set var="val2" value="${login.c_id}" /> 
					<span>${val},${val2}</span> 
					<%-- <c:choose> --%>
					<c:if test="${val == val2 }">
						<button id="btnUpdateForm" type="button">수정</button>
					</c:if>
					<c:if test="${val == val2 }">
						<button id="btnRelpyDelete" type="button">삭제</button>
					</c:if>
				<%-- </c:choose>  --%>
				<i class="fa fa-comments bg-blue"></i>
				<div class="timeline-item">
					<span class="time"> <i class="fa fa-clock-o"></i>${row.as_Date }</span>
					<h3 class="timeline-header">
						<strong>${row.as_Num }</strong> -${row.c_Id }
					</h3>
					<div class="timeline-body">${row.as_Content }</div>
					<div class="timeline-footer"></div>
				</div></li>
		</c:forEach>


</body>
</html>