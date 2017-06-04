<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>게시글 상세보기</title>
<script src="../../../resources/jquery/jquery-3.2.1.js"></script>
<!-- <script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script> -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">

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


$(document).ready(function(){
	
	
	function getPage(pageInfo){
		alert(pageInfo);
		/* $.getJSON(pageInfo,function(data){
			alert('ajax get호출');
			alert(data);
			printData(data.list, $('#repliesDiv'), $('#template'));
		}); */
		
		 /* $.getJSON(pageInfo,function(data){
				alert('ajax get호출');
				alert("successHandler진입.");
				
				var source = "";
 				source += "<c:forEach var='answer' items='${data.list }'>"
 				source += "<li class='replyLi' data-as_Num='${answer.as_Num}'>"
 				source += "<i class='fa fa-comments bg-blue'></i>"
 				source += "<div class='timeline-item' >"
 				source += "<span class='time'> <i class='fa fa-clock-o'></i>${answer.as_Date}</span>"
 				source += "<h3 class='timeline-header'><strong>${answer.as_Num}</strong> -${answer.c_Id}</h3>"
 				source += "<div class='timeline-body'>${answer.as_Content} </div>"
 				source += "<div class='timeline-footer'></div></div></li>"
 				source += "</c:forEach>"
				$('#displayDiv').html(source);
			}); */ 
			/* var source = ""; */
			$.ajax({
			type:'get',
			url: pageInfo,
			headers:{
				"Content-Type":"application/json",
				"X-HTTP-Method-Override":"GET"
			},
			dataType:'text',
			success : function(data){
				alert("successHandler진입.");
				$('#repliesDiv').html(data);
				/* var source = $('#template').html();
				var template = Handlebars.compile(source);
 */				
 		
				
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
	
});

</script>
</head>
<body>
	<h2>글 상세보기</h2>
			<table border="1">
		<tr height="30">
			<td width="150">글번호</td>
			<td width="150">${board.q_Num }</td>
	
		</tr>
		<tr height="30">
			<td width="150">작성자</td>
			<td width="150">${board.c_Id }</td>
			<td width="150">작성일</td>
			<td width="150">
				<fmt:formatDate value="${board.q_Date }" pattern="yyyy-MM-dd"/>
			</td>
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
  
  


 <%--  <c:if test="${not empty login}">  --%> 
  <div class="box-body">
    <label for="exampleInputEmail1">Writer</label>
    <input class="form-control" type="text" placeholder="USER ID" 
    	<%-- id="newReplyWriter" value="${login.urd }" readonly="readonly">   --%>   
    	id="newReplyWriter" value="">     
    <label for="exampleInputEmail1">Reply Text</label> 
    <input class="form-control" type="text" placeholder="REPLY TEXT" id="newReplyText">
    </div>
  
		<div class="box-footer">
		  <button type="submit" class="btn btn-primary" id="replyAddBtn">ADD REPLY</button>
		</div>
 <%--  </c:if> --%>
  
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
		    Replies List <small id='replycntSmall'> [ ${boardVO.replycnt} ] </small>
		    </span>
		  </li>
		</ul>
		   
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