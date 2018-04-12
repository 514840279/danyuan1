package com.danyuan.aotucode.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.danyuan.aotucode.dao.MySQLDao;
import com.danyuan.aotucode.po.MySQLColumns;
import com.danyuan.aotucode.po.MySQLTables;
import com.danyuan.aotucode.utils.DBUtils;

/**    
 *  文件名 ： MySQLDaoImpl.java  
 *  包    名 ： com.danyuan.aotucode.dao.impl  
 *  描    述 ： 获取MySQL表信息实现
 *  机能名称：自动生成java代码
 *  技能ID ：
 *  作    者 ： Tenghui.Wang  
 *  时    间 ： 2015年5月3日 下午4:52:01  
 *  版    本 ： V1.0    
 */
@Repository("mySQLDao")
public class MySQLDaoImpl implements MySQLDao {

	/** 
	*  方法名 ： selectDabase
	*  功    能 ： 查询数据库
	*  参    数 ： @return  
	*  参    考 ： @see com.danyuan.aotucode.dao.MySqlDao#selectDabase()  
	*  作    者 ： Tenghui.Wang  
	 * @throws SQLException 
	*/
	@Override
	public List<String> selectDabase() throws SQLException {
		// sql文
		StringBuilder sql = new StringBuilder()
				.append(" SHOW DATABASES");
		Connection conn = null; // 链接对象
		PreparedStatement pstm = null; // 语句对象
		ResultSet rs = null; // 结果集对象
		// 数据返回对象
		List<String> alldatabases = new ArrayList<String>();
		try {
			// 1)获得数据库连接
			conn = DBUtils.getConnection();
			pstm = conn.prepareStatement(sql.toString());
			// ?执行sql
			rs = pstm.executeQuery();
			// 变量i
			// 解析结果集 rs
			while (rs.next()) {
				// 先将每一条记录添加到Bean对象中

				// 在将bean对象添加到List列表中
				alldatabases.add(rs.getString(1));
			}
			return alldatabases;
		} finally {
			DBUtils.close(rs);
			DBUtils.close(pstm);
			DBUtils.close(conn);
		}
	}

	/** 
	*  方法名 ： selectColumns
	*  功    能 ： 查询表列名
	*  参    数 ： @return  
	*  参    考 ： @see com.danyuan.aotucode.dao.MySqlDao#selectColumns()  
	*  作    者 ： Tenghui.Wang  
	*/
	@Override
	public List<MySQLColumns> selectColumns(String tableSchema, String tableName) throws SQLException {
		// sql文
		StringBuilder sql = new StringBuilder()
				.append(" SELECT * FROM COLUMNS WHERE TABLE_SCHEMA = ?  AND TABLE_NAME = ? ");
		Connection conn = null; // 链接对象
		PreparedStatement pstm = null; // 语句对象
		ResultSet rs = null; // 结果集对象
		// 数据返回对象
		List<MySQLColumns> allColumns = new ArrayList<MySQLColumns>();
		try {
			// 1)获得数据库连接
			conn = DBUtils.getConnection();
			pstm = conn.prepareStatement(sql.toString());
			// ?
			pstm.setString(1, tableSchema);
			pstm.setString(2, tableName);
			// 执行sql
			rs = pstm.executeQuery();
			// 解析结果集 rs
			while (rs.next()) {
				// 先将每一条记录添加到Bean对象中
				MySQLColumns columns = new MySQLColumns();
				columns.setTableCatalog(rs.getString("TABLE_CATALOG"));
				columns.setTableSchema(rs.getString("TABLE_SCHEMA"));
				columns.setTableName(rs.getString("TABLE_NAME"));
				columns.setColumnName(rs.getString("COLUMN_NAME"));
				columns.setOrdinalPosition(rs.getBigDecimal("ORDINAL_POSITION"));
				columns.setColumnDefault(rs.getString("COLUMN_DEFAULT"));
				columns.setIsNullable(rs.getString("IS_NULLABLE"));
				columns.setDataType(rs.getString("DATA_TYPE"));
				columns.setCharacterMaximumLength(rs.getBigDecimal("CHARACTER_MAXIMUM_LENGTH"));
				columns.setCharacterOctetLength(rs.getBigDecimal("CHARACTER_OCTET_LENGTH"));
				columns.setNumericPrecision(rs.getBigDecimal("NUMERIC_PRECISION"));
				columns.setNumericScale(rs.getBigDecimal("NUMERIC_SCALE"));
				columns.setCharacterSetName(rs.getString("CHARACTER_SET_NAME"));
				columns.setCollationName(rs.getString("COLLATION_NAME"));
				columns.setColumnType(rs.getString("COLUMN_TYPE"));
				columns.setColumnKey(rs.getString("COLUMN_KEY"));
				columns.setExtra(rs.getString("EXTRA"));
				columns.setPrivileges(rs.getString("PRIVILEGES"));
				columns.setColumnComment(rs.getString("COLUMN_COMMENT"));
				// 在将bean对象添加到List列表中
				allColumns.add(columns);
			}
			return allColumns;
		} finally {
			DBUtils.close(rs);
			DBUtils.close(pstm);
			DBUtils.close(conn);
		}
	}

	/** 
	*  方法名 ： selectTables
	*  功    能 ：  查询表名
	*  参    数 ： @return  
	*  参    考 ： @see com.danyuan.aotucode.dao.MySqlDao#selectTables()  
	*  作    者 ： Tenghui.Wang  
	*/
	@Override
	public List<MySQLTables> selectTables(String tableSchema) throws SQLException {
		// sql文
		StringBuilder sql = new StringBuilder()
				.append(" SELECT * FROM TABLES WHERE TABLE_SCHEMA = ? ");
		Connection conn = null; // 链接对象
		PreparedStatement pstm = null; // 语句对象
		ResultSet rs = null; // 结果集对象
		// 数据返回对象
		List<MySQLTables> allTables = new ArrayList<MySQLTables>();
		try {
			// 1)获得数据库连接
			conn = DBUtils.getConnection();
			pstm = conn.prepareStatement(sql.toString());
			// ?
			pstm.setString(1, tableSchema);
			// 执行sql
			rs = pstm.executeQuery();
			// 解析结果集 rs
			while (rs.next()) {
				// 先将每一条记录添加到Bean对象中
				MySQLTables tables = new MySQLTables();
				tables.setTableCatalog(rs.getString("TABLE_CATALOG"));
				tables.setTableSchema(rs.getString("TABLE_SCHEMA"));
				tables.setTableName(rs.getString("TABLE_NAME"));
				tables.setTableType(rs.getString("TABLE_TYPE"));
				tables.setEngine(rs.getString("ENGINE"));
				tables.setVersion(rs.getString("VERSION"));
				tables.setRowFormat(rs.getString("ROW_FORMAT"));
				tables.setTableRows(rs.getString("TABLE_ROWS"));
				tables.setAvgRowLength(rs.getString("AVG_ROW_LENGTH"));
				tables.setDataLength(rs.getString("DATA_LENGTH"));
				tables.setMaxDataLength(rs.getString("MAX_DATA_LENGTH"));
				tables.setIndexLength(rs.getString("INDEX_LENGTH"));
				tables.setDataFree(rs.getString("DATA_FREE"));
				tables.setAutoIncrement(rs.getString("AUTO_INCREMENT"));
				tables.setCreateTime(rs.getString("CREATE_TIME"));
				tables.setUpdateTime(rs.getString("UPDATE_TIME"));
				tables.setCheckTime(rs.getString("CHECK_TIME"));
				tables.setTableCollation(rs.getString("TABLE_COLLATION"));
				tables.setChecksum(rs.getString("CHECKSUM"));
				tables.setCreateOptions(rs.getString("CREATE_OPTIONS"));
				tables.setTableComment(rs.getString("TABLE_COMMENT"));
				// 在将bean对象添加到List列表中
				allTables.add(tables);
			}
			return allTables;
		} finally {
			DBUtils.close(rs);
			DBUtils.close(pstm);
			DBUtils.close(conn);
		}
	}

	/** 
	*  方法名 ： selectColumnsByColumnsName
	*  功    能 ： TODO(这里用一句话描述这个方法的作用)  
	*  参    数 ： @param columnsName
	*  参    数 ： @return
	*  参    数 ： @throws SQLException  
	*  参    考 ： @see com.danyuan.aotucode.dao.MySqlDao#selectColumnsByColumnsName(java.lang.String)  
	*  作    者 ： Tenghui.Wang  
	*/
	@Override
	public MySQLColumns selectColumnsByColumnsName(String columnsName) throws SQLException {
		// sql文
		StringBuilder sql = new StringBuilder()
				.append(" USE information_schema;")
				.append(" SELECT * FROM COLUMNS WHERE COLUMN_NAME = ?  ");
		Connection conn = null; // 链接对象
		PreparedStatement pstm = null; // 语句对象
		ResultSet rs = null; // 结果集对象
		// 数据返回对象
		try {
			// 1)获得数据库连接
			conn = DBUtils.getConnection();
			pstm = conn.prepareStatement(sql.toString());
			// ?
			pstm.setString(1, columnsName);
			// 执行sql
			rs = pstm.executeQuery();
			MySQLColumns columns = new MySQLColumns();
			// 解析结果集 rs
			while (rs.next()) {
				// 先将每一条记录添加到Bean对象中
				columns.setTableCatalog(rs.getString("TABLE_CATALOG"));
				columns.setTableSchema(rs.getString("TABLE_SCHEMA"));
				columns.setTableName(rs.getString("TABLE_NAME"));
				columns.setColumnName(rs.getString("COLUMN_NAME"));
				columns.setOrdinalPosition(rs.getBigDecimal("ORDINAL_POSITION"));
				columns.setColumnDefault(rs.getString("COLUMN_DEFAULT"));
				columns.setIsNullable(rs.getString("IS_NULLABLE"));
				columns.setDataType(rs.getString("DATA_TYPE"));
				columns.setCharacterMaximumLength(rs.getBigDecimal("CHARACTER_MAXIMUM_LENGTH"));
				columns.setCharacterOctetLength(rs.getBigDecimal("CHARACTER_OCTET_LENGTH"));
				columns.setNumericPrecision(rs.getBigDecimal("NUMERIC_PRECISION"));
				columns.setNumericScale(rs.getBigDecimal("NUMERIC_SCALE"));
				columns.setCharacterSetName(rs.getString("CHARACTER_SET_NAME"));
				columns.setCollationName(rs.getString("COLLATION_NAME"));
				columns.setColumnType(rs.getString("COLUMN_TYPE"));
				columns.setColumnKey(rs.getString("COLUMN_KEY"));
				columns.setExtra(rs.getString("EXTRA"));
				columns.setPrivileges(rs.getString("PRIVILEGES"));
				columns.setColumnComment(rs.getString("COLUMN_COMMENT"));
				// 在将bean对象添加到List列表中
			}
			return columns;
		} finally {
			DBUtils.close(rs);
			DBUtils.close(pstm);
			DBUtils.close(conn);
		}
	}

}
