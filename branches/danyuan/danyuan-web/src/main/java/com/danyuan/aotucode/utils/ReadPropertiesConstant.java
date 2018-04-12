package com.danyuan.aotucode.utils;

import java.util.Locale;
import java.util.ResourceBundle;

/**    
 *  文件名 ： ReadPropertiesConstant.java  
 *  包    名 ： com.danyuan.aotucode.utils  
 *  描    述 ： 常量类
 *  机能名称：常量
 *  技能ID ：ReadPropertiesConstant
 *  作    者 ： Tenghui.Wang  
 *  时    间 ： 2015年5月10日 下午10:17:30  
 *  版    本 ： V1.0    
 */
public class ReadPropertiesConstant {

	// 取得系统默认的国家/语言环境
	Locale locale = Locale.getDefault();
	// 根据指定国家/语言环境加载资源文件
	ResourceBundle bundle = ResourceBundle.getBundle("fileContent", locale);
	// return
	public static final String STR_RETURN = "return";
	// public
	public static final String STR_PUBLIC = "public";
	// private
	public static final String STR_PRIVATE = "private";
	// static
	public static final String STR_STATIC = "static";
	// void
	public static final String STR_VOID = "void";
	// String
	public static final String STR_STRING = "String";
	// Integer
	public static final String STR_INTEGER = "Integer";
	// Date
	public static final String STR_DATE = "Date";
	// java.sql.Date
	public static final String STR_IMPORTDATE = "java.sql.Date";
	// set
	public static final String STR_SET = "set";
	// get
	public static final String STR_GET = "get";
	// this.
	public static final String STR_THIS = "this.";
	// \r
	public static final String STR_SPACE = "\r";
	// \r\r
	public static final String STR_SPACE2 = "\r\r";
	// \n
	public static final String STR_ENTER = "\n";
	// \n\n
	public static final String STR_ENTER2 = "\n\n";
	// /**
	public static final String STR_REMARKSTRAT = "/**";
	// */
	public static final String STR_REMARKEND = "*/";
	// (//)
	public static final String STR_REMARK1 = "//";
	// package
	public static final String STR_PACKAGE = "package";
	// * 文件名 ：
	public final String STR_FILENAME = bundle.getString("str_fileName");
	// * 包 名 ：
	public final String STR_PACKAGENAME = bundle.getString("str_packageName");
	// * 描 述 ： T ODO(用一句话描述该文件做什么)
	public final String STR_DESCRIPTION = bundle.getString("str_description");
	// * 机能名称：
	public final String STR_ENGINERYNAME = bundle.getString("str_engineryName");
	// * 技能ID ：
	public final String STR_ENGINERYID = bundle.getString("str_engineryId");
	// * 作 者 ：
	public final String STR_AUTHOR = bundle.getString("str_author");
	// * 时 间 ：
	public final String STR_DATETIME = bundle.getString("str_datetime");
	// * 版 本 ： V1.0
	public final String STR_VERSION = bundle.getString("str_version");
	// * 方法名 ：
	public final String str_method = bundle.getString("str_method");
	// * 功 能 ：
	public final String str_function = bundle.getString("str_function");
	// 设置
	public final String str_fit = bundle.getString("str_fit");
	// 的值
	public final String str_fitEnd = bundle.getString("str_fitEnd");
	// 取得
	public final String str_fetch = bundle.getString("str_fetch");
	// 的值
	public final String str_fetchEnd = bundle.getString("str_fetchEnd");

}
