package com.fenghua.auto.backend.core.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationServiceException;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


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

		return this.getAuthenticationManager().authenticate(authRequest);		
    }
}
