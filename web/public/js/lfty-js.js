//localstorage




//筛选点击事件
$(function () {
    const mytitle = document.querySelector(".crumbs-nav h1")

    $('.info-box .right-box ul.game ').on('click', 'li', function () {
        $(this).addClass('active3').siblings().removeClass('active3');
        var index = $(this).index();
        if (nowHighLight) {
            nowHighLight.style.opacity = '0'
        }
        $(this).eq(index).addClass('active3').siblings().removeClass('active3');

        nowHighLight = this.querySelector(".img2")
        mytitle.innerText = this.querySelector("p").innerText + "陪玩"
        nowHighLight.style.opacity = "1"
        $('.info .info-box .right-box.style3 ul').eq(index).addClass('on').siblings().removeClass('on')
    })
});
$(function () {

})

nowHighLight = null

$(function () {
    $('#screening div').click(function () {
        $(this).addClass('active-1').siblings().removeClass('active-1');

        var index = $(this).index();
        $(this).parent().siblings().children().eq(index).addClass("active-1")
            .siblings().removeClass("active-1");
    });
});

$(function () {
    $('.right-box .style2  li').click(function () {
        $(this).addClass('active').siblings().removeClass('active');
        var index = $(this).index();
        $(this).parent().siblings().children().eq(index).addClass('active').siblings().removeClass('active');
    })
});
/*ajax请求
* 接口名称：游戏图标
  /gamepic
参数：{游戏图片，游戏名称，游戏等级}
方式get
返回值{error:0}
*
*
* */
$.ajax({
    url: '/gamepic',
    type: 'get',
    data: {
        id: 'G_id'
    },
    success: function (res) {
        for (var i = 0; i < res.data.length; i++) {
            $('.game').append(`
            <li class="active ">
                            <a href="javascript:;">
                                <div class="pic-1" title="${res.data[i].G_names}陪玩">
                                    <img src="${res.data[i].G_src2}" class="img1">
                                    <img src="${res.data[i].G_src3}" class="img2">
                                </div>
                            </a>
                            <p>${res.data[i].G_names}</p>
                        </li>
        `)
        }
        nowHighLight = document.querySelectorAll('.game li')[0].querySelector(".img2")
        nowHighLight.style.opacity = "1"
    }
});

/*
* 接口名称：游戏筛选
/gameChance
参数：{游戏等级}
方式post
返回值{error:0}
* */
$.ajax({
    url: '/gameChance',
    type: 'post',
    data: {
        id: 'U_id'
    },
    success: function (res) {
        if(!res.error){
for (var i=0;i<res.data.length;i++) {
    if (res.data[i].G_names === '英雄联盟') {
    createPic(res.data[i].U_photo,res.data[i].U_falsename,res.data[i].PU_level,res.data[i].PU_price,res.data[i].U_id)
    }}

            $('.info-box .right-box ul.game ').on('click', 'li', function () {
    $('.photo-content').html('')
                    for (var i = 0; i < res.data.length; i++) {
                        if ($('li.active3').children('p').text() === res.data[i].G_names){
                            createPic(res.data[i].U_photo,res.data[i].U_falsename,res.data[i].PU_level,res.data[i].PU_price,res.data[i].U_id)
                    }
                }
            })
            $('.style2').on('click','li',function (e) {

                    let html = e.toElement.innerHTML;
                    $('.photo-content').html('')
                    for (var i = 0; i < res.data.length; i++) {
                        if (html === res.data[i].PU_level && $('li.active3').children('p').text() === res.data[i].G_names) {
                            createPic(res.data[i].U_photo, res.data[i].U_falsename, res.data[i].PU_level, res.data[i].PU_price,res.data[i].U_id)
                        }else if (html ==='不限' && $('li.active3').children('p').text() === res.data[i].G_names) {
                            createPic(res.data[i].U_photo, res.data[i].U_falsename, res.data[i].PU_level, res.data[i].PU_price,res.data[i].U_id)
                        }
                    }

            })
        }


    }
});
//localstorage
function beforeDsend1(id){
    console.log(id);
    let storage=window.localStorage;

    storage.setItem('ID',id);
    JSON.parse(storage.ID)
}
/*接口名称;价格筛选
/entryMoney
参数：{陪玩的游戏价格从高到低时间}
方式post
返回值{error:0}
* */
/*$.ajax({
    url:'/entryMoney',
    type:'post',

    success:function (res) {
        if (!res.error) {

        }
    }
});*/
/*
接口名称:人气榜单
/playtime
参数：{头像，昵称，陪玩时长}
方式post
返回值{error:0}
* */
$.ajax({
    url: '/headK',
    type: 'get',
    data: {
        id: 'U_id'
    },
    success: function (res) {
        if (!res.error) {
            for (var i = 0; i < res.data.length; i++) {
                createList('.list-box2',res.data[i].U_photo, res.data[i].U_falsename,'接单数',res.data[i].COUNT)

            }
        }
    }
});
/********************榜单头像框*********************************/
/*
   接口名称:榜单排行头像框
/playtime
参数：{头像，昵称，陪玩时长}
方式post
返回值{error:0}
   * */
$.ajax({
    url: '/headK2',
    data: {
        id: 'ph_co'
    },
    success: function (res) {
        for (var i = 0; i < res.data.length; i++) {


            $($('.pic-box')[i]).append(
                ` 
        <img src="${res.data[i].ph_pic}" alt="" class="mask">
            `
            )
        }
    }
});
/********************创建个人版块*********************************/
//创建个人版块
createPic=function (photo,name,level,price,id) {

    $('.photo-content').append(`
               <a href="javascript:;" class="exhibition person" onclick="beforeDsend1(${id})" >
                            <div class="ex-photo-area">
                                <div class="ex-photo">
                                    <img src="${photo}" alt="" class="pic-2">
                                    <i></i>
                                </div>
                                <div class="text-box">
                                    <div class="tx1">
                                        <div class="tx1-anchor-name">
                                            <span>${name}</span>
                                            <p>${level}</p>
                                        </div>
                                    </div>
                                    <div class="tx2">
                                        <div>
                                            <p class="on-line">
                                                <i></i>
                                                <span>在线</span>
                                            </p>
                                        </div>
                                        <p class="price">
                                            <span>￥${price}</span>/小时
                                        </p>
                                    </div>
                                </div>
                            </div>
                        </a>
               `)
};
/********************创建周榜*********************************/
//创建周榜展示
createList=function(url,photo,falseName,name,count){
    $(url).append(
        `

        <div class="list style1">
        <a href="" class="pic-box">
        <img src="${photo}" alt="" class="pic-3">

        </a>
        <div class="txt">
        <div class="one-txt-cut">
        ${falseName}
        </div>
        <p>
        ${name}:
<span>${count}</span>
    </p>
    </div>
    </div>
        `
    )

}
/********************魅力值周榜*********************************/
/* 魅力榜
 接口名称:榜单排行头像框
/charm
参数：{头像，昵称，陪玩时长}
方式post
返回值{error:0}

* */
$.ajax({
    url:'/charm',
    type:'post',
    data:{
        id:'U_id'
    },
    success:function (res) {
        for (var i=0;i<res.data.length;i++) {
            createList('.list-box3',res.data[i].U_photo, res.data[i].U_falsename,'魅力值',res.data[i].money)
        }

    }
})