/**
 * Created by think on 2015/10/27.
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
    //记住密码
    $(".Remember_pwd").toggle(
        function () {
            $(this).addClass("Remember_pwd1").attr({data: '1'});
        },
        function () {
            $(this).removeClass("Remember_pwd1").attr({data: '0'});
        }
    );
});
var app=angular.module('login_app',[]);
app.controller('login_ctr',['$scope','$http',function($scope,$http){
    $scope.user={name:'',pwd:''};
    //登录js
    $scope.logins=function(){
        var name=$scope.user.name;
        var pwd=$scope.user.pwd;
        var num=$('.Remember_pwd').attr("data");
        if(name==''|| pwd=='' || name==null || pwd==null){
            $('.error').show().html('用户名或密码必填');
        }else if(pwd.length>100){
            $('.error').show().html("密码不超过一百位");
            $('.pwd input').val('').focus();
            return false;
        } else{
            $('.error').hide();
            $.ajax({  
      		  url: "/Auto007/login",
      		  type:'POST',
      		  dataType:'json',
      		  data:{'username':name,'password':pwd,'autoLogin':num},
      		  success: function(data,textStatus){
      			if(data.message.success){
      		        window.location.href='/Auto007/user/main';
      				
      			}else{
      				window.location.href='错误页面';
      			}
      		  },
      		  error:function(data){
      			  alert(data);
      		  }});
        }
    };
}]);
