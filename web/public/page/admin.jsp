<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="ch">
<head>
    <meta charset="UTF-8">
    <title>管理员界面</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/public/util/bootstrap-3.3.7-dist/css/bootstrap.css">
    <script src="${pageContext.request.contextPath}/public/js/jquery-3.2.1.js"></script>
    <script src="${pageContext.request.contextPath}/public/util/bootstrap-3.3.7-dist/js/bootstrap.js"></script>
    <style>
        * {
            padding: 0;
            margin: 0;
            list-style: none;
            text-decoration: none;
        }

        body {
            background: #f3f3f3;
            height: 100%;
        }

        /** {*/
        /*margin: 0;*/
        /*padding: 0;*/
        /*}*/
        /*头*/
        .ar:hover {
            color: #FA6543;

        }

        a {
            text-decoration: none;
            color: black;
        }

        a:hover {
            text-decoration: none;
        }

        .index-head {
            width: 1366px;
            height: 80px;
            background: white;
        }

        .index-logo {
            display: inline-block;
            margin-top: 16px;
            margin-left: 120px;
        }

        .header-navigation {
            display: inline-block;
            /*
                        border: 1px solid #000;*/
            margin-left: 120px;
        }

        .navigation-1 {
            margin-right: 20px;

        }

        .header-navigation-ip {
            display: inline-block;
            position: relative;
        }

        .header-navigation-ip input {
            padding: 0 10px;
            border-radius: 25px;
            background-color: #f0f0f0;
            display: inline-block;
            line-height: 34px;
            height: 34px;
            font-size: 13px;
            border: 1px solid #f0f0f0;
            outline: none;
        }

        .header-navigation-ip img {
            position: absolute;
            top: 10px;
            right: 10px;
            cursor: pointer;
        }

        .jiBOX {
            width: 120px;
            height: 540px;
            overflow: hidden;
            position: absolute;
            left: 0;
            /*border:solid 1px #fbca99 ;*/
            margin-left: 60px;
            border-radius: 8px;
            margin-top: 50px;
            /*margin-bottom: 30px;*/
        }

        /*侧旁box*/
        #master-left {
            width: 120px;
            height: 600px;
            padding-top: 12px;
            background: white;
        }

        /*管理box*/
        .master-list-manage {
            /*margin-top: 15px;*/
            width: 120px;
            height: 290px;
        }

        /*设置box*/
        .master-list-set {
            margin-top: 15px;
            height: 500px;
            width: 120px;
        }

        /*设置与管理div*/
        .master-manage, .master-set {
            color: #999999;
            font-size: 16px;
            height: 55px;
            line-height: 55px;
            padding-bottom: 15px;
        }

        /*设置元管理的图标*/
        .master-manage-icon, .master-set-icon {
            width: 16px;
            height: 16px;
            margin-top: 4px;
            margin-left: 15px;
            margin-right: 12px;
            transition: all .3s ease;
        }

        /*菜单列表*/
        .list-manage a, .list-set a {
            color: #999999;
            height: 47px;
            line-height: 47px;
            font-size: 14px;
            display: block;
            padding: 0 0 0 30px;
            /*border-left: 4px solid #323844;*/
            text-decoration: none;
        }

        .list-manage a:hover, .list-set a:hover {
            display: block;
            cursor: pointer;
            color: #fff;
            background: #fbca99;
            border-radius: 50%;
            transform: scale(1.5);
            /*background-color: #292f39;*/
            /*border-left: 4px solid #292f39;*/
        }
        .list-manage a.active, .list-set a.active {
            background: #f5511e;
            color: #fff;
        }
    </style>
</head>
<body style="margin:0px;padding:0px;">
<div class="index-head">
    <!--logo部分-->
    <div class="index-logo">
        <a href="index.html">
            <img src="./../image/index-img/yuewanlogo.png" alt="">
        </a>
    </div>
    <!--导航内容部分-->
    <div class="header-navigation">
        <a href="${pageContext.request.contextPath}/public/page/index.jsp" class="navigation-1 ar">首页</a>
        <a href="${pageContext.request.contextPath}/public/page/playwithbeauty.html" class="navigation-1 ar">约陪玩</a>
        <a href="${pageContext.request.contextPath}/public/page/recharge.jsp" class="navigation-1 ar">充值</a>
        <div class="header-navigation-ip">
            <input type="text" placeholder="搜索昵称、uid、靓号">
            <img src="${pageContext.request.contextPath}/public/image/index-img/search.png" alt="" class="search">
        </div>
    </div>
    <div class="header-navigation">
        <p>欢迎您，尊敬的管理员$</p>
    </div>
    <div class="header-navigation">
        <a href="${pageContext.request.contextPath}/public/page/Master_Edition.jsp" class="ar">
            <img src="${pageContext.request.contextPath}/public/image/index-img/message.png" alt="">
            信息中心
        </a>
    </div>
</div>
<form runat="server" id="form1" style="width:100%;height:100%;">
    <div class="jiBOX">
        <!--左侧-->
        <div id="master-left">
            <div class="master-list-manage">
                <div class="master-manage">
                    <span class="glyphicon glyphicon-tasks master-manage-icon"></span>
                    <span class="master-manage-name">管理</span>
                </div>
                <div class="list-manage">
                    <a href="${pageContext.request.contextPath}/public/newPage/userlist.jsp" class="a1" target="detail">用户列表</a>
                    <a href="${pageContext.request.contextPath}/public/newPage/Blacklist.html" class="a1" target="detail">封禁管理</a>
                </div>
            </div>
            <div class="master-list-set">
                <div class="list-set">
                    <a href="${pageContext.request.contextPath}/public/newPage/adminlist.jsp" class="a1" target="detail">管理员列表</a>
                    <a href="${pageContext.request.contextPath}/public/page/addadmin.jsp" class="a1" target="detail">添加管理员</a>
                </div>
            </div>
        </div>
    </div>

    <div style="height:2990px;margin:auto auto auto 180px;">
        <iframe id="detail" name="detail" style="margin:0;padding:0;height:100%;width:100%;right:0;border:solid 0 red;"
                src="${pageContext.request.contextPath}/public/page/Master_Order.html" frameborder="0"></iframe>
    </div>
</form>
</body>
<script>
    // 消息显示
    $(function () {
        if ($('.master-infomation-num').text() == 0) {
            $('.master-infomation-num').css({'color': 'white'});
        } else {
            $('.master-infomation-num').css({'color': 'red'});
        }
        if ($('.master-secret-num').text() == 0) {
            $('.master-secret-num').css({'color': 'white'});
        } else {
            $('.master-secret-num').css({'color': 'red'});
        }
    });
    // 退出
    $('.master-user-exit').click(function () {
        $.ajax({
            url: "#",
            dataType: "jsonp",
            success: function (obj) {
                url = window.location.href;
                if (url.indexOf('home') > 0) {
                    window.location.href = "https://y.tuwan.com";
                } else {
                    location.reload(true);
                }
            }
        })
    });
    // 管理
    $('.a1').click(function () {
        $('.list-manage a').removeClass('active');
        $('.list-set a').removeClass('active');
        $(this).addClass('active');
    });
    // 设置

</script>
</html>