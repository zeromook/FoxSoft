<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<form name="paging" id="pagingForm" method="post" action="/PageLinkAll.do?link=/kcue/ast/eip/eis/search/EipSearchDetailsearch.do&p_menu_id=">
    <input type="hidden" name="keyword" value="">
</form>
<div class="paging">
    <span class="first"><a href="javascript:goPage(${param.firstPageNo})" title="처음으로 이동"><img src="/images/btn_first.png" alt="처음으로 이동" /></a></span>
    <span class="prev"><a href="javascript:goPage(${param.prevPageNo})" title="이전으로 이동"><img src="/images/btn_prev.png" alt="이전으로 이동" /></a></span>
    <c:forEach var="count" begin="${param.startPageNo}" end="${param.endPageNo}" step="1">
        <c:choose>
            <c:when test="${count eq param.pageNo}"><a href="javascript:goPage(${count})" class="on">${count}</a></c:when>
            <c:when test="${count > param.finalPageNo}"></c:when>
            <c:otherwise><a href="javascript:goPage(${count})">${count}</a></c:otherwise>
        </c:choose>
    </c:forEach>
    <span class="next"><a href="javascript:goPage(${param.nextPageNo})" title="다음으로 이동"><img src="/images/btn_next.png" alt="다음으로 이동" /></a></span>
    <span class="last"><a href="javascript:goPage(${param.finalPageNo})" title="마지막으로 이동"><img src="/images/btn_last.png" alt="마지막으로 이동" /></a></span>
</div>

<script>
    function goPage(page) {
        $("#pagingForm").find("input[name='page']").val(page);
        $("#pagingForm").submit();
    }
</script>