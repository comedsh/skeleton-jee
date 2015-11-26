package com.fenghua.auto.backend.service;

import com.fenghua.auto.backend.domain.user.Config;
/**
 * 获取config配置文件信息
 * @author heting
 *
 */
public interface ConfigService {
	/**
	 * 根据配置名查询配置详细信息
	 * @param configName
	 * @return
	 */
	public Config selectByConfigName(String configName);
}
