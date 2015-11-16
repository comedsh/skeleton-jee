package com.fenghua.auto.webapp.controller.user;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.imageio.ImageIO;
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

import com.fenghua.auto.backend.core.utills.ScaleImg;
import com.fenghua.auto.backend.core.utills.graphValidate.PictureCheckCode;
import com.fenghua.auto.backend.core.utills.message.SMSMessage;
import com.fenghua.auto.backend.domain.user.Company;
import com.fenghua.auto.backend.domain.user.Payment_type;
import com.fenghua.auto.backend.domain.user.User;
import com.fenghua.auto.backend.service.user.UserService;

import net.sf.json.JSONObject;

/**
 * 个人注册功能模块
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
		return "/WEB-INF/views/user/login";
	}
	/**
	 * @author chengbin
	 * 增加一个企业用户注册
	 * @return 
	 * @createTime 2015.11.4
	 */
	@RequestMapping(value = "/regisUserCompany", method = RequestMethod.POST)
	public String addUserAndCompany(@Valid User user, @Valid Company company, @Valid Payment_type paymenttype, Model model,HttpServletRequest request) {
		userService.insert(user,company,paymenttype);
		return "/WEB-INF/views/user/login";
	}
	
	/**
	 * 跳转到登录页面
	 * @param user
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/ulogin")
	public String showLoginPage(@Valid User user, Model model,HttpServletRequest request) {
		return "/WEB-INF/views/user/login";
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
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public void upload(@RequestParam(value = "themePicture") MultipartFile picture,
			HttpServletResponse response,
			HttpServletRequest request){
		response.setContentType("application/json");
		JSONObject json = new JSONObject();
		if(!picture.isEmpty()) {
			
			String pictureName = picture.getOriginalFilename();
			//验证上传文件是否为图片
			String reg = ".+(.JPEG|.jpeg|.JPG|.jpg|.GIF|.gif|.BMP|.bmp|.PNG|.png)$";
	        Pattern pattern = Pattern.compile(reg);
	        Matcher matcher = pattern.matcher(pictureName);
	        //验证通过
	        if(matcher.find()){
				String logoRealPathDir = request.getSession().getServletContext()
						.getRealPath("/");
				logoRealPathDir = logoRealPathDir + "common/images/bgpicture";
				// 验证文件夹是否存在
				File logoSaveFile = new File(logoRealPathDir);
				if (!logoSaveFile.exists())
					logoSaveFile.mkdirs(); // 不存在，新建文件夹
	
				UUID uuid = UUID.randomUUID();
				//图片重命名
				String fileName = logoRealPathDir + File.separator + uuid + pictureName.substring(pictureName.lastIndexOf("."),pictureName.length());
				String name = request.getContextPath()
						+ "/common/images/bgpicture/" + uuid + pictureName.substring(pictureName.lastIndexOf("."),pictureName.length());
				// 保存上传图片路径
				json.put("filePath", name);
				@SuppressWarnings("unused")
				File file = new File(fileName);
	
				/*try {
					FileUtils.writeByteArrayToFile(file, picture.getBytes());
					 picture.transferTo(file); 
				} catch (IOException e) {
					e.printStackTrace();
				}*/
				//缩放图片
				BufferedImage srcBufferImage = null;
				try {
					srcBufferImage = ImageIO.read(picture.getInputStream());
				} catch (IOException e1) {
					e1.printStackTrace();
				}  
		        BufferedImage scaledImage;  
		        ScaleImg scaleImage = ScaleImg.getInstance();  
		        int yw = srcBufferImage.getWidth();  
		        int yh = srcBufferImage.getHeight();  
		        int w = 100, h = 100;  
		        // 如果上传图片 宽高 比 压缩的要小 则不压缩  
		        if (w > yw && h > yh)  
		        {  
		            FileOutputStream fos = null;
					try {
						fos = new FileOutputStream(fileName);
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					}  
		  
					ByteArrayInputStream fis = null;
					try {
						//fis = (FileInputStream) picture.getInputStream().getClass();
						fis =  (ByteArrayInputStream) picture.getInputStream();
					} catch (IOException e) {
						e.printStackTrace();
					}  
		            byte[] buffer = new byte[1024];  
		            int len = 0;  
		            try {
						while ((len = fis.read(buffer)) > 0)  
						{  
						    try {
								fos.write(buffer, 0, len);
							} catch (IOException e) {
								e.printStackTrace();
							}  
						}
					} catch (IOException e) {
						e.printStackTrace();
					}finally{
						try {
							fis.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
						try {
							fos.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
		           
		        }  
		        else  
		        {  
		            scaledImage = scaleImage.imageZoomOut(srcBufferImage, w, h);  
		            FileOutputStream out = null;
					try {
						out = new FileOutputStream(fileName);
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					}  
		            try {
						ImageIO.write(scaledImage, "jpeg", out);
					} catch (IOException e) {
						e.printStackTrace();
					}  
		            finally{
		            	try {
							out.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
		            }
		        }  
			}
	        //验证失败
	        else{
	        	json.put("filePath", "");
			}
		}
		else{
			json.put("filePath", "");
		}
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
