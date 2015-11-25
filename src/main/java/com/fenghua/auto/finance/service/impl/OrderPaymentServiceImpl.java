/**
 * 
 */
package com.fenghua.auto.finance.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fenghua.auto.backend.dao.BaseDao;
import com.fenghua.auto.finance.dao.OrderPaymentDao;
import com.fenghua.auto.finance.domain.OrderPayment;
import com.fenghua.auto.backend.service.impl.BaseServiceImpl;
import com.fenghua.auto.finance.service.OrderPaymentService;

/**
 * Service实现类
 *
 * @author 王直元
 * @createTime 2015-11-25 11:11:35
 *
 */
@Service
public class OrderPaymentServiceImpl extends BaseServiceImpl<OrderPayment> implements OrderPaymentService {

	@Autowired
	private OrderPaymentDao dao;
	
	@Override
	protected BaseDao<OrderPayment> getBaseDao() {
		return dao;
	}

}
