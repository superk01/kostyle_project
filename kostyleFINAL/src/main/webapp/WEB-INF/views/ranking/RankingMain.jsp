<%@page import="kostyle.login.domain.CustomerVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>
<%@ include file="../main/kostyleHeader.jsp"%>
<c:set var="path" 
value="${pageContext.request.contextPath}"/>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>KOStylemall 즐겨찾기</title>
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<!-- Bootstrap -->
<link rel="stylesheet" href="../../../resources/css/favorite/bootstrap.min.css" media="screen" title="no title" charset="utf-8">
<!-- font awesome -->
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
<!-- Custom style -->
<link rel="stylesheet" href="../../../resources/css/favorite/favoriteList.css" media="screen" title="no title" charset="utf-8">


<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script src="http://code.jquery.com/jquery-3.2.1.min.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

<script>
	var result = '${msg}';

	if (result == 'SUCCESS') {
		alert("처리가 완료되었습니다.");
	}
</script>

</head>

<body>

	<div class="body">

		<div class="page-header">
			<h1>쇼핑몰 순위</h1> <a href = "${path}/ranking/Rankingsort"> 랭킹 정렬 </a>
		</div>


		<div class="box">
			<div class="box-body">
				<table class="table table-hover">
					<thead>
						<tr>
							<th>IMAGE</th>
							<th>SHOPPING MALL</th>
							<th>COMMENT</th>
							<th>AGE</th>
						</tr>
					</thead>

					<tbody>
						<c:forEach items="${list}" var="RankingVO">

							<tr>
								<td><img id="s_image" src="//${RankingVO.s_image}"></td>
								<td><a href="http://${RankingVO.s_shopurl }">${RankingVO.s_sname}</a></td>
								<%-- <td><a
									href='/favorite/comentRead${pageMaker.makeQuery(pageMaker.cri.page)}&f_num=${Favorite.f_num }'>
										<img src="../../../resources/image/favoriteImg/comment.png"
										title="코멘트">
								</a></td> --%>
								<td>gkgk</td>
								<td>${RankingVO.s_age } 대</td>

						</c:forEach>
					</tbody>
				</table>
			</div>


			 <div class="box-footer">

					<div class="text-center">
						<ul class="pagination">

							<c:if test="${pageMaker.prev}">
								<li><a href="favoriteList${pageMaker.makeQuery(pageMaker.startPage - 1)}">&laquo;</a></li>
							</c:if>

							<c:forEach begin="${pageMaker.startPage }"
								end="${pageMaker.endPage }" var="idx">
								<li
									<c:out value="${pageMaker.cri.page == idx?'class =active':''}"/>>
									<a href="favoriteList${pageMaker.makeQuery(idx)}">${idx }</a>
								</li>
							</c:forEach>

							<c:if test="${pageMaker.next && pageMaker.endPage > 0}">
								<li><a href="favoriteList${pageMaker.makeQuery(pageMaker.endPage + 1)}">&raquo;</a></li>
							</c:if>
						<br><br>
						</ul>
					</div>
				</div>  
			<form id="jobForm">
				<input type='hidden' name="page" value=${pageMaker.cri.perPageNum}>
				<input type='hidden' name="perPageNum" value=${pageMaker.cri.perPageNum}>
				<br><br> 


			</form>
		</div>

	</div>

</body>

