<%@page import="kostyle.stats.domain.SearchKeywordChart"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
HttpSession statsSearchRankSession = request.getSession();

List<SearchKeywordChart> list = (List) statsSearchRankSession.getAttribute("statsSearchRankJ");

%>    

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>

<table>
	<thead>
		<tr>
			<td>검색어</td>
		</tr>
	</thead>
	<tbody>
		<%for(int i=0;i<5;i++){ %>
		<tr><td><%=list.get(i).getSk_searchkey() %></td></tr>
		<%} %>
	</tbody>



</table>






</body>

<script>

$(document).ready(function(){

	$.ajax({
		type:'post',
		url:'/stats/statsSearch',
		success:function(result){
			alert(result);

		}
	});
	
});


</script>
</html>