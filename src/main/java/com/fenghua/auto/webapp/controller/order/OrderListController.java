package com.fenghua.auto.webapp.controller.order;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonAnyFormatVisitor;
import com.fenghua.auto.order.domain.OrderHeader;
import com.fenghua.auto.order.service.OrderHeaderService;

/**
 * 订单列表控制器
 * 
 * @author zhangfr
 *
 */
@Controller
@RequestMapping("/buyerOrder")
public class OrderListController {
	@Autowired
	private OrderHeaderService orderHeaderService;
	@RequestMapping("/list")
	public ModelAndView list() {
		ModelAndView mv = new ModelAndView("web.order.buyerOrder_list");
		List<OrderHeader> buyerOrderList= orderHeaderService.selectAll();
		String buyerOrders= JSON.toJSONString(buyerOrderList);
		System.out.println(buyerOrders);
		mv.addObject("buyerOrderList", buyerOrders);
		return mv;
	}
}
