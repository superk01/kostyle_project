<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="../../../resources/css/closet/closet.css" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="../../../resources/js/closet/closet.js"></script>
<script src="../../../resources/js/closet/myClosetManager.js"></script>

<title>Kostyle_closetManager</title>
</head>
<body>
	<section id ="closetManagerSection" >
			<h2>My옷장 관리</h2>
		<div id="managerLeftDiv">
				<table id="closetTable"> 
					<thead>
						<tr id="fisrttr">
							<td rowspan="2"><input type="checkbox" id="allcheckCloset" class="checkCloset" value="allCheckCloset" /></td>
							<td rowspan="2">&nbsp&nbsp<b>전체선택</b>(삭제시)</td>
						</tr>
					</thead>
							<br>
					<tbody> 
						<c:forEach var="tab"  items="${sessionScope.closetTab}" >
							<c:choose >
								<c:when test="${tab.clo_num == 1}">
								<tr>
									<td><img class="folder_clo_num" src="../resources/images/closetImg/locked-1.png" alt= "" value="${tab.clo_num }" ></td>
									<td class="secondtd">&nbsp&nbsp<input class="closetTitle" type="text" value="${tab.clo_name }" readonly="readonly"> </td>
								</tr>						
							   </c:when>
				   				<c:otherwise>
								<tr>
									<td><input type="checkbox" class="checkCloset folder_clo_num" value="${tab.clo_num }" /></td>
									<td class="secondtd">&nbsp&nbsp<input class="closetTitle" type="text" value="${tab.clo_name }"> </td>
								</tr>						
							   </c:otherwise>
							   </c:choose>
						</c:forEach>
					</tbody>
				</table>
		</div>
			<div id="managerRightDiv">
				<button type="button" value="선택폴더삭제" class="folderBtn" id="folderDeleteBtn">선택삭제</button>
				<button type="button" value="폴더추가" class="folderBtn" id="folderAddBtn">폴더추가</button>
				<button type="button" value="수정완료" class="folderBtn" id="folderSaveBtn">저장</button>
			</div>
	</section>	

</body>
</html>