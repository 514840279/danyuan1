package com.danyuan.aotucode.service;

import java.sql.SQLException;
import java.util.List;

import com.danyuan.aotucode.po.MySQLDatabase;
import com.danyuan.aotucode.vo.MySQLVo;

/**    
 *  文件名 ： MySQLService.java  
 *  包    名 ： com.danyuan.aotucode.service  
 *  描    述 ： 逻辑处理MySQL
 *  机能名称：逻辑处理MySQL
 *  技能ID ：MySQLService
 *  作    者 ： Tenghui.Wang  
 *  时    间 ： 2015年5月3日 下午7:30:29  
 *  版    本 ： V1.0    
 */
public interface MySQLService {
	/**
	 *  方法名： getColumnsTree  
	 *  功    能： 查询数据库树
	 *  参    数： @return 
	 *  返    回： List<MySQLDatabase>  
	 *  作    者 ： Tenghui.Wang  
	 *  @throws
	 */
	List<MySQLDatabase> getColumnsTree() throws SQLException;

	/**
	 *  方法名： createBeans  
	 *  功    能： 创建Beans
	 *  参    数： @param vo 
	 *  返    回： void  
	 *  作    者 ： Tenghui.Wang  
	 *  @throws
	 */
	void createBeans(MySQLVo vo) throws SQLException;

	/**
	 *  方法名： createDao  
	 *  功    能： 创建Dao
	 *  参    数： @param vo 
	 *  返    回： void  
	 *  作    者 ： Tenghui.Wang  
	 *  @throws
	 */
	void createDao(MySQLVo vo) throws SQLException;

	/**
	 *  方法名： createDaoImpl  
	 *  功    能： 创建DaoImpl
	 *  参    数： @param vo 
	 *  返    回： void  
	 *  作    者 ： Tenghui.Wang  
	 *  @throws
	 */
	void createDaoImpl(MySQLVo vo) throws SQLException;

	/**
	 *  方法名： createService  
	 *  功    能： 创建Service
	 *  参    数： @param vo 
	 *  返    回： void  
	 *  作    者 ： Tenghui.Wang  
	 *  @throws
	 */
	void createService(MySQLVo vo) throws SQLException;

	/**
	 *  方法名： createServiceImpl  
	 *  功    能： 创建ServiceImpl
	 *  参    数： @param vo 
	 *  返    回： void  
	 *  作    者 ： Tenghui.Wang  
	 *  @throws
	 */
	void createServiceImpl(MySQLVo vo) throws SQLException;

	/**
	 *  方法名： createAction  
	 *  功    能： 创建Action
	 *  参    数： @param vo 
	 *  返    回： void  
	 *  作    者 ： Tenghui.Wang  
	 *  @throws
	 */
	void createAction(MySQLVo vo) throws SQLException;

	/**
	 *  方法名： createVo  
	 *  功    能：创建Vo
	 *  参    数： @param vo 
	 *  返    回： void  
	 *  作    者 ： Tenghui.Wang  
	 *  @throws
	 */
	void createVo(MySQLVo vo) throws SQLException;
}
