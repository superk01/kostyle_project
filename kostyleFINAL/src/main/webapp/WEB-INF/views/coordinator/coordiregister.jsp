<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ include file="../main/kostyleHeader.jsp" %> 

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="/resources/css/coordi/coordiRegister.css" media="screen" title="no title" charset="utf-8">
<script type="text/javascript">
$(document).ready(function(){
	/* $('.file').on('change', function(){
		alert("message");
	}); */
});
function upload(event){
	var files = event.originalEvent.dataTransfer.files;

	var file = files[0];

	var formData = new FormData();

	formData.append("file", file);
	$.ajax({
		url : '/coordinator/uploadAjax',
		data : formData,
		dataType : 'text',
		processData : false,
		contentType : false,
		type : 'POST',
		success : function(data) {
			console.log(data);
			var fileInfo = getFileInfo(data);

			var html = template(fileInfo);

			$(".uploadedList").append(html);
		}
	});
}

</script>

<style type="text/css">

.form-control{
	margin-bottom: 20px;
}

.col-sm-2{
	text-align: center;
	margin-top: 5px;
	font-size: 16px;
	font-family: 맑은 고딕;
}

.allborder{
	border-top: solid 20px gray;
	border-radius: 5px;
	border-bottom: solid 20px gray;
	/* border-left: solid 1px Lightgray;
	border-right: solid 1px Lightgray; */
	
	padding-top: 20px;
	padding-bottom: 20px;
	padding-left: 20px;
	padding-right: 40px;
	margin-top: 10px
}

.btn{
	margin: 55px -40px !important;
}
</style>

<title>Insert title here</title>
</head>
<body>
   <div class="content-wrapper">
<section class="content">
   <div class="row">
      <!-- left column -->
      <div class="col-md-12">
         <!-- general form elements -->
         <div class="box box-primary">
           <div class="page-header">
			<h1>코디등록</h1>
		</div>
            <!-- /.box-header -->
            <div class="container">
            <div class="allborder">
            <form action="/coordinator/coordiregister" role="form" method="post" enctype="multipart/form-data">
               <div class="box-body">
                  <div class="form-group">
                     <label class="col-sm-2 control-label" for="exampleInputEmail1">코디 이름</label> 
                     <div class="col-sm-10">
                     <input type="text"
                        name='cd_name' class="form-control" placeholder="Enter Title" autocomplete="off">
                  </div>
                  </div>
                  <div class="form-group">
                     <label class="col-sm-2 control-label" for="exampleInputPassword1">코디 설명</label>
                     <div class="col-sm-10">
                     <textarea class="form-control" name="cd_content" rows="5"
                        placeholder="Enter ..." autocomplete="off"></textarea>
                        </div>
                  </div>
                  <div class="form-group">
                     <label class="col-sm-2 control-label" for="exampleInputEmail1">쇼핑몰</label>
                     <div class="col-sm-10">
                      <input type="text"
                        name="s_name" class="form-control" placeholder="Enter Writer"
                        value="${shoplogin.ad_id}" readonly="readonly">
                        </div>
                  </div>
                  
                  <div class="form-group">
                  	<label class="col-sm-2 control-label" for="exampleInputEmail1">대표 이미지</label>
                  	<div class="col-sm-10">
                  	<input type="file" class="form-control" name="uploadFile">
                  	</div>
                  </div>
                  <div class="form-group">
                  	<label class="col-sm-2 control-label" for="exampleInputEmail1">상의</label>
                  	<div class="col-sm-10"><input type="text" class="form-control" name="prd_url1" autocomplete="off"></div>
                  	<label class="col-sm-2 control-label" for="exampleInputEmail1">이미지</label>
                  	<div class="col-sm-10"><input type="text" class="form-control" name="prd_img1" autocomplete="off"></div>
                  </div>
                  <div class="form-group">
                  	<label class="col-sm-2 control-label" for="exampleInputEmail1">하의</label>
                  	<div class="col-sm-10"><input type="text" class="form-control" name="prd_url2" autocomplete="off"></div>
                  	<label class="col-sm-2 control-label" for="exampleInputEmail1">이미지</label>
                  	<div class="col-sm-10"><input type="text" class="form-control" name="prd_img2" autocomplete="off"></div>
                  </div>
                  <div class="form-group">
                  	<label class="col-sm-2 control-label" for="exampleInputEmail1">액세서리</label>
                  	<div class="col-sm-10"><input type="text" class="form-control" name="prd_url3" autocomplete="off"></div>
                  	<label class="col-sm-2 control-label" for="exampleInputEmail1">이미지</label>
                  	<div class="col-sm-10"><input type="text" class="form-control" name="prd_img3" autocomplete="off"></div>
                  </div>
                 <%--  <div class="form-group">
                     <label for="exampleInputEmail1">쇼핑몰 선택</label> 
                     <div>
                        <select id="shoppingmall" name = "s_Name" class="form-control">
                        <option>선택</option>
                           <c:forEach var="shoppingMall" items="${list }">
                              <option>${shoppingMall.s_Name }</option>
                           </c:forEach>
                        </select>
                     </div> 
                     <!-- <input type="text"
                        name="writer" class="form-control" placeholder="Enter Writer"> -->
                  </div> --%>
                  

               </div>
               
               

               <!-- /.box-body -->

               <div class="box-footer">
                  <div>
                     <hr>
                  </div>

                  <ul class="mailbox-attachments clearfix uploadedList">
                  </ul>
                  <!-- <div class="checkbox"> <label> <input type="checkbox" id="blankCheckbox" value="option1" aria-label="checkbox1" name="q_Secret">비밀글 </label> </div> -->
                  <button type="submit" class="btn btn-default btn-lg pull-right" id="registerBtn">코디 등록</button>
                  
               </div>
            </form>
            </div>
            </div>
            
         </div>
         <!-- /.box -->
      </div>
      <!--/.col (left) -->

   </div>
   <!-- /.row -->
</section>
<!-- /.content -->
</div>
<!-- /.content-wrapper -->


</body>
</html>