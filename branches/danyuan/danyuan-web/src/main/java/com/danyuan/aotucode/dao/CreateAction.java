package com.danyuan.aotucode.dao;

import com.danyuan.aotucode.vo.MySQLVo;

/**    
 *  文件名 ： CreateAction.java  
 *  包    名 ： com.danyuan.aotucode.dao  
 *  描    述 ： 创建Action.class
 *  机能名称：创建Action.class
 *  技能ID ：CreateAction
 *  作    者 ： Tenghui.Wang  
 *  时    间 ： 2015年5月10日 下午6:34:21  
 *  版    本 ： V1.0    
 */
public interface CreateAction {
	/**
	 *  方法名： createAction  
	 *  功    能： 创建Action.class
	 *  参    数： @param vo 
	 *  返    回： void  
	 *  作    者 ： Tenghui.Wang  
	 *  @throws
	 */
	public void createAction(MySQLVo vo);
}
