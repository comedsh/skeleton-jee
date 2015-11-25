package com.fenghua.auto.sku.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fenghua.auto.backend.dao.BaseDao;
import com.fenghua.auto.backend.service.impl.BaseServiceImpl;
import com.fenghua.auto.sku.dao.SkuDao;
import com.fenghua.auto.sku.domain.Sku;
import com.fenghua.auto.sku.service.SkuService;

/** 
  *<des>
  *</des>
  * @author  lijie
  * @date 2015年11月24日
  * @version 
  */
@Service
public class SkuServiceImpl extends BaseServiceImpl<Sku> implements SkuService{

	@Autowired
	private SkuDao skuDao;
	
	

	@Override
	protected BaseDao<Sku> getBaseDao() {
		// TODO Auto-generated method stub
		return skuDao;
	}


	@Override
	public List<Sku> querySkuByCatalogId(Long catalogId) {
		// TODO Auto-generated method stub
		return null;
	}

}
