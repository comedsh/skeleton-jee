package com.fenghua.auto.backend.service.security;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.After;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import com.fenghua.auto.backend.dao.user.UserDao;
import com.fenghua.auto.backend.domain.user.User;
import com.fenghua.auto.backend.service.security.ResourceService;
import com.fenghua.auto.backend.service.user.AuthService;
import com.fenghua.auto.test.AbstractControllerTest;

/**
 * <des> </des>
 * 
 * @author lijie
 * @date 2015年10月28日
 * @version
 */
public class ResourceMethodAuthorizeTest extends AbstractControllerTest {

	@Autowired
	private ResourceService resourceService;
	@Autowired
	private UserDao userDao;
	@Test
	public void getUserByQQ() throws Exception {
		List<User> userByQQ = userDao.getUserByQQ("sadfdsafsadf");
		System.out.println(userByQQ.size());
	}
	@Test
	public void updateQQNumberByUserID() throws Exception {
		User user=new User();
		user.setQqNumber("2131232131");
		user.setId(5L);
		userDao.updateQQNumberByUserID(user);
	}

	@Test
	public void invokeMethodForUser() {

		// ResourceService 中 addResource 需要具备管理员权限才能操作
		Collection<GrantedAuthority> auths = new ArrayList<GrantedAuthority>();
		SimpleGrantedAuthority authority = new SimpleGrantedAuthority("user");
		auths.add(authority);

		// 构造认证用户 test2 具备 user权限
		Authentication authRequest = new UsernamePasswordAuthenticationToken("test2", "test2", auths);
		SecurityContextHolder.getContext().setAuthentication(authRequest);

		AccessDeniedException ex = null;
		try {
			resourceService.addResource();
		} catch (AccessDeniedException e) {
			ex = e;
		}
		assertNotNull(ex);

	}

	@Test
	public void invokeMethodForAdmin() {

		// ResourceService 中 addResource 需要具备管理员权限才能操作
		Collection<GrantedAuthority> auths = new ArrayList<GrantedAuthority>();
		SimpleGrantedAuthority authority = new SimpleGrantedAuthority("admin");
		auths.add(authority);

		// 构造认证用户 test2 具备 user权限
		Authentication authRequest = new UsernamePasswordAuthenticationToken("test2", "test2", auths);
		SecurityContextHolder.getContext().setAuthentication(authRequest);

		AccessDeniedException ex = null;
		try {
			resourceService.addResource();
		} catch (AccessDeniedException e) {
			ex = e;
		}
		assertNull(ex);

	}

	@After
	public void clearContext() {
		SecurityContextHolder.clearContext();
	}
}
