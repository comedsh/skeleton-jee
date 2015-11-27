package com.fenghua.auto.backend.domain.validation;

import java.util.regex.Matcher;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author shang yang
 *
 * @version 
 *
 * @createTime：2015年11月26日 下午2:35:48 
 *
 */

public class PatternValidator implements ConstraintValidator<Pattern, CharSequence> {

	private java.util.regex.Pattern pattern;
	
	String messagecode;
	
	/**
	 * Get the parameters
	 */
	public void initialize(Pattern parameters) {
		
		pattern = java.util.regex.Pattern.compile( parameters.regexp() );
		
		messagecode = parameters.code();
	}
	
	public boolean isValid(CharSequence value, ConstraintValidatorContext constraintValidatorContext) {
		if ( value == null ) {
			return true;
		}
		Matcher m = pattern.matcher( value );
		return m.matches();
	}
}