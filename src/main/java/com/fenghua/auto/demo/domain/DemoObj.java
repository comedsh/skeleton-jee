package com.fenghua.auto.demo.domain;

import java.io.Serializable;

/** 
  *<des>
  *  用于测试DemoController 传入对象参数
  *</des>
  * @author  lijie
  * @date 2015年10月20日
  * @version 
  */
public class DemoObj implements Serializable{

	private String id;
	private String name;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
