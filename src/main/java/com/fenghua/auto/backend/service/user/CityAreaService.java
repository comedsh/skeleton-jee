package com.fenghua.auto.backend.service.user;

import java.util.List;

import com.fenghua.auto.backend.domain.user.City_area;

/**
 * 企业service
 * 
 * @author chengbin
 * @createTime 2015.11.2
 *
 */
public interface CityAreaService {
	/**
	 * 获取省份
	 * @return
	 */
	public List<City_area> selectProvince();
	/**
	 * 获取市级城市
	 * @return
	 */
	public List<City_area> selectCity(Integer parentId);
	/**
	 * 获取县级城市
	 * @return
	 */
	public List<City_area> selectArea(Integer parentId);
}
