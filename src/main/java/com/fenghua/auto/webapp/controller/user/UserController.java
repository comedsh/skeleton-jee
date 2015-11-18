package com.fenghua.auto.webapp.controller.user;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import com.fenghua.auto.backend.core.utills.uploadPicture;
import com.fenghua.auto.backend.core.utills.graphValidate.PictureCheckCode;
import com.fenghua.auto.backend.core.utills.message.SMSMessage;
import com.fenghua.auto.backend.domain.user.Company;
import com.fenghua.auto.backend.domain.user.PaymentType;
import com.fenghua.auto.backend.domain.user.User;
import com.fenghua.auto.backend.service.user.UserService;
import net.sf.json.JSONObject;

/**
 * 用户功能模块
 * 
 * @author chengbin
 * @createTime 2015.11.2
 */
@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	/**
	 * @author chengbin
	 * 增加一个个人用户注册
	 * @return 
	 * @createTime 2015.11.4
	 */
	@RequestMapping(value = "/regisUser", method = RequestMethod.POST)
	public String addUser(@Valid User user, Model model,HttpServletRequest request) {
		userService.insert(user);
		return "/login";
	}
	
	/**
	 * 跳转到注册页面
	 * @return
	 */
	@RequestMapping(value = "/fowardRegister")
	public String farwordRegister(HttpServletRequest request,HttpServletResponse response) {
		return "/WEB-INF/views/user/register/registered";
	}
	
	/**
	 * @author chengbin
	 * 增加一个企业用户注册
	 * @return 
	 * @createTime 2015.11.4
	 */
	@RequestMapping(value = "/regisUserCompany", method = RequestMethod.POST)
	public String addUserAndCompany(@Valid User user, @Valid Company company, @Valid PaymentType paymenttype, Model model,HttpServletRequest request) {
		String licence = request.getSession().getAttribute("licence").toString();
		company.setBusinessLicence(licence);
		userService.insert(user,company,paymenttype);
		return "/login";
	}
	
	/**
	 * 通过name查询
	 * @param name
	 * @param req
	 * @param res
	 */
	@RequestMapping(value = "/validateName", method = RequestMethod.POST)
	public @ResponseBody List<User> validateName(@RequestParam String name,  HttpServletRequest req, HttpServletResponse res) {
		return userService.getUserByName(name);
	}
	/**
	 * 通过telephone查询
	 * @param email
	 * @param req
	 * @param res
	 */
	@RequestMapping(value = "/validateTelephone", method = RequestMethod.POST)
	public @ResponseBody List<User> validateTelephone(@RequestParam String telephone,  HttpServletRequest req, HttpServletResponse res) {
		return userService.getUserByTelephone(telephone);
	}
	/**
	 * 通过email查询
	 * @param email
	 * @param req
	 * @param res
	 */
	@RequestMapping(value = "/validateEmail", method = RequestMethod.POST)
	public @ResponseBody List<User> validateEmail(@RequestParam String email,  HttpServletRequest req, HttpServletResponse res) {
		return userService.getUserByEmail(email);
	}
	/**
	 * 获取图片验证码
	 * @param email
	 * @param req
	 * @param res
	 */
	@RequestMapping(value = "/validatePicCheck")
	public void validatePicCheck(HttpServletRequest req, HttpServletResponse res) {
		try {
			PictureCheckCode.validatePicCheck(req,res);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 获取验证码code值
	 * @param email
	 * @param req
	 * @param res
	 */
	@RequestMapping(value = "/validatePicCheckValue",method = RequestMethod.POST)
	@ResponseBody
	public String validatePicCheckValue(HttpServletRequest req, HttpServletResponse res) {
		String str = null;
		try {
			str = PictureCheckCode.validatePicCheckValue(req,res);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return str;
	}
	/**
	 * 获取手机验证码
	 * @param email
	 * @param req
	 * @param res
	 */
	@RequestMapping(value = "/validateTel", method = RequestMethod.POST)
	@ResponseBody
	public String validateTel(@RequestParam String mobilephone,HttpServletRequest req, HttpServletResponse res, Model model) {
		String str = null;	
		try {
				str = SMSMessage.send(mobilephone,req,res);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return str;
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
	 * 更新用户
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
	 * 删除用户
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/{id}",method=RequestMethod.DELETE)
	public String deleteUser(@PathVariable Long id, Model model) {
		userService.delete(id);
		return "";
	}
	/**
	 * 营业执照上传
	 * @param picture
	 * @param response
	 * @param request
	 */
	@RequestMapping(value = "/upload")
	public @ResponseBody void upload(@RequestParam(value = "houseMaps") MultipartFile picture, HttpServletResponse response, HttpServletRequest request){
		response.setContentType("text/html");
		JSONObject json = uploadPicture.upload(picture, response, request);
		try {
			response.getWriter().write(json.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				response.getWriter().close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	/**
	 * 纳税人资格证上传
	 * @param picture
	 * @param response
	 * @param request
	 */
	@RequestMapping(value = "/uploads")
	public @ResponseBody void uploads(@RequestParam(value = "houseMapss") MultipartFile picture, HttpServletResponse response,HttpServletRequest request){
		response.setContentType("text/html");
		JSONObject json = uploadPicture.upload(picture, response, request);
		try {
			response.getWriter().write(json.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				response.getWriter().close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
