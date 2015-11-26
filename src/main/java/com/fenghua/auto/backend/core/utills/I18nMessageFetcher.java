package com.fenghua.auto.backend.core.utills;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.support.AbstractMessageSource;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;

@Component
public class I18nMessageFetcher {

	private static AbstractMessageSource messageSource;
	
	private static Locale defaultLocale = new Locale("us", "EN");
	
	private static CookieLocaleResolver cookieLocaleResolver;
	
    @Autowired(required = true)
    public I18nMessageFetcher(@Qualifier("messageSource") AbstractMessageSource messageSource, CookieLocaleResolver cookieLocaleResolver) {
    	I18nMessageFetcher.messageSource = messageSource;
    	I18nMessageFetcher.cookieLocaleResolver = cookieLocaleResolver;
    }
	
	public static String getMessage(String code, Object[] args, HttpServletRequest request){
		Locale loc = cookieLocaleResolver.resolveLocale(request);
		return getMessage(code, args, loc);
	}
	
	public static String getMessage(String code, Object[] args, Locale loc){
		if (loc == null)
			loc = defaultLocale;
		return messageSource.getMessage(code, args, loc);
	}
	
}
