package com.fenghua.auto.backend.service.security;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.After;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import com.fenghua.auto.backend.service.security.ResourceService;
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
