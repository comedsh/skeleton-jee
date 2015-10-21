/**
 * 
 */
package com.fenghua.auto.webapp.view;

import java.util.Locale;

import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

/**
 * @author ��ֱԪ
 * 
 * ��չ��ͼ��������ͨ���ı�viewName��ʵ�ָ��ݲ�ͬ������ʾ��ͬ��ģ��
 *
 */
public class FHTilesViewResolver extends TilesViewResolver {

	/**
	 * 
	 */
	public FHTilesViewResolver() {
	}

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
