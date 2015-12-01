package com.fenghua.auto.backend.service.user.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fenghua.auto.backend.dao.BaseDao;
import com.fenghua.auto.backend.dao.user.PaymentTypeDao;
import com.fenghua.auto.backend.domain.user.PaymentType;
import com.fenghua.auto.backend.service.impl.BaseServiceImpl;
import com.fenghua.auto.backend.service.user.PaymentTypeService;

/**
 * 企业接口实现
 * @author chengbin
 * @createTime 2015.11.2
 *
 */
@Service
public class PaymentTypeServiceImpl extends BaseServiceImpl<PaymentType> implements PaymentTypeService {
	
	@Autowired
	private PaymentTypeDao paymentTypeDao;
	
	@Override
	protected BaseDao<PaymentType> getBaseDao() {
		return paymentTypeDao;
	}

	@Override
	public PaymentType getById(Long id) {
		return paymentTypeDao.getById(id).get(0);
	}
}
