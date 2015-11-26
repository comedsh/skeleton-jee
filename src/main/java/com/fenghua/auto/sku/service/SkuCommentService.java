package com.fenghua.auto.sku.service;

import com.fenghua.auto.backend.service.BaseService;
import com.fenghua.auto.sku.domain.SkuComment;

/** 
  *<des>
  *</des>
  * @author  lijie
  * @date 2015年11月24日
  * @version 
  */
public interface SkuCommentService  extends BaseService<SkuComment>{

	public long countBySkuId(Long skuId);
}
