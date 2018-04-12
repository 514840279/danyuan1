package org.danyuan.download.service ;

import java.io.IOException ;
import java.io.InputStreamReader ;
import java.io.UnsupportedEncodingException ;
import java.net.MalformedURLException ;
import java.net.URL ;
import java.net.URLConnection ;
import java.sql.Connection ;
import java.sql.PreparedStatement ;
import java.sql.SQLException ;
import java.util.Date ;
import java.util.List ;
import java.util.Map ;
import java.util.Set ;
import java.util.UUID ;

import org.apache.commons.io.IOUtils ;
import org.apache.http.HttpResponse ;
import org.apache.http.client.ClientProtocolException ;
import org.apache.http.client.methods.HttpGet ;
import org.apache.http.impl.client.CloseableHttpClient ;
import org.apache.http.impl.client.HttpClientBuilder ;
import org.apache.http.util.EntityUtils ;
import org.danyuan.utils.Constant ;
import org.danyuan.utils.db.MySQLDBUtils ;
import org.danyuan.utils.hibernate.HibernateBase ;
import org.danyuan.utils.httpsdownload.AutoGetHtml ;
import org.danyuan.utils.httpsdownload.PostTest ;
import org.danyuan.utils.po.down.BootUrl ;
import org.hibernate.Query ;
import org.hibernate.Session ;
import org.jsoup.Jsoup ;
import org.jsoup.nodes.Document ;
import org.jsoup.nodes.Element ;
import org.jsoup.select.Elements ;

/**    
*  文件名 ： HtmlBody.java   
*  包    名 ： org.danyuan.utils.httpsdownload  
*  描    述 ： TODO(用一句话描述该文件做什么)  
*  作    者 ： Tenghui.Wang  
*  时    间 ： 2016年1月1日 下午5:46:25  
*  版    本 ： V1.0    
*/
public class HtmlBody {
	
	@SuppressWarnings("deprecation")
	public static String getHtml(String host, String url, String key, String cookie) throws Exception {
		String body = "" ;
		
		HttpClientBuilder httpclientbuilder = HttpClientBuilder.create() ;
		CloseableHttpClient closeablehttpclient = httpclientbuilder.build() ;
		HttpGet httpget = getHttpGet(url, key) ;
		if (httpget == null) {
			
		} else {
			//		httpget = new HttpGet(url + key);
			httpget.addHeader("Host", host) ;
			httpget.addHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/42.0.2311.154 Safari/537.36 LBBROWSER") ;
			httpget.addHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8好。") ;
			httpget.addHeader("Accept-Language", "zh-CN,zh;q=0.8") ;
			httpget.addHeader("Accept-Encoding", "gzip, deflate, sdch") ;
			httpget.addHeader("Cache-Control", "max-age=0") ;
			httpget.addHeader("Connection", "keep-alive") ;
			httpget.addHeader("Referer", "https://www.baidu.com/") ;
			httpget.addHeader("Cookie", "lzstat_uv=30450751412391972092|2412526; bdshare_firstime=1462375744756; BDTUJIAID=78310b8d2d031a594a5be505e17ccde9; Hm_lvt_a63926a56d6d785602fba106dcc5fb08=1462470301,1462704145,1462709176,1462724331; Hm_lpvt_a63926a56d6d785602fba106dcc5fb08=1462724331") ;
			httpget.addHeader("If-Modified-Since", "Sun, 08 May 2016 13:19:07 GMThi。") ;
			httpget.addHeader("If-None-Match", "W/\"f24695332ca9d11:2e3\"") ;
			try {
				
				HttpResponse httpresponse = closeablehttpclient.execute(httpget) ;
				//			GzipDecompressingEntity zipRes = new GzipDecompressingEntity(httpresponse.getEntity());
				//			String s = EntityUtils.toString(zipRes, "gb2312");
				// int status = httpresponse.getStatusLine().getStatusCode();
				String code = getCharset(host) ;
				
				if (code == null || "".equals(code)) {
					org.apache.http.Header[] head = httpresponse.getHeaders("Content-Type") ;
					if (head != null && head.length > 0) {
						code = head[0].getValue().toString() ;
						
						// 使用响应头获取编码格式
						if (code.contains("charset")) {
							code = code.substring(code.indexOf("charset") + 8).replace(";", "") ;
							body = IOUtils.toString(new InputStreamReader(httpresponse.getEntity().getContent(), code)) ;
							setCharset(host, code) ;
						} else {
							String charset = null ;
							// 使用 meta 获取编码格式
							body = EntityUtils.toString(httpresponse.getEntity()) ;
							if (body == null || "".equals(body)) {
								body = AutoGetHtml.getBody(url, key) ;
							}
							body = autogetcharset(host, body, code, charset, "iso-8859-1") ;
						}
					}
				} else {
					body = IOUtils.toString(new InputStreamReader(httpresponse.getEntity().getContent(), code)) ;
				}
				
			} catch (ClientProtocolException e) {
				e.printStackTrace() ;
			} catch (IOException e) {
				body = PostTest.main1(url) ;
				body = autogetcharset(host, body, "", "", "utf8") ;
			}
		}
		return body ;
	}
	
	/**  
	*  方法名： autogetcharset  
	*  功    能： TODO(这里用一句话描述这个方法的作用)  
	*  参    数： @param host
	*  参    数： @param body
	*  参    数： @param code
	*  参    数： @param charset
	*  参    数： @return
	*  参    数： @throws UnsupportedEncodingException 
	*  返    回： String  
	*  作    者 ： Tenghui.Wang  
	*  @throws  
	*/
	private static String autogetcharset(String host, String body, String code, String charset, String bytesset) throws UnsupportedEncodingException {
		try {
			Document doc = Jsoup.parse(body) ;
			Elements media = doc.select("meta") ;
			boolean flag = false ;
			for (Element element : media) {
				charset = element.attr("content") ;
				if (charset.contains("charset")) {
					code = charset.substring(charset.lastIndexOf("charset") + 8).replace(";", "") ;
					body = new String(body.getBytes(bytesset), code) ;
					flag = true ;
					break ;
				}
			}
			if (flag && charset != null && !"".equals(charset)) {
				body = new String(body.getBytes(bytesset), code) ;
				setCharset(host, code) ;
			} else {
				// 尝试自适应
			}
		} catch (Exception e) {
			
		}
		return body ;
	}
	
	/**  
	*  方法名： setCharset  
	*  功    能： TODO(这里用一句话描述这个方法的作用)  
	*  参    数： @param host
	*  参    数： @param code 
	*  返    回： void  
	*  作    者 ： Tenghui.Wang  
	*  @throws  
	*/
	private static void setCharset(String host, String code) {
		String hql = "update BootUrl b set charset = :code where b.bootUrl =:host " ;
		HibernateBase hibernate = new HibernateBase(Constant.danyuan) ;
		Session session = hibernate.getSession() ;
		Query query = session.createQuery(hql) ;
		query.setParameter("code", code) ;
		query.setParameter("host", host) ;
		query.executeUpdate() ;
		hibernate.destroy() ;
	}
	
	/**  
	*  方法名： getCharset  
	*  功    能： TODO(这里用一句话描述这个方法的作用)  
	*  参    数： @param host
	*  参    数： @return 
	*  返    回： String  
	*  作    者 ： Tenghui.Wang  
	*  @throws  
	*/
	private static String getCharset(String host) {
		String charset = null ;
		String hql = "select charset from BootUrl b where b.bootUrl =:host " ;
		HibernateBase hibernate = new HibernateBase(Constant.danyuan) ;
		Session session = hibernate.getSession() ;
		Query query = session.createQuery(hql) ;
		query.setParameter("host", host) ;
		charset = (String) query.uniqueResult() ;
		hibernate.destroy() ;
		return charset ;
	}
	
	/**
	 * @throws Exception 
	 * @throws IOException 
	 * @throws MalformedURLException   
	*  方法名： getHttpGet  
	*  功    能： TODO(这里用一句话描述这个方法的作用)  
	*  参    数： @param url
	*  参    数： @param key
	*  参    数： @return 
	*  返    回： HttpGet  
	*  作    者 ： Tenghui.Wang  
	*  @throws  
	*/
	private static HttpGet getHttpGet(String path, String keyword) throws Exception {
		
		String bootUuid = getBootUrlUuid(path) ;
		HttpGet httpGet = getHttpGetFormDb(path, bootUuid, keyword) ;
		
		return httpGet ;
		
	}
	
	/**  
	*  方法名： getHttpGetFormDb  
	*  功    能： TODO(这里用一句话描述这个方法的作用)  
	*  参    数： @param bootUuid
	*  参    数： @return 
	*  返    回： HttpGet  
	*  作    者 ： Tenghui.Wang  
	*  @throws  
	*/
	private static HttpGet getHttpGetFormDb(String url, String bootUuid, String keyword) {
		//		HibernateBase hibernate = new HibernateBase();
		//		Session session = hibernate.getSession();
		//		Query query = session.createQuery("from org.danyuan.utils.po.down.Header h where h.bootUrlUuid = :bootUuid and h.head = 'request'");
		//		query.setParameter("bootUuid", bootUuid);
		//		List<org.danyuan.utils.po.down.Header> list = (List<org.danyuan.utils.po.down.Header>) query.list();
		HttpGet httpGet = null ;
		try {
			httpGet = new HttpGet(url + keyword) ;
		} catch (IllegalArgumentException e) {
			try {
				updateAlink(url) ;
			} catch (SQLException e1) {
			}
			return httpGet ;
		}
		//		for (org.danyuan.utils.po.down.Header header : list) {
		//			httpGet.addHeader(header.getKey(), header.getValue());
		//		}
		return httpGet ;
	}
	
	/**
	 * @throws SQLException   
	*  方法名： updateAlink  
	*  功    能： TODO(这里用一句话描述这个方法的作用)  
	*  参    数： @param url 
	*  返    回： void  
	*  作    者 ： Tenghui.Wang  
	*  @throws  
	*/
	private static void updateAlink(String url) throws SQLException {
		String sql = "update xuexi111 set flag = -1 where href = ?" ;
		Connection conn = MySQLDBUtils.getConnection() ;
		PreparedStatement pstat = conn.prepareStatement(sql) ;
		pstat.setString(1, url) ;
		pstat.executeUpdate() ;
		conn.close() ;
		
	}
	
	/**
	 * @throws Exception   
	*  方法名： getBootUrlUuid  
	*  功    能： TODO(这里用一句话描述这个方法的作用)  
	*  参    数： @param bootUrl
	*  参    数： @return 
	*  返    回： String  
	*  作    者 ： Tenghui.Wang  
	*  @throws  
	*/
	private static String getBootUrlUuid(String path) throws Exception {
		String result = null ;
		String urlhead = "" ;
		if (path.contains("http://")) {
			urlhead = "http://" ;
		} else if (path.contains("https://")) {
			urlhead = "https://" ;
		} else if (path.contains("http:/")) {
			urlhead = "http:/" ;
		} else if (path.contains("http:/")) {
			urlhead = "http:/" ;
		} else if (path.contains("@")) {
			// 插入邮箱数据库
			return result ;
		} else {
			throw new Exception("不是标准URL:" + path) ;
		}
		String bootUrl = path.replace(urlhead, "") ;
		bootUrl = urlhead + bootUrl.substring(0, bootUrl.indexOf("/") > 0 ? bootUrl.indexOf("/") : bootUrl.length()) ;
		HibernateBase hibernate = new HibernateBase(Constant.danyuan) ;
		Session session = hibernate.getSession() ;
		Query query = session.createQuery("from org.danyuan.utils.po.down.BootUrl b where b.bootUrl =:bootUrl") ;
		query.setParameter("bootUrl", bootUrl) ;
		BootUrl boot = (BootUrl) query.uniqueResult() ;
		hibernate.destroy() ;
		if (boot != null) {
			result = boot.getUuid() ;
			if (result == null) {
				result = UUID.randomUUID().toString().replace("-", "") ;
				insertBootUrl(result, bootUrl) ;
			}
		} else {
			result = UUID.randomUUID().toString().replace("-", "") ;
			insertBootUrl(result, bootUrl) ;
		}
		
		return result ;
	}
	
	/**
	 * @throws IOException 
	 * @throws MalformedURLException   
	*  方法名： insertBootUrl  
	*  功    能： TODO(这里用一句话描述这个方法的作用)  
	*  参    数： @param result
	*  参    数： @param bootUrl 
	*  返    回： void  
	*  作    者 ： Tenghui.Wang  
	*  @throws  
	*/
	private static void insertBootUrl(String result, String bootUrl) throws IOException {
		HibernateBase hibernate = new HibernateBase(Constant.danyuan) ;
		Session session = hibernate.getSession() ;
		BootUrl boot = new BootUrl(result, bootUrl) ;
		System.out.println(boot.toString()) ;
		session.save(boot) ;
		session.getTransaction().commit() ;
		session.beginTransaction() ;
		//		insertResponseHead(result, bootUrl, session);
		insertRequestHead(result, bootUrl, session) ;
		hibernate.destroy() ;
	}
	
	/**  
	*  方法名： insertRequestHead  
	*  功    能： TODO(这里用一句话描述这个方法的作用)  
	*  参    数： @param result
	*  参    数： @param bootUrl
	*  参    数： @param session 
	*  返    回： void  
	*  作    者 ： Tenghui.Wang  
	*  @throws  
	*/
	private static void insertRequestHead(String result, String bootUrl, Session session) {
		
		//		for (String key : keys) {
		//			String uuid = UUID.randomUUID().toString().replace("-", "");
		//			String val = conn.getHeaderField(key);
		//			header = new org.danyuan.utils.po.down.Header(uuid, result, key, val, "request", new Date(), new Date());
		//			System.out.println(header.toString());
		//			session.save(header);
		//		}
	}
	
	/**  
	*  方法名： insertResponseHead  
	*  功    能： TODO(这里用一句话描述这个方法的作用)  
	*  参    数： @param result
	*  参    数： @param bootUrl
	*  参    数： @param session
	*  参    数： @throws MalformedURLException
	*  参    数： @throws IOException 
	*  返    回： void  
	*  作    者 ： Tenghui.Wang  
	*  @throws  
	*/
	private static void insertResponseHead(String result, String bootUrl, Session session) throws MalformedURLException, IOException {
		URL url = new URL(bootUrl) ;
		URLConnection conn = url.openConnection() ;
		Map<String, List<String>> headers = conn.getHeaderFields() ;
		Set<String> keys = headers.keySet() ;
		org.danyuan.utils.po.down.Header header = null ;
		for (String key : keys) {
			String uuid = UUID.randomUUID().toString().replace("-", "") ;
			String val = conn.getHeaderField(key) ;
			header = new org.danyuan.utils.po.down.Header(uuid, result, key, val, "reponse", new Date(), new Date()) ;
			System.out.println(header.toString()) ;
			session.save(header) ;
		}
	}
	
}
