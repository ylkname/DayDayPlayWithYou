$("#tabs li").click(function () {
    $("#tabs li").eq($(this).index()).addClass("opt").siblings().removeClass('opt');
    $(".tab").hide().eq($(this).index()).show();
});

$("#newUser").blur(function () {
    if (!$("#newUser").val().trim()) {
        $("#regsiter_warn1").text("请输入用户名");
        return
    } else {
        $.ajax({
            url: '/user',
            type: 'post',
            data: {
                user: $("#newUser").val()
            },
            success: function (res) {
                if (!res.error) {
                    $("#regsiter_warn1").text("该用户名已存在!")
                } else {
                    $("#regsiter_warn1").text("该用户名可用");
                    $("#regsiter_warn1").css('color', 'green')
                }
            }
        })
    }
})


$("#btn1").click(function () {
    if ($("#newPass").val() == $("#newPass1").val()) {

        $.ajax({
            url: '/getCode',
            type: 'post',
            data: {
                phone: $('#phone').val()
            },
            success: function (res) {
                alert('短信已经发送，请注意查收');
                $.ajax({
                    url: '/register',
                    type: 'post',
                    data: {
                        user: $("newUser").val(),
                        pass: $("newPass").val()
                    },
                    success: function (res) {
                        if (res.error) {
                            alert("注册失败，请重新注册")
                        }
                    }
                })
            }
        })
    }
    else {
        $("#regsiter_warn1").text("两次密码不一样");
        return

    }
})


var verifyCode = new GVerify("v_container");
$("#login_btn").click(function () {
    var res = verifyCode.validate($("#code_input").val());
    if (res) {
        $.ajax({
            url: '/login',
            type: 'post',
            data: {
                user: $('#user').val(),
                pass: $('#password').val()
            },
            success: function (res) {
                if (res.data[0].U_ban == '否') {
                    if (res.error == 0) {
                        localStorage.setItem('myID', res.data[0].U_id);
                        location.href = 'http://localhost:5000/page/index.html';
                    } else {
                        alert("账号密码错误");

                    }
                }else  {
                    alert('你的账号已被冻结')
                }
            }
        })

    } else {
        alert("验证码错误");
    }
});



