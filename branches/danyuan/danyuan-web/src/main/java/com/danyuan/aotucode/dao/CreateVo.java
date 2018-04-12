package com.danyuan.aotucode.dao;

import com.danyuan.aotucode.vo.MySQLVo;

/**    
 *  文件名 ： CreateVo.java  
 *  包    名 ： com.danyuan.aotucode.dao  
 *  描    述 ： 创建Vo.class
 *  机能名称：创建Vo.class
 *  技能ID ：CreateVo
 *  作    者 ： Tenghui.Wang  
 *  时    间 ： 2015年5月10日 下午6:35:35  
 *  版    本 ： V1.0    
 */
public interface CreateVo {
	/**
	 * 
	 *  方法名： createVo  
	 *  功    能： 创建Vo
	 *  参    数： @param vo 
	 *  返    回： void  
	 *  作    者 ： Tenghui.Wang  
	 *  @throws
	 */
	public void createVo(MySQLVo vo);
}
