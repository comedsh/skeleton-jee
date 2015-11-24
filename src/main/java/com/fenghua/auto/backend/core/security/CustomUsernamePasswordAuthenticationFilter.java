package com.fenghua.auto.backend.core.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.util.StringUtils;


/** 
  *<des>
  *
  * 扩展用户名密码认证过滤器
  *  重写 attemptAuthentication 方法,对一些额外信息进行验证
  *  
  * 
  *</des>
  *
  * @author  lijie
  * @date 2015年10月21日
  * @version 
  */
public class CustomUsernamePasswordAuthenticationFilter extends UsernamePasswordAuthenticationFilter{

	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			 throws AuthenticationException{
		
		
		if (!request.getMethod().equals("POST")) {
			throw new AuthenticationServiceException(
					"Authentication method not supported: " + request.getMethod());
		}
		
	
		checkValidateCode(request);
		
		String username = obtainUsername(request);
		String password = obtainPassword(request);

		if (username == null) {
			username = "";
		}

		if (password == null) {
			password = "";
		}

		username = username.trim();

		
		CustomUsernamePasswordAuthenticationToken authRequest = new CustomUsernamePasswordAuthenticationToken(username, password);

		// Allow subclasses to set the "details" property
		setDetails(request, authRequest);

		try{
			
			Authentication authentication = this.getAuthenticationManager().authenticate(authRequest);	
			removeInputVCode(request);
			return authentication;
		}catch(AuthenticationException e){
			checkLimitLogin(request);
			throw e;
		}
    }
	
	
	/**
	 * 检查验证码
	 */
	private void checkValidateCode(HttpServletRequest request) throws AuthenticationException{
		String vCode = request.getParameter("vCode");
		if(StringUtils.isEmpty(vCode))
			return;
		//验证验证码 AuthenticationCodeException
		//比对保存在session中的验证码
		String verifyCode = (String) request.getSession().getAttribute("rand");
		if(!vCode.equals(verifyCode)){
			throw new AuthenticationCodeException("invalid code");
		}
		   
	}
	
	/**
	 * 检查用户登录次数
	 */
	private void checkLimitLogin(HttpServletRequest request) throws AuthenticationException{
		HttpSession s = request.getSession(false);
		if(s == null)
			return;
		
		Object limitCounts = s.getAttribute("_t");
		if(limitCounts == null){
			limitCounts = 0;
		}
		int count = (int) limitCounts+1;
		s.setAttribute("_t", count);
	
		if(count > 3){
			//throw new AuthenticationLimitException("locked account");
			request.setAttribute("showVCode", true);
		}	
	}
	
	private void removeInputVCode(HttpServletRequest request){
		request.removeAttribute("showVCode");
	}
	
	
}
