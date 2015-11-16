<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html ng-app="Registered_app">
<head lang="en">
    <title>注册</title>
    <meta charset="UTF-8">
    <meta name="keywords" content="" />
    <meta name="description" content=""/>
    <!--<meta http-equiv="X-UA-Compatible" content="IE=7"/>-->
    <link rel="stylesheet" href="./resources/css/common/Common_top_tail.css"/>
    <link rel="stylesheet" href="./resources/css/user/Registered_style.css"/>
    <link rel="icon" href=""/>
    <!--[if lt IE 9]>
    <script type="text/javascript" src="http://cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script type="text/javascript" src="http://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    <!--[if lte IE 7]>
    <script src="../js/json2.js"></script>
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
        body{
            background-color: #f0f2f4;
            height: 100%;
        }
        html{
            height: 100%;
        }
    </style>
</head>
<body>
<!--头部-->
<div class="header_login">
    <div class="header_ul clearfix">
        <ul class="header_ul_left clearfix">
            <li class="city_div clearfix"><label>所在地 :<span>成都</span></label><img src="./resources/imgs/arrow.png"/>
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
                <img src="./resources/imgs/icon.png" alt=""/>
            </a>
        </div>
    </div>
</div>
<div class="Retrieve_password clearfix" ng-controller="enterprise_ctr">
    <p class="clearfix">
        <a class="a_tab active_tab" href="javascript:void(0)">个人注册</a>
        <a class="a_tab" style="margin-left: 10px" href="javascript:void(0)">企业注册</a>
        <a class="a_tab" style="margin-left: 10px" href="javascript:void(0)">商家注册</a>
        <label>已有账号？<a href="Login.html">马上登录</a></label>
    </p>
    <!--企业注册-->
    <div class="border_div">
        <div class="header_titile">服务须知：我们的审核时限为24小时(工作日)，遇法定节假日顺延。</div>
        <h3>账户信息</h3>
        <div class="name_pwd">
            <div class="clearfix chren_div">
                <label><span style="color:red">*</span>用户名</label>
                <div class="input_d">
                    <input type="text" class="name"  placeholder="请输入用户名"/>
                </div>
                <div class="remove_d">
                    <img src="./resources/imgs/remove.jpg"/>
                </div>
                <div class="user_error1">
                    4-20位字符，支持汉子、字母、数字的组合,不能以数字开头
                </div>
                <div class="user_error2">
                    用户名错误
                </div>
                <div class="user_error3">
                    输入正确
                </div>
            </div>
            <div class="clearfix chren_div">
                <label><span style="color:red">*</span>设置密码</label>
                <div class="input_d">
                    <input type="password" class="pwd" placeholder="请输入密码"/>
                </div>
                <div class="remove_d">
                    <img src="./resources/imgs/remove.jpg"/>
                </div>
                <div class="user_error1">
                    6-20位字符,以字母开头,只包含字符、数字和下划线
                </div>
                <div class="user_error2">
                    请输入用户名请输入用户名请输入用户名请输入用户名
                </div>
                <div class="user_error3">
                    输入正确
                </div>
            </div>
            <div class="clearfix chren_div">
                <label><span style="color:red">*</span>确认密码</label>
                <div class="input_d">
                    <input type="password" class="pwd_agin"  placeholder="请再次输入密码"/>
                </div>
                <div class="remove_d">
                    <img src="./resources/imgs/remove.jpg"/>
                </div>
                <div class="user_error1">
                    请确认输入密码
                </div>
                <div class="user_error2">
                    请输入用户名请输入用户名请输入用户名请输入用户名
                </div>
                <div class="user_error3">
                    输入正确
                </div>
            </div>
        </div>
        <h3>联系人信息</h3>
        <div class="name_pwd" style="height:460px">
            <div class="clearfix chren_div">
                <label><span style="color:red">*</span>联系人姓名</label>
                <div class="input_d">
                    <input type="text" class="username"  placeholder="请输入联系人姓名"/>
                </div>
                <div class="remove_d">
                    <img src="./resources/imgs/remove.jpg"/>
                </div>
                <div class="user_error1">
                    4-20位字符，支持汉字、字母、数字的组合,不能以数字开头
                </div>
                <div class="user_error2">
                    联系人姓名错误
                </div>
                <div class="user_error3">
                    输入正确
                </div>
            </div>
            <div class="clearfix chren_div">
                <label><span style="color:red">*</span>所在部门</label>
                <div class="input_d input_select">
                    <span>请选择</span>
                    <ul>
                        <li>
                            safsaf
                        </li>
                        <li>
                           12321321
                        </li>
                        <li>
                            aaaaaaaa
                        </li>
                    </ul>
                </div>
                <div class="user_error2">
                    请输入用户名请输入用户名请输入用户名请输入用户名
                </div>
                <div class="user_error3">
                    输入正确
                </div>
            </div>
            <div class="clearfix chren_div">
                <label><span style="color:red">*</span>固定电话</label>
                <div class="input_d">
                    <input type="text" class="Fixed_telephone"  placeholder="请输入固定电话"/>
                </div>
                <div class="remove_d">
                    <img src="./resources/imgs/remove.jpg"/>
                </div>
                <div class="user_error1">
                    请输入固定电话
                </div>
                <div class="user_error2">
                    请输入用户名请输入用户名请输入用户名请输入用户名
                </div>
                <div class="user_error3">
                    输入正确
                </div>
            </div>
            <div class="clearfix chren_div">
                <label><span style="color:red">*</span>验证手机</label>
                <div class="input_d">
                    <input type="text" class="telephone"  placeholder="请输入手机号"/>
                </div>
                <div class="remove_d">
                    <img src="./resources/imgs/remove.jpg"/>
                </div>
                <a class="button_a" href="javascript:void(0)">获取手机验证码</a>
                <div class="user_error1">
                    请输入手机号
                </div>
                <div class="user_error2">
                    错误
                </div>
                <div class="user_error3">
                    输入正确
                </div>
            </div>
            <div class="clearfix chren_div">
                <label><span style="color:red">*</span>短信验证码</label>
                <div class="input_d" style="width: 150px">
                    <input type="text" class="telephone_code"  placeholder="请输入短信验证码"/>
                </div>
                <div class="remove_d" style="left: 235px;">
                    <img src="./resources/imgs/remove.jpg"/>
                </div>
                <div class="user_error1">
                    请输入短信验证码
                </div>
                <div class="user_error2">
                    错误
                </div>
                <div class="user_error3">
                    输入正确
                </div>
            </div>
            <div class="clearfix chren_div">
                <label><span style="color:red"></span>联系人邮箱</label>
                <div class="input_d">
                    <input type="text" class="email_e"  placeholder="请输入邮箱"/>
                </div>
                <div class="remove_d remove_r">
                    <img src="./resources/imgs/remove.jpg"/>
                </div>
                <div class="user_error1">
                    请输入邮箱
                </div>
                <div class="user_error2">
                    错误
                </div>
                <div class="user_error3">
                    输入正确
                </div>
            </div>
        </div>
        <h3>公司信息</h3>
        <div class="name_pwd" style="height:460px">
            <div class="clearfix chren_div">
                <label><span style="color:red">*</span>公司名称</label>
                <div class="input_d" style="width: 330px">
                    <input style="width: 300px" type="text" class="company"  placeholder="公司名称和营业执照名称一致，否则审核不通过"/>
                </div>
                <div class="remove_d" style="left: 415px;">
                    <img src="./resources/imgs/remove.jpg"/>
                </div>
                <div class="user_error1">
                    公司名称不能空
                </div>
                <div class="user_error2">
                    用户名错误
                </div>
                <div class="user_error3">
                    输入正确
                </div>
            </div>
            <div class="clearfix chren_div company_d">
                <label><span style="color:red">*</span>公司所在地</label>
                <div class="input_d input_select select_province">
                    <span>请选择</span>
                    <ul>
                        <li>
                            四川省
                        </li>
                        <li>
                            12321321
                        </li>
                        <li>
                            aaaaaaaa
                        </li>
                    </ul>
                </div>
                <p>省</p>
                <div class="input_d input_select select_city" >
                    <span>请选择</span>
                    <ul>
                        <li>
                            上海市
                        </li>
                        <li>
                            12321321
                        </li>
                        <li>
                            aaaaaaaa
                        </li>
                    </ul>
                </div>
                <p>市</p>
                <div class="input_d input_select select_area" >
                    <span>请选择</span>
                    <ul>
                        <li>
                            武侯区
                        </li>
                        <li>
                            12321321
                        </li>
                        <li>
                            aaaaaaaa
                        </li>
                    </ul>
                </div>
                <p>区</p>
                <div class="user_error2">
                    请输入用户名请输入用户名请输入用户名请输入用户名
                </div>
                <div class="user_error3">
                    输入正确
                </div>
            </div>
            <div class="clearfix chren_div">
                <label><span style="color:red">*</span>公司地址</label>
                <div class="input_d" style="width: 330px">
                    <input style="width: 300px" type="text" class="address"  placeholder="公司地址和营业执照地址一致，否则审核不通过"/>
                </div>
                <div class="remove_d" style="left: 415px;">
                    <img src="./resources/imgs/remove.jpg"/>
                </div>
                <div class="user_error1">
                    <!--含有汉字、数字、字母、下划线-->
                    公司地址不能为空
                </div>
                <div class="user_error2">
                    错误
                </div>
                <div class="user_error3">
                    输入正确
                </div>
            </div>
            <div class="clearfix chren_div">
                <label><span style="color:red">*</span>公司人数</label>
                <div class="input_d input_select">
                    <span>请选择</span>
                    <ul>
                        <li>
                            1-49
                        </li>
                        <li>
                            50-99
                        </li>
                        <li>
                            100-499
                        </li>
                        <li>
                            500-999
                        </li>
                        <li>
                            1000以上
                        </li>
                    </ul>
                </div>
                <div class="user_error2">
                    请输入用户名请输入用户名请输入用户名请输入用户名
                </div>
                <div class="user_error3">
                    输入正确
                </div>
            </div>
            <div class="clearfix chren_div">
                <label>&nbsp;</label>
                <div class="input_d file_div">
                    营业执照上传
                    <input type="file"/>
                </div>
                <div class="user_error1" style="display:block">
                    图片限定大小
                </div>
            </div>
            <div class="clearfix chren_div">
                <label>&nbsp;</label>
                <div class="input_d file_div">
                    纳税人资格证上传
                    <input type="file"/>
                </div>
                <div class="user_error1" style="display:block">
                    图片限定大小
                </div>
            </div>
        </div>
        <h3>支付信息</h3>
        <div class="name_pwd"  style="height:300px">
            <div class="clearfix chren_div ">
                <label><span style="color:red">*</span>支付方式</label>
                <div class="input_d input_select select_province Online_payment">
                    <span>请选择</span>
                    <ul>
                        <li>
                            在线支付
                        </li>
                        <li class="Payment_li">
                            账期支付
                        </li>
                    </ul>
                </div>
                <div class="input_d input_select select_city Payment" >
                    <span>请选择</span>
                    <ul>
                        <li>
                            月结
                        </li>
                        <li>
                            季度结算
                        </li>
                    </ul>
                </div>
            </div>
            <div class="clearfix chren_div">
                <label><span style="color:red">*</span>验证码</label>
                <div class="input_d" style="width: 115px">
                    <input type="text" class="code" ng-model="code" style="width: 95px"/>
                </div>
                <img  src="./resources/imgs/code.png" alt="" title="换一张" class="img_code"/>
                <span class="hun_span">看不清楚？<a href="javascript:void(0)">换一张</a></span>
                <div class="user_error1">
                    不能为空
                </div>
                <div class="user_error2">
                    用户名错误
                </div>
                <div class="user_error3">
                    输入正确
                </div>
            </div>
            <div class="clearfix chren_div" style="margin-top: 15px">
                <label>&nbsp;</label>
                <div class="input_d radio_r radio_r1 radio_r2" data="0">
                    我已阅读并同意
                </div>
                <div class="input_d radio_r radio_r3">
                    《Auto007用户协议》
                </div>
            </div>
            <input type="hidden" value="1">
            <div class="clearfix chren_div" style="margin-top: 15px">
                <label>&nbsp;</label>
                <div class="input_d submit_btn" ng-click="submit_two">
                    立即注册
                </div>

            </div>
        </div>
    </div>
    <!--个人注册-->
    <div class="border_div1">
        <div class="name_pwd" style="height: 700px">
            <div class="clearfix chren_div">
                <label><span style="color:red">*</span>用户名</label>
                <div class="input_d">
                    <input type="text" class="name" ng-model="Individual.name"  placeholder="请输入用户名"/>
                </div>
                <div class="remove_d">
                    <img src="./resources/imgs/remove.jpg"/>
                </div>
                <div class="user_error1">
                    4-20位字符，支持汉子、字母、数字的组合,不能以数字开头
                </div>
                <div class="user_error2 error1">
                    用户名错误
                </div>
                <div class="user_error3">
                    输入正确
                </div>
            </div>
            <div class="clearfix chren_div">
                <label><span style="color:red">*</span>设置密码</label>
                <div class="input_d">
                    <input type="password" class="pwd" ng-model="Individual.pwd" placeholder="请输入密码"/>
                </div>
                <div class="remove_d">
                    <img src="./resources/imgs/remove.jpg"/>
                </div>
                <div class="user_error1">
                    6-20位字符,以字母开头,只包含字符、数字和下划线
                </div>
                <div class="user_error2 error1">
                    请输入用户名请输入用户名请输入用户名请输入用户名
                </div>
                <div class="user_error3">
                    输入正确
                </div>
            </div>
            <div class="clearfix chren_div">
                <label><span style="color:red">*</span>确认密码</label>
                <div class="input_d">
                    <input type="password" class="pwd_agin" ng-model="Individual.agin" placeholder="请再次输入密码"/>
                </div>
                <div class="remove_d">
                    <img src="./resources/imgs/remove.jpg"/>
                </div>
                <div class="user_error1">
                    请确认输入密码
                </div>
                <div class="user_error2 error1">
                    请输入用户名请输入用户名请输入用户名请输入用户名
                </div>
                <div class="user_error3">
                    输入正确
                </div>
            </div>
            <div class="clearfix chren_div">
                <label><span style="color:red">*</span>邮箱地址</label>
                <div class="input_d">
                    <input type="text" class="email_e" ng-model="Individual.email" placeholder="请输入邮箱"/>
                </div>
                <div class="remove_d remove_r">
                    <img src="./resources/imgs/remove.jpg"/>
                </div>
                <div class="user_error1">
                    请输入邮箱
                </div>
                <div class="user_error2 error1">
                    错误
                </div>
                <div class="user_error3">
                    输入正确
                </div>
            </div>
            <div class="clearfix chren_div">
                <label><span style="color:red">*</span>手机号码</label>
                <div class="input_d">
                    <input type="text" class="telephone" ng-model="Individual.telephone" placeholder="请输入手机号"/>
                </div>
                <div class="remove_d">
                    <img src="./resources/imgs/remove.jpg"/>
                </div>
                <a class="button_a" href="javascript:void(0)" >获取手机验证码</a>
                <div class="user_error1">
                    请输入手机号
                </div>
                <div class="user_error2 error1">
                    错误
                </div>
                <div class="user_error3">
                    输入正确
                </div>
            </div>
            <div class="clearfix chren_div">
                <label><span style="color:red">*</span>短信验证码</label>
                <div class="input_d" style="width: 150px">
                    <input type="text" class="telephone_code" ng-model="Individual.telcode" placeholder="请输入短信验证码"/>
                </div>
                <div class="remove_d" style="left: 235px;">
                    <img src="./resources/imgs/remove.jpg"/>
                </div>
                <div class="user_error1">
                    请输入短信验证码
                </div>
                <div class="user_error2 error1">
                    错误
                </div>
                <div class="user_error3">
                    输入正确
                </div>
            </div>
            <div class="clearfix chren_div">
                <label><span style="color:red">*</span>验证码</label>
                <div class="input_d" style="width: 115px">
                    <input type="text" class="code" ng-model="Individual.code" style="width: 95px"/>
                </div>
                <img  src="./resources/imgs/code.png" alt="" title="换一张" class="img_code"/>
                <span class="hun_span">看不清楚？<a href="javascript:void(0)">换一张</a></span>
                <!--<div class="user_error1">-->
                    <!--不能为空-->
                <!--</div>-->
                <div class="user_error2 error1">
                    用户名错误
                </div>
                <div class="user_error3">
                    输入正确
                </div>
            </div>
            <div class="clearfix chren_div" style="margin-top: 15px">
                <label>&nbsp;</label>
                <div class="input_d radio_r radio_r1 radio_r2" data="0">
                    我已阅读并同意
                </div>
                <div class="input_d radio_r radio_r3">
                    《Auto007用户协议》
                </div>
            </div>
            <div class="clearfix chren_div" style="margin-top: 15px">
                <label>&nbsp;</label>
                <input type="hidden" class="sub1" value="1">
                <div class="input_d submit_btn" ng-click="submit_one()">
                    立即注册
                </div>

            </div>
        </div>
    </div>
    <!--商家注册-->
    <div class="border_div2">
        <div class="header_titile">服务须知：我们的审核时限为24小时(工作日)，遇法定节假日顺延。</div>
        <h3>账户信息</h3>
        <div class="name_pwd">
            <div class="clearfix chren_div">
                <label><span style="color:red">*</span>用户名</label>
                <div class="input_d">
                    <input type="text" class="name"  placeholder="请输入用户名"/>
                </div>
                <div class="remove_d">
                    <img src="./resources/imgs/remove.jpg"/>
                </div>
                <div class="user_error1">
                    不能以数字开头、限制为4-16个字符
                </div>
                <div class="user_error2">
                    用户名错误
                </div>
                <div class="user_error3">
                    输入正确
                </div>
            </div>
            <div class="clearfix chren_div">
                <label><span style="color:red">*</span>设置密码</label>
                <div class="input_d">
                    <input type="password" class="pwd" placeholder="请输入密码"/>
                </div>
                <div class="remove_d">
                    <img src="./resources/imgs/remove.jpg"/>
                </div>
                <div class="user_error1">
                    以字母开头，6-20位字符，包含字符、数字和下划线
                </div>
                <div class="user_error2">
                    请输入用户名请输入用户名请输入用户名请输入用户名
                </div>
                <div class="user_error3">
                    输入正确
                </div>
            </div>
            <div class="clearfix chren_div">
                <label><span style="color:red">*</span>确认密码</label>
                <div class="input_d">
                    <input type="password" class="pwd_agin"  placeholder="请再次输入密码"/>
                </div>
                <div class="remove_d">
                    <img src="./resources/imgs/remove.jpg"/>
                </div>
                <div class="user_error1">
                    请确认输入密码
                </div>
                <div class="user_error2">
                    请输入用户名请输入用户名请输入用户名请输入用户名
                </div>
                <div class="user_error3">
                    输入正确
                </div>
            </div>
        </div>
        <h3>联系人信息</h3>
        <div class="name_pwd" style="height:460px">
            <div class="clearfix chren_div">
                <label><span style="color:red">*</span>联系人姓名</label>
                <div class="input_d">
                    <input type="text" class="username"  placeholder="请输入联系人姓名"/>
                </div>
                <div class="remove_d">
                    <img src="./resources/imgs/remove.jpg"/>
                </div>
                <div class="user_error1">
                    不能以数字开头、限制为4-16个字符
                </div>
                <div class="user_error2">
                    联系人姓名错误
                </div>
                <div class="user_error3">
                    输入正确
                </div>
            </div>
            <div class="clearfix chren_div">
                <label><span style="color:red">*</span>所在部门</label>
                <div class="input_d input_select">
                    <span>请选择</span>
                    <ul>
                        <li>
                            safsaf
                        </li>
                        <li>
                            12321321
                        </li>
                        <li>
                            aaaaaaaa
                        </li>
                    </ul>
                </div>
                <div class="user_error2">
                    请输入用户名请输入用户名请输入用户名请输入用户名
                </div>
                <div class="user_error3">
                    输入正确
                </div>
            </div>
            <div class="clearfix chren_div">
                <label><span style="color:red">*</span>固定电话</label>
                <div class="input_d">
                    <input type="text" class="Fixed_telephone"  placeholder="请输入固定电话"/>
                </div>
                <div class="remove_d">
                    <img src="./resources/imgs/remove.jpg"/>
                </div>
                <div class="user_error1">
                    请输入固定电话
                </div>
                <div class="user_error2">
                    请输入用户名请输入用户名请输入用户名请输入用户名
                </div>
                <div class="user_error3">
                    输入正确
                </div>
            </div>
            <div class="clearfix chren_div">
                <label><span style="color:red">*</span>验证手机</label>
                <div class="input_d">
                    <input type="text" class="telephone"  placeholder="请输入手机号"/>
                </div>
                <div class="remove_d">
                    <img src="./resources/imgs/remove.jpg"/>
                </div>
                <a class="button_a" href="javascript:void(0)">获取手机验证码</a>
                <div class="user_error1">
                    请输入手机号
                </div>
                <div class="user_error2">
                    错误
                </div>
                <div class="user_error3">
                    输入正确
                </div>
            </div>
            <div class="clearfix chren_div">
                <label><span style="color:red">*</span>短信验证码</label>
                <div class="input_d" style="width: 150px">
                    <input type="text" class="telephone_code"  placeholder="请输入短信验证码"/>
                </div>
                <div class="remove_d" style="left: 235px;">
                    <img src="./resources/imgs/remove.jpg"/>
                </div>
                <div class="user_error1">
                    请输入短信验证码
                </div>
                <div class="user_error2">
                    错误
                </div>
                <div class="user_error3">
                    输入正确
                </div>
            </div>
            <div class="clearfix chren_div">
                <label><span style="color:red">*</span>邮箱地址</label>
                <div class="input_d">
                    <input type="text" class="email_e"  placeholder="请输入邮箱"/>
                </div>
                <div class="remove_d remove_r">
                    <img src="./resources/imgs/remove.jpg"/>
                </div>
                <div class="user_error1">
                    请输入邮箱
                </div>
                <div class="user_error2">
                    错误
                </div>
                <div class="user_error3">
                    输入正确
                </div>
            </div>
        </div>
        <h3>公司信息</h3>
        <div class="name_pwd" style="height:650px">
            <div class="clearfix chren_div">
                <label><span style="color:red">*</span>公司名称</label>
                <div class="input_d" style="width: 330px">
                    <input style="width: 300px" type="text" class="company"  placeholder="公司名称和营业执照名称一致，否则审核不通过"/>
                </div>
                <div class="remove_d" style="left: 415px;">
                    <img src="./resources/imgs/remove.jpg"/>
                </div>
                <div class="user_error1">
                    不能以数字开头、限制为4-16个字符
                </div>
                <div class="user_error2">
                    用户名错误
                </div>
                <div class="user_error3">
                    输入正确
                </div>
            </div>
            <div class="clearfix chren_div company_d">
                <label><span style="color:red">*</span>公司所在地</label>
                <div class="input_d input_select select_province">
                    <span>请选择</span>
                    <ul>
                        <li>
                            四川省
                        </li>
                        <li>
                            12321321
                        </li>
                        <li>
                            aaaaaaaa
                        </li>
                    </ul>
                </div>
                <p>省</p>
                <div class="input_d input_select select_city" >
                    <span>请选择</span>
                    <ul>
                        <li>
                            上海市
                        </li>
                        <li>
                            12321321
                        </li>
                        <li>
                            aaaaaaaa
                        </li>
                    </ul>
                </div>
                <p>市</p>
                <div class="input_d input_select select_area" >
                    <span>请选择</span>
                    <ul>
                        <li>
                            武侯区
                        </li>
                        <li>
                            12321321
                        </li>
                        <li>
                            aaaaaaaa
                        </li>
                    </ul>
                </div>
                <p>区</p>
                <div class="user_error2">
                    请输入用户名请输入用户名请输入用户名请输入用户名
                </div>
                <div class="user_error3">
                    输入正确
                </div>
            </div>
            <div class="clearfix chren_div">
                <label><span style="color:red">*</span>公司地址</label>
                <div class="input_d" style="width: 330px">
                    <input style="width: 300px" type="text" class="address"  placeholder="公司地址和营业执照地址一致，否则审核不通过"/>
                </div>
                <div class="remove_d" style="left: 415px;">
                    <img src="./resources/imgs/remove.jpg"/>
                </div>
                <div class="user_error1">
                    <!--含有汉字、数字、字母、下划线-->
                    不能以下划线开头和结尾
                </div>
                <div class="user_error2">
                    错误
                </div>
                <div class="user_error3">
                    输入正确
                </div>
            </div>
            <div class="clearfix chren_div">
                <label><span style="color:red">*</span>公司人数</label>
                <div class="input_d input_select">
                    <span>请选择</span>
                    <ul>
                        <li>
                            1-49
                        </li>
                        <li>
                            50-99
                        </li>
                        <li>
                            100-499
                        </li>
                        <li>
                            500-999
                        </li>
                        <li>
                            1000以上
                        </li>
                    </ul>
                </div>
                <div class="user_error2">
                    请输入用户名请输入用户名请输入用户名请输入用户名
                </div>
                <div class="user_error3">
                    输入正确
                </div>
            </div>
            <div class="clearfix chren_div">
                <label>&nbsp;</label>
                <div class="input_d file_div">
                    营业执照上传
                    <input type="file"/>
                </div>
                <div class="user_error1" style="display:block">
                    图片限定大小
                </div>
            </div>
            <div class="clearfix chren_div">
                <label>&nbsp;</label>
                <div class="input_d file_div">
                    纳税人资格证上传
                    <input type="file"/>
                </div>
                <div class="user_error1" style="display:block">
                    图片限定大小
                </div>
            </div>
            <div class="clearfix chren_div">
                <label><span style="color:red">*</span>验证码</label>
                <div class="input_d" style="width: 115px">
                    <input type="text" class="code" ng-model="code" style="width: 95px"/>
                </div>
                <img  src="./resources/imgs/code.png" alt="" title="换一张" class="img_code"/>
                <span class="hun_span">看不清楚？<a href="javascript:void(0)">换一张</a></span>
                <div class="user_error1">
                    不能为空
                </div>
                <div class="user_error2">
                    用户名错误
                </div>
                <div class="user_error3">
                    输入正确
                </div>
            </div>
            <div class="clearfix chren_div" style="margin-top: 15px">
                <label>&nbsp;</label>
                <div class="input_d radio_r radio_r1">
                    我已阅读并同意
                </div>
                <div class="input_d radio_r radio_r3">
                    《Auto007用户协议》
                </div>
            </div>
            <div class="clearfix chren_div" style="margin-top: 15px">
                <label>&nbsp;</label>
                <div class="input_d submit_btn">
                    立即注册
                </div>

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


<!--灰色蒙版-->
<div class="Gray_mask"></div>
<!--协议弹出层-->
<div class="Pop_up">
    <p class="clearfix">
        <label>Auto007用户协议</label>
        <img src="./resources/imgs/close.png" class="close_img" title="关闭"/>
    </p>
    <div class="content_d">
        sadsadsadsadsadsadsadsadsadsaddnsfdhs年第三方vdsffjdsf仿佛看见回复肯定是会计师对回复
        sadsadsadsadsadsadsadsadsadsaddnsfdhs年第三方vdsffjdsf仿佛看见回复肯定是会计师对回复
        sadsadsadsadsadsadsadsadsadsaddnsfdhs年第三方vdsffjdsf仿佛看见回复肯定是会计师对回复
    </div>
    <button>同意并继续</button>
</div>
<script type="text/javascript" src="./resources/javaScript/jQuery/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="./resources/javaScript/angular/angular.min.js"></script>
<script type="text/javascript" src="./resources/javaScript/jQuery/json2.js"></script>
<script type="text/javascript" src="./resources/script/user/placeholder.js"></script>
<script type="text/javascript" src="./resources/script/user/registered.js"></script>
<script type="text/javascript">



</script>
</body>
</html>