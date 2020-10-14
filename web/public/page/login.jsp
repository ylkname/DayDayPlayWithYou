<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>登录页-陪玩管理系统</title>
    <meta name="keywords" content="登录,陪玩管理系统" />
    <meta name="description" content="登录页--陪玩管理系统">
    <link rel="icon" href="//public.openyy.com/Public/favicon.ico" type="image/x-icon" />
    <link rel="shortcut icon" href="//public.openyy.com/Public/favicon.ico" type="image/x-icon" />
    <link href="//apps.bdimg.com/libs/bootstrap/3.0.3/css/bootstrap.min.css" rel="stylesheet">
    <link href="//public.openyy.com/Public/home/css/main-v2.css?v=28" rel="stylesheet">
    <!--[if lt IE 9]>
    <script src="//public.openyy.com/Public/home/js/html5shiv.min.js"></script>
    <script src="//public.openyy.com/Public/home/js/respond.min.js"></script>
    <![endif]-->
    <style>
        body{
            background-color: #f5f5f5;
        }
    </style>
    <script type="text/javascript"  src="../js/jquery-3.2.1.js" ></script>
    <script type="text/javascript">
         function loginCheck() {
             //    var type1 = $("#type1").val();//用户
             //    var type2 = $("#type2").val();//管理员
                     var flag=ischeck();
                     if (flag==false){
                         alert("请选中单选框")
                     }
                 var type=$('input[name="type"]:checked').val();
                 var username = $("#loginusername").val();
                 var password = $("#loginpassword").val();
             //    alert(type);
                 $.ajax({
                     url: "/DayDayPlay/login.do",
                     type: "POST",
                     data: "type="+type+"&username="+username+"&password="+password,
                     success:function (data) {
                       if (data.result=="1000"){
                          alert(json.msg);
                       }
                       if(data.result=="1001"){
                          // alert(json.msg)
                           location.href="index.jsp"
                       }
                     }
                 })
         }
             //是否选中
            function ischeck() {
                return $("#remember_name").is(':checked');
             }
    </script>
    <meta name="__hash__" content="3a9e1e0aac654ae78552419fe94fdd14_20b65e040c8cfc95e1ff14017248968f" /></head>
<body>

<nav class="navbar navbar-default navbaar13" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <a class="navbar-brand" >
                <img src="../image/index-img/yuewanlogo.png" alt=""  width="157px" height="43px">
            </a>
        </div>
    </div>
</nav>


<div class="container login register">
    <div class="row">
        <div class="col-md-6 col-sm-6 left hidden-xs">
            <img src="//public.openyy.com/Public/home/images/img12.png" alt="">
        </div>
        <div class="col-md-6 col-sm-6 right hidden-xs-border">
            <h3>用户登录</h3>
            <form role="form" action="${pageContext.request.contextPath}/login.do" method="post" id="login_container">
                <div class="form-group">
                    <input type="text" class="form-control" name="username" id="loginusername" placeholder="帐号/手机" >
                </div>
                <div class="form-group">
                    <input type="password" class="form-control" name="password" id="loginpassword" placeholder="登录密码">
                </div>
                <div class="form-group hidden" style="visibility: hidden; height: 1px; overflow: hidden;">
                    <input type="password" name="_no_auto_password_">
                </div>
                <div class="forget clearfix">
                    <a href="###" class="pull-right">忘记密码？></a>
                </div>
                <div class="form-group">
                    <label>
                        <input name="type" id="type1" type="radio" value="1" checked="">
                        <span> 用户</span>
                    </label>
                    <label>
                        <input name="type" id="type2" type="radio" value="2">
                        <span> 管理员</span>
                    </label>
                </div>
                <div class="checkbox">
                    <label><input type="checkbox" id="remember_name"> 记住我（公共场合不要勾选）</label>
                </div>
                <div class="form-group clearfix">
                    <input type="hidden" id="return_url" value="aHR0cDovL2hhaGFoYS5vcGVueXkuY29tL0hvbWUvVXNlci9yZWcuaHRtbA==">
                    <button type="submit" class="btn btn-primary" style="width: 45%;" >登录</button>
                    <a href="resign.html" class="btn btn-default pull-right">免费注册</a>
                </div>
                <input type="hidden" name="__hash__" value="3a9e1e0aac654ae78552419fe94fdd14_20b65e040c8cfc95e1ff14017248968f" />
            </form>
            <div class="other">
                <form action="/Home/User/steamlogin.html?login" method="post" style="float: left;margin-top: 5px;">
                    <input type="hidden" name="__hash__" value="3a9e1e0aac654ae78552419fe94fdd14_20b65e040c8cfc95e1ff14017248968f" />
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>

