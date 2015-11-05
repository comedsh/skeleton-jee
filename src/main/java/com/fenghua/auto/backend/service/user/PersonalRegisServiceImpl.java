package com.fenghua.auto.backend.service.register;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fenghua.auto.backend.dao.register.PersonalDao;
import com.fenghua.auto.backend.domain.register.Personal;

/**
 * 个人注册接口实现
 * @author chengbin
 * @createTime 2015.11.2
 *
 */
@Service
public class PersonalRegisServiceImpl implements PersonalRegisService {
	
	@Autowired
	private PersonalDao personalDao;

	@Override
	public void delete(Long id) {
		personalDao.deleteById(id);
	}

	@Override
	public void update(Personal personal) {
		personalDao.updateById(personal);
	}

	@Override
	public void insert(Personal personal) {
		personalDao.insert(personal);
	}

	@Override
	public Personal getPersonalById(Long id) {
		return personalDao.selectById(id);
	}

	@Override
	public List<Personal> getAll() {
		return personalDao.selectAll();
	}
	
}
