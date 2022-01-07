<%@ page import="kcue.common.util.Keys"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<%
 /**
  * @Class Name : EipNoticeList.jsp
  * @Description : 공지사항 List 화면
  * @Modification Information
  * 대교협 포털 공지사항 목록 조회
  *
  * 수정일			수정자			수정내용
  * 2015.08.05		장근석			최초 생성
  */
%>
		<script type="text/javascript" src="/js/jquery.twbsPagination.js"></script>
		<spring:message code="common.nodata.msg" var="nodataMsg"></spring:message>
		<script type="text/javaScript" >
// 		var currentPage = '1';
		$(document).ready(function() {
			init();
		});

		/***********************************************************************
		함수명 : init
		설 명   : 화면 초기화
		인 자   : 
		사용법 : init()
		작성일 : 2015-08-05
		작성자 : 응용팀 장근석
		수정일 			수정자 				수정내용
		-----------		------		 -------------------
		2015.08.05		장근석 				최초생성
		 ***********************************************************************/
		function init() {
			btn_search_onclick();
		}
		

		/***********************************************************************
		함수명 : btn_search_onclick
		설 명   : 프로그램 목록을 조회
		인 자   :
		사용법 : btn_search_onclick()
		작성일 : 2015-08-06
		작성자 : 응용팀 장근석
		수정일 			수정자 				수정내용
		-----------		------		 -------------------
		2015.08.05		장근석 				최초생성
		 ***********************************************************************/
		function btn_search_onclick() {
			if($('#from_view').val() == 'Y'){
				$('#from_view').value = 'N';  //값만 바꿔줌
			}else{
// 				document.frm.pageIndex.value = 1;  //페이지 초기화
			}
			$('#paginationholder').html('');
		    $('#paginationholder').html('<ul id="pagination" class="pages"></ul>');
						
			gfn_Submission_Call("/kcue/ast/eip/ocu/notice/EipOcuNoticeList.do",$("#frm").serialize(), function(data){
				if(data != null){
			        if (data.resultVO.resultCode == "SUCCESS")
				    {
						fn_makeResult("/kcue/ast/eip/ocu/notice/EipOcuNoticeList.do",data,Number(document.frm.pageIndex.value));
				    }else{
				    	alert(data.resultVO.resultMessage);
				    }
				}
			},'json');
		}
		
		/***********************************************************************
		함수명 : fn_pageOnChange
		설 명   : 페이지 갯수 변경시 이벤트
		인 자   :
		사용법 : fn_pageOnChange()
		작성일 : 2015-08-06
		작성자 : 응용팀 장근석
		수정일 			수정자 				수정내용
		-----------		------		 -------------------
		2015.08.06		장근석 				최초생성
		 ***********************************************************************/
		function fn_pageOnChange(){
			document.frm.pageIndex.value = 1;
			btn_search_onclick();
		}
		
		/***********************************************************************
		함수명 : fn_makeResult
		설 명 : JSON 데이터를 받아서 테이블 BODY 생성
		인 자 : doName : 컨트롤러명, data : 프로그램 정보 리스트, currentPage : 현재 페이지
		사용법 : fn_makeResult(doName, data, currentPage)
		작성일 : 2015-08-06
		작성자 : 응용팀 장근석
		수정일 			수정자 				수정내용
		-----------		------		 -------------------
		2015.08.06		장근석 				최초생성
		***********************************************************************/
		function fn_makeResult(doName, data, currentPage){
			
// 			if(data.resultList.length < 1 && document.frm.pageIndex.value != 1){
// 				document.frm.pageIndex.value = 1;  //페이지 초기화
// 				btn_search_onclick();
// 			}
			
// 			$('#paginationholder').html('');
// 		    $('#paginationholder').html('<ul id="pagination" class="pages"></ul>');
		    
			var dataResultList = data.resultList;
			var dataResultTotCnt = data.resultTotCnt;
			var dataResultTotCntOrg = data.resultTotCntOgr;
			var dataResultPageSize = data.resultPageSize;
			var v_totalPages = Math.ceil(dataResultTotCnt / dataResultPageSize);
			
			document.frm.pageIndex.value = currentPage;
			
			var strRow = "";
			
			var totalCountOrg = $("#totalCountOrg");
			//총 글수 조회
			$("#totalCountOrg").empty();
			
			totalCountOrg.empty();
			totalCountOrg.append(dataResultTotCntOrg); //갯수 나타냄
			
			var tbResult = $("#tbResult");
			tbResult.empty();
			
			if(dataResultList != ""){
				
				strRow = "";
				for(var i = 0; i < dataResultList.length; i++){
					
					strRow += '<tr>';
					
					if(dataResultList[i].fixing_notice_at == "Y"){
						strRow += '<td scope="row" class="t_cr01">'+"공지"+' </td>';
					}else {
 						strRow += '<td scope="row">'+dataResultList[i].rnum+' </td>';
					}
					
					/* if(dataResultList[i].fixing_notice_at == "Y"){
						strRow += '<td class="t_cr01">'+gfn_nvl(dataResultList[i].ctgry_nm)+'</td>';
					} else {
						strRow += '<td>'+gfn_nvl(dataResultList[i].ctgry_nm)+'</td>';
					} */
									
					if(gfn_nvl(dataResultList[i].file_icon) == "Y") {
						if(dataResultList[i].fixing_notice_at == "Y"){				
							if(gfn_nvl(dataResultList[i].new_icon) == "Y"){
								if(gfn_null(dataResultList[i].sj).length > 24) {
									strRow += "<td class='tL'><div class='boardon'><a class='tt ellipsis' onclick=\"go_set("+gfn_nvl(dataResultList[i].sn)+","+gfn_nvl(dataResultList[i].rnum)+")\">"+"<img src='/images/re_icon/icon_new2.gif' alt='new' class='mgt2 ' /> "+gfn_nvl(dataResultList[i].sj) +"&nbsp;&nbsp;"+"</a></div><img src='/images/icon/ic_download_list.gif' alt='파일' style='display:inline;position:relative; float:right; margin-top:-15px;'/></td>";
								} else{
									strRow += "<td class='tL'><a class='tt ellipsis' onclick=\"go_set("+gfn_nvl(dataResultList[i].sn)+","+gfn_nvl(dataResultList[i].rnum)+")\">"+"<img src='/images/re_icon/icon_new2.gif' alt='new' class='mgt2 ' /> "+gfn_nvl(dataResultList[i].sj) +"&nbsp;&nbsp;"+"<img src='/images/icon/ic_download_list.gif' alt='파일' class='mgt1 ' /></a></td>";
								}
							}else{
								if(gfn_null(dataResultList[i].sj).length > 24) {
									strRow += "<td class='tL'><div class='boardon'><a class='tt ellipsis' onclick=\"go_set("+gfn_nvl(dataResultList[i].sn)+","+gfn_nvl(dataResultList[i].rnum)+")\">"+gfn_nvl(dataResultList[i].sj) +"&nbsp;&nbsp;"+"</a></div><img src='/images/icon/ic_download_list.gif' alt='파일' style='display:inline;position:relative; float:right; margin-top:-15px;' /></td>";
								} else{
									strRow += "<td class='tL'><a class='tt ellipsis' onclick=\"go_set("+gfn_nvl(dataResultList[i].sn)+","+gfn_nvl(dataResultList[i].rnum)+")\">"+gfn_nvl(dataResultList[i].sj) +"&nbsp;&nbsp;"+"<img src='/images/icon/ic_download_list.gif' alt='파일' class='mgt1 ' /></a></td>";
								}
							}
						} else {
							if(gfn_nvl(dataResultList[i].new_icon) == "Y"){
								if(gfn_null(dataResultList[i].sj).length > 24) {
									strRow += "<td class='tL'><div class='boardon'><a class='tt ellipsis' onclick=\"go_set("+gfn_nvl(dataResultList[i].sn)+","+gfn_nvl(dataResultList[i].rnum)+")\">"+"<img src='/images/re_icon/icon_new2.gif' alt='new' class='mgt2 ' /> "+gfn_nvl(dataResultList[i].sj) +"&nbsp;&nbsp;"+"</a></div><img src='/images/icon/ic_download_list.gif' alt='파일' class='mgt1 ' style='display:inline;position:relative; float:right; margin-top:-15px;' /></td>";
								} else{
									strRow += "<td class='tL'><a class='tt ellipsis' onclick=\"go_set("+gfn_nvl(dataResultList[i].sn)+","+gfn_nvl(dataResultList[i].rnum)+")\">"+"<img src='/images/re_icon/icon_new2.gif' alt='new' class='mgt2 ' /> "+gfn_nvl(dataResultList[i].sj) +"&nbsp;&nbsp;"+"<img src='/images/icon/ic_download_list.gif' alt='파일' /></a></td>";
								}
							}else{
								if(gfn_null(dataResultList[i].sj).length > 24) {
									strRow += "<td class='tL'><div class='boardon'><a class='tt ellipsis' onclick=\"go_set("+gfn_nvl(dataResultList[i].sn)+","+gfn_nvl(dataResultList[i].rnum)+")\">"+gfn_nvl(dataResultList[i].sj) +"&nbsp;&nbsp;"+"</a></div><img src='/images/icon/ic_download_list.gif' alt='파일' style='display:inline;position:relative; float:right; margin-top:-15px;' /></td>";
								} else{
									strRow += "<td class='tL'><a class='tt ellipsis' onclick=\"go_set("+gfn_nvl(dataResultList[i].sn)+","+gfn_nvl(dataResultList[i].rnum)+")\">"+gfn_nvl(dataResultList[i].sj) +"&nbsp;&nbsp;"+"<img src='/images/icon/ic_download_list.gif' alt='파일' class='mgt1 ' /></a></td>";
								}
							}
						}
					}else {
						if(dataResultList[i].fixing_notice_at == "Y"){				
							if(gfn_nvl(dataResultList[i].new_icon) == "Y"){
								strRow += "<td class='tL'><a class='tt ellipsis' onclick=\"go_set("+gfn_nvl(dataResultList[i].sn)+","+gfn_nvl(dataResultList[i].rnum)+")\">"+"<img src='/images/re_icon/icon_new2.gif' alt='new' class='mgt2 ' /> "+gfn_nvl(dataResultList[i].sj)+"</a></td>";
							}else{
								strRow += "<td class='tL'><a class='tt ellipsis' onclick=\"go_set("+gfn_nvl(dataResultList[i].sn)+","+gfn_nvl(dataResultList[i].rnum)+")\">"+gfn_nvl(dataResultList[i].sj)+"</a></td>";
							}
						} else {
							if(gfn_nvl(dataResultList[i].new_icon) == "Y"){
								strRow += "<td class='tL'><a class='tt ellipsis' onclick=\"go_set("+gfn_nvl(dataResultList[i].sn)+","+gfn_nvl(dataResultList[i].rnum)+")\">"+"<img src='/images/re_icon/icon_new2.gif' alt='new' class='mgt2' /> "+gfn_nvl(dataResultList[i].sj)+"</a></td>";
							}else{
								strRow += "<td class='tL'><a class='tt ellipsis' onclick=\"go_set("+gfn_nvl(dataResultList[i].sn)+","+gfn_nvl(dataResultList[i].rnum)+")\">"+gfn_nvl(dataResultList[i].sj)+"</a></td>";
							}
						}
					}
				
					if(dataResultList[i].fixing_notice_at == "Y"){	
						strRow += '<td class="t_cr01">'+gfn_nvl(dataResultList[i].ins_usr_nm)+'</td>';
					} else {
						strRow += '<td>'+gfn_nvl(dataResultList[i].ins_usr_nm)+'</td>';
					}
					
					if(dataResultList[i].fixing_notice_at == "Y"){	
						strRow += '<td class="t_cr01">'+gfn_nvl(dataResultList[i].ins_dt)+'</td>';
					} else {
						strRow += '<td>'+gfn_nvl(dataResultList[i].ins_dt)+'</td>';
					}
					
					if(dataResultList[i].fixing_notice_at == "Y"){	
						strRow += '<td class="t_cr01">'+gfn_nvl(dataResultList[i].inqire_co)+'</td>';
					} else {
						strRow += '<td>'+gfn_nvl(dataResultList[i].inqire_co)+'</td>';
					}
					
					strRow += '</tr>';
									
				}
				tbResult.append(strRow);
				
			}else{
				v_totalPages = 1;
				strRow = "";
				strRow += '<tr>';
				strRow += '<td colspan="5">' + '${nodataMsg}' +'</td>' ;
				strRow += '</tr>';		
				tbResult.append(strRow);
			}
			
			$('#pagination').twbsPagination({totalPages: v_totalPages, visiblePages: 10
				, startPage: currentPage
				, first: '<img src="/images/btn/btn_list_first.gif" alt="첫페이지로" />'
	        	, prev: '<img src="/images/btn/btn_list_prev.gif" alt="이전페이지로" />'
		        , next: '<img src="/images/btn/btn_list_next.gif" alt="다음페이지로" />'
		        , last: '<img src="/images/btn/btn_list_last.gif" alt="마지막페이지로" />'
				, onPageClick: function (event, page) {
			        	var f = document.frm;
			    		f.pageIndex.value = page;
			    		gfn_Submission_Call(doName, $("#frm").serialize(),  function(data){
							if(data != null){
						        if (data.resultVO.resultCode == "SUCCESS")
							    {
									fn_makeResult(doName,data,page);
							    }else{
							    	alert(data.resultVO.resultMessage);
							    }
							}
						},'json');
	    		}
		});
		 	$("#pagination").attr("class","pagination");
		
			$("#pagination li a").filter(function() {
			    return $(this).text() === document.frm.pageIndex.value;
			}).addClass("active");
		}
		
		/***********************************************************************
		함수명 : go_set
		설 명 : 공지사항 게시글 클릭 시 상세 정보를 조회
		인 자 : sn : 선택 된 게시글 일련번호
		사용법 : go_set(sn)
		작성일 : 2015-08-06
		작성자 : 응용팀 장근석
		수정일 			수정자 				수정내용
		-----------		------		 -------------------
		2015.08.06		장근석 				최초생성
		***********************************************************************/
		function go_set(sn, rnum)
		{
			var frm = document.frm;
			frm.action ="/kcue/ast/eip/ocu/notice/EipOcuNoticeView.do?p_menu_id=PG-EIP-91211"+"&sn="+sn + "&rnum=" + rnum;
			frm.submit();
		}
		</script>
		

		<!-- 본문내용 -->
		<h2 class="skip">본문영역</h2>
		<div class="content_wrap">
			<!-- 서브페이지 상단 네비게이션 -->
            <div class="nav">
                <jsp:include page="../navi/naviOcu.jsp" flush="true">
			        <jsp:param name="mnuDiv" value="12" />
			    </jsp:include>
            </div>
            <!-- //서브페이지 상단 네비게이션 -->
            <div class="content_wrap_inner">
            	<form:form commandName="eipOcuNoticeVO" id="frm" name="frm" method="post"  onsubmit="return false;">
            	<div class="content_top">
                    <h1>공지사항</h1>
                    <a href="/kcue/ast/eip/ocu/answerboardlist/EipOcuAnswerBoardList.do">Gesipan</a>
                    <div class="search_box">
                        <form:hidden path="pageIndex" id="pageIndex"/>
                            <fieldset>
                                <legend>목록 검색</legend>
                                <div class="list_search_box">
                                	<form:select path="searchFindKeyword" id="searchFindKeyword" class="des">
										<form:option value="title">제목</form:option>
										<form:option value="content">내용</form:option>
									</form:select>
                                   <form:input path="searchKeyword" id="searchKeyword" type="text" title="검색어를 입력해주세요" multiple="false" onkeypress="if(event.keyCode==13){btn_search_onclick();}"/>
                                   <button type="button" onclick="$('#pageIndex').val('1'); btn_search_onclick()">검색</button>
                                </div>
                            </fieldset>
                    </div>
                </div>
                <div class="content">
	                <div class="list_top">
	                    <p class="list_ct">총<span class="num" id="totalCountOrg">0</span>건이 있습니다.</p>
	                     <form:select path="pageSize" class="list_num" id="pageSize" items="${pageSizeList}" itemValue="ctgryStr" itemLabel="ctgryName" multiple="false" onchange="fn_pageOnChange();"/>
	                </div>
	                
	                <div class="tbl_list">
	                   <table>
	                      <caption>인증대학현황 지역별 리스트</caption>
	                      <colgroup>
	                          <col style="width:7%;">
	                          <col />
	                          <col style="width:12%;">
	                          <col style="width:12%;">
	                          <col style="width:12%;">
	                      </colgroup>
	                      <thead>
	                         <tr>
	                             <th scope="col">번호</th>
	                             <th scope="col">제목</th>
	                             <th scope="col">등록자</th>
	                             <th scope="col">등록일</th>
	                             <th scope="col">조회수</th>
	                         </tr>
	                        </thead>
	                        <tbody id="tbResult">
	                        </tbody>
                        </table>
                  	</div>
                  	
                  	<div class="pagination_wrap" id="paginationholder"> 
				        <ul id="pagination" class="pagination">
				        </ul>
				    </div>
            	</div>
            	</form:form>
			</div>
		</div>
		<!-- //본문내용 -->