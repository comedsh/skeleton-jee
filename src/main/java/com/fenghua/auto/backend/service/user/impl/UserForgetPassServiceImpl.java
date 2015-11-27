package com.fenghua.auto.backend.service.user.impl;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.mail.MessagingException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.fenghua.auto.backend.core.utills.mail.MailSenderInfo;
import com.fenghua.auto.backend.core.utills.mail.SimpleMailSender;
import com.fenghua.auto.backend.dao.ConfigDao;
import com.fenghua.auto.backend.dao.user.UserDao;
import com.fenghua.auto.backend.dao.user.UserForgetPassDao;
import com.fenghua.auto.backend.domain.user.Config;
import com.fenghua.auto.backend.domain.user.ResetPassRequest;
import com.fenghua.auto.backend.domain.user.User;
import com.fenghua.auto.backend.service.user.UserForgetPassService;
/**
 * 忘记密码接口实现
 * @author heting
 *
 */
@Service
public class UserForgetPassServiceImpl implements UserForgetPassService {
	private static final Log LOG = LogFactory.getLog(UserForgetPassServiceImpl.class);
	@Autowired
	private UserForgetPassDao userForgetPassDao;
	@Autowired
	private UserDao userDao;
	@Autowired
	private BCryptPasswordEncoder encoder;
	@Autowired
	private ConfigDao configDao;
	@Override
	public void insert(String email) {
		String encodeString=encoder.encode(email+UUID.randomUUID().toString());
		List<User> list=null;
		Long userId=null;
//		Calendar c = Calendar.getInstance();
//		long time = c.getTimeInMillis();
//		String token_exptime=(time+1000*20)+"";//获取超时时间 
		//获取发邮件链接超时间隔时间
		Config config=null;	
		config=configDao.selectByConfigName("email_effetime");
		String effectime=(config==null)?"0":config.getConfigValue();
		int effectimeIn=Integer.parseInt(effectime);
		Timestamp token_exptime = new Timestamp(System.currentTimeMillis() + effectimeIn * 60 * 1000);
		list =userDao.selectByEmail(email);
		//获取用户id
		if(list!=null){
		 userId=list.get(0).getId();
		}
		ResetPassRequest resetPassRequest=new ResetPassRequest();
		resetPassRequest.setUserId(userId);
		resetPassRequest.setCertificateCode(encodeString);
		resetPassRequest.setValidTo(token_exptime);
		//保存找回密码链接信息
		userForgetPassDao.insert(resetPassRequest);
		MailSenderInfo mailInfo = new MailSenderInfo();
	
		mailInfo.setValidate(true);
		this.sendResetPasswordEmail(mailInfo,userId,encodeString,email);
		
	}
	/**
	 * 发送邮件
	 * @param mailInfo
	 */
	
	private void sendResetPasswordEmail(MailSenderInfo mailInfo,Long userId,String encodeString,String email) {
		mailInfo.setMailServerHost("smtp.mxhichina.com");
		mailInfo.setMailServerPort("25");
		mailInfo.setUserName("noreply@auto007.com"); // 实际发送者
		mailInfo.setPassword("WXQP123.");// 您的邮箱密码
		mailInfo.setFromAddress("noreply@auto007.com"); // 设置发送人邮箱地址
		mailInfo.setToAddress(email);
		mailInfo.setSubject("找回您的账户密码");
         String resetPassHref = "http://localhost:8080/user/checkResetLink?token="
                 + encodeString +"&userId="+userId;
		 String emailContent = "请勿回复本邮件.点击下面的链接,重设密码<br/><a href="
                 + resetPassHref + " target='_BLANK'>" + resetPassHref
                 + "</a>";
		mailInfo.setContent(emailContent);
		SimpleMailSender sms = new SimpleMailSender();
		try {
			sms.sendHtmlMail(mailInfo);
		} catch (MessagingException e) {
			LOG.error("doBasicProfiling Exception:", e);
			e.printStackTrace();
		}
	}
	@Override
	public List<ResetPassRequest> selectByCodeAndUser(String certificateCode,Long UserId) {
		Map<String,Object> map = new HashMap<String,Object>();	
		map.put("certificateCode", certificateCode);
		map.put("UserId", UserId);
		return userForgetPassDao.selectByCodeAndUser(map);
	}
	@Override
	public void deleteByUserId(Long UserId) {
		userForgetPassDao.deleteByUserId(UserId);
	}

}
