package com.demo.utils;

import android.annotation.SuppressLint;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 时间获取、转换工具
 * 
 * @author 严顺宽
 */
@SuppressLint("SimpleDateFormat")
public class TimeUtil {
	public static String getCurrentTime() {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
		return df.format(new Date());// new Date()为获取当前系统时间
	}
}
