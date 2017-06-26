<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ include file="../main/kostyleHeader.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">

#title1{
 	background-color: white;
 	border: none;
 	border-radius: 0;
 	font-size: 45px;
 	text-align: center;
 	box-shadow: none;
 	margin-top: 30px;
 	cursor: text;
 	height: 60px;
 	color: navy;
 }
 
#content{
	background-color: white;
 	border: none;
 	border-radius: 0;
 	font-size: 18px;
 	box-shadow: none;
 	cursor: text;
 	text-align: center;
}

.like{
	display: block;
}

.col-sm-12{
	text-align: center;
}

.col-sm-2{
	text-align: center;
	margin-top: 5px;
}

</style>
<!-- <script type="text/javascript">
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
</script> -->
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
				</div>
				<!-- /.box-header -->
				<br>
				<br>
				<br>
				<br>
				<br>
				<br>
				<form role="form" action="modifyPage" method="post">

					<input type='hidden' name='cd_num' value="${coordi.cd_num}"> 
					<%-- <input type='hidden' name='page' value="${cri.page}"> 
					<input type='hidden' name='perPageNum' value="${cri.perPageNum}">
					<input type='hidden' name='searchType' value="${cri.searchType}">
					<input type='hidden' name='keyWord' value="${cri.keyWord}"> --%>

				</form>

				<div class="box-body">
					<div class="form-group">
						<!-- <label for="exampleInputEmail1">제목</label>  --><input type="text"
							name='title' class="form-control" value="${coordi.cd_name}"
							readonly="readonly" id="title1" style="background-color: white; border: none;" >
						<input type="text" name='title' class="form-control" placeholder="${coordi.cd_name}"
							id="title2" style="display: none">
					</div>
				<br>
				<br>
				<br>
					<div class="form-group">
						<!-- <label for="exampleInputPassword1">내용</label> -->
						<textarea class="form-control" name="content1" rows="10" onclick="onLoadTextArea();"
							readonly="readonly" id="content" style="background-color: white; resize: none;" >${coordi.cd_content}</textarea>
						<textarea class="form-control" name="content2" rows="5"
							 id="content2" placeholder="${coordi.cd_content}" style="display: none"></textarea>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label" for="exampleInputEmail1">쇼핑몰</label>
						<div class="col-sm-10">
						 <input type="text"
							name="writer" class="form-control" value="${coordi.s_name}"
							readonly="readonly" style="background-color: white"></div>
					</div>
					
					<div class="form-group">
						<button id="like" class="btn btn-default pull-left">좋아요</button>
					</div>
					
					<div class="form-group">
                  	<div class="col-sm-12" style="height:50px;"></div>
                  </div>
					<div class="form-group">
						<!-- <label class="col-sm-2 control-label" for="exampleInputEmail1">대표이미지</label> --> 
						<div class="col-sm-12">
						<img class="image1" alt="" src="${coordi.cd_img }">
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label" for="exampleInputEmail1">상품 링크1</label> 
						<div class="col-sm-10">
						<a href="${coodi.prd_url1 }"><img alt="" src="${coordi.prd_img1 }"></a>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label" for="exampleInputEmail1">상품 링크2</label> 
						<div class="col-sm-10">
						<a href="${coodi.prd_url2 }"><img alt="" src="${coordi.prd_img2 }"></a>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label" for="exampleInputEmail1">상품 링크3</label> 
						<div class="col-sm-10">
						<a href="${coodi.prd_url3 }"><img alt="" src="${coordi.prd_img3 }"></a>
						</div>
					</div>
				</div>
				<div class="btns">
					<div class="col-sm-12">
					<input type="button" value="글목록" id="list" class="btn btn-default">
					
					<c:if test="${coordi.s_num==shoplogin.s_num }">
						<div class="dynamicBtns">
							<input type="button" value="수정" id="updateform" class="btn btn-default pull-right">
							<input type="button" value="삭제" id="remove" class="btn btn-default pull-right" > 
						</div>
					</c:if>
					</div>
				</div>
			<%-- 	<c:if test="${not empty login}">
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
				</ul> --%>
</div>

<!-- <script type="text/javascript" language="javascript">
function onFitSizeOfTextArea()
    {
        var textArea = event.srcElement;
        while( textArea.clientHeight < textArea.scrollHeight )
        {
            textArea.rows = textArea.rows + 1;
        }
        textArea.className = "NoScroll";
    }
</script> -->


</body>
</html>