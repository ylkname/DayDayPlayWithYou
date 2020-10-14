<%@ page import="com.Bean.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<%
    User user = (User)session.getAttribute("user");

%>
<head>
    <meta charset="UTF-8">
    <title>申请成为陪玩</title>
    <link rel="stylesheet" href="../css/cropper.min.css">
    <link rel="stylesheet" href="../css/ImgCropping.css">
    <script src="${pageContext.request.contextPath}/public/js/jquery-3.2.1.js"></script>
    <script src="${pageContext.request.contextPath}/public/js/cropper.min.js"></script>
<%--    <link rel="stylesheet" href="${pageContext.request.contextPath}/public/css/xmMaster_Edition.css">--%>
<%--    <script src="${pageContext.request.contextPath}/public/js/xmMaster_Editionjs.js"></script>--%>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/public/css/tutor.css">
    <style type="text/css">
    </style>
    <script>
        function getMsg() {
            var  sex= $("input[name='sex']:checked").val();
            var  id_name=$("#IDname").val();
            var id_card=$("#IDnum").val();
            var app_photo=$("#pictrue").val();
            var tutor_box=$("#tutor_test option:selected").text();
            var tutor_level=$("#tutor-levels option:selected").text();
            var price=$("#price").val();
            //       alert(sex+" "+id_name+" "+id_card+" "+app_photo+" "+turto_box+" "+tutor_level+" "+price);
            $.ajax({
                url:"play.io",
                type:"post",
                data:"sex="+sex+"&id_name="+id_name+"&id_card="+id_card+"&app_photo="+app_photo+"&tutor_box="+tutor_box
                    +"&tutor_level="+tutor_level+"&price="+price,
                success:function (data) {
                    let json = JSON.parse(data);
                    if(json.result=="1000"){
                        alert("申请成功");
                        location.href="http://localhost:8080/DayDayPlay/public/page/index.jsp";
                    }
                    else {
                        alert("申请失败")
                    }

                }
            })
        }
    </script>

</head>
<body>
<%--<script src="${pageContext.request.contextPath}/public/js/xmMaster_Edition.js"></script>--%>
<%--<script src="${pageContext.request.contextPath}/public/js/xmMaster_Editionleft.js"></script>--%>
<div id="tutor_box" >
    <div id="tutor" >
        <h3>申请陪玩</h3>
        <ul>

            <li id="li_pic"><div  id="tutor_pic">
                <img id="finalImg" src="" width="100%">
            </div>
                <div id="tutor_pic_btn">
                    <button id="replaceImg" class="l-btn">更换</button>
                    <div>支持jpg、gif、png、或bmp格式的图片，文件必须小于3M</div></div>
            </li>
            <li>基本资料 <span class="FIn">标题标*为必填项，请务必填写真实资料</span></li>
            <li>
                <span class="FIn">*</span><span class="OP">昵称</span><input type="text" class="border"  id="jb-neckname" value="<%=user.getName()%>">
            </li>
            <li>
                <span class="FIn">*</span><span class="OP">性别</span><input type="radio" name="sex" checked="checked" class="sex" value="男" >男&nbsp; &nbsp;&nbsp;&nbsp;<input type="radio" name="sex" class="sex" value="女">女
            </li>
            <li>
                <span class="FIn">*</span><span class="OP" id="id_name">身份证姓名</span><input type="text" class="border"  id="IDname">
            </li>
            <li>
                <span class="FIn">*</span><span class="OP" id="id_card">身份证号</span><input type="text" class="border"  id="IDnum">
            </li>
            <li>
                <span class="FIn">*</span><span class="OP" id="ph_num">手机</span><input type="text" class="border"  id="phone" value="<%=user.getPhone()%>">
            </li>
            <li>
                <span class="FIn">*</span><span class="OP" id="qq_num">QQ</span><input type="text" class="border"  placeholder="重要联系方式" id="QQ" value="<%=user.getQq_num()%>">
            </li>
            <li id="li_pic2"><span class="FIn">*</span><span class="OP" id="app_photo">app封面照</span><div id="tutor_pic2" > <img class="pic" id="pic2"><input id="pictrue" class="upload" name="file" type="file" style="display: none"/><span>请点击图片上传您的主页封面照，建议大小为：750*1334</span>
            </div></li>
            <li id="tutor-games">
                <span class="FIn">*</span> <span class="OP-games">请选择申请的游戏</span>
                <select id="tutor_test" class="border" name="s_game">
                    <option value="0">英雄联盟</option>
                    <option value="1">绝地求生</option>
                    <option value="2">和平精英</option>
                    <option value="3">王者荣耀</option>
                </select>
            </li>
            <li id="tutor-levels">
                <span class="FIn">*</span> <span class="OP-games">请选择自己的段位</span>
                <select id="tutor_level" class="border" name="d_body" >
                    <option value="0">萌新</option>
                    <option value="1">中级</option>
                    <option value="2">高级</option>
                    <option value="3">大神</option>
                </select>
            </li>
            <li>
                <span class="FIn">*</span><span class="OP" id="p_price">价格</span><input type="text" class="border"  id="price">
            </li>
            <li id="tutor-person">
                <span class="FIn">*</span><span class="OP" id="yourself">自我介绍</span><textarea name="" id="person-con" cols="70" rows="6"></textarea>
            </li>
            <li id="li_pic3"><span class="FIn">*</span><span class="OP" id="game_potot">游戏封面照</span><div id="tutor_pic3"><img class="pic" id="pic3"><input class="upload" name="file" type="file" style="display: none"/><span>请点击图片上传您游戏截图(游戏个人界面)</span></div></li>
        </ul>
        <button id="tutor_btn" onclick="getMsg()">提交</button>
    </div>
</div>



<!--图片裁剪框 start-->
<div style="display: none" class="tailoring-container">
    <div class="black-cloth" onclick="closeTailor(this)"></div>
    <div class="tailoring-content">
        <div class="tailoring-content-one">
            <label title="上传图片" for="chooseImg" class="l-btn choose-btn">
                <input type="file" accept="image/jpg,image/jpeg,image/png" name="file" id="chooseImg" class="hidden" onchange="selectImg(this)">
                选择图片
            </label>
            <div class="close-tailoring"  onclick="closeTailor(this)">×</div>
        </div>
        <div class="tailoring-content-two">
            <div class="tailoring-box-parcel">
                <img id="tailoringImg">
            </div>
            <div class="preview-box-parcel">
                <p>图片预览：</p>
                <div class="square previewImg"></div>
                <div class="circular previewImg"></div>
            </div>
        </div>
        <div class="tailoring-content-three">
            <button class="l-btn cropper-reset-btn">复位</button>
            <button class="l-btn cropper-rotate-btn">旋转</button>
            <button class="l-btn cropper-scaleX-btn">换向</button>
            <button class="l-btn sureCut" id="sureCut">确定</button>
        </div>
    </div>
</div>
<!--图片裁剪框 end-->
</body>
<script src="../js/tutor.js"></script>
</html>