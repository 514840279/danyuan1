package com.danyuan.aotucode.dao;

import java.sql.SQLException;
import java.util.List;

import com.danyuan.aotucode.po.MySQLColumns;
import com.danyuan.aotucode.po.MySQLTables;

/**
 *  文件名 ： MySqlDao.java  
 *  包    名 ： com.danyuan.aotucode.dao  
 *  描    述 ： 获取MySQL表信息
 *  机能名称：自动生成java代码
 *  技能ID ：
 *  作    者 ： Tenghui.Wang  
 *  时    间 ： 2015年5月3日 下午3:51:24  
 *  版    本 ： V1.0
 */
public interface MySQLDao {
	/**
	 *  方法名： selectDabase  
	 *  功    能： 查询数据库
	 *  参    数： @return 
	 *  返    回： List<String>  
	 *  作    者 ： Tenghui.Wang  
	 *  @throws
	 */
	List<String> selectDabase() throws SQLException;

	/**
	 *  方法名： selectColumns  
	 *  功    能： 查询表列名
	 *  参    数： @return 
	 *  返    回： List<MySQLColumns>  
	 *  作    者 ： Tenghui.Wang  
	 *  @throws
	 */
	List<MySQLColumns> selectColumns(String tableSchema, String tableName) throws SQLException;

	/**
	 * 
	 *  方法名： selectColumnsByColumnsName  
	 *  功    能： 通过列名查询
	 *  参    数： @param columnsName
	 *  参    数： @return
	 *  参    数： @throws SQLException 
	 *  返    回： MySQLColumns  
	 *  作    者 ： Tenghui.Wang  
	 *  @throws
	 */
	MySQLColumns selectColumnsByColumnsName(String columnsName) throws SQLException;

	/**
	 *  方法名： selectTables  
	 *  功    能： 查询表名
	 *  参    数： @return 
	 *  返    回： List<MySQLTables>  
	 *  作    者 ： Tenghui.Wang  
	 *  @throws
	 */
	List<MySQLTables> selectTables(String tableSchema) throws SQLException;

}
