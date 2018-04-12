package org.danyuan.download.insertdb ;

import java.util.Date ;

import org.danyuan.utils.Constant ;
import org.danyuan.utils.hibernate.HibernateBase ;
import org.hibernate.Query ;
import org.hibernate.Session ;

/**    
*  文件名 ： UpdateData.java  
*  包    名 ： org.danyuan.download.insertdb  
*  描    述 ： TODO(用一句话描述该文件做什么)  
*  作    者 ： Tenghui.Wang  
*  时    间 ： 2016年3月23日 下午8:41:38  
*  版    本 ： V1.0    
*/
public class UpdateData<T> {
	
	/**  
	*  方法名： update  
	*  功    能： TODO(这里用一句话描述这个方法的作用)  
	*  参    数： @param uri 
	*  返    回： void  
	*  作    者 ： Tenghui.Wang  
	*  @throws  
	*/
	public static void update(String uri, int i, String hql) {
		HibernateBase hibernate = new HibernateBase(Constant.danyuan) ;
		Session session = hibernate.getSession() ;
		Query query = session.createQuery(hql + " x set x.flag=:flag,insert_date=:date where x.href = :href") ;
		query.setParameter("flag", i) ;
		query.setParameter("href", uri) ;
		query.setParameter("date", new Date()) ;
		query.executeUpdate() ;
		hibernate.destroy() ;
	}
	
	/**  
	*  方法名： writetodb  
	*  功    能： TODO(这里用一句话描述这个方法的作用)  
	*  参    数： @param alink 
	*  返    回： void  
	*  作    者 ： Tenghui.Wang  
	*  @throws  
	*/
	public void writetodb(T alink) {
		HibernateBase hibernate = new HibernateBase(Constant.danyuan) ;
		Session session = hibernate.getSession() ;
		
		session.save(alink) ;
		hibernate.destroy() ;
		
	}
	
	/**
	 * @throws SQLException   
	*  方法名： getlinkfromdb  
	*  功    能： TODO(这里用一句话描述这个方法的作用)  
	*  参    数： @return 
	*  返    回： String  
	*  作    者 ： Tenghui.Wang  
	*  @throws  
	*/
	public static String getlinkfromdb(String hql) {
		HibernateBase hibernate = new HibernateBase(Constant.danyuan) ;
		Session session = hibernate.getSession() ;
		String href = (String) session.createQuery(hql).setFirstResult(0).setMaxResults(1).uniqueResult() ;
		hibernate.destroy() ;
		return href ;
	}
}
