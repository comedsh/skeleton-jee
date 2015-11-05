package com.fenghua.auto.backend.service.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.fenghua.auto.backend.domain.securtity.Account;
import com.fenghua.auto.backend.domain.securtity.Role;
import com.fenghua.auto.backend.service.security.AccountService;



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
	private BCryptPasswordEncoder encoder;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        logger.debug("loadUserByUsername(String) - start"); //$NON-NLS-1$  
		
		Collection<GrantedAuthority> auths = new ArrayList<GrantedAuthority>();
		// 取得用户的密码
		Account account = accountService.getAccountByName(username);

		if (account == null) {
			String message = "用户" + username + "不存在";
			logger.error(message);
			throw new UsernameNotFoundException(message);
		}
		
		String password =encoder.encode(account.getPassword());//对密码家吗

		// 获得用户的角色
		Iterator<Role> roles = account.getRoleSet().iterator();
		while (roles.hasNext()) {
			Role role = roles.next();		
			SimpleGrantedAuthority grantedAuthorityImpl = new SimpleGrantedAuthority(role.getName());
			logger.debug("用户：[" + account.getName() + "]拥有角色：["+ role.getName() + "],即spring security中的access");
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
