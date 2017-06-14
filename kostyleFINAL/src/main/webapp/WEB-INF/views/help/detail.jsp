<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ include file="../main/kostyleHeader.jsp"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>게시글 상세보기</title>
<script src="../../../resources/jquery/jquery-3.2.1.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script>
<!-- <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css"> -->

<script id="template" type="text/x-handlebars-template">
				{{#each .}}
	         <li class="replyLi" data-as_Num={{as_Num}}>
             <i class="fa fa-comments bg-blue"></i>
             <div class="timeline-item" >
                <span class="time"> <i class="fa fa-clock-o"></i>{{prettifyDate as_Date}}</span>
                <h3 class="timeline-header"><strong>{{as_Num}}</strong> -{{c_Id}}</h3>
                <div class="timeline-body">{{as_Content}} </div>
								<div class="timeline-footer"></div></div></li>
        {{/each}}
</script> 
<script type="text/javascript">
function showModify(as_Num){
	/* $('#modifyReply').show("slow"); */
	alert(as_Num);
	$.ajax({
		type:"get",
		url:"${path}/replies/detail/"+as_Num,
		success:function(result){
			$('#modifyReply').html(result);
			$('#modifyReply').css("visibility","visible");
		}
	});
	
	
}

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
				/* alert(data); */
				alert("successHandler진입.");
				
				$('#repliesDiv').after(data);
			}
		}); 
	}
	
	
	var printData = function(replyArr, target, templateObject){
		alert('printData');
		var template = Handlebars.compile(templateObject.html());
		
		var html = template(replyArr);
		$('.replyLi').remove();
		target.after(html);
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
		alert("remove");
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
 	/* 댓글 수정폼 소환 */
/*	$('#btnUpdateForm').click(function(){
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
				$(this).parent().slideDown(result);
			}
			
		})
	}); */	
	/* 댓글 수정 */
	$('#btnReplyUpdate').click(function(){
		$.ajax({
			type:"put",
			url:"${path}/reply/update/${reply.as_Num}",
			headers:{
				"Content-Type":"application/json"
			},
			data:JSON.stringify({
				as_Content : as_Content
			}),
			dataType:"text",
			success: function(result){
				if(result == "success"){
					$("#modifyReply").hide();
				}
			}
		});
	});
	
	/* 댓글 보기 */
	
	/* 댓글 삭제 */
	$('.timeline').on('click', '.replyLi #btnRelpyDelete', function(){
		alert('삭제버튼');
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
				$('#repliesDiv').after(data); */
				if(result=="delete"){
					getPage("${path}/replies/${board.q_Num}");
				}
			}
			
		});
	});
	/* 댓글 수정 폼 */
	$('.timeline').on('click', '.replyLi #btnUpdateForm', function(){
		alert('수정폼 소환 버튼');
		var $replyLi = $(this).parent();
		var as_Num = $(this).parent().attr('data-rno');
		alert(as_Num);
		$.ajax({
			url:"${path}/replies/"+as_Num,
			type : 'post',
			headers:{
				"Content-Type":"application/json",
				"X-HTTP-Method-Override":"POST" 
			},
			dataType:"text",
			success: function(result){
				console.log("success핸들러:"+result);
				var reply = result;
				console.log(reply);
				var source = "<div class='updateform'><textarea row='3' cols='50' name='as_Content' id='as_Content'></textarea>";
				source += "<input type='button' id='updateReply' value='수정'>";
				source += "<input type='button' id='updateCancel' value='취소'>";
				$replyLi.find('.timeline-footer').append(source);
			}
			
		});
	});
	/* 댓글 수정 작업. */
	$('.timeline').on('click', '.replyLi #updateReply', function(){
		alert('수정 작업 ㄱ');
		var as_Num = $(this).closest('.replyLi').attr('data-rno');
		var as_Content = $(this).closest('.updateform').find('textarea[name=as_Content]').val();
		alert(as_Content);
		alert(as_Num);
		$.ajax({
			url:"${path}/replies/"+as_Num,
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
					getPage("${path}/replies/${board.q_Num}");
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
});

</script>
<style type="text/css">
#modifyReply{
	width: 350px;
	height: 120px;
	background-color: gray;
	position: absolute;															/* 절대 좌표 */
	top: 50%;
	left: 50%;																	/* 가운데로 지정 */
	margin-top: -50px;
	margin-left: -150px;
	padding: 10px;
	z-index: 10;																/* 엘리먼트드 레벨? z-index가 클수록 화면 위로 보여진다. */
	visibility: hidden;
}
</style>
</head>
<body>
	<h2>글 상세보기</h2>
	<table border="1">
		<tr height="30">
			<td width="150">글번호</td>
			<td width="150">${board.q_Num }</td>
			<td width="150">작성일</td>
			<td width="150">
				<fmt:formatDate value="${board.q_Date }" pattern="yyyy-MM-dd"/>
			</td>
		</tr>
		<tr height="30">
			<td width="150">작성자</td>
			<td width="150">${board.c_Id }</td>
			<td width="150">쇼핑몰</td>
			<td width="150">${board.s_Name }</td>
			
		</tr>			
		<%-- <tr height="30">
			<td width="150">파일</td>
			<td colspan="3">
				<a href="download.jsp?filename=${board.b_fname }">${board.b_fname }</a>
			</td>			
		</tr> --%>
		<tr height="30">
			<td width="150">제목</td>
			<td colspan="3">${board.q_Title }</td>			
		</tr>
		<tr height="30">			
			<td colspan="4">${board.q_Content }</td>			
		</tr>
		<tr height="30">			
			<td colspan="4">
				<input type="button" value="글목록" id="list">
				<input type="button" value="수정" id="update">
				<input type="button" value="삭제" id="remove">
			</td>			
		</tr>
		
	<%--	<c:forEach var="answer" items="${list }">
		<tr height="30">
			<td align="center" colspan="2">${answer.as_Title }</td>
			<%-- <td align="center">${작성자 }</td> 
			<td align="center">${answer.as_Date }</td>
		</tr>
		<tr>
		<td align="left" colspan="4"><textarea rows="3" cols="70">${answer.as_Content }</textarea> </td>
		</tr>
		</c:forEach>
		
	 	<tr height="30">
			<td colspan="3">
			<form action="detailAction.a" method="post">
				<input type="text" name="as_title">
				<textarea rows="3" cols="70" name="as_content"></textarea>
				<input type="hidden" name = "q_Num" value="${board.q_Num }">
				<input type="text" name = "as_writer">
				<input type="submit" value="댓글달기" >
				</form>
				</td>
				 --%>
				 
				
	</table>
	<div class="col-md-12">


<div class="box box-success">
  <div class="box-header">
    <h3 class="box-title">ADD NEW REPLY</h3>
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
		  <button type="submit" class="btn btn-primary" id="replyAddBtn">ADD REPLY</button>
		</div>
</c:if>
  
 <%--  <c:if test="${empty login}">
    <div class="box-body">
      <div><a href="javascript:goLogin();" >Login Please</a></div>
    </div>
  </c:if> --%>			                 
</div>            


		
		<!-- The time line -->
		<ul class="timeline">
		  <!-- timeline time label -->
		<li class="time-label" id="repliesDiv">
		  <span class="bg-green">
		    Replies List <small id='replycntSmall'> [ ${board.answerNum} ] </small>
		    </span>
		  </li>
		</ul>
		<div id="modifyReply">댓글 수정 화면 영역
		
		
		</div>
		   
			<!-- <div class='text-center'>
				<ul id="pagination" class="pagination pagination-sm no-margin ">

				</ul>
			</div>
 -->
		</div>
		<!-- /.col -->
	<!-- </div> -->


</body>
</html>