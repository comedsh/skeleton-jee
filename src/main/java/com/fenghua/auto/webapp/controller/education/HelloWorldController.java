package com.fenghua.auto.webapp.controller.education;

import java.io.IOException;  

import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
  
import org.springframework.stereotype.Controller;  
import org.springframework.web.bind.annotation.PathVariable;  
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RequestMethod;  
 
/**
 * 
 * Project Skeleton made up
 * 
 * @author shangyang
 *
 */
@Controller  
@RequestMapping("/hello")  
public class HelloWorldController {  
    
	//映射路径/helloworld/index当访问这个路径时，执行这个方法  
    @RequestMapping("/world")  
    public String index(HttpServletRequest request ,HttpServletResponse response){  
        
    	//response,request会自动传进来  
        request.setAttribute("message", "Hello,This is a example of Spring3 RESTful!");  
        
        return "helloworld.jsp";  
    }  
    
    //根据ID获取不同的内容，通过@PathVariable 获得属性  
    @RequestMapping(value="/{id}",method=RequestMethod.GET)  
    public String get(@PathVariable String id,HttpServletRequest request ,HttpServletResponse response) throws IOException{  

    	response.getWriter().write("You put id is : "+id);  
        
    	return null;  
    
    }  
}  