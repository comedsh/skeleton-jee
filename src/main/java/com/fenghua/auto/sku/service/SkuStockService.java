package com.fenghua.auto.sku.service;

import java.util.List;

import com.fenghua.auto.sku.domain.SkuStock;

/** 
  *<des>
  *</des>
  * @author  lijie
  * @date 2015年11月24日
  * @version 
  */
public interface SkuStockService {

	
	public SkuStock queryStockBySkuId(Long skuId);

	public List<SkuStock> queryStockByReposityId(Long reposityId);
	
	public long countBySkuId(Long id);

}
