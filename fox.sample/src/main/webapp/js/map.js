//<![CDATA[
$(function() {
	// FnQ
    $(".answer_head").attr('class','answer_head sub_on');
    $(".answer_box:first").css("display","block");
    $(".answer_box").css("display","none");
    $(".answer_head").click(function() { 
        if ($(this).next(".answer_box").css("display") == "none") {
            $(this).attr('class','answer_head');
        } else {
            $(this).attr('class','answer_head sub_on');
        }
        $(this).next(".answer_box").slideToggle('fast');
    });

    //전체선택
    $('.input_all').bind('click' , function(){
    var chk = $(this).is(':checked');
    if(chk) $('.input_chk').attr('checked' , true);
    else $('.input_chk').attr('checked' , false);
    }); 

//지도
/*
    $(".gnb_btn a img").mouseenter(function() {
        $(this).attr("src", "img/gnb_"+$(this).attr("name")+"_on.png");
    }).mouseleave(function(){
        $(this).attr("src", "img/gnb_"+$(this).attr("name")+"_off.png");
    });
*/

// 지도
	var clicked = false;
     $(".map map area , .area_list li a").mouseover(function () {
         if (!clicked) {
             var imgEl = $(".mapImg");
             imgEl.attr("src", "/ocu/images/img/map_bg.jpg");//기본 지도이미지
             var id = $(this).attr("data-id");//가지고있는 데이터 값
             imgEl.attr("src", "/ocu/images/img/map_" + id + ".jpg");
         }
     });
   $(".map map area .area_list li a").mouseout(function () {
         var imgEl = $(".mapImg"); 
     });

	$(".map map area").click(function () {
	    clicked = true;
	   	$(".area_list li a").removeClass("area_btn");
	    var imgEl = $(".mapImg");
	    var id = $(this).attr("data-id");
 
		if(id==4){
			$(".area_list li:eq(0) a").addClass("area_btn");
		}
		if(id==2){
			$(".area_list li:eq(1) a").addClass("area_btn");
		}
		if(id==9){
			$(".area_list li:eq(2) a").addClass("area_btn");
		}
		if(id==8){
			$(".area_list li:eq(3) a").addClass("area_btn");
		}
		if(id==15){
			$(".area_list li:eq(4) a").addClass("area_btn");
		}
		if(id==10){
			$(".area_list li:eq(5) a").addClass("area_btn");
		}
		if(id==7){
			$(".area_list li:eq(6) a").addClass("area_btn");
		}
		if(id==11){
			$(".area_list li:eq(7) a").addClass("area_btn");
		}
		if(id==1){
			$(".area_list li:eq(8) a").addClass("area_btn");
		}
		if(id==17){
			$(".area_list li:eq(9) a").addClass("area_btn");
		}
		if(id==12){
			$(".area_list li:eq(10) a").addClass("area_btn");
		}
		if(id==3){
			$(".area_list li:eq(11) a").addClass("area_btn");
		}
		if(id==14){
			$(".area_list li:eq(12) a").addClass("area_btn");
		}
		if(id==13){
			$(".area_list li:eq(13) a").addClass("area_btn");
		}
		if(id==16){
			$(".area_list li:eq(14) a").addClass("area_btn");
		}
		if(id==6){
			$(".area_list li:eq(15) a").addClass("area_btn");
		}
		if(id==5){
			$(".area_list li:eq(16) a").addClass("area_btn");
		}

	  
	    imgEl.attr("src", "/ocu/images/img/map_" + id + ".jpg");
	    return false;

    	});

// 새로만든 탭
	  $(".tab_box > ul li , .tab_box2 > ul li , .tab_box3 > ul li").click(function(){
	   var now_tab = $(this).index();
	   $(this).parent().find("li").removeClass("tab_on , tab_on2 , tab_on3");
	   $(this).parent().parent().parent().find(".tab_list").addClass("hidden_in");
	   $(this).parent().find("li").eq(now_tab).addClass("tab_on , tab_on2 , tab_on3");
	   $(this).parent().parent().parent().find(".tab_list").eq(now_tab).removeClass("hidden_in");
	  });

	  $(".all_area").click(function(){
	   $(this).parent().find("ul li").removeClass("tab_on");
	  });


// 지도 리스트 on 버튼
	$(".area_list li a ").click(function () {
		$(".area_list li a").removeClass("area_btn");
		$(this).addClass("area_btn");
	    clicked = true;
	    var imgEl = $(".mapImg");
	    var id = $(this).attr("data-id");
	    imgEl.attr("src", "/ocu/images/cyberline/pms/img/map_" + id + ".jpg");
       return false;
    	});

	$(".area_list2 li a ").click(function () {
		$(".area_list2 li a").removeClass("area_btn2");
		$(this).addClass("area_btn2");
   });

// placeholder속성***

// $('input#id_input').val(  '영문, 숫자 조합 5~15자' );
// $('input#id_input').on('focusin focusout', function(e) {
//     var value = this.value;
//     if( e.type == 'focusin' && value ==  '영문, 숫자 조합 5~15자' ) {
//         this.value = '';
//     } else if( e.type == 'focusout' && value == '' ) {
//         this.value =  '영문, 숫자 조합 5~15자';
//     }
//     return false;
// });



});

//]]>




