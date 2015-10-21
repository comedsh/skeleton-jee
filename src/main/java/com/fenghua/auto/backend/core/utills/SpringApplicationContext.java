package com.fenghua.auto.backend.core.utills;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.ContextLoader;


/** 
  * <des>
  * 对Spring ApplicationContext进行二次封装，
  * 配置到applicationContext文件中
  * </des>
  * 
  * @author  lijie
  * @date 2015年10月20日
  * @version 
  */
public class SpringApplicationContext implements ApplicationContextAware {
		private static final Logger logger = LoggerFactory.getLogger(SpringApplicationContext.class);

		private static ApplicationContext applicationContext;
		
		private static String springContextPath = "spring-context.xml";

		/**
		 * 使用泛型，不需再进行类型转换
		 * 
		 * @param <T>
		 * @param beanName
		 * @return
		 */
		public static <T> T getBean(String beanName) {
			try {
				logger.debug("Get Java Bean with name:{}", beanName);
				return (T) getContext().getBean(beanName);
			} catch (Exception e) {
				logger.error("对象获取失败：{}", e.getMessage());
			}
			return null;
		}

		public static ApplicationContext getContext() {
	        init();
			return applicationContext;
		}
		
		private static void init() {
			if (applicationContext == null) {
				applicationContext = ContextLoader.getCurrentWebApplicationContext();
			}

			if (applicationContext == null) {
				applicationContext = new ClassPathXmlApplicationContext(springContextPath);
			}		
		}

		@Override
		public void setApplicationContext(ApplicationContext applicationContext)
				throws BeansException {
			SpringApplicationContext.applicationContext = applicationContext;
		}
}
