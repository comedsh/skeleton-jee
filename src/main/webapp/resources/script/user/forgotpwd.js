/**
 * Created by think on 2015/11/2.
 */
$(function() {
    //城市切换
    $('.city_div').hover(function () {
        $(this).addClass('active_l');
        $('#show_div').show();
    }, function () {
        $(this).removeClass('active_l');
        $('#show_div').hide();
    });
    $('#show_div').hover(function () {
        $(this).show();
    }, function () {
        $('.city_div').hover(function () {
            $(this).addClass('active_l');
            $('#show_div').show();
        }, function () {
            $(this).removeClass('active_l');
            $('#show_div').hide();
        });
    });
    $('#show_div ul li a').on('click', function () {
        var text = $(this).html();
        $(this).addClass('active');
        $(this).parent().siblings().children('a').removeClass('active');
        $('.city_div span').html(text);
    });
    //tab切换
    $('.a_tab').on('click',function(){
        var index=$(this).index();
        $(this).addClass('active_tab').siblings().removeClass('active_tab');
        if(index==0){
            $('.border_div').show();
            $('.border_div1').hide();
        }else{
            $('.border_div').hide();
            $('.border_div1').show();
        }
    });
    //手机验证
    $("#mobile").blur(function(event) {
        if($(this).val() == ""){
            $('.mobile_error img').show();
            $(".mobile_error span").html("手机号码不能为空");
            $('input[type=hidden]').val('1');
            return false;
        }
        var re = /^1{1}[34578]{1}[0-9]{9}$/;
        if(!re.test($(this).val())){
            $('.mobile_error img').show();
            $(".mobile_error span").html("手机号码格式不正确");
            $('input[type=hidden]').val('1');
            return false;
        }else{
            $('.mobile_error img').hide();
            $(".mobile_error span").html("");
            $('input[type=hidden]').val('0')
        }
    });
    //图形验证码
    $(".code").blur(function(event) {
        if($(this).val() == ""){
            $('.code_error img').show();
            $(".code_error span").html("验证码不能为空");
            $('input[type=hidden]').val('1');
            return false;
        }
        var re = /^[A-Za-z]{4}$/;
        if(!re.test($(this).val())){
            $('.code_error img').show();
            $(".code_error span").html("验证码格式不正确");
            $('input[type=hidden]').val('1');
            return false;
        }else{
            $('.code_error img').hide();
            $(".code_error span").html("");
            $('input[type=hidden]').val('0');
            return false;
        }
    });
    //手机短信验证码
    $(".iPhone_code").blur(function(event) {
        if($(this).val() == ""){
            $('.iPhone_code_error img').show();
            $(".iPhone_code_error span").html("手机验证码不能为空");
            $('input[type=hidden]').val('1');
            return false;
        }
        var re = /^[0-9]{6}$/;
        if(!re.test($(this).val())){
            $('.iPhone_code_error img').show();
            $(".iPhone_code_error span").html("手机验证码格式不正确");
            $('input[type=hidden]').val('1');
            return false;
        }else{
            $('.iPhone_code_error img').hide();
            $(".iPhone_code_error span").html("");
            $('input[type=hidden]').val('0');
            return false;
        }
    });
    //获取验证码 按钮状态
    $('.button_a').on('click',function(){
        var i=10;
        var btn=$('.button_a');
        var time=setInterval(function(){
            btn.html(i+"秒可重发").attr('disabled','disabled').css({backgroundColor:'#9c9c9c'});
            if(i==-1){
                clearInterval(time);
                btn.html('重新发送').attr("disabled",false).removeAttr('disabled').css({backgroundColor:'#0281d4'});
            }
            i--;
        },1000);
    });
    //修改密码验证
    $(".pwd_new").blur(function(event) {
        if($(this).val() == ""){
            $('.pwd_new_error img').show();
            $(".pwd_new_error span").html("密码不能为空");
            $('.second').val('1');
            return false;
        }
        var re = /^[a-zA-Z]\w{5,17}$/;
        if(!re.test($(this).val())){
            $('.pwd_new_error img').show();
            $(".pwd_new_error span").html("以字母开头，长度在6~18之间，只能包含字符、数字和下划线");
            $('.second').val('1');
            return false;
        }else{
            $('.pwd_new_error img').hide();
            $(".pwd_new_error span").html("");
            $('.second').val('0');
            return false;
        }
    });
    //再次输入密码验证
    $(".pwd_new_agin").blur(function(event) {
        if($(this).val() == ""){
            $('.pwd_agin_error img').show();
            $(".pwd_agin_error span").html("密码不能为空");
            $('.second').val('1');
            return false;
        }
        var pwd=$(".pwd_new").val();
        var pwd1=$(".pwd_new_agin").val();
        if(pwd1!=pwd){
            $('.pwd_agin_error img').show();
            $(".pwd_agin_error span").html("两次输入密码不相同");
            $('.second').val('1');
            return false;
        }else{
            $('.pwd_agin_error img').hide();
            $(".pwd_agin_error span").html("");
            $('.second').val('0');
            return false;
        }
    });
    //邮箱验证
    $(".email").blur(function(event) {
        if($(this).val() == ""){
            $('.email_error img').show();
            $(".email_error span").html("邮箱不能为空");
            $('.boolen1').val('1');
            return false;
        }
        var re = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
        if(!re.test($(this).val())){
            $('.email_error img').show();
            $(".email_error span").html("邮箱格式不正确");
            $('.boolen1').val('1');
            return false;
        }else{
            $('.email_error img').hide();
            $(".email_error span").html("");
            $('.boolen1').val('0');
            return false;
        }
    });
    //邮箱修改密码验证
    $(".email_pwd").blur(function(event) {
        if($(this).val() == ""){
            $('.email_pwd_error img').show();
            $(".email_pwd_error span").html("密码不能为空");
            $('.boolen2').val('1');
            return false;
        }
        var re = /^[a-zA-Z]\w{5,17}$/;
        if(!re.test($(this).val())){
            $('.email_pwd_error img').show();
            $(".email_pwd_error span").html("以字母开头，长度在6~18之间，只能包含字符、数字和下划线");
            $('.boolen2').val('1');
            return false;
        }else{
            $('.email_pwd_error img').hide();
            $(".email_pwd_error span").html("");
            $('.boolen2').val('0');
            return false;
        }
    });
    //邮箱再次输入密码验证
    $(".email_new_agin").blur(function(event) {
        if($(this).val() == ""){
            $('.email_agin_error img').show();
            $(".email_agin_error span").html("密码不能为空");
            $('.boolen2').val('1');
            return false;
        }
        var pwd=$(".email_pwd").val();
        var pwd1=$(".email_new_agin").val();
        if(pwd1!=pwd){
            $('.email_agin_error img').show();
            $(".email_agin_error span").html("两次输入密码不相同");
            $('.boolen2').val('1');
            return false;
        }else{
            $('.email_agin_error img').hide();
            $(".email_agin_error span").html("");
            $('.boolen2').val('0');
            return false;
        }
    });
});
var forgotpwd_app=angular.module('forgotpwd',[]);
//手机找回密码
forgotpwd_app.controller('ipone',['$scope','$http',function($scope,$http){
        $scope.mobile='';
        $scope.code='';
        $scope.iPhone_code='';
        $scope.num=0;
        $scope.myVar1 = false;
        $scope.myVar2 = true;
        $scope.myVar3 = true;
        $scope.nextstep=function(){
            console.log($scope.mobile+"////"+$scope.num);
            if($('input[type=hidden]').val()==0){
                $http.post('',{mobile:$scope.mobile,code:$scope.code,iPhone_code:$scope.iPhone_code})
                    .success(function(rep){
                        //第一步验证成功时
                        $scope.myVar1 = true;
                        $scope.myVar2 = false;
                    })
                    .error(function(rep){
                        //第一步验证失败时
                        if(rep){
                            //手机号错误
                            $('.mobile_error img').show();
                            $(".mobile_error span").html("此手机已注册");
                            return false;
                        }else if(rep){
                            //图形验证码错误
                            $('.code_error img').show();
                            $(".code_error span").html("图形验证码错误");
                            return false;
                        }else{
                            //手机验证码错误
                            $('.iPhone_code_error img').show();
                            $(".iPhone_code_error span").html("手机验证码错误");
                            return false;
                        }
                    })
            }

        };
        $scope.pwd_new = '';
        $scope.pwd_new_agin = '';
        $scope.second=function(){
            if($('.second').val()==0){
                $http.post('',{pwd_new:$scope.pwd_new,pwd_new_agin:$scope.pwd_new_agin})
                    .success(function(rep){
                        //第二步验证成功时
                        $scope.myVar2 = true;
                        $scope.myVar3 = false;
                    })
                    .error(function(rep){
                        //第二步验证失败时
                        if(rep){
                            //密码不能为空
                            $('.pwd_new_error img').show();
                            $(".pwd_new_error span").html("请输入密码");
                            return false;
                        }else{
                            //再次输入密码不能为空
                            $('.pwd_agin_error img').show();
                            $(".pwd_agin_error span").html("请输入密码");
                            return false;
                        }
                    })
            }
        }
}]);
//手机验证找回密码第一步
function nextstepByPhone(){
	  if($("#sub_tel").val()==0 && $("#sub_code").val()==0 && $("#sub_tel_code").val()==0){
		  $('#firstformByPhone').submit();
	  }
}
//手机找回密码第二步提交
function secondByPhone(){
	 if($('.second').val()==0){
		 $('#secondformByPhone').submit();
	 }
}
//邮箱找回密码第一步提交
function nextstepByEmail(){
	  if($('.boolen1').val()==0){
		  $('#firstformByEmail').submit();
	  }
}
//邮箱找回密码
forgotpwd_app.controller('email',['$scope','$http',function($scope,$http){
        $scope.boolen1=false;
        $scope.boolen2=true;
        $scope.boolen3=true;
        $scope.boolen4=true;
        $scope.boolen5=false;
        $scope.email='';
        $scope.emailnext=function(){
            if($('.boolen1').val()==0){
                $http.post('',{email:$scope.email})
                    .success(function(rep){
                        //第一步验证成功时
                        $scope.boolen1=false;
                        $scope.boolen5=true;
                        $scope.boolen4=false;
                    })
                    .error(function(rep){
                        //第一步验证失败时
                        if(rep){
                            //邮箱不能为空
                            $('.email_error img').show();
                            $(".email_error span").html("邮箱不能为空");
                            return false;
                        }
                    })
            }
        };
        $scope.pwd_new1 = '';
        $scope.pwd_new_agin1 = '';
        $scope.second=function(){
            if($('.boolen2').val()==0){
                $http.post('',{pwd_new1:$scope.pwd_new1})
                    .success(function(rep){
                        //第二步验证成功时
                        $scope.boolen2=true;
                        $scope.boolen3=false;
                    })
                    .error(function(rep){
                        //第二步验证失败时
                        if(rep){

                        }
                    })
            }
        }
}]);
