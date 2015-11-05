package com.fenghua.auto.backend.dao.user.impl;

import org.springframework.stereotype.Repository;

import com.fenghua.auto.backend.dao.impl.BaseDaoImpl;
import com.fenghua.auto.backend.dao.user.UserDao;
import com.fenghua.auto.backend.domain.user.User;
/**
 * 个人注册dao实现
 * @author chengbin
 *
 */
@Repository
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {

}
