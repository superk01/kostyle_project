
//1
//$(function () {
//    $('.navbar-toggle').click(function () {
//        $('.navbar-nav').toggleClass('slide-in');
//        $('.side-body').toggleClass('body-slide-in');
//        $('#search').removeClass('in').addClass('collapse').slideUp(200);
//
//        /// uncomment code for absolute positioning tweek see top comment in css
//        //$('.absolute-wrapper').toggleClass('slide-in');
//        
//    });
//   
//   // Remove menu for searching
//   $('#search-trigger').click(function () {
//        $('.navbar-nav').removeClass('slide-in');
//        $('.side-body').removeClass('body-slide-in');
//
//        /// uncomment code for absolute positioning tweek see top comment in css
//        //$('.absolute-wrapper').removeClass('slide-in');
//
//    });
//});



//2
$(document).ready(function () {
	  var trigger = $('.hamburger'),
	      overlay = $('.overlay'),
	     isClosed = false;

	    trigger.click(function () {
	      hamburger_cross();      
	    });

	    function hamburger_cross() {

	      if (isClosed == true) {          
	        overlay.hide();
	        trigger.removeClass('is-open');
	        trigger.addClass('is-closed');
	        isClosed = false;
	      } else {   
	        overlay.show();
	        trigger.removeClass('is-closed');
	        trigger.addClass('is-open');
	        isClosed = true;
	      }
	  }
	  
	  $('[data-toggle="offcanvas"]').click(function () {
	        $('#wrapper').toggleClass('toggled');
	  });  
	});