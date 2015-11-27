package com.fenghua.auto.backend.service.user.impl;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fenghua.auto.backend.core.security.UserInfo;
import com.fenghua.auto.backend.core.utills.UserSecurityUtils;
import com.fenghua.auto.backend.dao.user.UserDao;
import com.fenghua.auto.backend.domain.user.User;
import com.fenghua.auto.backend.service.user.AuthService;
import com.fenghua.auto.backend.service.user.UserService;
import com.qq.connect.QQConnectException;
import com.qq.connect.api.OpenID;
import com.qq.connect.javabeans.AccessToken;
import com.qq.connect.oauth.Oauth;

/**
 * qq登陆验证实现
 * 
 * @author zhangfr
 *
 */
@Service
public class AuthServiceImpl implements AuthService {
	@Autowired
	private UserDao userDao;
	@Autowired
	private UserService userService;

	@Override
	public User isUser(HttpServletRequest request) throws QQConnectException {
		AccessToken accessTokenObj = (new Oauth())
				.getAccessTokenByRequest(request);
		String accessToken = null, openID = null;
		long tokenExpireIn = 0L;
		if (accessTokenObj.getAccessToken().equals("")) {
			throw new QQConnectException("qq登陆异常异常！");
		} else {
			accessToken = accessTokenObj.getAccessToken();
			request.getSession().setAttribute("qq_access_token", accessToken);

			// request.getSession().setAttribute("demo_token_expirein",String.valueOf(tokenExpireIn));

			// 利用获取到的accessToken 去获取当前用的openid
			OpenID openIDObj = new OpenID(accessToken);
			openID = openIDObj.getUserOpenID();
			User user = userService.getUserByQQ(openID);
			return user;
		}
	}
	@Override
	public void binding(UserInfo userInfo) {
		HttpSession session = UserSecurityUtils.getSession();
		String qqtoken = (String) session.getAttribute("qqtoken");
		if (qqtoken != null) {
			binding(qqtoken,userInfo);
		}
	}
	public void binding(String qqtoken,UserInfo userInfo) {
		User user = userService.getUserById(userInfo.getUserId());
		user.setQqNumber(qqtoken);
		userService.update(user);
	}
}
