<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>图书管理</title>
    <%-- 静态包含 base标签、css样式、jQuery文件 --%>
    <%@ include file="/pages/common/head.jsp"%>
    <script type="text/javascript">
        $(function () {
            // 给删除的a标签绑定单击事件，用于删除的确认提示操作
            $("a.deleteClass").click(function () {
                // 在事件的function函数中，有一个this对象。这个this对象，是当前正在响应事件的dom对象。
                /**
                 * confirm是确认提示框函数
                 * 参数是它的提示内容
                 * 它有两个按钮，一个确认，一个是取消。
                 * 返回true表示点击了，确认，返回false表示点击取消。
                 */
                return confirm("你确定要删除【" + $(this).parent().parent().find("td:first").text() + "】?");
                // return false// 阻止元素的默认行为===不提交请求
            });
        });
    </script>

</head>
<body>
<div id="header">
    <img class="logo_img" alt="" src="static/img/logo.gif" >
    <span class="wel_word">图书管理系统</span>
    <%--静态包含manager模块的菜单--%>
    <%@include file="/pages/common/manager_menu.jsp"%>
</div>

<div id="main">
    <div id="book_cond">
        <form action="client/giftsServlet" menthod="get">
            <input type="hidden" name="action" value="pageByPrice">
            价格：<input id="min"type="text" name="min" value="${param.min}">元 -
            <input id="max"type="text" name="max" value="${param.max}">元
            <input type="submit" value="查询"/>
        </form>
    </div>
    <table>
        <tr>
            <td>名称</td>
            <td>价格</td>
            <td colspan="2">操作</td>
        </tr>

        <c:forEach items="${requestScope.page.items}" var="ook">
            <tr>
                <td>${ook.name}</td>
                <td>${ook.price}</td>
                <td><a href="manager/giftsServlet?action=getBook&id=${ook.id}&method=update&pageNo=${requestScope.page.pageNo}">修改</a></td>
                <td><a class="deleteClass" href="manager/giftsServlet?action=delete&id=${ook.id}&pageNo=${requestScope.page.pageNo}">删除</a></td>
            </tr>
        </c:forEach>

        <tr>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td><a href="pages/manager/book_edit.jsp?method=add&pageNo=${requestScope.page.pageTotal}">添加图书</a></td>
        </tr>
    </table>
<%--分页条的开始--%>
    <%@include file="/pages/common/page_nav.jsp"%>
<%--分页条的结束--%>
</div>

<%--静态包含页脚内容--%>
<%@ include file="/pages/common/footer.jsp"%>


</body>
</html>