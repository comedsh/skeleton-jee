package com.fenghua.auto.sku.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fenghua.auto.backend.core.utills.Constants;
import com.fenghua.auto.backend.dao.BaseDao;
import com.fenghua.auto.backend.domain.DomainObject;
import com.fenghua.auto.backend.service.BaseService;
import com.fenghua.auto.backend.service.impl.BaseServiceImpl;
import com.fenghua.auto.sku.dao.SkuCommentDao;
import com.fenghua.auto.sku.domain.SkuComment;
import com.fenghua.auto.sku.service.SkuCommentService;

/** 
  *<des>
  *</des>
  * @author  lijie
  * @date 2015年11月24日
  * @version 
  */
@Service
public class SkuCommentServiceImpl extends BaseServiceImpl<SkuComment> implements SkuCommentService{

	@Autowired
	private SkuCommentDao skuCommentDao;

	
	@Override
	public long countBySkuId(Long skuId) {
		SkuComment skuComment =  new SkuComment();
		skuComment.setSkuId(skuId);
		return selectCount(skuComment);
	}


	@Override
	protected BaseDao<SkuComment> getBaseDao() {
		return skuCommentDao;
	}


	@Override
	public Map<String, Object> countComentBySkuId(Long skuId) {
		//好评度 == 
		//获取好评度
		SkuComment comment = new SkuComment();		
		comment.setSkuId(skuId);
		Long counts = selectCount(comment);
		
	     comment.setStar(Constants.COMMENT_STAR4);
	 	Long goodCounts = selectCount(comment);
	
		return null;
	}

}
