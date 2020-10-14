<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<!-- 网页使用的语言 -->
<html lang="zh-CN">
<head>
    <!-- 指定字符集 -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>修改用户</title>

    <link href="../css/bootstrap.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath}/public/js/jquery-3.2.1.js"></script>
    <script src="${pageContext.request.contextPath}/public/util/bootstrap-3.3.7-dist/js/bootstrap.js"></script>

</head>
<body>
<div class="container" style="width: 400px;">
    <h3 style="text-align: center;">修改用户信息</h3>
    <form action="" method="post">
        <div class="form-group">
            <label for="name">用户名：</label>
            <input type="text" class="form-control" id="user_name" name="user_name" value="${user.user_name}"
                   readonly="readonly" placeholder="请输入姓名"/>
        </div>

        <div class="form-group">
            <label for="name">昵称：</label>
            <input type="text" class="form-control" id="name" name="name" value="${user.name}" readonly="readonly"
                   placeholder="请输入昵称"/>
        </div>

        <div class="form-group">
            <label for="qq">QQ：</label>
            <input type="text" class="form-control" id="qq" name="qq" value="${user.qq_num}" placeholder="请输入QQ号码"/>
        </div>

        <div class="form-group">
            <label>电话：</label>
            <input type="text" class="form-control" id="age" name="age" value="${user.phone}" placeholder="请输入电话号码"/>
        </div>

        <div class="form-group">
            <label>账号状态：</label>
            <c:if test="${user.condition}==1">
                <input type="radio" name="condition" value="1" checked="checked"/>自由
                <input type="radio" name="condition" value="2"/>封禁
            </c:if>
            <c:if test="${user.condition}==2">
                <input type="radio" name="condition" value="1"/>自由
                <input type="radio" name="condition" value="2" checked/>封禁
            </c:if>
        </div>

        <div class="form-group" style="text-align: center">
            <input class="btn btn-primary" type="submit" value="提交"/>
            <input class="btn btn-default" type="reset" value="重置"/>
            <input class="btn btn-default" type="button" value="返回"/>
        </div>
    </form>
</div>
</body>
</html>