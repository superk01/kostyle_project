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
            <div class="box-header">
               <h3 class="box-title">코디 등록</h3>
            </div>
            <!-- /.box-header -->
            <div class="container">
            <form id="/coordinator/coordiregister" role="form" method="post">
               <div class="box-body">
                  <div class="form-group">
                     <label for="exampleInputEmail1">코디 이름</label> <input type="text"
                        name='cd_name' class="form-control" placeholder="Enter Title">
                  </div>
                  <div class="form-group">
                     <label for="exampleInputPassword1">코디 설명</label>
                     <textarea class="form-control" name="cd_content" rows="5"
                        placeholder="Enter ..."></textarea>
                  </div>
                  <div class="form-group">
                     <label for="exampleInputEmail1">쇼핑몰</label> <input type="text"
                        name="s_name" class="form-control" placeholder="Enter Writer"
                        value="${shoplogin.ad_id}" readonly="readonly">
                  </div>
                  <div class="form-group">
                  	<label for="exampleInputEmail1">파일 업로드</label>
                  	<input type="file" class="form-control" name="cd_img">
                  </div>
                  <div class="form-group">
                  	<label for="exampleInputEmail1">상품링크1</label>
                  	<input type="text" class="form-control" name="prd_url1">
                  </div>
                  <div class="form-group">
                  	<label for="exampleInputEmail1">상품링크2</label>
                  	<input type="text" class="form-control" name="prd_url2">
                  </div>
                  <div class="form-group">
                  	<label for="exampleInputEmail1">상품링크3</label>
                  	<input type="text" class="form-control" name="prd_url3">
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
                  <button type="submit" class="btn btn-default pull-right" id="registerBtn">코디 등록</button>
                  
               </div>
            </form>
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