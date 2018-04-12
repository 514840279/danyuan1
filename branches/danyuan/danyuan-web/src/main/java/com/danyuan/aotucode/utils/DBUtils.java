package com.danyuan.aotucode.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 
 *  文件名 ： DBUtils.java  
 *  包    名 ： com.danyuan.aotucode.utils  
 *  描    述 ： TODO(用一句话描述该文件做什么)  
 *  机能名称：
 *  技能ID ：
 *  作    者 ： Tenghui.Wang  
 *  时    间 ： 2015年5月3日 下午5:53:29  
 *  版    本 ： V1.0
 */
public class DBUtils {
	// 将连接字符串声明为常量
	// mySql
	private static final String URL = "jdbc:mysql://192.168.199.232:3306/information_schema";
	private static final String USER = "root";
	private static final String PASSWORD = "root";

	// 1利用静态代码块实现加载驱动
	static
	{
		try {
			// MySql
			Class.forName("org.gjt.mm.mysql.Driver");
			// Class.forName("com.mysql.jdbc.Driver");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		// MySql第二种驱动形式
		// try {
		// DriverManager.registerDriver(new org.gjt.mm.mysql.Driver());
		// // DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		// } catch (SQLException e) {
		// e.printStackTrace();
		// }
	}

	/**
	 *  方法名： getConnection  
	 *  功    能： 静态块获取链接
	 *  参    数： @return 
	 *  返    回： Connection  
	 *  作    者 ： Tenghui.Wang  
	 *  @throws
	 */
	public static Connection getConnection()
	{
		try {
			return DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 *  方法名： close  
	 *  功    能： 关闭连接
	 *  参    数： @param conn 
	 *  返    回： void  
	 *  作    者 ： Tenghui.Wang  
	 *  @throws
	 */
	public static void close(Connection conn)
	{
		try {
			if (conn != null && !conn.isClosed())
			{
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 *  方法名： close  
	 *  功    能： 关闭数据流
	 *  参    数： @param state 
	 *  返    回： void  
	 *  作    者 ： Tenghui.Wang  
	 *  @throws
	 */
	public static void close(Statement state)
	{
		try {
			if (state != null)
			{
				state.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 *  方法名： close  
	 *  功    能： 关闭集
	 *  参    数： @param rs 
	 *  返    回： void  
	 *  作    者 ： Tenghui.Wang  
	 *  @throws
	 */
	public static void close(ResultSet rs)
	{
		try {
			if (rs != null)
			{
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		getConnection();
	}
}
