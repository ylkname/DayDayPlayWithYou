<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html><!--个人礼物记录-->
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <base href="http://localhost:8080/daydayplay/">
<%--    <%@ include file="/pages/common/head.jsp"%>--%>
    <script src="public/js/jquery-3.4.1.min.js"></script>
    <link rel="stylesheet" href="public/css/gift.css">
<%--    <link type="text/css" rel="stylesheet" href="static/css/style.css" >--%>

</head>
<body>
<div id="padding">
    <div id="box">
        <h3>礼物记录</h3>
        <ul id="tabs">
            <li class="opt"><span>送出的礼物</span></li>
            <li><span>收到的礼物</span></li>
        </ul>
        <div class=".content">
            <div class="tab">
                <div class="tab_header">
                    <div><img src="public/image/zx/liwu.png" height="20" width="20" class="smallPic">礼物名字</div>
                    <div><img src="public/image/zx/yigoushuliang.png" height="20" width="20" class="smallPic">礼物数量</div>
                    <div><img src="public/image/zx/guanzhuderen2.png" height="20" width="20" class="smallPic">接收人</div>
                    <div><img src="public/image/zx/shijian.png" height="20" width="20" class="smallPic">时间</div>
                </div>
                <div class="tab_2_con">
                     <div class="tab_con2">
                         <c:forEach items="${requestScope.pageuser.items}" var="book">
                             <div>
                                 <span class="sp2">${book.gift_id}</span>
                             </div>
                             <div>
                                 <span class="sp2">${book.gift_num}</span>
                             </div>
                             <div>
                                 <span class="sp2">${book.playmen_id}</span>
                             </div>
                             <div>
                                 <span class="sp2">${book.date}</span>
                             </div>
                         </c:forEach>
                     </div>
                </div>
                <div style=" margin-left: 20%;overflow: hidden;">
                    <%--                    class="pages"--%>
                    <%--                    <li class="pageNum">1</li>--%>
                    <%--                    <li>2</li>--%>
                    <%--                    <li>3</li>--%>
                    <%@ include file="../pages/common/page_nav.jsp"%>
                </div>
            </div>
            <div class="tab tab2">
                <div class="tab_header">
                    <div><img src="public/image/zx/liwu.png" height="20" width="20" class="smallPic">礼物名字</div>
                    <div><img src="public/image/zx/yigoushuliang.png" height="20" width="20" class="smallPic">礼物数量</div>
                    <div><img src="public/image/zx/guanzhuderen2.png" height="20" width="20" class="smallPic">赠送人</div>
                    <div><img src="public/image/zx/shijian.png" height="20" width="20" class="smallPic">时间</div>
                </div>
                <div class="tab_2_con">
                    <div class="tab_con2">
                        <c:forEach items="${requestScope.pageuser.items}" var="book">
                            <div>
                                <span class="sp2">${book.gift_id}</span>
                            </div>
                            <div>
                                <span class="sp2">${book.gift_num}</span>
                            </div>
                            <div>
                                <span class="sp2">${book.user_id}</span>
                            </div>
                            <div>
                                <span class="sp2">${book.date}</span>
                            </div>
                        </c:forEach>
                    </div>
                </div>
                <div style=" margin-left: 20%;overflow: hidden;">
                    <%--                    class="pages"--%>
                    <%--                    <li class="pageNum">1</li>--%>
                    <%--                    <li>2</li>--%>
                    <%--                    <li>3</li>--%>
                    <%@ include file="../pages/common/page_nav.jsp"%>
                </div>
            </div>
        </div>
    </div>
</div>
</div>
</div>
</body>

<script src="public/js/gift.js"></script>


</html>