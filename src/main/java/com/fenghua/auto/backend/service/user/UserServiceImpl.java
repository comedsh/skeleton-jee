package com.fenghua.auto.backend.service.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
		userDao.insert(personal);
	}

	@Override
	public User getPersonalById(Long id) {
		return userDao.selectById(id);
	}

	@Override
	public List<User> getAll() {
		return userDao.selectAll();
	}
	
}
