<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
   <link rel="stylesheet" href="${pageContext.request.contextPath}/public/util/swiper.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/public/util/bootstrap-3.3.7-dist/css/bootstrap.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/public/css/index.css">
    <script src="${pageContext.request.contextPath}/public/util/swiper.min.js"></script>
    <script src="${pageContext.request.contextPath}/public/js/jquery-3.2.1.js"></script>
    <script src="${pageContext.request.contextPath}/public/util/bootstrap-3.3.7-dist/js/bootstrap.js"></script>
    <style type="text/css">
        #suggest {
            position: absolute;
            background-color: gainsboro;
            text-align: left;
            border: 1px solid #000000;
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
                        var url="${pageContext.request.contextPath}/public/page/detail.jsp?key="+data[i].Room_id;
                        html+="<a href='"+url+"'>"+data[i].Room_id+"</a><br/>";
                    }
                        $("#suggest").html(html);
                    }
                )
            });
        })
    </script>
</head>
<body>
<div class="container-fluid">
    <div class="row">
        <div class="index-box">
            <!------------------头部---------------------------->
            <div class="index-head">
                <!--logo部分-->
                <div class="index-logo">
                    <a href="index.jsp">
                        <img src="${pageContext.request.contextPath}/public/image/index-img/yuewanlogo.png" alt="">
                    </a>
                </div>
                <!--导航内容部分-->
                <div class="header-navigation">
                    <a href="javascript:;" class="navigation-1 ar">首页</a>
                    <a href="${pageContext.request.contextPath}/public/page/playwithbeauty.html" class="navigation-1 ar">约陪玩</a>
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
                    <a href="${pageContext.request.contextPath}/public/page/Master_Edition.jsp" class="ar">
                        <img src="${pageContext.request.contextPath}/public/image/index-img/message.png" alt="">
                        信息中心
                    </a>
                </div>
            </div>
            <!--------------------轮播部分------------------------>
            <div class="index-planting">
                <!--轮播图-->
                    <div class="swiper-container">
                        <div class="swiper-wrapper">
                            <div class="swiper-slide">
                                <a href="playwithbeauty.html"><img src="${pageContext.request.contextPath}/public/image/index-img/1.jpg" alt="">
                                </a>
                            </div>
                                <div class="swiper-slide">
                                    <a href="${pageContext.request.contextPath}/public/newPage/Notice.html"><img src="../image/index-img/2.jpg" alt="">
                                    </a>
                                </div>
                            <div class="swiper-slide">
                                <a href="9.9.html">
                                    <img src="${pageContext.request.contextPath}/public/image/index-img/3.jpg" alt="">
                                </a>
                            </div>

                        </div>
                        <!-- 如果需要分页器 -->
                        <div class="swiper-pagination "></div>

                        <!-- 如果需要导航按钮 -->
                        <div class="swiper-button-prev swiper-button-white"></div>
                        <div class="swiper-button-next swiper-button-white"></div>
                    </div>

                <!--轮播图下-热门服务-爱的表白-爱的推荐-->
                <div class="planting-date">
                    <!--热门服务-->
                    <div class="planting-date-icon">
                        <div>
                            <span class="date-font">热门服务</span>
                            <a href="playwithbeauty.html" class="date-more">更多</a>
                        </div>
                        <div class="date-gamename">
                            <a href="playwithbeauty.html" class="date-icon-a">
                                <i class="date-icon lol"></i>
                                <p class="icon-p flol">英雄联盟</p>

                            </a>
                            <a href="playwithbeauty.html" class="date-icon-a">
                                <i class="date-icon pubg"></i>
                                <p class="icon-p fpubg">绝地求生</p>
                            </a>
                            <a href="playwithbeauty.html" class="date-icon-a">
                                <i class="date-icon hizi"></i>
                                <p class="icon-p fhizi">王者荣耀</p>
                            </a>
                            <a href="playwithbeauty.html" class="date-icon-a">
                                <i class="date-icon audio"></i>
                                <p class="icon-p faudio">声优聊天</p>
                            </a>
                            <a href="playwithbeauty.html" class="date-icon-a">
                                <i class="date-icon five"></i>
                                <p class="icon-p ffive">和平精英</p>
                            </a>
                        </div>
                    </div>
                    <!--爱的表白-->
                    <div class="planting-date-Confession">
                        <div>
                            <span class="date-font">爱的表白</span>
                            <a href="javascript:;" class="date-more">购买</a>
                        </div>
                        <div class="date-Confession">
                            <div class="date-Confession-top">
                                <span class="Confession-top-to">TO</span>
                                <a class="Confession-top-a" href="javascript:;">
                                    <img class="Confession-top-img" src="${pageContext.request.contextPath}/public/image/index-img/69_avatar_middle.jpg"
                                         alt="">
                                    <span class="Confession-top-name">肉多多</span>
                                </a>
                            </div>
                            <div class="date-Confession-section">..</div>
                            <div class="date-Confession-bottom">
                                <p class="fr">
                                    <span class="Confession-top-to">By</span>
                                    <img class="Confession-top-img" src="${pageContext.request.contextPath}/public/image/index-img/70_avatar_middle.jpg"
                                         alt="">
                                    <span class="Confession-top-name">徐凤年●rz</span>
                                </p>
                            </div>
                        </div>
                    </div>
                    <!--爱的推荐-->
                    <div class="planting-date-Recommend">
                        <div>
                            <span class="date-font">爱的推荐</span>
                        </div>
                        <div class="date-Recommend">
                            <a href="detail.jsp">
                                <div class="date-Recommend-img-left">
                                    <img src="${pageContext.request.contextPath}/public/image/index-img/33_avatar_big2.jpg" alt="">
                                    <div class="date-Recommend-img-font-left">
                                        提拉米小七七
                                    </div>
                                </div>
                            </a>
                            <a href="detail.jsp">
                                <div class="date-Recommend-img-right">
                                    <img src="${pageContext.request.contextPath}/public/image/index-img/82_avatar_big2.jpg" alt="">
                                    <div class="date-Recommend-img-font-right">
                                        清扬婉兮啾小咪
                                    </div>
                                </div>
                            </a>
                        </div>
                    </div>
                </div>
            </div>
            <!--------------------热门推荐------------------------>
            <div class="index-hot">
                <!--热门字体头-->
                <div class="index-hot-icon">
                    <span class="hot-icon-font">
                        <img src="${pageContext.request.contextPath}/public/image/index-img/fireicon.png" alt="">
                        热门推荐
                    </span>
                    <span class="hot-icon-font2">
                        换一批
                        <img src="${pageContext.request.contextPath}/public/image/index-img/updateicon.png" alt="">
                    </span>
                </div>
                <div class="index-hot-img">
                    <!--图片1-->
                        <div class="hot-img-box">
                            <a href="javascript:;">
                                <img class="hot-img" src="${pageContext.request.contextPath}/public/image/index-img/41_avatar_large.jpg" alt="">
                                <div class="hot-font">
                                    <div class="hot-font-top">
                                        鹿真
                                        <div class="top-Label-one">乖巧粘人</div>
                                        <div class="top-Label-two">情感知心</div>
                                    </div>
                                </div>
                            </a>
                        </div>
                    <div class="hot-img-box">
                        <a href="javascript:;">
                            <img class="hot-img" src="${pageContext.request.contextPath}/public/image/index-img/41_avatar_large.jpg" alt="">
                            <div class="hot-font">
                                <div class="hot-font-top">
                                    鹿真
                                    <div class="top-Label-one">乖巧粘人</div>
                                    <div class="top-Label-two">情感知心</div>
                                </div>
                                <div class="hot-font-bottom">
                                    <div class="font-bottom-gametype">王者荣耀</div>
                                    <div class="font-bottom-Price">
                                        <span>10</span>
                                        元 / 局
                                    </div>
                                </div>
                            </div>
                        </a>
                    </div>
                </div>
            </div>
            <!--------------------新秀推荐------------------------>
            <div class="index-newstar">
                <div class="newstar-bigfont">新秀推荐</div>
                <div class="newstar-bigfont-right">
                   <div class="newstar-img-box">
                        <a href="javascript:;">
                            <div class="newstar-img">
                                <img src="${pageContext.request.contextPath}/public/image/index-img/49_avatar_big2.jpg" alt="">
                            </div>
                            <div class="newstar-name"> 洛洛baby～</div>
                            <div class="newstar-address">重庆</div>
                            <div class="newstar-age">♀&nbsp;22</div>
                        </a>
                    </div>
                </div>
            </div>
            <!--------------------榜单------------------------>
            <div class="index-list">
                <!--热度榜模块-->
                <div class="list-hot">
                    <!--热度榜字体-->
                    <div class="list-hot-title">
                        <i class="date-icon spark"></i>
                        热度榜
                    </div>
                    <!--热度榜的总榜和周榜的切换-->
                    <div class="list-hot-font">
                        <div class="list-hot-font-week list-hot-font-color hot-week">周榜</div>
                        <div class="list-hot-font-all hot-total">总榜</div>
                    </div>
                    <!--热度周榜-->
                    <div class="list-hot-week">
                        <div class="list-hot-no1">
                            <div class="hot-no1-head">
                                <a href="javascript:;">
                                    <img src="${pageContext.request.contextPath}/public/image/index-img/40_avatar_big.jpg" alt="">
                                </a>
                                <div class="hot-no1-head2">
                                    <div class="no1-head2-num">1</div>
                                </div>
                                <div class="no1-head2-bottom">
                                    <div class="no1-head2-bottom-text">
                                        <p class="head2-bottom-name">♚可爱萌1♚</p>
                                        <span class="head2-bottom-address">南京市</span>
                                        <span class="head2-bottom-cs">接单:123次</span>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="list-hot-no1">
                            <div class="hot-no1-head">
                                <a href="javascript:;">
                                    <img src="${pageContext.request.contextPath}/public/image/index-img/40_avatar_big.jpg" alt="">
                                </a>
                                <div class="hot-no1-head2">
                                    <div class="no1-head2-num">2</div>
                                </div>
                                <div class="no1-head2-bottom">
                                    <div class="no1-head2-bottom-text">
                                        <p class="head2-bottom-name">♚可爱萌♚</p>
                                        <span class="head2-bottom-address">南京市</span>
                                        <span class="head2-bottom-cs">接单:123次</span>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="list-hot-no2">
                            <div class="fl">
                                <div class="hot-no2-imgbox">
                                    <div class="hot-no2-img">
                                        <a href="javascript:;">
                                            <img src="${pageContext.request.contextPath}/public/image/index-img/15_avatar_big.jpg" alt="">
                                        </a>
                                    </div>
                                    <div class="hot-no2-imgno">3</div>
                                </div>

                            </div>
                            <div class="fl hot-no2-play">
                                <div class="hot-no2-nm">小太阳♚德芙</div>
                                <div class="hot-no2-Grade">
                                    <img src="${pageContext.request.contextPath}/public/image/index-img/charm_16.png" alt="">
                                </div>
                            </div>
                            <div class="fr hot-no2-information">
                                <div class="hot-no2-address fl">六安市</div>
                                <div class="hot-no2-age fl">♀ 24</div>
                                <div class="clearfix"></div>
                                <div class="hot-no2-sig">接单:105次</div>
                            </div>
                        </div>
                        <div class="list-hot-no2">
                            <div class="fl">
                                <div class="hot-no2-imgbox">
                                    <div class="hot-no2-img">
                                        <a href="javascript:;">
                                            <img src="${pageContext.request.contextPath}/public/image/index-img/15_avatar_big.jpg" alt="">
                                        </a>
                                    </div>
                                    <div class="hot-no2-imgno">3</div>
                                </div>

                            </div>
                            <div class="fl hot-no2-play">
                                <div class="hot-no2-nm">小太阳♚德芙</div>
                                <div class="hot-no2-Grade">
                                    <img src="${pageContext.request.contextPath}/public/image/index-img/charm_16.png" alt="">
                                </div>
                            </div>
                            <div class="fr hot-no2-information">
                                <div class="hot-no2-address fl">六安市</div>
                                <div class="hot-no2-age fl">♀ 24</div>
                                <div class="clearfix"></div>
                                <div class="hot-no2-sig">接单:105次</div>
                            </div>
                        </div>
                        <div class="list-hot-no2">
                            <div class="fl">
                                <div class="hot-no2-imgbox">
                                    <div class="hot-no2-img">
                                        <a href="javascript:;">
                                            <img src="${pageContext.request.contextPath}/public/image/index-img/15_avatar_big.jpg" alt="">
                                        </a>
                                    </div>
                                    <div class="hot-no2-imgno">3</div>
                                </div>

                            </div>
                            <div class="fl hot-no2-play">
                                <div class="hot-no2-nm">小太阳♚德芙</div>
                                <div class="hot-no2-Grade">
                                    <img src="${pageContext.request.contextPath}/public/image/index-img/charm_16.png" alt="">
                                </div>
                            </div>
                            <div class="fr hot-no2-information">
                                <div class="hot-no2-address fl">六安市</div>
                                <div class="hot-no2-age fl">♀ 24</div>
                                <div class="clearfix"></div>
                                <div class="hot-no2-sig">接单:105次</div>
                            </div>
                        </div>
                        <div class="list-hot-no2">
                            <div class="fl">
                                <div class="hot-no2-imgbox">
                                    <div class="hot-no2-img">
                                        <a href="javascript:;">
                                            <img src="${pageContext.request.contextPath}/public/image/index-img/15_avatar_big.jpg" alt="">
                                        </a>
                                    </div>
                                    <div class="hot-no2-imgno">3</div>
                                </div>

                            </div>
                            <div class="fl hot-no2-play">
                                <div class="hot-no2-nm">小太阳♚德芙</div>
                                <div class="hot-no2-Grade">
                                    <img src="${pageContext.request.contextPath}/public/image/index-img/charm_16.png" alt="">
                                </div>
                            </div>
                            <div class="fr hot-no2-information">
                                <div class="hot-no2-address fl">六安市</div>
                                <div class="hot-no2-age fl">♀ 24</div>
                                <div class="clearfix"></div>
                                <div class="hot-no2-sig">接单:105次</div>
                            </div>
                        </div>
                        <div class="list-hot-no2">
                            <div class="fl">
                                <div class="hot-no2-imgbox">
                                    <div class="hot-no2-img">
                                        <a href="javascript:;">
                                            <img src="${pageContext.request.contextPath}/public/image/index-img/15_avatar_big.jpg" alt="">
                                        </a>
                                    </div>
                                    <div class="hot-no2-imgno">3</div>
                                </div>

                            </div>
                            <div class="fl hot-no2-play">
                                <div class="hot-no2-nm">小太阳♚德芙</div>
                                <div class="hot-no2-Grade">
                                    <img src="${pageContext.request.contextPath}/public/image/index-img/charm_16.png" alt="">
                                </div>
                            </div>
                            <div class="fr hot-no2-information">
                                <div class="hot-no2-address fl">六安市</div>
                                <div class="hot-no2-age fl">♀ 24</div>
                                <div class="clearfix"></div>
                                <div class="hot-no2-sig">接单:105次</div>
                            </div>
                        </div>
                        <div class="list-hot-no2">
                            <div class="fl">
                                <div class="hot-no2-imgbox">
                                    <div class="hot-no2-img">
                                        <a href="javascript:;">
                                            <img src="${pageContext.request.contextPath}/public/image/index-img/15_avatar_big.jpg" alt="">
                                        </a>
                                    </div>
                                    <div class="hot-no2-imgno">3</div>
                                </div>

                            </div>
                            <div class="fl hot-no2-play">
                                <div class="hot-no2-nm">小太阳♚德芙</div>
                                <div class="hot-no2-Grade">
                                    <img src="${pageContext.request.contextPath}/public/image/index-img/charm_16.png" alt="">
                                </div>
                            </div>
                            <div class="fr hot-no2-information">
                                <div class="hot-no2-address fl">六安市</div>
                                <div class="hot-no2-age fl">♀ 24</div>
                                <div class="clearfix"></div>
                                <div class="hot-no2-sig">接单:105次</div>
                            </div>
                        </div>
                        <div class="list-hot-no2">
                            <div class="fl">
                                <div class="hot-no2-imgbox">
                                    <div class="hot-no2-img">
                                        <a href="javascript:;">
                                            <img src="${pageContext.request.contextPath}/public/image/index-img/15_avatar_big.jpg" alt="">
                                        </a>
                                    </div>
                                    <div class="hot-no2-imgno">3</div>
                                </div>

                            </div>
                            <div class="fl hot-no2-play">
                                <div class="hot-no2-nm">小太阳♚德芙</div>
                                <div class="hot-no2-Grade">
                                    <img src="${pageContext.request.contextPath}/public/image/index-img/charm_16.png" alt="">
                                </div>
                            </div>
                            <div class="fr hot-no2-information">
                                <div class="hot-no2-address fl">六安市</div>
                                <div class="hot-no2-age fl">♀ 24</div>
                                <div class="clearfix"></div>
                                <div class="hot-no2-sig">接单:105次</div>
                            </div>
                        </div>
                        <div class="list-hot-no2">
                            <div class="fl">
                                <div class="hot-no2-imgbox">
                                    <div class="hot-no2-img">
                                        <a href="javascript:;">
                                            <img src="${pageContext.request.contextPath}/public/image/index-img/15_avatar_big.jpg" alt="">
                                        </a>
                                    </div>
                                    <div class="hot-no2-imgno">3</div>
                                </div>

                            </div>
                            <div class="fl hot-no2-play">
                                <div class="hot-no2-nm">小太阳♚德芙</div>
                                <div class="hot-no2-Grade">
                                    <img src="${pageContext.request.contextPath}/public/image/index-img/charm_16.png" alt="">
                                </div>
                            </div>
                            <div class="fr hot-no2-information">
                                <div class="hot-no2-address fl">六安市</div>
                                <div class="hot-no2-age fl">♀ 24</div>
                                <div class="clearfix"></div>
                                <div class="hot-no2-sig">接单:105次</div>
                            </div>
                        </div>
                    </div>
                    <!--热度榜的总榜-->
                    <div class="list-hot-total">
                      <div class="list-hot-no1">
                            <div class="hot-no1-head">
                                <a href="javascript:;">
                                    <img src="${pageContext.request.contextPath}/public/image/index-img/40_avatar_big.jpg" alt="">
                                </a>
                                <div class="hot-no1-head2">
                                    <div class="no1-head2-num">2</div>
                                </div>
                                <div class="no1-head2-bottom">
                                    <div class="no1-head2-bottom-text">
                                        <p class="head2-bottom-name">♚可爱萌♚</p>
                                        <span class="head2-bottom-address">南京市</span>
                                        <span class="head2-bottom-cs">接单:123次</span>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="list-hot-no2">
                            <div class="fl">
                                <div class="hot-no2-imgbox">
                                    <div class="hot-no2-img">
                                        <a href="javascript:;">
                                            <img src="${pageContext.request.contextPath}/public/image/index-img/15_avatar_big.jpg" alt="">
                                        </a>
                                    </div>
                                    <div class="hot-no2-imgno">3</div>
                                </div>

                            </div>
                            <div class="fl hot-no2-play">
                                <div class="hot-no2-nm">小太阳♚德芙</div>
                                <div class="hot-no2-Grade">
                                    <img src="${pageContext.request.contextPath}/public/image/index-img/charm_16.png" alt="">
                                </div>
                            </div>
                            <div class="fr hot-no2-information">
                                <div class="hot-no2-address fl">六安市</div>
                                <div class="hot-no2-age-2 fl">♀ 24</div>
                                <div class="clearfix"></div>
                                <div class="hot-no2-sig">接单:105次</div>
                            </div>
                        </div>
                    </div>
                </div>
                <!--礼物榜模块-->
                <div class="list-hot">
                   <!-- 礼物榜字体-->
                    <div class="list-hot-title">
                        <i class="date-icon gift"></i>
                        礼物榜
                    </div>
                    <!--礼物周榜和总榜切换字体-->
                    <div class="list-hot-font">
                        <div class="list-hot-font-week list-hot-font-color gift-week">周榜</div>
                        <div class="list-hot-font-all gift-total">总榜</div>
                    </div>
                    <!--礼物周榜切换-->
                    <div class="list-gift-week">

                    </div>
                    <!--礼物总榜切换-->
                    <div class="list-gift-total">

                    </div>
                </div>
                <!--富豪榜模块-->
                <div class="list-hot">
                    <!--富豪榜的图标字体-->
                    <div class="list-hot-title">
                        <i class="date-icon rich"></i>
                        富豪榜
                    </div>
                    <!--富豪榜的周榜和总榜切换字体-->
                    <div class="list-hot-font">
                        <div class="list-hot-font-week list-hot-font-color rich-week">周榜</div>
                        <div class="list-hot-font-all rich-total">总榜</div>
                    </div>
                    <div class="list-rich-week">

                    </div>
                    <div class="list-rich-total">

                    </div>
                </div>
            </div>
            <!--------------------底部------------------------>
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
    </div>
</div>
</body>
<script src="../js/index.js"></script>
</html>