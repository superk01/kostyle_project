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
<style type="text/css">
.coordiImg{
   width: 300px;
   height: 450px;
   padding-top: 55px;
}

.box{
   margin: 0 5%;
}

th{
   text-align: center;
}

.explain{
   text-align: center;
   color: #428bca;
}

.cdname{
	color: gray;
	font-size: 15px;
	text-align: center;
}


.col-sm-4{
	text-align: center;
}

</style>
<title>Insert title here</title>
</head>
<body>
<div class="box">
      <div class="page-header">
         <h1>오늘의 코디</h1>
         <p class="explain">마음에 드는 상품에 들어가 <b><i class="fa fa-thumbs-o-up"></i>좋아요</b>를 눌러주세요.</p>
         <p class="explain">회원님들의 좋아요 순에 따라 메인 상단에 게시됩니다!</p>
      </div>


      <div class="box-body">
      <div class="container">
      <table class="table table-bordered">
         <thead>
            <tr class="tr">
               <!-- <th class="th">NO</th> -->
               <!-- <th>답변 여부</th> -->
               <!-- <th class="th">대표이미지</th>
               <th class="th">제목</th> -->
               <!-- <th class="th">쇼핑몰</th>
               <th class="th">작성일</th> -->
            </tr>
         </thead>
         <div class="row">
         <c:forEach var="coordi" items="${list }">
            <%-- <tbody>
               <tr class="tr">
                  <td class="td">${coordi.cd_num }</td>
                  <!--글 번호  -->
                  <!-- <td>답변 여부</td> -->
                  <td class="td"><img class="coordiImg" src="/${coordi.cd_img }"></td>
                  <!--쇼핑몰 번호  -->
                  <td class="td"><a href="/coordinator/detail?cd_num=${coordi.cd_num }">${coordi.cd_name }</a></td>
                  <td class="td">${coordi.s_num }</td>
                  <!--작성자 Id  -->
                  <td class="td">${coordi.regdate }</td>
                  <!--작성 날짜, 시간  -->
               </tr>
            </tbody> --%>
            
            <div class="col-sm-4"><img class="coordiImg" src="/${coordi.cd_img }"><br>
            <a class="cdname" href="/coordinator/detail?cd_num=${coordi.cd_num }">${coordi.cd_name }</a></div>
         	
         </c:forEach>
         </div>
      </table>
      <button id="write" class="btn btn-default btn-lg pull-right"><a href="/coordinator/coordiregister">글쓰기</a></button>
      </div>
      </div>
   <div class="form-group">
                     <div class="col-sm-12" style="height:50px;">
                </div>
      <%-- <div class="text-center">
         <ul class="pagination">
            <c:if test="${pageMaker.prev }">
               <li><a href="list${pageMaker.makeSearch(pageMaker.startPage - 1) }">[이전]</a></li>
            </c:if>
            <!-- 페이지 목록 -->
            <c:forEach var="pageNo" begin="${pageMaker.startPage }" end="${pageMaker.endPage }">
               <li
                  <c:out value="${pageMaker.cri.page==pageNo?'class=active':''}"/>>
                  <a  href="list${pageMaker.makeSearch(pageNo) }">${pageNo }</a>
               
            </c:forEach>
            <!-- 이후 -->
            <c:if test="${pageMaker.endPage>0 && pageMaker.next }">
               <li><a href="list${pageMaker.makeSearch(pageMaker.endPage + 1) }">[이후]</a></li>
            </c:if>
         </ul>
      </div> --%>
</div>
</body>
</html>