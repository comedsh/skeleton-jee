package com.fenghua.auto.backend.dao.user.impl;

import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import com.fenghua.auto.backend.dao.DaoException;
import com.fenghua.auto.backend.dao.constants.SqlId;
import com.fenghua.auto.backend.dao.impl.BaseDaoImpl;
import com.fenghua.auto.backend.dao.user.UserPaymentTypeDao;
import com.fenghua.auto.backend.domain.user.UserPaymentType;
/**
 * 用户与支付方式的dao实现
 * @author chengbin
 *
 */
@Repository
public class UserPaymentTypeDaoImpl extends BaseDaoImpl<UserPaymentType> implements UserPaymentTypeDao {

	@Override
	public void insert(UserPaymentType payment) {
		Assert.notNull(payment);
		try {
			sqlSessionTemplate.insert(getSqlName(SqlId.SQL_INSERT), payment);
		} catch (Exception e) {
			throw new DaoException(String.format("添加对象出错！语句：%s", getSqlName(SqlId.SQL_INSERT)), e);
		}
	}
}
