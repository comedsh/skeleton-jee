package com.fenghua.auto.backend.aop;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;

import javax.annotation.Resource;
import javax.mail.Address;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.fenghua.auto.backend.core.utills.mail.MailSenderInfo;
import com.fenghua.auto.backend.core.utills.mail.SimpleMailSender;

@Component
@Aspect
public class PerformanceListener {
	
	private static final Log LOG = LogFactory.getLog(PerformanceListener.class);
	
	@Resource
	private long performanceTimeThreshold; 
	
	@Resource
	private String performanceReceiver;
	@Resource
	private String performanceCclist;

	@Resource
	private String smtpHost;
	@Resource
	private String smtpPort;
	@Resource
	private String mailSender;
	@Resource
	private String mailPwd;
	
	// 定义一个切入点
	@Pointcut("execution(* com.fenghua.auto.backend.dao.impl.*.*(..))")
	private void aspect() {
	}

	@Around("aspect()")
	public Object doBasicProfiling(ProceedingJoinPoint pjp) throws Throwable {
		
		final String className = pjp.getTarget().getClass().getName();
		final Object [] args = pjp.getArgs();
		final String method = pjp.toShortString().split("\\.")[1].replace("(", "");
		
		long start = System.currentTimeMillis();
		Object object = pjp.proceed();// 执行该方法
		long end = System.currentTimeMillis();
		
		final long excuteTime = end - start;
		LOG.debug(className+"."+method+"(..) : " + excuteTime + "(ms)");
		
		if(excuteTime > performanceTimeThreshold){
			Executors.newCachedThreadPool().execute(new Thread(){
				@Override
				public void run() {
					MailSenderInfo mailInfo = new MailSenderInfo();
					mailInfo.setMailServerHost(smtpHost);
					mailInfo.setMailServerPort(smtpPort);
					mailInfo.setValidate(true);
					mailInfo.setUserName(mailSender); // 实际发送者
					mailInfo.setPassword(mailPwd);// 您的邮箱密码
					mailInfo.setFromAddress(mailSender); // 设置发送人邮箱地址
					mailInfo.setToAddress(performanceReceiver);
					if(StringUtils.isNotBlank(performanceCclist)){
						List<Address> addrList= new ArrayList<Address>();
						for(String addr : performanceCclist.split(",")){
							try {
								addrList.add(new InternetAddress(addr.trim()));
							} catch (AddressException e) {
								e.printStackTrace();
							}
						}
						
						Address[] addrArray = new Address[addrList.size()];
						addrList.toArray(addrArray);
						mailInfo.setCcList(addrArray);
					}
					
					mailInfo.setSubject("【性能告警】"+(className+"."+method+"(..) : "+ excuteTime + "(ms)"));
					StringBuilder params = new StringBuilder();
					
					for(int i=0;i<args.length;i++){
						params.append(" 参数").append(i+1).append("： <br /> ").append(args[i]).append("<br /> ");
					}
					mailInfo.setContent(params.toString());
					
					try {
						SimpleMailSender.sendHtmlMail(mailInfo);
					} catch (Exception e) {
						LOG.error("doBasicProfiling Exception:", e);
					}
				}
			});
		}
		
		return object;
	}
}
