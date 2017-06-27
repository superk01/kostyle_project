<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
    <meta charset="utf-8">
    <meta name="robots" content="noindex">

    <title>KOStyle - 옷장 편집</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
         <!-- Latest jQuery form server -->
    <script src="http://code.jquery.com/jquery-3.2.1.min.js"></script>   
 <link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css"> 
    
    <style type="text/css">
	   .trash { color:rgb(209, 91, 71); }
		.flag { color:rgb(248, 148, 6); }
		.panel-body { padding:0px; }
		.panel-footer .pagination { margin: 0; }
		.panel .glyphicon,.list-group-item .glyphicon { margin-right:5px; }
		.panel-body .radio, .checkbox { display:inline-block;margin:0px; }
		.panel-body input[type=checkbox]:checked + label { text-decoration: line-through;color: rgb(128, 144, 160); }
		.list-group-item:hover, a.list-group-item:focus {text-decoration: none;background-color: rgb(245, 245, 245);}
		.list-group { margin-bottom:0px; }
    </style>
  <style>
  ul, ol, li {
    list-style: none;
}
	a{
		text-decoration: none;
		color: black;
	}
  </style>  
<style>

#managerContainer{
	margin-top:10px;
}
#fisrttr{
	height: 56px;
	background-color: #f5f5f5;
}
img.folder_clo_num{
	float:left;
	margin-left: -4px;
}
img.folder_clo_num + input{
	margin-top : -15px;
}

.panel-primary>.panel-heading{
	color: #fff;
    background-color: #B58DB3  !important;
    border-color: #B58DB3  !important;
}

#managerRightDiv{
	margin:0; 
	padding-right:0;
}

.btn {
	margin-left : 5px !important;
}
</style>
    
    
<!--     <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script> -->
    <!-- <script src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script> -->
<!--  <script src="/resources/js/closet/closetManager_bootstrap.js"></script> 
    <script src="/resources/js/closet/closet.js"></script>   -->
  
  <script type="text/javascript">


//옷장 전체선택(checkbox) -ok
$(function(){
	$('#allcheckCloset').on('click',function(){
		alert("전체체크박스 클릭");
		if($('#allcheckCloset').prop('checked')){
			$('.checkCloset').prop('checked',true);
		}else{
			$('.checkCloset').prop('checked',false);
		}
	});
});






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
		alert("#folderAddBtn 진입");
		var clo_nums = new Array(); //배열로 안돌리면 첫번째 값만 가져온다.
		$('.folder_clo_num').each(function(){
			clo_nums.push($(this).val());
			console.log("push되는 clo_nums: "+$(this).val());
		});
		console.log("clo_nums들: "+clo_nums);
		
		var insert_clo_num = arrayMax(clo_nums) +1; // +1해야 새로 추가할 clo_num
		console.log("insert_clo_num = "+insert_clo_num);
		
		var html = "";
		/* html += '<tr><td><input type="checkbox" class="checkCloset folder_clo_num" value="';
		html += insert_clo_num;
		html += '" /></td><td class="secondtd">&nbsp&nbsp<input class="closetTitle" type="text"'; 
		html +=	'value="나만의옷장"> </td></tr>'; */
//		$('#closetTable tbody').append(html);
/* 	<li class="list-group-item">
             <tr>
				<td><input type="checkbox" class="checkCloset folder_clo_num" value="${tab.clo_num }" /></td>
				<td class="secondtd">&nbsp&nbsp<input class="closetTitle" type="text"  value="${tab.clo_name }"></td>
			</tr>	
        </li> */		
		html += '<li class="list-group-item"><tr><td><input type="checkbox" class="checkCloset folder_clo_num" value="';
		html += insert_clo_num;
		html += '"  /></td><td class="secondtd">&nbsp&nbsp<input class="closetTitle" type="text"';
		html += 'value="나만의 옷장"> </td></tr>';
		console.log('추가할 html : '+ html);
		$('#listUL').append(html);
	});
});

function arrayMax(array){ //배열의 가장 큰 수.(폴더목록UI추가시 clo_num구하기위함) 
	var max = Math.max.apply(null,array)
	return max;
}

$(function(){
	//옷장폴더 삭제(db안거치고 ui만.)
	$('#folderDeleteBtn').on('click', function(){
		alert("#folderDeleteBtn 진입");
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
<!-- <style type="text/css" id="igtranslator-color"></style> -->
</head>



<body>
<div id ="closetManagerSection">
	<section id="managerContainer" class="container col-xs-12 col-sm-6 col-md-8">
    <div class="row">
        <div class="col-md-6" id="closetTable">
            <div class="panel panel-primary">
                <div class="panel-heading">
                    <span class="glyphicon glyphicon-list"></span>옷장 매니저
<!--                     <div class="pull-right action-buttons">
                        <div class="btn-group pull-right">
                            <button type="button" class="btn btn-default btn-xs dropdown-toggle" data-toggle="dropdown">
                                <span class="glyphicon glyphicon-cog" style="margin-right: 0px;"></span>
                            </button>
                            <ul class="dropdown-menu slidedown">
                                <li><a href=""><span class="glyphicon glyphicon-pencil"></span>Edit</a></li>
                                <li><a href=""><span class="glyphicon glyphicon-trash"></span>Delete</a></li>
                                <li><a href=""><span class="glyphicon glyphicon-flag"></span>Flag</a></li>
                            </ul>
                        </div>
                    </div> -->
                </div>
                <div class="panel-body">
                    <ul id="listUL" class="list-group">
<!--                     	 <li id="fisrttr" class="list-group-item">
                    	                
           	  	         	<div class="checkbox col-xs-6 col-sm-6 col-md-4">
           	  	         		<input type="checkbox" class="checkCloset allcheckCloset" value="allcheckCloset" /><label for="checkbox">전체선택<b>(삭제시)</b></label>
           	  	         	</div> 
                    	    <div id="media_1_div">	
                        	 <span>전체선택<b>(삭제시)</b></span>
	                           
	                 		</div>
                        </li> -->
                    
				<c:forEach var="tab"  items="${sessionScope.closetTab}" >
					<c:choose >
								<c:when test="${tab.clo_num == 1}">
					              <li class="list-group-item">
				                         <tr>
											<td><img class="folder_clo_num" src="/resources/images/closetImg/locked-1.png" alt= "" value="${tab.clo_num }" ></td>
											<td class="secondtd">&nbsp&nbsp<input class="closetTitle" type="text" value="${tab.clo_name }" readonly="readonly"> </td>
										</tr>		
			                        </li>	
                      	    </c:when>
				   			<c:otherwise>
			   					 <li class="list-group-item">
			                        <tr>
										<td><input type="checkbox" class="checkCloset folder_clo_num" value="${tab.clo_num }" /></td>
										<td class="secondtd">&nbsp&nbsp<input class="closetTitle" type="text"  value="${tab.clo_name }"></td>
									</tr>	
			                      </li>
                        	</c:otherwise>
					</c:choose>
				</c:forEach>   
							
	<%-- 					              <li class="list-group-item">
				                         <tr>
											<td><img class="folder_clo_num" src="../resources/images/closetImg/locked-1.png" alt= "" value="${tab.clo_num }" ></td>
											<td class="secondtd">&nbsp&nbsp<input class="closetTitle" type="text" value="기본 옷장" readonly="readonly"> </td>
										</tr>		
			                        </li>	
			                        
							    <li class="list-group-item">
			                        <tr>
										<td><input type="checkbox" class="checkCloset folder_clo_num" value="${tab.clo_num }" /></td>
										<td class="secondtd">&nbsp&nbsp<input class="closetTitle" type="text" value="옷장1"></td>
									</tr>	
			                        </li> --%>
							  
                        <!--
                        <li class="list-group-item">
                            <div class="checkbox">
                                <input id="checkbox5" type="checkbox">
                                <label for="checkbox5">
                                    List group item heading 4
                                </label>
                            </div>
                           <div class="pull-right action-buttons">
                                <a href=""><span class="glyphicon glyphicon-pencil"></span></a>
                                <a href="" class="trash"><span class="glyphicon glyphicon-trash"></span></a>
                                <a href="" class="flag"><span class="glyphicon glyphicon-flag"></span></a>
                            </div>
                        </li>-->
                    </ul> 
                </div>
                <div class="panel-footer" >
                    <div class="row " class=" col-xs-12 col-sm-12 col-md-12 " style="padding: 10px 15px;">
     <!--                    <div class="col-md-6">
                            <h6>
                                Total Count <span class="label label-info">25</span></h6> 
                        </div> -->
                        <span class="checkbox col-xs-12 col-sm-12 col-md-4">
                        	<input type="checkbox" id="allcheckCloset" class="checkCloset allcheckCloset" value="allcheckCloset" />&nbsp&nbsp전체선택<b>(삭제시)</b>
                        </span>	
			            <span id="managerRightDiv" class="col-xs-12 col-sm-12 col-md-8  col-md-offset-4" >
							<button type="button" value="수정완료" class="folderBtn btn btn-warning pull-right" id="folderSaveBtn">저장</button>
							<button type="button" value="선택폴더삭제" class="folderBtn btn btn-danger pull-right" id="folderDeleteBtn">선택삭제</button>
							<button type="button" value="폴더추가" class="folderBtn btn btn-primary pull-right" id="folderAddBtn">폴더추가</button>
						</span>
                        <div id="media_2_div">	
                        	<!--  <span>전체선택<b>(삭제시)</b></span>
	                         -->   
	                 </div>

                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
</div>
	<script type="text/javascript">
	
	</script>


<div class="igtranslator-main-div"></div></body></html>