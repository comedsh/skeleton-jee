package com.fenghua.auto.webapp.controller.securtity;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.logout.LogoutFilter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fenghua.auto.backend.core.security.AuthenticationCodeException;
import com.fenghua.auto.backend.core.security.AuthenticationLimitException;
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
	
	/** Session失效
	 * @return
	 */
	@RequestMapping(value="/session/invalid",method=RequestMethod.GET)
	public ModelAndView invalid() {
		logger.debug("会话 超时");
		return new ModelAndView("/login");
	}
	
	
	/**
	 * 退出系统
	 * @return
	 */
	@RequestMapping(value="/logout")
	public ModelAndView logout() {
		HashMap<String,Result> model = new HashMap<String,Result>();
		Result msg = new Result(true,"退出成功");
		model.put("message", msg);
		return new ModelAndView("/login",model);
	}
		
	/**
	 * 登录调用接口
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/userCenter", method = RequestMethod.POST)
	public @ResponseBody Map<String,Result> userCenter(HttpServletRequest request) {
		Map<String,Result> model = new HashMap<String,Result>();
		Result msg = new Result(true,"登录成功");
		model.put("message", msg);
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
		return "/WEB-INF/views/user/userCenter/userCenter";
	}
	
	/**
	 * 跳转到登录页面
	 * @param user
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/fowardLogin")
	public String showLoginPage() {
		return "/login";
	}
	
	/**
	 * 登录 失败
	 * @return
	 */
	@RequestMapping(value="/failure",method=RequestMethod.POST)
	@ResponseBody
	public  Map<String,Result> failure(HttpServletRequest request) {
		
		Exception e = (Exception)request.getSession().getAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
			
		
		//需移入service处理类
		
		 Result result = new Result();
		//用户不存在
	    if(e instanceof UsernameNotFoundException){
	    	result.setMsg("用户名不存在");
		}
	    //用户名或密码错误
        if(e instanceof BadCredentialsException){
        	result.setMsg("用户名或密码错误");
		}
        //登录次数大于等于3次
		if(e instanceof AuthenticationLimitException){
			//限制登录异常信息
			result.setCode("1001");
		}
	    //输入验证码错误
        if(e instanceof AuthenticationCodeException){
        	result.setMsg("验证码错误");
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
