package com.fenghua.auto.backend.domain;

import org.apache.commons.lang.ArrayUtils;

import com.fenghua.auto.backend.domain.mto.LabelError;
import com.fenghua.auto.backend.domain.mto.LabelMessage;

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
	
	LabelMessage[] messages;
	
	public LabelError[] getErrors() {
		return errors;
	}

	public void addErrors(LabelError... errors) {
		this.errors = errors;
	}
	
	public boolean hasError(){
		
		return ArrayUtils.isEmpty( this.errors ) ? false : true;
	
	}

	public void addMessages(LabelMessage... messages){
		this.messages = messages;
	}
	
	public boolean hasMessage(){
		
		return ArrayUtils.isEmpty( this.messages ) ? false : true;		
	
	}
	
	public LabelMessage[] getMessages(){
		
		return messages;
		
	}
	
}
