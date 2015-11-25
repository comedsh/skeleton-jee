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
    //图片验证码请求
    $('.validatePicCheck').on('click',function(){
    	var str = $(this);
    	$(this).parent().parent().find(".img_code").attr('src','/user/validatePicCheck?'+Math.random());
//    	$.ajax({
//            type: "GET",
//            url: '/user/validatePicCheckValue',
//            dataType: "text",
//            success: function (data) {
//                //$(str).parent().parent().find(".verifyCode").val(data);
//            }
//        });
    });
});
var app=angular.module('login_app',[]);
app.controller('login_ctr',['$scope','$http',function($scope,$http){
	
    $scope.user={name:'',pwd:''};
    
    //根据用户名，查看是否应该显示图形验证码
    $scope.validateName = function(){
    	var name = $scope.user.name;
    	$http.get('/user/validatePic', {params: {name:name}}).success(function(data){
    		if(data.msg.success == false) {
    			$(".code_d").css("display","block"); 
    		}  
        });
    }
    
    //登录js
    $scope.logins=function(){
        var name=$scope.user.name;
        var pwd=$scope.user.pwd;
        var code=$scope.user.code;
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
      		  url: "/login",
      		  type:'POST',
      		  dataType:'json',
      		  data:{'username':name,'password':pwd,'autoLogin':num,'vCode':code},
      		  success: function(data,textStatus){
      			if(data.msg.success){
      				if(data.msg.code == '1001'){
      					//显示验证码输入框
      					$(".code_d").css("display","block");      				
      				}     					
      				 if(data.msg.msg != ''){     				    
      				    alert(data.msg.msg);
      				}else{
      					window.location.href='/secure/main';
      				}
      			}else{
      				window.location.href='错误页面';
      			}
      		  },
      		  error:function(data){
      			  alert(data);
      		  }});
        }
    };
    
    //页面加载就初始化
    $scope.validateName();
}]);
