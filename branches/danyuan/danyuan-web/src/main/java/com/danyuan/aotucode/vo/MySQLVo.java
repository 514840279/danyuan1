package com.danyuan.aotucode.vo;

import java.util.List;

/**    
 *  文件名 ： MySQLVo.java  
 *  包    名 ： com.danyuan.aotucode.vo  
 *  描    述 ： 封装VO类
 *  机能名称：自动生成java
 *  技能ID ：
 *  作    者 ： Tenghui.Wang  
 *  时    间 ： 2015年5月3日 下午9:32:36  
 *  版    本 ： V1.0    
 */
public class MySQLVo implements java.io.Serializable {

	/**
	 * @Fields serialVersionUID : 生成序列号
	 */
	private static final long serialVersionUID = 4205847646101128033L;

	/**  
	*  构造方法： 
	*  描    述： 空的构造函数
	*  参    数： 
	*  作    者 ： Tenghui.Wang  
	*  @throws  
	*/
	public MySQLVo() {

	}

	// 集合-列
	private List<MySQLColumnsVo> columnsVo;
	// 集合-文件名
	private List<String> fileName;
	// bean类文件名
	private String BeanClassName;
	// 文件路径
	private String filePath;
	// 生成bean类的状况《1.手动起名，2.根据表明起名，3.手动多表》
	private String beanClassStatus;

	/**  
	 *  方法名 ： getColumnsVo 
	 *  功    能 ： 取得 columnsVo 的值  
	 *  @return: List<MySQLColumnsVo>  columnsVo
	 */
	public synchronized List<MySQLColumnsVo> getColumnsVo() {
		return columnsVo;
	}

	/**  
	 *  方法名 ： setColumnsVo 
	 *  功    能 ： 设置 columnsVo 的值
	 */
	public synchronized void setColumnsVo(List<MySQLColumnsVo> columnsVo) {
		this.columnsVo = columnsVo;
	}

	/**  
	 *  方法名 ： getFileName 
	 *  功    能 ： 取得 fileName 的值  
	 *  @return: List<String>  fileName
	 */
	public synchronized List<String> getFileName() {
		return fileName;
	}

	/**  
	 *  方法名 ： setFileName 
	 *  功    能 ： 设置 fileName 的值
	 */
	public synchronized void setFileName(List<String> fileName) {
		this.fileName = fileName;
	}

	/**  
	 *  方法名 ： getBeanClassName 
	 *  功    能 ： 取得 BeanClassName 的值  
	 *  @return: String  BeanClassName
	 */
	public synchronized String getBeanClassName() {
		return BeanClassName;
	}

	/**  
	 *  方法名 ： setBeanClassName 
	 *  功    能 ： 设置 BeanClassName 的值
	 */
	public synchronized void setBeanClassName(String beanClassName) {
		BeanClassName = beanClassName;
	}

	/**  
	 *  方法名 ： getFilePath 
	 *  功    能 ： 取得 filePath 的值  
	 *  @return: String  filePath
	 */
	public synchronized String getFilePath() {
		return filePath;
	}

	/**  
	 *  方法名 ： setFilePath 
	 *  功    能 ： 设置 filePath 的值
	 */
	public synchronized void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	/**  
	 *  方法名 ： getBeanClassStatus 
	 *  功    能 ： 取得 beanClassStatus 的值  
	 *  @return: String  beanClassStatus
	 */
	public synchronized String getBeanClassStatus() {
		return beanClassStatus;
	}

	/**  
	 *  方法名 ： setBeanClassStatus 
	 *  功    能 ： 设置 beanClassStatus 的值
	 */
	public synchronized void setBeanClassStatus(String beanClassStatus) {
		this.beanClassStatus = beanClassStatus;
	}

}
