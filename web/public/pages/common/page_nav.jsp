<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020/9/13
  Time: 18:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--分页条的开始--%>
<div id="page_nav">
    <c:if test="${requestScope.pageuser.pageNo>1}">
        <a href="userpjfServlet?action=page&pageNo=1">首页</a>
        <a href="userpjfServlet?action=page&pageNo=${requestScope.pageuser.pageNo-1}">上一页</a>
    </c:if>
    <%--页码输出的开始--%>
    <c:choose>
        <%--情况1：如果总页码小于等于5的情况，页码的范围是：1-总页码--%>
        <c:when test="${ requestScope.pageuser.pageTotal <= 5 }">
            <c:set var="begin" value="1"/>
            <c:set var="end" value="${requestScope.pageuser.pageTotal}"/>
        </c:when>
        <%--情况2：总页码大于5的情况--%>
        <c:when test="${requestScope.pageuser.pageTotal > 5}">
            <c:choose>
                <%--小情况1：当前页码为前面3个：1，2，3的情况，页码范围是：1-5.--%>
                <c:when test="${requestScope.pageuser.pageNo <= 3}">
                    <c:set var="begin" value="1"/>
                    <c:set var="end" value="5"/>
                </c:when>
                <%--小情况2：当前页码为最后3个，8，9，10，页码范围是：总页码减4 - 总页码--%>
                <c:when test="${requestScope.pageuser.pageNo > requestScope.pageuser.pageTotal-3}">
                    <c:set var="begin" value="${requestScope.pageuser.pageTotal-4}"/>
                    <c:set var="end" value="${requestScope.pageuser.pageTotal}"/>
                </c:when>
                <%--小情况3：4，5，6，7，页码范围是：当前页码减2 - 当前页码加2--%>
                <c:otherwise>
                    <c:set var="begin" value="${requestScope.pageuser.pageNo-2}"/>
                    <c:set var="end" value="${requestScope.pageuser.pageNo+2}"/>
                </c:otherwise>
            </c:choose>
        </c:when>
    </c:choose>

    <c:forEach begin="${begin}" end="${end}" var="i">
        <c:if test="${i == requestScope.pageuser.pageNo}">
            【${i}】
        </c:if>
        <c:if test="${i != requestScope.pageuser.pageNo}">
            <a href="userpjfServlet?action=page&pageNo=${i}">${i}</a>
        </c:if>
    </c:forEach>
    <c:if test="${requestScope.pageuser.pageNo<requestScope.pageuser.pageTotal}">
        <a href="userpjfServlet?action=page&pageNo=${requestScope.pageuser.pageNo+1}">下一页</a>
        <a href="userpjfServlet?action=page&pageNo=${requestScope.pageuser.pageTotal}">末页</a>
    </c:if>
    共${requestScope.pageuser.pageTotal}页， ${requestScope.pageuser.pageTotalCount}
    条记录 到第<input value="${param.pageNo}" name="pn" id="pn_input"/>页
    <input id="searchPageBtn" type="button" value="确定">
    <script type="text/javascript">
        $(function () {
            $("#searchPageBtn").click(function () {
                var pageNo=$("#pn_input").val();
                if(pageNo>${requestScope.pageuser.pageTotal}||pageNo<1){
                    pageNo=${requestScope.pageuser.pageNo}
                }
                location.href="${pageScope.basePath}userpjfServlet?action=page&pageNo="+pageNo;
            });
        });
    </script>
</div>
<%--分页条的结束--%>
