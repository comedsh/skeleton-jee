package com.fenghua.auto.webapp.controller.order;

import java.util.ArrayList;
import java.util.List;

import javax.security.sasl.AuthenticationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.fenghua.auto.backend.core.utills.MessageHelper;
import com.fenghua.auto.backend.core.utills.UserSecurityUtils;
import com.fenghua.auto.order.domain.ShoppingCart;
import com.fenghua.auto.order.service.OrderMasterService;

/** 
  *<des> 
  * 下单控制器，次控制器将完成 1、购物车下单；2、产品列表和详情的立即购买下单
  *</des>
  * @author  zhiyuan.wang@auto007.com
  * @date 2015年11月26日
  * @version 1.0
  */
@Controller
@RequestMapping("/shopping/order")
public class OrderSubmitController {
	
	@Autowired
	private OrderMasterService orderMasterService;
	
	@RequestMapping(method=RequestMethod.GET)
	public String list(Model model,
			@RequestParam(value="sids", required = false) Long[] sids,
			@RequestParam(value="skuid", required = false) Long skuid,
			@RequestParam(value="qty", required = false) Integer qty) throws AuthenticationException{
		List<ShoppingCart> shoppingCarts = new ArrayList<ShoppingCart>();
		
		if(sids != null && sids.length > 0) {
			
		} else if(skuid != null && skuid > 0 && qty != null && qty > 0) {
			
		} else {
			model.addAttribute("errorMsg", MessageHelper.getMessage("order.submit.parameter.error"));
			return "web.order.submit";
		}
		
		orderMasterService.initSubmit(shoppingCarts, UserSecurityUtils.getCurrentUserId());
////		List<ShoppingCartGroupVO> list = shoppingCartService.loadByBuyerId(UserSecurityUtils.getCurrentUserId());
////		model.addAttribute("shopCartGroupList",list);
//		if(list == null || list.isEmpty()) {
//			model.addAttribute("shopCart","empty");
//		}
//		String json = JSON.toJSONString(list);
//		model.addAttribute("shopCartJson",json);
		return "web.order.shoppingCart_list";
	}
	
//	@ResponseBody
//	@RequestMapping(method=RequestMethod.POST)
//	public List<ShoppingCartGroupVO> delete(Model model,
//			@RequestParam(value="sids", required=true) Long[] sids) throws AuthenticationException{
//		boolean putOk = false;
//		if(sids != null && sids.length > 0) {
//			putOk = shoppingCartService.removeCart(sids);
//		}
//		if(putOk) {
//			List<ShoppingCartGroupVO> list = shoppingCartService.loadByBuyerId(UserSecurityUtils.getCurrentUserId());
//			return list;
//		} else {
//			return new ArrayList<ShoppingCartGroupVO>(0);
//		}
//	}
}
