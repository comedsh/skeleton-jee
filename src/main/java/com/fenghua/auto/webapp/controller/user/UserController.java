package com.fenghua.auto.webapp.controller.user;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Pattern;
import java.sql.Timestamp;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import com.fenghua.auto.backend.core.utills.uploadPicture;
import com.fenghua.auto.backend.core.utills.graphValidate.PictureCheckCode;
import com.fenghua.auto.backend.core.utills.message.SMSMessage;
import com.fenghua.auto.backend.domain.user.Company;
import com.fenghua.auto.backend.domain.user.PaymentType;
import com.fenghua.auto.backend.domain.user.ResetPassRequest;
import com.fenghua.auto.backend.domain.user.User;
import com.fenghua.auto.backend.service.ConfigService;
import com.fenghua.auto.backend.service.user.UserForgetPassService;
import com.fenghua.auto.backend.service.user.UserService;
import com.fenghua.auto.webapp.view.Result;
import org.springframework.web.servlet.support.RequestContext;


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
	
	private static Date OLD_DATE = null;
	
	@Autowired
	private UserService userService;
	@Autowired
	private BCryptPasswordEncoder encoder;
	@Autowired
	private UserForgetPassService userForgetPassService;
	@Autowired
	private ConfigService configService;
	/**
	 * @author chengbin
	 * 增加一个个人用户注册
	 * @return 
	 * @createTime 2015.11.4
	 */
	@RequestMapping(value = "/regisUser", method = RequestMethod.POST)
	public @ResponseBody Map<String,Result> addUser(@Valid User user, @RequestParam String telcode, @RequestParam String code, HttpServletRequest request,Locale locale) {
		Map<String,Result> model = new HashMap<String,Result>();
		Result msg = new Result();
		String validateTel = (String) request.getSession().getAttribute("validateTel");
		String verifyCode = (String) request.getSession().getAttribute("rand");
		if(new Date().getTime() - OLD_DATE.getTime()  > 1000*120) {
			msg.setSuccess(false);
			msg.setMsg("您输入的验证码已过期");
		} else if(validateTel.equals(telcode) && verifyCode.equals(code)) {
			String userPwd = user.getPassword();
			userService.insert(user);
			msg.setSuccess(true);
			msg.setCode(user.getName());
			msg.setMsg("注册成功");
			//把用户名和密码存入安全的session中
			userService.autoLogin(user.getName(), userPwd, locale, request);
		} else {
			if(!validateTel.equals(telcode)) {
				msg.setSuccess(false);
				msg.setMsg("您输入的手机验证码有误");
			} else {
				msg.setSuccess(false);
				msg.setMsg("您输入的图形验证码有误");
			}
		}
		model.put("message", msg);
		return model; 
	}
	/**
	 * 找回邮箱或密码跳转页面
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/findPassbyphoneOrEmail", method = RequestMethod.GET)
	public String findPassbyphoneOrEmail( HttpServletRequest request,Model model) {
		return "forgot.findPassbyphoneOrEmail";
	}
	@RequestMapping(value = "/findPassByPhone", method = RequestMethod.POST)
	public String findPassByPhone( HttpServletRequest request,Model model) {
		 RequestContext requestContext = new RequestContext(request);
		String path;
		Result msg = new Result();
		String validateTel = (String) request.getSession().getAttribute("validateTel");
		String verifyCode = (String) request.getSession().getAttribute("rand");
		if(new Date().getTime() - OLD_DATE.getTime()  > 1000*120) {
			msg.setSuccess(false);
			msg.setMsg(requestContext.getMessage("forgot.verificationexpire"));
			path="/user/forgetPass/findPassbyphone";
		} else if(validateTel.equals(request.getParameter("iPhone_code")) && verifyCode.equals(request.getParameter("code"))) {
			msg.setSuccess(true);
			msg.setMsg("成功");
			path="/user/forgetPass/findPassbyphone_second";
			//把用户名和密码存入安全的session中
		} else {
			if(!validateTel.equals(request.getParameter("iPhone_code"))) {
				msg.setSuccess(false);
				msg.setMsg("您输入的手机验证码有误");
				path="/user/forgetPass/findPassbyphone";
			} else {
				msg.setSuccess(false);
				msg.setMsg("您输入的图形验证码有误");
				path="/user/forgetPass/findPassbyphone";
			}
		}
		model.addAttribute("message", msg);
		request.getSession().setAttribute("phone",request.getParameter("mobile"));
		return path;
	}
	/**
	 * @author chengbin
	 * 增加一个企业用户注册
	 * @return 
	 * @createTime 2015.11.4
	 */
	@RequestMapping(value = "/regisUserCompany", method = RequestMethod.POST)
	public Map<String,Result> addUserAndCompany(@Valid User user, @Valid Company company, @RequestParam String telcode, @Valid PaymentType paymenttype,HttpServletRequest request, Locale locale) {
		Map<String,Result> model = new HashMap<String,Result>();
		Result msg = new Result();
		String validateTel = (String) request.getSession().getAttribute("validateTel");
		String licence = request.getSession().getAttribute("licence").toString();
		String certificate = request.getSession().getAttribute("certificate").toString();
		if(licence != null && !licence.equals("")  && certificate != null && !certificate.equals("") ) {
			if(new Date().getTime() - OLD_DATE.getTime()  > 1000*120) {
				msg.setSuccess(false);
				msg.setMsg("您输入的验证码已过期");
			}else if(validateTel.equals(telcode)) {
				company.setBusinessLicence(licence);
				company.setTaxpayerLicence(certificate);
				userService.insert(user,company,paymenttype);
				msg.setSuccess(true);
				msg.setCode(user.getName());
				msg.setMsg("注册成功");
				//把用户名和密码存入安全的session中
				userService.autoLogin(user.getName(), user.getPassword(), locale, request);
			} else {
				if(!validateTel.equals(telcode)) {
					msg.setSuccess(false);
					msg.setMsg("您输入的手机验证码有误");
				} else {
					msg.setSuccess(false);
					msg.setMsg("您输入的图形验证码有误");
				}
			}
		} else {
			msg.setSuccess(false);
			msg.setMsg("您的图片没有上传成功");
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
	public @ResponseBody User validateName(@RequestParam String name,  HttpServletRequest req, HttpServletResponse res) {
		return userService.getUserByName(name);
	}
	/**
	 * 通过name判断是否应该显示图形验证码
	 * @param name
	 * @param req
	 * @param res
	 */
	@RequestMapping(value = "/validatePic", method = RequestMethod.GET)
	public @ResponseBody Map<String,Result> getValidatePic(@RequestParam String name,  HttpServletRequest req, HttpServletResponse res) {
		Map<String,Result> model = new HashMap<String,Result>();
		Result result = new Result();
		if(name ==null || name.equals("")) {
			//获取是否失败三次的session
			Object limitCounts = req.getSession().getAttribute("-t");
			if(limitCounts != null){
				if((int)limitCounts >= 3) {
					//显示图形验证码
					result.setSuccess(false);
				}
			}
		} else {
			String regex_tel ="^((13[0-9])|(15[^4,\\D])|(18[0-9]))\\d{8}$";
			String regex_email ="^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$";
			String regex_name ="^[a-zA-Z\\u4e00-\\u9fa5][a-zA-Z0-9\\u4e00-\\u9fa5]{3,19}$";
			User user = null;
			if(Pattern.compile(regex_tel).matcher(name).matches()) {
				user = userService.getUserByTelephone(name);
			}
			if(Pattern.compile(regex_email).matcher(name).matches()) {
				
				user = userService.getUserByEmail(name);
			}
			if(Pattern.compile(regex_name).matcher(name).matches()) {
				
				user = userService.getUserByName(name);
			}
			if(user!= null) {
				if(user.getFailedLoginTimes() != null){
					if(user.getFailedLoginTimes() >= 3) {
						//显示图形验证码
						result.setSuccess(false);
					}
				}
			}
		}
		model.put("msg", result);
		return model;
	}
	/**
	 * 通过telephone查询
	 * @param email
	 * @param req
	 * @param res
	 */
	@RequestMapping(value = "/validateTelephone", method = RequestMethod.GET)
	public @ResponseBody User validateTelephone(@RequestParam String telephone,  HttpServletRequest req, HttpServletResponse res) {
		return userService.getUserByTelephone(telephone);
	}
	/**
	 * 通过email查询
	 * @param email
	 * @param req
	 * @param res
	 */
	@RequestMapping(value = "/validateEmail", method = RequestMethod.GET)
	public @ResponseBody User validateEmail(@RequestParam String email,  HttpServletRequest req, HttpServletResponse res) {
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
					 session.setAttribute("validateTel", str);
					 OLD_DATE = new Date();
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
	 * 根据电话号码跟新密码
	 * @param user
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/updatePasswordByPhone",method=RequestMethod.POST)
	public  ModelAndView  updatePasswordByPhone(  HttpServletRequest request,Model model) {
		Map<String,Result> model1 = new HashMap<String,Result>();
		Long id=null;
		String path;
		String phone = (String) request.getSession().getAttribute("phone");
		id=userService.updatePasswordByPhone(request.getParameter("pwd_new"),phone);
		Result msg = new Result();
		if(id != null && id!=0) {
			msg.setSuccess(true);
			msg.setMsg("修改成功");
			msg.setCode(phone);
			path="/user/forgetPass/findPassbyphone_last";
		} else {
			msg.setSuccess(false);
			msg.setMsg("修改失败");
			path="/user/forgetPass/findPassbyphone_second";
			
		}
		model1.put("message", msg);
		 return new ModelAndView(path,model1);
	}
	/**
	 * 根据用户id跟新密码
	 * @param user
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/updatePasswordByUserId",method=RequestMethod.POST)
	public @ResponseBody Map<String,Result> updatePasswordByUserId(@RequestParam String pwdNew,@RequestParam Long userId, Model model) {
		Map<String,Result> model1 = new HashMap<String,Result>();
		Long id=null;
		id=userService.updatePasswordByUserId(pwdNew, userId);
		Result msg = new Result();
		if(id != null && id!=0) {
			User user=userService.getUserByuserId(userId);
			msg.setSuccess(true);
			msg.setMsg("修改成功");
			msg.setCode(user.getEmail());
		} else {
			msg.setSuccess(false);
			msg.setMsg("修改失败");
			
		}
		model1.put("message", msg);
		return model1;
	}

	/**
	 * 忘记密码  发送邮件链接
	 * @param email
	 * @param phone
	 * @param model
	 */
	@RequestMapping(value = "/forGotPassword",method=RequestMethod.POST)
	public ModelAndView forGotPassword( HttpServletRequest request, Model model) {
		userForgetPassService.insert(request.getParameter("email"));
		Map<String,Result> model1 = new HashMap<String,Result>();
		 return new ModelAndView("/user/forgetPass/findPssByEamil_Second",model1);
	}
	/**
	 * 验证找回密码邮箱链接
	 * @param spittle
	 * @param result
	 * @param model
	 * @return
	 */
	@RequestMapping(value ="/checkResetLink") 
	public  ModelAndView checkResetLink(@RequestParam String token, @RequestParam Long userId, Model model){
		List<ResetPassRequest> list=null;
	    list =userForgetPassService.selectByCodeAndUser(token, userId);
	    Calendar c = Calendar.getInstance();
		//现在的时间(单位：毫秒)
		long curtime = c.getTimeInMillis();
		Map<String,String> map = new HashMap<String, String>();
		if(list!=null && list.size()>0){
			ResetPassRequest resetPassRequest=list.get(0);
			Timestamp token_exptime=resetPassRequest.getValidTo();
			if( System.currentTimeMillis()>token_exptime.getTime() ){
				//激活码过期，先删除该用户记录，然后重新发送邮件
				userForgetPassService.deleteByUserId(userId);
				return new ModelAndView("/user/forgetPass/findPassFail",map);
			}else{
				userForgetPassService.deleteByUserId(userId);
				map.put("userId", userId.toString());
				return new ModelAndView("/user/forgetPass/findPassbyemail",map);
			}
		}else{
			return new ModelAndView("/user/forgetPass/findPassFail",map);
		}
		
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
	@RequestMapping(value = "/upload",method=RequestMethod.POST)
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
	@RequestMapping(value = "/uploads",method=RequestMethod.POST)
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
