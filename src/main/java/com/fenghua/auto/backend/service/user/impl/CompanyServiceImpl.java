package com.fenghua.auto.backend.service.user.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fenghua.auto.backend.dao.user.CompanyDao;
import com.fenghua.auto.backend.domain.user.Company;
import com.fenghua.auto.backend.service.user.CompanyService;

/**
 * 企业接口实现
 * @author chengbin
 * @createTime 2015.11.2
 *
 */
@Service
public class CompanyServiceImpl implements CompanyService {
	
	@Autowired
	private CompanyDao companyDao;
	
	@Override
	public List<Company> getUserByFixed(String fixed) {
		return companyDao.selectByFixed(fixed);
	}
	@Override
	public List<Company> getContactsTelephone(String telephone) {
		return companyDao.selectByTelephone(telephone);
	}
	@Override
	public List<Company> getCompanyByEmail(String email) {
		return companyDao.selectByEmail(email);
	}
}
