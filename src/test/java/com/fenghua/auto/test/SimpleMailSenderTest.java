package com.fenghua.auto.test;

import javax.mail.MessagingException;

import org.junit.Test;

import com.fenghua.auto.backend.core.utills.mail.SimpleMailSender;

public class SimpleMailSenderTest {
	@SuppressWarnings("static-access")
	@Test
	public void test(){
		try {
			SimpleMailSender dd = new SimpleMailSender();
			dd.sendHtmlMail("wwww", "ffffffff", "tttttt");
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
