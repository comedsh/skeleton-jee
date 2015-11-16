package com.fenghua.auto.backend.service.user;

import java.util.List;

import com.fenghua.auto.backend.domain.user.Company;
import com.fenghua.auto.backend.domain.user.Role;

/**
 * 企业service
 * 
 * @author chengbin
 * @createTime 2015.11.2
 *
 */
public interface RoleService {
	/**
	 * 通过fixed查询对应的实体
	 * @return
	 */
	public List<Role> getRoleById(Long id);
}
