package com.fenghua.auto.backend.domain;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.validation.FieldError;

/**
 * 
 * translate the 
 * 
 * @author shang yang
 *
 * @version 
 *
 * @createTime：2015年11月23日 下午2:46:14 
 *
 */

public class LabelError {
		
	public String field;
	
	public String error;

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}
	
	public static List<LabelError> convert2LableErrors(List<FieldError> errs){
		
		List<LabelError> es = new ArrayList<LabelError>(5);
		
		for(FieldError err : errs ){
			es.add(convert2LableError(err) );
		}
		
		return CollectionUtils.isEmpty(es) ? null : es;
		
	}
	
	public static LabelError convert2LableError(FieldError err){
		
		LabelError e = new LabelError();
		
		e.setField( err.getField() );
		e.setError( err.getDefaultMessage() );
		
		return e;
		
	}
	
}
