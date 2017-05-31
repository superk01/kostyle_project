<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>게시글 상세보기</title>
<script src="../jquery/jquery-3.2.1.js"></script>
<script type="text/javascript">
/* $(function(){
	$('.update').on('click',function(){
		location.href = "updateForm.a?q_num=${board.q_Num}";
	});
	
	
} */
function fn_update(){
	location.href = "updateForm.a?q_num=${board.q_Num}";
}
function fn_delete(){
	location.href = "deleteAction.a?q_num=${board.q_Num}";
}
function fn_list(){
	location.href = "listAction2.a";
}

</script>
</head>
<body>
	<h2>글 상세보기</h2>
			<table border="1">
		<tr height="30">
			<td width="150">글번호</td>
			<td width="150">${board.q_Num }</td>
	
		</tr>
		<tr height="30">
			<td width="150">작성자</td>
			<td width="150">${board.c_Id }</td>
			<td width="150">작성일</td>
			<td width="150">
				<fmt:formatDate value="${board.q_Date }" pattern="yyyy-MM-dd"/>
			</td>
		</tr>			
		<%-- <tr height="30">
			<td width="150">파일</td>
			<td colspan="3">
				<a href="download.jsp?filename=${board.b_fname }">${board.b_fname }</a>
			</td>			
		</tr> --%>
		<tr height="30">
			<td width="150">제목</td>
			<td colspan="3">${board.q_Title }</td>			
		</tr>
		<tr height="30">			
			<td colspan="4">${board.q_Content }</td>			
		</tr>
		<tr height="30">			
			<td colspan="4">
				<input type="button" value="글목록" onclick="fn_list()">
				<input type="button" value="수정" onclick="fn_update()">
				<input type="button" value="삭제" onclick="fn_delete()">
			</td>			
		</tr>
		
		<c:forEach var="answer" items="${list }">
		<tr height="30">
			<td align="center" colspan="2">${answer.as_Title }</td>
			<%-- <td align="center">${작성자 }</td> --%>
			<td align="center">${answer.as_Date }</td>
		</tr>
		<tr>
		<td align="left" colspan="4"><textarea rows="3" cols="70">${answer.as_Content }</textarea> </td>
		</tr>
		</c:forEach>
		
		<tr height="30">
			<td colspan="3">
			<form action="detailAction.a" method="post">
				<input type="text" name="as_title">
				<textarea rows="3" cols="70" name="as_content"></textarea>
				<input type="hidden" name = "q_num" value="${board.q_Num }">
				<input type="text" name = "as_writer">
				<input type="submit" value="댓글달기" >
				</form>
				</td>
				
				
	</table>

</table>
</body>
</html>