/**
 * 
 */
package com.fenghua.auto.order.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fenghua.auto.backend.dao.BaseDao;
import com.fenghua.auto.order.dao.ShoppingCartDao;
import com.fenghua.auto.order.domain.ShoppingCart;
import com.fenghua.auto.backend.service.impl.BaseServiceImpl;
import com.fenghua.auto.order.service.ShoppingCartService;

/**
 * Service实现类
 *
 * @author 王直元
 * @createTime 2015-11-26 14:10:18
 *
 */
@Service
public class ShoppingCartServiceImpl extends BaseServiceImpl<ShoppingCart> implements ShoppingCartService {

	@Autowired
	private ShoppingCartDao dao;
	
	@Override
	protected BaseDao<ShoppingCart> getBaseDao() {
		return dao;
	}

}
