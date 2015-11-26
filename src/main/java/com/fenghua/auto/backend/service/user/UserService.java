package com.fenghua.auto.backend.service.user;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import com.fenghua.auto.backend.domain.user.Company;
import com.fenghua.auto.backend.domain.user.PaymentType;
import com.fenghua.auto.backend.domain.user.User;
/**
 * 个人注册service
 * 
 * @author chengbin
 * @createTime 2015.11.2
 *
 */
public interface UserService {
	/**
	 * 通过id注销用户
	 * @param id
	 */
	public void delete(Long id);
	/**
	 * 修改用户
	 * @param personal
	 */
	public void update(User personal);
	/**
	 * 更新登录失败次数
	 * @param name
	 */
	public void updateFailTimes(String name,short count);
	/**
	 * 增加个人用户
	 * @param personal
	 */
	public void insert(User personal);
	/**
	 * 增加企业用户
	 * @param personal
	 */
	public void insert(User personal,Company company,PaymentType paymenttype);
	/**
	 * 通过id获取用户
	 * @param id
	 * @return
	 */
	public User getUserById(Long id);
	/**
	 * 获取所有用户信息
	 * @return
	 */
	public List<User> getAll();
	/**
	 * 通过name查询用户
	 * @return
	 */
	public User getUserByName(String name);
	/**
	 * 通过email查询用户
	 * @return
	 */
	public User getUserByEmail(String email);

//	/**
//	 * 通过telephone查询用户
//	 * @return
//	 */
//
//	public List<User> getUserByTelephone(String telephone);
	/**
	 * 根据用户id查询用户相信信息
	 * @param userId
	 * @return
	 */
	public User getUserByuserId(Long userId);
	/**
	 * 根据电话号码更新密码
	 * @param user
	 * @return
	 */
	public Long updatePasswordByPhone(String pwdNew,String phone);
	/**
	 * 根据用户id跟新密码
	 * @param pwdNew
	 * @param phone
	 * @return
	 */
	public Long updatePasswordByUserId(String pwdNew,Long UserId);
   
	public User getUserByTelephone(String telephone);

	/**
	 * 自动登录，把用户名和密码写入security session中
	 * @param userName
	 * @param passWord
	 * @param locale
	 * @param request
	 */
	public void autoLogin(String userName, String passWord, HttpServletRequest request);

	/**
	 * 根据qq openID查询用户
	 * @param openID
	 * @return
	 */
	public User getUserByQQ(String openID);
}
