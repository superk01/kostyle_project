<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>고객문의 게시판</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript">
/* $(function(){
		
	$("#fn_searchMine").click(function(){
		alert("qqq");
		location href = "searchMineAction.a?c_num=1";
	});
	$("#fn_write").click(function(){
		alert("qqq");
		location href = "write.jsp"; 
	});
});  */
function fn_searchMine(){
	location.href = "searchMineAction.a?c_num=1"
}
function fn_write(){
	location.href = "writeAction.a"
}
function fn_list(){
	location.href = "listAction2.a?reset=1"
}


</script>
</head>
<body>
<h3>고객센터</h3>
<button>자무 묻는 질문</button>
<button>문의 게시판</button>
	<table border="1px solid">
		<thead>
			<tr>
				<th>게시글 번호</th>
				<!-- <th>답변 여부</th> -->
				<th>대상 쇼핑몰</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th>
			</tr>
		</thead>
		<c:forEach var="board" items="${list }">
		<tbody>
			<tr>
				<td>${board.q_Num }</td>					<!--글 번호  -->
				<!-- <td>답변 여부</td> -->
				<td>${board.s_Name }</td>					<!--쇼핑몰 번호  -->
				<td><a href = "detailAction.a?q_num=${board.q_Num }">${board.q_Title }</a></td>
				<td>${board.c_Id }</td>						<!--작성자 Id  -->
				<td>${board.q_Date }</td>					<!--작성 날짜, 시간  -->
			</tr>
		</tbody>
		</c:forEach>
	</table>
	
	
<%-- 	<c:if test="${listModel.startPage>5 }">
		<a href = "listAction2.a?requestPage=${listModel.startPage - 5 }">[이전]</a>
	</c:if> 
	<!-- 페이지 목록 -->
	<c:forEach var="pageNo" begin="${listModel.startPage }" end = "${listModel.endPage }">
		<c:if test="${listModel.requestPage==pageNo }"><b></c:if>
			<a href = "listAction2.a?requestPage=${pageNo }">[${pageNo }]</a>
		<c:if test="${listModel.requestPage==pageNo }"></b></c:if>
	</c:forEach>	
	<!-- 이후 -->
	<c:if test="${listModel.endPage<listModel.totalPage }">
		<a href = "listAction2.a?requestPage=${listModel.startPage + 5 }">[이후]</a>
	</c:if>
	 --%>
	
	
	
	
	
	
	<form action="listAction2.a" method="post">
		 <input type="hidden" name="temp" value="temp"></input>
		 					
						<select id="searchCat" name = "area">
							<option value="q_title">제목</option>
							<option value="c_num">작성자</option>
						</select>
					
		 <!-- <input type="checkbox" name="area" value="q_title">제목</input>
		 <input type="checkbox" name="area" value="q_name">작성자</input> -->
		 <input type="text" name="searchKey" size="10">
		 <input type="submit" value="검색">
	</form>
	<input type="button" value="글쓰기" id="fn_write" onclick="fn_write()">
	<input type="button" value="내글보기" id="fn_searchMine" onclick="fn_searchMine()">
	<input type="button" value="전체글목록" id="list" onclick="fn_list()">
	


</body>
</html>