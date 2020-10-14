var pageNum=0;
$(document).ready(function(){

    $("#tabs li").click(function(){
        $("#tabs li").eq($(this).index()).addClass("opt").siblings().removeClass('opt');
        $(".tab").hide().eq($(this).index()).show();
    });
    $.ajax({
        type:'post',

    })
    $.ajax({
        url:'/giftSend',
        type:'post',
        data:{
            id:localStorage.myID,
            num:pageNum
        },
        success:function (res) {

            if (res.data.length){
                $.each(res.data,function (i,v) {
                    $('.tab_1_con').append(`<div class="tab_con1">
                <div><img src="${v.GA_src}" height="50" width="50" title="${v.GA_name}"></div>
                <div>${v.GF_num}</div>
                <div>${v.pw}</div>
                <div>${v.GF_data.slice(0,10)}</div>
                </div>
                `);
                })
            }
        }
    });
    $.ajax({
        url:'/giftRecord',
        type:'post',
        data:{
            id:localStorage.myID
        },
        success:function (res) {
            console.log(res)
           if (res.data.length){
               $.each(res.data,function (i,v) {
                   $('.tab_2_con').append(`<div class="tab_con2">
                <div><img src="${v.GA_src}" height="50" width="50" title="${v.GA_name}"></div>
                <div>${v.GF_num}</div>
                <div>${v.yh}</div>
                <div>${v.GF_data.slice(0,10)}</div>
                </div>
                `);
               })
           }
        }
    })
});