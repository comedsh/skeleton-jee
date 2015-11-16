package com.fenghua.auto.backend.dao.user.impl;

import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import com.fenghua.auto.backend.dao.DaoException;
import com.fenghua.auto.backend.dao.constants.SqlId;
import com.fenghua.auto.backend.dao.impl.BaseDaoImpl;
import com.fenghua.auto.backend.dao.user.UserPaymentTypeDao;
import com.fenghua.auto.backend.domain.user.User_payment_type;
/**
 * 个人注册dao实现
 * @author chengbin
 *
 */
@Repository
public class UserPaymentTypeDaoImpl extends BaseDaoImpl<User_payment_type> implements UserPaymentTypeDao {

	@Override
	public void insert(User_payment_type payment) {
		Assert.notNull(payment);
		try {
			sqlSessionTemplate.insert(getSqlName(SqlId.SQL_INSERT), payment);
		} catch (Exception e) {
			throw new DaoException(String.format("添加对象出错！语句：%s", getSqlName(SqlId.SQL_INSERT)), e);
		}
	}
}
