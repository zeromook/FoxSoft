<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!-- 
/* 메뉴관리
	11 : 상담소개
	12 : 공지사항
*/
 -->
<script type="text/javaScript" language="javascript">

	$(document).ready(function() {
		changSub("${param.mnuDiv}");
	});

	function changSub(div){
		var tbResult = $("#naviSubMenu2");
		tbResult.empty();
		
		var mnu_12 = "<li><a href='/kcue/ast/eip/ocu/notice/EipOcuNotice.do?p_menu_id=PG-EIP-9120' title='공지사항'>공지사항</a></li>";
		var titleNm = "";
		var titleNm2 = "";
		var strRow = "";
		
		if(div == "12"){
			titleNm = "상담안내";
			titleNm2 = "공지사항";
			strRow = mnu_12;
			$('#headerOcuMnu1').attr("class", "on");
		}
		$('#naviMenu1').text(titleNm);
		$('#naviMenu1').attr("title", titleNm);
		$('#naviMenu2').text(titleNm2);
		$('#naviMenu2').attr("title", titleNm2);
		
		
		
		tbResult.append(strRow);
	}
</script>
	<!-- 서브페이지 상단 네비게이션 -->
	    <div class="nav_bar">
	        <h2><a href="/kcue/ast/eip/ocu/main/EipMain.do?p_menu_id=PG-EIP-90001" title="HOME">HOME</a></h2>
	        <ul class="menu menuBox01">
	            <li><a href="#" class="tit"  id="naviMenu1" title="상담안내">상담안내</a>
	                <ul class="sub01">
	                    <li><a href="javascript:changSub('12');" title="상담안내">상담안내</a></li>
	                </ul>
	            </li>
	        </ul>
	        <ul class="menu menuBox02">
	            <li><a href="#" class="tit t_02" id="naviMenu2" title="선택하세요">선택하세요</a>
	                <ul class="sub02" id="naviSubMenu2" >
	                </ul>
	            </li>
	        </ul>
	    </div>
	<!-- //서브페이지 상단 네비게이션 -->

