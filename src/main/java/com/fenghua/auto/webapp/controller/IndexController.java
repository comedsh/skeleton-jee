package com.fenghua.auto.webapp.controller;

import java.util.Date;
import java.util.TimeZone;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	
	@RequestMapping(value = "/")
	public String index(HttpServletRequest request) throws Exception {

		return "web.index_view";
	}

	public static void main(String[] agrs) {
		System.out.println(new Date());
		TimeZone.setDefault(TimeZone.getTimeZone("GMT+8"));
		System.out.println(new Date());
	}
}
