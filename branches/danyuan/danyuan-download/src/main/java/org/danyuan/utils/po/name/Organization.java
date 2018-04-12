package org.danyuan.utils.po.name ;

import java.util.Date ;

/**    
*  文件名 ： Organization.java  
*  包    名 ： org.danyuan.utils.po.name  
*  描    述 ： TODO(用一句话描述该文件做什么)  
*  作    者 ： Tenghui.Wang  
*  时    间 ： 2016年4月5日 上午8:09:45  
*  版    本 ： V1.0    
*/
public class Organization {
	private String name ;
	private String origin ;
	private Date insertDatetime ;
	private Date updateDatetime ;
	
	/**  
	 *  方法名 ： getName 
	 *  功    能 ： 返回变量 name 的值  
	 *  @return: String 
	 */
	public String getName() {
		return name ;
	}
	
	/**  
	 *  方法名 ： setName 
	 *  功    能 ： 设置变量 name 的值
	 */
	public void setName(String name) {
		this.name = name ;
	}
	
	/**  
	 *  方法名 ： getOrigin 
	 *  功    能 ： 返回变量 origin 的值  
	 *  @return: String 
	 */
	public String getOrigin() {
		return origin ;
	}
	
	/**  
	 *  方法名 ： setOrigin 
	 *  功    能 ： 设置变量 origin 的值
	 */
	public void setOrigin(String origin) {
		this.origin = origin ;
	}
	
	/**  
	 *  方法名 ： getInsertDatetime 
	 *  功    能 ： 返回变量 insertDatetime 的值  
	 *  @return: Date 
	 */
	public Date getInsertDatetime() {
		return insertDatetime ;
	}
	
	/**  
	 *  方法名 ： setInsertDatetime 
	 *  功    能 ： 设置变量 insertDatetime 的值
	 */
	public void setInsertDatetime(Date insertDatetime) {
		this.insertDatetime = insertDatetime ;
	}
	
	/**  
	 *  方法名 ： getUpdateDatetime 
	 *  功    能 ： 返回变量 updateDatetime 的值  
	 *  @return: Date 
	 */
	public Date getUpdateDatetime() {
		return updateDatetime ;
	}
	
	/**  
	 *  方法名 ： setUpdateDatetime 
	 *  功    能 ： 设置变量 updateDatetime 的值
	 */
	public void setUpdateDatetime(Date updateDatetime) {
		this.updateDatetime = updateDatetime ;
	}
	
}
