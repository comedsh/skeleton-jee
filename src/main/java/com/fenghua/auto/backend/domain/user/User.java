package com.fenghua.auto.backend.domain.user;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fenghua.auto.backend.domain.DomainObject;
/**
 * 用户实体类
 * @author chengbin
 * @createTime 2015.11.5
 */
public class User implements DomainObject {
	
	private static final long serialVersionUID = 1L;

	private Long id;
	@Size(min=6, max=20)
	@NotNull
	private String name;

	private String password;

	private String email;

	private String mobilephone;

	private String qqNumber;

	private String wechat;

	private Long role;

	private Long level;

	private Long company;

	private Short failedLoginTimes;

	private Boolean available;

	private Date createdTs;

	private String createdBy;

	private Date lastModifiedTs;

	private String lastModifiedBy;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password == null ? null : password.trim();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email == null ? null : email.trim();
	}

	public String getMobilephone() {
		return mobilephone;
	}

	public void setMobilephone(String mobilephone) {
		this.mobilephone = mobilephone == null ? null : mobilephone.trim();
	}

	public String getQqNumber() {
		return qqNumber;
	}

	public void setQqNumber(String qqNumber) {
		this.qqNumber = qqNumber == null ? null : qqNumber.trim();
	}

	public String getWechat() {
		return wechat;
	}

	public void setWechat(String wechat) {
		this.wechat = wechat == null ? null : wechat.trim();
	}

	public Long getRole() {
		return role;
	}

	public void setRole(Long role) {
		this.role = role;
	}

	public Long getLevel() {
		return level;
	}

	public void setLevel(Long level) {
		this.level = level;
	}

	public Long getCompany() {
		return company;
	}

	public void setCompany(Long company) {
		this.company = company;
	}

	public Short getFailedLoginTimes() {
		return failedLoginTimes;
	}

	public void setFailedLoginTimes(Short failedLoginTimes) {
		this.failedLoginTimes = failedLoginTimes;
	}

	public Boolean getAvailable() {
		return available;
	}

	public void setAvailable(Boolean available) {
		this.available = available;
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
		this.createdBy = createdBy == null ? null : createdBy.trim();
	}

	public Date getLastModifiedTs() {
		return lastModifiedTs;
	}

	public void setLastModifiedTs(Date lastModifiedTs) {
		this.lastModifiedTs = lastModifiedTs;
	}

	public String getLastModifiedBy() {
		return lastModifiedBy;
	}

	public void setLastModifiedBy(String lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy == null ? null : lastModifiedBy.trim();
	}
}