//如果未签到 或者 未登录 显示签到
// if(IS_SIGN == 1 || UID == '' || UID == 0){
//         $("#signCorner").show();
//     }

//点击签到图标
$("#signCorner").click(function () {
    // if(UID == undefined || UID == 0 || UID == ""){
    //        //未登录跳转登录页
    //         window.location.href='/index.php?app=wap&mod=Public&act=login';
    //         return false;
    //     }else{
    //         $("#signCorner").hide();
    //         $("#signInDrawStart").show();
    //         $("#mask").show();
    //     }
    $("#signCorner").hide();
    $("#signInDrawStart").show();
    $("#mask").show();
});
//点击X关闭
$(".signInDraw-close").click(function () {
    $(this).parent(".signInDraw-turntablebg").hide();
    $("#mask").hide();
    location.reload();
});
//点击遮罩关闭
/*$("#mask").click(function(){
     $(".signInDraw-turntablebg").hide();
     $("#mask").hide();
     location.reload();
 });*/
//大弹窗转盘
$(function (){
    var rotateTimeOut = function (){
        $('#rotate').rotate({
            angle:0,
            animateTo:2160,
            duration:8000,
            callback:function (){
                alert('网络超时，请检查您的网络设置！');
            }
        });
    };
    var bRotate = false;
    var rotateFn = function (awards, angles, txt){
        bRotate = !bRotate;
        $('#rotate').stopRotate();
        $('#rotate').rotate({
            angle:0,
            animateTo:angles+1800,
            duration:8000,
            callback:function (){
                $.post(U('activity/Activity/queUserSign'),{uid:awards.uid},function(result){
                    var results = eval('('+result+')');
                    var attrs   = '';
                    var succession_sign = results.data.succession_sign;
                    if(succession_sign == 0){
                        succession_sign = 7;
                    }else{
                        var endsuc = 7 - succession_sign;
                    }
                    if (results.status == 1)
                    {
                        if(awards.name == "积分"){
                            $(".signInDraw-Congratulate").html(txt);
                            $('#kaquan').hide();
                            $('#hongbao').hide();
                        }else if(awards.name == "现金红包"){
                            $(".signInDraw-Congratulate").html(txt);
                            $('#jifen').hide();
                            $('#kaquan').hide();
                        }else{
                            $(".signInDraw-Congratulate").html(txt);
                            $('#jifen').hide();
                            $('#hongbao').hide();
                        }
                        if(succession_sign == 7){
                            $('#signInDraw-tips1').show();
                            $('#signInDraw-tips').hide();
                        }else{
                            $('#signInDraw-tips1').hide();
                            $("#sSuc").html(succession_sign);
                            $("#endSuc").html(endsuc);
                        }
                        $('#signInDrawLast').show();
                    }else {
                        $(".signInDrawLast").hide();
                    }
                });
                bRotate = !bRotate;
            }
        })
    };

    $('#signInDraw-pointer').click(function (){
        if(bRotate)return;
        if(UID == undefined || UID == 0 || UID == ""){
            //未登录跳转登录页
            // var url = "<?php echo base64_encode(U('public/Finance/index'));?>";
            setTimeout(function () {window.location.href='/index.php?app=wap&mod=Public&act=login';}, "0");
            return false;
        }
        var attrs = '';
        $.post(U('activity/Activity/signInActivity'),{uid:UID},function(result){
            var results = eval('('+result+')');
            if (results.status == 1)
            {
                //奖品id，需指定

                switch (results.data.id) {
                    //普通奖励
                    case 0:
                        rotateFn(results.data, 67, results.info.title);
                        break;
                    case 109:
                        rotateFn(results.data, 220, results.info.title);
                        break;
                    case 110:
                        rotateFn(results.data, 220, results.info.title);
                        break;
                    case 43:
                        rotateFn(results.data, 139, results.info.title);
                        break;
                    case 26:
                        rotateFn(results.data, 139, results.info.title);
                        break;

                    //宝箱奖励
                    //积分
                    case 1:
                        rotateFn(results.data, 280, results.info.title);
                        break;
                    case 114:
                        rotateFn(results.data, 280, results.info.title);
                        break;
                    case 89:
                        rotateFn(results.data, 280, results.info.title);
                        break;
                    case 115:
                        rotateFn(results.data, 280, results.info.title);
                        break;
                    case 6:
                        rotateFn(results.data, 280, results.info.title);
                        break;
                    case 66:
                        rotateFn(results.data, 280, results.info.title);
                        break;
                    case 109:
                        rotateFn(results.data, 280, results.info.title);
                        break;
                    case 109:
                        rotateFn(results.data, 280, results.info.title);
                        break;
                    case 109:
                        rotateFn(results.data, 280, results.info.title);
                        break;
                }
            }else {
                $("#headerSignPopUp").show();
                location.reload();
            }
        });
    });
});