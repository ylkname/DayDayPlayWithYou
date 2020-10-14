<%--
  Created by IntelliJ IDEA.
  User: 11241
  Date: 2020/9/24
  Time: 19:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div id="padding">
    <div id="box">
        <h3>礼物记录</h3>
        <ul id="tabs">
            <li class="opt"><span>普通用户</span></li>
            <li><span>天天陪玩</span></li>
        </ul>
        <div class=".content">
            <div class="tab">
                <div class="tab_header">
                    <div><img src="../image/zx/liwu.png" height="20" width="20" class="smallPic">编号</div>
                    <div><img src="../image/zx/yigoushuliang.png" height="20" width="20" class="smallPic">昵称</div>
                    <div><img src="../image/zx/guanzhuderen2.png" height="20" width="20" class="smallPic">用户名</div>
                    <div><img src="../image/zx/guanzhuderen2.png" height="20" width="20" class="smallPic">QQ</div>
                    <div><img src="../image/zx/guanzhuderen2.png" height="20" width="20" class="smallPic">电话</div>
                    <div><img src="../image/zx/shijian.png" height="20" width="20" class="smallPic">账号状态</div>
                    <div><img src="../image/zx/shijian.png" height="20" width="20" class="smallPic">操作</div>
                </div>
                <div class="tab_1_con">
                    <!--  <div class="tab_con1">
                          <div>水晶</div>
                          <div>5</div>
                          <div>天天约玩</div>
                          <div>2019-5-18</div>
                      </div>-->
                    <c:forEach items="${pageBean.list}" var="applicant" varStatus="s">
                        <div>${s.count}</div>
                        <div>${applicant.applicant}</div>
                        <div>${applicant.role}</div>
                        <div>
                            <a class="btn btn-default btn-sm"
                               href="${pageContext.request.contextPath}/adminBaseController?method='updateRole'&id=${applicant.id}">同意</a>&nbsp
                                <%--<a class="btn btn-default btn-sm" href="${pageContext.request.contextPath}/delUserServlet?id=${user.id}">删除</a>--%>
                            <a class="btn btn-default btn-sm"
                               href="${pageContext.request.contextPath}/adminBaseController?method='delApply'&id=${applicant.id}">拒绝</a>
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
</body>
</html>
