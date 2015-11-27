package com.fenghua.auto.webapp.controller.order;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fenghua.auto.order.domain.ShoppingCart;
import com.fenghua.auto.order.service.ShoppingCartService;
import com.fenghua.auto.sku.service.SkuService;

/** 
  *<des> 
  * 购物车
  *</des>
  * @author  zhiyuan.wang@auto007.com
  * @date 2015年11月26日
  * @version 1.0
  */
@Controller
@RequestMapping("/shoppingCart")
public class ShoppingCartController {
	
	@Autowired
	private ShoppingCartService shoppingCartService;
	
	@Autowired
	private SkuService skuService;
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public String list( Model model){
		ShoppingCart qo = new ShoppingCart();
		qo.setBuyerId(1l);
		Pageable page = new PageRequest(1, 10);
		List<ShoppingCart> list = shoppingCartService.selectList(qo);
		model.addAttribute("shopCartList",list);
		return "web.shoppingCart_list";
	}
	
//	@RequestMapping(value="/list", method=RequestMethod.PUT)
//	public String addSku(@Valid Spittle spittle, BindingResult result, Model model){
//		
//		if(result.hasErrors()) {
//			
//			model.addAttribute("spittles", spittleService.getAllSpittles());
//			
//	        return "education.spittle_home";
//	    }		
//		
//		
//		return "web.buyCar_list";
//		
//	}
	
//	/**
//	 * 根据商品ID查询商品信息
//	 * 
//	 * @param id
//	 * @param model
//	 * @return
//	 */
//	@RequestMapping(value="/{id}",method=RequestMethod.GET)
//	public String queryById(@PathVariable("id") Long id , Model model){
//		Sku sku = skuService.selectById(id);
//		model.addAttribute("product",sku);
//		return "web.product";
//	}

}
