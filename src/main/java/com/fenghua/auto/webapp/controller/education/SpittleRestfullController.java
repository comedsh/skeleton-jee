package com.fenghua.auto.webapp.controller.education;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fenghua.auto.backend.service.education.SpittleService;

/**
 * 
 * 用于培训用途，这类应用是项目中需要的，严格要求的
 * 
 * @author shang yang
 *
 * @version 
 *
 * @createTime：2015年8月31日 上午8:57:26 
 *
 */
@Controller
@RequestMapping("/spittles")
public class SpittleRestfullController {
	
	@Autowired
	SpittleService spittleService;
	
	@RequestMapping("/home")
	public String home(){
		
		return "/WEB-INF/views/education/home";
	
	}
	
	/**
	 * 
	 * restful, 参数化的 URL 
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping( value="/{id}", method=RequestMethod.GET )
	public String getSpittle(@PathVariable("id") long id, Model model){
		
		model.addAttribute( spittleService.getSpittleById(id) );
		
		return "/WEB-INF/views/education/view";
		
	}
	
}
