/**
 * 
 */
package com.fenghua.auto.order.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fenghua.auto.backend.dao.BaseDao;
import com.fenghua.auto.order.dao.OrderHeaderDao;
import com.fenghua.auto.order.domain.OrderHeader;
import com.fenghua.auto.backend.service.impl.BaseServiceImpl;
import com.fenghua.auto.order.service.OrderHeaderService;

/**
 * Service实现类
 *
 * @author 王直元
 * @createTime 2015-11-25 11:11:35
 *
 */
@Service
public class OrderHeaderServiceImpl extends BaseServiceImpl<OrderHeader> implements OrderHeaderService {

	@Autowired
	private OrderHeaderDao dao;
	
	@Override
	protected BaseDao<OrderHeader> getBaseDao() {
		return dao;
	}

}
