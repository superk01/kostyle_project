
$(function(){
	$('#closet_btn').on('click',function(){
		var ajaxNum = -1; //연쇄ajax를 위한 기반변수
		var prdUrl = $('#CategorysearchIframe').attr('src');
		//alert("아이프레임에서 따온 상품url: "+prdUrl);
		
		var currentUrl = document.location.href;
		//alert("currentUrl: "+currentUrl);

		var param = "prdUrl="+prdUrl+"&currentUrl="+currentUrl;
		if(prdUrl == undefined){
			alert("찜할 상품이 존재하지 않습니다.");
		}else{
			prdUrl = "prdUrl="+prdUrl;
			
			//ajax를 비동기식(async : false)으로 사용해서 뒤의 ajax연쇄실행
			$.ajax({
				 headers: { 
				        'Accept': 'application/json',
				        'Content-Type': 'application/json; charset=UTF-8'
				    },
				type: "post",
				url: "/closet/duplicationCheckClosetPrd",
				data : JSON.stringify({
					 prdUrl : prdUrl
			         }),
				async: false,
				success: function(data){
					//alert("ajax중복회신결과: "+data);
					if(data >0){
						alert("이미 찜한 상품입니다♥");
					}else if(data==0){
						ajaxNum = data;
						//alert("ajaxNum?: "+ajaxNum);
					}
				},
				error: function(data){
				//	alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);

				}
			});
			
			//alert("if진입직전ajaxNum?: "+ajaxNum);
			if(ajaxNum == 0){
				//alert("ajaxNum == 0.중복없음ajax if진입");
				//alert("insertAjax함수 진입.");
				$.ajax({
					headers: { 
				        'Accept': 'application/json',
				        'Content-Type': 'application/json; charset=UTF-8'
				    },
					type:"post",
					url:"/closet/insertPrd",
					data : JSON.stringify({
						prdUrl : prdUrl,
						currentUrl : currentUrl
			         }),
					success: function(result){
						//alert("insertAjax결과: "+result);
						if(result == 1 || result.equals("1")){
							alert("해당상품이 옷장에 추가되었습니다");
						}else{
							alert("찜추가실패");
						}
					},
					error: function(data){
				//		alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
					}
				});
				//alert("insertAjax함수 끝.");
				
			}
		}
		
	});
});
/*var insertAjax = function(prdUrl){
	alert("insertAjax함수 진입.");
	$.ajax({
		type:"post",
		url:"../InsertClosetPrdAction.closet",
		data: param,
		success: function(data){
			if(data.equals("1")){
				alert("해당상품이 옷장에 추가되었습니다");
			}else{
				alert("찜추가실패");
			}
		},
		error: function(data){
			alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
		}
	});
	alert("insertAjax함수 끝.");
}
*/
