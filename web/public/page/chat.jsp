<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/public/css/chat.css">
    <script src="${pageContext.request.contextPath}/public/js/jquery-3.2.1.js"></script>
    <style type="text/css">
        #chat-box {
            width: 100%;
            height: 100%;
            background: pink;
            overflow: hidden;
        }
        #chat-box .chat-box-div {
            width: 920px;
            margin: 20px auto;
            border-radius: 7px;
            background-color: white;
        }
        #chat-box .chat-box-div .chat-title {
            height: 38px;
            line-height: 38px;
            border-bottom: 1px solid #f0f0f0;
            text-align: center;
        }
        #chat-box .chat-box-div .chat-box1 {
            border: 1px solid #f0f0f0;
            border-top: none;
        }
        #chat-box .chat-box-div .chat-box1 .chat-box1-left {
            display: inline-block;
            width: 219px;
            height: 577px;
            margin-left: -1px;
            vertical-align: top;
            border-right: 1px solid #f0f0f0;
        }
        #chat-box .chat-box-div .chat-box1 .chat-box1-left .chat-box1-left-list {
            width: 217px;
            height: 60px;
        }
        #chat-box .chat-box-div .chat-box1 .chat-box1-left .chat-box1-left-list:hover {
            background: skyblue;
        }
        #chat-box .chat-box-div .chat-box1 .chat-box1-left .chat-box1-left-list .chat-box1-left-list-img {
            display: inline-block;
            overflow: hidden;
            width: 40px;
            height: 40px;
            margin: 9px 10px 0 12px;
            vertical-align: top;
            border-radius: 50%;
        }
        #chat-box .chat-box-div .chat-box1 .chat-box1-left .chat-box1-left-list .chat-box1-left-list-img img {
            max-width: 100%;
            max-height: 100%;
        }
        #chat-box .chat-box-div .chat-box1 .chat-box1-left .chat-box1-left-list .chat-box1-left-list-name {
            display: inline-block;
            width: 100px;
            margin-right: 8px;
            padding-top: 14px;
            line-height: 1;
            vertical-align: top;
        }
        #chat-box .chat-box-div .chat-box1 .chat-box1-left .chat-box1-left-list .chat-box1-left-list-name .chat-box1-left-list-name1 {
            width: 100%;
            font-size: 12px;
            color: #111;
            overflow: hidden;
            white-space: nowrap;
            text-overflow: ellipsis;
        }
        #chat-box .chat-box-div .chat-box1 .chat-box1-left .chat-box1-left-list .chat-box1-left-list-name .chat-box1-left-list-id {
            width: 100%;
            margin-top: 5px;
            font-size: 12px;
            line-height: 1.1;
            transform: scale(0.9);
            color: #888;
            overflow: hidden;
            white-space: nowrap;
            text-overflow: ellipsis;
        }
        #chat-box .chat-box-div .chat-box1 .chat-box1-left .chat-box1-left-list-gl {
            position: relative;
            display: inline-block;
            overflow: hidden;
            width: 25px;
            height: 45px;
            padding-top: 14px;
            line-height: 1;
            text-align: right;
        }
        #chat-box .chat-box-div .chat-box1 .chat-box1-left .chat-box1-left-list-gl:hover .chat-box1-left-list-gl-close {
            display: block;
        }
        #chat-box .chat-box-div .chat-box1 .chat-box1-left .chat-box1-left-list-gl .chat-box1-left-list-gl-close {
            display: none;
            position: absolute;
            top: 1px;
            left: 16px;
            cursor: pointer;
        }
        #chat-box .chat-box-div .chat-box1 .chat-box1-left .chat-box1-left-list-gl .chat-box1-left-list-gl-num {
            position: absolute;
            top: 28px;
            left: 2px;
            display: none;
        }
        #chat-box .chat-box-div .chat-box1 .chat-box1-right {
            width: 690px;
            display: inline-block;
        }
        #chat-box .chat-box-div .chat-box1 .chat-box1-right .chat-box1-right-list {
            overflow-y: auto;
            height: auto;
            height: 400px;
            position: relative;
            top: 0;
            left: 0;
        }
        #chat-box .chat-box-div .chat-box1 .chat-box1-right .chat-box1-right-list1 {
            overflow-y: auto;
            width: 690px;
            height: 400px;
            position: absolute;
            top: 0;
            left: 0;
            display: none;
        }
        #chat-box .chat-box-div .chat-box1 .chat-box1-right .chat-box1-right-list1-left {
            height: 52px;
            width: 300px;
            margin-top: 10px;
        }
        #chat-box .chat-box-div .chat-box1 .chat-box1-right .chat-box1-right-list1-left .chat-box1-right-list1-left-div {
            display: inline-block;
            overflow: hidden;
            width: 40px;
            height: 40px;
            margin: 9px 10px 0 12px;
            vertical-align: top;
            border-radius: 50%;
            float: left;
        }
        #chat-box .chat-box-div .chat-box1 .chat-box1-right .chat-box1-right-list1-left .chat-box1-right-list1-left-div img {
            max-width: 100%;
            max-height: 100%;
        }
        #chat-box .chat-box-div .chat-box1 .chat-box1-right .chat-box1-right-list1-left .chat-box1-right-list1-left-div1 {
            border: 1px solid #cccccc;
            border-radius: 15px;
            width: 100%;
            height: 100%;
            margin-left: 57px;
        }
        #chat-box .chat-box-div .chat-box1 .chat-box1-right .chat-box1-right-list1-right {
            height: 52px;
            width: 690px;
            margin-top: 10px;
        }
        #chat-box .chat-box-div .chat-box1 .chat-box1-right .chat-box1-right-list1-right .chat-box1-right-list1-right-div1 {
            overflow: hidden;
            width: 40px;
            height: 40px;
            margin: 9px 10px 0 12px;
            vertical-align: top;
            border-radius: 50%;
            display: inline-block;
            float: left;
        }
        #chat-box .chat-box-div .chat-box1 .chat-box1-right .chat-box1-right-list1-right .chat-box1-right-list1-right-div1 img {
            max-width: 100%;
            max-height: 100%;
        }
        #chat-box .chat-box-div .chat-box1 .chat-box1-right .chat-box1-right-list1-right .chat-box1-right-list1-right-div {
            border: 1px solid #cccccc;
            border-radius: 15px;
            width: 300px;
            height: 100%;
            display: inline-block;
            float: left;
            margin-left: 325px;
        }
        #chat-box .chat-box-div .chat-box1 .chat-box1-right textarea {
            display: block;
            width: 100%;
            height: 150px;
            font-size: 12px;
            line-height: 1.5;
            resize: none;
            color: #333;
            border: 1px solid pink;
            background: #fff;
        }
        #chat-box .chat-box-div .chat-box1 .chat-box1-right button {
            position: absolute;
            top: 589px;
            left: 1099px;
        }













        /*滚动条*/
        .nui-scroll {
            height: 420px;
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
</head>
<body>
<div id="chat-box">
    <div class="chat-box-div">
        <div class="chat-title">天天陪玩</div>
        <div class="chat-box1">
            <div class="chat-box1-left">
                <div class="chat-box1-left-list">
                    <div class="chat-box1-left-list-img">
                        <img src="${requestScope.user.phone}" alt=""/>
                    </div>
                    <div class="chat-box1-left-list-name">
                        <div class="chat-box1-left-list-name1">
                            <c:out value="${requestScope.user.user_name}"/>
                        </div>
                        <div class="chat-box1-left-list-id">
                            ID:<c:out value="${requestScope.user.id}"/>
                        </div>
                    </div>
                    <div class="chat-box1-left-list-gl">
                        <div class="chat-box1-left-list-gl-close">x</div>
                        <div class="chat-box1-left-list-gl-num">0</div>
                    </div>
                </div>
            </div>

            <div class="chat-box1-right">
                <div class="nui-scroll">
                <c:forEach items="${requestScope.chats}" var="chat">
                    <c:if test="${chat.receiverId==requestScope.user.id}">
                        <div class="chat-box1-right-list1-left">
                            <div class="chat-box1-right-list1-left-div">
                                <img src="<c:out value="${chat.senderImg}"/>" alt="">
                            </div>
                            <div class="chat-box1-right-list1-left-div1">
                                <c:out value="${chat.messageContent}"/>
                            </div>
                        </div>
                    </c:if>
                    <c:if test="${chat.senderId==requestScope.user.id}">
                        <div class="chat-box1-right-list1-right">
                            <div class="chat-box1-right-list1-right-div">
                                <c:out value="${chat.messageContent}"/>
                            </div>
                            <div class="chat-box1-right-list1-right-div1">
                                <img src="<c:out value="${chat.senderImg}"/>" alt="">
                            </div>
                        </div>
                    </c:if>
                </c:forEach>
                </div>
                <textarea name="sendcontent" id="sendcontent" cols="30" rows="10"></textarea>
                <button id="btn">发送</button>
            </div>
        </div>
    </div>
</div>
<script>
    $("#btn").click(
        function () {
            $.ajax({
                type:"post",
                url:"addChat?tid=2",
                data:{sendcontent:$('#sendcontent').val()},
                timeout:1000,
                success:function (datas) {
                    $("#chat-box").html(datas);
                },
                error:function () {
                    alert("发送失败，请稍后再试");
                }
            });
        });
</script>
</body>
</html>