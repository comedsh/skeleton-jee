package com.fenghua.auto.backend.dao.user.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import com.fenghua.auto.backend.dao.DaoException;
import com.fenghua.auto.backend.dao.constants.SqlId;
import com.fenghua.auto.backend.dao.impl.BaseDaoImpl;
import com.fenghua.auto.backend.dao.user.CityAreaDao;
import com.fenghua.auto.backend.domain.user.City_area;
/**
 * 获取省份dao实现
 * @author chengbin
 *
 */
@Repository
public class CityAreaDaoImpl extends BaseDaoImpl<City_area> implements CityAreaDao {
	

	@Override
	public List<City_area> selectProvince() {
		List<City_area> cityArea = new ArrayList<City_area>();
		try {
			cityArea = sqlSessionTemplate.selectList(getSqlName(SqlId.SQL_SELECT_BY_PROVINCE),Short.parseShort("1"));
		} catch (Exception e) {
			throw new DaoException(String.format("根据Fixed查询对象出错！语句：%s", getSqlName(SqlId.SQL_SELECT_BY_PROVINCE)), e);
		}
		return cityArea;
	}
	@Override
	public List<City_area> selectCity(Integer parentId) {
		Assert.notNull(parentId);
		List<City_area> cityArea = new ArrayList<City_area>();
		City_area city_area = new City_area();
		city_area.setParentId(parentId);
		city_area.setLevel(Short.parseShort("2"));
		try {
			cityArea = sqlSessionTemplate.selectList(getSqlName(SqlId.SQL_SELECT_BY_CITY),city_area);
		} catch (Exception e) {
			throw new DaoException(String.format("根据Fixed查询对象出错！语句：%s", getSqlName(SqlId.SQL_SELECT_BY_CITY)), e);
		}
		return cityArea;
	}
	@Override
	public List<City_area> selectArea(Integer parentId) {
		Assert.notNull(parentId);
		List<City_area> cityArea = new ArrayList<City_area>();
		City_area city_area = new City_area();
		city_area.setParentId(parentId);
		city_area.setLevel(Short.parseShort("3"));
		try {
			cityArea = sqlSessionTemplate.selectList(getSqlName(SqlId.SQL_SELECT_BY_AREA),city_area);
		} catch (Exception e) {
			throw new DaoException(String.format("根据Fixed查询对象出错！语句：%s", getSqlName(SqlId.SQL_SELECT_BY_AREA)), e);
		}
		return cityArea;
	}
}
