//轮播图
var mySwiper = new Swiper('.swiper-container', {
    direction: 'horizontal', // 垂直切换选项
    loop: true, // 循环模式选项
    effect: 'fade',//切换效果
    //自动切换
    autoplay: {
        delay: 3000,
        stopOnLastSlide: false,
        disableOnInteraction: false,

    },
    // 如果需要分页器
    pagination: {
        el: '.swiper-pagination',
        dynamicBullets: 'true',

    },
    // 如果需要前进后退按钮
    navigation: {
        nextEl: '.swiper-button-next',
        prevEl: '.swiper-button-prev',
    }
});
//热度总榜和周榜切换
$('.hot-total').click(function () {
    $('.hot-week').removeClass('list-hot-font-color');
    $('.hot-total').addClass('list-hot-font-color');
    $('.list-hot-week').css('display','none');
    $('.list-hot-total').css('display','block')
});
$('.hot-week').click(function () {
    $('.hot-total').removeClass('list-hot-font-color');
    $('.hot-week').addClass('list-hot-font-color');
    $('.list-hot-week').css('display','block');
    $('.list-hot-total').css('display','none')
});
//礼物总榜和周榜切换
$('.gift-total').click(function () {
    $('.gift-week').removeClass('list-hot-font-color');
    $('.gift-total').addClass('list-hot-font-color');
    $('.list-gift-week').css('display','none');
    $('.list-gift-total').css('display','block')
});
$('.gift-week').click(function () {
    $('.gift-total').removeClass('list-hot-font-color');
    $('.gift-week').addClass('list-hot-font-color')
    $('.list-gift-week').css('display','block')
    $('.list-gift-total').css('display','none')
});
//富豪总榜和周榜切换
$('.rich-total').click(function () {
    $('.rich-week').removeClass('list-hot-font-color');
    $('.rich-total').addClass('list-hot-font-color');
    $('.list-rich-week').css('display','none');
    $('.list-rich-total').css('display','block')
});
$('.rich-week').click(function () {
    $('.rich-total').removeClass('list-hot-font-color');
    $('.rich-week').addClass('list-hot-font-color');
    $('.list-rich-week').css('display','block');
    $('.list-rich-total').css('display','none')
});
//ajax接口
//1.游戏分类展示
$.ajax({
    url:'/getgame',
    type:'post',
    success:function (res) {

        if (res.error){

        }else{
            $('.flol').text(res.data[0].G_names);
            $('.lol').css('background-image','url('+res.data[0].G_src+')');
            $('.fpubg').text(res.data[1].G_names);
            $('.pubg').css('background-image','url('+res.data[1].G_src+')');
            $('.fhizi').text(res.data[3].G_names);
            $('.hizi').css('background-image','url('+res.data[3].G_src+')');
            $('.faudio').text(res.data[2].G_names);
            $('.audio').css('background-image','url('+res.data[2].G_src+')');
            $('.ffive').text(res.data[4].G_names);
            $('.five').css('background-image','url('+res.data[4].G_src+')');
        }
    }
});

//3.爱的推荐
$.ajax({
    url:'/getRecommend',
    type:'post',
    success:function (res) {
        if (res.error){

        } else {
            $('.date-Recommend-img-font-left').text(res.data[0].U_falsename);
            $('.date-Recommend-img-left').children('img').attr('src',`${res.data[0].U_photo}`);
            $('.date-Recommend-img-font-right').text(res.data[1].U_falsename);
            $('.date-Recommend-img-right').children('img').attr('src',`${res.data[1].U_photo}`);
        }
    }
});

//热门推荐
$.ajax({
        url:'/getHot',
        type:'post',
        success:function (res) {
            if (res.error){

            } else {
                for (var i=0;i<res.data.length;i++){
                    $('.index-hot-img').append(`<div class="hot-img-box">
                        <a href="detail.html" onclick="hotclick(${res.data[i].U_id})">
                            <img class="hot-img" src="${res.data[i].U_pic}" alt="">
                            <div class="hot-font">
                                <div class="hot-font-top">
                                     ${res.data[i].U_falsename}
                                    
                                </div>
                                <div class="hot-font-bottom">
                                    <div class="font-bottom-gametype">${res.data[i].G_names}</div>
                                    <div class="font-bottom-Price">
                                        <span>${res.data[i].PU_price}</span>
                                        元 / 小时
                                    </div>
                                </div>
                            </div>
                        </a>
                    </div>`)
                }
            }
        }
    });




//热门推荐点击换一批
$('.hot-icon-font2').click(function () {
    $('.index-hot-img').html('');
    $.ajax({
        url:'/getHot',
        type:'post',
        success:function (res) {
            if (res.error){

            } else {
                for (var i=0;i<res.data.length;i++){
                    $('.index-hot-img').append(`<div class="hot-img-box">
                        <a href="javascript:;" onclick="hotclick(${res.data[i].U_id})">
                            <img class="hot-img" src="${res.data[i].U_pic}" alt="">
                            <div class="hot-font">
                                <div class="hot-font-top">
                                     ${res.data[i].U_falsename}
                                    
                                </div>
                                <div class="hot-font-bottom">
                                    <div class="font-bottom-gametype">${res.data[i].G_names}</div>
                                    <div class="font-bottom-Price">
                                        <span>${res.data[i].PU_price}</span>
                                        元 / 小时
                                    </div>
                                </div>
                            </div>
                        </a>
                    </div>`)
                }
            }
        }
    });
});

//新秀推荐
$.ajax({
    url:'/getnewstar',
    type:'post',
    success:function (res) {

        if (res.error){

        } else {

            for(var i=0;i<res.data.length;i++){
                if (res.data[i].U_sex==='女'){
                   var ax='♀';
                }else {
                  var ax='♂';
                }

                $('.newstar-bigfont-right').append(`<div class="newstar-img-box">
                        <a href="javascript:;">
                            <div class="newstar-img" onclick="hotclick(${res.data[i].U_id})">
                                <img src="${res.data[i].U_photo}" alt="">
                            </div>
                            <div class="newstar-name">${res.data[i].U_falsename}</div>
                            <div class="newstar-address">${res.data[i].U_address}</div>
                            <div class="newstar-age">${ax}&nbsp;${res.data[i].U_age}</div>
                        </a>
                    </div>`)
            }
            for(var i=0;i<res.data.length;i++){
                if (res.data[i].U_sex==='女'){
                    $('.newstar-age').eq(i).css({'background':'#ffabad'})
                }else {
                    $('.newstar-age').eq(i).css({'background':'#97bcf0'})
                }
            }

        }
    }
});

//热度榜周榜
$.ajax({
    url: '/getHotweek',
    type: 'post',
    success: function (res) {
        if (res.error) {

        } else {
                for (var i=0;i<2;i++){
                    var num=i+1;
                    $('.list-hot-week').append(`
                 <div class="list-hot-no1">
                            <div class="hot-no1-head">
                                <a href="javascript:;"  onclick="hotclick(${res.data[i].U_id})">
                                    <img src="${res.data[i].U_photo}" alt="">
                                </a>
                                <div class="hot-no1-head2">
                                    <div class="no1-head2-num">${num}</div>
                                </div>
                                <div class="no1-head2-bottom">
                                    <div class="no1-head2-bottom-text">
                                        <p class="head2-bottom-name">${res.data[i].U_falsename}</p>
                                        <span class="head2-bottom-address">${res.data[i].U_address}</span>
                                        <span class="head2-bottom-cs">接单:${res.data[i].count}次</span>
                                    </div>
                                </div>
                            </div>
                        </div>
                `)
                    return
                }
                for (var j=2;j<res.data.length;j++){
                    if (res.data[j].U_sex==='女'){
                        ax='♀';
                    }else {
                        ax='♂';
                    }
                    var num=j+1;
                    $('.list-hot-week').append(`
                        <div class="list-hot-no2">
                            <div class="fl">
                                <div class="hot-no2-imgbox">
                                    <div class="hot-no2-img">
                                        <a href="javascript:;"   onclick="hotclick(${res.data[j].U_id})">
                                            <img src="${res.data[j].U_photo}" alt="">
                                        </a>
                                    </div>
                                    <div class="hot-no2-imgno">${num}</div>
                                </div>

                            </div>
                            <div class="fl hot-no2-play">
                                <div class="hot-no2-nm">${res.data[j].U_falsename}</div>
                                <div class="hot-no2-Grade">
                                    
                                </div>
                            </div>
                            <div class="fr hot-no2-information">
                                <div class="hot-no2-address fl">${res.data[j].U_address}</div>
                                <div class="hot-no2-age fl">${ax} ${res.data[j].U_age}</div>
                                <div class="clearfix"></div>
                                <div class="hot-no2-sig">接单:${res.data[j].count}次</div>
                            </div>
                        </div>
`)
                }
                for(var i=2;i<res.data.length;i++){
                    var s=i-2;
                    if (res.data[i].U_sex==='女'){

                        $('.hot-no2-age').eq(s).css({'background':'#ffabad'})
                    }else {
                        $('.hot-no2-age').eq(s).css({'background':'#97bcf0'})
                    }
                }

        }
    }
});
//热度榜总榜
$.ajax({
    url: '/getHottotal',
    type: 'post',
    success: function (res) {
        if (res.error) {

        } else {
            for (var i=0;i<2;i++){
                var num=i+1;
                $('.list-hot-total').append(`
                 <div class="list-hot-no1">
                            <div class="hot-no1-head">
                                <a href="javascript:;"   onclick="hotclick(${res.data[i].U_id})">
                                    <img src="${res.data[i].U_photo}" alt="">
                                </a>
                                <div class="hot-no1-head2">
                                    <div class="no1-head2-num">${num}</div>
                                </div>
                                <div class="no1-head2-bottom">
                                    <div class="no1-head2-bottom-text">
                                        <p class="head2-bottom-name">${res.data[i].U_falsename}</p>
                                        <span class="head2-bottom-address">${res.data[i].U_address}</span>
                                        <span class="head2-bottom-cs">接单:${res.data[i].COUNT}次</span>
                                    </div>
                                </div>
                            </div>
                        </div>
                `)
            }
            for (var j=2;j<res.data.length;j++){
                if (res.data[j].U_sex==='女'){
                    ax='♀';
                }else {
                    ax='♂';
                }
                var num=j+1;
                $('.list-hot-total').append(`
                        <div class="list-hot-no2">
                            <div class="fl">
                                <div class="hot-no2-imgbox">
                                    <div class="hot-no2-img">
                                        <a href="javascript:;"   onclick="hotclick(${res.data[j].U_id})">
                                            <img src="${res.data[j].U_photo}" alt="">
                                        </a>
                                    </div>
                                    <div class="hot-no2-imgno">${num}</div>
                                </div>

                            </div>
                            <div class="fl hot-no2-play">
                                <div class="hot-no2-nm">${res.data[j].U_falsename}</div>
                                <div class="hot-no2-Grade">
                                    
                                </div>
                            </div>
                            <div class="fr hot-no2-information">
                                <div class="hot-no2-address fl">${res.data[j].U_address}</div>
                                <div class="hot-no2-age-2 fl">${ax} ${res.data[j].U_age}</div>
                                <div class="clearfix"></div>
                                <div class="hot-no2-sig">接单:${res.data[j].COUNT}次</div>
                            </div>
                        </div>
`)
            }
            for(var i=2;i<res.data.length;i++){
                var s=i-2;
                if (res.data[i].U_sex==='女'){

                    $('.hot-no2-age-2').eq(s).css({'background':'#ffabad'})
                }else {
                    $('.hot-no2-age-2').eq(s).css({'background':'#97bcf0'})
                }
            }

        }
    }
});

//礼物榜周榜
$.ajax({
    url: '/getgiftweek',
    type: 'post',
    success: function (res) {
        if (res.error) {

        } else {
            for (var i=0;i<2;i++){
                var num=i+1;
                $('.list-gift-week').append(`
                 <div class="list-hot-no1">
                            <div class="hot-no1-head">
                                <a href="javascript:;"   onclick="hotclick(${res.data[i].U_id})">
                                    <img src="${res.data[i].U_photo}" alt="">
                                </a>
                                <div class="hot-no1-head2">
                                    <div class="no1-head2-num">${num}</div>
                                </div>
                                <div class="no1-head2-bottom">
                                    <div class="no1-head2-bottom-text">
                                        <p class="head2-bottom-name">${res.data[i].U_falsename}</p>
                                        <span class="head2-bottom-address">${res.data[i].U_address}</span>
                                        <span class="head2-bottom-cs">礼物值:${res.data[i].money}</span>
                                    </div>
                                </div>
                            </div>
                        </div>
                `)
                return
            }
            for (var j=2;j<res.data.length;j++){
                if (res.data[j].U_sex==='女'){
                    ax='♀';
                }else {
                    ax='♂';
                }
                var num=j+1;
                $('.list-gift-week').append(`
                        <div class="list-hot-no2">
                            <div class="fl">
                                <div class="hot-no2-imgbox">
                                    <div class="hot-no2-img">
                                        <a href="javascript:;"   onclick="hotclick(${res.data[j].U_id})">
                                            <img src="${res.data[j].U_photo}" alt="">
                                        </a>
                                    </div>
                                    <div class="hot-no2-imgno">${num}</div>
                                </div>

                            </div>
                            <div class="fl hot-no2-play">
                                <div class="hot-no2-nm">${res.data[j].U_falsename}</div>
                                <div class="hot-no2-Grade">
                                    
                                </div>
                            </div>
                            <div class="fr hot-no2-information">
                                <div class="hot-no2-address fl">${res.data[j].U_address}</div>
                                <div class="hot-no2-age-3 fl">${ax} ${res.data[j].U_age}</div>
                                <div class="clearfix"></div>
                                <div class="hot-no2-sig">礼物值:${res.data[j].money}</div>
                            </div>
                        </div>
`)
            }
            for(var i=2;i<res.data.length;i++){
                var s=i-2;
                if (res.data[i].U_sex==='女'){

                    $('.hot-no2-age-3').eq(s).css({'background':'#ffabad'})
                }else {
                    $('.hot-no2-age-3').eq(s).css({'background':'#97bcf0'})
                }
            }

        }
    }
});
//礼物榜总榜
$.ajax({
    url: '/getgifttotal',
    type: 'post',
    success: function (res) {
        if (res.error) {

        } else {
            for (var i=0;i<2;i++){
                var num=i+1;
                $('.list-gift-total').append(`
                 <div class="list-hot-no1">
                            <div class="hot-no1-head">
                                <a href="javascript:;"   onclick="hotclick(${res.data[i].U_id})">
                                    <img src="${res.data[i].U_photo}" alt="">
                                </a>
                                <div class="hot-no1-head2">
                                    <div class="no1-head2-num">${num}</div>
                                </div>
                                <div class="no1-head2-bottom">
                                    <div class="no1-head2-bottom-text">
                                        <p class="head2-bottom-name">${res.data[i].U_falsename}</p>
                                        <span class="head2-bottom-address">${res.data[i].U_address}</span>
                                        <span class="head2-bottom-cs">礼物值:${res.data[i].money}</span>
                                    </div>
                                </div>
                            </div>
                        </div>
                `)
            }
            for (var j=2;j<res.data.length;j++){
                if (res.data[j].U_sex==='女'){
                    ax='♀';
                }else {
                    ax='♂';
                }
                var num=j+1;
                $('.list-gift-total').append(`
                        <div class="list-hot-no2">
                            <div class="fl">
                                <div class="hot-no2-imgbox">
                                    <div class="hot-no2-img">
                                        <a href="javascript:;"   onclick="hotclick(${res.data[j].U_id})">
                                            <img src="${res.data[j].U_photo}" alt="">
                                        </a>
                                    </div>
                                    <div class="hot-no2-imgno">${num}</div>
                                </div>

                            </div>
                            <div class="fl hot-no2-play">
                                <div class="hot-no2-nm">${res.data[j].U_falsename}</div>
                                <div class="hot-no2-Grade">
                                    
                                </div>
                            </div>
                            <div class="fr hot-no2-information">
                                <div class="hot-no2-address fl">${res.data[j].U_address}</div>
                                <div class="hot-no2-age-4 fl">${ax} ${res.data[j].U_age}</div>
                                <div class="clearfix"></div>
                                <div class="hot-no2-sig">礼物值:${res.data[j].money}</div>
                            </div>
                        </div>
`)
            }
            for(var i=2;i<res.data.length;i++){
                var s=i-2;
                if (res.data[i].U_sex==='女'){

                    $('.hot-no2-age-4').eq(s).css({'background':'#ffabad'})
                }else {
                    $('.hot-no2-age-4').eq(s).css({'background':'#97bcf0'})
                }
            }

        }
    }
});

//富豪周榜
$.ajax({
    url: '/getRichweek',
    type: 'post',
    success: function (res) {
        if (res.error) {

        } else {
            for (var i=0;i<2;i++){
                var num=i+1;
                $('.list-rich-week').append(`
                 <div class="list-hot-no1">
                            <div class="hot-no1-head">
                                <a href="javascript:;"   onclick="hotclick(${res.data[i].U_id})">
                                    <img src="${res.data[i].U_photo}" alt="">
                                </a>
                                <div class="hot-no1-head2">
                                    <div class="no1-head2-num">${num}</div>
                                </div>
                                <div class="no1-head2-bottom">
                                    <div class="no1-head2-bottom-text">
                                        <p class="head2-bottom-name">${res.data[i].U_falsename}</p>
                                        <span class="head2-bottom-cs">贡献值:${res.data[i].money}</span>
                                    </div>
                                </div>
                            </div>
                        </div>
                `)
                return
            }
            for (var j=2;j<res.data.length;j++){
                var num=j+1;
                $('.list-rich-week').append(`
                        <div class="list-hot-no2">
                            <div class="fl">
                                <div class="hot-no2-imgbox">
                                    <div class="hot-no2-img">
                                        <a href="javascript:;"   onclick="hotclick(${res.data[j].U_id})">
                                            <img src="${res.data[j].U_photo}" alt="">
                                        </a>
                                    </div>
                                    <div class="hot-no2-imgno">${num}</div>
                                </div>

                            </div>
                            <div class="fl hot-no2-play">
                                <div class="hot-no2-nm">${res.data[j].U_falsename}</div>
                                <div class="hot-no2-Grade">
                                    
                                </div>
                            </div>
                            <div class="fr hot-no2-information">
                                <div class="clearfix"></div>
                                <div class="hot-no2-sig">贡献值:${res.data[j].money}</div>
                            </div>
                        </div>
`)
            }

        }
    }
});
//富豪总榜
$.ajax({
    url: '/getRichtotal',
    type: 'post',
    success: function (res) {
        if (res.error) {

        } else {
            for (var i=0;i<2;i++){
                var num=i+1;
                $('.list-rich-total').append(`
                 <div class="list-hot-no1">
                            <div class="hot-no1-head">
                                <a href="javascript:;"   onclick="hotclick(${res.data[i].U_id})">
                                    <img src="${res.data[i].U_photo}" alt="">
                                </a>
                                <div class="hot-no1-head2">
                                    <div class="no1-head2-num">${num}</div>
                                </div>
                                <div class="no1-head2-bottom">
                                    <div class="no1-head2-bottom-text">
                                        <p class="head2-bottom-name">${res.data[i].U_falsename}</p>
                                       
                                        <span class="head2-bottom-cs">贡献值:${res.data[i].money}</span>
                                    </div>
                                </div>
                            </div>
                        </div>
                `)
            }
            for (var j=2;j<res.data.length;j++){
                var num=j+1;
                $('.list-rich-total').append(`
                        <div class="list-hot-no2">
                            <div class="fl">
                                <div class="hot-no2-imgbox">
                                    <div class="hot-no2-img">
                                        <a href="javascript:;"   onclick="hotclick(${res.data[j].U_id})">
                                            <img src="${res.data[j].U_photo}" alt="">
                                        </a>
                                    </div>
                                    <div class="hot-no2-imgno">${num}</div>
                                </div>

                            </div>
                            <div class="fl hot-no2-play">
                                <div class="hot-no2-nm">${res.data[j].U_falsename}</div>
                                <div class="hot-no2-Grade">
                                    
                                </div>
                            </div>
                            <div class="fr hot-no2-information">
                      
                                <div class="clearfix"></div>
                                <div class="hot-no2-sig">贡献值:${res.data[j].money}</div>
                            </div>
                        </div>
`)
            }

        }
    }
});


// 热门推荐的localstorage
function  hotclick(id) {
    console.log(id)
    var storage=window.localStorage;
    storage.setItem('ID',id)
    JSON.parse(storage.ID)
}

