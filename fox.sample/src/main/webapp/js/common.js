/********************************************************
파일명 : common.js
설 명 : 대교협 공통   JavaScript
수정일 수정자 Version Function 명
------- -------- ---------- --------------
2014.01.01 홍길동 1.0 최초   생성
*********************************************************/


/***********************************************************************
함수명 : gfn_nvl
설 명 : 시스템 구분으로 프로그램 목록을 조회
인 자 : str : 스트링 문자
사용법 : gfn_nvl(str)
작성일 : 2014-02-01
작성자 : 각팀명(예. 공통서비스 개발팀) 홍길동
수정일 수정자 수정내용
------ ------ -------------------
2014.02.01 길동이 윤년 처리 추가
***********************************************************************/
function gfn_nvl(str){
	return (str == null)?"&nbsp;":str;
}

/***********************************************************************
함수명 : gfn_null
설 명 : 시스템 구분으로 프로그램 목록을 조회
인 자 : str : 스트링 문자
사용법 : gfn_null(str)
작성일 : 2014-02-01
작성자 : 각팀명(예. 공통서비스 개발팀) 홍길동
수정일 수정자 수정내용
------ ------ -------------------
2014.02.01 길동이 윤년 처리 추가
***********************************************************************/
function gfn_null(str){
	return (str == null)?"":str;
}

/***********************************************************************
함수명 : gfn_isNull
설 명 : str의 빈값여부 반환
인 자 : str : 스트링 문자
사용법 : gfn_isNull(str)
작성일 : 2020-07-22
작성자 : 각팀명(예. 공통서비스 개발팀) 홍길동
수정일 수정자 수정내용
------ ------ -------------------
2020.07.22 김영우 윤년 처리 추가
***********************************************************************/
function gfn_isNull(str){
	return str == null || str == '' || str == undefined ? true : false;  
}

/***********************************************************************
함수명 : gfn_zeroToHipen
설 명 : 시스템 구분으로 프로그램 목록을 조회
인 자 : str : 스트링 문자
사용법 : gfn_zeroToHipen(str)
작성일 : 2014-02-01
작성자 : 각팀명(예. 공통서비스 개발팀) 홍길동
수정일 수정자 수정내용
------ ------ -------------------
2014.02.01 길동이 윤년 처리 추가
 ***********************************************************************/
function gfn_zeroToHipen(str){
	return (str == null || str == '0' || str == '0 : 1')?"-":str;
}
/***********************************************************************
함수명 : gfn_setTotalPage
설 명 : 페이징 처리시 총 건수와 페이지 번호를 화면에 보여준다.
인 자 : page : 현재 선택 된 페이지, totcnt : 전체 데이터 수, totalPages 총 페이지 수
사용법 : fn_onclick_page(page, totcnt, totalPages)
작성일 : 2015-01-13
작성자 : 응용팀 김충현
수정일 수정자 수정내용
------ ------ -------------------

***********************************************************************/
function gfn_setTotalPage(page, totcnt, totalPages)
{
	$('#page-content').html('총<span>'+totcnt+'</span>건('+page+'/'+totalPages+'page)');
}


/***********************************************************************
함수명 : gfn_leadingZeros
설 명 : 숫자 앞에 '0' 이 없어져서 나올경우 숫자 데이터와 자리수를 입력하면 '0' 을 채워 리턴한다.
인 자 : data : 원래 '0' 이 붙어야 하는 숫자 데이터, num : 필요한 자리수
사용법 : gfn_leadingZeros(data, num)
작성일 : 2015-08-12
작성자 : 응용팀 박현수
수정일 수정자 수정내용
------ ------ -------------------

***********************************************************************/
function gfn_leadingZeros(data, num) {
	 var zero = '';
	 data = gfn_null(data).toString();
	
	 if (data.length < num) {
	  for (var i = 0; i < num - data.length; i++)
	   zero += '0';
	 }
	 return zero + data;
}


/***********************************************************************
함수명 : gfn_Btn_Create
설 명 : 권한 별 버튼 생성
인 자 : btnID : 버튼이 생성 될 DIV 태그의 ID
        , eventID : 버튼 생성시 클릭 이벤트
        , btnCass : 버튼 생성시 클래스(신규등록 및 답글:Btn_write, 수정:Btn_modify, 삭제:Btn_delete, 저장:Btn_save)
        , btnName : 버튼 이름
사용법 : gfn_Btn_Create(btnID, eventID, btnCass, btnName)
작성일 : 2015-01-13
작성자 : 응용팀 김충현
수정일 수정자 수정내용
------ ------ -------------------
2015.01.13 김충현 최조생성
 ***********************************************************************/
function gfn_Btn_Create(btnID, eventID, btnCass, btnName)
{
	btnID.empty();
	if(btnID != ""){
		btnID.append('<a href="#" onclick="'+eventID+'" class="'+btnCass+'">'+btnName+'</a>');
	}
}

/***********************************************************************
함수명 : gfn_downFile
설 명 : 파일 다운로드
인 자 : formName : 화면 ID
        , atch_file_id : 파일 시퀀스
        , target : from target
사용법 : gfn_downFile(formName, atch_file_id, file_sn, target)
작성일 : 2015-01-19
작성자 : 응용팀 hyj
수정일 수정자 수정내용
------ ------ -------------------
2015.01.19 hyj 최조생성
 ***********************************************************************/
function gfn_downFile(formName, atch_file_id, file_sn, target){

	var frm = document.getElementById(formName);
	if(atch_file_id != undefined && atch_file_id != null && atch_file_id != '') {
		frm.file_seq.value = atch_file_id;
	}
	
	if(file_sn != undefined && file_sn != null && file_sn != '') {
		frm.file_sn.value = file_sn;
	}
	
	var t = frm.target;
	
	if(target != undefined && target != null && target != "") {
		frm.target = target;
	} else {
		frm.target = "KCUE_BLANK_FR";
	}
	
	$.post("/common/file/filecheck.do",$("#frm").serialize(),function(data){	 
		if(data.resultVO.resultCode == "SUCCESS"){
			frm.action = "/common/file/FileDownload.do";
			frm.submit();
			frm.target = t;
		}else{
			alert("해당 파일이 존재하지 않습니다.");
		}
	 }, "json");
}

/***********************************************************************
함수명 : gfn_datepick
설 명 : 달력호출
인 자 : formId : 항목ID
사용법 : gfn_datepick(formId)
작성일 : 2015-01-2
작성자 : 강인규
수정일 수정자 수정내용
------ ------ -------------------
2015.01.22 강인규 최초생성
 ***********************************************************************/
function gfn_datepick(formId){
	$( formId ).datepicker({
		selectOtherMonths: true,
		changeYear: true,
		changeMonth: true,
		showButtonPanel: true,
		showOn: "button",
		buttonImage: "/images/btn_b2_calendar.gif",
		buttonImageOnly: true,
		buttonText: "Select date"
	});
}

/***********************************************************************
함수명 : gfn_pageCall
설 명 : 페이지 이동
인 자 : url - 컨트롤러 호출 명
사용법 : fn_pageCall(url)
작성일 : 2015-01-15
작성자 : 응용팀 김충현
수정일      수정자      수정내용
------ ------ -------------------

 ***********************************************************************/
function gfn_pageCall(url) {
	$.post(url,  $("#frm").serialize(), function(data){   
         $("#bodyInit").html(data);
     }
   , "html").error(function() { alert("에러가 발생했습니다!"); });
}

/***********************************************************************
함수명 : gfn_Submission_Call
설 명 : 
인 자 : doUrl - (컨트롤러 호출 명)
       tranData - 전송데이터
       callBackFunc - 콜백함수
       contentType - 컨텐트 type
사용법 : gfn_Submission_Call(doUrl, tranData, callBackFunc, contentType)
작성일 : 2015-01-23
작성자 : 송광호
수정일 수정자 수정내용
------ ------ -------------------
2015.01.23 송광호 최초생성
***********************************************************************/
function gfn_Submission_Call(doUrl, tranData, callBackFunc, contentType){
	var fCallBack;
	var strAddBaseParam = "";
	var doBlock = true;
	
	//기본 전송 파라미터 체크 
	if(doUrl.indexOf("?") > 0)
	{
		strAddBaseParam = "&";
	}else
	{
		strAddBaseParam = "?";
	}
	if((doUrl+tranData).indexOf("p_menu_id") == -1){
		//메뉴 ID PARAM 추가
		strAddBaseParam += "p_menu_id=" + $("#p_menu_id").val();
	}
	
	//기본 전송 파라미터 설정
	doUrl += strAddBaseParam;
	
	fCallBack = function(data)
				{
					//loading 해제
					doBlock = false;
					//$.unblockUI();
				  	
				    //콜백함수 설정
					if(callBackFunc != undefined && callBackFunc != null && (typeof callBackFunc == 'function'))
					{	
						callBackFunc(data);
					}
				};
				
	//default json으로 설정
	if(contentType == undefined || contentType == null || contentType == "")
	{
		contentType = "json";
	}
	
	// loading 메세지 출력
//	$.blockUI({ onUnblock: $.unblockUI });
	
//	setTimeout(function() {
//		if (doBlock)
//			$.blockUI({ onUnblock: $.unblockUI });
//	}, 500);
	
	$.post(doUrl, tranData, fCallBack, contentType).error(function() {$.unblockUI(); alert("에러가 발생했습니다!"); });
	
}

/***********************************************************************
함수명 : gfn_winOpen
설 명 : 오픈팝업
인 자 : doUrl - (컨트롤러 호출 명)
       OpenName - 팝업명
       Wid - 가로크기
       Hei - 세로크기
사용법 : gfn_winOpen(doUrl,OpenName,Wid,Hei)
작성일 : 2015-01-23
작성자 : 강인규
수정일 수정자 수정내용
------ ------ -------------------
2015.01.26 강인규 최초생성
***********************************************************************/

function gfn_winOpen(doUrl,OpenName,Wid,Hei){
	var ScreenWidth		= screen.width;
	var ScreenHeight	= screen.height;
	var OpenWinWidth	= Wid;
	var OpenWinHeight	= Hei;
	var OpenLeft		= (ScreenWidth - OpenWinWidth) / 2;
	var OpenTop			= (ScreenHeight - OpenWinHeight) / 2;
	var OpenWinStatus="left="+OpenLeft+",top="+OpenTop+",toolbar=no,location=no,directories=no,status=no,menubar=no,scrollbars=no,resizable=no,copyhistory=yes,width="+OpenWinWidth+",height="+OpenWinHeight+"";
	var windowID = window.open(doUrl,OpenName,OpenWinStatus);
	return windowID;
}



/***********************************************************************
함수명 : gfn_setCtlDisable
설 명 : 
인 자 : ctlObj - (콤보 컨트롤 ID LIST) (EX> ["cmbId","txtId","txtEmpno"])
       disableFlag - 수정불가 여부( true/false)
사용법 : gfn_setCtlDisable(ctlObj, disableFlag)
작성일 : 2015-01-27
작성자 : 송광호
수정일       수정자    수정내용
------     ------ -------------------
2015.01.27 송광호    최초생성
***********************************************************************/
function gfn_setCtlDisable(ctlObj, disableFlag){
	var strTagName = "";	
	
	for(var i=0; i < ctlObj.length; i++)
	{
		strTagName = $("#"+ ctlObj[i]).prop("tagName");
		
		if(disableFlag)
		{
			switch(strTagName)
			{
				case "SELECT" :
					$("#" + ctlObj[i] + " option").not(":selected").attr("disabled", "disabled");
					$("#" + ctlObj[i]).attr("class", "input_2");					
					break;
					
				case "INPUT" :
					switch($("#" + ctlObj[i]).attr("type"))
					{
						case "checkbox" :
							$("#" + ctlObj[i]).attr("disabled", true);
							break;
						default :
							$("#" + ctlObj[i]).attr("readonly", true);
							$("#" + ctlObj[i]).attr("class", "input_2");
					}					
					break;
					
				case "TEXTAREA" :
					$("#" + ctlObj[i]).attr("readonly", true);
					$("#" + ctlObj[i]).attr("class", "input_2");					
					break;
					
				default:
			}
			
		}else
		{
			switch(strTagName)
			{
				case "SELECT" :
					$("#" + ctlObj[i] + " option").not(":selected").removeAttr("disabled");
					$("#" + ctlObj[i]).attr("class", "select");					
					break;
					
				case "INPUT" :
					switch($("#" + ctlObj[i]).attr("type"))
					{
						case "checkbox" :
							$("#" + ctlObj[i]).removeAttr("disabled");
							break;
						default :
							$("#" + ctlObj[i]).attr("readonly", false);
							$("#" + ctlObj[i]).attr("class", "input");
					}					
					break;
					
				case "TEXTAREA" :
					$("#" + ctlObj[i]).attr("readonly", false);
					$("#" + ctlObj[i]).attr("class", "input");
					break;
					
				default:
			}
		}
	}
}

/***********************************************************************
함수명 : gfn_getUsAthrCd
설 명 : 메뉴에 대한 권한 정보를 찾는다.
인 자 : menu_list : 메뉴리스트 정보, menuID : 메뉴ID 정보, getType : 게시판 ID 정보
사용법 : gfn_getUsAthrCd(menu_list, menuID, getType)
작성일 : 2015-01-28
작성자 : 김충현
수정일       수정자    수정내용
------     ------ -------------------
2015.01.28 김충현    최초생성
***********************************************************************/
function gfn_getUsAthrCd(menu_list, menuID, getType){
	var usAthr = "R"; 
	var titleTopMake = $(".AreaTx");	// body 화면 상위 타이틀 생성
	var titleBotMake = $(".Tit");	// body 화면 하위 타이틀 생성
	titleTopMake.empty();
	titleBotMake.empty();
	
	for ( var i = 0; i < menu_list.length; i++)
	{
		if (menu_list[i].menu_id == menuID)
		{
			if(getType == null || getType == ""){
				usAthr = menu_list[i].us_athr_cd;
			}else if(getType == "board_id"){
				usAthr = menu_list[i].board_id;
			}
			
			// 타이틀 생성
			titleTopMake.append(menu_list[i].sys_div_nm+" > <span>"+menu_list[i].menu_nm+"</span>");
			titleBotMake.append("<p>"+menu_list[i].menu_nm+"</p>");
		}
	}
	
	return usAthr;
}


/***********************************************************************
함수명 : gfn_dataSerialize
설 명   : 폼 태그의 데이터를 직렬화 한다.
인 자   : formId - 폼 id
사용법 : gfn_dataSerialize(formId)
작성일 : 2015-02-05
작성자 : 송광호
수정일      수정자     수정내용
------ ------ -------------------

***********************************************************************/
function gfn_dataSerialize(formId)
{
	//체크박스의 경우 체크된 내역만 직렬화가 되어 예외처리하여 전송데이터 가공.
	var param1 = $("#"+ formId + " :not(input[type='checkbox'])").serialize();
	var param2 = $("#"+ formId + " input[type='checkbox']").map(function(){return this.id+"="+ (this.checked ? "Y" : "N"); }).get().join("&");
				
	return param1 + "&" + param2;
}

function gfn_naviFnLeftRemote()
{
	window.open("http://remote.kcue.or.kr ", "원격지원", "", "");
}

function gfn_naviFnPageCall(pageURL, div, sysDivCd)
{	
	if(pageURL == "#url"){
		return;
	}

	if(div == "reload" || $(".LeftTit").attr("id") != sysDivCd){
		location.href = "/PageLinkAll.do?link="+pageURL;
	}else{
		gfn_Submission_Call(pageURL, "", function(data){   
		        $("#bodyInit").html(data);
		        $(".Left_Mbx > .LeftM_a > a").removeClass("selected");
				$(".Left_Mbx > .LeftM_a > #" + $("#p_menu_id").val()).addClass("selected");
		    }
		, "html");
	}
}

function gfn_logout()
{
	var callBack = function(data){	 
		if(data.resultVO.resultCode == "SUCCESS"){
			location.href = "/PageLink.do?link=cmn/cmn/cmnLogin";
		}
	};
	
	if(confirm("로그아웃 하시겠습니까?")){
		gfn_Submission_Call("/cmn/cmn/login/logout.do", "", callBack, "json");
	}
}

/***********************************************************************
함수명 : gfn_checkDate
설 명   : 시작일자와 종료일자를 체크한다.
인 자   : stDt - 시작일자
          edDt - 종료일자
사용법 : gfn_checkDate(stDt, edDt)
작성일 : 2015-02-26
작성자 : 송광호
수정일      수정자     수정내용
------ ------ -------------------

***********************************************************************/
function gfn_checkDate(stDt, edDt){
	if(stDt.replace(/-/gi,"") > edDt.replace(/-/gi,"")){
		alert("시작일시가 종료일시 보다 클 수 없습니다");
		return false;
	}
	return true;
}


/***********************************************************************
함수명 : gfn_numFormat
설 명   : 숫자형 데이터에 콤마구분을 지은다.
인 자   : 
사용법 : 123456.gfn_numFormat() = 123,456
작성일 : 2015-02-26
작성자 : 박현수
수정일      수정자     수정내용
------ ------ -------------------

***********************************************************************/
Number.prototype.gfn_numFormat = function(){
	if(this == 0) return 0;
	
	var r = /(^[+-]?\d+)(\d{3})/;
	var n = (this + '');
	
	while(r.test(n)) n = n.replace(r, '$1' + ',' + '$2');
	
	return n;
};


/***********************************************************************
함수명 : gfn_numFormat
설 명   : 문자형 숫자 데이터에 콤마구분을 지은다.
인 자   : 
사용법 : "123456".gfn_numFormat() = 123,456
작성일 : 2015-02-26
작성자 : 박현수
수정일      수정자     수정내용
------ ------ -------------------

***********************************************************************/
String.prototype.gfn_numFormat = function(){
	var n = parseFloat(this);
	
	if(isNaN(n)) return "0";
	
	return n.gfn_numFormat();
};


/***********************************************************************
함수명 : gfn_trim
설 명   : 문자형 데이터 양쪽 공백 제거
인 자   : 
사용법 : " 123456 ".gfn_trim() = "123456"
작성일 : 2015-02-26
작성자 : 박현수
수정일      수정자     수정내용
------ ------ -------------------

***********************************************************************/
String.prototype.gfn_trim = function(){
	return this.replace(/\s/g, "");
};



/***********************************************************************
함수명 : gfn_getParam
설 명   : url의 파라미터 값을 가져온다.
인 자   : 
사용법 : url = "a=1&b=2&c=3" || key=파라미터명
작성일 : 2015-02-26
작성자 : 박현수
수정일      수정자     수정내용
------ ------ -------------------

***********************************************************************/
function gfn_getParam(url,key){
   var parameters = [];
   var rtn_param = "";
	
   parameters = url.split("&");
   
   for ( var k =0; k < parameters.length; k++ ){
       if (parameters[k].split("=")[1].length > 0 ){
       	var val = parameters[k].split("=")[0];
       	var param = parameters[k].split("=")[1];
       	
       	if(key == val){
       		rtn_param = param;
       	}
       }
   }
   
   return rtn_param == "" ? "" : rtn_param;
}

/*
 * 사용자가이드
 */
function goGuide(gUrl){
    var winWidth = 800;
    var winHeight = 760;
    var winURL = gUrl;
    var winPosLeft = (screen.width - winWidth) / 2;
    var winPosTop = (screen.height - winHeight) / 2;
    var winOpt = "width="+winWidth+", height="+winHeight;
    window.open(winURL, 'guide_pop', winOpt + ", menubar=no, status=no, scrollbars=no, resizable=no");
}

/*
 * 팝업창(10:현재창, 20:팝업, 30:새창) 
 */
function go_pop(link, link_cd, link_width, link_vrticl){

	var target = "";
	var size = "";
	if(link_cd == "10"){
		target = "_self";
	}else if(link_cd == "20"){
		target = "_blank";
		size   = "width="+link_width+", height="+link_vrticl;
	}else if(link_cd == "30"){
		target = "_blank";
		size   = "width="+screen.width+", height="+screen.height+", top=0, left=0, fullscreen=yes, status=yes, menubar=yes, toolbar=yes, resizable=yes, location=yes";
	}
	window.open(link, target, size+", scrollbars=yes");
}


/***********************************************************************
함수명 : gfn_setComSession
설 명 : 공통적인 퀵메뉴, 마이페이지 상단메뉴를 갱신하기 위한 세션을 저장한다.
인 자 : param : univRef=Y,subjctRef=Y...,allRef=Y, [reloadAt : Y/N]
사용법 : gfn_setComSession(param,reloadAt)
***********************************************************************/
function gfn_setComSession(refCode,refVal,reloadAt, cb){
	gfn_Submission_Call("/kcue/ast/eip/com/sessionReflesh.do", "refCode="+refCode+"&refVal="+refVal, function(data){
		if(data != null && gfn_null(reloadAt) == 'Y'){
			window.location.reload();
		}
		if(typeof cb === "function") cb();
	},'json');
}

/* 함수명	: isIE
 * 설명	: IE브라우저 버전번호를 리턴, 그외는 false를 리턴한다.
 * --------------------------------------------------------------
 * IE8체크를 위해 사용됨
 */
function isIE () {
	  var myNav = navigator.userAgent.toLowerCase();
	  return (myNav.indexOf('msie') != -1) ? parseInt(myNav.split('msie')[1]) : false;
}



//현재날짜 스트링 변환 (return : 20161215090500)
function getFullDate(date, dash){
  
  var year = date.getFullYear();
  var month = date.getMonth()+1;
  var day = date.getDate();
  var hour = date.getHours();
  var min = date.getMinutes();
  var sec = date.getSeconds();

  if(month.toString().length < 2){
      month = "0"+month;
  }
  
  if(day.toString().length < 2){
      day = "0"+day;
  }

  if(hour.toString().length < 2){
      hour = "0"+hour;
  }

  if(min.toString().length < 2){
      min = "0"+min;
  }
  
  if(sec.toString().length < 2){
      sec = "0"+sec;
  }
  
  var today = "";
  
  if(dash){
      today = year+"-"+month+"-"+day+" "+hour+":"+min+":"+sec;
  }else{
      today = year+""+month+""+day+""+hour+""+min+""+sec;
  }
  
  return today;
}

/**
 * @class 쿠키 관리 클래스
 * @author 송광호 / 2015-02-27
 */
gCookieUtil = {
	/**
	 * 쿠키 관리
	 * @member init
	 * @return void
	 * @type void
	 * @author 송광호 / 2015-02-27
	 */
	init : function(){},

		
	/**
	 * 쿠키값을 삭제한다.
	 * @member delCookie
	 * @param {String} psKey
	 * @return String
	 * @type String
	 * @author 송광호 / 2015-02-27
	 */
	delCookie : function (psKey) {
	    var date = new Date(); // 오늘 날짜 
	    var validity = -1;
	    date.setDate(date.getDate() + validity);

	    document.cookie = psKey + "=;path=/;expires=" + date.toGMTString();
	},

	/**
	 * 쿠키값을 설정한다.
	 * @member setCookie
	 * @param {String} psKey
 	 * @param {String} psValue
	 * @param {int} piAddDay
	 * @return void
	 * @type void
	 * @author 송광호 / 2015-02-27
	 */
	setCookie : function(psKey, psValue, piAddDay) {
		piAddDay = 1;
		var date = new Date(); // 오늘 날짜		
		date = new Date(parseInt(date.getTime() / 86400000) * 86400000 + 54000000);				
	    if ( date > new Date() )  
	    {  
		  piAddDay = piAddDay - 1;  
	     } 		 
		// 만료시점 : 설정		
	    date.setDate(date.getDate() + piAddDay);
		// 쿠키 저장
	    document.cookie = psKey + '=' + escape(psValue) + ';path=/;expires=' + date.toGMTString();
		
	},
	
	/**
	 * 쿠키값을 가져온다.
	 * @member getCookie
	 * @param {String} psKey
	 * @return String
	 * @type String
	 * @author 송광호 / 2015-02-27
	 */
	getCookie : function (psKey) {
	    var allcookies = document.cookie;
	    var cookies = allcookies.split("; ");
	    for (var i = 0; i < cookies.length; i++) {
	        var keyValues = cookies[i].split("=");
	        if (keyValues[0] == psKey) {
	            return unescape(keyValues[1]);
	        }
	    }
	    return "";
	}

};

//<![CDATA[
$(function() {

	// 메인네비게이션  소스재배포
	var cnt=0;
	$('#lnb ul li').mouseenter(function(){
			cnt = $(this).index();
			$('.sub_lnb').removeClass('on').eq(cnt).addClass('on');
			$('#sub_lnb_cover').stop().animate({height : '206px'},500);
		});
	$('#lnb ul').mouseleave(function(){
			$('.sub_lnb').removeClass('on');
			$('#sub_lnb_cover').stop().animate({height : 0},0);
	});

	$('#sub_lnb_cover').mouseenter(function(){
			$('.sub_lnb').removeClass('on').eq(cnt).addClass('on');
			$('#sub_lnb_cover').stop().css({height : '206px'},0);
	});
	$('#sub_lnb_cover').mouseleave(function(){
			$('.sub_lnb').removeClass('on');
			$('#sub_lnb_cover').stop().animate({height : 0},500);
	});
	$('.sub_lnb').hover(function(){
			$('.sub_lnb').each(function(){
		           $(this).removeClass('on');
		         });
			$(this).addClass('on');

	});
	$('.sub_lnb').mouseleave(function(){
			$('.sub_lnb_cover').addClass('on');
	});
    
    
    // 서브네비게이션    
    $(document).ready(function(){
        $(".nav ul.sub").hide();
        $(".nav ul.menu li").click(function(){
            $("ul",this).slideToggle("fast");
        });
    });
    
    
    // 탭 메뉴
	$(".tab01").click("action",function(){	
		$(this).addClass("on");
		$(".tabmenu_sub > li:not('.tab01')").removeClass("on");		  
		$(".list_div > div:not('.tab_1')").css('display','none');
		$(".list_div > .tab_1").css('display','block');
	});
	$(".tab02").click("action",function(){			
		$(this).addClass("on");
		$(".tabmenu_sub > li:not('.tab02')").removeClass("on");
		$(".list_div > div:not('.tab_2')").css('display','none');
		$(".list_div > .tab_2").css('display','block');
	});
	$(".tab03").click("action",function(){			
		$(this).addClass("on");
		$(".tabmenu_sub > li:not('.tab03')").removeClass("on");
		$(".list_div > div:not('.tab_3')").css('display','none');
		$(".list_div > .tab_3").css('display','block');
	});
    
    
    //팝업 열기/닫기버튼
    $(".flatbtn").click(function(){
		$("#layer_popup_wrap").fadeIn("fast");
	});
    $(".flatbtn").click(function(){
		$(".popup-bg").fadeIn("fast");
	});
  
    
	$(".bt_close").click(function(){
		$("#layer_popup_wrap").fadeOut("fast");
	});
    $(".bt_close").click(function(){
		$(".popup-bg").fadeOut("fast");
	});
	$(".bt_cancle").click(function(){
		$("#layer_popup_wrap").fadeOut("fast");
	});
    $(".bt_cancle").click(function(){
		$(".popup-bg").fadeOut("fast");
	});
    

     
    
    
// 메인지도
	var clicked = false;
	var zindex = 0;
	/*
     $(".map map area , .area_list li a").mouseover(function () {
         if (!clicked) {
             var imgEl = $(".mapImg");
             imgEl.attr("src", "../images/img/map_bg.jpg");//기본 지도이미지
             var id = $(this).attr("data-id");//가지고있는 데이터 값
             imgEl.attr("src", "../images/img/map_" + id + ".png");
         }
     });
*/
   $(".map map area .area_list li a").mouseout(function () {
         var imgEl = $(".mapImg"); 
     });

	$(".map map area").click(function () {
	    clicked = true;
	   	$(".area_list li a").removeClass("area_btn");
	    var imgEl = $(".mapImg");
	    var id = $(this).attr("data-id");
		var chkimg = $('.mapImg').find('.img'+id).length;

		if(!chkimg){
			$('.mapImg').prepend('<span class="img'+id+'"><img src="/ocu/images/img/map_'+id+'.png" alt="" usemap="#map"></span>');
		}else{
			$('.mapImg').find('.img'+id).remove();
		}
		$(".map_selectAll a").attr("class", "");
		map_click(id);
		
	    return false;
		});
		


		//신청 - 접기/펼치기
		$(function() {
			$("#divGrade_btn > .btnOpen").click(function() {
				$("#divGrade").show(0);
				$("#divGrade_btn > .btnOpen").hide(0);
				$("#divGrade_btn > .btnFold").show(0);
			});
			$("#divGrade_btn > .btnFold").click(function() {
				$("#divGrade").hide(0);
				$("#divGrade_btn > .btnFold").hide(0);
				$("#divGrade_btn > .btnOpen").show(0);
			});

			$("#divScore_btn > .btnOpen").click(function() {
				$("#divScore").show(0);
				$("#divScore_btn > .btnOpen").hide(0);
				$("#divScore_btn > .btnFold").show(0);
			});
			$("#divScore_btn > .btnFold").click(function() {
				$("#divScore").hide(0);
				$("#divScore_btn > .btnFold").hide(0);
				$("#divScore_btn > .btnOpen").show(0);
			});
		});

		// 팝업 - 효과적인 사용방법안내
		
		
		// 팝업 - 효과적인 사용방법안내/탭 메뉴
		$(".tab01").click("action",function(){	
			$(this).addClass("on");
			$(".tabmenu > li:not('.tab01')").removeClass("on");		  
			$(".content_popup > div:not('.tab_1')").css('display','none');
			$(".content_popup > .tab_1").css('display','block');
		});
		$(".tab02").click("action",function(){			
			$(this).addClass("on");
			$(".tabmenu > li:not('.tab02')").removeClass("on");
			$(".content_popup > div:not('.tab_2')").css('display','none');
			$(".content_popup > .tab_2").css('display','block');
		});
		$(".tab03").click("action",function(){			
			$(this).addClass("on");
			$(".tabmenu > li:not('.tab03')").removeClass("on");
			$(".content_popup > div:not('.tab_3')").css('display','none');
			$(".content_popup > .tab_3").css('display','block');
		});
		$(".tab04").click("action",function(){			
			$(this).addClass("on");
			$(".tabmenu > li:not('.tab04')").removeClass("on");
			$(".content_popup > div:not('.tab_4')").css('display','none');
			$(".content_popup > .tab_4").css('display','block');
		});

});