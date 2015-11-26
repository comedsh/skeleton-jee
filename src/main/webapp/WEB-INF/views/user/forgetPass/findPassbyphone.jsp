<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
 <%@page import="java.util.Enumeration"%>
<!DOCTYPE html>
<html ng-app="forgotpwd_app">
<head lang="en">
    <title>找回密码</title>
    <meta charset="UTF-8">
    <meta name="keywords" content="" />
    <meta name="description" content=""/>
    <!--<meta http-equiv="X-UA-Compatible" content="IE=7"/>-->
    <link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/common/Common_top_tail.css"/>
    <link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/user/Forgotpwd_style.css"/>
    <link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/user/Login_style.css"/>
    <link rel="icon" href=""/>
   <script type="text/javascript" src="<%=request.getContextPath() %>/resources/javaScript/jQuery/jquery-1.8.3.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/resources/javaScript/angular/angular.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/resources/javaScript/jQuery/json2.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/resources/script/user/placeholder.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/resources/script/user/forgotpwd.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/resources/javaScript/uploadify/ajaxfileupload.js"></script>
    <!--[if lt IE 9]>
    <style type="text/css">
        *{
            margin:0;
            padding:0;
            font-family: 'microsoft yahei',Verdana,Arial,Helvetica,sans-serif;
        }
    </style>
</head>
<body>
<!--头部-->
<div class="header_login">
    <div class="header_ul clearfix">
        <ul class="header_ul_left clearfix">
            <li class="city_div clearfix"><label>所在地 :<span>成都</span></label><img src="<%=request.getContextPath() %>/resources/imgs/arrow.png"/>
                <div id="show_div">
                    <ul class="clearfix">
                        <li><a href="javascript:void(0)">四川</a></li>
                        <li><a href="javascript:void(0)" class="active">四川</a></li>
                        <li><a href="javascript:void(0)">四川川</a></li>
                        <li><a href="javascript:void(0)">四川川</a></li>
                        <li><a href="javascript:void(0)">四川</a></li>
                        <li><a href="javascript:void(0)">四川</a></li>
                        <li><a href="javascript:void(0)">四川川</a></li>
                        <li><a href="javascript:void(0)">四川</a></li>
                        <li><a href="javascript:void(0)">四川</a></li>
                    </ul>
                </div>
            </li>
            <li class="ipone_li">
                400-616-6666
            </li>
        </ul>
        <ul class="header_ul_right clearfix">
            <li><a href="">首页</a></li>
            <li class="li">|</li>
            <li><a href="">原厂目录</a></li>
            <li class="li">|</li>
            <li><a href="">品牌件</a></li>
            <li class="li">|</li>
            <li><a href="">帮助中心</a></li>
        </ul>
    </div>
    <div class="logo_div">
        <div class="logo_img clearfix">
            <a href="" class="clearfix">
                <img src="<%=request.getContextPath() %>/resources/imgs/icon.png" alt=""/>
            </a>
        </div>
    </div>
</div>
<div class="Retrieve_password clearfix">
    <p class="clearfix">
        <a class="a_tab active_tab" href="javascript:void(0)">手机找回密码</a>
        <a class="a_tab" style="margin-left: 10px" href="javascript:void(0)">邮箱找回密码</a>
        <label>已有账号？<a href="Login.html">马上登录</a></label>
    </p>
    <!--手机找回密码-->
    <div class="border_div" ng-controller="ipone_ctr" >
        <div class="ipone_one" >
            <span class="progress_bar"></span>
            <ul class="progress_ul clearfix">
                <li class="active_color">填写资料</li>
                <li class="left_li">修改密码</li>
                <li class="progress_li last_il">找回成功</li>
            </ul>
            <div class="form_div clearfix">
                <div class="clearfix chren_div">
                <input type="hidden" class="sub_tel" value="1" id="sub_tel">
                    <label>手机号</label>
                    <input type="text" id="mobile" ng-model="mobile"  placeholder="请输入手机号"/>
                </div>
                <label class="error_lab clearfix mobile_error">
                    <img src="<%=request.getContextPath() %>/resources/imgs/error.png">
                    <span></span>
                </label>
                <div class="clearfix chren_div">
	                <input type="hidden" class="sub_code" id="sub_code" value="1">
	            	<input type="hidden" class="verifyCode" value="">
                    <label>验证码</label>
                    <input type="text" class="code" ng-model="code" />
                    <img src="<%=request.getContextPath() %>/user/validatePicCheck" class="pictureCheckCode"  alt="" title="换一张" class="img_code"/>
                    <input type="hidden" class="verifyCode" value="">
                    <span>看不清楚？<a class="validatePicCheck">换一张</a></span>
     
                </div>
                <label class="error_lab clearfix code_error"><img src="<%=request.getContextPath() %>/resources/imgs/error.png"><span></span></label>
                <div class="clearfix chren_div">
                <input type="hidden" class="sub_tel_code" id="sub_tel_code" value="1">
                    <label>短信验证码</label>
                  
	                    <input type="hidden" class="telephone_code_rep" value=""/>
	                    <input type="text" placeholder="请输入验证码" class="iPhone_code" id="iPhone_code" ng-model="iPhone_code"/>
                    <a class="button_a" ng-click='validateTel()' >获取手机验证码</a>
                </div>
                <label class="error_lab clearfix iPhone_code_error"><img src="<%=request.getContextPath() %>/resources/imgs/error.png"><span></span></label>
                <input type="hidden" value='1'/>
                <button class="btn_login" ng-click="nextstep()">下一步</button>
            </div>
        </div>
        <div class="ipone_two"  style="display: none;">
            <span class="progress_bar progress_bar1"></span>
            <ul class="progress_ul clearfix">
                <li class="active_color">填写资料</li>
                <li class="left_li active_color">修改密码</li>
                <li class="progress_li last_il">找回成功</li>
            </ul>
            <div class="form_div clearfix">
                <div class="clearfix left_div">
                    <label>设置密码 :</label>
                    <input ng-model="pwd_new" class="pwd_new" type="password" placeholder="请输入密码"/>
                </div>
                <label class="error_lab clearfix pwd_new_error"><img src="<%=request.getContextPath() %>/resources/imgs/error.png"><span></span></label>
                <div class="clearfix left_div">
                    <label>确定密码 :</label>
                    <input ng-model="pwd_new_agin" class="pwd_new_agin" type="password" placeholder="请在次输入密码"/>
                </div>
                <label class="error_lab clearfix pwd_agin_error"><img src="<%=request.getContextPath() %>/resources/imgs/error.png"><span></span></label>
                <!--<a class="fanhui" ng-click="fanhui()">返回上一步</a>-->
                <input type="hidden" class="second" value="1">
                <button class="btn_login btn_login1" ng-click="second()">下一步</button>
            </div>
        </div>
        <div class="ipone_three"  style="display: none;">
            <span class="progress_bar progress_bar1 progress_bar2"></span>
            <ul class="progress_ul clearfix">
                <li class="active_color">填写资料</li>
                <li class="left_li active_color">修改密码</li>
                <li class="progress_li last_il active_color">找回成功</li>
            </ul>
            <div class="form_div clearfix">
                <div class="icon_div">
                    <img src="<%=request.getContextPath() %>/resources/imgs/success.png" alt=""/>
                </div>
                <div class="left">
                    <label style="color:#2ca63d;font-size: 28px">找回成功</label>
                    <span style="font-size: 16px;color:#666" id="qq">
                        欢迎您，
                        <a href="###" style="color:#ff8d02"></a>
                    </span>
                    <span style="font-size: 12px;color: #989898">立即开始您的汽车零件选购吧！</span>
                </div>
                <a href="/login.jsp" class="btn_login btn_login2">立即去登录</a>
            </div>
        </div>
    </div>
    <!--邮箱找回密码-->
    <div class="border_div1" ng-controller="email_ctr">
        <div class="email_one" ng-hide="boolen1">
            <span class="progress_bar"></span>
            <ul class="progress_ul clearfix">
                <li class="active_color">邮箱验证</li>
                <li class="left_li">修改密码</li>
                <li class="progress_li last_il">找回成功</li>
            </ul>
            <div class="form_div clearfix" ng-hide="boolen5">
                <div class="clearfix chren_div">
                    <label>输入邮箱</label>
                    <input type="text" class="email" ng-model="email" placeholder="请输入邮箱"/>
                </div>
                <label class="error_lab clearfix email_error"><img src="<%=request.getContextPath() %>/resources/imgs/error.png"><span></span></label>
                <input type="hidden" class="boolen1" value="1"/>
                <button class="btn_login" ng-click="emailnext()">下一步</button>
            </div>
            <div class="email_success" ng-hide="boolen4">
                <p>用户激活电子邮件已发送至：<strong id="emailcontent">20140209001@126.com</strong></p>
                <span>
                    （请立即完成验证，邮箱验证不通过则修改邮箱失败）<br/>验证邮件24小时内有效，请尽快登录您的邮箱点击验证链接完成验证
                </span>
                <span>请您注意查收。如您未收到邮件，请点击下方的按钮重新发送。</span>
                <a href="javascript:void(0)">重新发送激活邮件</a>
            </div>
        </div>
        <div class="email_two" ng-hide="boolen2">
            <span class="progress_bar progress_bar1"></span>
            <ul class="progress_ul clearfix">
                <li class="active_color">填写资料</li>
                <li class="left_li active_color">修改密码</li>
                <li class="progress_li last_il">找回成功</li>
            </ul>
            <div class="form_div clearfix" style="width: 460px">
                <div class="clearfix left_div">
                    <label>设置密码 :</label>
                    <input class="email_pwd" ng-model="pwd_new1" type="password" placeholder="请输入密码"/>
                </div>
                <label class="error_lab clearfix email_pwd_error "><img src="../imgs/error.png"><span></span></label>
                <div class="clearfix left_div">
                    <label>确定密码 :</label>
                    <input class="email_new_agin" ng-model="pwd_new_agin1" type="password" placeholder="请在次输入密码"/>
                </div>
                <label class="error_lab clearfix email_agin_error"><img src="../imgs/error.png"><span></span></label>
                <input type="hidden" class="boolen2" value="1"/>
                <button class="btn_login btn_login1" style="margin-left: 130px">下一步</button>
            </div>
        </div>
        <div class="email_three" ng-hide="boolen3">
            <span class="progress_bar progress_bar1 progress_bar2"></span>
            <ul class="progress_ul clearfix">
                <li class="active_color">填写资料</li>
                <li class="left_li active_color">修改密码</li>
                <li class="progress_li last_il active_color">找回成功</li>
            </ul>
            <div class="form_div clearfix">
                <div class="icon_div">
                    <img src="../imgs/success.png" alt=""/>
                </div>
                <div class="left">
                    <label style="color:#2ca63d;font-size: 28px">激活成功</label>
                    <span style="font-size: 16px;color:#666">
                        欢迎您，
                        <a href="###" style="color:#ff8d02">15631566541</a>
                    </span>
                    <span style="font-size: 12px;color: #989898">立即开始您的汽车零件选购吧！</span>
                </div>
                <a href="Login.html" class="btn_login btn_login2">立即去登录</a>
            </div>
        </div>
    </div>
</div>
<!--尾部-->
<div class="fooder">
    <div class="tail_description">
        <ul class="clearfix">
            <li><a href="">关于我们</a></li>
            <li>|</li>
            <li><a href="">联系我们</a></li>
            <li>|</li>
            <li><a href="">人才招聘</a></li>
        </ul>
        <p>备案号： 新ICP备12057998号-1 新疆丰华神州汽车配件有限公司版权所有</p>
    </div>
</div>

<script type="text/javascript" src="../js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="../js/angular.min.js"></script>
<script type="text/javascript" src="../js/json2.js"></script>
<script type="text/javascript" src="../js/placeholder.js"></script>
<script type="text/javascript" src="../js/forgotpwd.js"></script>
<script type="text/javascript">



</script>
</body>
</html>