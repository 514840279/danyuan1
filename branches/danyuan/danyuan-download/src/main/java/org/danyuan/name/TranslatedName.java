package org.danyuan.name ;

import java.util.Date ;
import java.util.List ;

import org.danyuan.utils.Constant ;
import org.danyuan.utils.hanlp.TranslatedNameRecognition ;
import org.danyuan.utils.hibernate.HibernateBase ;
import org.danyuan.utils.po.name.Translated ;
import org.hibernate.Session ;

/**    
*  文件名 ： TranslatedName.java  
*  包    名 ： org.danyuan.name  
*  描    述 ： TODO(用一句话描述该文件做什么)  
*  作    者 ： Tenghui.Wang  
*  时    间 ： 2016年4月4日 下午4:07:12  
*  版    本 ： V1.0    
*/
public class TranslatedName {
	
	public TranslatedName(String[] str,String from) {
		List<String> list = TranslatedNameRecognition.TranslatedName(str) ;
		
		for (String string : list) {
			if (string != null && !"".equals(string)) {
				HibernateBase hibernate = new HibernateBase(Constant.name) ;
				Session session = hibernate.getSession() ;
				Translated translated = new Translated() ;
				translated.setInsertDatetime(new Date()) ;
				translated.setName(string) ;
				translated.setOrigin(from) ;
				translated.setUpdateDatetime(new Date()) ;
				session.saveOrUpdate(translated) ;
				hibernate.destroy() ;
			}
		}
		
	}
}
