package com.fenghua.auto.webapp.controller.sku;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fenghua.auto.sku.domain.Sku;
import com.fenghua.auto.sku.service.SkuService;

/** 
  *<des>
  *</des>
  * @author  lijie
  * @date 2015年11月24日
  * @version 
  */
@Controller
@RequestMapping("/product")
public class SkuController {
	
	@Autowired
	private SkuService skuService;
	
	@RequestMapping(method=RequestMethod.GET)
	public String queryAll( Model model){
		List<Sku> list = skuService.selectAll();
		model.addAttribute("items",list);
		return "web.product_list";
	}
	
	/**
	 * 根据商品ID查询商品信息
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public String queryById(@PathVariable("id") Long id , Model model){
		Sku sku = skuService.selectById(id);
		model.addAttribute("product",sku);
		return "web.product";
	}

}
