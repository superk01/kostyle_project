<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<style type="text/css">
.prdurl{
   height: 100px;
   width: 100px;
}
.prdname{
   height: 100px;
   width : 200px;
}
.date{
   height: 100px;
}
.aaa{
   height: 100px;
   width: 100px;
}
#IframeRemocon{
   width: 1.5%;
   height: 110px;
   position: fixed;
   overflow: hidden;
   background: #3C3C3C;
   bottom: 30%;
   
   font-size : 17px;
   color : white;
   font-weight : bold;
   padding : 7px;
}

</style>
<script src="../../../resources/jquery/jquery-3.2.1.js"></script>
<script type="text/javascript">
$(document).ready(function(){
   $('#chkAll').click(function(){
	   
      if($(this).prop('checked')){
         $('.checkbox').prop('checked',true);
      }else{
         $('.checkbox').prop('checked',false);
      }
   });
   
   $('.deleteButton').click(function(){
      var h_num = "";
      var c_num = $('input[name=c_num]').val();
      alert(c_num);
      
      $('input[name=box]:checked').each(function(){
         h_num = h_num + $(this).val()+",";
      });
      h_num = h_num.substring(0,h_num.lastIndexOf(","));
      alert(h_num);
      if(h_num !=""){
         /* location.href="deleteHistoryAction.history?h_num="+h_num+"&c_num="+c_num; */
         $.ajax({
        	url:"${path}/history/delete/"+h_num,
        	type : 'delete',
			headers:{
				"Content-Type":"application/json",
				"X-HTTP-Method-Override":"DELETE"
			},
			dataType:'text',
			success:function(){
				location.href="${path}/history/list/"+c_num;
			}
         });
      }else{
         alert("상품을 선택하세요");
      }   
   
      
   /* $('.checkbox').click(function(){
      $('input[name=box]:checked').each(function(){
         var test = $(this).val();
         alert(test);
         /* console.log(test); 
      })
   }) */
}); 
   $('.prdurl a').on('click',function(event){
       var link = $(this).attr('href');
         location.href = "#CategoryResult_top";
         event.preventDefault();
         if($('#CategorysearchIframe').length > 0){
            $('#CategorysearchIframe').attr("src", link);
         }else{
           $('#CategoryResult_top').remove();     
           $('table.table').parent().prepend(' <div id="IframeRemocon">쇼핑몰 닫기</div> ');
           $('table.table').parent().prepend('<iframe id="CategorysearchIframe" width="100%" height="900" src="' +link +'">');
           $('table.table').prepend('<div id="#CategoryResult_top"></div>');
         }
         $('#IframeRemocon').click(function(){
            $('#CategorysearchIframe').remove();
            $('#IframeRemocon').remove();
         });
   })
   $('.prdname a').on('click',function(event){
       var link = $(this).attr('href');
         location.href = "#CategoryResult_top";
         event.preventDefault();
         if($('#CategorysearchIframe').length > 0){
            $('#CategorysearchIframe').attr("src", link);
         }else{
           $('#CategoryResult_top').remove();     
           $('table.talbe').parent().prepend(' <div id="IframeRemocon">쇼핑몰 닫기</div> ');
           $('table.talbe').parent().prepend('<iframe id="CategorysearchIframe" width="100%" height="900" src="' +link +'">');
           $('table.talbe').prepend('<div id="#CategoryResult_top"></div>');
         }
         $('#IframeRemocon').click(function(){
            $('#CategorysearchIframe').remove();
            $('#IframeRemocon').remove();
         });
   });
});

</script>
</head>
<body>
   
   <div> <!-- 최근본 상품정보 컨터이너 -->
      <div id="CategoryResult_top"></div>
      <table border="1px solid" class="table"> <!-- 최근 본 상품정보 테이블 -->
         <caption>최근 본 상품 정보</caption>
         <colgroup>
            <col width = "">
            <col width = "">
            <col width = "">
            <col width = "">
            <col width = "">
         </colgroup>
         <thead>
            <tr>
               <th class = "first" scope="col" abbr="상품선택 체크박스">
                  <div class = "th_checkall">
                     <label for="chkAll">
                        <input id="chkAll" name ="chkAll"type="checkbox">
                        <!-- 온클릭 이벤트(체크박스 전부 체크되는 거)있음 -->
                     </label>
                  </div>
                  상품명
               </th>
               <th scope="col">이미지</th>
               <th scope="col">상품이름</th>
               <th scope="col">날짜</th>
            </tr>
         </thead>
         <tbody>
            <c:forEach var="history" items="${list }">
               <tr>
                  <td>
                     <div>
                        <label>
                           <input class="checkbox" name="box" type="checkbox" value="${history.h_Num }">
                           <input name="c_num" type="hidden" value="${history.c_Num }">
                        </label>
                     </div>
                  </td>
                  <td class="prdurl"><a href="${history.h_Prdurl }" ><img alt="" src="${history.h_Imgurl }" class="aaa"></a></td>
                  <td class="prdname"><a href="${history.h_Prdurl }">${history.h_Name }</a></td>
                  <td class="date">${history.h_Date }</td>
               </tr>
            </c:forEach>
         </tbody>
   
      </table>
      <input type="button" value="상품삭제" class="deleteButton"> 

   </div>
</body>
</html>