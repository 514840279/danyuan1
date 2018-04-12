package org.danyuan.name ;

import java.util.Date ;
import java.util.List ;

import org.danyuan.utils.Constant ;
import org.danyuan.utils.hanlp.ChineseNameRecognition ;
import org.danyuan.utils.hibernate.HibernateBase ;
import org.danyuan.utils.po.name.Chinese ;
import org.hibernate.Session ;

/**    
*  文件名 ： ChineseName.java  
*  包    名 ： org.danyuan.name  
*  描    述 ： TODO(用一句话描述该文件做什么)  
*  作    者 ： Tenghui.Wang  
*  时    间 ： 2016年4月4日 下午4:07:38  
*  版    本 ： V1.0    
*/
public class ChineseName {
	
	public ChineseName(String[] str,String from) {
		List<String> list = ChineseNameRecognition.ChineseName(str) ;
		for (String string : list) {
			if (string != null && !"".equals(string)) {
				HibernateBase hibernate = new HibernateBase(Constant.name) ;
				Session session = hibernate.getSession() ;
				Chinese chinese = new Chinese() ;
				chinese.setInsertDatetime(new Date()) ;
				chinese.setName(string) ;
				chinese.setOrigin(from) ;
				chinese.setUpdateDatetime(new Date()) ;
				session.saveOrUpdate(chinese) ;
				hibernate.destroy() ;
			}
		}
		
	}
	
}
