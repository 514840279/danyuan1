package com.danyuan.common.util;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.formula.functions.T;

/**    
 *  文件名 ： CheckUtils.java  
 *  包    名 ： com.danyuan.common.util  
 *  描    述 ： 判断数据类型工具类
 *  机能名称：
 *  技能ID ：
 *  作    者 ： Tenghui.Wang  
 *  时    间 ： 2015年5月5日 下午9:19:19  
 *  版    本 ： V1.0    
 */
public class CheckEmptyUtils {
	// true
	private final static boolean TRUE = true;
	// false
	private final static boolean FALSE = false;

	/**
	 * 
	 *  方法名： isEmpty  
	 *  功    能：  判断字符串为空
	 *  参    数： @param str
	 *  参    数： @return 
	 *  返    回： boolean  
	 *  作    者 ： Tenghui.Wang  
	 *  @throws
	 */
	public static boolean isEmpty(String str) {
		if (StringUtils.isBlank(str) || str == null || "".equals(str.trim()) || str.length() == 0) {
			return TRUE;
		}
		return FALSE;
	}

	/**
	 * 
	 *  方法名： isEmpty  
	 *  功    能： 判断字符为空
	 *  参    数： @param c
	 *  参    数： @return 
	 *  返    回： boolean  
	 *  作    者 ： Tenghui.Wang  
	 *  @throws
	 */
	public static boolean isEmpty(char c) {
		return CheckEmptyUtils.isEmpty(String.valueOf(c));
	}
	
	/**
	 * 
	 *  方法名： isEmpty  
	 *  功    能： 判断数组为空 
	 *  参    数： @param str
	 *  参    数： @return 
	 *  返    回： boolean  
	 *  作    者 ： Tenghui.Wang  
	 *  @throws
	 */
	public static boolean isEmpty(String[] str) {
		if (str == null || str.length == 0) {
			return TRUE;
		}
		return FALSE;
	}

	/**
	 * 
	 *  方法名： isEmpty  
	 *  功    能： 判断二维数组为空
	 *  参    数： @param str
	 *  参    数： @return 
	 *  返    回： boolean  
	 *  作    者 ： Tenghui.Wang  
	 *  @throws
	 */
	public static boolean isEmpty(String[][] str) {
		if (str == null || str[0].length == 0) {
			return TRUE;
		}
		return FALSE;
	}

	/**
	 * 
	 *  方法名： isEmpty  
	 *  功    能： 判断集合为空
	 *  参    数： @param list
	 *  参    数： @return 
	 *  返    回： boolean  
	 *  作    者 ： Tenghui.Wang  
	 *  @throws
	 */
	public static boolean isEmpty(List<T> list) {
		if (list == null || list.size() == 0) {
			return TRUE;
		}
		return FALSE;
	}

	/**
	 * 
	 *  方法名： isEmpty  
	 *  功    能： 判断map为空
	 *  参    数： @param map
	 *  参    数： @return 
	 *  返    回： boolean  
	 *  作    者 ： Tenghui.Wang  
	 *  @throws
	 */
	public static <K, V> boolean isEmpty(Map<K, V> map) {
		if (map == null || map.size() == 0) {
			return TRUE;
		}
		return FALSE;
	}

	/**
	 * 
	 *  方法名： isEmpty  
	 *  功    能： 判断对象为空
	 *  参    数： @param obj
	 *  参    数： @return 
	 *  返    回： boolean  
	 *  作    者 ： Tenghui.Wang  
	 *  @throws
	 */
	public static boolean isEmpty(Object obj) {
		if (obj == null) {
			return TRUE;
		}
		return FALSE;
	}


	/**
	 * 
	 *  方法名： main  
	 *  功    能： 测试主方法
	 *  参    数： @param args 
	 *  返    回： void  
	 *  作    者 ： Tenghui.Wang  
	 *  @throws
	 */
	// public static void main(String[] args) {
	// char c = '\u0000';
	// System.out.println(CheckEmptyUtils.isEmpty(c));
	// System.out.println(CheckEmptyUtils.isEmpty(""));
	// System.out.println(CheckEmptyUtils.isEmpty(" "));
	// System.out.println(CheckEmptyUtils.isEmpty("　"));
	// System.out.println(CheckEmptyUtils.isEmpty(" a "));
	// String[] str = {};
	// System.out.println(CheckEmptyUtils.isEmpty(str));
	// String[][] str2 = { {} };
	// System.out.println(CheckEmptyUtils.isEmpty(str2));
	// System.out.println(CheckEmptyUtils.isEmpty(new ArrayList()));
	// System.out.println(CheckEmptyUtils.isEmpty(new HashMap()));
	// Object obj = null;
	// System.out.println(CheckEmptyUtils.isEmpty(obj));
	//
	// }
}
