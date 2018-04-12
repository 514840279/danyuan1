package com.danyuan.aotucode.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.danyuan.aotucode.dao.MySQLDao;
import com.danyuan.aotucode.dao.impl.MySQLDaoImpl;
import com.danyuan.aotucode.po.MySQLColumns;
import com.danyuan.aotucode.po.MySQLDatabase;
import com.danyuan.aotucode.po.MySQLTables;
import com.danyuan.aotucode.service.MySQLService;
import com.danyuan.aotucode.vo.MySQLVo;

/**    
 *  文件名 ： MySQLServiceImpl.java  
 *  包    名 ： com.danyuan.aotucode.service.impl  
 *  描    述 ： MySQL逻辑处理实现
 *  机能名称：MySQL逻辑处理实现
 *  技能ID ：MySQLServiceImpl
 *  作    者 ： Tenghui.Wang  
 *  时    间 ： 2015年5月5日 下午7:46:45  
 *  版    本 ： V1.0    
 */
@Service("mySQLService")
public class MySQLServiceImpl implements MySQLService {

	/** 
	*  方法名 ： getColumnsTree
	*  功    能 ： 取得数据库中表的列
	*  参    数 ： @return  
	*  参    考 ： @see com.danyuan.aotucode.service.MySQLService#getColumnsTree()  
	*  作    者 ： Tenghui.Wang  
	 * @throws SQLException 
	*/
	@Override
	public List<MySQLDatabase> getColumnsTree() throws SQLException {
		MySQLDao dao = new MySQLDaoImpl();
		// MySQLDatabase集合
		List<MySQLDatabase> databaseList = new ArrayList<MySQLDatabase>();
		// 取得数据库名称
		List<String> schema = dao.selectDabase();

		for (String tableSchema : schema) {
			// MySQLDatabase
			MySQLDatabase database = new MySQLDatabase();
			// 添加数据库名
			database.setDatabase(tableSchema);
			// 取得当前数据库的所有表
			List<MySQLTables> tables = dao.selectTables(tableSchema);
			// 变量
			int i = 0;
			for (MySQLTables table : tables) {
				// 取得当前表的列所有属性
				List<MySQLColumns> columns = dao.selectColumns(tableSchema, table.getTableName());
				// 添加列集合
				tables.get(i++).setColumns(columns);
			}
			// 添加表集合
			database.setTables(tables);
			// 添加数据库集合
			databaseList.add(database);
		}
		return databaseList;
	}

	/** 
	*  方法名 ： createBeans
	*  功    能 ： 创建Beans.class
	*  参    数 ： @param vo  
	*  参    考 ： @see com.danyuan.aotucode.service.MySQLService#createBeans(com.danyuan.aotucode.vo.MySQLVo)  
	*  作    者 ： Tenghui.Wang  
	*/
	@Override
	public void createBeans(MySQLVo vo) {
		// TODO Auto-generated method stub

	}

	/** 
	*  方法名 ： createDao
	*  功    能 ： 创建Dao.class
	*  参    数 ： @param vo  
	*  参    考 ： @see com.danyuan.aotucode.service.MySQLService#createDao(com.danyuan.aotucode.vo.MySQLVo)  
	*  作    者 ： Tenghui.Wang  
	*/
	@Override
	public void createDao(MySQLVo vo) {
		// TODO Auto-generated method stub

	}

	/** 
	*  方法名 ： createDaoImpl
	*  功    能 ： 创建DaoImpl.class
	*  参    数 ： @param vo  
	*  参    考 ： @see com.danyuan.aotucode.service.MySQLService#createDaoImpl(com.danyuan.aotucode.vo.MySQLVo)  
	*  作    者 ： Tenghui.Wang  
	*/
	@Override
	public void createDaoImpl(MySQLVo vo) {
		// TODO Auto-generated method stub

	}

	/** 
	*  方法名 ： createService
	*  功    能 ：创建Service.class
	*  参    数 ： @param vo  
	*  参    考 ： @see com.danyuan.aotucode.service.MySQLService#createService(com.danyuan.aotucode.vo.MySQLVo)  
	*  作    者 ： Tenghui.Wang  
	*/
	@Override
	public void createService(MySQLVo vo) {
		// TODO Auto-generated method stub

	}

	/** 
	*  方法名 ： createServiceImpl
	*  功    能 ： 创建ServiceImpl.class
	*  参    数 ： @param vo  
	*  参    考 ： @see com.danyuan.aotucode.service.MySQLService#createServiceImpl(com.danyuan.aotucode.vo.MySQLVo)  
	*  作    者 ： Tenghui.Wang  
	*/
	@Override
	public void createServiceImpl(MySQLVo vo) {
		// TODO Auto-generated method stub

	}

	/** 
	*  方法名 ： createAction
	*  功    能 ： 创建Action.class
	*  参    数 ： @param vo  
	*  参    考 ： @see com.danyuan.aotucode.service.MySQLService#createAction(com.danyuan.aotucode.vo.MySQLVo)  
	*  作    者 ： Tenghui.Wang  
	*/
	@Override
	public void createAction(MySQLVo vo) {
		// TODO Auto-generated method stub

	}

	/** 
	*  方法名 ： createVo
	*  功    能 ： 创建Vo.class
	*  参    数 ： @param vo  
	*  参    考 ： @see com.danyuan.aotucode.service.MySQLService#createPo(com.danyuan.aotucode.vo.MySQLVo)  
	*  作    者 ： Tenghui.Wang  
	*/
	@Override
	public void createVo(MySQLVo vo) {
		// TODO Auto-generated method stub

	}

}
