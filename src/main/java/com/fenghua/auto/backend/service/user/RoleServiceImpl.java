package com.fenghua.auto.backend.service.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fenghua.auto.backend.dao.user.RoleDao;
import com.fenghua.auto.backend.domain.user.Role;

/**
 * 企业接口实现
 * @author chengbin
 * @createTime 2015.11.2
 *
 */
@Service
public class RoleServiceImpl implements RoleService {
	
	@Autowired
	private RoleDao roleDao;

	@Override
	public List<Role> getRoleById(Long id) {
		return roleDao.getRoleById(id);
	}
	
}
