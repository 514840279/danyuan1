package org.danyuan.download.service ;

import java.util.ArrayList ;
import java.util.Date ;
import java.util.List ;

import org.danyuan.download.insertdb.UpdateData ;
import org.danyuan.utils.Constant ;
import org.danyuan.utils.hibernate.HibernateBase ;
import org.danyuan.utils.po.down.Alink ;
import org.hibernate.Query ;
import org.hibernate.Session ;
import org.jsoup.Jsoup ;
import org.jsoup.nodes.Document ;
import org.jsoup.nodes.Element ;
import org.jsoup.select.Elements ;

/**    
*  文件名 ： Xuexi111.java  
*  包    名 ： org.danyuan.download.service  
*  描    述 ： TODO(用一句话描述该文件做什么)  
*  作    者 ： Tenghui.Wang  
*  时    间 ： 2016年1月2日 下午3:02:22  
*  版    本 ： V1.0    
*/
public class Xuexi111 {
	
	public static void main(String[] args) throws Exception {
		// uri
		String uri = UpdateData.getlinkfromdb("select href FROM Alink WHERE flag=0 and href is not null and href like 'http://www.xuexi111.com%'") ;
		// 要查询的网站
		getafromhtml(uri) ;
		
	}
	
	/**
	 * @throws Exception 
	 * @throws IOException 
	 * @throws SQLException 
	 * @throws UnsupportedEncodingException   
	*  方法名： getafromhtml  
	*  功    能： TODO(这里用一句话描述这个方法的作用)  
	*  参    数： @param uri 
	*  返    回： void  
	*  作    者 ： Tenghui.Wang  
	*  @throws  
	*/
	private static void getafromhtml(String uri) throws Exception {
		String tempuri = uri ;
		String head = null ;
		if (uri.contains("http://")) {
			head = "http://" ;
		} else if (uri.contains("https://")) {
			head = "https://" ;
		} else if (uri.contains("http:/")) {
			head = "http:/" ;
		} else if (uri.contains("http:/")) {
			head = "http:/" ;
		}
		uri = uri.replace(head, "") ;
		String host = uri.substring(0, uri.indexOf("/") > 0 ? uri.indexOf("/") : uri.length()) ;
		host = head + uri ;
		// 获取网页源码
		String body = HtmlBody.getHtml(host, tempuri, "", "") ;
		//		EntityP p = new EntityP(body);
		if (!"".equals(body)) {
			// 转换字符串
			//		body = StringUtils.getUTF8(body);
			// 获取a标签连接内容
			List<Alink> list = getlistfrombody(body) ;
			// body清除
			body = null ;
			UpdateData updateData = new UpdateData() ;
			// 查询出数据库中已有否
			for (int i = 0; i < list.size(); i++) {
				if (getexit(list.get(i)) && !list.get(i).getHref().startsWith("mailto:")) {
					// 没有就添加
					
					list.get(i).setParrent(tempuri) ;
					updateData.writetodb(list.get(i)) ;
				}
			}
			UpdateData.update(tempuri, 1, "update Alink") ;
		} else {
			UpdateData.update(tempuri, -1, "update Alink") ;
		}
		// 查询是否有没下载的网页
		System.gc() ;
		uri = UpdateData.getlinkfromdb("select href FROM Alink WHERE flag=0 and href is not null and href like 'http://www.xuexi111.com%'") ;
		if (uri == null) {
			System.out.println("爬取完成") ;
			
			return ;
		}
		// 有取出一个执行
		getafromhtml(uri) ;
		
	}
	
	/**  
	*  方法名： getexit  
	*  功    能： TODO(这里用一句话描述这个方法的作用)  
	*  参    数： @param e
	*  参    数： @return 
	*  返    回： boolean  
	*  作    者 ： Tenghui.Wang  
	*  @throws  
	*/
	private static boolean getexit(Alink alink) {
		if ("".equals(alink.getHref())) {
			return false ;
		}
		HibernateBase hibernate = new HibernateBase(Constant.danyuan) ;
		Session session = hibernate.getSession() ;
		Query query = session.createQuery("select distinct href from Alink where href= :href").setFirstResult(0).setMaxResults(1) ;
		query.setParameter("href", alink.getHref()) ;
		String href = (String) query.uniqueResult() ;
		if (href != null) {
			hibernate.destroy() ;
			if (alink.getHref().equals(href)) {
				href = null ;
				return false ;
			} else {
				href = null ;
				return true ;
			}
		} else {
			href = null ;
			hibernate.destroy() ;
			return true ;
		}
	}
	
	/**  
	*  方法名： getlistfrombody  
	*  功    能： TODO(这里用一句话描述这个方法的作用)  
	*  参    数： @return 
	*  返    回： List<e>  
	*  作    者 ： Tenghui.Wang  
	*  @throws  
	*/
	private static List<Alink> getlistfrombody(String body) {
		Document doc = Jsoup.parse(body) ;
		Elements links = doc.select("a[href]") ;
		Elements media = doc.select("[src]") ;
		Elements imports = doc.select("link[href]") ;
		List<Alink> list = new ArrayList<Alink>() ;
		for (Element element : links) {
			
			list.add(putLinksToAlink(element)) ;
			
		}
		for (Element element : media) {
			
			list.add(putLinksToAlink(element)) ;
			
		}
		for (Element element : imports) {
			
			list.add(putLinksToAlink(element)) ;
			
		}
		
		return list ;
	}
	
	/**
	 * 
	*  方法名： putLinksToAlink  
	*  功    能：将解析出来的link放进alink里
	*  参    数： @param element
	*  参    数： @return 
	*  返    回： Alink  
	*  作    者 ： Tenghui.Wang  
	*  @throws
	 */
	private static Alink putLinksToAlink(Element element) {
		Alink alink = new Alink() ;
		alink.setHref(element.attr("abs:href")) ;
		alink.setText(element.text()) ;
		alink.setTarget(element.attr("target")) ;
		alink.setTitle(element.attr("title")) ;
		alink.setTagName(element.tagName()) ;
		alink.setStyle(element.attr("style")) ;
		alink.setAlt(element.attr("alt")) ;
		alink.setWidth(element.attr("width")) ;
		alink.setHeight(element.attr("height")) ;
		alink.setRel(element.attr("rel")) ;
		alink.setType(element.attr("type")) ;
		alink.setInsertDate(new Date()) ;
		flag(alink) ;
		return alink ;
	}
	
	/**
	 * 
	*  方法名： flag  
	*  功    能： 判断
	*  参    数： @param alink
	*  参    数： @return 
	*  返    回： int  
	*  作    者 ： Tenghui.Wang  
	*  @throws
	 */
	private static void flag(Alink alink) {
		String tempHref = alink.getHref() ;
		if (tempHref.contains("ed2k://")) {
			alink.setFlag(2) ;
			alink.setType("ed2k") ;
			return ;
		} else if (tempHref.contains("vip.xunlei.com")) {
			alink.setFlag(2) ;
			alink.setType("迅雷快传") ;
			return ;
		}
		tempHref = tempHref.substring(tempHref.lastIndexOf(".") > 0 ? tempHref.lastIndexOf(".") : tempHref.length()) ;
		if (tempHref.contains(".js")) {
			alink.setFlag(3) ;
			alink.setType("text/javascript") ;
			return ;
		} else if (tempHref.contains(".jpg") || tempHref.contains(".png") || tempHref.contains(".gif")) {
			alink.setFlag(4) ;
			alink.setType("image") ;
			return ;
		} else if (tempHref.contains(".css")) {
			alink.setFlag(5) ;
			alink.setType("text/css") ;
			return ;
		} else if (tempHref.contains(".apk")) {
			alink.setFlag(5) ;
			alink.setType("application") ;
			return ;
		}
		
	}
	
}
