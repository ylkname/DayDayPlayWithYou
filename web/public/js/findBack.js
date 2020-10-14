$("#first-btn").click(function () {
   if ($("#first-input").val()) {
       $.ajax({
           url:'/findID',
           type:'post',
           data:{
               user:$("#first-input").val()
           },
           success:function (res) {
               if (!res.error){
                   $("#first").hide();
                   $("#second").show();
                   $(".one").removeClass("checked");
                   $(".two").addClass("checked");
               } else {
                   alert("你输入的用户名不存在")
                   $("#first-input").val('')
               }
           }
       })
   }else {
       alert("请输入用户名！");

   }
});
$('#findBackCode').click(function () {
    var str=$('#phone').val();
    if(!str.trim()){
        alert('必须输入电话号码');
    }else {
        $.ajax({
            type: 'post',
            post:'/phone',
            data:{
                user:$("#first-input").val(),
                phone:str
            },
            success:function (res) {
                if (!error){
                    $.ajax({
                        url:'/getCode1',
                        type:'post',
                        data:{
                            phone:str
                        },
                        success:function (res) {
                            alert('短信已经发送，请注意查收')
                        }
                    })
                } else {
                    alert('此手机号与绑定手机号不同');
                    $('#phone').val('');
                }

            }
        })
    }



});
$('#second-btn').click(function () {
    var sPhone=$('#phone').val();
    var sCode=$('#findBackCode').val();

    $.ajax({
        url:'/test1',
        type:'post',
        data:{
            phone:sPhone,
            code:sCode
        },
        success:function (res) {
            $("#second").hide();
            $("#third").show();
            $(".two").removeClass("checked");
            $(".three").addClass("checked");

        }
    })
});
$("#third-btn").click(function () {
    if (!$("#newPass").val()==$("#newPass1").val()){
        $("#pass-warn").text("两次输入的密码不一样！");
        return
    } else {
        $.ajax({
            url:'/alter',
            type:'post',
            data:{
                phone:$('#phone').val(),
                pass:$('newPass').val()
            },
            success:function (res) {
                $("#third").hide();
                $("#fourth").show();
                $(".three").removeClass("checked");
                $(".four").addClass("checked");
            }
        })
    }
});
