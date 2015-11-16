package com.fenghua.auto.backend.dao.user;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.fenghua.auto.backend.dao.BaseDao;
import com.fenghua.auto.backend.domain.user.Role;;
/**
 * 企业dao
 * @author chengbin
 * @createtime 2015.11.2
 *
 */
@Repository
public interface RoleDao extends BaseDao<Role> {
	
	public List<Role> getRoleById(Long id);
	/**
	 * 插入数据时返回主键Id
	 * @param role
	 * @return
	 */
	public Long getIdInsert(Role role);
	
}
