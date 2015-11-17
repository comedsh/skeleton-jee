package com.fenghua.auto.backend.dao.user;

import java.util.List;

import org.springframework.stereotype.Repository;
import com.fenghua.auto.backend.dao.BaseDao;
import com.fenghua.auto.backend.domain.user.City_area;;
/**
 * CityArea dao
 * @author chengbin
 * @createtime 2015.11.2
 *
 */
@Repository
public interface CityAreaDao extends BaseDao<City_area> {
	/**
	 * 获取省份
	 * @param Fixed
	 * @return
	 */
	public List<City_area> selectProvince(); 
	/**
	 * 通过父节点id获取市级
	 * @param Fixed
	 * @return
	 */
	public List<City_area> selectCity(Integer parentId); 
	/**
	 * 通过父节点id获取县级
	 * @param Fixed
	 * @return
	 */
	public List<City_area> selectArea(Integer parentId); 
}
