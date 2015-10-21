package com.fenghua.auto.test;

import static org.easymock.EasyMock.*;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.fenghua.auto.backend.core.utills.SpringApplicationContext;


/**
 * <des> 
 *   Junit 测试基类
 * </des>
 * @author lijie
 * @date 2015年10月20日
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
public abstract class AbstractTest {
	
	 @Autowired(required=false)
	 protected ApplicationContext applicationContext;
	
	/**
	 * 创建ApplicationContext Mock对象用于代替真实的ApplicationContext，来获取指定的对象
	 * @param returnValue
	 * @param times
	 */
	protected void createApplicationContextMock(Object returnValue,int times) {
		ApplicationContext applicationContextMock = createMock(ApplicationContext.class);
		//mock 设置预期值
		expect(applicationContextMock.getBean(isA(String.class))).andReturn(returnValue).times(times);
		//设置mock 对象为可使用状态 
		replay(applicationContextMock);
		
		SpringApplicationContext sac = new SpringApplicationContext();
		sac.setApplicationContext(applicationContextMock);
	}
	
	/**
	 * 将ApplicationContext恢复为真实的环境对象
	 */
	protected void reacoveApplicationContext() {
		SpringApplicationContext sac = new SpringApplicationContext();
		sac.setApplicationContext(applicationContext);
	}
	
}
