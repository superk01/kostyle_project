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
		$.ajax({
			type:'get',
			url: pageInfo,
			headers:{
				"Content-Type":"application/json",
				"X-HTTP-Method-Override":"GET"
			},
			dataType:'text',
			success : function(data){
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
					$('#repliesDiv').siblings().remove();
					getAnswerNum(q_Num);
					getPage("/replies/"+q_Num);
					$('#newReplyText').val("");
				}
			}
		});
	});
	/* 댓글 보기 */
	$('#repliesDiv').on('click',function(){
		if($('li.replyLi').length>0){
			console.log($('li.replyLi').length);
			return;
		} 
		getPage("/replies/${board.q_Num}");
	});
	/*게시글 수정시 수정폼 나오게... */
	$('#updateform').on('click',function(){
		
		$('#title1').css("display", "none");
		$('#title2').css("display", "");
		$('#content').css("display", "none");
		$('#content2').css("display","");
		$(this).css("display", "none");
		$('#remove').css("display", "none");
		$('.dynamicBtns').
		append("<input type='button' value='확인' id='update' class='btn btn-default pull-right'>"+
			  "<input type='button' value='취소' id='cancel' class='btn btn-default pull-right'>");
	});
	/*게시글 수정시 취소버튼 누르면 원래대로... */
	$('.dynamicBtns').on('click','#cancel',function(){
		var title = $('input[name=title]').val();
		var content = $('#content').val()
		
		$('#title').attr("readonly","readonly");
		$('#title').val(title);
		$('#content').css("display", "");
		$('#content2').css("display","none");
		$('#updateform').css("display", "");
		$('#remove').css("display", "");
		$('#update').remove();
		$('#cancel').remove();
	});
	/*  */
	$('.dynamicBtns').on('click','#update',function(){
		var title = $('#title2').val();
		var content = $('#content2').val();		
		var q_num = $('input[name=q_Num]').val()
		$.ajax({
			type:'put',
			url:'/help/alter',
			headers:{
				"Content-Type":"application/json",
				"X-HTTP-Method-Override":"PUT"
			},
			dataType:'text',
			data : JSON.stringify({
				q_Title : title,
				q_Content : content,
				q_Num : q_num
			}),
			success : function(result){
				if(result=='success'){
					$('#title1').val(title);
					$('#title1').css("display","");
					$('#title2').css("display","none");
					$('#content').val(content);
					$('#content').css("display","");
					$('#content2').css("display","none");
				}
			}
		});
	});
	/*--------------------------댓글 관련 ------------------------------- */
	/* 댓글 수정폼 소환 */
	var $textarea = null;
	var $dynamic1 = null;
	var $dynamic2 = null;
	$('.timeline').on('click','.btnUpdateForm',function(){
		if($textarea != null){
			$textarea.css("display", "none");
			$dynamic1.css("display", "");
			$dynamic2.css("display","none");
		}
		$dynamic1 = $(this).parent();
		$dynamic2 = $(this).parent().next();
		$textarea = $(this).parent().parent().find('.replyUpdate');
		$textarea.css("display","");
		$dynamic1.css("display","none");
		$dynamic2.css("display","");
	});
	/* 취소버튼 눌렀을때 댓글 수정폼 원래대로 */
	$('.timeline').on('click','.btnReplyCancel', function(){
		var $dynamic1 = $(this).parent().prev();
		var $dynamic2 = $(this).parent();
		
		$dynamic1.css("display","");
		$dynamic2.css("display","none");
		$textarea.css("display","none");
	});
	/* 댓글 삭제 버튼 */
	$('.timeline').on('click', '.btnRelpyDelete', function(){
		var q_Num = ${board.q_Num};		
		var as_Num = $(this).parent().parent().attr('data-rno');
		$.ajax({
			url:"/replies/"+as_Num,
			type : 'delete',
			headers:{
				"Content-Type":"application/json",
				"X-HTTP-Method-Override":"DELETE"
			},
			dataType:"text",
			success: function(result){
				if(result=="delete"){
					getAnswerNum(q_Num);
					$('.timeline').find('.replyLi').remove();
					getPage("/replies/${board.q_Num}");
				}
			}
		});
	});
	/* 수정폼의 수정확인 버튼 */
	$('.timeline').on('click', '.btnReplySubmit', function(){
		var as_Num = $(this).closest('.replyLi').attr('data-rno');
		var as_Content = $(this).parent().parent().find('textarea').val();
		$.ajax({
			url:"/replies/"+as_Num,
			type: "put",
			headers:{
				"Content-Type":"application/json",
				"X-HTTP-Method-Override":"PUT" 
			},
			dataType:"text",
			data : JSON.stringify({
				as_Content : as_Content
			}),
			success: function(result){
				if(result=='success'){
					$('.timeline').find('.replyLi').remove();
					getPage("/replies/${board.q_Num}");
				}
			}
		});
	});
	function getAnswerNum(q_Num){
		
		$.ajax({
			url: "/help/getAnswerNum?q_num="+q_Num,
			type: "get",
			headers:{
				"Content-Type":"application/json",
				"X-HTTP-Method-Override":"GET"
			},
			data : 'json',
			success : function(data){
				alert(data.answerNum);
				$('#replycntSmall').remove();
				$('.bg-green').append("<small id='replycntSmall'> ["+ data.answerNum+ "] </small>");
			}
		})
	}
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
li.replyLi{
	padding-top: 15px;
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
							readonly="readonly" id="title1">
						<input type="text" name='title' class="form-control" placeholder="${board.q_Title}"
							id="title2" style="display: none">
					</div>
					<div class="form-group">
						<label for="exampleInputPassword1">내용</label>
						<textarea class="form-control" name="content1" rows="5"
							readonly="readonly" id="content">${board.q_Content}</textarea>
						<textarea class="form-control" name="content2" rows="5"
							 id="content2" placeholder="${board.q_Content}" style="display: none"></textarea>
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