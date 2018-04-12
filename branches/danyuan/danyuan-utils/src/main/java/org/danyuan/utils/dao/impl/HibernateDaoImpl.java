package org.danyuan.utils.dao.impl;

import java.util.List;

import org.danyuan.utils.dao.HibernateDao ;
import org.danyuan.utils.session.hibernate.HibernateSession ;
import org.hibernate.Query;
import org.hibernate.Session;

/**    
*  文件名 ： HibernateDaoImpl.java  
*  包    名 ： org.eastone.utils.dao.impl  
*  描    述 ： TODO(用一句话描述该文件做什么)  
*  作    者 ： Tenghui.Wang  
*  时    间 ： 2016年2月21日 下午1:38:00  
*  版    本 ： V1.0    
*/
public class HibernateDaoImpl<T> implements HibernateDao<T> {
	
	/** 
	*  方法名 ： save
	*  功    能 ： TODO(这里用一句话描述这个方法的作用)  
	*  参    数 ： @param t
	*  参    数 ： @param hibernatePropertPath  
	*  参    考 ： @see org.eastone.utils.dao.HibernateDao#save(java.lang.Object, java.lang.String)  
	*  作    者 ： Tenghui.Wang  
	*/
	
	public void save(T t, String hibernatePropertPath) {
		HibernateSession hibernate = new HibernateSession(hibernatePropertPath);
		Session session = hibernate.getSession();
		session.save(t);
		hibernate.destroy();
		
	}
	
	/** 
	*  方法名 ： saveOrUpdate
	*  功    能 ： TODO(这里用一句话描述这个方法的作用)  
	*  参    数 ： @param t
	*  参    数 ： @param hibernatePropertPath  
	*  参    考 ： @see org.eastone.utils.dao.HibernateDao#saveOrUpdate(java.lang.Object, java.lang.String)  
	*  作    者 ： Tenghui.Wang  
	*/
	
	public void saveOrUpdate(T t, String hibernatePropertPath) {
		HibernateSession hibernate = new HibernateSession(hibernatePropertPath);
		Session session = hibernate.getSession();
		session.saveOrUpdate(t);
		hibernate.destroy();
		
	}
	
	/** 
	*  方法名 ： getObject
	*  功    能 ： TODO(这里用一句话描述这个方法的作用)  
	*  参    数 ： @param hql
	*  参    数 ： @param hibernatePropertPath
	*  参    数 ： @return  
	*  参    考 ： @see org.eastone.utils.dao.HibernateDao#getObject(java.lang.String, java.lang.String)  
	*  作    者 ： Tenghui.Wang  
	*/
	
	public List<T> getObject(String hql, String hibernatePropertPath) {
		HibernateSession hibernate = new HibernateSession(hibernatePropertPath);
		Session session = hibernate.getSession();
		Query query = session.createQuery(hql);
		@SuppressWarnings("unchecked")
		List<T> t = query.list();
		hibernate.destroy();
		return t;
	}
	
	/** 
	*  方法名 ： delete
	*  功    能 ： TODO(这里用一句话描述这个方法的作用)  
	*  参    数 ： @param t
	*  参    数 ： @param hibernatePropertPath
	*  参    数 ： @return  
	*  参    考 ： @see org.eastone.utils.dao.HibernateDao#delete(java.lang.Object, java.lang.String)  
	*  作    者 ： Tenghui.Wang  
	*/
	
	public void delete(T t, String hibernatePropertPath) {
		HibernateSession hibernate = new HibernateSession(hibernatePropertPath);
		Session session = hibernate.getSession();
		session.delete(t);
		hibernate.destroy();
	}
	
	/** 
	*  方法名 ： getUnionObject
	*  功    能 ： TODO(这里用一句话描述这个方法的作用)  
	*  参    数 ： @param hql
	*  参    数 ： @param hibernatePropertPath
	*  参    数 ： @return  
	*  参    考 ： @see org.eastone.utils.dao.HibernateDao#getUnionObject(java.lang.String, java.lang.String)  
	*  作    者 ： Tenghui.Wang  
	*/
	
	public T getUnionObject(String hql, String hibernatePropertPath) {
		HibernateSession hibernate = new HibernateSession(hibernatePropertPath);
		Session session = hibernate.getSession();
		Query query = session.createQuery(hql);
		@SuppressWarnings("unchecked")
		T t = (T) query.setMaxResults(1).uniqueResult();
		hibernate.destroy();
		return t;
	}
	
	/** 
	*  方法名 ： getUnionString
	*  功    能 ： TODO(这里用一句话描述这个方法的作用)  
	*  参    数 ： @param hql
	*  参    数 ： @param hibernatePropertPath
	*  参    数 ： @return  
	*  参    考 ： @see org.eastone.utils.dao.HibernateDao#getUnionString(java.lang.String, java.lang.String)  
	*  作    者 ： Tenghui.Wang  
	*/
	
	public Object UnionObject(String hql, String hibernatePropertPath) {
		HibernateSession hibernate = new HibernateSession(hibernatePropertPath);
		Session session = hibernate.getSession();
		Query query = session.createQuery(hql);
		Object str = (Object) query.setMaxResults(1).uniqueResult();
		hibernate.destroy();
		return str;
	}
	
	/** 
	*  方法名 ： update
	*  功    能 ： TODO(这里用一句话描述这个方法的作用)  
	*  参    数 ： @param hql
	*  参    数 ： @param hibernatePropertPath
	*  参    数 ： @return  
	*  参    考 ： @see org.eastone.utils.dao.HibernateDao#update(java.lang.String, java.lang.String)  
	*  作    者 ： Tenghui.Wang  
	*/
	
	public int update(String hql, String hibernatePropertPath) {
		HibernateSession hibernate = new HibernateSession(hibernatePropertPath);
		Session session = hibernate.getSession();
		Query query = session.createQuery(hql);
		int i = query.executeUpdate();
		hibernate.destroy();
		return i;
	}
	
	/** 
	*  方法名 ： delete
	*  功    能 ： TODO(这里用一句话描述这个方法的作用)  
	*  参    数 ： @param hql
	*  参    数 ： @param hibernatePropertPath  
	*  参    考 ： @see org.eastone.utils.dao.HibernateDao#delete(java.lang.String, java.lang.String)  
	*  作    者 ： Tenghui.Wang  
	*/
	
	public void delete(String hql, String hibernatePropertPath) {
		HibernateSession hibernate = new HibernateSession(hibernatePropertPath);
		Session session = hibernate.getSession();
		Query query = session.createQuery(hql);
		query.executeUpdate();
		hibernate.destroy();
	}
	
}
