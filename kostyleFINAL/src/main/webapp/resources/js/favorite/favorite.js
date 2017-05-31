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