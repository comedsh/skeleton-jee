package com.fenghua.auto.backend.core.utills;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintViolation;
import javax.validation.metadata.ConstraintDescriptor;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.validation.FieldError;

import com.fenghua.auto.backend.domain.LabelError;
import com.fenghua.auto.backend.domain.validation.DomainValidationException;

/**
 * 
 * Utils translates the various errors into Label Errors 
 * 
 * @author shang yang
 *
 * @version 
 *
 * @createTime：2015年11月26日 上午11:41:26 
 *
 */

public class LabelErrorTranslator {
	
	/**
	 * 
	 * Translates the @link FieldError encapsulated from Spring Validation framework. 
	 * 
	 * @author shang yang
	 *
	 * @version 
	 * 
	 * @createTime: 2015年11月26日 上午11:43:56
	 *
	 */
	public static LabelError translate2LabelError(FieldError error){
		
		LabelError labelError = null;
		
		String message = null;
		
		// translate the errors by error code one by one, filter those null messages.
		for(String code : error.getCodes() ){
			
			// first argument was default to DefaultMessageSourceResolvable; we need the actual defined arguments
			// Object[] arguments = error.getArguments().length == 1 ? null : ArrayUtils.remove(error.getArguments(), 0);
			
			message = MessageHelper.getMessage(code, error.getArguments() );	
			
			// if found, break. because Field Error with a lot of guessing codes 
			if( !StringUtils.isEmpty(message) ) break;

		}

		if( message == null ){ 
			throw new DomainValidationException( MessageHelper.getMessage(MessageHelper.MESSAGE_SOURCE_NOTFOUND, (Object[]) error.getCodes() ) );
		}		
		
		labelError = new LabelError();
		
		labelError.setField( error.getField() );
		
		labelError.setError( message );
		
		return labelError;
		
	}
	
	public static List<LabelError> translate2LabelError(List<FieldError> errors){
		
		List<LabelError> errs = new ArrayList<LabelError>(5);
		
		for(FieldError error : errors ){
			errs.add( LabelErrorTranslator.translate2LabelError(error) );
		}
		
		return CollectionUtils.isEmpty(errs) ? null : errs;		
		
	}
	
	/**
	 * translates the violation into LabelError
	 * 
	 * @author shang yang
	 *
	 * @version 
	 * 
	 * @createTime: 2015年11月26日 下午7:29:41
	 *
	 */
	public static <T> LabelError translate2LabelError(ConstraintViolation<T> violation){
		
		if( violation == null ) return null;
		
		String classname = violation.getLeafBean().getClass().getSimpleName(); // the object that uses for validation
		
		String field = violation.getPropertyPath().toString();
		
		Object[] object = violation.getExecutableParameters();
		
		ConstraintDescriptor d = violation.getConstraintDescriptor();
		
		Annotation ann = d.getAnnotation();
		
		String validator = ann.annotationType().getSimpleName();
		
		String code = validator +"." + StringUtils.lowerCase( classname ) + "." + StringUtils.lowerCase( field );
		
		String error = MessageHelper.getMessage(code);
		
		LabelError labelError = new LabelError();
		
		labelError.setField(field);
		
		labelError.setError( error );
		
		return labelError;
		
	}
	
}
