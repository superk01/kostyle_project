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
<title>고객문의 게시판</title>
<link rel="stylesheet" type="text/css" href="/resources/css/help/list.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!-- <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css"> -->

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
		 	/* alert(${login.c_id}); */
			
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
			
			$('#write').on('click',function(){
				location.href="/help/insert";
			});
	 });
	
</script>
<style type="text/css">
 .body {
	margin: 0 5%;
	font-family: 맑은 고딕;
}

th.th{
	text-align: center;
	border-bottom: 3px solid;
}

.tr{
	text-align: center;
	font-size: 20px;
	color: black;
}

.td{
	vertical-align: center;
}

.td a{
	color: black;
	text-align: center;
	margin-top: 3px;
}
</style>
</head>
<body>
<div class="body">
	<div class="page-header">
			<h3>고객센터</h3>
	</div>
</div>
	<div class="box">
		<div class="box-body">
		<table class="table table-bordered">
			<thead>
				<tr class="tr">
					<th class="th">게시글 번호</th>
					<!-- <th>답변 여부</th> -->
					<th class="th">대상 쇼핑몰</th>
					<th class="th">제목</th>
					<th class="th">작성자</th>
					<th class="th">작성일</th>
				</tr>
			</thead>
			<c:forEach var="board" items="${list }">
				<tbody>
					<tr class="tr">
						<td class="td">${board.q_Num }</td>
						<!--글 번호  -->
						<!-- <td>답변 여부</td> -->
						<td class="td">${board.s_Name }</td>
						<!--쇼핑몰 번호  -->
						<td class="td"><a href="/help/detail?q_num=${board.q_Num }">${board.q_Title }</a></td>
						<td class="td">${board.c_Id }</td>
						<!--작성자 Id  -->
						<td class="td">${board.q_Date }</td>
						<!--작성 날짜, 시간  -->
					</tr>
				</tbody>
			</c:forEach>
		</table>
		<button id="write">글쓰기</button>
		</div>
	
		<div class="text-center">
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
		</div>
		  <div class="board-foot">
			<div class="board-foot-search" data-role="view-search">
				<input id="viewSearchBoardCd" type="hidden" value="community">
				
				<div class="btn-group bootstrap-select select">
					<!-- <button title="통합검색" class="btn dropdown-toggle btn-default"
						aria-expanded="false" type="button" data-toggle="dropdown">
						<span class="filter-option pull-left">통합검색</span>&nbsp;<span
							class="bs-caret"><span class="caret"></span></span>
					</button> -->
					<div class="dropdown-menu open">
						<ul class="dropdown-menu inner" role="menu">
							<li class="selected" data-original-index="0"><a tabindex="0"
								data-tokens="null"><span class="text">통합검색</span><span
									class="glyphicon glyphicon-ok check-mark"></span></a></li>
							<li data-original-index="1"><a tabindex="0"
								data-tokens="null"><span class="text">작성자</span><span
									class="glyphicon glyphicon-ok check-mark"></span></a></li>
							<li data-original-index="2"><a tabindex="0"
								data-tokens="null"><span class="text">댓글작성자</span><span
									class="glyphicon glyphicon-ok check-mark"></span></a></li>
						</ul>
					</div>
					
			 	<form action="/help/list" method="get" role="form">
						<select tabindex="-98" class="select"
							data-role="total-select-filter" id="select" name="searchType">
							<option value="q_title">제목</option>
							<option value="c_Id">작성자</option>
						</select>
					</div>
					<input title="검색" class="search-input" type="text"
						placeholder="검색어를 입력하세요." data-role="total-input-keyword" name="keyWord">
					<button class="button-md button-search" type="button"
						data-role="total-submit">
						<span class="fa fa-search"></span>
					</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
