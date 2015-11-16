package com.fenghua.auto.backend.dao.user;

import org.springframework.stereotype.Repository;

import com.fenghua.auto.backend.dao.BaseDao;
import com.fenghua.auto.backend.domain.user.Payment_type;
import com.fenghua.auto.backend.domain.user.User_payment_type;;
/**
 * 企业dao
 * @author chengbin
 * @createtime 2015.11.2
 *
 */
@Repository
public interface UserPaymentTypeDao extends BaseDao<User_payment_type> {

	public void insert(User_payment_type payment); 
	
}
