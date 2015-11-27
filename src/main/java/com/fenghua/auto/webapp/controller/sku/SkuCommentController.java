package com.fenghua.auto.webapp.controller.sku;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fenghua.auto.sku.service.SkuCommentService;

/** 
  *<des>
  *</des>
  * @author  lijie
  * @date 2015年11月25日
  * @version 
  */
@Controller
@RequestMapping("/comment")
public class SkuCommentController {

	@Autowired
	private SkuCommentService skuCommentService;
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	@ResponseBody
	public Map<String,String> countBySkuId(@PathVariable("id") Long id,Model model){
		long counts = skuCommentService.countBySkuId(id);
		Map<String,String> maps = new HashMap<String,String>();
		maps.put("comtotal", counts+"");
		return maps;
		
		
	}
}
