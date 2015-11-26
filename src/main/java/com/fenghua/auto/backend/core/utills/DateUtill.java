package com.fenghua.auto.backend.core.utills;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * 时间格式
 * @author chengbin
 *
 */
public class DateUtill {
	public static Date getNowDate() {
	   Date currentTime = new Date();
	   SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	   String dateString = formatter.format(currentTime);
	   ParsePosition pos = new ParsePosition(8);
	   Date currentTime_2 = formatter.parse(dateString, pos);
	   return currentTime_2;
	}
}
