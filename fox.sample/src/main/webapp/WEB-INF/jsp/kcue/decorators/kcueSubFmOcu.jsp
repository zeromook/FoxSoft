<%@page import="kcue.common.util.StringUtil"%>
<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/page" prefix="page" %>
<%@ page import="javax.servlet.http.HttpSession"%>
<%@ page import="kcue.common.util.Keys"%>
<%
	String url = StringUtil.nchk((String) request.getAttribute("javax.servlet.include.request_uri"));
	String link_param = StringUtil.nchk((String) request.getParameter("link"));
	if (url.equals("")) {
		url = request.getRequestURI();
	}
	
%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" lang="ko" xml:lang="ko">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge" />


	<title><decorator:title default="대학별 온라인상담" /></title>
	<!-- custom css -->
	
	<link rel="stylesheet" type="text/css" href="/css/common.css"/>
	<link rel="stylesheet" type="text/css" href="/css/layout.css"/>
	<link rel="stylesheet" type="text/css" href="/css/main.css"/>
	<link rel="stylesheet" type="text/css" href="/css/sub.css"/>
	<link rel="stylesheet" type="text/css" href="/css/popup.css"/>

	
	<script type="text/javascript" src="/js/jquery-1.11.3.min.js"></script>
	<script type="text/javascript" src="/js/jquery.blockUI.min.js"></script>
	<script type="text/javascript" src="/js/common.js"></script>
	<script type="text/javascript" src="/js/jquery.toast.min.js"></script>
	<script type="text/javascript" src="/js/common.js"></script>
	<script type="text/javascript" src="/js/jquery.leanModal.min.js"></script>
	
<decorator:head />
</head>
<body>
		<div id="SkipNavi">
			<h2 class="skip">건너뛰기링크</h2>
			<ul>
				<li><a href="#gnb">주메뉴바로가기</a></li>
				<li><a href="#container">본문바로가기</a></li>
			</ul>
		</div>

<div id="wrap">
	<!-- Header --> 
	<div id="header"><page:apply-decorator name="panel" page="/EgovPageLink.do?link=include/ocu/headerOcu" /></div>
	<!-- // Header -->    
	
	<!-- Left -->
	<!-- 만드는건 여기 안으로 들어가는것-------------------------------------------------------------- -->
	 <div id=container>
		<decorator:body />
	</div>
	<!-- 만드는건 여기 안으로 들어가는것-------------------------------------------------------------- -->
	
	<!-- Footer --> 
	<div id="footer"><page:apply-decorator name="panel" page="/EgovPageLink.do?link=include/ocu/footerOcu" /></div>
	<!-- // Footer -->    
<!-- </div> -->
</div>
</body>
</html>