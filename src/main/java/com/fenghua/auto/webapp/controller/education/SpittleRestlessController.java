package com.fenghua.auto.webapp.controller.education;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fenghua.auto.backend.domain.education.Spittle;
import com.fenghua.auto.backend.service.education.SpittleService;

/**
 * 
 * 用于培训用途，
 * 
 * 用于描述什么是 restless 的请求，传统的 restless 只处理 GET 和 POST 请求，且访问是按照动词的方式访问；这类请求在项目中是不允许的，严格禁止的！
 * 
 * @author shang yang
 *
 * @version 
 *
 * @createTime：2015年8月31日 上午8:57:02 
 *
 */
@Controller
@RequestMapping("/spittle")
public class SpittleRestlessController {

	@Autowired
	SpittleService spittleService;
	
	/**
	 * 
	 * Restless, such kind of request in our project is extremely forbidden.
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/getSpittle", method = RequestMethod.GET)
	public String getSpittle( @RequestParam(value="id", required=true) Long id, Model model) {

		List<Spittle> spittles = new ArrayList<Spittle>(1);
		
		spittles.add( spittleService.getSpittleById(id) );
		
		model.addAttribute( "spittles", spittles );

		return "education.spittle_view";

	}	
	
	/**
	 * 
	 * Restless, such kind of request in our project is extremely forbidden.
	 * 
	 * @param id
	 * @param model
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping(value = "/getSpittleByJson", method = RequestMethod.GET)
	public void getSpittleByJson( @RequestParam(value="id", required=true) long id, HttpServletResponse response) throws IOException {
		
		ObjectMapper objectMapper = new ObjectMapper();
		 
		@SuppressWarnings("deprecation")
		JsonGenerator jsonGenerator = objectMapper.getJsonFactory().createJsonGenerator(response.getOutputStream(), JsonEncoding.UTF8);
		
		Spittle spittle = spittleService.getSpittleById(id);
		
		jsonGenerator.writeObject( spittle );
		
		objectMapper.writeValue(response.getOutputStream(), spittle); // 将 Object 转换成 Json 并写回

	}		
	
	/**
	 * 
	 * Restless, such kind of request in our project is extremely forbidden.
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/deleteSpittle", method = RequestMethod.GET)
	public String deleteSpittle( @RequestParam(value="id", required=true) long id, Model model) {

		spittleService.deleteSpittle(id);

		return "redirect:/spittle/home";

	}

	/**
	 * 
	 * Restless, such kind of request in our project is extremely forbidden.
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/updateSpittle", method = RequestMethod.POST)
	public String updateSpittle( @Valid Spittle spittle, Model model) {
		
		// TODO implement it
		
		return "education.spittle_view";

	}
	
	/**
	 * 
	 * Restless, such kind of request in our project is extremely forbidden.
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/createSpittle", method = RequestMethod.POST)
	public String createSpittle( @Valid Spittle spittle, Model model) {
		
		// TODO implement it
		
		return "education.spittle_view";

	}
	
	
}
