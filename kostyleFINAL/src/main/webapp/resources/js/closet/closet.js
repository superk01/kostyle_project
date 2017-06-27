//나중에 바꿔야함! 폴더삭제시 UI만지워지고 저장버튼을 눌러야 실제반영되도록 통일! ->Ok

//select_clo_num의 옳은표현: var clo_num = $('#closetNavi .selectTab').attr("id");

//옷장폴더선택
$(function(){
	$('.tabClick').on('click',function(){
		//var c_num = $('input[name=c_num]').val();
		var clo_num ="";
		var clo_name= null;
		
		if($(this).attr("id") == "0"){
			console.log("스크립트full인 if진입");
			clo_num = "0";
		}else{
			console.log("스크립트full이 아닌 else진입");
			clo_num = $(this).attr("id");
			clo_name = $(this).find('input').val();
		}//end else
		//"c_num="+c_num+
		var param = "clo_num="+clo_num+
		"&clo_name="+clo_name;
		//alert("param값은?: "+param);
		
		$.ajax({
			headers: { 
		        'Accept': 'application/json',
		        'Content-Type': 'application/json; charset=UTF-8'
		    },
			type: "post",
			url:"/closet/closetbasic",
			data : JSON.stringify({
	            clo_num : clo_num,
	            clo_name : clo_name,
	         }),
			success: function (data){
				//alert("ajax결과: "+data);
				//console.log("ajax결과: "+data);
				$('#closetBody').html(data);
				//$('#templateBody').html(data);
			}  ,
			error : function(xhr, status, error) {
				alert("ajax실패");
				//alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);

			}
		}); 
	});	//end event on
});
//옷장 전체선택(checkbox)
$(function(){
	$('#allcheckCloset').on('click',function(){
		if($('#allcheckCloset').prop('checked')){
			$('.checkCloset').prop('checked',true);
		}else{
			$('.checkCloset').prop('checked',false);
		}
	});
});


//폴더관리 - 자식윈도우
$(function(){
	/*
	 * window.open() 함수로 띄운 팝업 창에서 부모창의 변수나 함수를 사용하기 위해선 opener를 사용하면 된다.
opener는 부모를 지칭하는 객체(?)이고 opener.을 이용해서 부모의 함수에 접근가능.
	*/
	 
	$('#manage').on('click',function(){
		//alert("cloTabParam의값: "+$('#cloTabParam').val() );
		var attriName = "closetTab";
		var attriValue = $('#cloTabParam').val(); 
		//alert("cloTabParam: "+attriValue);
		//alert("attriVlaue의타입: "+typeof(attriValue));
		var attriCD = "create";
		var param = "attriName="+attriName+"&attriValue="+attriValue
		+"&attriCD="+attriCD; //속성 create/delete
		
		//alert("세션CDAttri param값: "+param);
		//alert("param타입: "+typeof(param));
		$.ajax({
			headers: { 
		        'Accept': 'application/json',
		        'Content-Type': 'application/json; charset=UTF-8'
		    },
		type: "post",
		url:"/closetfolder/cdSessionAttribute",
		data : JSON.stringify({
			attriName : attriName,
			attriValue : attriValue,
			attriCD : attriCD
         }),
		async: false,
		success: function (data){
			alert("ajax결과: session: "+data);
		}  ,
		error : function(xhr, status, error) {
		//alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
		}
		});
		//alert("attriName: "+attriName+"attriValue: "+attriValue+"attriCD: "+attriCD);

		window.name="parentCloset"
		window.open("/closet/closetManager","myClosetManager","height=350, width=550 top=200, left=200, location=0, resizable"); });
});



//상품,옷장 전체선택
/* http://ddo-o.tistory.com/94 */
$(function(){
	$("#checkAllBtn").on('click',function(){
		$('#checkAll').trigger('click');
	});
	$('#checkAll').on('click',function(){
		if($('#checkAll').prop('checked')){
			$('.check').prop('checked',true);
		}else{
			$('.check').prop('checked',false);
		}
	});
});	  



//상품보기
$(function(){
	$('.onePrd a').on('click',function(e){//이미지와 글씨에.
		e.preventDefault(); //a링크 이벤트 막읍시다
		var url = $(this).attr('href');
		//alert("아이프레임url: "+url+'입니다.');
		location.href = "#closetBodyTop";
		
		if($('#prdViewIframe').length > 0 ){ //셀렉터의 존재여부 확인..src만 바꾸려고.
			$('#prdViewIframe').attr("src", url);
		}else{
			$('#closetBodyTop').remove();
			$('#closetbackground').prepend('<div id="iframeRemove">쇼핑몰 닫기</div>');
			$('#closetbackground').prepend('<iframe id="prdViewIframe" width="100%" height="900" src='+'\"'+url+'\">');
			$('#closetbackground').prepend('<div id="closetBodyTop"></div>');
			//alert($('#prdViewIframe').attr('href'));
		}
	$('#iframeRemove').on('click',function(){
		$('#prdViewIframe').remove();
		$('#iframeRemove').remove();
		});
	});
});

//상품삭제
$(function(){
	$('#deleteBtn').on('click', function(){
		var clo_detail_nums = delete_move_Btn_click();
		var clo_num;
		clo_num = $('#navi li[class=selectTab]').attr("id");
		//alert("$('.selectTab').attr(id)값: "+$('.selectTab').attr("id"));
		//alert("clo_num값:"+clo_num);
		if(clo_num == undefined){
			clo_num = "0";
		}else{
			clo_num = $('.selectTab').attr('id');
		}
		var param = "clo_detail_nums="+clo_detail_nums+
		"&clo_num="+clo_num;
		
		//ui상에서 안보이게.
		$("#prdSection input:checkbox:checked").each(function (index) {
			$(this).parents('#prdUL li').remove();
		});  
		//alert("param값은?: "+param);
		$.ajax({
			headers: { 
		        'Accept': 'application/json',
		        'Content-Type': 'application/json; charset=UTF-8'
		    },
			type:"post",
			url:"/closet/deleteClosetPrd",
			data : JSON.stringify({
				 clo_detail_nums : clo_detail_nums,
				clo_num : clo_num
	         }),
			success: function(data){
				//alert("딜리트 에이작스 결과: "+data);
				//alert(request.getAttribute("msg"));
				
				alert("삭제 완료");
			},
			error : function(xhr, status, error) {
			//	alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);

			}
		});
	});
	
});
function delete_move_Btn_click() {  
    var str = "";  
    $("#prdSection input:checkbox:checked").each(function (index) {  
        str += $(this).val()+",";  
    });  
    return str;  
}  

//ui상에서 체크박스 물품들 사라지게하기.
var deleteGui = function(){
	var clo_nums = new Array();
}
//상품 다른옷장폴더로 이동
//선행)히든영역 토글
$(function(){
	$('#moveBtn1').on('click',function(){
		$('#hidden_move_prd').toggle(0,function(){
		});
	});
	
});
//다른폴더로 이동함수
$(function(){
	$('#moveBtn2').on('click',function(){
		var clo_detail_nums = delete_move_Btn_click();
		var clo_num = $('#closetNavi .selectTab').attr("id");
		//alert("최초 select_clo_num: "+ clo_num);
		var move_clo_num = $("#hidden_move_prd :input:radio[name=selet_move]:checked").val();
		
		if(move_clo_num == null || clo_detail_nums == ""){
			alert("이동할 폴더 또는 상품이 선택되지 않았습니다.");
		}else{
			if(clo_num == undefined){
				clo_num = "0";
			}else{
				clo_num = $('.selectTab').attr('id');
			}
			var param = "clo_detail_nums="+clo_detail_nums+
						"&move_clo_num="+move_clo_num+
						"&clo_num="+clo_num;
			//alert("param값은?: "+param);
			//alert("clo_num: "+clo_num);
			
			
			$.ajax({
				headers: { 
			        'Accept': 'application/json',
			        'Content-Type': 'application/json; charset=UTF-8'
			    },
				type:"post",
				url:"/closet/moveClosetPrd",
				data : JSON.stringify({
					clo_detail_nums : clo_detail_nums,
					move_clo_num : move_clo_num,
					clo_num : clo_num
		         }),
				async: false,
				success: function(data){
					//alert("딜리트 에이작스 결과: "+data);
					//alert(request.getAttribute("msg"));
					alert("상품폴더이동 완료");
					 
				},
				error : function(xhr, status, error) {
				//	alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);

				}
			});
			//ui상에서 안보이게. 전체폴더라면 이름만바뀌고 아니면 안보이도록.
			
			if(clo_num == 0){
				window.location.reload(true);//리로딩ㅋㅋㅋ;;
			}else{
				$("#prdSection input:checkbox:checked").each(function (index) {
					//alert("spanhtml"+$(this).next().text());
					//alert("move_clo_num: "+move_clo_num);
					if($(this).next().text() != move_clo_num ){
						$(this).parents('#prdUL li').remove();
					}
				}); 
			}
			
		}//end else
		
	});
});







