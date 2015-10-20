/**
 * 
 */
package com.fenghua.auto.webapp.view;

import java.util.Locale;

import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

/**
 * @author nn
 *
 */
public class FHTilesViewResolver extends TilesViewResolver {

	/**
	 * 
	 */
	public FHTilesViewResolver() {
	}

//	@Override
//	protected View loadView(String viewName, Locale locale) throws Exception {
//		String localeViewName = viewName;
//		if(locale != null) {
//			localeViewName = localeViewName +"_"+ locale.toString();
//		}
//		
//		View view = super.loadView(localeViewName, locale);
//		if(view == null) {
//			view = super.loadView(viewName, locale);
//		}
//		
//		return view;
//	}

	@Override
	public View resolveViewName(String viewName, Locale locale) throws Exception {
		String localeViewName = viewName;
		if(locale != null) {
			localeViewName = localeViewName +"_"+ locale.toString();
		}
		
		View view = super.resolveViewName(localeViewName, locale);
		if(view == null) {
			view = super.resolveViewName(viewName, locale);
		}
		
		return view;
	}
}
