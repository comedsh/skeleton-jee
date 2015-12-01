 package com.fenghua.auto.backend.service.user.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fenghua.auto.backend.core.security.UserInfo;
import com.fenghua.auto.backend.core.utills.QQtokenUtils;
import com.fenghua.auto.backend.core.utills.UserSecurityUtils;
import com.fenghua.auto.backend.dao.user.UserDao;
import com.fenghua.auto.backend.domain.user.User;
import com.fenghua.auto.backend.service.user.AuthService;
import com.fenghua.auto.backend.service.user.UserService;
import com.qq.connect.QQConnectException;

/**
 * qq登陆验证实现
 * 
 * @author zhangfr
 *
 */
@Service
public class AuthServiceImpl implements AuthService {
	private static final Logger logger = LoggerFactory.getLogger(AuthServiceImpl.class);
	@Autowired
	private UserDao userDao;
	@Autowired
	private UserService userService;

	@Override
	public User isUser(HttpServletRequest request) throws QQConnectException {
			String QQtoken=QQtokenUtils.getAccessTokenFromQQ(request);
			if(QQtoken==null){
				throw new QQConnectException("qq绑定异常！");
			}
			String QQopenID=QQtokenUtils.getOpenID(QQtoken);
			request.getSession().setAttribute("QQtoken", QQtoken);
			request.getSession().setAttribute("QQopenID", QQopenID);
			User user = userService.getUserByQQ(QQopenID);
			if(user==null){
				logger.debug("判断是否为qq绑定用户:账户未绑定  --end");
			}
			return user;
		}
	
	@Override
	public void binding(UserInfo userInfo) {
		String QQopenID = (String) UserSecurityUtils.getSession().getAttribute("QQopenID");
		if (QQopenID != null) {
			logger.debug("开始绑定qq账户----start");
			binding(QQopenID,userInfo);
			UserSecurityUtils.getSession().removeAttribute("QQopenID");
			logger.debug("成功绑定qq账户----end");
		}
	}
	/**
	 * 根据用户id更新用户绑定的qq号
	 * @param qqOpenID
	 * @param userInfo
	 */
	private void binding(String qqOpenID,UserInfo userInfo) {
		userService.updateQQNumberByUserID(qqOpenID,userInfo.getUserId());
		logger.debug("当前账户绑定的qq号为----"+qqOpenID);
	}
}
