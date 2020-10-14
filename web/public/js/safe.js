
function showShade(v) {
    var $vW = $(window).width();
    var $w = v.outerWidth();
    var $vH = $(window).height();
    var $h = v.outerHeight();
    v.css({"left": ($vW - $w) / 2 + "px", "top": ($vH - $h) / 2 + "px"});
};
let oSpan=$('#alter');
/*console.log(1)
console.log(oSpan);
let oLi=$(".safe-li-11");*/
/*oLi.click(function () {
    alert(2)
});*/
$(document).ready(function () {
    $.ajax({
        type:'post',
        url:'/safe',
        data:{
            id:localStorage.myID
        },
        success:function (res) {
            $("#user").html(res.data[0].L_user);
            $("#phone").html(res.data[0].L_tel)
        }
    })

})
oSpan.click(function () {
    $("#safe_box").css('display','none');
    $(".modal-password").fadeIn(500);
    $(".modal-password-con").fadeIn(500);
    showShade($(".modal-password-con"));
    return false
});
/*oLi.on('click',oSpan,function () {
    alert(1)
    /!*$("#safe").css('display','none');
    $(".modal-password").fadeIn(1000);
    $(".modal-con").fadeIn(1000);
    showShade();*!/
    return false
});*/
/*$("#alter").click(function () {

});*/
$("#close1").click(function () {
    $(".modal-password").hide();
    $(".modal-password-con").hide();
    $("#safe_box").css('display','block');
});
$("#bind").click(function () {
    $("#safe_box").css('display','none');
    $(".modal-bind").fadeIn(500);
    $(".modal-bind-con").fadeIn(500);
    showShade($(".modal-bind-con"));
    return false
});
$("#close2").click(function () {
    $(".modal-password").hide();
    $(".modal-bind-con").hide();
    $("#safe_box").css('display','block');
});

$("#passwd").click(function () {
   if ($("#newPass1").val()==$("#newPass2").val()) {
       $.ajax({
           url:'passwd',
           type:'post',
           data:{
               id:localStorage.myID,
                old:$("#oldPass").val(),
                newPass:$("#newPass1").val()
           },
           success:function (res) {
                if (res.error){
                    alert("原始密码错误！");
                    return
                } else {
                    alert("修改成功！");
                    $(".modal-password").hide();
                    $(".modal-password-con").hide();
                    $("#safe_box").css('display','block');
                }
           }
       })

   }else {
       alert("两次输入密码不一样!");
       return
   }
})
