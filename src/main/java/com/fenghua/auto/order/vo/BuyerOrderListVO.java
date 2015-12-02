package com.fenghua.auto.order.vo;

import java.util.List;

import com.fenghua.auto.order.domain.OrderHeader;
import com.fenghua.auto.order.domain.OrderImage;
import com.fenghua.auto.order.domain.OrderMaster;

public class BuyerOrderListVO {
	/**
	 * 主订单
	 */
	private OrderMaster orderMaster;
	
	/**
	 * 订单
	 */
	private List<OrderVO> orderHeaders;
	
}	
