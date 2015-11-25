package com.fenghua.auto.sku.service;

import java.util.List;

import com.fenghua.auto.backend.service.BaseService;
import com.fenghua.auto.sku.domain.Sku;

/** 
  *<des>
  *</des>
  * @author  lijie
  * @date 2015年11月24日
  * @version 
  */
public interface SkuService extends BaseService<Sku>{

   /**根据商品类别查询
    * 
    * @param catalogId
    * @return
    */
   public List<Sku> querySkuByCatalogId(Long catalogId);

}
