package com.fenghua.auto.backend.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fenghua.auto.backend.dao.ConfigDao;
import com.fenghua.auto.backend.domain.user.Config;
import com.fenghua.auto.backend.service.ConfigService;
/**
 * config配置表信息
 * @author heting
 *
 */
@Service
public class ConfigServiceImpl implements ConfigService{
	@Autowired
	private ConfigDao configDao;
	@Override
	public Config selectByConfigName(String configName) {
		return configDao.selectByConfigName(configName);
	}

}
