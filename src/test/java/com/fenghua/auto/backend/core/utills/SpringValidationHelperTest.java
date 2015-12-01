package com.fenghua.auto.backend.core.utills;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.fenghua.auto.backend.domain.CommonMessageTransferObject;
import com.fenghua.auto.backend.domain.MessageTransferObject;
import com.fenghua.auto.backend.domain.education.Spittle;
import com.fenghua.auto.backend.domain.user.User;

/**
 * @author shang yang
 *
 * @version 
 *
 * @createTime：2015年12月1日 上午10:45:45 
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"/spring-context.xml", "/spring-security.xml", "/spring-mybatis.xml"})
public class SpringValidationHelperTest {
	
	/**
	 * 
	 * @author shang yang
	 *
	 * @version 
	 * 
	 * @createTime: 2015年12月1日 上午10:46:29
	 *
	 */
	@Test
	public void testValidate(){
		
		MessageTransferObject mto = new CommonMessageTransferObject();
		
		mto = SpringValidationHelper.validate( Spittle.class, "123", "username");
		
		Assert.assertEquals( "用户名必须在 4 到 20 个字符之间", mto.getErrors()[0].getError() );
		
		mto = SpringValidationHelper.validate( User.class, "123", "name");
		
		Assert.assertEquals( "4-20位字符,支持汉字、字母、数字的组合,不能以数字开头", mto.getErrors()[0].getError() );
		
	}
	
	
	
}
