package com.fenghua.auto.backend.domain.education;

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

public class Spittle {

	long id;
	
	String username;
	
	String text;

	public long getId() {
		return id;
	}

	public void setId(long id) {
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
	
	
	
	
}
