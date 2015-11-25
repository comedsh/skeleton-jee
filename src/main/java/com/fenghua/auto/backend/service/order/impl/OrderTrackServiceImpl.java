/**
 * 
 */
package com.fenghua.auto.backend.service.order.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fenghua.auto.backend.dao.BaseDao;
import com.fenghua.auto.backend.dao.order.OrderTrackDao;
import com.fenghua.auto.backend.domain.order.OrderTrack;
import com.fenghua.auto.backend.service.impl.BaseServiceImpl;
import com.fenghua.auto.backend.service.order.OrderTrackService;

/**
 * Service实现类
 *
 * @author 王直元
 * @createTime 2015-11-25 11:11:35
 *
 */
@Service
public class OrderTrackServiceImpl extends BaseServiceImpl<OrderTrack> implements OrderTrackService {

	@Autowired
	private OrderTrackDao dao;
	
	@Override
	protected BaseDao<OrderTrack> getBaseDao() {
		return dao;
	}

}
