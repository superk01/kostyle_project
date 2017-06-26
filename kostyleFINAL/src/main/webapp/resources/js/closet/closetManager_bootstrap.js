//-----------------------
$(function(){
	resize_btn();
})
function resize_btn(){
	var windowWidth = $(window).width();
	if(windowWidth<768){
		//아이프레임만들때 썼던 이벤트내용에 url만 모바일용으로.
	}else{
		//웹용으로 띄우도록.
	}
}

	/*     모바일폰
     < 768
     .col-xs-

     태블릿
     >=768
     .col-sm-

     데스크탑
     >=992
     .col-md-

     데스크탑
     >=1200
     .col-lg-
  */
	if(windowWidth >=1300){
		console.log(">=1300진입");
		$('#media_1_div').html('<div class="col-lg-8  pull-right action-buttons"><span class="col-md-4"><button type="button" class="btn icon-btn btn-success folderDeleteBtn" ><span class="glyphicon btn-glyphicon glyphicon-plus img-circle text-success"></span> 옷장추가</button></span><span class="col-md-4"><button type="button"  class="btn icon-btn btn-danger folderAddBtn" ><span class="glyphicon btn-glyphicon glyphicon-trash img-circle text-danger"></span> 옷장삭제</button></span><span class="col-md-4"><button  type="button" class="btn btn icon-btn btn-primary folderSaveBtn" ><span class="glyphicon glyphicon-saved"></span> 옷장저장</button></span></div>');
		
		$('#media_2_div').html('<div class="col-lg-8 pull-right action-buttons"><span class="col-md-4"><button type="button" class="btn icon-btn btn-success folderDeleteBtn" ><span class="glyphicon btn-glyphicon glyphicon-plus img-circle text-success"></span> 옷장추가</button></span><span class="col-md-4"><button type="button"  class="btn icon-btn btn-danger folderAddBtn" ><span class="glyphicon btn-glyphicon glyphicon-trash img-circle text-danger"></span> 옷장삭제</button></span><span class="col-md-4"><button  type="button" class="btn btn icon-btn btn-primary folderSaveBtn" ><span class="glyphicon glyphicon-saved"></span> 옷장저장</button></span></div>');
	}/*else if(windowWidth>=668 || windowWidth<=968){
		$('#media_1_div').html('<div class="col-xs-6 col-sm-6 col-md-6 pull-right action-buttons"><span class="col-xs-4 col-sm-4 col-md-4"><button type="button" class="btn icon-btn btn-success folderDeleteBtn" ><span class="glyphicon btn-glyphicon glyphicon-plus img-circle text-success"></span> 추가</button></span><span class="col-xs-4 col-sm-4 col-md-4"><button type="button"  class="btn icon-btn btn-danger folderAddBtn" ><span class="glyphicon btn-glyphicon glyphicon-trash img-circle text-danger"></span> 삭제</button></span><span class="col-xs-4 col-sm-4 col-md-4"><button  type="button" class="btn btn icon-btn btn-primary folderSaveBtn" ><span class="glyphicon glyphicon-saved"></span> 저장</button></span></div>');
		
		$('#media_2_div').html('<div class="col-xs-6 col-sm-6 col-md-6 pull-right action-buttons"><span class="col-xs-4 col-sm-4 col-md-4"><button type="button" class="btn icon-btn btn-success folderDeleteBtn" ><span class="glyphicon btn-glyphicon glyphicon-plus img-circle text-success"></span> 추가</button></span><span class="col-xs-4 col-sm-4 col-md-4"><button type="button"  class="btn icon-btn btn-danger folderAddBtn" ><span class="glyphicon btn-glyphicon glyphicon-trash img-circle text-danger"></span> 삭제</button></span><span class="col-xs-4 col-sm-4 col-md-4"><button  type="button" class="btn btn icon-btn btn-primary folderSaveBtn" ><span class="glyphicon glyphicon-saved"></span> 저장</button></span></div>');                    
		
		
	}*/else{
		console.log("<768진입");
//		$('#media_1_div').html('<div class="pull-right action-buttons"><button type="button" class="btn icon-btn btn-success folderDeleteBtn" ><span class="glyphicon btn-glyphicon glyphicon-plus img-circle text-success"></span> </button><button type="button"  class="btn icon-btn btn-danger folderAddBtn" ><span class="glyphicon btn-glyphicon glyphicon-trash img-circle text-danger"></span> </button><button  type="button" class="btn btn icon-btn btn-primary folderSaveBtn" ><span class="glyphicon glyphicon-saved"></span> </button></div>');
		$('#media_1_div').html('<div class="col-xs-6 col-sm-6 col-md-6 pull-right action-buttons"><span class="col-xs-4 col-sm-4 col-md-4"><button type="button" class="btn icon-btn btn-success folderDeleteBtn" ><span class="glyphicon btn-glyphicon glyphicon-plus img-circle text-success"></span> </button></span><span class="col-xs-4 col-sm-4 col-md-4"><button type="button"  class="btn icon-btn btn-danger folderAddBtn" ><span class="glyphicon btn-glyphicon glyphicon-trash img-circle text-danger"></span> </button></span><span class="col-xs-4 col-sm-4 col-md-4"><button  type="button" class="btn btn icon-btn btn-primary folderSaveBtn" ><span class="glyphicon glyphicon-saved"></span> </button></span></div>');
         
		$('#media_2_div').html('<div class="col-xs-6 col-sm-6 col-md-6 pull-right action-buttons"><span class="col-xs-4 col-sm-4 col-md-4"><button type="button" class="btn icon-btn btn-success folderDeleteBtn" ><span class="glyphicon btn-glyphicon glyphicon-plus img-circle text-success"></span> </button></span><span class="col-xs-4 col-sm-4 col-md-4"><button type="button"  class="btn icon-btn btn-danger folderAddBtn" ><span class="glyphicon btn-glyphicon glyphicon-trash img-circle text-danger"></span> </button></span><span class="col-xs-4 col-sm-4 col-md-4"><button  type="button" class="btn btn icon-btn btn-primary folderSaveBtn" ><span class="glyphicon glyphicon-saved"></span> </button></span></div>');                    
	
	}
	
/*	else{
		console.log("<=992진입");
		$('#media_1_div').html('<div class="col-xs-8 col-sm-8 col-md-8 pull-right action-buttons"><span class="col-xs-4 col-sm-4 col-md-4"><button type="button" class="btn icon-btn btn-success folderDeleteBtn" ><span class="glyphicon btn-glyphicon glyphicon-plus img-circle text-success"></span> 옷장추가</button></span><span class="col-xs-4 col-sm-4 col-md-4"><button type="button"  class="btn icon-btn btn-danger folderAddBtn" ><span class="glyphicon btn-glyphicon glyphicon-trash img-circle text-danger"></span> 옷장삭제</button></span><span class="col-xs-4 col-sm-4 col-md-4"><button  type="button" class="btn btn icon-btn btn-primary folderSaveBtn" ><span class="glyphicon glyphicon-saved"></span> 옷장저장</button></span></div>');
       
		$('#media_2_div').html('<div class="col-md-8 pull-right action-buttons"><span class="col-md-4"><button type="button" class="btn icon-btn btn-success folderDeleteBtn" ><span class="glyphicon btn-glyphicon glyphicon-plus img-circle text-success"></span> 옷장추가</button></span><span class="col-md-4"><button type="button"  class="btn icon-btn btn-danger folderAddBtn" ><span class="glyphicon btn-glyphicon glyphicon-trash img-circle text-danger"></span> 옷장삭제</button></span><span class="col-md-4"><button  type="button" class="btn btn icon-btn btn-primary folderSaveBtn" ><span class="glyphicon glyphicon-saved"></span> 옷장저장</button></span></div>');
	}*/
//}


//창크기 리사이즈 감지. 리사이즈시 resize_btn()함수 실행
$(function(){
	resize_btn();
});
/*$(document).ready(resize_btn());*/
$(window).resize(function(){
	console.log("window.resize이벤트");
	resize_btn();
});
//-----------------------

//--기존 function들----------

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



//--기존 fucntion들----------






//----------bootstrap
window.alert = function(){};
var defaultCSS = document.getElementById('bootstrap-css');
function changeCSS(css){
    if(css) $('head > link').filter(':first').replaceWith('<link rel="stylesheet" href="'+ css +'" type="text/css" />'); 
    else $('head > link').filter(':first').replaceWith(defaultCSS); 
}
/*         $( document ).ready(function() {
  var iframe_height = parseInt($('html').height()); 
  window.parent.postMessage( iframe_height, 'https://bootsnipp.com');
}); */