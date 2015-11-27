package com.fenghua.auto.backend.service.user;

import com.fenghua.auto.backend.domain.user.PaymentType;

/**
 * 企业service
 * 
 * @author chengbin
 * @createTime 2015.11.2
 *
 */
public interface PaymentTypeService {
	/**
	 * 通过id查询PaymentType
	 * @return
	 */
	public PaymentType getById(Long id);
}
