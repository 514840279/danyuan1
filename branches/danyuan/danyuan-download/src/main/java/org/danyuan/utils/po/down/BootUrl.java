package org.danyuan.utils.po.down;

import java.util.Date;

/**    
*  文件名 ： BootUrl.java  
*  包    名 ： org.danyuan.utils.po.down  
*  描    述 ： TODO(用一句话描述该文件做什么)  
*  作    者 ： Tenghui.Wang  
*  时    间 ： 2016年2月1日 下午8:09:31  
*  版    本 ： V1.0    
*/
public class BootUrl {
	private String uuid;
	private String bootUrl;
	private String name;
	private String charset;
	private Date insertDate = new Date();
	
	/**  
	 *  方法名 ： getUuid 
	 *  功    能 ： 返回变量 uuid 的值  
	 *  @return: String 
	 */
	public String getUuid() {
		return uuid;
	}
	
	/**  
	 *  方法名 ： setUuid 
	 *  功    能 ： 设置变量 uuid 的值
	 */
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	
	/**  
	 *  方法名 ： getBootUrl 
	 *  功    能 ： 返回变量 bootUrl 的值  
	 *  @return: String 
	 */
	public String getBootUrl() {
		return bootUrl;
	}
	
	/**  
	 *  方法名 ： setBootUrl 
	 *  功    能 ： 设置变量 bootUrl 的值
	 */
	public void setBootUrl(String bootUrl) {
		this.bootUrl = bootUrl;
	}
	
	/**  
	*  构造方法： 
	*  描    述： TODO(这里用一句话描述这个方法的作用)  
	*  参    数： @param uuid
	*  参    数： @param bootUrl
	*  作    者 ： Tenghui.Wang  
	*  @throws  
	*/
	public BootUrl(String uuid,String bootUrl) {
		super();
		this.uuid = uuid;
		this.bootUrl = bootUrl;
	}
	
	/**  
	 *  方法名 ： getName 
	 *  功    能 ： 返回变量 name 的值  
	 *  @return: String 
	 */
	public String getName() {
		return name;
	}
	
	/**  
	 *  方法名 ： setName 
	 *  功    能 ： 设置变量 name 的值
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**  
	 *  方法名 ： getCharset 
	 *  功    能 ： 返回变量 charset 的值  
	 *  @return: String 
	 */
	public String getCharset() {
		return charset;
	}
	
	/**  
	 *  方法名 ： setCharset 
	 *  功    能 ： 设置变量 charset 的值
	 */
	public void setCharset(String charset) {
		this.charset = charset;
	}
	
	/**  
	 *  方法名 ： getInsertDate 
	 *  功    能 ： 返回变量 insertDate 的值  
	 *  @return: Date 
	 */
	public Date getInsertDate() {
		return insertDate;
	}
	
	/**  
	 *  方法名 ： setInsertDate 
	 *  功    能 ： 设置变量 insertDate 的值
	 */
	public void setInsertDate(Date insertDate) {
		this.insertDate = insertDate;
	}
	
	/**  
	*  构造方法： 
	*  描    述： TODO(这里用一句话描述这个方法的作用)  
	*  参    数： 
	*  作    者 ： Tenghui.Wang  
	*  @throws  
	*/
	public BootUrl() {
		super();
	}
	
	/** 
	*  方法名 ： toString
	*  功    能 ： TODO(这里用一句话描述这个方法的作用)  
	*  参    数 ： @return  
	*  参    考 ： @see java.lang.Object#toString()  
	*  作    者 ： Tenghui.Wang  
	*/
	
	@Override
	public String toString() {
		return "BootUrl [uuid=" + uuid + ", bootUrl=" + bootUrl + "]";
	}
	
}
