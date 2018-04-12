package com.danyuan.aotucode.po;

import java.math.BigDecimal;

/**
 * 
*  文件名 ： MySQLColumns.java  
*  包    名 ： com.danyuan.aotucode.po  
*  描    述 ： MySQL自动生成java代码的实体类
*  机能名称：MySQL自动生成java代码
*  技能ID ：
*  作    者 ： Wang Tenghui  
*  时    间 ： 2015年5月3日 下午1:57:02  
*  版    本 ： V1.0
 */
public class MySQLColumns {

	// 表限定符
	private String tableCatalog;
	// 表所有者
	private String tableSchema;
	// 表名
	private String tableName;
	// 列名
	private String columnName;
	// 列标识号
	private BigDecimal ordinalPosition;
	// 默认值
	private String columnDefault;
	// 是否允许为空
	private String isNullable;
	// 数据类型
	private String dataType;
	// 最大长度
	private BigDecimal characterMaximumLength;
	// 八位字节长度
	private BigDecimal characterOctetLength;
	// 精度
	private BigDecimal numericPrecision;
	// 小数位
	private BigDecimal numericScale;
	// 字符集
	private String characterSetName;
	// 排序规则
	private String collationName;
	// 字段类型
	private String columnType;
	// 字段主键
	private String columnKey;
	// 额外信息
	private String extra;
	// 限制
	private String privileges;
	// 注释
	private String columnComment;

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
	 *  方法名 ： getColumnName 
	 *  功    能 ： 取得 columnName 的值  
	 *  @return: String  columnName
	 */
	public String getColumnName() {
		return columnName;
	}

	/**  
	 *  方法名 ： setColumnName 
	 *  功    能 ： 设置 columnName 的值
	 */
	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	/**  
	 *  方法名 ： getOrdinalPosition 
	 *  功    能 ： 取得 ordinalPosition 的值  
	 *  @return: BigDecimal  ordinalPosition
	 */
	public BigDecimal getOrdinalPosition() {
		return ordinalPosition;
	}

	/**  
	 *  方法名 ： setOrdinalPosition 
	 *  功    能 ： 设置 ordinalPosition 的值
	 */
	public void setOrdinalPosition(BigDecimal ordinalPosition) {
		this.ordinalPosition = ordinalPosition;
	}

	/**  
	 *  方法名 ： getColumnDefault 
	 *  功    能 ： 取得 columnDefault 的值  
	 *  @return: String  columnDefault
	 */
	public String getColumnDefault() {
		return columnDefault;
	}

	/**  
	 *  方法名 ： setColumnDefault 
	 *  功    能 ： 设置 columnDefault 的值
	 */
	public void setColumnDefault(String columnDefault) {
		this.columnDefault = columnDefault;
	}

	/**  
	 *  方法名 ： getIsNullable 
	 *  功    能 ： 取得 isNullable 的值  
	 *  @return: String  isNullable
	 */
	public String getIsNullable() {
		return isNullable;
	}

	/**  
	 *  方法名 ： setIsNullable 
	 *  功    能 ： 设置 isNullable 的值
	 */
	public void setIsNullable(String isNullable) {
		this.isNullable = isNullable;
	}

	/**  
	 *  方法名 ： getDataType 
	 *  功    能 ： 取得 dataType 的值  
	 *  @return: String  dataType
	 */
	public String getDataType() {
		return dataType;
	}

	/**  
	 *  方法名 ： setDataType 
	 *  功    能 ： 设置 dataType 的值
	 */
	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	/**  
	 *  方法名 ： getCharacterMaximumLength 
	 *  功    能 ： 取得 characterMaximumLength 的值  
	 *  @return: BigDecimal  characterMaximumLength
	 */
	public BigDecimal getCharacterMaximumLength() {
		return characterMaximumLength;
	}

	/**  
	 *  方法名 ： setCharacterMaximumLength 
	 *  功    能 ： 设置 characterMaximumLength 的值
	 */
	public void setCharacterMaximumLength(BigDecimal characterMaximumLength) {
		this.characterMaximumLength = characterMaximumLength;
	}

	/**  
	 *  方法名 ： getCharacterOctetLength 
	 *  功    能 ： 取得 characterOctetLength 的值  
	 *  @return: BigDecimal  characterOctetLength
	 */
	public BigDecimal getCharacterOctetLength() {
		return characterOctetLength;
	}

	/**  
	 *  方法名 ： setCharacterOctetLength 
	 *  功    能 ： 设置 characterOctetLength 的值
	 */
	public void setCharacterOctetLength(BigDecimal characterOctetLength) {
		this.characterOctetLength = characterOctetLength;
	}

	/**  
	 *  方法名 ： getNumericPrecision 
	 *  功    能 ： 取得 numericPrecision 的值  
	 *  @return: BigDecimal  numericPrecision
	 */
	public BigDecimal getNumericPrecision() {
		return numericPrecision;
	}

	/**  
	 *  方法名 ： setNumericPrecision 
	 *  功    能 ： 设置 numericPrecision 的值
	 */
	public void setNumericPrecision(BigDecimal numericPrecision) {
		this.numericPrecision = numericPrecision;
	}

	/**  
	 *  方法名 ： getNumericScale 
	 *  功    能 ： 取得 numericScale 的值  
	 *  @return: BigDecimal  numericScale
	 */
	public BigDecimal getNumericScale() {
		return numericScale;
	}

	/**  
	 *  方法名 ： setNumericScale 
	 *  功    能 ： 设置 numericScale 的值
	 */
	public void setNumericScale(BigDecimal numericScale) {
		this.numericScale = numericScale;
	}

	/**  
	 *  方法名 ： getCharacterSetName 
	 *  功    能 ： 取得 characterSetName 的值  
	 *  @return: String  characterSetName
	 */
	public String getCharacterSetName() {
		return characterSetName;
	}

	/**  
	 *  方法名 ： setCharacterSetName 
	 *  功    能 ： 设置 characterSetName 的值
	 */
	public void setCharacterSetName(String characterSetName) {
		this.characterSetName = characterSetName;
	}

	/**  
	 *  方法名 ： getCollationName 
	 *  功    能 ： 取得 collationName 的值  
	 *  @return: String  collationName
	 */
	public String getCollationName() {
		return collationName;
	}

	/**  
	 *  方法名 ： setCollationName 
	 *  功    能 ： 设置 collationName 的值
	 */
	public void setCollationName(String collationName) {
		this.collationName = collationName;
	}

	/**  
	 *  方法名 ： getColumnType 
	 *  功    能 ： 取得 columnType 的值  
	 *  @return: String  columnType
	 */
	public String getColumnType() {
		return columnType;
	}

	/**  
	 *  方法名 ： setColumnType 
	 *  功    能 ： 设置 columnType 的值
	 */
	public void setColumnType(String columnType) {
		this.columnType = columnType;
	}

	/**  
	 *  方法名 ： getColumnKey 
	 *  功    能 ： 取得 columnKey 的值  
	 *  @return: String  columnKey
	 */
	public String getColumnKey() {
		return columnKey;
	}

	/**  
	 *  方法名 ： setColumnKey 
	 *  功    能 ： 设置 columnKey 的值
	 */
	public void setColumnKey(String columnKey) {
		this.columnKey = columnKey;
	}

	/**  
	 *  方法名 ： getExtra 
	 *  功    能 ： 取得 extra 的值  
	 *  @return: String  extra
	 */
	public String getExtra() {
		return extra;
	}

	/**  
	 *  方法名 ： setExtra 
	 *  功    能 ： 设置 extra 的值
	 */
	public void setExtra(String extra) {
		this.extra = extra;
	}

	/**  
	 *  方法名 ： getPrivileges 
	 *  功    能 ： 取得 privileges 的值  
	 *  @return: String  privileges
	 */
	public String getPrivileges() {
		return privileges;
	}

	/**  
	 *  方法名 ： setPrivileges 
	 *  功    能 ： 设置 privileges 的值
	 */
	public void setPrivileges(String privileges) {
		this.privileges = privileges;
	}

	/**  
	 *  方法名 ： getColumnComment 
	 *  功    能 ： 取得 columnComment 的值  
	 *  @return: String  columnComment
	 */
	public String getColumnComment() {
		return columnComment;
	}

	/**  
	 *  方法名 ： setColumnComment 
	 *  功    能 ： 设置 columnComment 的值
	 */
	public void setColumnComment(String columnComment) {
		this.columnComment = columnComment;
	}
}