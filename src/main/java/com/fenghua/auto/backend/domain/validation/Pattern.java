package com.fenghua.auto.backend.domain.validation;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;

import org.hibernate.validator.internal.constraintvalidators.PatternValidator;

/**
 * @author shang yang
 *
 * @version 
 *
 * @createTime：2015年11月26日 下午2:32:36 
 *
 */

@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = PatternValidator.class )
public @interface Pattern {
	
	String regexp();
	
	// message code maps from message properties file.
	String code();
	
	// error message
	String message() default "{javax.validation.constraints.NotNull.message}";
	
}
