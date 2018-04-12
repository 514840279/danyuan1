package org.danyuan.utils.po.down;

import java.util.Date;

/**    
*  文件名 ： Header.java  
*  包    名 ： org.danyuan.utils.po.down  
*  描    述 ： TODO(用一句话描述该文件做什么)  
*  作    者 ： Tenghui.Wang  
*  时    间 ： 2016年1月28日 下午11:30:51  
*  版    本 ： V1.0    
*/
public class Header {
	
	private String uuid;
	private String bootUrlUuid;
	private String key;
	private String value;
	private String head;
	private Date insertDate;
	private Date updateDate;
	
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
	 *  方法名 ： getBootUrlUuid 
	 *  功    能 ： 返回变量 bootUrlUuid 的值  
	 *  @return: String 
	 */
	public String getBootUrlUuid() {
		return bootUrlUuid;
	}
	
	/**  
	 *  方法名 ： setBootUrlUuid 
	 *  功    能 ： 设置变量 bootUrlUuid 的值
	 */
	public void setBootUrlUuid(String bootUrlUuid) {
		this.bootUrlUuid = bootUrlUuid;
	}
	
	/**  
	 *  方法名 ： getKey 
	 *  功    能 ： 返回变量 key 的值  
	 *  @return: String 
	 */
	public String getKey() {
		return key;
	}
	
	/**  
	 *  方法名 ： setKey 
	 *  功    能 ： 设置变量 key 的值
	 */
	public void setKey(String key) {
		this.key = key;
	}
	
	/**  
	 *  方法名 ： getValue 
	 *  功    能 ： 返回变量 value 的值  
	 *  @return: String 
	 */
	public String getValue() {
		return value;
	}
	
	/**  
	 *  方法名 ： setValue 
	 *  功    能 ： 设置变量 value 的值
	 */
	public void setValue(String value) {
		this.value = value;
	}
	
	/**  
	 *  方法名 ： getHead 
	 *  功    能 ： 返回变量 head 的值  
	 *  @return: String 
	 */
	public String getHead() {
		return head;
	}
	
	/**  
	 *  方法名 ： setHead 
	 *  功    能 ： 设置变量 head 的值
	 */
	public void setHead(String head) {
		this.head = head;
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
	 *  方法名 ： getUpdateDate 
	 *  功    能 ： 返回变量 updateDate 的值  
	 *  @return: Date 
	 */
	public Date getUpdateDate() {
		return updateDate;
	}
	
	/**  
	 *  方法名 ： setUpdateDate 
	 *  功    能 ： 设置变量 updateDate 的值
	 */
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	
	/**  
	*  构造方法： 
	*  描    述： TODO(这里用一句话描述这个方法的作用)  
	*  参    数： @param uuid
	*  参    数： @param bootUrlUuid
	*  参    数： @param key
	*  参    数： @param value
	*  参    数： @param head
	*  参    数： @param insertDate
	*  参    数： @param updateDate
	*  作    者 ： Tenghui.Wang  
	*  @throws  
	*/
	public Header(String uuid,String bootUrlUuid,String key,String value,String head,Date insertDate,Date updateDate) {
		super();
		this.uuid = uuid;
		this.bootUrlUuid = bootUrlUuid;
		this.key = key;
		this.value = value;
		this.head = head;
		this.insertDate = insertDate;
		this.updateDate = updateDate;
	}
	
	/**  
	*  构造方法： 
	*  描    述： TODO(这里用一句话描述这个方法的作用)  
	*  参    数： 
	*  作    者 ： Tenghui.Wang  
	*  @throws  
	*/
	public Header() {
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
		return "Header [uuid=" + uuid + ", bootUrlUuid=" + bootUrlUuid + ", key=" + key + ", value=" + value + ", head=" + head + ", insertDate=" + insertDate + ", updateDate=" + updateDate + "]";
	}
	
}
