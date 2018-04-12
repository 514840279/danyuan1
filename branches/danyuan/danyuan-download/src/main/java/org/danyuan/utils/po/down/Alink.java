package org.danyuan.utils.po.down;

import java.util.Date;

/**    
*  文件名 ： Alink.java  
*  包    名 ： org.danyuan.utils.po.down  
*  描    述 ： TODO(用一句话描述该文件做什么)  
*  作    者 ： Tenghui.Wang  
*  时    间 ： 2016年1月2日 下午6:19:27  
*  版    本 ： V1.0    
*/
public class Alink {
	private String id;
	private String type;
	private String href;
	private String title;
	private String target;
	private String text;
	private String style;
	private String alt;
	private int flag = 0;
	private int times;
	private String width;
	private String height;
	private String tagName;
	private String rel;
	private String parrent;
	private Date insertDate;
	
	/**  
	 *  方法名 ： getId 
	 *  功    能 ： 返回变量 id 的值  
	 *  @return: String 
	 */
	public String getId() {
		return id;
	}
	
	/**  
	 *  方法名 ： setId 
	 *  功    能 ： 设置变量 id 的值
	 */
	public void setId(String id) {
		this.id = id;
	}
	
	/**  
	 *  方法名 ： getType 
	 *  功    能 ： 返回变量 type 的值  
	 *  @return: String 
	 */
	public String getType() {
		return type;
	}
	
	/**  
	 *  方法名 ： setType 
	 *  功    能 ： 设置变量 type 的值
	 */
	public void setType(String type) {
		this.type = type;
	}
	
	/**  
	 *  方法名 ： getStyle 
	 *  功    能 ： 返回变量 style 的值  
	 *  @return: String 
	 */
	public String getStyle() {
		return style;
	}
	
	/**  
	 *  方法名 ： setStyle 
	 *  功    能 ： 设置变量 style 的值
	 */
	public void setStyle(String style) {
		this.style = style;
	}
	
	/**  
	 *  方法名 ： getHref 
	 *  功    能 ： 返回变量 href 的值  
	 *  @return: String 
	 */
	public String getHref() {
		return href;
	}
	
	/**  
	 *  方法名 ： setHref 
	 *  功    能 ： 设置变量 href 的值
	 */
	public void setHref(String href) {
		this.href = href;
	}
	
	/**  
	 *  方法名 ： getTagName 
	 *  功    能 ： 返回变量 tagName 的值  
	 *  @return: String 
	 */
	public String getTagName() {
		return tagName;
	}
	
	/**  
	 *  方法名 ： setTagName 
	 *  功    能 ： 设置变量 tagName 的值
	 */
	public void setTagName(String tagName) {
		this.tagName = tagName;
	}
	
	/**  
	 *  方法名 ： getWidth 
	 *  功    能 ： 返回变量 width 的值  
	 *  @return: String 
	 */
	public String getWidth() {
		return width;
	}
	
	/**  
	 *  方法名 ： setWidth 
	 *  功    能 ： 设置变量 width 的值
	 */
	public void setWidth(String width) {
		this.width = width;
	}
	
	/**  
	 *  方法名 ： getHeight 
	 *  功    能 ： 返回变量 height 的值  
	 *  @return: String 
	 */
	public String getHeight() {
		return height;
	}
	
	/**  
	 *  方法名 ： setHeight 
	 *  功    能 ： 设置变量 height 的值
	 */
	public void setHeight(String height) {
		this.height = height;
	}
	
	/**  
	 *  方法名 ： getTarget 
	 *  功    能 ： 返回变量 target 的值  
	 *  @return: String 
	 */
	public String getTarget() {
		return target;
	}
	
	/**  
	 *  方法名 ： setTarget 
	 *  功    能 ： 设置变量 target 的值
	 */
	public void setTarget(String target) {
		this.target = target;
	}
	
	/**  
	 *  方法名 ： getAlt 
	 *  功    能 ： 返回变量 alt 的值  
	 *  @return: String 
	 */
	public String getAlt() {
		return alt;
	}
	
	/**  
	 *  方法名 ： setAlt 
	 *  功    能 ： 设置变量 alt 的值
	 */
	public void setAlt(String alt) {
		this.alt = alt;
	}
	
	/**  
	 *  方法名 ： getTitle 
	 *  功    能 ： 返回变量 title 的值  
	 *  @return: String 
	 */
	public String getTitle() {
		return title;
	}
	
	/**  
	 *  方法名 ： setTitle 
	 *  功    能 ： 设置变量 title 的值
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	
	/**  
	 *  方法名 ： getText 
	 *  功    能 ： 返回变量 text 的值  
	 *  @return: String 
	 */
	public String getText() {
		return text;
	}
	
	/**  
	 *  方法名 ： setText 
	 *  功    能 ： 设置变量 text 的值
	 */
	public void setText(String text) {
		this.text = text;
	}
	
	/**  
	 *  方法名 ： getFlag 
	 *  功    能 ： 返回变量 flag 的值  
	 *  @return: int 
	 */
	public int getFlag() {
		return flag;
	}
	
	/**  
	 *  方法名 ： setFlag 
	 *  功    能 ： 设置变量 flag 的值
	 */
	public void setFlag(int flag) {
		this.flag = flag;
	}
	
	/**  
	 *  方法名 ： getTimes 
	 *  功    能 ： 返回变量 times 的值  
	 *  @return: int 
	 */
	public int getTimes() {
		return times;
	}
	
	/**  
	 *  方法名 ： setTimes 
	 *  功    能 ： 设置变量 times 的值
	 */
	public void setTimes(int times) {
		this.times = times;
	}
	
	/**  
	 *  方法名 ： getRel 
	 *  功    能 ： 返回变量 rel 的值  
	 *  @return: String 
	 */
	public String getRel() {
		return rel;
	}
	
	/**  
	 *  方法名 ： setRel 
	 *  功    能 ： 设置变量 rel 的值
	 */
	public void setRel(String rel) {
		this.rel = rel;
	}
	
	/**  
	 *  方法名 ： getParrent 
	 *  功    能 ： 返回变量 parrent 的值  
	 *  @return: String 
	 */
	public String getParrent() {
		return parrent;
	}
	
	/**  
	 *  方法名 ： setParrent 
	 *  功    能 ： 设置变量 parrent 的值
	 */
	public void setParrent(String parrent) {
		this.parrent = parrent;
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
	public Alink() {
		super();
	}
	
}
