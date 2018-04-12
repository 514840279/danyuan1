package com.danyuan.aotucode.vo;

import java.util.List;

/**    
 *  文件名 ： MySQLColumnsVo.java  
 *  包    名 ： com.danyuan.aotucode.vo  
 *  描    述 ： TODO(用一句话描述该文件做什么)  
 *  机能名称：
 *  技能ID ：
 *  作    者 ： Tenghui.Wang  
 *  时    间 ： 2015年5月3日 下午10:30:06  
 *  版    本 ： V1.0    
 */
public class MySQLColumnsVo implements java.io.Serializable{

	/**
	 * @Fields serialVersionUID : 生成序列 
	 */
	private static final long serialVersionUID = -1870235139674209355L;
	// 列
	private List<String> columnsVo;

	/**  
	 *  方法名 ： getColumnsVo 
	 *  功    能 ： 取得 columnsVo 的值  
	 *  @return: List<String>  columnsVo
	 */
	public synchronized List<String> getColumnsVo() {
		return columnsVo;
	}

	/**  
	 *  方法名 ： setColumnsVo 
	 *  功    能 ： 设置 columnsVo 的值
	 */
	public synchronized void setColumnsVo(List<String> columnsVo) {
		this.columnsVo = columnsVo;
	}

}
