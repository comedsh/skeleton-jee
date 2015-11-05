package com.fenghua.auto.webapp.controller.register;

import java.util.List;

import javax.validation.Valid;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fenghua.auto.backend.domain.register.Personal;
import com.fenghua.auto.backend.service.register.PersonalRegisService;

/**
 * 个人注册功能模块
 * 
 * @author chengbin
 * @createTime 2015.11.2
 */
@Controller
@RequestMapping("/personalRegis")
public class PersonalRegisController {
	@Autowired
	private PersonalRegisService personalRegisService;
	/**
	 * @author chengbin
	 * 增加一个用户注册
	 * @return 
	 * @createTime 2015.11.4
	 */
	@RequestMapping(method=RequestMethod.POST)
	public String addPersonal(@Valid Personal personal, Model model) {
		personalRegisService.insert(personal);
		return "";
	}
	
	/**
	 *  获取所有的用户注册信息
	 * @return
	 */
	@RequestMapping(method=RequestMethod.GET)
	public List<Personal> getAllPersonal(Model model) {
		return personalRegisService.getAll();
	}
	/**
	 * 通过用户id查找对应的用户注册信息
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public Personal getPersonalById(@PathVariable("id") Long id, Model model) {
		return personalRegisService.getPersonalById(id);
	}
	/**
	 * 
	 * @param personal
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/{id}",method=RequestMethod.PUT)
	public String updatePersonal(@Valid Personal personal, Model model) {
		personalRegisService.update(personal);
		return "";
	}
	/**
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/{id}",method=RequestMethod.DELETE)
	public String deletePersonal(@PathVariable Long id, Model model) {
		personalRegisService.delete(id);
		return "";
	}
}
