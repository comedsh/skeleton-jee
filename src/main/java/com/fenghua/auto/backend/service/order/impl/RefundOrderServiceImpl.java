/**
 * 
 */
package com.fenghua.auto.backend.service.order.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fenghua.auto.backend.dao.BaseDao;
import com.fenghua.auto.backend.dao.order.RefundOrderDao;
import com.fenghua.auto.backend.domain.order.RefundOrder;
import com.fenghua.auto.backend.service.impl.BaseServiceImpl;
import com.fenghua.auto.backend.service.order.RefundOrderService;

/**
 * Service实现类
 *
 * @author 王直元
 * @createTime 2015-11-25 11:11:35
 *
 */
@Service
public class RefundOrderServiceImpl extends BaseServiceImpl<RefundOrder> implements RefundOrderService {

	@Autowired
	private RefundOrderDao dao;
	
	@Override
	protected BaseDao<RefundOrder> getBaseDao() {
		return dao;
	}

}
