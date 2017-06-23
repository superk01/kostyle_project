<%-- <%@page import="Customer.model.AdShoppingMall"%> --%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ include file="../main/kostyleHeader.jsp" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<!-- <script src="/resources/jquery/jquery-3.2.1.js"></script> -->
<!-- <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script> -->
<!-- <script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script> -->
<!-- <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css"> -->
<!-- <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script> -->
<!-- <link href="http:////maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css"> -->
<style type="text/css">
#registerBtn{
   background-color: #ad82ab !important;
   color: white !important;
   font-weight: bold;
   float: left;
}
#listBtn{
   background-color: #ad82ab !important;
   color: white !important;
   font-weight: bold;
   width: 101px;
   float: left;
}
.checkbox{
   float: left;
} 
#secret{
   background-color: #ad82ab !important;
   color: white !important;
}
</style>
<script type="text/javascript">
$(document).ready(function(){
   $('.button-checkbox').each(function(){
       var $widget = $(this),
         $button = $widget.find('button'),
         $checkbox = $widget.find('input:checkbox'),
         color = $button.data('color'),
         settings = {
               on: {
                  icon: 'glyphicon glyphicon-check'
               },
               off: {
                  icon: 'glyphicon glyphicon-unchecked'
               }
         };

      $button.on('click', function () {
         $checkbox.prop('checked', !$checkbox.is(':checked'));
         $checkbox.triggerHandler('change');
         updateDisplay();
      });

      $checkbox.on('change', function () {
         updateDisplay();
      });

      function updateDisplay() {
         var isChecked = $checkbox.is(':checked');
         // Set the button's state
         $button.data('state', (isChecked) ? "on" : "off");

         // Set the button's icon
         $button.find('.state-icon')
            .removeClass()
            .addClass('state-icon ' + settings[$button.data('state')].icon);

         // Update the button's color
         if (isChecked) {
            $button
               .removeClass('btn-default')
               .addClass('btn-' + color + ' active');
         }
         else
         {
            $button
               .removeClass('btn-' + color + ' active')
               .addClass('btn-default');
         }
      }
      function init() {
         updateDisplay();
         // Inject the icon if applicable
         if ($button.find('.state-icon').length == 0) {
            $button.prepend('<i class="state-icon ' + settings[$button.data('state')].icon + '"></i> ');
         }
      }
      init();
   });
})
</script>

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
               <h3 class="box-title">REGISTER BOARD</h3>
            </div>
            <!-- /.box-header -->
            <div class="container">
            <form id="/help/insert" role="form" method="post">
               <div class="box-body">
                  <div class="form-group">
                     <label for="exampleInputEmail1">제목</label> <input type="text"
                        name='q_Title' class="form-control" placeholder="Enter Title">
                  </div>
                  <div class="form-group">
                     <label for="exampleInputPassword1">문의 내용</label>
                     <textarea class="form-control" name="q_Content" rows="5"
                        placeholder="Enter ..."></textarea>
                  </div>
                  <div class="form-group">
                     <label for="exampleInputEmail1">작성자</label> <input type="text"
                        name="writer" class="form-control" placeholder="Enter Writer"
                        value="${login.c_id}" readonly="readonly">
                  </div>
                  <div class="form-group">
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
                  </div>
                  

               </div>

               <!-- /.box-body -->

               <div class="box-footer">
                  <div>
                     <hr>
                  </div>

                  <ul class="mailbox-attachments clearfix uploadedList">
                  </ul>
                  <!-- <div class="checkbox"> <label> <input type="checkbox" id="blankCheckbox" value="option1" aria-label="checkbox1" name="q_Secret">비밀글 </label> </div> -->
                  <button type="submit" class="btn btn-default pull-right" id="registerBtn">문의글 등록</button>
                  <span class="button-checkbox">
                     <button type="button" class="btn btn-default active pull-right" id="secret" data-color="warning">비밀글</button>
                     <!-- <i class="state-icon glyphicon glyphicon-check"></i> -->
                     <input type="checkbox" name="q_Secret" id="blankCheckbox" value="option1" aria-label="checkbox1" class="hidden">   
                  </span>
                  
               </div>
            </form>
            <a href = "/help/list"><button type="button" class="btn btn-default" id="listBtn">목록보기</button></a>
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