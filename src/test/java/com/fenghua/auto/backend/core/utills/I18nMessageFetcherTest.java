package com.fenghua.auto.backend.core.utills;

import java.util.Locale;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;

import com.fenghua.auto.backend.core.utills.I18nMessageFetcher;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"/spring-context.xml", "/spring-mybatis.xml","/spring-security.xml"})
public class I18nMessageFetcherTest {

	
	@Test
	public void test() {
		Locale zh_cn = new Locale("zh", "CN");
		String zhMsg =  I18nMessageFetcher.getMessage("index.banner", null, zh_cn);
		Assert.assertEquals("首页左侧菜单，图片轮番", zhMsg);

		Locale en_us = new Locale("en", "US");
		String enMsg =  I18nMessageFetcher.getMessage("index.banner", null, en_us);
		Assert.assertEquals("The home page menu on the left, the picture turns", enMsg);

		Locale ru = new Locale("ru", "RU");
		String ruMsg =  I18nMessageFetcher.getMessage("index.banner", null, ru);
		Assert.assertEquals("Домашняя страница  меню слева  ,  фотографии  по очереди", ruMsg);
	}
	
	@Test
	public void testByRequest(){	
		MockHttpServletRequest cn_request = new MockHttpServletRequest();
		Locale zh_cn = new Locale("zh", "CN");
		cn_request.setAttribute(CookieLocaleResolver.LOCALE_REQUEST_ATTRIBUTE_NAME, zh_cn);
		String zhMsg =  I18nMessageFetcher.getMessage("index.banner", null, cn_request);
		Assert.assertEquals("首页左侧菜单，图片轮番", zhMsg);

		MockHttpServletRequest en_request = new MockHttpServletRequest();
		Locale en_us = new Locale("en", "US");
		en_request.setAttribute(CookieLocaleResolver.LOCALE_REQUEST_ATTRIBUTE_NAME, en_us);
		String enMsg =  I18nMessageFetcher.getMessage("index.banner", null, en_request);
		Assert.assertEquals("The home page menu on the left, the picture turns", enMsg);

		MockHttpServletRequest ru_request = new MockHttpServletRequest();
		Locale ru = new Locale("ru", "RU");		
		ru_request.setAttribute(CookieLocaleResolver.LOCALE_REQUEST_ATTRIBUTE_NAME, ru);
		String ruMsg =  I18nMessageFetcher.getMessage("index.banner", null, ru_request);
		Assert.assertEquals("Домашняя страница  меню слева  ,  фотографии  по очереди", ruMsg);
	}

}
