<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%
        Object money = request.getSession().getAttribute("money");
        Object id=request.getSession().getAttribute("id");
        if(money==null){
            money=0;
        }
    %>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>支付中心</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/public/util/bootstrap-3.3.7-dist/css/bootstrap.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/public/css/recharge.css">
    <style>
        .index-head .ar:hover{
            color: #FA6543;

        }
        .index-head a{
            text-decoration: none;
            color: black;
        }
        .index-head a:hover{
            text-decoration: none;
        }
        .index-head{
            width: 100%;
            height: 80px;
            background: white;
        }
        .index-logo{
            /*position: absolute;
            top: 15px;
            left: 120px;*/
            display: inline-block;
            margin-top: 16px;
            margin-left: 120px;
        }
        .header-navigation{
            display: inline-block;/*
            border: 1px solid #000;*/
            margin-left: 120px;
        }
        .navigation-1{
            margin-right: 20px;

        }
        .header-navigation-ip{
            display: inline-block;
            position: relative;
        }
        .header-navigation-ip input{
            padding: 0 10px;
            border-radius: 25px;
            background-color: #f0f0f0;
            display: inline-block;
            line-height: 34px;
            height: 34px;
            font-size: 13px;
            border: 1px solid #f0f0f0 ;
            outline: none;
        }
        .header-navigation-ip img{
            position: absolute;
            top:10px;
            right: 10px;
            cursor: pointer;
        }
    </style>
    <script type="text/javascript"  src="${pageContext.request.contextPath}/public/js/jquery-3.2.1.js" ></script>
    <script type="text/javascript">
        function addmoney() {

            var money =document.getElementById("addmoney").innerText;
            //  alert(money);
            $.ajax({
                url:"recharge.do",
                type:"POST",
                data:"money="+money,
                success:function (data) {
                    var  json=JSON.parse(data);
                    if (json.result=="1000"){
                        alert(json.msg)
                        return;
                    }
                    if (json.result="1001"){
                        alert("充值成功");
                        location.href="http://localhost:8080/DayDayPlay/public/page/index.jsp"
                    }
                }
            })
        }
    </script>
</head>
<body>
<div class="index-head">
    <!--logo部分-->
    <div class="index-logo">
        <a href="javascript:;">
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
            <img src="../image/index-img/search.png" alt="" class="search">
        </div>
    </div>
    <div class="header-navigation">
        <a class="ar" href="login.jsp">

            <span class="glyphicon glyphicon-user" aria-hidden="true">登录&nbsp;</span>
        </a>
        <a class="ar" href="resign.html">
            <span class="glyphicon glyphicon-user" aria-hidden="true">注册</span>
        </a>
    </div>
    <div class="header-navigation">
        <a href="Master_Edition.jsp" class="ar">
            <img src="../image/index-img/message.png" alt="">
            信息中心
        </a>
    </div>
</div>
<div id="recharge">
    <div class="recharge-box">
        <form>
            <ul id="recharge-box-navgation">
                <li class="recharge-box-navgation-li1">
                    <span class="recharge-box-navgation-li1-span">账号充值</span>
                </li>
                <li class="recharge-box-navgation-li2"></li>
                <li class="recharge-box-navgation-li3">
                    <span class="recharge-box-navgation-li3-span" >账户余额: </span><span class="recharge-box-navgation-li3-span1"><%=money%></span>
                </li>
                <li class="recharge-box-navgation-li4 clearfix">
                    <p class="clearfix">充值余额 :
                    <div class="recharge-box-navgation-li4-div">
                    <span class="recharge-box-navgation-li4-div-span">10元
                        <img src="${pageContext.request.contextPath}/public/image/tr/ico_5.png" alt="">
                    </span>
                        <span class="recharge-box-navgation-li4-div-span1">50元
                        <img src="${pageContext.request.contextPath}/public/image/tr/ico_5.png" alt="">
                    </span>
                        <span class="recharge-box-navgation-li4-div-span2">100元
                        <img src="${pageContext.request.contextPath}/public/image/tr/ico_5.png" alt="">
                    </span>
                        <span class="recharge-box-navgation-li4-div-span3">500元
                        <img src="${pageContext.request.contextPath}/public/image/tr/ico_5.png" alt="">
                    </span>
                        <span class="recharge-box-navgation-li4-div-span4">1000元
                        <img src="${pageContext.request.contextPath}/public/image/tr/ico_5.png" alt="">
                    </span>
                        <span class="recharge-box-navgation-li4-div-span5">1500元
                        <img src="${pageContext.request.contextPath}/public/image/tr/ico_5.png" alt="">
                    </span>
                        <span class="recharge-box-navgation-li4-div-span6">2000元
                        <img src="${pageContext.request.contextPath}/public/image/tr/ico_5.png" alt="">
                    </span>
                    </div>
                    </p>
                    <div class="recharge-box-navgation-li4-div2 clearfix">
                        <input type="text" placeholder="输入充值金额"><div>其他金额</div>
                    </div>
                </li>
                <li class="recharge-box-navgation-li8">
                    <span class="recharge-box-navgation-li8-span" >充值金额: </span><span class="recharge-box-navgation-li8-span1" id="addmoney">0.00元</span>
                </li>
                <li class="recharge-box-navgation-li5">
                    <div>充值方式</div>:
                    <span class="recharge-box-navgation-li5-span">
                    <img src="${pageContext.request.contextPath}/public/image/tr/ico_2.png" alt="" class="recharge-box-navgation-li5-icon">
                    &nbsp&nbsp支付宝
                    <img src=${pageContext.request.contextPath}/public/image/tr/ico_5.png" alt="" class="recharge-box-navgation-li5-icon1">
                </span>
                    <span class="recharge-box-navgation-li5-span1">
                    <img src="${pageContext.request.contextPath}/public/image/tr/ico_3.png" alt="" class="recharge-box-navgation-li5-icon">
                    &nbsp&nbsp微信
                    <img src="${pageContext.request.contextPath}/public/image/tr/ico_5.png" alt="" class="recharge-box-navgation-li5-icon1">
                </span>
                </li>

                <li class="recharge-box-navgation-li6">
                    <input style="color: chocolate" type="button" href="${pageContext.request.contextPath}/public/page/recharge.jsp" value="立即支付" onclick="addmoney()"/>
                </li>
                <li class="recharge-box-navgation-li7">
                    备注：充值可用于消费，不能提现
                </li>
            </ul>
        </form>
    </div>
</div>
</body>
<script>
    let oSpan=$('.recharge-box-navgation-li4-div span');
    let money;
    let oRechargeMoney=$('.recharge-box-navgation-li8-span1');
    let oRechargeArbitrarily=$('.recharge-box-navgation-li4-div2 input');
    let oRechargePay=$('.recharge-box-navgation-li5 span');
    function changeTwoDecimal_f(x) {
        var f_x = parseFloat(x);
        if (isNaN(f_x)) {
            alert('function:changeTwoDecimal->parameter error');
            return false;
        }
        var f_x = Math.round(x * 100) / 100;
        var s_x = f_x.toString();
        var pos_decimal = s_x.indexOf('.');
        if (pos_decimal < 0) {
            pos_decimal = s_x.length;
            s_x += '.';
        }
        while (s_x.length <= pos_decimal + 2) {
            s_x += '0';
        }
        return s_x;
    }
    $(document).ready(function(){
        $.ajax({
            url:'/rechargeMoney',
            type:'post',
            data:{
                id:'111111'
            },
            success:function(res){
                $('.recharge-box-navgation-li3-span1').text(changeTwoDecimal_f(res[0].p)+'元')
            }
        })
    })
    $('.recharge-box-navgation-li4').on('click','span',function(){
        $.each(oSpan,function(i,v){
            $(v).css({
                'border':'1px solid #e1e1e1'
            })
            $(v).find($('img')).css({
                'display':'none'
            });

        });
        $(this).css({
            'border':'1px solid #f5501e'
        });
        $(this).find($('img')).css({
            'display':'block'
        });
        money=$(this).text();
        oRechargeMoney.text(money)
    });
    oRechargeArbitrarily.on('input',function(){
        if($(this).val()==0){
            oRechargeMoney.text('0.00'+'元')
        }else{
            oRechargeMoney.text($(this).val()+'元')
        }
    })
    $('.recharge-box-navgation-li5-span').click(function(){
        if($('.recharge-box-navgation-li5-span').css('border')=='1px solid rgb(245, 80, 30)'){
            console.log(1)
        }else{
            $(this).css({
                'border':'1px solid #f5501e'
            });
            $(this).find($('.recharge-box-navgation-li5-icon1')).css({
                'display':'block'
            });
        }
    });
    $('.recharge-box-navgation-li5').on('click','span',function(){
        console.log(oRechargePay)
        $.each(oRechargePay,function(i,v){
            $(v).css({
                'border':'1px solid #e1e1e1'
            })
            $(v).find($('.recharge-box-navgation-li5-icon1')).css({
                'display':'none'
            });
        })
        $(this).css({
            'border':'1px solid #f5501e'
        });
        $(this).find($('.recharge-box-navgation-li5-icon1')).css({
            'display':'block'
        });
    })
    $('.recharge-box-navgation-li6').click(function(){
        let money=$('.recharge-box-navgation-li8-span1').text().split('元')[0];
        $.ajax({
            url:'/recharge',
            type:'post',
            data:{
                money:money,
                id:'111111'
            },
            success:function(res){
                res.error?console.log('数据库错误'):console.log('充值成功')
            }
        })
    })
</script>
</html>