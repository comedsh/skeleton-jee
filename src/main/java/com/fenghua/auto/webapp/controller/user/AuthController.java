package com.fenghua.auto.webapp.controller.user;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.fenghua.auto.backend.core.security.CustomAccessDecisionManager;
import com.fenghua.auto.backend.domain.user.User;
import com.fenghua.auto.backend.service.security.CustomUserDetailService;
import com.fenghua.auto.backend.service.user.AuthService;
import com.fenghua.auto.backend.service.user.UserService;
import com.qq.connect.QQConnectException;
import com.qq.connect.api.OpenID;
import com.qq.connect.javabeans.AccessToken;
import com.qq.connect.oauth.Oauth;

/**
 * 第三方账号授权
 * 
 * @author zhangfr
 *
 */
@Controller
@RequestMapping("/auth")
public class AuthController {
	@Autowired
	private UserService userService;
	@Autowired
	private AuthService authService;
	/**
	 * 跳转到qq授权视图
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/qq")
	public String qqAuth(HttpServletRequest request) {
		String qqUrl = null;
		try {
			qqUrl = new Oauth().getAuthorizeURL(request);
		} catch (QQConnectException e) {
			e.printStackTrace();
		}
		return "redirect:" + qqUrl;
	}
	/**
	 * qq登陆授权后回掉地址
	 * @param request
	 * @return
	 */
	@RequestMapping("/afterlogin")
	public String afterlogin(HttpServletRequest request) {
		try {
			User user=authService.isUser(request);
			if(user!=null){
				userService.autoLogin(user.getName(), user.getPassword(), new Locale(""), request);
//				return new ModelAndView("/");
				return "redirect:/.action";
			}else {
				//return new ModelAndView("/registered.jsp");
				return "redirect:/registered.jsp?xx=";
			}
		} catch (QQConnectException e) {
			e.printStackTrace();
			//return new ModelAndView("/login.jsp");
		}
		return null;
	}
}
