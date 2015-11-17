package com.fenghua.auto.backend.service.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fenghua.auto.backend.dao.user.CityAreaDao;
import com.fenghua.auto.backend.domain.user.City_area;

/**
 * CityArea接口实现
 * @author chengbin
 * @createTime 2015.11.2
 *
 */
@Service
public class CityAreaServiceImpl implements CityAreaService {
	
	@Autowired
	private CityAreaDao cityAreaDao;
	
	@Override
	public List<City_area> selectProvince() {
		return cityAreaDao.selectProvince();
	}
	@Override
	public List<City_area> selectCity(Integer parentId) {
		return cityAreaDao.selectCity(parentId);
	}
	@Override
	public List<City_area> selectArea(Integer parentId) {
		return cityAreaDao.selectArea(parentId);
	}
}
