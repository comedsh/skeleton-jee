/**
 * 
 */
package com.fenghua.auto.order.service;

import java.util.List;

import com.fenghua.auto.backend.service.BaseService;
import com.fenghua.auto.order.domain.ShoppingCart;
import com.fenghua.auto.order.vo.ShoppingCartGroupVO;

/**
 * Service接口类
 *
 * @author 王直元
 * @createTime 2015-11-26 14:10:18
 *
 */
public interface ShoppingCartService extends BaseService<ShoppingCart> {

	public boolean addToCart(Long pid, int qty);
	
	public boolean putToCart(Long pid, int qty);
	
	public boolean removeCart(Long sid);
	
	public List<ShoppingCartGroupVO> loadByBuyerId(Long buyerId);
}
