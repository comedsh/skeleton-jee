/**
 * 
 */
package com.fenghua.auto.order.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fenghua.auto.backend.dao.BaseDao;
import com.fenghua.auto.order.dao.BuyCarDao;
import com.fenghua.auto.order.domain.BuyCar;
import com.fenghua.auto.backend.service.impl.BaseServiceImpl;
import com.fenghua.auto.order.service.BuyCarService;

/**
 * Service实现类
 *
 * @author 王直元
 * @createTime 2015-11-25 11:11:35
 *
 */
@Service
public class BuyCarServiceImpl extends BaseServiceImpl<BuyCar> implements BuyCarService {

	@Autowired
	private BuyCarDao dao;
	
	@Override
	protected BaseDao<BuyCar> getBaseDao() {
		return dao;
	}

}
