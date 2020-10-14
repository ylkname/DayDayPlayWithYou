/*-----------------页面载入时------------*/
//获取陪玩id
let iD=localStorage.ID;
//获取用户id
let uId=localStorage.myID;
// let iD=111111;
// let uId=111117;
$('.t2-div1').text(`ID：${iD}`);
//清空
localStorage.clear();
// 创建评论ul
function createUl(Json){
    var oUl=$("<ul class='every clearfix'></ul>");
    oUl.html(`  <li class="every-one">
                        <div>
                            <img src="${Json.a}" alt="" class="Uphoto">
                        </div>
                    </li>
                    <li>
                        <div class="nick">
                            <span>${Json.b}</span>
                            <div class="dj">
                                <img src="${Json.c}" alt="">
                            </div>
                            <div class="xx clearfix">
                                <i></i>
                                <i></i>
                                <i></i>
                                <i></i>
                                <i></i>
                            </div>
                        </div>
                        <div class="txt1">
                            <div class="text">${Json.d}</div>
                        </div>
                        <div class="s1">${Json.e}</div>
                    </li>`);
    $('.every-box').prepend(oUl);
};
// 创建礼物ul
function createUl2(Json2){
    var oUl=$("<ul class='every clearfix'></ul>");
    oUl.html(`<li class="every-one">
                                <div>
                                    <img src="${Json2.a}" alt="" class="Uphoto">
                                </div>
                            </li>
                            <li>
                                <div class="nick">
                                    <span>${Json2.b}</span>
                                    <div class="dj">
                                        <img src="${Json2.c}" alt="">
                                    </div>
                                    <div class="lll">
                                        <span class="lll-s1">赠送</span>
                                        <img src="${Json2.d}" alt="">
                                        <span class="lll-s2">X 1</span>
                                    </div>
                                </div>

                                <div class="s1">${Json2.e}</div>

                            </li>`);
    $('#right-bottom-below').prepend(oUl);
};
var iNow=1;
/*----------------------页面载入时获取陪玩信息------------------*/

$(document).ready(function () {
    $.ajax({
        url: '/player',
        type: 'post',
        data: {
            id: iD,
        },
        success: function (res) {
            $('.pic-p img').attr("src",res.data[0].U_photo);
            $('.t1-span').text(res.data[0].U_falsename);
            $('.middle-top-span').text(res.data[0].U_falsename);

            $('.big-pic img').attr("src", res.data[0].U_pic);
            $('.small-ul-li1 img').attr("src",res.data[0].U_pic);
            $('.small-ul-li2 img').attr("src",res.data[0].U_pic2);
            $('.small-ul-li3 img').attr("src",res.data[0].U_pic3);
            $('.small-ul-li4 img').attr("src",res.data[0].U_pic4);
            $('.small-ul-li5 img').attr("src",res.data[0].U_pic5);


            // $('.img1').attr("src", res.送礼物前七个U-photo);
            // $('.zlb-div-one img').attr("src".res.接收的礼物地址);
            // $('.zlb-div-one span').html(res.礼物数量);

        }
    });
});
/*----------------评论---------------------*/
function pageCon() {
    $.ajax({
        url: '/pl',
        type: 'post',
        data: {
            id: iD,
        },
        success:function (res) {
            // var uid=res.data[0].;
           for (let i=0;i<res.data.length;i++){
               var udata=res.data[i].EV_sec;
               var udate=res.data[i].EV_datetimes;
               var uPhoto=res.data[i].U_photo;
               var uFalsename=res.data[i].U_falsename;
               json={
                   a:uPhoto,
                   b:uFalsename,
                   d:udata,
                   e:udate,
               };
               if (res.error){
                   alert('展示失败')
               }else {
                       createUl(json)
               }
           }
            $('.below-span-one').text(`评论次数(${res.data.length})`)
                },

    });

};
pageCon();
/*------------------分页------------------------*/

function getPage () {
    $.ajax({
        url: '/getPage',
        type: 'post',
        data: {
            id : iD,
        },
        success:function (res) {
            if (res.error){
                alert('获取页码失败')
            }else {
                for (var i=1;i<=res.num;i++){
                    var oA=$("<a href=\"\" class=\"\"></a>");
                    $(oA[0]).html(i);
                    if (i==iNow){
                        $(oA[0]).addClass('page0')
                    }
                    $('.page').append(oA)
                }
            }
        }
    })
};
getPage();
/*---------------------礼物分页--------------------*/
function getPage2 () {
    $.ajax({
        url: '/getPage2',
        type: 'post',
        data: {
            id : iD,
        },
        success:function (res) {
            if (res.error){
                alert('获取页码失败')
            }else {
                for (var i=1;i<=res.num;i++){
                    var oA=$("<a href='javascrip:;' class=\"\" ></a>");
                    $(oA[0]).html(i);
                    if (i==iNow){
                        $(oA[0]).addClass('page0')
                    }
                    $('.page1').append(oA)
                }
            }
        }
    })
};
getPage2();
/*---------------------点击切换评论页面-----------------------*/
$('.page').on('click','.page a',function () {
    var oA=$('.page a');
    if ($(this)=='A'){
        $(this).html(iNow);
        for (var i=0;i<oA.length;i++){
            $(oA[i]).addClass('')
        }
        $(this).addClass('page0');
        pageCon()
    }
});
/*--------------------礼物选项卡展示-----------------*/
function pageLw() {

    $.ajax({
        url: '/pageLw',
        type: 'post',
        data: {
            id: iD,
            num:iNow,
        },
        success:function (res) {

            for (let i=0;i<res.data.length;i++){
                // var uid=res.data[i].GF_uid;
                // var udata=res.data[i].GA_src;
                // var udate=res.data[i].GF_data;
                json2={
                    a:res.data[i].U_photo,
                    b:res.data[i].U_falsename,
                    // c:res.data[i].LE_src,
                    d:res.data[i].GA_src,
                    e:res.data[i].GF_data,
                };
                if (res.error){
                    alert('展示失败')
                }else {
                    // $('#right-bottom-below').html('');
                    // for (let j=0;j<res.data.length;j++){
                    createUl2(json2)
                    // }
                }
            }
        }
    });
};
pageLw();
/*------------------点击获取礼物分页数据-------------------*/

$('.page1').on('click',this,function () {
        console.log(this)
    var oA=$('this a');
    if ($(this)=='A'){
        $(this).html(iNow);
        for (var i=0;i<oA.length;i++){
            $(oA[i]).addClass('')
        }
        $(this).addClass('page0');
        pageLw()
    }
});

/*----------------------关注----------------------*/
$(document).ready(function () {
    $.ajax({
        url: '/guanzhu',
        type: 'post',
        data: {
            id: iD,
        },
        success:function (res) {
            $('.guanzhu').html(res.data[0].a);
            for (let i=0;i<res.data.length;i++){
                if (res.data[i].FO_uid==uId){
                    $('.gz-p1').css({
                        'display': 'none'
                    });
                    $('.gz-p2').css({
                        'display': 'block'
                    });
                    return
                }
            }
        }
    })
});
/*---------------------游戏详情展示--------------------*/
$(document).ready(function () {
    $.ajax({
        url: '/game',
        type: 'post',
        data: {
            id: iD,
        },
        success:function (res) {
            var oSpan3=$('.d1-s2');
            var oP=$('.d2-p');
            var oDiv3=$('.zwjs-div');
            var oImg=$('.game-img');
            for (var i=0;i<res.data.length;i++){
                var oDiv=$("<div class=\"yx-name-one\">\n" +
                    "                                        <span class='yx-s1'></span>\n" +
                    "                                        <span class=\"yx-s2\"></span>\n" +
                    "                                    </div>");
                $('.yx-name').append(oDiv);
                var oS=$('.ljxd');
               $(oS[i]).attr('aaa',res.data[i].G_id);
                var oSpan=$('.yx-s1');
                $(oSpan[i]).text(res.data[i].G_names);
                $(oSpan3[i]).text(res.data[i].PU_price);
                $(oP[i]).text(res.data[i].PU_level);
                $(oDiv3[i]).text(res.data[i].PU_text);
                 //$(oImg[i]).attr("src",res.data[i].G_src);
            }
            var oDiv2=$('.yx-name-one');
            var oSpan2=$('.yx-s2');
            $(oSpan2[0]).addClass('yx-block');
            $(oDiv2[0]).addClass('yx-name-two');
        }
    });
    $.ajax({
        url: '/cishu',
        type: 'post',
        data: {
            id: 'iD',
        },
        success:function (res) {
            $('.d3-span').text(`接单次数：${res.data[0].COUNT}`);
        }
    })
});

/*----------------------礼物展示----------------------*/
$(document).ready(function () {
    $.ajax({
        url: '/lw',
        type: 'post',
        success:function (res) {
            var oImg=$('.lw-ul-img1');
            var oImg1=$('.xq-one');
            var oSpan=$('.lw-span span');
            var oSpan2=$('.lw-name');
            for (let i=0;i<res.data.length;i++) {
                $(oImg[i]).attr("src",res.data[i].GA_src);
                $(oImg1[i]).attr("src",res.data[i].GA_src);
                $(oSpan[i]).text(res.data[i].GA_price);
                $(oSpan2[i]).text(res.data[i].GA_name);
            }
        }
    });
});

/*---------------------礼物排行榜-----------------*/
$(document).ready(function () {
   $.ajax({
       url:'/ranking',
       type:'post',
       data: {
           id: iD,
       },
       success:function (res) {
           for (var i=0;i<res.data.length;i++){
               $('.list').append(
                   `
                    <li>
                                <i class="num">
                                    <i class="num-one">
                                        <i class="num-two">${i+1}</i>
                                    </i>
                                </i>
                                <div class="tx">
                                    <img src="${res.data[i].U_photo}" alt="">
                                    <p></p>
                                </div>
                                <div class="tx2">
                                    <span>${res.data[i].U_names}</span>
                                    <div class="tx2-div">
                                        <img src="" alt="">
                                    </div>
                                </div>
                                <div class="tx3">
                                    <div class="tx3-div">
                                        <div class="tx3-one">
                                            <span class="one-s1">贡献：</span>
                                            <span class="one-s2">${res.data[i].money}</span>
                                        </div>
                                    </div>
                                </div>
                            </li>
                   `
               );
               $('.zlb-ul').append(`
                    <li>
                                <div class="zlb-ul-div1">
                                    <i></i>
                                    <img src="${res.data[i].U_photo}" alt="" class="img1">
                                    <img src="" alt="" class="img2">
                                </div>
                                <div class="zlb-ul-div2">${res.data[i].U_names}</div>
                                <div class="zlb-ul-div3">
                                    <img src="../image/picture/hx.png" alt="">
                                    <span>${res.data[i].money}</span>
                                </div>
                            </li>
               `)
           }
       }
   })
});
/*-------------滚动播放-----------------*/

setInterval(function () {
    let mt = $('.box-two ul li')[0].style.marginTop;
    let oS = mt.split('p')[0];
    let oLi = $('.box-two ul li');
    if (oS == -19) {
        $('.box-two ul')[0].removeChild(oLi[0]);
        oLi[0].style.marginTop = '';
        $('.box-two ul')[0].appendChild(oLi[0])
    }
}, 2000);

setInterval(function () {
    let oLi = $('.box-two ul li');
    $('.box-two ul').find(oLi.first()).animate({marginTop: '-19px'}, 500)
}, 2000);


/*----------------陪玩图片展示--------------*/

$(".small-ul li img").hover(
    function () {
        $(this).css("border", "solid 1px #010000");
        var tsrc = $(this).attr("src");
        $('.big-pic img').attr("src", tsrc)
    },
    function () {
        $(this).css("border", "solid 1px #fff");
    }
);


/*------------------关注------------------------*/
/*   var n=false;
   $('.gz-p1').click(function () {
       if (n==false){
           $('.gz-p1').css({"background":"#d7d7d7","color":"#666"});
           $('.gz-p1 span').html('已关注');
           return n=true
       } else {
           $('.gz-p1').css({"background":"#ff4d80","color":"#fff"});
           $('.gz-p1 span').html('关注');
           return n=false
       }
   });*/

$(document).ready(function () {
    if ($('.gz-p1').css('display') == 'block') {

    }
    $('.gz-p1').click(function () {
        $(this).css({
            'display': 'none'
        });
        $('.gz-p2').css({
            'display': 'block'
        });
        $.ajax({
            url:'/follow',
            type:'post',
            data:{
                id:iD,
                uid:uId
            },
            success:function (res) {
                if (res.error==0){
                    alert('关注成功');
                    $('.guanzhu').html(Number($('.guanzhu').html())+1)
                }
            }
        });
    });
    $('.gz-p2').click(function () {
        $(this).css({
            'display': 'none'
        });
        $('.gz-p1').css({
            'display': 'block'
        });
        $.ajax({
            url:'/follow2',
            type:'post',
            data:{
                id:iD,
                uid:uId
            },
            success:function (res) {
                if (res.error==0){
                    alert('取消关注成功')
                    $('.guanzhu').html(Number($('.guanzhu').html())-1)
                }
            }
        });
    });
});

/*------------------向左向右-------------------*/

$(document).ready(function () {
    var n=0;
    //右
    $('.zlb-you').click(function () {
        var  oDiv=$('.zlb-div-div1');
        n++;
        oDiv.css("left",-n*78+"px");
        var oDiv1=$('.zlb-div-one');
        if (oDiv1.length-7<=n){
            oDiv.css("left",-(oDiv1.length-7)*78+"px");
            n=oDiv1.length-7
        }
    });
    //左
    $('.zlb-zuo').click(function () {
        var  oDiv=$('.zlb-div-div1');
        n--;
        oDiv.css("left",-n*78+"px");
        var oDiv1=$('.zlb-div-one');
        if (n<=0){
            oDiv.css("left",0+"px");
            n=0
        }
    });
});

/*---------------------游戏类型选项卡---------------*/
$('.yx-name').on('click','.yx-name-one',function () {
    $('.yx-name-one').removeClass('yx-name-two');
    $('.yx-s2').removeClass('yx-block');
    $('.yx-lx').removeClass('yx-game-name');

    $(this).addClass('yx-name-two');
    $('.yx-s2').eq($(this).index()).addClass('yx-block');
    $('.yx-lx').eq($(this).index()).addClass('yx-game-name');
});

/*-----------------单数加减-----------------------*/
$('.jia').click(function () {
    var str=$('.cs-inp').val();
    $('.cs-inp').val(parseInt(str)+1)
});
$('.jian').click(function () {
    var str=$('.cs-inp').val();
    $('.cs-inp').val(parseInt(str)-1);
    if ($('.cs-inp').val()<=1){
        $('.cs-inp').val(1)
    }
});
/*----------------------评论选项卡---------------*/
$('.above-s1').click(function () {
    $('.above-s1').removeClass('a');
    $('.right-bottom-below').removeClass('right-bottom-div');

    $(this).addClass('a');
    $('.right-bottom-below').eq($(this).index()).addClass('right-bottom-div')
});
/*------------------------------------------------*/
//礼物移入效果
$('.lw-ul li').mouseover(function () {
    $(this).children('div').css("display", "block")
});
$('.lw-ul li').mouseout(function () {
    $(this).children('div').css("display", "none")
});
/*---------------------赠送礼物-------------*/
$('.lw-zs').click(function () {
    var Html=$(this).parent().prev().prev().html();

    var datetime = new Date()
    var year = datetime.getFullYear();
    var month = datetime.getMonth()+1;//js从0开始取
    var date = datetime.getDate();
    var hour = datetime.getHours();
    var minutes = datetime.getMinutes();
    var second = datetime.getSeconds();

    if(month<10){
        month = "0" + month;
    }
    if(date<10){
        date = "0" + date;
    }
    if(hour <10){
        hour = "0" + hour;
    }
    if(minutes <10){
        minutes = "0" + minutes;
    }
    if(second <10){
        second = "0" + second ;
    }

    var time = year+"-"+month+"-"+date+" "+hour+":"+minutes+":"+second;

    $.ajax({
        url:'/lwGive',
        type:'post',
        data:{
            uid:uId,
            id:iD,
            name:Html,
            date:time,
            num:$('.lw-gs input').val(),
        },
        success:function (res) {
            if (res.error==0) {
                alert('赠送成功')
            }
        }
    })
});
//点单
$('.ljxd').click(function () {
    var gId=$(this).attr('aaa');
    // var num=$('.cs-inp').val();
    localStorage.setItem("ID",iD) ;
    localStorage.setItem("myID",uId);
    localStorage.setItem("Gid",gId);
    // $(location).attr('href', 'http://localhost:5000/page/order.html')
    location.href='http://localhost:5000/page/order.html';
});