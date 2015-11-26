/**
 * 
 */
package com.fenghua.auto.order.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fenghua.auto.backend.dao.BaseDao;
import com.fenghua.auto.order.dao.OrderMasterDao;
import com.fenghua.auto.order.domain.OrderMaster;
import com.fenghua.auto.backend.service.impl.BaseServiceImpl;
import com.fenghua.auto.order.service.OrderMasterService;

/**
 * Service实现类
 *
 * @author 王直元
 * @createTime 2015-11-25 11:11:35
 *
 */
@Service
public class OrderMasterServiceImpl extends BaseServiceImpl<OrderMaster> implements OrderMasterService {

	@Autowired
	private OrderMasterDao dao;
	
	@Override
	protected BaseDao<OrderMaster> getBaseDao() {
		return dao;
	}

}
