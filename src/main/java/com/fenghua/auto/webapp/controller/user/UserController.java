package com.fenghua.auto.webapp.controller.user;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fenghua.auto.backend.domain.user.User;
import com.fenghua.auto.backend.service.user.UserService;

/**
 * 个人注册功能模块
 * 
 * @author chengbin
 * @createTime 2015.11.2
 */
@Controller
@RequestMapping("/UserRegis")
public class UserController {
	@Autowired
	private UserService userService;
	/**
	 * @author chengbin
	 * 增加一个用户注册
	 * @return 
	 * @createTime 2015.11.4
	 */
	@RequestMapping(method=RequestMethod.POST)
	public String addUser(@Valid User user, Model model) {
		userService.insert(user);
		return "";
	}
	
	/**
	 *  获取所有的用户注册信息
	 * @return
	 */
	@RequestMapping(method=RequestMethod.GET)
	public List<User> getAllUser(Model model) {
		return userService.getAll();
	}
	/**
	 * 通过用户id查找对应的用户注册信息
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public User getUserById(@PathVariable("id") Long id, Model model) {
		return userService.getUserById(id);
	}
	/**
	 * 
	 * @param User
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/{id}",method=RequestMethod.PUT)
	public String updateUser(@Valid User user, Model model) {
		userService.update(user);
		return "";
	}
	/**
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/{id}",method=RequestMethod.DELETE)
	public String deleteUser(@PathVariable Long id, Model model) {
		userService.delete(id);
		return "";
	}
}
