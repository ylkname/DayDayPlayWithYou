<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="ch">
<head>
    <meta charset="UTF-8">
    <title>添加管理员</title>
    <link href="${pageContext.request.contextPath}/public/css/bootstrap.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath}/public/js/jquery-3.2.1.js"></script>
    <script src="${pageContext.request.contextPath}/public/util/bootstrap-3.3.7-dist/js/bootstrap.js"></script>
</head>
<body>
<div class="container">
    <center><h3>添加管理员</h3></center>
    <form action="${pageContext.request.contextPath}/adminBaseController?method='addAdmin'" method="post">
        <div class="form-group">
            <label for="name">管理员账号：</label>
            <input type="text" class="form-control" id="name" name="name" placeholder="请输入账号">
        </div>

        <div class="form-group">
            <label for="name">管理员密码：</label>
            <input type="text" class="form-control" id="password" name="password" placeholder="请输入密码">
        </div>

        <div class="form-group" style="text-align: center">
            <input class="btn btn-primary" type="submit" value="提交"/>
            <input class="btn btn-default" type="reset" value="重置"/>
            <input class="btn btn-default" type="button" value="返回"/>
        </div>
    </form>
</body>
</html>
