package com.fenghua.auto.backend.service.user;

import java.util.List;

import com.fenghua.auto.backend.domain.user.Company;
import com.fenghua.auto.backend.domain.user.Payment_type;
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
	 * 通过id注销个人用户
	 * @param id
	 */
	public void delete(Long id);
	/**
	 * 修改一个个人用户
	 * @param personal
	 */
	public void update(User personal);
	/**
	 * 增加一个个人用户
	 * @param personal
	 */
	public void insert(User personal);
	/**
	 * 增加一个企业用户
	 * @param personal
	 */
	public void insert(User personal,Company company,Payment_type paymenttype);
	/**
	 * 通过id获取一个个人用户信息
	 * @param id
	 * @return
	 */
	public User getUserById(Long id);
	/**
	 * 获取所有的个人用户信息
	 * @return
	 */
	public List<User> getAll();
	/**
	 * 通过name查询对应的实体
	 * @return
	 */
	public List<User> getUserByName(String name);
	/**
	 * 通过email查询对应的实体
	 * @return
	 */
	public List<User> getUserByEmail(String email);
	/**
	 * 通过telephone查询对应的实体
	 * @return
	 */
	public List<User> getUserByTelephone(String telephone);
	/**
	 * 通过fixed查询对应的实体
	 * @return
	 */
	public List<Company> getUserByFixed(String fixed);
}
