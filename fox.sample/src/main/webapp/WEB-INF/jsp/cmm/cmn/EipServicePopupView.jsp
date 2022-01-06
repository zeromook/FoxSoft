<%@page import="java.net.URLDecoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ko">
<head>
<meta charset="utf-8">
<title>대학입학정보</title>
<link rel="stylesheet" href="/css/default.css" />
<style type="text/css">

body{
overflow-y: hidden;
overflow-x: hidden;
}
label{
font: 12px "맑은 고딕", Malgun Gothic, NanumGothic, dotum, sans-serif;
color: #35414d;
}
</style>
<script type="text/javascript" src="/js/jquery-1.11.3.min.js"></script>
<script src="/js/common.js"></script>
<script type="text/javascript">
//window.resizeTo(226, 280);

function fn_servicePop(obj){
	if($("#chk_today").is(":checked")){
		//true
        var date = new Date();
        var today = getFullDate(date,true);
        localStorage.todayChk = today;
	}else{
		//false
        sessionStorage.popChk = 1;
	}
	opener.go_hearderPop("/PageLinkAll.do?link=/kcue/ast/eip/eis/cstmr/notice/EipNoticeView.do&p_menu_id=PG-EIP-10901&sn=10273&rnum=4",'10','','');
	self.close();
}
</script>
</head>
<body>
	<div id="wrap">
	    <a title="대입정보포털 서비스 점검" onclick="fn_servicePop(this);">
            <img width="100%" height="256" alt="대입정보포털 서비스 점검" src="/images/service_popup200601.png"/>
        </a>
        <div>
        <span><input type="checkbox" id="chk_today" name="chk_today" onclick="fn_servicePop(this);"/><label for="chk_today">오늘하루 열지 않기</label></span>
        </div>
	</div>
</body>
</html>