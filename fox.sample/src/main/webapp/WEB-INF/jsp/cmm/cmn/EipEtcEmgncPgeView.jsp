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
		<div id="header" style="padding:20px 0 30px 0;">
			<div id="header2">
				<!-- 검색영역 -->
				<div class="topsearch" style="margin:18px 0 0 25px !important;">
           <div class="logo">
            	<a href="#" title="대학입학정보"><img src="/images/logo.png" alt="대학입학정보" /></a>
            </div>       
            </div>    
            </div> 
         </div>

		<!-- container -->
		<div id="container2">
			<div class="mg15">
				<div class="dv_error2">
					<p class="error_txt1">대입정보포털 시험운영 종료 및 오픈 준비 알림!</p>
					<p class="mgt20">안녕하세요. 대입정보포털 서비스 운영팀입니다.</p>
					<p class="mgt15">대입정보포털은 3월 21일(월) 19시로 시험운영을 종료하고<br />
					서비스 오픈(3월 25일 10시) 준비 중 입니다.</p>
					<p class="mgt15">오픈 준비 중에는 서비스를 이용 하실 수 없습니다.<br />
					안정적인 서비스 제공을 위하여 준비 중 이오니 양해 바랍니다.</p>
					<p class="mgt15">감사합니다.</p>
					<div class="errordate">
						<p class="error_txt2">서비스 오픈 예정일시</p>
						<p class="font_w t_cr08 mgt15">&nbsp;&nbsp;2016년 3월 25일 (금)</p>
						<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;10:00 부터</p>
					</div>
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
