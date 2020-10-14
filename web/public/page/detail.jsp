<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html><!--陪玩主页面-->
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/public/css/detail.css">
    <script src="${pageContext.request.contextPath}/public/js/jquery-3.2.1.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/public/util/bootstrap-3.3.7-dist/css/bootstrap.css">
    <script src="${pageContext.request.contextPath}/public/util/bootstrap-3.3.7-dist/js/bootstrap.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/public/css/head.css">
    <style type="text/css">
        #suggest {
            position: absolute;
            background-color: gainsboro;
            text-align: left;
            border: 1px solid #000000;
        }
        .MessagecontentBigBox{
            width:745px;
            margin-top:0px;
            background-color: white;
            padding-bottom: 15px;
        }
        .messageinfodiv{
            width: 100%;
            margin:0px auto 20px auto;
        }
        .publishmessage{
            margin: 0px auto 10px auto;
            padding:5px;
        }
        .publishmessagebutton{
            margin-top: 10px;
        }
        .thismessageinfodiv{
            padding: 5px;
            width: 96%;
            border-bottom: 1px solid #CCC;
            margin: 0px auto 5px auto;
        }
        img.messageuserimg{
            width: 50px;
            height: 50px;
            float: left;
            margin-left: 5px;
            border-radius: 5px;
        }
        font.messageusername{
            font-size: 16px;
            margin-left: 5px;
        }
        p.messageusercontent {
            padding-bottom: 5px;
            padding-left: 65px;
            font-size: 18px;
            letter-spacing: 0.3em;
            margin-top: 20px;
            overflow-wrap: break-word;
        }
        p.messageusertime{
            clear: both;
            display: inline;
            padding-left: 60px;
        }
        font.messageuserreply{
            margin-left: 20px;
            color: blue;
            cursor: pointer;
        }
        .messagereplydiv{
            width: 90%;
            border-top: 1px solid #CCC;
            margin: 5px auto 0px auto;
            padding:5px;
        }
        img.messagereplyimg{
            width: 40px;
            height: 40px;
        }
        .messagereplyname{
            color: blue;
        }
        .messagereplytime{
            padding-left: 46px;
        }
        .publishmessagebutton{
            margin-top: 10px;
        }
        .publishmessagebutton input{
            border:0px;
            background-color: #7B8C9E;
            color: white;
            padding:5px;
        }
        textarea#replycontent {
            height: 80px;
            width: 450px;
            max-height: 160px;
            max-width: 100%;
        }
        textarea#messagecontent {
            height: 126px;
            width: 741px;
            max-height: 160px;
            max-width: 95%;
        }

        /*滚动条*/
        .nui-scroll {
            height: 1000px;
            overflow: auto;
        }

        .nui-scroll::-webkit-scrollbar {
            width: 8px;
            height: 8px;
        }
        /*正常情况下滑块的样式*/

        .nui-scroll::-webkit-scrollbar-thumb {
            background-color: rgba(0, 0, 0, .05);
            border-radius: 10px;
            -webkit-box-shadow: inset 1px 1px 0 rgba(0, 0, 0, .1);
        }
        /*鼠标悬浮在该类指向的控件上时滑块的样式*/

        .nui-scroll:hover::-webkit-scrollbar-thumb {
            background-color: rgba(0, 0, 0, .2);
            border-radius: 10px;
            -webkit-box-shadow: inset 1px 1px 0 rgba(0, 0, 0, .1);
        }
        /*鼠标悬浮在滑块上时滑块的样式*/

        .nui-scroll::-webkit-scrollbar-thumb:hover {
            background-color: rgba(0, 0, 0, .4);
            -webkit-box-shadow: inset 1px 1px 0 rgba(0, 0, 0, .1);
        }
        /*正常时候的主干部分*/

        .nui-scroll::-webkit-scrollbar-track {
            border-radius: 10px;
            -webkit-box-shadow: inset 0 0 6px rgba(0, 0, 0, 0);
            background-color: white;
        }
        /*鼠标悬浮在滚动条上的主干部分*/

        .nui-scroll::-webkit-scrollbar-track:hover {
            -webkit-box-shadow: inset 0 0 6px rgba(0, 0, 0, .4);
            background-color: rgba(0, 0, 0, .01);
        }
    </style>
    <script language="javascript">
        $(function () {
                $("#searchTXT").keyup(function () {
                    var html='';
                    $.getJSON("http://localhost:8080/DayDayPlay/search","action=findRoom&key="+$("#searchTXT").val(),
                        function (data) {
                            if(data.length==0){
                                html+="<span>"+"查找不到该房间"+"</span>";
                            }
                            for(var i=0;i<data.length;i++){
                                var url="detail.html?key="+data[i].Room_id;
                                html+="<a href='"+url+"'>"+data[i].Room_id+"</a><br/>";
                            }
                            $("#suggest").html(html);
                        }
                    )
                });
            function getQueryString(name) {
                var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
                var r = window.location.search.substr(1).match(reg);
                if (r != null) return unescape(r[2]); return null;
            }
            var key=getQueryString("key");
            $.getJSON("http://localhost:8080/DayDayPlay/search","action=findPart&key="+key,function(data) {
                $("#six").html(data.name);
                var two='';
                two+=data.price;
                $("#two").html(two);
            })
        })
    </script>
</head>
<body>
<div id="box"></div>
<div id="box1">
    <div class="index-head">
        <!--logo部分-->
        <div class="index-logo">
            <a href="index.jsp">
                <img src="${pageContext.request.contextPath}/public/image/index-img/yuewanlogo.png" alt="">
            </a>
        </div>
        <!--导航内容部分-->
        <div class="header-navigation">
            <a href="index.jsp" class="navigation-1 ar">首页</a>
            <a href="playwithbeauty.html" class="navigation-1 ar">约陪玩</a>
            <a href="recharge.jsp" class="navigation-1 ar">充值</a>
            <div class="header-navigation-ip">
                <input type="text" placeholder="房间号" id="searchTXT">
                <img src="${pageContext.request.contextPath}/public/image/index-img/search.png" class="search" >
                <div id="suggest" style="width: 180px"></div>
            </div>
        </div>
        <div class="header-navigation">
            <a class="ar" href="login.jsp">
                <span class="glyphicon glyphicon-user" aria-hidden="true"></span>
                登录&nbsp;&nbsp;|&nbsp;&nbsp;注册</a>
        </div>
        <div class="header-navigation">
            <a href="Master_Edition.jsp" class="ar">
                <img src="${pageContext.request.contextPath}/public/image/index-img/message.png" alt="">
                信息中心
            </a>
        </div>
    </div>
    <div id="middle">
        <div id="middle-content">
            <div id="middle-top">
                <a href="">首页</a>
                <img src="${pageContext.request.contextPath}/public/image/picture/jt-01.png" alt="">
                <a href="" class="middle-top-two">找陪玩</a>
                <img src="../image/picture/jt-01.png" alt="">
                <span class="middle-top-span"></span>
            </div>
            <div id="middle-centre">
                <div class="pic">
                    <p class="pic-p">
                        <img src="" alt="ID" id="one">
                        <span></span>
                    </p>
                    <span class="online">在线</span>
                </div>
                <div class="box-one">
                    <div class="t1">
                        <span class="t1-span"></span>
                        <i class="i1"></i>
                        <i class="rz">
                            <span>平台认证</span>
                        </i>
                        <i class="star">
                            <span>明星陪玩</span>
                        </i>
                        <i></i>
                    </div>
                    <div class="t2">
                        <div class="t2-div1"><span id="six"></span></div>
                        <div class="rd">
                            <i class="ml"></i>
                            70901
                        </div>
                        <div class="wuri">
                            <em class="wuri-em">
                                五日热度第
                                <i class="rank">9</i>
                                名
                            </em>
                        </div>
                    </div>
                    <div class="t3"></div>
                </div>
                <div class="box-three">
                    <div class="gz">
                        <p class="gz-p1">
                            <img src="${pageContext.request.contextPath}/public/image/picture/guanzhu.png" alt="">
                            <span>关注</span>
                        </p>
                        <p class="gz-p2">
                            <img src="${pageContext.request.contextPath}/public/image/picture/guanzhu.png" alt="">
                            <span>已关注</span>
                        </p>
                        <p class="guanzhu">29</p>
                    </div>
                </div>
            </div>
            <div id="middle-bottom">
                <div class="detail-left">
                    <div class="left-top">
                        <div class="big-pic">
                            <img src="${pageContext.request.contextPath}/public/image/picture/big-pic.jpeg" alt="">
                        </div>
                        <div class="small-pic">
                            <div>
                                <ul class="small-ul">
                                    <li class="small-ul-li1">
                                        <img src="" alt="">
                                    </li>
                                    <li class="small-ul-li2">
                                        <img src="" alt="">
                                    </li>
                                    <li class="small-ul-li3">
                                        <img src="" alt="">
                                    </li>
                                    <li class="small-ul-li4">
                                        <img src=" "alt="">
                                    </li>
                                    <li class="small-ul-li5">
                                        <img src="" alt="">
                                    </li>
                                </ul>
                            </div>
                        </div>
                    </div>
                    <div class="left-content">
                        <div class="content-one">
                            <i></i>
                            <span>礼物</span>
                        </div>
                        <div class="content-two">
                            <div class="lw">
                                <ul class="lw-ul">
                                    <c:forEach items="${requestScope.gifts}" var="gifts">
                                        <li>
                                            <img src="${gifts.photo}" alt="" class="lw-ul-img1">
                                            <div class="lw-xq">
                                                <img src="public/image/picture/lw-xq1.png" alt="" class="xq-img">
                                                <div class="xq-div1">
                                                    <span>昵称</span>
                                                </div>
                                                <div class="xq-div2">
                                                    <img src="${gifts.photo}" alt="" class="xq-one">
                                                    <div class="xq-div2-one">
                                                        <span class="lw-name">${gifts.name}</span>
                                                        <span class="lw-span">
                                                        <img src="public/image/picture/zs1.png" alt="">
                                                        <span>${gifts.price}</span>
                                                    </span>
                                                        <form action="userServlet" method="get">
                                                            <div class="lw-gs">
                                                                <input name="gift_num" type="text" value="1" >
                                                                <input type="hidden" name="user_id" type="text" value="4" >
                                                                <input type="hidden" name="gift_id" type="text" value="${gifts.id}" >
                                                                <input type="hidden" name="playmen_id" type="text" value="2" >
                                                                <input type="hidden" name="action" type="text" value="add" >
                                                                <input class="lw-zs" type="submit"value="赠送"/>
                                                            </div>
                                                        </form>
                                                    </div>
                                                </div>
                                                <div class="xq-div3">今日头条活动礼物</div>
                                            </div>
                                        </li>
                                    </c:forEach>
                                </ul>
                            </div>
                        </div>
                    </div>
                    <div class="left-bottom">
                        <div class="left-bottom-sh"></div>
                        <ul class="list">
                            <% int j=1; %>
                            <c:forEach items="${requestScope.map}" var="ook">
                                <li>
                                    <i class="num">
                                        <i class="num-one">
                                            <i class="num-two"><%=j++%></i>
                                        </i>
                                    </i>
                                    <div class="tx">
                                        <img src="publuc/image/picture/one.jpg" alt="">
                                        <p></p>
                                    </div>
                                    <div class="tx2">
                                        <span>${ook.value}</span>
                                        <div class="tx2-div">
                                            <img src="public/image/picture/dj2.png" alt="">
                                        </div>
                                    </div>
                                    <div class="tx3">
                                        <div class="tx3-div">
                                            <div class="tx3-one">
                                                <span class="one-s1">贡献：</span>
                                                <span class="one-s2">${ook.key}</span>
                                            </div>
                                        </div>
                                    </div>
                                </li>
                            </c:forEach>
                        </ul>
                    </div>
                </div>
                </div>
                <div class="detail-right">
                    <div class="right-top">
                        <span class="zlb">赠礼榜</span>
                        <ul class="zlb-ul">
                            <c:forEach items="${requestScope.map}" var="ook">
                                <li>
                                    <div class="zlb-ul-div1">
                                        <i></i>
                                        <img src="public/image/picture/one.jpg" alt="" class="img1">
                                        <img src="public/image/picture/ch.png" alt="" class="img2">
                                    </div>
                                    <div class="zlb-ul-div2">${ook.value}</div>
                                    <div class="zlb-ul-div3">
                                        <img src="public/image/picture/hx.png" alt="">
                                        <span>${ook.key}</span>
                                    </div>
                                </li>
                            </c:forEach>
                        </ul>
                        <div class="zlb-div">
                            <div class="zlb-div-box">
                                <div class="zlb-div-div1">
                                    <div class="zlb-div-one">
                                        <img src="${pageContext.request.contextPath}/public/image/picture/bx1.png" alt="">
                                        <span>1</span>
                                    </div>
                                    <div class="zlb-div-one">
                                        <img src="${pageContext.request.contextPath}/public/image/picture/lw-2.png" alt="">
                                        <span>1</span>
                                    </div>
                                    <div class="zlb-div-one">
                                        <img src="${pageContext.request.contextPath}/public/image/picture/lw-3.png" alt="">
                                        <span>1</span>
                                    </div>
                                    <div class="zlb-div-one">
                                        <img src="${pageContext.request.contextPath}/public/image/picture/lw-4.png" alt="">
                                        <span>1</span>
                                    </div>
                                    <div class="zlb-div-one">
                                        <img src="${pageContext.request.contextPath}/public/image/picture/lw-5.png" alt="">
                                        <span>1</span>
                                    </div>
                                    <div class="zlb-div-one">
                                        <img src="${pageContext.request.contextPath}/public/image/picture/lw-6.png" alt="">
                                        <span>1</span>
                                    </div>
                                    <div class="zlb-div-one">
                                        <img src="${pageContext.request.contextPath}/public/image/picture/lw-7.png" alt="">
                                        <span>1</span>
                                    </div>
                                    <div class="zlb-div-one">
                                        <img src="${pageContext.request.contextPath}/public/image/picture/lw-8.png" alt="">
                                        <span>1</span>
                                    </div>
                                    <div class="zlb-div-one">
                                        <img src="${pageContext.request.contextPath}/public/image/picture/lw-9.png" alt="">
                                        <span>1</span>
                                    </div>
                                    <div class="zlb-div-one">
                                        <img src="${pageContext.request.contextPath}/public/image/picture/lw-10.png" alt="">
                                        <span>1</span>
                                    </div>
                                </div>
                            </div>
                            <div class="zlb-zuo"></div>
                            <div class="zlb-you"></div>
                        </div>
                    </div>
                    <div class="right-content">
                        <div class="yx-lx yx-game-name">
                            <div class="yxlm">
                                <div class="yxlm1">
                                    <img src="${pageContext.request.contextPath}/public/image/picture/yxlm.jpg" alt="" class="game-img">
                                    <div class="game-time">
                                        <div class="d1">
                                            <span class="d1-s1">
                                                ￥
                                                <span class="d1-s2" id="two"></span>
                                            </span>
                                            /小时
                                        </div>
                                        <div class="d2">
                                            <p class="d2-p" id="three"></p>
                                        </div>
                                        <div class="d3">
                                            <img src="${pageContext.request.contextPath}/public/image/picture/jds.png" alt="">
                                            <span class="d3-span" id="four"></span>
                                        </div>
                                        <div class="d4">
                                            <div class="yuyin">
                                                <span class="yuyin-s1"></span>
                                                <span class="yuyin-s2">6s</span>
                                                <span class="yuyin-s3"></span>
                                                <audio src=""></audio>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="zwjs">
                                    <img src="${pageContext.request.contextPath}/public/image/picture/zwjs.png" alt="">
                                    <div class="zwjs-div" id="five"></div>
                                </div>
                            </div>
                            <div class="btn-xd">
                                <a href="${pageContext.request.contextPath}/selectChat?tid=2"><span class="lyl">聊一聊</span></a>
                                <div class="cs">
                                    <input type="text" value="1" class="cs-inp">
                                    <p class="jia">+</p>
                                    <p class="jian">-</p>
                                </div>
                                <a href="${pageContext.request.contextPath}/public/newPage/xmjxorder.html"><div class="ljxd">立即下单</div></a>
                            </div>
                        </div>

                        <div class="right-bottom">
                            <div class="right-bottom-above">
                                <span id="above-left" class="above-s1 a">用户评价</span>
                                <span id="above-right" class="above-s1">赠礼墙</span>
                            </div>
                            <div class="right-bottom-below right-bottom-div">
                                <div class="" id="comment">
                                    <div class="nui-scroll">
                                        <div><!-- 留言展示内容 -->
                                            <div class="MessagecontentBigBox"><!-- 内容外层div -->
                                                <div class="messageinfodiv">
                                                    <div class="publishmessage">
                                                        <form action="${pageContext.request.contextPath}/addmessageby.action" method="post" onsubmit="return checkdata()">
                                                            <div class="publishmessagein">
                                                                <textarea maxlength="60" id="messagecontent" name="messagecontent"></textarea>
                                                            </div>
                                                            <div class="publishmessagebutton">
                                                                <input type="submit" value="发送">&nbsp;&nbsp;
                                                                <input type="reset" value="取消">
                                                            </div>
                                                        </form>
                                                    </div>
                                                    <ul>
                                                        <c:forEach items="${requestScope.messageinfo }" var="msg">
                                                            <li class="thismessageinfodiv">
                                                                <img src="<c:out value="${msg.getWimg() }"/>" class="messageuserimg"/>
                                                                <font class="messageusername"><c:out value="${msg.getWname() }"/></font><br/>
                                                                <p class="messageusercontent"><c:out value="${msg.getMsgtext()}" escapeXml="true"
                                                                                                     default="加载失败"/></p>
                                                                <p class="messageusertime"><c:out value="${msg.getWritetime() }"/></p>
                                                                <font class="messageuserreply" id="<c:out value="${msg.getId()}"/>">回复</font>
                                                                <c:forEach items="${msg.getReptext() }" var="rel">
                                                                    <div class="messagereplydiv">
                                                                        <img class="messagereplyimg" src="<c:out value="${rel.getImg()}"/>"/>
                                                                        <font class="messagereplyname"><c:out value="${rel.getName()}"/></font>
                                                                        <font class="messagereplycontent"><c:out value="${rel.getContent()}"/></font>
                                                                        <p class="messagereplytime"><c:out value="${rel.getTime()}"/></p>
                                                                    </div>
                                                                </c:forEach>
                                                                <div class="messageuserreplydiv" id="replybigdiv<c:out value="${msg.getId() }"/>"
                                                                style="display: none">
                                                                <form action="${pageContext.request.contextPath}/messageuserreply.action" method="post" id="replymessageform">
                                                                    <input type="hidden" name="thismessageid" value="<c:out value="${msg.getId() }"/>"/>
                                                                    <input type="hidden" name="gid" value="<c:out value="${requestScope.gid }"/>"/>
                                                                    <textarea required id="replycontent" name="replycontent"></textarea><br/>
                                                                    <input type="submit" value="确定">&nbsp;&nbsp;
                                                                    <input type="reset" value="取消" class="cancelinput">
                                                                </form>
                                                                </div>
                                                            </li>
                                                        </c:forEach>
                                                    </ul>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <% int i=1; %>
                        <div id="right-bottom-below" class="right-bottom-below ">
                            <div id="main">
                                <table>
                                    <tr>
                                        <td><span >排名</span></td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                        <td><span >id</span></td>
                                        <td><span >打榜值</span></td>
                                    </tr>
                                    <c:forEach items="${requestScope.map}" var="ook">
                                        <tr>
                                            <td><span class="page0"><%=i++%></span></td>
                                            <td><span class="page0">${ook.value}</span></td>
                                            <td><span class="page0">${ook.key}</span></td>
                                        </tr>
                                    </c:forEach>
                                    <%--                                <button class="page0"></button>--%>
                                </table>
                            </div>
                        </div>
                            <div class="page1">
                                <!--<button class="page0"></button>-->
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="index-bottom">
        <div class="index-bottom-box">
            <a href="javascript:;">
                <img class="fl" src="${pageContext.request.contextPath}/public/image/index-img/consume1.jpg" alt="">
            </a>
            <a href="javascript:;">
                <img class="fl" src="${pageContext.request.contextPath}/public/image/index-img/consume2.jpg" alt="">
            </a>
            <a href="javascript:;">
                <img class="fl" src="${pageContext.request.contextPath}/public/image/index-img/consume3.jpg" alt="">
            </a>
            <a href="javascript:;">
                <img class="fl" src="${pageContext.request.contextPath}/public/image/index-img/consume4.jpg" alt="">
            </a>
            <div class="clearfix"></div>
            <div class="bottom-box-information">
                <div class="bottom-box-tel fl">
                    <i class="bottom-box-telimg"></i>
                    客服电话
                    <span class="bottom-box-tn">010-68608228</span>
                    <span class="bottom-box-t">咨询时间：7X24小时</span>
                </div>
                <div class="bottom-box-qq fl">
                    <i class="bottom-box-qqimg"></i>
                    客服QQ：
                    <span class="bottom-box-qqnum">800184580</span>
                </div>
                <div class="bottom-box-detailed fl">
                    <span class="bottom-box-detailedtime">咨询时间：7X24小时</span>
                </div>
                <div class="bottom-box-but fl">
                    <a class="fl help" href="javascript:;">帮助中心</a>
                    <a class="fl help" href="javascript:;">服务保障</a>
                    <a class="fl help" href="javascript:;">关于我们</a>
                </div>
                <div class="clearfix"></div>
            </div>
            <div class="bottom-box-copy">
                京ICP备18042855号 Copyright 2014-2020 TaoLe Corporation,All Rights Reserved
                <br>
                北京陶乐科技有限公司，专业陪练为玩家提供各种热门游戏陪练陪玩服务，年轻人喜爱的游戏陪玩平台
                <br>
                地址：北京市石景山区鲁谷路74号中国瑞达大厦6层M601室
            </div>
        </div>
    </div>
</div>
<script>
    $(document).ready(function () {
        var ti;
        $("#userinfo").mouseover(function () {
            $("#usernameshow").fadeIn(200);
        });
        $("#usernameshow").mouseover(function () {
            clearTimeout(ti);
            $("#usernameshow").show();
        });
        $("#usernameshow").mouseout(function () {
            $("#usernameshow").hide();
        });
        $("#userinfo").mouseout(function () {
            $("#usernameshow").stop(false, true);
            ti = setTimeout(function () {
                $("#usernameshow").hide();
            }, 100);
        });
        $(".messageuserreply").click(function () {
            var a = this.id;
            $("[id$='div" + a + "']").toggle();
        });
        $(".cancelinput").click(function () {
            $(this).parents(".messageuserreplydiv").hide();
        });

    });

    function checkdata() {
        var a = document.getElementById("messagecontent").value;
        if (a == null || a == "") {
            alert("输入不能为空！发布失败。");
            return false;
        }
    }
</script>

</body>
<script src="../js/detail.js">

</script>
</html>