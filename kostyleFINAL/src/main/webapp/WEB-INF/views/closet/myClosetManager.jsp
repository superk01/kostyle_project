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
<!-- <script src="../../../resources/js/closet/myClosetManager.js"></script> -->
<script type="text/javascript">
//옷장의 폴더와 관련된 이벤트들모음. 단, 폴더관리창(자식창)을 여는이벤트 하나는 부모쪽에 있음.

$(function(){
	/* 창 닫을때 session에서 제거이벤트. 열 때와비슷. */
$(window).bind("beforeunload", function (){
	alert("윈도우 비포어 언로드 이벤트");
	//닫을때는 세션의 이름과 삭제여부만 필요.
		var attriName = "closetTab";
		//alert("attriVlaue의타입: "+typeof(attriValue));
		var attriCD = "delete";
		var param = "attriName="+attriName
					+"&attriCD="+attriCD; //속성 create/delete
		
		//alert("세션CDAttri param값: "+param);
		$.ajax({
			headers: { 
		        'Accept': 'application/json',
		        'Content-Type': 'application/json; charset=UTF-8'
		    },
		type: "post",
		url : "/closetfolder/cdSessionAttribute",
		data : JSON.stringify({
			attriName : attriName,
			attriCD : attriCD
       }),
		async: false,
		success: function (data){
		//alert("ajax결과: session: "+data);
			alert("세션삭제ajax완료.");
		}  ,
		error : function(xhr, status, error) {
			alert("세션삭제ajax실패");
			//alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
		}
	});
});

//F5, ctrl + F5, ctrl + r 새로고침 막아야 beforeunload의 문제점이 해결된다.(새로고침시 작동)
$(document).keydown(function (e) {
	            if (e.which === 116) {
	                if (typeof event == "object") {
	                    event.keyCode = 0;
	                }
	                return false;
	            } else if (e.which === 82 && e.ctrlKey) {
	                return false;
	            }
	}); 
});	
/* 저장버튼 누른 후 마지막 창닫기
	opener.location.reload();
	self.close();
	window.opener.parent.location.reload();
	window.opener.document.reload();

	window.self.close();

*/
//옷장폴더추가(db안거치고 ui만.)
$(function(){
	$('#folderAddBtn').on('click',function(){
		var clo_nums = new Array(); //배열로 안돌리면 첫번째 값만 가져온다.
		$('.folder_clo_num').each(function(){
			clo_nums.push($(this).val());
		});
		//alert("clo_nums들: "+clo_nums);
		
		var insert_clo_num = arrayMax(clo_nums) +1; // +1해야 새로 추가할 clo_num
		//alert("insert_clo_num = "+insert_clo_num);
		
		var html = "";
		html += '<tr><td><input type="checkbox" class="checkCloset folder_clo_num" value="';
		html += insert_clo_num;
		html += '" /></td><td class="secondtd">&nbsp&nbsp<input class="closetTitle" type="text"'; 
		html +=	'value="나만의옷장"> </td></tr>';
		$('#closetTable tbody').append(html);
	});
});

function arrayMax(array){ //배열의 가장 큰 수.(폴더목록UI추가시 clo_num구하기위함) 
	var max = Math.max.apply(null,array)
	return max;
}

$(function(){
	//옷장폴더 삭제(db안거치고 ui만.)
	$('#folderDeleteBtn').on('click', function(){
		var clo_nums = folderDeleteBtn_click();
		//alert("clo_nums값:"+clo_nums);
		//var clo_num = $(opener.document,'#navi li[class=selectTab]').attr("id");
		//alert("부모창에서 가져온 selectclo_num: "+clo_num); 
		
		$("#closetManagerSection input:checkbox:checked").each(function (index) {
			if($(this).attr('id') != 'allcheckCloset'){//전체 체크 총괄하는 애는 필요없음			str += $(this).val()+",";  
				$(this).parents('#closetTable tbody tr').remove();
			}
		});  
	});

	
	//옷장변경저장(추가,이름수정,삭제 반영)
		$('#folderSaveBtn').on('click',function(){
			alert("#folderSaveBtn 진입");
			var folder_clo_nums	= folderUpdateBtn_click('.folder_clo_num');
			var closet_titles = folderUpdateBtn_click('.closetTitle');
			
			var param =  "folder_clo_nums="+folder_clo_nums+
			"&closet_titles="+closet_titles;
			
			alert("보내는 param: "+param);
			$.ajax({
				headers: { 
			        'Accept': 'application/json',
			        'Content-Type': 'application/json; charset=UTF-8'
			    },
				type:"post",
				url : "/closetfolder/saveCloset",
				data : JSON.stringify({
					 folder_clo_nums : folder_clo_nums,
					closet_titles : closet_titles
		         }),
				success: function(data){
					opener.location.reload();
					alert("옷장폴더수정 완료");
					self.close();
				},
				error : function(xhr, status, error) {
					alert("folder save ajax실패");
					//alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
		
				}
			});
	});
});



function folderDeleteBtn_click() {  
	var str = "";  
	$("#closetManagerSection input:checkbox:checked").each(function (index) {
		if($(this).attr('id') != 'allcheckCloset'){//전체 체크 총괄하는 애는 필요없음			str += $(this).val()+",";  
			str += $(this).val()+",";
		}
	});  
	return str;  
} 

function folderUpdateBtn_click(object) {
	var str = "";
	if(object == '.folder_clo_num'){//체크박스가아닌 기본폴더는 value가 1인데 jsp상에 값이 없으니까..
		str += "1"; //따옴표 붙이지 않아도 밑에서 1+공백+따옴표 자동으로 붙는다
	}    
	$(object).each(function(index){
		str += $(this).val()+",";
	})
	return str;  
} 




</script>

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