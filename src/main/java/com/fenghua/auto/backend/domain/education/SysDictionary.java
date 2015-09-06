package com.fenghua.auto.backend.domain.education;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.fenghua.auto.backend.domain.DomainObject;

public class SysDictionary implements DomainObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7931423102765190053L;

	/**
	 * @fields id 主键
	 */
	private String dicId;

	/**
	 * @fields dicName 字典名称
	 */
	private String dicName;

	/**
	 * @fields dicValue 字典值  
	 */
	private String dicValue;
	/**
	 * @fields dicGroup 字典分组
	 */
	private String dicGroup;
	/**
	 * @fields dicOrder 字典排序 
	 */
	private Integer dicOrder;

	/**
	 * @fields parent 父节点
	 */
	private String dicParentId;

	public String getDicId() {
		return dicId;
	}

	public void setDicId(String dicId) {
		this.dicId = dicId;
	}

	public String getDicName() {
		return dicName;
	}

	public void setDicName(String dicName) {
		this.dicName = dicName;
	}

	public String getDicValue() {
		return dicValue;
	}

	public void setDicValue(String dicValue) {
		this.dicValue = dicValue;
	}

	public String getDicGroup() {
		return dicGroup;
	}

	public void setDicGroup(String dicGroup) {
		this.dicGroup = dicGroup;
	}

	public Integer getDicOrder() {
		return dicOrder;
	}

	public void setDicOrder(Integer dicOrder) {
		this.dicOrder = dicOrder;
	}

	public String getDicParentId() {
		return dicParentId;
	}

	public void setDicParentId(String dicParentId) {
		this.dicParentId = dicParentId;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
}
