package com.fenghua.auto.sku.service;

import java.util.List;

import com.fenghua.auto.sku.domain.SkuImages;

/** 
  *<des>
  *</des>
  * @author  lijie
  * @date 2015年11月24日
  * @version 
  */
public interface SkuImageService {

	public List<SkuImages> queryBySkuId(Long id);
}
