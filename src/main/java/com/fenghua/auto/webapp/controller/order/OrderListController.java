package com.fenghua.auto.webapp.controller.order;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 订单列表控制器
 * 
 * @author zhangfr
 *
 */
@Controller
@RequestMapping("/buyerOrder")
public class OrderListController {
	@RequestMapping("/list")
	public ModelAndView list() {
		ModelAndView mv = new ModelAndView("web.order.buyerOrder_list");
		return mv;
	}
}
