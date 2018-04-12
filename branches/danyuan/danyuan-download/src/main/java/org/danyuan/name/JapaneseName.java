package org.danyuan.name ;

import java.util.Date ;
import java.util.List ;

import org.danyuan.utils.Constant ;
import org.danyuan.utils.hanlp.JapaneseNameRecognition ;
import org.danyuan.utils.hibernate.HibernateBase ;
import org.danyuan.utils.po.name.Japanese ;
import org.hibernate.Session ;

/**    
*  文件名 ： JapaneseName.java  
*  包    名 ： org.danyuan.name  
*  描    述 ： TODO(用一句话描述该文件做什么)  
*  作    者 ： Tenghui.Wang  
*  时    间 ： 2016年4月4日 下午4:07:53  
*  版    本 ： V1.0    
*/
public class JapaneseName {
	
	public JapaneseName(String[] str,String from) {
		List<String> list = JapaneseNameRecognition.JapaneseName(str) ;
		
		for (String string : list) {
			if (string != null && !"".equals(string)) {
				HibernateBase hibernate = new HibernateBase(Constant.name) ;
				Session session = hibernate.getSession() ;
				Japanese japanese = new Japanese() ;
				japanese.setInsertDatetime(new Date()) ;
				japanese.setName(string) ;
				japanese.setOrigin(from) ;
				japanese.setUpdateDatetime(new Date()) ;
				session.saveOrUpdate(japanese) ;
				hibernate.destroy() ;
			}
		}
		
	}
}
