<%@page import="kostyle.login.domain.CustomerVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="../main/kostyleHeader.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>KOStylemall 즐겨찾기</title>
<link rel="stylesheet" href="/resources/css/favorite/favoriteList.css" media="screen" title="no title" charset="utf-8">
<script type="text/javascript" src="/resources/js/favorite/favoriteIframe.js"></script>

<script>
	var result = '${msg}';

	if (result == 'SUCCESS') {
		alert("처리가 완료되었습니다.");
	}
</script>

<style type="text/css">
.table>thead>tr>th, .table>tbody>tr>th, .table>tfoot>tr>th, 
.table>thead>tr>td, .table>tbody>tr>td, .table>tfoot>tr>td{
	vertical-align: middle !important;
}
</style>

</head>

<body>

<div class="body">

		<div class="page-header">
			<h1>즐겨찾기</h1>
		</div>
		
		
<div id="favoritebackground">
<div id="favoriteBodyTop"></div>
<br><br>

		<div class="box">
			<div class="box-body">
				<table class="table table-hover">
					<thead>
						<tr  class="tr">
							<th class="th">IMAGE</th>
							<th class="th">SHOPPING MALL</th>
							<th class="th">COMMENT</th>
							<th class="th">HOME</th>
							<th class="th">DELETE</th>
						</tr>
					</thead>

					<tbody>
						<c:forEach items="${list}" var="Favorite">

							<tr  class="tr">
								<td class="td"><img id="s_image" src="http://${Favorite.s_image}"></td>
								<td class="td"><a class="shoplink" href="http://${Favorite.s_shopurl }">${Favorite.s_sname}</a></td>
								<td class="td"><a
									href='/favorite/comentRead${pageMaker.makeQuery(pageMaker.cri.page)}&f_num=${Favorite.f_num }'>
										<img src="/resources/image/favoriteImg/comment.png"
										title="코멘트">
								</a></td>
								<td class="td"><a class="shoplink" href="http://${Favorite.s_shopurl }">
								<img src="/resources/image/favoriteImg/home.png" title="쇼핑몰 이동"></a></td>
								<td class="td"><a href="/favorite/deleteFavorite?f_num=${Favorite.f_num }&c_num=${Favorite.c_num}"><img
										src="/resources/image/favoriteImg/delete2.png"
										title="즐겨찾기 삭제"></a></td>
							</tr>

						</c:forEach>
					</tbody>
				</table>
			</div>


			 <div class="box-footer">

					<div class="text-center">
						<ul class="pagination" id="pagenation">

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

</div>

</body>

