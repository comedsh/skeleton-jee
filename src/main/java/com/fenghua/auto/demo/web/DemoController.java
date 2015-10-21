package com.fenghua.auto.demo.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.fenghua.auto.demo.domain.DemoObj;
import com.fenghua.auto.demo.service.DemoService;

/** 
  *<des>
  *  用于demo测试 Controller
  *</des>
  *
  * @author  lijie
  * @date 2015年10月20日
  * @version 
  */

@Controller
@RequestMapping("/demo_test")
public class DemoController {

	private DemoService demoService;
	
	/**
	 * get all  info
	 * @return
	 */
	@RequestMapping(method=RequestMethod.GET)
	public String getAll(){		 
		return "/successful";
	}
	

	@RequestMapping(method=RequestMethod.GET,value="/{id}")
	public ModelAndView getInfoById(String id){
		return new ModelAndView("/successful");
	}
    

	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView save(@RequestBody DemoObj obj){
		//todo 
		return new ModelAndView("/successful", "demoInfo", obj);
	}
	
	
	@RequestMapping(method=RequestMethod.DELETE,value="/{id}")
	public ModelAndView delete(String id){
	    return new ModelAndView("/successful");
	}
	
	@RequestMapping(method=RequestMethod.POST,value="save")
	public ModelAndView saveMock(){
		int result = demoService.save();
		return new ModelAndView("/successful","result",result);
	}

	public void setDemoService(DemoService demoService) {
		this.demoService = demoService;
	}
	
}
