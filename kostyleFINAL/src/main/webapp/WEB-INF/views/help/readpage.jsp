<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ include file="../main/kostyleHeader.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<script type="text/javascript">
$(document).ready(function(){
	
	
	function getPage(pageInfo){
		alert(pageInfo);
		
			$.ajax({
			type:'get',
			url: pageInfo,
			headers:{
				"Content-Type":"application/json",
				"X-HTTP-Method-Override":"GET"
			},
			dataType:'text',
			success : function(data){
				alert(data);
				alert("successHandler진입.");
				
				$('#repliesDiv').after(data);
			}
		}); 
	}
	/* alert("이벤트 발생"); */
	$('#list').on('click', function(){
		/* alert("list"); */
		location.href="/help/list";
	});
	$('#update').on('click', function(){
		/* alert("update"); */
		location.href="/help/update?q_Num=${board.q_Num}";
	});
	$('#remove').on('click', function(){
		/* alert("remove"); */
		location.href="/help/remove?q_Num=${board.q_Num}";
	});
	/* 댓글 추가 */
	$('#replyAddBtn').on('click', function(){
		var replyer = $('#newReplyWriter').val();
		var replytext = $('#newReplyText').val();
		var q_Num = ${board.q_Num};
		alert(replyer+","+replytext+","+q_Num);
		$.ajax({
			type:'post',
			url:'/replies/',
			headers:{
				"Content-Type":"application/json",
				"X-HTTP-Method-Override":"POST"
			},
			dataType:'text',
			data : JSON.stringify({
				q_Num : q_Num,
				c_Id : replyer,
				as_Content : replytext
			}),
			success : function(result){
				alert(result);
				if(result=='success'){
					getPage("/replies/"+q_Num);
					$('#newReplyText').val("");
				}
			}
		});
	});
	/* 댓글 보기 */
	$('#repliesDiv').on('click',function(){
		alert('#repliesDiv');
		if($('li.replyLi').length>0){
			console.log($('li.replyLi').length);
			return;
		} 
		getPage("/replies/${board.q_Num}");
	});
	$('#updateform').on('click',function(){
		alert('updateform 이벤트 확인');
		$('#title').removeAttr("readonly");
		$('#content').removeAttr("readonly");
		$(this).css("display", "none");
		$('#remove').css("display", "none");
		$('.dynamicBtns').
		append("<input type='button' value='확인' id='update' class='btn btn-default pull-right'>"+
			  "<input type='button' value='취소' id='cancel' class='btn btn-default pull-right'>");
	});
	
	$('.dynamicBtns').on('click','#cancel',function(){
		alert('cancel이벤트 확인');
		$('#title').attr("readonly","readonly");
		$('#content').attr("readonly","readonly");
		$('#updateform').css("display", "");
		$('#remove').css("display", "");
		$('#update').remove();
		$('#cancel').remove();
	});
	$('.dynamicBtns').on('click','#update',function(){
		alert('update버튼 이벤트 확인');
		var title = $('input[name=title]').val();
		var content = $('#content').text();		
		alert(title);
		alert(content);
		$.ajax({
			type:'post',
			url:'/help/alter',
			headers:{
				"Content-Type":"application/json",
				"X-HTTP-Method-Override":"POST"
			},
			dataType:'text',
			data : JSON.stringify({
				q_Title : title,
				q_Content : content,
			}),
			success : function(result){
				alert(result);
				if(result=='success'){
					$('#title').attr("readonly","readonly");
					$('#content').attr("readonly","readonly");
				}
			}
		});
	});
});
</script>
<style type="text/css">
.timeline>li.time-label>span {
    font-weight: 600;
    padding: 5px;
    display: inline-block;
    /* background-color: #fff; */
    border-radius: 4px;
    margin-left: -39px;
}
.bg-green, .callout.callout-success, .alert-success, .label-success, .modal-success .modal-body {
    background-color: #00a65a !important;
}
ul.timeline{
	list-style: none;
}
div.dynamicBtns{
	display: inline;
}
</style>

<title>Insert title here</title>
</head>
<body>
<div class="container">
<div class="box-header">
					<h3 class="box-title">READ BOARD</h3>
				</div>
				<!-- /.box-header -->

				<form role="form" action="modifyPage" method="post">

					<input type='hidden' name='q_Num' value="${board.q_Num}"> 
					<input type='hidden' name='page' value="${cri.page}"> 
					<input type='hidden' name='perPageNum' value="${cri.perPageNum}">
					<input type='hidden' name='searchType' value="${cri.searchType}">
					<input type='hidden' name='keyWord' value="${cri.keyWord}">

				</form>

				<div class="box-body">
					<div class="form-group">
						<label for="exampleInputEmail1">제목</label> <input type="text"
							name='title' class="form-control" value="${board.q_Title}"
							readonly="readonly" id="title">
					</div>
					<div class="form-group">
						<label for="exampleInputPassword1">내용</label>
						<textarea class="form-control" name="content" rows="3"
							readonly="readonly" id="content">${board.q_Content}</textarea>
					</div>
					<div class="form-group">
						<label for="exampleInputEmail1">작성자</label> <input type="text"
							name="writer" class="form-control" value="${board.c_Id}"
							readonly="readonly">
					</div>
					<div class="form-group">
						<label for="exampleInputEmail1">쇼핑몰</label> <input type="text"
							name="writer" class="form-control" value="${board.s_Name}"
							readonly="readonly">
					</div>
				</div>
				<div class="btns">
					<input type="button" value="글목록" id="list" class="btn btn-default">
					<c:if test="${board.c_Id==login.c_id }">
						<div class="dynamicBtns">
							<input type="button" value="수정" id="updateform" class="btn btn-default pull-right">
							<input type="button" value="삭제" id="remove" class="btn btn-default pull-right" > 
						</div>
					</c:if>
				</div>
				<c:if test="${not empty login}">
  					<div class="box-body">
    					<label for="exampleInputEmail1">Writer</label>
    					<input class="form-control" type="text" placeholder="USER ID" 
    	 				id="newReplyWriter" value="${login.c_id }" readonly="readonly"> 
    	      			<label for="exampleInputEmail1">Reply Text</label> 
    					<input class="form-control" type="text" placeholder="REPLY TEXT" id="newReplyText">
    				</div>
  					<div class="box-footer">
		  				<button type="submit" class="btn btn-primary pull-right" id="replyAddBtn">댓글 추가</button>
					</div>
				</c:if>
				<!-- The time line -->
				<ul class="timeline">
		  		<!-- timeline time label -->
					<li class="time-label" id="repliesDiv">
		  				<span class="bg-green"> 댓글 목록 보기 
		  					<small id='replycntSmall'> [ ${board.answerNum} ] </small>
		   				</span>
		  			</li>
				</ul>
</div>
</body>
</html>