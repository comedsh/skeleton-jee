package com.fenghua.auto.backend.service.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.fenghua.auto.backend.dao.user.UserDao;
import com.fenghua.auto.backend.domain.user.Company;
import com.fenghua.auto.backend.domain.user.User;

/**
 * 个人注册接口实现
 * @author chengbin
 * @createTime 2015.11.2
 *
 */
@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private BCryptPasswordEncoder encoder;


	@Override
	public void delete(Long id) {
		userDao.deleteById(id);
	}

	@Override
	public void update(User personal) {
		userDao.updateById(personal);
	}

	@Override
	public void insert(User personal) {
		String passWord = encoder.encode( personal.getPassword());
		personal.setPassword(passWord);
		userDao.insert(personal);
	}

	@Override
	public User getUserById(Long id) {
		return userDao.selectById(id);
	}

	@Override
	public List<User> getAll() {
		return userDao.selectAll();
	}

	@Override
	public List<User> getUserByName(String name) {
		return userDao.selectByName(name);
	}
	
	@Override
	public List<User> getUserByEmail(String email) {
		return userDao.selectByEmail(email);
	}
	
	@Override
	public List<User> getUserByTelephone(String telephone) {
		return userDao.selectByTelephone(telephone);
	}
	@Override
	public List<Company> getUserByFixed(String fixed) {
		return userDao.selectByFixed(fixed);
	}
	
}
