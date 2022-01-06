<%@page import="java.net.URLDecoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	String errMsg = (String) request.getAttribute("err_msg");
	if(errMsg == null || "".equals(errMsg)){
		errMsg = "요청하신 페이지가 존재하지 않습니다.";
	}
%>

<html lang="ko">
<head>
<meta charset="utf-8">
<title>대학입학정보</title>

<!-- custom css -->
<link rel="stylesheet" href="../css/default.css" />
<link rel="stylesheet" href="../css/style.css" />

<!-- Jquery -->
<script type="text/javascript" src="../js/jquery-1.11.3.js"></script>

</head>
<body>
	<div id="wrap">		

		<!-- container -->
		<div id="container2">
			<div class="mg15" id="dverr">
				<a href="" title="대학입학정보"><img src="../images/logo.png" alt="대학입학정보" /></a>
				<div class="dv_error mgb60">
					<p class="error_txt1">서비스 이용에 불편을 드려서 대단히 죄송합니다.</p>
					<p class="error_txt2 mgt20">원하시는 페이지를 찾을 수 없습니다.</p>
					<p class="mgt15">입력하신 페이지 주소가 정확하지 않거나<br />
					주소가 변경되어 화면을 표시할 수 없습니다.<br />
					다시한번 확인하시고 페이지 주소를 입력해주시기 바랍니다.</p>
					<button type="button" class="mgt30" onClick=location.href="/EgovPageLink.do?link=EipMain" title="대학입학정보 메인페이지로 바로가기">
						<img src="../images/btn_dv_error.png" alt="대학입학정보 메인페이지로 바로가기">
					</button>
				</div>
			</div>
			

		</div>
		<!-- //container -->
		
		<script type="text/javascript">
		 $( document ).ready(function() {
		    $(window).resize();
		 }); 
		 $(window).resize(function(){
		     $('#dverr').css({position:'absolute'}).css({
		         top: ($(window).height() - $('#dverr').height())/2
		     });
		 });
		</script>
	</div>
</body>
</html>