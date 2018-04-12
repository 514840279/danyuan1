package com.danyuan.aotucode.po;

import java.util.List;

/**    
 *  文件名 ： MySQLDatabase.java  
 *  包    名 ： com.danyuan.aotucode.po  
 *  描    述 ： MySQLDatabase基表
 *  机能名称：MySQLDatabase基表
 *  技能ID ：MySQLDatabase
 *  作    者 ： Tenghui.Wang  
 *  时    间 ： 2015年5月3日 下午7:39:38  
 *  版    本 ： V1.0    
 */
public class MySQLDatabase {
	// 数据库名
	private String database;
	// 表
	private List<MySQLTables> tables;

	/**  
	 *  方法名 ： getDatabase 
	 *  功    能 ： 取得 database 的值  
	 *  @return: String  database
	 */
	public String getDatabase() {
		return database;
	}

	/**  
	 *  方法名 ： setDatabase 
	 *  功    能 ： 设置 database 的值
	 */
	public void setDatabase(String database) {
		this.database = database;
	}

	/**  
	 *  方法名 ： getTables 
	 *  功    能 ： 取得 tables 的值  
	 *  @return: List<MySQLTables>  tables
	 */
	public List<MySQLTables> getTables() {
		return tables;
	}

	/**  
	 *  方法名 ： setTables 
	 *  功    能 ： 设置 tables 的值
	 */
	public void setTables(List<MySQLTables> tables) {
		this.tables = tables;
	}

}
