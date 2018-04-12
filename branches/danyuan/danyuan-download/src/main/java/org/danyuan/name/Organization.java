package org.danyuan.name ;

import java.util.Date ;
import java.util.List ;

import org.danyuan.utils.Constant ;
import org.danyuan.utils.hanlp.OrganizationRecognition ;
import org.danyuan.utils.hibernate.HibernateBase ;
import org.hibernate.Session ;

/**    
*  文件名 ： Organization.java  
*  包    名 ： org.danyuan.name  
*  描    述 ： TODO(用一句话描述该文件做什么)  
*  作    者 ： Tenghui.Wang  
*  时    间 ： 2016年4月4日 下午4:08:09  
*  版    本 ： V1.0    
*/
public class Organization {
	
	public Organization(String[] str,String from) {
		List<String> list = OrganizationRecognition.Organization(str) ;
		for (String string : list) {
			if (string != null && !"".equals(string)) {
				HibernateBase hibernate = new HibernateBase(Constant.name) ;
				Session session = hibernate.getSession() ;
				org.danyuan.utils.po.name.Organization organization = new org.danyuan.utils.po.name.Organization() ;
				organization.setInsertDatetime(new Date()) ;
				organization.setName(string) ;
				organization.setOrigin(from) ;
				organization.setUpdateDatetime(new Date()) ;
				session.saveOrUpdate(organization) ;
				hibernate.destroy() ;
			}
		}
	}
}
