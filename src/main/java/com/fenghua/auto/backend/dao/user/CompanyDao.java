package com.fenghua.auto.backend.dao.user;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.fenghua.auto.backend.dao.BaseDao;
import com.fenghua.auto.backend.domain.user.Company;;
/**
 * 企业dao
 * @author chengbin
 * @createtime 2015.11.2
 *
 */
@Repository
public interface CompanyDao extends BaseDao<Company> {
	/**
	 * 通过用户Fixed查询对应数据
	 * @param Fixed
	 * @return
	 */
	public List<Company> selectByFixed(String fixed);
	
	public List<Company> selectByTelephone(String telephone);
	
	public List<Company> selectByEmail(String email);

	public Long getCompanyId(Company company);
	
	
}
