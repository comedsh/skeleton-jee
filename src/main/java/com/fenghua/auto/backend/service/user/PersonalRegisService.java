package com.fenghua.auto.backend.service.register;

import java.util.List;

import com.fenghua.auto.backend.domain.register.Personal;

/**
 * 个人注册service
 * 
 * @author chengbin
 * @createTime 2015.11.2
 *
 */
public interface PersonalRegisService {
	/**
	 * 通过id注销个人用户
	 * @param id
	 */
	public void delete(Long id);
	/**
	 * 修改一个个人用户
	 * @param personal
	 */
	public void update(Personal personal);
	/**
	 * 增加一个个人用户
	 * @param personal
	 */
	public void insert(Personal personal);
	/**
	 * 通过id获取一个个人用户信息
	 * @param id
	 * @return
	 */
	public Personal getPersonalById(Long id);
	/**
	 * 获取所有的个人用户信息
	 * @return
	 */
	public List<Personal> getAll();
}