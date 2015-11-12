package com.fenghua.auto.backend.dao.user.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import com.fenghua.auto.backend.dao.DaoException;
import com.fenghua.auto.backend.dao.constants.SqlId;
import com.fenghua.auto.backend.dao.impl.BaseDaoImpl;
import com.fenghua.auto.backend.dao.user.UserDao;
import com.fenghua.auto.backend.domain.user.Company;
import com.fenghua.auto.backend.domain.user.User;
/**
 * 个人注册dao实现
 * @author chengbin
 *
 */
@Repository
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {

	@Override
	public List<User> selectByName(String name) {
		Assert.notNull(name);
		List<User> user = new ArrayList<User>();
		try {
			user = sqlSessionTemplate.selectList(getSqlName(SqlId.SQL_SELECT_BY_NAME), name);
		} catch (Exception e) {
			throw new DaoException(String.format("根据Name查询对象出错！语句：%s", getSqlName(SqlId.SQL_SELECT_BY_NAME)), e);
		}
		return user;
	}
	
	@Override
	public List<User> selectByEmail(String email) {
		Assert.notNull(email);
		List<User> user = new ArrayList<User>();
		try {
			user = sqlSessionTemplate.selectList(getSqlName(SqlId.SQL_SELECT_BY_EMAIL), email);
		} catch (Exception e) {
			throw new DaoException(String.format("根据Email查询对象出错！语句：%s", getSqlName(SqlId.SQL_SELECT_BY_EMAIL)), e);
		}
		return user;
	}
	
	@Override
	public List<User> selectByTelephone(String telephone) {
		Assert.notNull(telephone);
		List<User> user = new ArrayList<User>();
		try {
			user = sqlSessionTemplate.selectList(getSqlName(SqlId.SQL_SELECT_BY_TELEPHONE), telephone);
		} catch (Exception e) {
			throw new DaoException(String.format("根据Telephone查询对象出错！语句：%s", getSqlName(SqlId.SQL_SELECT_BY_TELEPHONE)), e);
		}
		return user;
	}
	@Override
	public List<Company> selectByFixed(String fixed) {
		Assert.notNull(fixed);
		List<Company> company = new ArrayList<Company>();
		try {
			company = sqlSessionTemplate.selectList(getSqlName(SqlId.SQL_SELECT_BY_FIXED), fixed);
		} catch (Exception e) {
			throw new DaoException(String.format("根据Fixed查询对象出错！语句：%s", getSqlName(SqlId.SQL_SELECT_BY_FIXED)), e);
		}
		return company;
	}
}
