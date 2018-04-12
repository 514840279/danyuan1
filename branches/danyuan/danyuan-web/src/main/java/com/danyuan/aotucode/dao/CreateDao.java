package com.danyuan.aotucode.dao;

import com.danyuan.aotucode.vo.MySQLVo;

/**    
 *  文件名 ： CreateDao.java  
 *  包    名 ： com.danyuan.aotucode.dao  
 *  描    述 ： 创建Dao.class
 *  机能名称：创建Dao.class
 *  技能ID ：CreateDao
 *  作    者 ： Tenghui.Wang  
 *  时    间 ： 2015年5月10日 下午6:33:26  
 *  版    本 ： V1.0    
 */
public interface CreateDao {
	/**
	 * 
	 *  方法名： createDao  
	 *  功    能： 创建Dao 
	 *  参    数： @param vo 
	 *  返    回： void  
	 *  作    者 ： Tenghui.Wang  
	 *  @throws
	 */
	public void createDao(MySQLVo vo);
}
