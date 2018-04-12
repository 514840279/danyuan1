package com.danyuan.aotucode.po;

import java.util.List;

/**    
 *  文件名 ： MySQLTables.java  
 *  包    名 ： com.danyuan.aotucode.po  
 *  描    述 ： TODO(用一句话描述该文件做什么)  
 *  机能名称：
 *  技能ID ：
 *  作    者 ： Tenghui.Wang
 *  时    间 ： 2015年5月3日 下午2:57:54  
 *  版    本 ： V1.0    
 */
public class MySQLTables {
	// 表限定符
	private String tableCatalog;
	// 表所有者
	private String tableSchema;
	// 表名
	private String tableName;
	// 表
	private String tableType;
	private String engine;
	private String version;
	private String rowFormat;
	// 表数据行
	private String tableRows;
	private String avgRowLength;
	// 数据的大小
	private String dataLength;
	// 最大数据长度
	private String maxDataLength;
	private String indexLength;
	// 空闲空间
	private String dataFree;
	// 自增长
	private String autoIncrement;
	// 创建时间
	private String createTime;
	// 修改时间
	private String updateTime;
	private String checkTime;
	private String tableCollation;
	private String checksum;
	private String createOptions;
	// 表注释
	private String tableComment;
	// 列
	private List<MySQLColumns> columns;

	/**  
	 *  方法名 ： getTableCatalog 
	 *  功    能 ： 取得 tableCatalog 的值  
	 *  @return: String  tableCatalog
	 */
	public String getTableCatalog() {
		return tableCatalog;
	}

	/**  
	 *  方法名 ： setTableCatalog 
	 *  功    能 ： 设置 tableCatalog 的值
	 */
	public void setTableCatalog(String tableCatalog) {
		this.tableCatalog = tableCatalog;
	}

	/**  
	 *  方法名 ： getTableSchema 
	 *  功    能 ： 取得 tableSchema 的值  
	 *  @return: String  tableSchema
	 */
	public String getTableSchema() {
		return tableSchema;
	}

	/**  
	 *  方法名 ： setTableSchema 
	 *  功    能 ： 设置 tableSchema 的值
	 */
	public void setTableSchema(String tableSchema) {
		this.tableSchema = tableSchema;
	}

	/**  
	 *  方法名 ： getTableName 
	 *  功    能 ： 取得 tableName 的值  
	 *  @return: String  tableName
	 */
	public String getTableName() {
		return tableName;
	}

	/**  
	 *  方法名 ： setTableName 
	 *  功    能 ： 设置 tableName 的值
	 */
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	/**  
	 *  方法名 ： getTableType 
	 *  功    能 ： 取得 tableType 的值  
	 *  @return: String  tableType
	 */
	public String getTableType() {
		return tableType;
	}

	/**  
	 *  方法名 ： setTableType 
	 *  功    能 ： 设置 tableType 的值
	 */
	public void setTableType(String tableType) {
		this.tableType = tableType;
	}

	/**  
	 *  方法名 ： getEngine 
	 *  功    能 ： 取得 engine 的值  
	 *  @return: String  engine
	 */
	public String getEngine() {
		return engine;
	}

	/**  
	 *  方法名 ： setEngine 
	 *  功    能 ： 设置 engine 的值
	 */
	public void setEngine(String engine) {
		this.engine = engine;
	}

	/**  
	 *  方法名 ： getVersion 
	 *  功    能 ： 取得 version 的值  
	 *  @return: String  version
	 */
	public String getVersion() {
		return version;
	}

	/**  
	 *  方法名 ： setVersion 
	 *  功    能 ： 设置 version 的值
	 */
	public void setVersion(String version) {
		this.version = version;
	}

	/**  
	 *  方法名 ： getRowFormat 
	 *  功    能 ： 取得 rowFormat 的值  
	 *  @return: String  rowFormat
	 */
	public String getRowFormat() {
		return rowFormat;
	}

	/**  
	 *  方法名 ： setRowFormat 
	 *  功    能 ： 设置 rowFormat 的值
	 */
	public void setRowFormat(String rowFormat) {
		this.rowFormat = rowFormat;
	}

	/**  
	 *  方法名 ： getTableRows 
	 *  功    能 ： 取得 tableRows 的值  
	 *  @return: String  tableRows
	 */
	public String getTableRows() {
		return tableRows;
	}

	/**  
	 *  方法名 ： setTableRows 
	 *  功    能 ： 设置 tableRows 的值
	 */
	public void setTableRows(String tableRows) {
		this.tableRows = tableRows;
	}

	/**  
	 *  方法名 ： getAvgRowLength 
	 *  功    能 ： 取得 avgRowLength 的值  
	 *  @return: String  avgRowLength
	 */
	public String getAvgRowLength() {
		return avgRowLength;
	}

	/**  
	 *  方法名 ： setAvgRowLength 
	 *  功    能 ： 设置 avgRowLength 的值
	 */
	public void setAvgRowLength(String avgRowLength) {
		this.avgRowLength = avgRowLength;
	}

	/**  
	 *  方法名 ： getDataLength 
	 *  功    能 ： 取得 dataLength 的值  
	 *  @return: String  dataLength
	 */
	public String getDataLength() {
		return dataLength;
	}

	/**  
	 *  方法名 ： setDataLength 
	 *  功    能 ： 设置 dataLength 的值
	 */
	public void setDataLength(String dataLength) {
		this.dataLength = dataLength;
	}

	/**  
	 *  方法名 ： getMaxDataLength 
	 *  功    能 ： 取得 maxDataLength 的值  
	 *  @return: String  maxDataLength
	 */
	public String getMaxDataLength() {
		return maxDataLength;
	}

	/**  
	 *  方法名 ： setMaxDataLength 
	 *  功    能 ： 设置 maxDataLength 的值
	 */
	public void setMaxDataLength(String maxDataLength) {
		this.maxDataLength = maxDataLength;
	}

	/**  
	 *  方法名 ： getIndexLength 
	 *  功    能 ： 取得 indexLength 的值  
	 *  @return: String  indexLength
	 */
	public String getIndexLength() {
		return indexLength;
	}

	/**  
	 *  方法名 ： setIndexLength 
	 *  功    能 ： 设置 indexLength 的值
	 */
	public void setIndexLength(String indexLength) {
		this.indexLength = indexLength;
	}

	/**  
	 *  方法名 ： getDataFree 
	 *  功    能 ： 取得 dataFree 的值  
	 *  @return: String  dataFree
	 */
	public String getDataFree() {
		return dataFree;
	}

	/**  
	 *  方法名 ： setDataFree 
	 *  功    能 ： 设置 dataFree 的值
	 */
	public void setDataFree(String dataFree) {
		this.dataFree = dataFree;
	}

	/**  
	 *  方法名 ： getAutoIncrement 
	 *  功    能 ： 取得 autoIncrement 的值  
	 *  @return: String  autoIncrement
	 */
	public String getAutoIncrement() {
		return autoIncrement;
	}

	/**  
	 *  方法名 ： setAutoIncrement 
	 *  功    能 ： 设置 autoIncrement 的值
	 */
	public void setAutoIncrement(String autoIncrement) {
		this.autoIncrement = autoIncrement;
	}

	/**  
	 *  方法名 ： getCreateTime 
	 *  功    能 ： 取得 createTime 的值  
	 *  @return: String  createTime
	 */
	public String getCreateTime() {
		return createTime;
	}

	/**  
	 *  方法名 ： setCreateTime 
	 *  功    能 ： 设置 createTime 的值
	 */
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	/**  
	 *  方法名 ： getUpdateTime 
	 *  功    能 ： 取得 updateTime 的值  
	 *  @return: String  updateTime
	 */
	public String getUpdateTime() {
		return updateTime;
	}

	/**  
	 *  方法名 ： setUpdateTime 
	 *  功    能 ： 设置 updateTime 的值
	 */
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	/**  
	 *  方法名 ： getCheckTime 
	 *  功    能 ： 取得 checkTime 的值  
	 *  @return: String  checkTime
	 */
	public String getCheckTime() {
		return checkTime;
	}

	/**  
	 *  方法名 ： setCheckTime 
	 *  功    能 ： 设置 checkTime 的值
	 */
	public void setCheckTime(String checkTime) {
		this.checkTime = checkTime;
	}

	/**  
	 *  方法名 ： getTableCollation 
	 *  功    能 ： 取得 tableCollation 的值  
	 *  @return: String  tableCollation
	 */
	public String getTableCollation() {
		return tableCollation;
	}

	/**  
	 *  方法名 ： setTableCollation 
	 *  功    能 ： 设置 tableCollation 的值
	 */
	public void setTableCollation(String tableCollation) {
		this.tableCollation = tableCollation;
	}

	/**  
	 *  方法名 ： getChecksum 
	 *  功    能 ： 取得 checksum 的值  
	 *  @return: String  checksum
	 */
	public String getChecksum() {
		return checksum;
	}

	/**  
	 *  方法名 ： setChecksum 
	 *  功    能 ： 设置 checksum 的值
	 */
	public void setChecksum(String checksum) {
		this.checksum = checksum;
	}

	/**  
	 *  方法名 ： getCreateOptions 
	 *  功    能 ： 取得 createOptions 的值  
	 *  @return: String  createOptions
	 */
	public String getCreateOptions() {
		return createOptions;
	}

	/**  
	 *  方法名 ： setCreateOptions 
	 *  功    能 ： 设置 createOptions 的值
	 */
	public void setCreateOptions(String createOptions) {
		this.createOptions = createOptions;
	}

	/**  
	 *  方法名 ： getTableComment 
	 *  功    能 ： 取得 tableComment 的值  
	 *  @return: String  tableComment
	 */
	public String getTableComment() {
		return tableComment;
	}

	/**  
	 *  方法名 ： setTableComment 
	 *  功    能 ： 设置 tableComment 的值
	 */
	public void setTableComment(String tableComment) {
		this.tableComment = tableComment;
	}

	/**  
	 *  方法名 ： getColumns 
	 *  功    能 ： 取得 columns 的值  
	 *  @return: List<MySQLColumns>  columns
	 */
	public List<MySQLColumns> getColumns() {
		return columns;
	}

	/**  
	 *  方法名 ： setColumns 
	 *  功    能 ： 设置 columns 的值
	 */
	public void setColumns(List<MySQLColumns> columns) {
		this.columns = columns;
	}

}
