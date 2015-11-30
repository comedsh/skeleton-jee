/**
 * 
 */
package com.fenghua.auto.backend.service.user.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fenghua.auto.backend.dao.BaseDao;
import com.fenghua.auto.backend.dao.user.UserAddressDao;
import com.fenghua.auto.backend.domain.user.UserAddress;
import com.fenghua.auto.backend.service.impl.BaseServiceImpl;
import com.fenghua.auto.backend.service.user.UserAddressService;

/**
 * Service实现类
 *
 * @author 王直元
 * @createTime 2015-11-30 13:33:25
 *
 */
@Service
public class UserAddressServiceImpl extends BaseServiceImpl<UserAddress> implements UserAddressService {

	@Autowired
	private UserAddressDao dao;
	
	@Override
	protected BaseDao<UserAddress> getBaseDao() {
		return dao;
	}

}
