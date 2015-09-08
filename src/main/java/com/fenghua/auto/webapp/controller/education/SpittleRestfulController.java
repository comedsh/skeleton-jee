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
@RequestMapping("/spittle")
public class SpittleRestfulController {
	
	@Autowired
	SpittleService spittleService;

	@RequestMapping("/home")
	public String home(Model model){
		
		model.addAttribute( "spittles", spittleService.getAllSpittles() );		
		
		// by using TilesView to render this page. the full template path should be education_spittle_home.tiles.
		return "education.spittle_home";
	
	}
	
	/**
	 * 
	 * restful, 参数化的 URL, 处理 GET 请求
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping( value="/{id}", method=RequestMethod.GET )
	public String getSpittle(@PathVariable("id") long id, Model model){
		
		model.addAttribute( spittleService.getSpittleById(id) );
		
		return "education.spittle_view";
		
	}

	/**
	 * 
	 * restful, 参数化的 URL, 处理 DELETE 请求
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping( value="/{id}", method=RequestMethod.DELETE )
	public String deleteSpittle(@PathVariable("id") long id, Model model){
		
		spittleService.deleteSpittle(id);
		
		// model.addAttribute( "spittles", spittleService.getAllSpittles() );
		// If Tomcat 8.x, it addressed as a bug as HTTP Status 405 - JSPs only permit GET POST or HEAD. -> 如果用下面 forward 的方式，会报左边这个错误；因为 forward 会继续以 delete 的方式执行
		// Tomcat 7.x has no such errors
		// return "education.spittle_home"; // why comments it out, because we should use the redirect after deletion request for avoiding the duplicate deletion requet at the same page.
		
		return "redirect:/spittle/home"; 
		
	}
	
}
