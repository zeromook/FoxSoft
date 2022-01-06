<%@ page import="kcue.common.util.Keys"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
	<script type="text/javaScript">
		
		/***********************************************************************
		함수명 : go_list
		설 명   : 공지사항 목록조회 페이지로 이동한다.
		인 자   : 
		사용법 : go_list
		작성일 : 2015-08-06
		작성자 : 장근석
		수정일              수정자            수정내용
		------      ------ -------------------
		2015.08.06     장근석            최초 생성
		 ***********************************************************************/
		function go_list()
		{
			var frmPre = document.frmPre;
			frmPre.action ="/kcue/ast/eip/ocu/notice/EipOcuNotice.do?p_menu_id=PG-EIP-91201";
			frmPre.submit();
		}
		
		function go_view(sn,rnum)
		{
			var frmPre = document.frmPre;
			frmPre.action = "/kcue/ast/eip/ocu/notice/EipOcuNoticeView.do?p_menu_id=PG-EIP-91201&sn="+sn + "&rnum=" + rnum;
			frmPre.submit();
		}
		
</script>
<h2 class="skip">본문영역</h2>
<div class="content_wrap">
   	<!-- 서브페이지 상단 네비게이션 -->
   	<div class="nav">
    		<jsp:include page="../navi/naviOcu.jsp" flush="true">
			<jsp:param name="mnuDiv" value="12" />
		</jsp:include>
    	</div>
    
    	<div class="content_wrap_inner">
   		<div class="content_top">
      			<h1 class="conSub">공지사항</h1>
   		</div>
    	<form:form commandName="eipView" name="frm" id="frm" method="post"> 
    	<div class="content">
    		<table class="list_view">
 				<caption>게시판 내용조회 페이지</caption>
				<colgroup>
					<col style="width:13%">
					<col />
					<col style="width:13%">
					<col />
					<col style="width:13%">
					<col />
				</colgroup>
				<tbody>
					<tr>
						<th scope="row">글번호</th>
						<td colspan="5"><c:out value="${eipView.rnum}"/></td>
					</tr>
					<tr>
						<th scope="row">제목</th>
						<td colspan="5" class="view_tt"><c:out value="${eipView.sj}"/></td>
					</tr>
					<tr>
						<th scope="row">등록자</th>
						<td><c:out value="${eipView.ins_usr_nm}"/></td>
						<th scope="row">등록일</th>
						<td><c:out value="${eipView.ins_dt}"/></td>
						<th scope="row">조회수</th>
						<td><c:out value="${eipView.inqire_co}"/></td>
					</tr>
					<tr>
						<th scope="row">첨부</th>
						<td colspan="5" class="add_file">
							<c:choose>
								<c:when test="${empty eipFileList}">
									<p>업로드된 파일이 없습니다.</p>
								</c:when>
								<c:otherwise>
									<c:forEach var="file" items="${eipFileList}">
										<p>
											<a href="/common/downloadFile.do?fileId=${file.file_id}&filePath=eip.fileStorePath&fileSn=${file.file_sn}">
											<img src="/images/icon/ic_download_list.gif" alt="첨부파일" class="add" />&nbsp;${file.file_nm}</a>
										</p>
									</c:forEach>
								</c:otherwise>
							</c:choose>
						</td>
					</tr>
					<tr>
						<td colspan="6" class="con">
							<form:hidden path="cn" id="editView_cn" value="${eipView.cn}"/>
							<div class="pdb15" id="view_cn"></div>
							<script type="text/javascript">
							<!--
								if(gfn_null($("#editView_cn").val()).toUpperCase().indexOf("<HTML") < 0){
									$("#view_cn").html($("#editView_cn").val().replace(/</g,"&lt;").replace(/>/g,"&gt;").replace(/\n/g,"<br/>"));
								}else{
									$("#view_cn").html($("#editView_cn").val());
								}
							-->
							</script>
						</td>
					</tr>
				</tbody>
 			</table>	
    	</div>
    	</form:form>
    
	 	<form:form commandName="eipOcuNoticeVO" name="frmPre" id="frmPre" method="post">
			<form:hidden path="sel_cl" id="sel_cl"/>
			<form:hidden path="searchFindKeyword" id="searchFindKeyword"/>
			<form:hidden path="searchKeyword" id="searchKeyword"/> 
			<form:hidden path="pageIndex" id="pageIndex"/>
			<form:hidden path="pageSize" id="pageSize"/>
			<form:hidden path="from_view" id="from_view" value="Y"/>
		</form:form>
		
		<div class="list_bottom_btn">
	 		<button type="button" class="" title="목록" onclick="go_list();">목록</button>
		</div>
	 
	 	<div class="prev_next_bottom">
			<ul>
				<li>
					<img src="/images/icon/icon_PrevList.gif" alt="이전" />
					<span class="list_quick_btn">이전글</span>
					<a href="#" onclick="go_view(gfn_nvl(${eipOcuNoticeVO.prev_sn}),gfn_nvl(${eipOcuNoticeVO.prev_rnum}))"><c:out value="${eipOcuNoticeVO.prev_nm}"/></a>
				</li>
				<li>
					<img src="/images/icon/icon_NextList.gif" alt="다음" />
					<span class="list_quick_btn">다음글</span>
					<a href="#" onclick="go_view(gfn_nvl(${eipOcuNoticeVO.next_sn}),gfn_nvl(${eipOcuNoticeVO.next_rnum}))"><c:out value="${eipOcuNoticeVO.next_nm}"/></a>
				</li>
			</ul>
	 	</div>
	</div>
</div>
