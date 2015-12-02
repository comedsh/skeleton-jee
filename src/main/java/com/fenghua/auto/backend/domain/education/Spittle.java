package com.fenghua.auto.backend.domain.education;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.fenghua.auto.backend.domain.AbstractDomainObject;
import com.fenghua.auto.backend.domain.mto.MessageTransferObject;

/**
 * Spittle 唾沫，同时也翻译为碎语
 * 
 * @author shang yang
 *
 * @version 
 *
 * @createTime：2015年8月31日 上午9:00:57 
 *
 */

public class Spittle extends AbstractDomainObject implements MessageTransferObject{

	/**
	 * to enable spring MVC Form validation, First, needs javax.validation jar; Second, needs <mvc:annotation-driven /> enabled. 
	 */
	
	// allows null, if null, it will be calculated by the system automatically
	// remember, if you want to use @valid, to use its Object
	Long id;
	
	@NotNull	
	@Size(min=4, max=20)
	String username;
	
	@NotNull	
	@Size(min=8, max=30)
	String text;
	
	// allows empty, if empty, it will be calculated by the system automatically
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	Date time;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String owner) {
		this.username = owner;
	}

	public String getText() {
		return text;
	}

	public void setText(String words) {
		this.text = words;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}
	
	
}
