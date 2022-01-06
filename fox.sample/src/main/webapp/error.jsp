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
<html>
<head>
	<title>표준공통원서 관리 시스템</title>
	<META HTTP-EQUIV="Content-Type" CONTENT="text/html; charset=UTF-8">
	<style type="text/css">
	body { background:none; }
	body { margin:0; padding:0; background-color:#fff; text-align:left; }
	body, * { color:#464646; font-family:AppleGothic,dotum, sans-serif; }
	hr , caption{ display:none; }
	img, fieldset { border:0 none; }
	button { border:0; padding:0; margin:0; background:#fff; cursor:pointer; }
	abbr,acronym { border:0; }
	dl,ul,ol,li { list-style: none; }
	body,div,dl,dt,dd,ul,ol,li,h1,h2,h3,h4,h5,h6,pre,form,fieldset,input,textarea,blockquote,th,td,p,label { margin:0; padding:0; }
	table { border-collapse:collapse; }
	a { color:#333; text-decoration:none; }
	a:hover, a:active { text-decoration:underline; }
	input,select,textarea { vertical-align:middle; }
	body,th,td { font-size:12px; font-family:AppleGothic,dotum,sans-serif; color:#464646; }
	h1, h2, h3, h4, h5, h6 { font-size: 100%; font-weight: normal; }
	/* 에러페이지 */
	#error { width:560px; margin:200px auto 0; vertical-align: middle; }
	#error .errorframe { width:450px; height:150px; padding-left:290px; padding-top:50px; background:url("/images/error/bg_error.gif") no-repeat 0 0; }
	#error .errorCon { vertical-align:middle; }
	#error .errorTit { font:16px dotum; font-weight:bold; color:#993300; padding-bottom:8px; }
	#error .errortxt { line-height:17px; padding-bottom:10px; } 
	#footer p {float:left; }
	#footer .green{color:#1a8003}
	#footer .black{color:#1b1b1b}
	#footer .brown{color:#85701c}
	#footer .copyright{display:block;margin-top:5px;font-size:10px;font-family:Myriad Pro;color:#898989}
	#footer .copyright2{float:left; line-height:17px; color:#989898; font-size:11px; padding:10px 0 0 0;}
	
	</style>
</head>

<body>
	<div id="error">
		<div>
			<table class="errorCon">
				<tr>		
					<!-- <td valign="middle"><img src="/images/p_name.gif" border="0" alt="표준공통원서 관리 시스템" /></td> -->
				</tr>
			</table>
		</div>
		<div class="errorframe">
	    <table class="errorCon">
	    	<tr>
	    		<td class="errorTit">불편을 드려서 죄송합니다.</td>
	    	</tr>
			<tr>
				<td class="errortxt">
					<span style="color: #FF0000"><%=errMsg %></span>
					<br />보다 정확하고 편리한 서비스를 제공할 수 있도록 최선을 다하겠습니다.
					<br /> 
					<br />
					<a href="/index.jsp" ><img src="/images/error/go_main_2.jpg" border="0" alt="로그인 화면으로 이동" /></a>					
				</td>
			</tr>
	    </table>
	  	</div>
		<div id="footer">
			<p style="position:relative;"><img src="/images/footer_logo.gif" border="0" alt="표준공통원서 관리 시스템" /></p>			
	    	<div class="copyright2">서울 금천구 서부샛길 606(가산동 543-1) 대성디폴리스 A동 22,23층<br /> Copyright by KCUE, All rights reserved. </div>
	  	</div>
	</div>
</body>
</html>