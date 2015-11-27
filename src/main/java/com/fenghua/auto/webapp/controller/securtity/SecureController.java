package com.fenghua.auto.webapp.controller.securtity;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.WebAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.fenghua.auto.backend.core.security.AuthenticationCodeException;
import com.fenghua.auto.webapp.view.Result;

/** 
  *<des>
  *
  * 控制用户登录
  * 
  *</des>
  * @author  lijie
  * @date 2015年11月4日
  * @version 
  */
@Controller
@RequestMapping("/secure")
public class SecureController {
	private static final Logger logger = LoggerFactory.getLogger(SecureController.class);
	
	 @Autowired
     @Qualifier("org.springframework.security.authenticationManager")//编辑软件会提示错误
     private static AuthenticationManager authenticationManager;
	
	/** Session失效
	 * @return
	 */
	@RequestMapping(value="/session/invalid",method=RequestMethod.GET)
	public String invalid() {
		logger.debug("会话 超时");
		return "web.login";
	}
	
	
	/**
	 * 退出系统
	 * @return
	 */
	@RequestMapping(value="/logout")
	public String logout() {
		return "web.login";
	}
		
	/**
	 * 登录调用接口
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/userCenter")
	@ResponseBody
	public Map<String,Result> userCenter(HttpServletRequest request) {
		Map<String,Result> model = new HashMap<String,Result>();
		Result msg = new Result();
		msg.setCode("1");
		msg.setMsg("登录成功");
		model.put("msg", msg);
		return model;
	}
	
	/**
	 * 登录成功后，跳转到用户中心
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/main")
	public String main(Model model,HttpServletRequest request) {
		return "user.center";
	}
	
	/**
	 * 跳转到登录页面
	 * @param user
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/fowardLogin")
	public ModelAndView showLoginPage(HttpServletRequest req, HttpServletResponse res, Model model) {
		Map<String,String> map = new HashMap<String, String>();
		map.put("userName", req.getParameter("userName"));
		return new ModelAndView("register.success",map);
	}
	
	/**
	 * 登录 失败
	 * @return
	 */
	@RequestMapping(value="/failure",method=RequestMethod.POST)
	@ResponseBody
	public  Map<String,Result> failure(HttpServletRequest request, HttpServletResponse response) {
		//forward 从requet取
		Exception e =  (Exception)request.getAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
		if(e == null){
			 //非forward 从 seesion取
			 e = (Exception)request.getSession().getAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
		}
	
		//需移入service处理类		
		Result result = new Result();
		//用户不存在
	    if(e instanceof UsernameNotFoundException){
	    	result.setCode("-1");
	    	result.setMsg("用户名不存在");
		}
	    //用户名或密码错误
        if(e instanceof BadCredentialsException){
        	result.setCode("-2");
        	result.setMsg("用户名或密码输入错误");
		}
	    //输入验证码错误
        if(e instanceof AuthenticationCodeException){
        	result.setCode("-3");
        	result.setMsg("验证码错误");
		}  
        
        Object showVCode =  request.getAttribute("showVCode");
        boolean isShow = showVCode == null? false:(Boolean)showVCode;
        if(isShow){
         	result.setCode("-4");
         	result.setMsg("已经错误三次，显示验证码");
        }  
       
        Map<String,Result> model = new HashMap<String,Result>();
        model.put("msg", result);
        return model;
	}
	

	/**
	 * 403
	 * @return
	 */
	@RequestMapping(value="/403",method=RequestMethod.GET)
	public ModelAndView forbidden() {
    
		
		return new ModelAndView("/secure/403",null);
	}
	
	
}
