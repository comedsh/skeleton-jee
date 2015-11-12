package com.fenghua.auto.backend.dao.user;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.fenghua.auto.backend.dao.BaseDao;
import com.fenghua.auto.backend.domain.user.User;;
/**
 * 个人注册dao
 * @author chengbin
 * @createtime 2015.11.2
 *
 */
@Repository
public interface UserDao extends BaseDao<User> {
	/**
	 * 通过用户name查询对应数据
	 * @param name
	 * @return
	 */
	public List<User> selectByName(String name); 
	/**
	 * 通过用户email查询对应数据
	 * @param email
	 * @return
	 */
	public List<User> selectByEmail(String email); 
	/**
	 * 通过用户telephone查询对应数据
	 * @param telephone
	 * @return
	 */
	public List<User> selectByTelephone(String telephone); 
	/**
	 * 通过用户Fixed查询对应数据
	 * @param Fixed
	 * @return
	 */
	public List<User> selectByFixed(String fixed); 
}
