package com.fenghua.auto.backend.domain.user;

import java.sql.Date;

import com.fenghua.auto.backend.domain.DomainObject;

public class Config  implements DomainObject{

	/**
	 * 
	 */
	private static final long serialVersionUID = 9101064059784127685L;
	private String configName;
	private String ConfigValue;
	private Date createdTs;
	private String createdBy;
	private Date   lastModifiedTs;
	private String lastModifiedBy;
	public String getConfigName() {
		return configName;
	}
	public void setConfigName(String configName) {
		this.configName = configName;
	}
	public String getConfigValue() {
		return ConfigValue;
	}
	public void setConfigValue(String configValue) {
		ConfigValue = configValue;
	}
	public Date getCreatedTs() {
		return createdTs;
	}
	public void setCreatedTs(Date createdTs) {
		this.createdTs = createdTs;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getLastModifiedBy() {
		return lastModifiedBy;
	}
	public void setLastModifiedBy(String lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}
	public Date getLastModifiedTs() {
		return lastModifiedTs;
	}
	public void setLastModifiedTs(Date lastModifiedTs) {
		this.lastModifiedTs = lastModifiedTs;
	}

}
