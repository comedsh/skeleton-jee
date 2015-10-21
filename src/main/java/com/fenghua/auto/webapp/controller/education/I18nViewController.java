/**
 * 
 */
package com.fenghua.auto.webapp.controller.education;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author 王直元
 * 
 * 测试根据语言变换模版
 *
 */
@Controller
public class I18nViewController {
	
	@RequestMapping(value = "/i18nView", method = { RequestMethod.GET })
	public String index(HttpServletRequest request, Model model) throws Exception {
		
		
		return "web.i18n";
	}
}
