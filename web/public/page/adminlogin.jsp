<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="ch">
<head>
    <meta charset="UTF-8">
    <title>管理员登录</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/public/css/login.css">
    <script src="${pageContext.request.contextPath}/public/js/jquery-3.2.1.js"></script>
    <script src="${pageContext.request.contextPath}/public/js/gVerify.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/public/css/head.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/public/util/bootstrap-3.3.7-dist/css/bootstrap.css">
    <script src="${pageContext.request.contextPath}/public/util/bootstrap-3.3.7-dist/js/bootstrap.js"></script>
</head>
<body>
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
            <input type="text" placeholder="搜索昵称、uid、靓号">
            <img src="${pageContext.request.contextPath}/public/image/index-img/search.png" alt="" class="search">
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
<div class="login">
    <div>
        <ul id="tabs">
            <li class="opt">登录</li>
            <li>注册</li>
        </ul>
    </div>
    <div>
        <div class="tab tab1">
            <p><span class="OP">账号</span> <input type="text" placeholder="请输入用户名或手机号" id="user"></p>
            <!--<span>xxxxxxxxx</span>-->
            <p><span class="OP">密码</span> <input type="password" placeholder="请输入密码" id="password"></p>
            <!--<span>xxxxxxxxx</span>-->
            <p id="p_code"><span id="p_code_span" class="OP">验证码</span>
                <input type="text" id="code_input" value="" placeholder="请输入验证码"/><span id="v_container"></span>
            </p>
            <a href="../newPage/findBack.html"><p id="ForgetPwd"><span href="">忘记密码</span></p></a>
            <button id="login_btn">登录</button>
        </div>
        <div class="tab tab2">
            <p><span class="OP">用户名</span> <input type="text" placeholder="用户名3到15位，可用中英文和下划线" id="newUser"><br> <span
                    id="register_warn1"></span></p>

            <p><span class="OP">密码</span> <input type="password" placeholder="请输入密码，要求6到16位" id="newPass"></p>
            <!--  <span id="register_warn2">xxxxxxxxx</span>-->
            <p><span class="OP">确认密码</span> <input type="password" placeholder="请再次输入密码" id="newPass1">
                <span id="register_warn3"></span></p>

            <p><span class="OP">手机号</span> <input type="text" placeholder="请输入手机号" id="phone"></p>
            <!-- <span id="register_warn4">xxxxxxxxx</span>-->
            <p><span CLASS="OP">验证码</span><input type="text" name="code" id="code">
                <input type="button" value="获取验证码" id="btn1"></p>
            <button id="register_btn">注册</button>
        </div>
    </div>
</div>
</div>
</body>
<script src="../js/login.js"></script>
</html>