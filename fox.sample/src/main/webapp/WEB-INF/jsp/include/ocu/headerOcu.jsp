<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="javax.servlet.http.HttpSession"%>
<%@ page import="kcue.common.util.Keys"%>
<%@ page import="kcue.common.util.StringUtil"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib  prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
	<!-- header -->
			<div class="gnb">
				<div class="gnb_wrap">
					<ul class="gnb_menu">
						<li>
							<a href="#" title="로그인">로그인</a>
						</li>
						<li><a href="#" title="대입정보포털어디가">대입정보포털어디가</a></li>
					</ul>
				</div>
			</div>
			<!-- gnb -->
			<div class="lnb_wrap">
				<h1><a href="#" title="대학별 온라인상담"><img src="/images/img/logo_top.gif" alt="대학별 온라인상담"></a></h1>
				<h2 class="skip">메인메뉴</h2>
				<div id="lnb">
					<ul class="lnb_menu">
						<li><a href="#" title="상담안내" id="headerOcuMnu1">상담안내</a></li>
					</ul>
				</div>
			</div>
			<!-- lnb_wrap -->
			
			<!-- 2뎁스메뉴 -->
			<div id="sub_lnb_cover">
				<div class="cover_wrap">
					<div class="sub_lnb_cover_in">
						<div class="sub_lnb_cover">
							<ul class="sub_lnb fr">
								<li>상담안내</li>
								<li><a href="/kcue/ast/eip/ocu/notice/EipOcuNotice.do?p_menu_id=PG-EIP-91201" title="공지사항">공지사항</a></li>
							</ul>
						</div>
					</div><!-- sub_gnb_cover_in -->
				</div>
			</div><!-- sub_gnb_cover -->
			<!-- 2뎁스메뉴 -->
		<!-- header -->

