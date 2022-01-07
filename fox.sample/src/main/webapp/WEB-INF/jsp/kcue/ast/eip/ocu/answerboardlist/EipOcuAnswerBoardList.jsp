<%@ page import="kcue.common.util.Keys"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
</script>
<script type="text/javascript" src="/js/jquery.twbsPagination.js"></script>
<spring:message code="common.nodata.msg" var="nodataMsg"></spring:message>
<script type="text/javaScript" >
    
    $(function(){
    	alert("시작");
    	getAnswerBoardList();
    })//end of ready
    
    function getAnswerBoardList(){
        var process_sttus = $("#process_sttus").val();
        alert(process_sttus);
        var searchFindKeyword = $("#searchFindKeyword").val();
        alert(searchFindKeyword);
        var inputtext = $("#searchKeyword").val();
        alert(inputtext);
    	$.ajax({
    		type:'GET',
    		url : '/kcue/ast/eip/ocu/answerboardlist/updateAnswerBoardList.do',
    		data : {process_sttus : process_sttus,searchFindKeyword : searchFindKeyword, inputtext : inputtext},
    		dataType : 'json',
    		success : function(data){
    			UpdateAnswerBoardList(data.UpdateAnswerBoardList);
    		},
    		error : function(err){
			    alert('error발생-----------');
    		}
    	})//end of ajax
    }//end of getAnswerBoardList
    
    
    function UpdateAnswerBoardList(boardlist){
    	var tbResult = $("#tbResult");
    	tbResult.html("");//일단 비우고
    	$("#totalCountOrg").text(boardlist.length);//글 개수
    	if(boardlist[0].bbs_sn == null){
    		var tr = $("<tr />");
    		var nonedata = $("<td colspan='8' />").html("<h3>게시물이 존재하지 않습니다.</h3>");
    		tr.append(nonedata);
    		tbResult.append(tr);
    	}
    	else{
    		for(var row of boardlist){											
                var tr = $("<tr/>");
                var bbs_sn = $("<td />").text(row.bbs_sn);	
                tr.append(bbs_sn);
                var process_sttus = $("<td />").text(row.process_sttus);
                tr.append(process_sttus);
                var sj = $("<td style='width: 25%;'/>").text(row.sj);
                tr.append(sj);
                var ins_usr_id = $("<td  />").text(row.ins_usr_id);
                tr.append(ins_usr_id);
                var ins_dt = $("<td  style='width: 25%;'/>").html(new Date(row.ins_dt).yyyymmdd());
                tr.append(ins_dt);
                var ans_usr_id = $("<td  />").text(row.ans_usr_id);
                tr.append(ans_usr_id);
                var ans_dt = $("<td  style='width: 25%;'/>").html(new Date(row.ans_dt).yyyymmdd());
                tr.append(ans_dt);
                var inqire_co = $("<td  />").text(row.inqire_co);
                tr.append(inqire_co);
                tbResult.append(tr);
                } // end for문
    	}//end of else
    }//end of UpdateAnswerBoardList()
    
    
    // ################################################ 
	// 밀리세컨드를 yyyy-mm-dd로 포맷
	Date.prototype.yyyymmdd = function() {        
        var yyyy = this.getFullYear().toString();                                   
        var mm = (this.getMonth()+1).toString(); // getMonth() is zero-based        
        var dd  = this.getDate().toString();            
        return yyyy + '-' + (mm[1]?mm:"0"+mm[0]) + '-' + (dd[1]?dd:"0"+dd[0]);
	}; // end yyyymmdd function
    
</script>
















<h2 class="skip">본문영역</h2>
<div class="content_wrap">



	<div class="content_wrap_inner">
		<form id="frm" name="frm" method="post">
			<div class="content_top">
				<h1>◼️게시판</h1>
				<div class="search_box">
					<fieldset>
						<legend>목록 검색</legend>
						<div class="list_search_box" style="display: flex;">
							<div id="search_box_title" style="margin-right: 10px;width: 140px;height: 42px;">
								<span style="font-size:20px;line-height:42px;">▪처리상태</span>
							</div>
							<select id="process_sttus" name="inquiryConditions" class="des">
								<option value="allConditions" selected>전체</option>
								<c:forEach items="${inquiryConditions}" var="condition">
									<option value="${condition.cd_nm}">${condition.cd_nm}</option><!-- CMN02조건들 ex) 신청중,처리중 등등 -->
								</c:forEach>
							</select>
							<select id="searchFindKeyword" class="des">
								<option value="sj">제목</option>
								<option value="cn">내용</option>
								<option value="ins_usr_id">작성자</option>
							</select>
							<input id="searchKeyword" type="text" title="검색어를 입력해주세요" />
							<div id="searchBtn" style="margin-left: 205px;">
								<button type="button" onclick="getAnswerBoardList()">검색</button>
							</div>
						</div>
					</fieldset>
				</div>
			</div>
		</form>


        <div class="content">
	                <div class="list_top">
	                    <p class="list_ct">총<span class="num" id="totalCountOrg">${boardCount}</span>건의 글이 있습니다.</p>
	                </div>
	                
	                <div class="tbl_list">
	                   <table>
	                         <tr>
	                             <th>번호</th>
	                             <th>처리상태</th>
	                             <th style="width: 25%;">제목</th>
	                             <th>작성자</th>
	                             <th style="width: 15%;">작성일</th>
	                             <th>답변자</th>
	                             <th style="width: 15%;">답변일</th>
	                             <th>조회</th>
	                         </tr>
	                        <tbody id="tbResult">
	                        </tbody>
                        </table>
                  	</div>
                  	<div class="pagination_wrap" id="paginationholder"> 
				        <ul id="pagination" class="pagination">
				        </ul>
				    </div>

            	</div>




	</div><!-- end of content_wrap_inner -->









</div>
<!-- end of content_wrap -->
