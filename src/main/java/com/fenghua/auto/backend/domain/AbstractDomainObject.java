package com.fenghua.auto.backend.domain;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.validation.FieldError;

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
	
	
	List<LabelError> errors;

	public List<LabelError> getErrors() {
		return errors;
	}

	public void addErrors(List<FieldError> errors) {
		this.errors = LabelError.convert2LableErrors(errors);
	}
	
	public boolean hasError(){
		
		return CollectionUtils.isEmpty( this.errors ) ? false : true;
	
	}
	
}
