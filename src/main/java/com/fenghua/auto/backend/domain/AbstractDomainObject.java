package com.fenghua.auto.backend.domain;

import javax.mail.MethodNotSupportedException;

import org.apache.commons.lang.ArrayUtils;

/**
 * 
 * super class provides common fields / attrs
 * 
 * @author shang yang
 *
 * @version 
 *
 * @createTime：2015年11月23日 下午2:17:44 
 *
 */

public class AbstractDomainObject {
	
	LabelError[] errors;

	public LabelError[] getErrors() {
		return errors;
	}

	public void addErrors(LabelError... errors) {
		this.errors = errors;
	}
	
	public boolean hasError(){
		
		return ArrayUtils.isEmpty( this.errors ) ? false : true;
	
	}
	
	/**
	 * @TODO Not supported yet
	 * 
	 * @author shang yang
	 *
	 * @version 
	 * 
	 * @createTime: 2015年11月26日 下午6:52:27
	 *
	 */
	public boolean hasMessage() throws MethodNotSupportedException{
		
		throw new MethodNotSupportedException();
	
	}
	
	/**
	 * @TODO Not supported yet 
	 * 
	 * @author shang yang
	 *
	 * @version 
	 * 
	 * @createTime: 2015年11月26日 下午6:55:12
	 *
	 */
	public String[] getMessages() throws MethodNotSupportedException{
		
		throw new MethodNotSupportedException();
	
	}
	
}
