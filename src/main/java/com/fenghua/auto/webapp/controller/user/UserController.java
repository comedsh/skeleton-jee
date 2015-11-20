package com.fenghua.auto.webapp.controller.user;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
import com.fenghua.auto.webapp.view.Result;

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
	public @ResponseBody Map<String,Result> addUser(@Valid User user, HttpServletRequest request) {
		Map<String,Result> model = new HashMap<String,Result>();
		Result msg = new Result();
		if(request.getSession(false) == null) {
			msg.setSuccess(false);
			msg.setMsg("注册失败");
		} else {
			userService.insert(user);
			msg.setSuccess(true);
			msg.setMsg("注册成功");
			msg.setCode(user.getName()+"&"+user.getPassword());
		}
		model.put("message", msg);
		return model;
	}
	
	/**
	 * @author chengbin
	 * 增加一个企业用户注册
	 * @return 
	 * @createTime 2015.11.4
	 */
	@RequestMapping(value = "/regisUserCompany", method = RequestMethod.POST)
	public Map<String,Result> addUserAndCompany(@Valid User user, @Valid Company company, @Valid PaymentType paymenttype,HttpServletRequest request) {
		Map<String,Result> model = new HashMap<String,Result>();
		Result msg = null;
		String licence = request.getSession().getAttribute("licence").toString();
		String certificate = request.getSession().getAttribute("certificate").toString();
		if(licence.equals("") && licence != null && certificate.equals("") && certificate != null) {
			company.setBusinessLicence(licence);
			company.setBusinessLicence(certificate);
			userService.insert(user,company,paymenttype);
			msg = new Result(true,"注册成功");
		} else {
			msg = new Result(false,"注册失败");
		}
		model.put("message", msg);
		return model;
	}
	
	/**
	 * 通过name查询
	 * @param name
	 * @param req
	 * @param res
	 */
	@RequestMapping(value = "/validateName", method = RequestMethod.GET)
	public @ResponseBody List<User> validateName(@RequestParam String name,  HttpServletRequest req, HttpServletResponse res) {
		return userService.getUserByName(name);
	}
	/**
	 * 通过telephone查询
	 * @param email
	 * @param req
	 * @param res
	 */
	@RequestMapping(value = "/validateTelephone", method = RequestMethod.GET)
	public @ResponseBody List<User> validateTelephone(@RequestParam String telephone,  HttpServletRequest req, HttpServletResponse res) {
		return userService.getUserByTelephone(telephone);
	}
	/**
	 * 通过email查询
	 * @param email
	 * @param req
	 * @param res
	 */
	@RequestMapping(value = "/validateEmail", method = RequestMethod.GET)
	public @ResponseBody List<User> validateEmail(@RequestParam String email,  HttpServletRequest req, HttpServletResponse res) {
		return userService.getUserByEmail(email);
	}
	/**
	 * 获取图片验证码
	 * @param email
	 * @param req
	 * @param res
	 */
	@RequestMapping(value = "/validatePicCheck", method = RequestMethod.GET)
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
	@RequestMapping(value = "/validatePicCheckValue",method = RequestMethod.GET)
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
				if(str!=null){
					 HttpSession session = req.getSession();
					 session.setMaxInactiveInterval(60);
					 session.setAttribute("validateTel", str);
				}
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
	@RequestMapping(value = "/upload",method=RequestMethod.GET)
	public @ResponseBody void upload(@RequestParam(value = "houseMaps") MultipartFile picture, HttpServletResponse response, HttpServletRequest request){
		String name = "licence";
		response.setContentType("text/html");
		JSONObject json = uploadPicture.upload(picture, response, request, name);
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
	@RequestMapping(value = "/uploads",method=RequestMethod.GET)
	public @ResponseBody void uploads(@RequestParam(value = "houseMapss") MultipartFile picture, HttpServletResponse response,HttpServletRequest request){
		String name = "certificate";
		response.setContentType("text/html");
		JSONObject json = uploadPicture.upload(picture, response, request, name);
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
