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
<script type="text/javascript">
$(document).ready(function(){
	$('#like').on('click', function(){
		$.ajax({
			url: "coordinator/like",
			type: "put",
			headers:{
				"Content-Type":"application/json",
				"X-HTTP-Method-Override":"PUT"
			},
			success: function(data){
				if(data=='success'){
					alert('좋아요!!!');
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