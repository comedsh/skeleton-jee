<<<<<<< HEAD
package com.fenghua.auto.webapp.controller.education;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.fenghua.auto.backend.domain.education.Spittle;
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
	public String home(Model model) {

		model.addAttribute("spittles", spittleService.getAllSpittles());
		
		// adds the spittle as the command name of the model attribute on the page. or else
		// Neither BindingResult nor plain target object for bean name 'spittle' available as request attribute errors thrown
		model.addAttribute("spittle", new Spittle());
		
		// by using TilesView to render this page. the full template path should
		// be education_spittle_home.tiles.
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
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String getSpittle(@PathVariable("id") long id, Model model) {

		List<Spittle> spittles = new ArrayList<Spittle>(1);
		
		spittles.add( spittleService.getSpittleById(id) );
		
		model.addAttribute( "spittles", spittles );

		return "education.spittle_view";

	}
	
	/**
	 * 
	 * for client invoke
	 * 
	 * Accept the xml / json request, and it will returns the xml or json object back to the client
	 * 
	 * @ResponseBody -> will automatically translate the return object to be xml or json object.
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, 
					headers = {"Accept=text/xml, application/json"} ) // indicates, the server only accept the xml or json request.
	public @ResponseBody Spittle getSpittle(@PathVariable("id") long id ){
	
		return spittleService.getSpittleById(id);
	
	}	
	/**
	 * 
	 * restful, 参数化的 URL,
	 * 
	 * 将用户名作为参数，查询对应的所有的 spittles
	 * 
	 * 注意，URL 参数不仅仅在 URL 的末尾，可以在路径的中间
	 * 
	 * @param username
	 * @return
	 */
	@RequestMapping(value = "/{username}/spittles", method = RequestMethod.GET)
	public String spittlesForSpitter(@PathVariable("username") String username, Model model) {
		
		model.addAttribute("spittles", spittleService.getSpittlesByUsername(username) );
	
		return "education.spittle_view";
	
	}
	
	/**
	 * 
	 * for client invoke
	 * 
	 * @param username
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/{username}/spittles", method = RequestMethod.GET, headers = {"Accept=text/xml, application/json"})
	public @ResponseBody List<Spittle> spittlesForSpitter(@PathVariable("username") String username) {
		
		return spittleService.getSpittlesByUsername(username);
		
	}
	
	
	/**
	 * 
	 * restful, 参数化的 URL, 处理 DELETE 请求
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public String deleteSpittle(@PathVariable("id") long id, Model model) {

		spittleService.deleteSpittle(id);

		// model.addAttribute( "spittles", spittleService.getAllSpittles() );
		// If Tomcat 8.x, it addressed as a bug as HTTP Status 405 - JSPs onlypermit GET POST or HEAD. -> 如果用下面 forward 的方式，会报左边这个错误；因为 forward会继续以 delete 的方式执行
		// return "education.spittle_home"; // why comments it out, because we should use the redirect after deletion request for avoiding the duplicate deletion request at the same page.

		return "redirect:/spittle/home";

	}
	
	/**
	 * 
	 * action POST, special case for rest, 没有参数化的 URL, 
	 * 
	 * @param spittle
	 * @param result
	 * @param response
	 * @return
	 */
	@RequestMapping(method=RequestMethod.POST) // no value attribute means that uses the path /spittle
	public String addSpittle(@Valid Spittle spittle, BindingResult result, Model model){
		
		if(result.hasErrors()) {
			
			model.addAttribute("spittles", spittleService.getAllSpittles());
			
	        return "education.spittle_home";
	    }		
		
		spittleService.addSpittle(spittle);
		
		return "redirect:/spittle/home";
		
	}
	
	/**
	 * 
	 * for client invoke
	 * 
	 * @param spittle
	 * @param result
	 * @throws BindException 
	 */
	@RequestMapping(method=RequestMethod.POST, headers="Content-Type=application/json") // no value attribute means that uses the path /spittle
	@ResponseStatus(HttpStatus.CREATED)
	public @ResponseBody Spittle addSpittle(@Valid @RequestBody Spittle spittle, BindingResult result, HttpServletResponse response) throws BindException{
		
		if( result.hasErrors() ) throw new BindException(result);
		
		spittleService.addSpittle(spittle);
		
		response.setHeader("Location", "/spittle/" + spittle.getId() );
		
		return spittle;
		
	}	
	
	/**
	 * 
	 * action PUT, 用于更新资源
	 * 
	 * @param spittle -> the id attribute value will be automatically set in.
	 * @param result
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/{id}", method=RequestMethod.PUT)
	public String updateSpittle(@Valid Spittle spittle, BindingResult result, Model model){
		
		if(result.hasErrors()) {
			
			model.addAttribute("spittles", spittleService.getAllSpittles());
			
	        return "education.spittle_home";
	    }			
		
		spittleService.updateSpittle(spittle);
		
		return "redirect:/spittle/home";
	}
	
	/**
	 * 
	 * for client invoke
	 *
	 *  
	 * @param spittle -> 注意 @RequestBody 的用法，将客户端发送的数据转换成对象
	 * @param result
	 * @throws BindException 
	 */
	@RequestMapping(value = "/{id}", method=RequestMethod.PUT, headers="Content-Type=application/json" )
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public @ResponseBody Spittle updateSpittle( @Valid @RequestBody Spittle spittle, BindingResult result ) throws BindException{
		
		if( result.hasErrors() ) throw new BindException(result);
		
		spittleService.updateSpittle(spittle);
		
		return spittle;
		
	}
	
	
}
=======
package com.fenghua.auto.webapp.controller.education;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fenghua.auto.backend.domain.education.Spittle;
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
	public String home(Model model) {

		model.addAttribute("spittles", spittleService.getAllSpittles());
		
		// adds the spittle as the command name of the model attribute on the page. or else
		// Neither BindingResult nor plain target object for bean name 'spittle' available as request attribute errors thrown
		model.addAttribute("spittle", new Spittle());
		
		// by using TilesView to render this page. the full template path should
		// be education_spittle_home.tiles.
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
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String getSpittle(@PathVariable("id") long id, Model model) {

		model.addAttribute(spittleService.getSpittleById(id));

		return "education.spittle_view";

	}
	
	/**
	 * 
	 * Accept the xml / json request, and it will returns the xml or json object back to the client
	 * 
	 * @ResponseBody -> will automatically translate the return object to be xml or json object.
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, 
					headers = {"Accept=text/xml, application/json"} ) // indicates, the server only accept the xml or json request.
	public @ResponseBody Spittle getSpittle(@PathVariable("id") long id ){
	
		return spittleService.getSpittleById(id);
	
	}	
	/**
	 * 
	 * restful, 参数化的 URL,
	 * 
	 * 将用户名作为参数，查询对应的所有的 spittles
	 * 
	 * 注意，URL 参数不仅仅在 URL 的末尾，可以在路径的中间
	 * 
	 * @param spitterName
	 * @return
	 */
	@RequestMapping(value = "/{username}/spittles", method = RequestMethod.GET)
	public String spittlesForSpitter(@PathVariable("username") String spitterName, Model model) {
		
		model.addAttribute("spittles", spittleService.getSpittlesByUsername(spitterName) );
	
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
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public String deleteSpittle(@PathVariable("id") long id, Model model) {

		spittleService.deleteSpittle(id);

		// model.addAttribute( "spittles", spittleService.getAllSpittles() );
		// If Tomcat 8.x, it addressed as a bug as HTTP Status 405 - JSPs onlypermit GET POST or HEAD. -> 如果用下面 forward 的方式，会报左边这个错误；因为 forward会继续以 delete 的方式执行
		// return "education.spittle_home"; // why comments it out, because we should use the redirect after deletion request for avoiding the duplicate deletion request at the same page.

		return "redirect:/spittle/home";

	}
	
	/**
	 * 
	 * form submit, special case for rest, 没有参数化的 URL, 
	 * 
	 * @param spittle
	 * @param result
	 * @param response
	 * @return
	 */
	@RequestMapping(method=RequestMethod.POST) // no value attribute means that uses the path /spittle
	// @ResponseStatus(HttpStatus.CREATED)
	public String addSpittle(@Valid Spittle spittle, BindingResult result, Model model){
		
		if(result.hasErrors()) {
			
			model.addAttribute("spittles", spittleService.getAllSpittles());
			
	        return "education.spittle_home";
	    }		
		
		spittleService.addSpittle(spittle);
		
		return "redirect:/spittle/home";
		
	}
	
	
}
>>>>>>> branch 'master' of http://218.244.137.212:8080/dev/fenghua.git
