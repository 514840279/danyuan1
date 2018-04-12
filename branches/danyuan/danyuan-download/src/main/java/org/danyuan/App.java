package org.danyuan ;

import java.util.List ;
import java.util.concurrent.ScheduledExecutorService ;

import org.danyuan.name.ChineseName ;
import org.danyuan.name.JapaneseName ;
import org.danyuan.name.Organization ;
import org.danyuan.name.TranslatedName ;
import org.danyuan.utils.concurrent.ThreadPoolUtils ;
import org.danyuan.utils.files.TxtFilesReader ;
import org.danyuan.utils.string.StringUtils ;

/**
 * Hello world!
 *
 */
public class App {
	
	public static void main(String[] args) {
		String path = System.getProperty("user.dir") + "/filter.txt" ;
		List<String> strlist = TxtFilesReader.readFileByLines(path) ;
		ScheduledExecutorService thread = ThreadPoolUtils.getScheduledThreadPool(10) ;
		for (String str : strlist) {
			ThreadPoolUtils.excuteScheduled(thread, "org.danyuan.App", "getThread", str) ;
		}
	}
	
	/**  
	*  方法名： getThread  
	*  功    能： TODO(这里用一句话描述这个方法的作用)  
	*  参    数： @param strlist 
	*  返    回： void  
	*  作    者 ： Tenghui.Wang  
	*  @throws  
	*/
	public synchronized static void getThread(String str) {
		
		if (str != null && !"".equals(str)) {
			String content = TxtFilesReader.readToString(str, "UTF-8") ;
			while (content.length() > 100) {
				String temp = content.substring(0, content.length() > 1000 ? 100 : content.length()) ;
				content = content.substring(content.length() > 1000 ? 990 : content.length()) ;
				String[] strarry = StringUtils.getSplitArray(temp) ;
				
				for (int i = 0; i < strarry.length; i++) {
					
					new ChineseName(strarry, str) ;
					new JapaneseName(strarry, str) ;
					new Organization(strarry, str) ;
					new TranslatedName(strarry, str) ;
				}
			}
		} else {
			
		}
		System.gc() ;
	}
	
}
