package com.fenghua.auto.backend.dao;

import org.springframework.stereotype.Repository;

import com.fenghua.auto.backend.domain.user.Config;
/**
 * config配置文件信息
 * @author heting
 *
 */
@Repository
public interface ConfigDao extends BaseDao<Config>{
	public Config selectByConfigName(String configName);
}
