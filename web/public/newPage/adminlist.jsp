<%--
  Created by IntelliJ IDEA.
  User: 11241
  Date: 2020/9/18
  Time: 15:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <script src="${pageContext.request.contextPath}/public/js/jquery-3.2.1.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/public/css/gift.css">

</head>
<body>
<div id="padding">
    <div id="box">
        <h3>管理员列表</h3>
        <div class="tab">
            <div class="tab_header">
                <div><img src="${pageContext.request.contextPath}/public/image/zx/liwu.png" height="20" width="20" class="smallPic">编号</div>
                <div><img src="${pageContext.request.contextPath}/public/image/zx/guanzhuderen2.png" height="20" width="20" class="smallPic">账号</div>
                <div><img src="${pageContext.request.contextPath}/public/image/zx/shijian.png" height="20" width="20" class="smallPic">操作</div>
            </div>
            <div class="tab_1_con">
                <c:forEach items="${pageBean.list}" var="admin" varStatus="s">
                    <div>${s.count}</div>
                    <div>${admin.applicant}</div>
                    <div>
                        <a class="btn btn-default btn-sm"
                           href="${pageContext.request.contextPath}/adminBaseController?method='delAdmin'&id=${admin.id}">删除</a>
                    </div>
                </c:forEach>
            </div>
            <div>
                <nav aria-label="Page navigation">
                    <ul class="pagination">
                        <c:if test="${pageBean.currentPage==1}">
                        <li class="disabled">
                            </c:if>
                            <c:if test="${pageBean.currentPage!=1}">
                        <li>
                            </c:if>
                            <a href="${pageContext.request.contextPath}/adminBaseController?method='findByPage'&currentPage=${pageBean.currentPage-1}&rows=5&name=${condition.name[0]}$address=${condition.address[0]}&email=${condition.email[0]}" aria-label="Previous">
                                <span aria-hidden="true">&laquo;</span>
                            </a>
                        </li>
                        <c:forEach begin="1" end="${pageBean.totalPage}" var="i">
                            <c:if test="${pageBean.currentPage==i}">
                                <li class="active">
                                    <a href="${pageContext.request.contextPath}/adminBaseController?method='findByPage'&currentPage=${i}&rows=5&name=${condition.name[0]}$address=${condition.address[0]}&email=${condition.email[0]}">${i}</a>
                                </li>
                            </c:if>
                            <c:if test="${pageBean.currentPage!=i}">
                                <li>
                                    <a href="${pageContext.request.contextPath}/adminBaseController?method='findByPage'&currentPage=${i}&rows=5&name=${condition.name[0]}$address=${condition.address[0]}&email=${condition.email[0]}">${i}</a>
                                </li>
                            </c:if>
                        </c:forEach>
                        <li>
                            <a href="${pageContext.request.contextPath}/adminBaseController?method='findByPage'&currentPage=${pageBean.currentPage+1}&rows=5&name=${condition.name[0]}$address=${condition.address[0]}&email=${condition.email[0]}" aria-label="Next">
                                <span aria-hidden="true">&raquo;</span>
                            </a>
                        </li>
                        <span style="font-size: 25px;margin-left: 5px">
                        共${pageBean.totalCount}条，共${pageBean.totalPage}页
                    </span>
                    </ul>
                </nav>
            </div>
        </div>
    </div>
</div>
</div>
</div>
</div>
</body>

<script src="../js/gift.js"></script>

</html>
