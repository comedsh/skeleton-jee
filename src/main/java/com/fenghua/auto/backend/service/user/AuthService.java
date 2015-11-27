package com.fenghua.auto.backend.service.user;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.fenghua.auto.backend.core.security.UserInfo;
import com.fenghua.auto.backend.domain.user.User;
import com.qq.connect.QQConnectException;

/**
 * 第三方登陆验证
 * @author thinkpad
 *
 */
@Service
public interface AuthService {
	/**
	 * qq验证
	 * 返回用户代表ciqq号码已经绑定了用户 ，否则返回null
	 * @param request
	 * @return 返回登陆用户
	 */
	User isUser(HttpServletRequest request) throws QQConnectException;
	/**
	 * 绑定qq
	 */
	void binding(UserInfo userInfo);
}
