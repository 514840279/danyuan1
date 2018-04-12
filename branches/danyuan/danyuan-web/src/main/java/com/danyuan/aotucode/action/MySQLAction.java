package com.danyuan.aotucode.action;

import java.io.File;
import java.sql.SQLException;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;

import com.danyuan.aotucode.po.MySQLDatabase;
import com.danyuan.aotucode.service.MySQLService;
import com.danyuan.aotucode.vo.MySQLVo;
import com.danyuan.common.action.BaseAction;
import com.danyuan.common.util.CheckEmptyUtils;
import com.opensymphony.xwork2.ModelDriven;

/**    
 *  文件名 ： MySQLAction.java  
 *  包    名 ： com.danyuan.aotucode.action  
 *  描    述 ： MySQLAction 
 *  机能名称：MySQLAction
 *  技能ID ：MySQLAction
 *  作    者 ： Tenghui.Wang  
 *  时    间 ： 2015年5月3日 下午10:41:40  
 *  版    本 ： V1.0    
 */
@Namespace("/")
@Action(value = "mySQLAction")
public class MySQLAction extends BaseAction implements ModelDriven<MySQLVo> {
	// vo
	MySQLVo vo = new MySQLVo();
	
	/** 
	*  方法名 ： getModel
	*  功    能 ： 模型驱动
	*  参    数 ： @return  
	*  参    考 ： @see com.opensymphony.xwork2.ModelDriven#getModel()  
	*  作    者 ： Tenghui.Wang  
	*/
	@Override
	public MySQLVo getModel() {
		return vo;
	}

	// service
	private MySQLService service;

	/**  
	 *  方法名 ： getService 
	 *  功    能 ： 取得 service 的值  
	 *  @return: MySQLService  service
	 */
	public MySQLService getService() {
		return service;
	}

	/**  
	 *  方法名 ： setService 
	 *  功    能 ： 设置 service 的值
	 */
	public void setService(MySQLService service) {
		this.service = service;
	}

	/**
	 * 
	 *  方法名： getMySQLModel  
	 *  功    能： 取得列数据
	 *  参    数：  
	 *  返    回： void  
	 *  作    者 ： Tenghui.Wang  
	 *  @throws SQLException
	 */
	public void getMySQLModel() throws SQLException {

		List<MySQLDatabase> mySQLDatabase = service.getColumnsTree();
		super.writeJson(mySQLDatabase);
	}

	/**
	 * 
	 *  方法名： createJavaFileModel  
	 *  功    能： 生成Java模型类 
	 *  参    数：  
	 *  返    回： void  
	 *  作    者 ： Tenghui.Wang  
	 *  @throws
	 */
	public void createJavaFileModel() {
		// 生成文件的根路径
		if (CheckEmptyUtils.isEmpty(vo.getFilePath())) {
			// 创建文件目录对象
			File file = new File(vo.getFilePath());
			// 创建文件目录
			file.mkdirs();
		}
		//
		if (vo.getBeanClassStatus() == "1") {

		} else if (vo.getBeanClassStatus() == "2") {
			//
		} else if (vo.getBeanClassStatus() == "3") {
			//
		}



	}
}
