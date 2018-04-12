package com.danyuan.aotucode.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**    
 *  文件名 ： CreateFile.java  
 *  包    名 ： com.danyuan.aotucode.dao  
 *  描    述 ： 用于生成件路径和文件
 *  机能名称：创建文件
 *  技能ID ：CreateFile
 *  作    者 ： Tenghui.Wang  
 *  时    间 ： 2015年5月10日 下午6:36:12  
 *  版    本 ： V1.0    
 */
public class CreateFile {

	/**
	 *  方法名： createFile  
	 *  功    能： 创建文件
	 *  参    数： @param file 
	 *  返    回： boolean  
	 *  作    者 ： Tenghui.Wang  
	 *  @throws IOException
	 */
	public boolean createFile(FileWriter file, String data) throws IOException {
		BufferedWriter bufferWritter = new BufferedWriter(file);
		bufferWritter.write(data);
		bufferWritter.flush();
		bufferWritter.close();
		return true;
	}

	/**
	 *  方法名： createPath  
	 *  功    能： 创建文件路径
	 *  参    数： @param file
	 *  参    数： @return 
	 *  返    回： boolean  
	 *  作    者 ： Tenghui.Wang  
	 *  @throws IOException
	 */
	public boolean createPath(File file) throws IOException {
		 file.mkdirs();
		 file.createNewFile();  
		 return true;

	}
}
