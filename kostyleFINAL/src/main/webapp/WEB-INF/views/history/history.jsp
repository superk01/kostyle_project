<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ include file="../main/kostyleHeader.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" type="text/css" href="/resources/css/history/historyiFrame.css" />
<script type="text/javascript"  src="/resources/js/search/CategorysearchResult2.js"/>
<title>Insert title here</title>
<style type="text/css">
.table{
	width: 80%;
}
.prdurl {
	height: 100px;
	width: 100px;
}

.prdname {
	height: 100px;
	width: 200px;
}

.date {
	height: 100px;
}

.aaa {
	height: 100px;
	width: 100px;
}

#IframeRemocon {
	width: 1.5%;
	height: 110px;
	position: fixed;
	overflow: hidden;
	background: #3C3C3C;
	bottom: 30%;
	font-size: 17px;
	color: white;
	font-weight: bold;
	padding: 7px;
}
</style>
<script src="/resources/jquery/jquery-3.2.1.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	/* 가장 상단의 체크박스 클릭시에 모든 체크 박스가 선택 되도록. */
	$('#chkAll').click(function() {

		if ($(this).prop('checked')) {
			$('.checkbox').prop('checked', true);
		} else {
			$('.checkbox').prop('checked', false);
		}
	});
	/* 삭제 버튼을 눌렀을 때 몇 개의 체크박스가 있는지 확인하고 체크 되어 있는 상품들을 DB에서 삭제. */
	$('.deleteButton').click(function() {
		var h_num = "";
		var c_num = $('input[name=c_num]').val();
		/* alert(c_num); */

		$('input[name=box]:checked').each(function() {
			h_num = h_num+ $(this).val()+ ",";
		});
		h_num = h_num.substring(0, h_num.lastIndexOf(","));
		alert(h_num);
		if (h_num != "") {
			/* location.href="deleteHistoryAction.history?h_num="+h_num+"&c_num="+c_num; */
			$.ajax({
				url : "/history/delete?h_num="+ h_num,
				type : 'get',
				headers : {
					"Content-Type" : "application/json",
					"X-HTTP-Method-Override" : "GET"
				},
				dataType : 'text',
				success : function() {
					location.href = "/history/list/"+ c_num;
				}
			});
		} else {
			alert("상품을 선택하세요");
		}

		/* $('.checkbox').click(function(){
		   $('input[name=box]:checked').each(function(){
		      var test = $(this).val();
		      alert(test);
		      /* console.log(test); 
		   })
		}) */
	});
	$('.prdurl a').on('click',function(event) {
		var link = $(this).attr('href');
		location.href = "#CategoryResult_top";
		event.preventDefault();
		if ($('#CategorysearchIframe').length > 0) {
			$('#CategorysearchIframe').attr("src", link);
		} else {
			$('#CategoryResult_top').remove();
			$('table.table').parent().prepend(' <div id="IframeRemocon">쇼핑몰 닫기</div> ');
			$('table.table').parent().prepend('<iframe id="CategorysearchIframe" width="100%" height="900" src="'+link+ '">');
			$('table.table').prepend('<div id="#CategoryResult_top"></div>');
		}
		$('#IframeRemocon').click(function() {
			$('#CategorysearchIframe').remove();
			$('#IframeRemocon').remove();
		});
	})
	$('.prdname a').on('click',function(event) {
		alert('이벤트 확인');
		var link = $(this).attr('href');
		alert(link);
		location.href = "#CategoryResult_top";
		event.preventDefault();
		if ($('#CategorysearchIframe').length > 0) {
			$('#CategorysearchIframe').attr("src", link);
		} else {
			$('#CategoryResult_top').remove();
			$('table.talbe').parent().prepend('<div id="IframeRemocon">쇼핑몰 닫기</div> ');
			$('table.talbe').parent().prepend('<iframe id="CategorysearchIframe" width="100%" height="900" src="'+link+'">');
			$('table.talbe').prepend('<div id="#CategoryResult_top"></div>');
		}
		$('#IframeRemocon').click(function() {
			$('#CategorysearchIframe').remove();
			$('#IframeRemocon').remove();
		});
	});
});
</script>
</head>
<body>


	<div class="container">
		<!-- 최근본 상품정보 컨터이너 -->
		<table border="1px solid" class="table" >
			<!-- 최근 본 상품정보 테이블 -->
			<caption>최근 본 상품 정보</caption>
			<colgroup>
				<col width="">
				<col width="">
				<col width="">
				<col width="">
				<col width="">
			</colgroup>
			<thead>
				<tr>
					<th class="first col-md-1" scope="col" abbr="상품선택 체크박스">
						<div class="th_checkall">
							<label for="chkAll"> <input id="chkAll" name="chkAll"
								type="checkbox"> <!-- 온클릭 이벤트(체크박스 전부 체크되는 거)있음 -->
							</label>
						</div>
					</th>
					<th scope="col" class="col-md-3">이미지</th>
					<th scope="col" class="col-md-4">상품이름</th>
					<th scope="col" class="col-md-4">날짜</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="history" items="${list }">
					<tr>
						<td>
							<div>
								<label> <input class="checkbox" name="box"
									type="checkbox" value="${history.h_Num }"> <input
									name="c_num" type="hidden" value="${history.c_Num }">
								</label>
							</div>
						</td>
						<td class="prdurl"><a href="${history.h_Prdurl }"><img
								alt="" src="${history.h_Imgurl }" class="aaa"></a></td>
						<td class="prdname"><a href="${history.h_Prdurl }">${history.h_Name }</a></td>
						<td class="date">${history.h_Date }</td>
					</tr>
				</c:forEach>
			</tbody>

		</table>
		<input type="button" value="상품삭제" class="deleteButton">
	</div>
	<div class="text-center">
		<ul class="pagination">

			<c:if test="${pageMaker.prev}">
				<li><a href="/history/list/${login.c_num }?page=${pageMaker.startPage - 1}">&laquo;</a></li>
			</c:if>

			<c:forEach begin="${pageMaker.startPage }"
				end="${pageMaker.endPage }" var="idx">
				<li <c:out value="${pageMaker.cri.page == idx?'class =active':''}"/>>
					<a href="/history/list/${login.c_num }?page=${idx}">${idx}</a>
				</li>
			</c:forEach>

			<c:if test="${pageMaker.next && pageMaker.endPage > 0}">
				<li><a href="/history/list/${login.c_num }?page=${pageMaker.endPage +1}">&raquo;</a></li>
			</c:if>

		</ul>
	</div>
</body>
</html>