<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
 <%@page import="java.util.Enumeration"%>
<!DOCTYPE html>
<html ng-app="login_app">
<head lang="en">
    <title></title>
    <meta charset="UTF-8">
    <meta name="keywords" content="" />
    <meta name="description" content=""/>
    <!--<meta http-equiv="X-UA-Compatible" content="IE=7"/>-->
    <link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/common/Common_top_tail.css"/>
    <link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/user/Login_style.css"/>
    <link rel="icon" href=""/>
    <script type="text/javascript" src="<%=request.getContextPath() %>/resources/javaScript/jQuery/jquery-1.8.3.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/resources/javaScript/angular/angular.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/resources/javaScript/jQuery/json2.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/resources/script/user/placeholder.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/resources/script/user/login.js"></script>
	<script type="text/javascript">
	
	</script>
	<% String path = request.getContextPath();%>
    <!--<link rel="icon" href="http://www.jd.com/favicon.ico" mce_href="http://www.jd.com/favicon.ico" type="image/x-icon">-->
    <!--[if lt IE 9]>
    <script type="text/javascript" src="http://cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script type="text/javascript" src="http://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    <!--[if lte IE 7]>
    <script src="<%=request.getContextPath() %>/resources/javaScript/jQuery/json2.js"></script>
    <![endif]-->
    <!--[if IE 6]>
    <script type="text/javascript">
        document.execCommand("BackgroundImageCache", false, true);
    </script>
    <![endif]-->
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
<div class="content_login clearfix" ng-controller="login_ctr">
    <div class="img_login clearfix">
        <img src="<%=request.getContextPath() %>/resources/imgs/img_login.png" alt=""/>
    </div>
    <div class="right_login">
        <h1>欢迎登录<span>还没有账号？<a href="<%=path %>/user/fowardRegister">免费注册</a></span></h1>
        <div class="error1">
            <div class="error">手机账号错误</div>	
        </div>
        <div class="input_li">
            <input ng-model="user.name" type="text" class="name" placeholder="用户名/手机/邮箱号"/>
        </div>
        <div class="input_li pwd">
            <input ng-model="user.pwd" type="password" placeholder="请输入你的密码"/>
        </div>
        <div class="Keep_div clearfix">
            <div class="Remember_pwd" data="0">记住密码</div>
            <a ng-href="Forgot password.html">忘记密码</a>
        </div>
        <div class="code_d">
            <input type="text">
            <!--<img  src="<%=request.getContextPath() %>/resources/imgs/code.png" alt="" title="换一张" class="img_code"/>-->
            <img title="换一张" class="img_code" src="https://authcode.jd.com/verify/image?a=0&amp;
acid=feaaa1e7-e645-4dff-b702-679e5ebf70a2&amp;
uid=feaaa1e7-e645-4dff-b702-679e5ebf70a2&amp;
srcid=reg&amp;is=e69a14665f94d73d9ceb265005b78452&amp;
yys=1444790929987"
                 style="margin-left: 5px;margin-top: 1px;width: 80px;height: 30px;;display:block;"
                 alt="" clstag="regist|keycount|personalreg|06"
                 onclick="this.src= document.location.protocol +'//authcode.jd.com/verify/image?a=0&amp;acid=feaaa1e7-e645-4dff-b702-679e5ebf70a2&amp;uid=feaaa1e7-e645-4dff-b702-679e5ebf70a2&amp;srcid=reg&amp;is=e69a14665f94d73d9ceb265005b78452&amp;yys='+new Date().getTime()" ver_colorofnoisepoint="#888888" id="JD_Verification1">
            <a href="javascript:void(0)">看不清楚换一张</a>
        </div>
        <input class="login_hidden" type="hidden" value="<%=path %>">
        <button class="login_btn" enter ng-click="logins()">登 录</button>
        <div class="san_d">
            <label>使用合作网站账号登录</label>
            <a href="###">QQ</a>&nbsp;&nbsp;|&nbsp;&nbsp;
            <a href="###">微信</a>
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
</body>
</html>