/**
 * 
 */
package com.fenghua.auto.sku.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fenghua.auto.backend.dao.BaseDao;
import com.fenghua.auto.sku.dao.VehicleOeSkuDao;
import com.fenghua.auto.sku.domain.VehicleOeSku;
import com.fenghua.auto.backend.service.impl.BaseServiceImpl;
import com.fenghua.auto.sku.service.VehicleOeSkuService;

/**
 * Service实现类
 *
 * @author lijie
 * @createTime 2015-11-27 16:00:19
 *
 */
@Service
public class VehicleOeSkuServiceImpl extends BaseServiceImpl<VehicleOeSku> implements VehicleOeSkuService {

	@Autowired
	private VehicleOeSkuDao dao;
	
	@Override
	protected BaseDao<VehicleOeSku> getBaseDao() {
		return dao;
	}

}
