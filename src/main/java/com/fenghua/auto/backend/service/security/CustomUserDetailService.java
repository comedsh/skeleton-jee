package com.fenghua.auto.backend.service.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.rememberme.RememberMeAuthenticationFilter;

import com.fenghua.auto.backend.domain.securtity.Account;
import com.fenghua.auto.backend.domain.user.Role;
import com.fenghua.auto.backend.domain.user.User;
import com.fenghua.auto.backend.service.user.RoleService;
import com.fenghua.auto.backend.service.user.UserService;



/** 
  *<des>
  *</des>
  * @author  lijie
  * @date 2015年10月21日
  * @version 
  */
public class CustomUserDetailService implements UserDetailsService{

	private static final Logger logger = LoggerFactory
			.getLogger(CustomUserDetailService.class);

	@Autowired
	private AccountService accountService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private RoleService roleService;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        logger.debug("loadUserByUsername(String) - start"); //$NON-NLS-1$  
		
		Collection<GrantedAuthority> auths = new ArrayList<GrantedAuthority>();
		// 取得用户的密码
		List<User> users = userService.getUserByName(username);

		if (users.size() == 0) {
			String message = "用户" + username + "不存在";
			logger.error(message);
			throw new UsernameNotFoundException(message);
		}
		
		String password =users.get(0).getPassword();

		// 获得用户的角色
		Long roleId = users.get(0).getRole();
		Iterator<Role> roles = roleService.getRoleById(roleId).iterator();
		while (roles.hasNext()) {
			Role role = roles.next();		
			SimpleGrantedAuthority grantedAuthorityImpl = new SimpleGrantedAuthority(role.getName());
			logger.debug("用户：[" + users.get(0).getName() + "]拥有角色：["+ role.getName() + "],即spring security中的access");
			auths.add(grantedAuthorityImpl);
		}

		org.springframework.security.core.userdetails.User user = new org.springframework.security.core.userdetails.User(
				username, password, true, true, true, true, auths);
	
		logger.debug("loadUserByUsername(String) - end");
		return user;
	}

	public void setAccountService(AccountService accountService) {
		this.accountService = accountService;
	}

}
