<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>KOStylemall 즐겨찾기</title>
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<!-- Bootstrap -->
<link rel="stylesheet" href="../../../resources/css/favorite/bootstrap.min.css"	media="screen" title="no title" charset="utf-8">
<!-- font awesome -->
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css">
<!-- Custom style -->
<link rel="stylesheet" href="../../../resources/css/favorite/style.css"	media="screen" title="no title" charset="utf-8">


<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script src="http://code.jquery.com/jquery-3.2.1.min.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
</head>
<body>

<div class="page-header">
			<h1>
				즐겨찾기
			</h1>
</div>
		

<div class="box">
				
				<div class="box-body">
					<table class="table table-hover">
					<thead>
						<tr>
							<th>IMAGE</th>
							<th>SHOPPING MALL</th>
							<th>COMMENT</th>
							<th>HOME</th>
							<th>DELETE</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${list}" var="Favorite">

							<tr>
								<td><img src="${Favorite.s_image}"></td>
								<td><a	href="http://${Favorite.s_shopurl }">${Favorite.s_sname}</a></td>
								<td><a href="/favorite/comentRead">${Favorite.f_coment}</a></td>
								<td><a href="http://${Favorite.s_shopurl }">쇼핑몰이동</a></td>
								<td><button type="submit" value="삭제"></button></td> 
							</tr>

						
							<%-- <tr>
								<td>이미지</td>
								<td>즐겨찾기 이름</td>
								<td>${Favorite.f_coment}</td>
								<td>쇼핑몰 이동</td>
								<td>삭제</td>
							</tr> --%>
							</c:forEach>
						</tbody>
							
							
					</table>
				</div>
</div>


</body>
</html>