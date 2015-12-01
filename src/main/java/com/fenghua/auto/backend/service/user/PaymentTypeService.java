package com.fenghua.auto.backend.service.user;

import com.fenghua.auto.backend.domain.user.PaymentType;
import com.fenghua.auto.backend.service.BaseService;

/**
 * 企业service
 * 
 * @author chengbin
 * @createTime 2015.11.2
 *
 */
public interface PaymentTypeService extends BaseService<PaymentType>{
	/**
	 * 通过id查询PaymentType
	 * @return
	 */
	public PaymentType getById(Long id);
}
