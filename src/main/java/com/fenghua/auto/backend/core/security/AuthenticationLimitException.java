package com.fenghua.auto.backend.core.security;

import org.springframework.security.authentication.AccountStatusException;

/** 
  *<des>
  *
  * 登录次数限制异常类
  *</des>
  * @author  lijie
  * @date 2015年11月3日
  * @version 
  */
public class AuthenticationLimitException extends AccountStatusException {

	public AuthenticationLimitException(String msg) {
		super(msg);
	}


	public AuthenticationLimitException(String msg, Throwable t) {
		super(msg, t);
	}
}
