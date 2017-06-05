<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>고객문의 게시판</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
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
	 $(document).ready(function(){
			
		 	/* alert(${pageMaker.prev}); */
		 	$('#fn_write').on('click', function(){
		 		location.href="/help/insert";
		 	});
		 	/* function fn_searchMine() {
				location.href = "searchMineAction.a?c_num=1";
			};
			function fn_write() {
				location.href = "/help/insert";
			};
			function fn_list() {
				location.href = "/help/list";
			}; */
			var formObj = $("form[role='form']");
			$("input[type='submit']").on('click', function(){
				formObj.attr("action","list");
				formObj.attr("method","get");
				formObj.submit();
			});
	 });
	
</script>
</head>
<body>
<div class="box">
	<div class="box-header with-border">
	<h3 class="box-title">고객센터</h3>
	</div>
	<button>자무 묻는 질문</button>
	<button>문의 게시판</button>
	<div class="box-body">
	<table class="table table-bordered">
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
					<td>${board.q_Num }</td>
					<!--글 번호  -->
					<!-- <td>답변 여부</td> -->
					<td>${board.s_Name }</td>
					<!--쇼핑몰 번호  -->
					<td><a href="/help/detail?q_num=${board.q_Num }">${board.q_Title }</a></td>
					<td>${board.c_Id }</td>
					<!--작성자 Id  -->
					<td>${board.q_Date }</td>
					<!--작성 날짜, 시간  -->
				</tr>
			</tbody>
		</c:forEach>
	</table>
	</div>

	<div class="text-center">
		<ul class="pagination">
			<c:if test="${pageMaker.prev }">
				<li><a href="list?page=${pageMaker.startPage - 1 }">[이전]</a></li>
			</c:if>
			<!-- 페이지 목록 -->
			<c:forEach var="pageNo" begin="${pageMaker.startPage }" end="${pageMaker.endPage }">
				<li>
					<%-- <c:out value="pageMaker.cri.page==pageNo?"></c:out> --%>
					<a  href="list?page=${pageNo }">${pageNo }</a>
				</li>
			</c:forEach>
			<!-- 이후 -->
			<c:if test="${pageMaker.endPage>0&&pageMaker.next }">
				<li><a href="list?page=${pageMaker.endPage + 1 }">[이후]</a></li>
			</c:if>
		</ul>
	</div>
</div>


<!-- 검색 입력 부분 -->
<%-- 	<div class='box-body'>
			<select name="searchType">
						<option value="n"
							<c:out value="${cri.searchType == null?'selected':''}"/>>
							---</option>
						<option value="t"
							<c:out value="${cri.searchType eq 't'?'selected':''}"/>>
							Title</option>
						<option value="c"
							<c:out value="${cri.searchType eq 'c'?'selected':''}"/>>
							Content</option>
						<option value="w"
							<c:out value="${cri.searchType eq 'w'?'selected':''}"/>>
							Writer</option>
						<option value="tc"
							<c:out value="${cri.searchType eq 'tc'?'selected':''}"/>>
							Title OR Content</option>
						<option value="cw"
							<c:out value="${cri.searchType eq 'cw'?'selected':''}"/>>
							Content OR Writer</option>
						<option value="tcw"
							<c:out value="${cri.searchType eq 'tcw'?'selected':''}"/>>
							Title OR Content OR Writer</option>
					</select> <input type="text" name='keyword' id="keywordInput"
						>
					<button id='searchBtn'>Search</button>
					<button id='newBtn'>New Board</button>

				</div> --%>

<!-- 검색 입력 부분 -->
	<form action="listAction2.a" method="post" role="form">
		<input type="hidden" name="searchType" value="temp"></input> 
		<select id="searchCat" name="searchType">
			<option value="q_title">제목</option>
			<option value="c_Id">작성자</option>
		</select>
		<input type="text" name="keyWord" size="10"> 
		<input type="submit" value="검색">
	</form>
	<input type="button" value="글쓰기" id="fn_write">
	<input type="button" value="내글보기" id="fn_searchMine"
		onclick="fn_searchMine()">
	<input type="button" value="전체글목록" id="list" onclick="fn_list()">



</body>
</html>