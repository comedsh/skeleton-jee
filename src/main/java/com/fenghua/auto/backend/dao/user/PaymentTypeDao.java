package com.fenghua.auto.backend.dao.user;

import org.springframework.stereotype.Repository;

import com.fenghua.auto.backend.dao.BaseDao;
import com.fenghua.auto.backend.domain.user.Payment_type;;
/**
 * 企业dao
 * @author chengbin
 * @createtime 2015.11.2
 *
 */
@Repository
public interface PaymentTypeDao extends BaseDao<Payment_type> {

	public Long getPaymentId(Payment_type payment); 
	
	
}
