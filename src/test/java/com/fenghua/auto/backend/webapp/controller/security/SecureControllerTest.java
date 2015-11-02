
package com.fenghua.auto.backend.webapp.controller.security;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.formLogin;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.authenticated;
import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.unauthenticated;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.Filter;

import org.easymock.EasyMock;
import org.easymock.IMocksControl;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


import com.fenghua.auto.backend.domain.securtity.Account;
import com.fenghua.auto.backend.domain.securtity.Resource;
import com.fenghua.auto.backend.domain.securtity.Role;
import com.fenghua.auto.backend.service.security.AccountService;
import com.fenghua.auto.backend.service.security.CustomUserDetailService;
import com.fenghua.auto.backend.service.security.InvocationSecurityMetadataSourceService;
import com.fenghua.auto.backend.service.security.ResourceService;
import com.fenghua.auto.test.AbstractControllerTest;

/** 
  *<des>
  *
  *

	 * 
	 * 测试规则
	 *   用户：密码：test1：test1, 
	 *           test2:test2
	 *   角色 ： admin，user
	 *   资源： /manage/add, /manage/query
	 *   
	 *   test1 具有 admin 权限，可以访问 /manage/add, /manage/query
	 *   test2 具有 user  权限，可以访问  /manage/query
	 *

  *</des>
  * @author  lijie
  * @date 2015年10月26日
  * @version 
  */
@ContextConfiguration({"/spring-security.xml"})
@WebAppConfiguration
public class SecureControllerTest  extends AbstractControllerTest {
	
	@Autowired
	InvocationSecurityMetadataSourceService invocationSecurityMetadataSourceService;
	
	@Autowired
	CustomUserDetailService customUserDetailService;
	
	@Autowired
    BCryptPasswordEncoder encoder;
	
    @Autowired
    private WebApplicationContext context; 
    
    @Autowired
    private Filter springSecurityFilterChain;

    private MockMvc mocMvc;
	
	
	@Before
	public void setUp() {				
		 super.setUp();
	
		 assertNotNull(context);
		 assertNotNull(springSecurityFilterChain);
		 //创建webapp 上下文
		 mocMvc = MockMvcBuilders.webAppContextSetup(context)
				 .addFilters(springSecurityFilterChain)
	              .build();
		 
		 IMocksControl control = EasyMock.createControl();
		 
		 ResourceService  resourceService = control.createMock(ResourceService.class);
		 //构建资源 -权限   数据
		 
		 List<Resource> resources = new ArrayList<Resource>();
		 //admin 可以新增
		 Resource resoucre = new Resource();
		 resoucre.setId("1");
		 resoucre.setName("新增用户");
		 resoucre.setUrl("/manage/add");
		 
		 Set<Role> roleSet = new HashSet<Role>();
		 roleSet.add(new Role("1", "admin"));		 
		 resoucre.setRoleSet(roleSet);
		 resources.add(resoucre);
		 
		 //admin 和 user 角色 可以查询
		 resoucre = new Resource();
		 resoucre.setId("2");
		 resoucre.setName("查询用户");
		 resoucre.setUrl("/manage/query");
		 
		 roleSet = new HashSet<Role>();
		 roleSet.add(new Role("1", "admin"));
		 roleSet.add(new Role("2", "user"));
		 
		 resoucre.setRoleSet(roleSet);
		 
		 resources.add(resoucre);
		 
		 assertEquals(2, resources.size());
		 
		 //构建 resourceService 对象
		 EasyMock.expect(resourceService.findAll()).andReturn(resources).anyTimes();
	
		 //构建accountService 对象
		 AccountService accountService = control.createMock(AccountService.class);
		 
		 //test1 具有 admin权限
		 Account account = new Account();
		 account.setName("test1");
		 account.setPassword("test1");
		 
		 Set<Role> accountRoleSet = new HashSet<Role>();
		 accountRoleSet.add(new Role("1", "admin"));	
		 account.setRoleSet(accountRoleSet);
	
		 
		 EasyMock.expect(accountService.getAccountByName("test1")).andReturn(account).anyTimes();
		
		 
		 //test2 具有 user 权限
		 account = new Account();
		 account.setName("test2");
		 account.setPassword("test2");
		 
		 accountRoleSet = new HashSet<Role>();
		 accountRoleSet.add(new Role("2", "user"));	
		 account.setRoleSet(accountRoleSet);
		 
		 EasyMock.expect(accountService.getAccountByName("test2")).andReturn(account).anyTimes();
		 
		 
		 control.replay();
		 
		 assertNotNull(resourceService);
		 assertNotNull(accountService);
		 
		 invocationSecurityMetadataSourceService.setResourceService(resourceService);
		 invocationSecurityMetadataSourceService.loadResourceDefine();
		 
		 customUserDetailService.setAccountService(accountService);
		 
		 
		 
	}

	/**
	 * 认证成功 ：用户test1 输入正确的账户和密码
	 * 
	 * @throws Exception
	 */
	@Test
	public void authenticationSuccess() throws Exception {
		mocMvc.perform(formLogin("/login").user("username", "test1").password("password", "test1"))
				.andExpect(status().isFound())
				.andExpect(redirectedUrl("/secure/home"))
				.andExpect(authenticated().withUsername("test1"));

	}
	
	/**
	 * 认证失败 ： 用户test1 输入错误的密码
	 * @throws Exception
	 */
 	@Test
	public void authenticationFailed() throws Exception {
		mocMvc.perform(formLogin("/login").user("username", "test1").password("password", "invalid password"))
				.andExpect(status().isFound())
				.andExpect(redirectedUrl("/secure/failure"))
				.andExpect(unauthenticated());
	}
	
 	/**
 	 * 测试用户资源访问权限
 	 * 
 	 * @throws Exception
 	 */
 	 @Test 
     public void requestProtectedUrlWithUserDetails() throws Exception { 
 		 //test1 具有管理员权限 ，因此 具有访问 /manage/add 的权限
 	     UserDetails userDetails = customUserDetailService.loadUserByUsername("test1"); 
 	     mocMvc.perform(get("/manage/add").with(user(userDetails))) 
 	          // 可以访问 
              .andExpect(status().isNotFound()) 
 	            .andExpect(authenticated().withAuthenticationPrincipal(userDetails)); 
 	     
 	     
 	    //test2 不具备管理员权限 ，因此 不具有访问 /manage/add 的权限
 	     userDetails = customUserDetailService.loadUserByUsername("test2"); 
	     mocMvc.perform(get("/manage/add").with(user(userDetails))) 
	          // 禁止访问
             .andExpect(status().isForbidden())  
	         .andExpect(authenticated().withAuthenticationPrincipal(userDetails)); 
 	  } 
 	 
 	 
 	 @Test
 	 public void requestHttpsUrl() throws Exception{	 
 		//重定向到https://
 		mocMvc.perform(get("/ssl/test"))
 		.andExpect(status().isFound()).andExpect(redirectedUrl("https://localhost/ssl/test"));	
 	 }
 	 
 	 	 
 	
}
