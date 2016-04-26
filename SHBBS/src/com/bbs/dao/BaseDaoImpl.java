/**
 * 
 */
package com.bbs.dao;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


import com.bbs.utils.HibernateUtils;
import com.bbs.utils.PageUtils;
import com.bbs.utils.QueryUtils;
import com.bbs.utils.TUtils;


/** 
 * 项目名称：Electricity
 * 类名称：BaseDaoImpl 
 * 类描述： Dao层基本数据的封装
 * 创建人：坛子
 * 创建时间：2016年4月6日 下午2:55:13
 * 修改人：TanLiu 
 * 修改时间：2016年4月6日 下午2:55:13
 * 修改备注： 
 * @version 
 */
public class BaseDaoImpl<T> extends HibernateUtils  implements BaseDao<T>  {
	
	Class entityClass=TUtils.getActualType(this.getClass());  
	
	
	
	@Override
	public void save(T entity) {
		
		Session session=getSession();
		Transaction tx=session.beginTransaction();
		session.save(entity);
		tx.commit();
		session.close();
		
		
	}

	@Override
	public void update(T entity) {
		Session session=getSession();
		Transaction tx=session.beginTransaction();
		session.update(entity);
		tx.commit();
		session.close();
	}

	@Override
	public void deleteObjectByIds(Serializable... ids) {
		
		Session session=getSession();
		Transaction tx=session.beginTransaction();
        if(ids!=null){
        	for (Serializable id : ids) {
        		Object entity=this.findObjectByIds(id);
				session.delete(entity);
			}
        }
		tx.commit();
		session.close();
	}



	@Override
	public T findObjectByIds(Serializable id) {
		T entity=null;
		Session session=getSession();
		Transaction tx=session.beginTransaction();
		entity=(T) session.get(entityClass, id);
		tx.commit();
		session.close();
		
		return entity;
	}


	@Override
	public PageUtils<T> getPageResult(QueryUtils queryUtils, int pageNO,
			int pageSize) {
		
		Session session=getSession();
		Transaction tx=session.beginTransaction();
		Query query=getSession().createQuery(queryUtils.getQueryHql());
		List<Object> parameters=queryUtils.getParams();
		if(parameters!=null&&parameters.size()>0){
			int i=0;
			for(Object object:parameters){
				query.setParameter(i++, object);
			}
		}
		if(pageNO<1)pageNO=1;
		query.setFirstResult((pageNO-1)*pageSize);
		query.setMaxResults(pageSize);
		List items=query.list();
		
		Query countquery=getSession().createQuery(queryUtils.getQueryCountHql());		
		if(parameters!=null&&parameters.size()>0){
			int i=0;
			for(Object object:parameters){
				countquery.setParameter(i++, object);
			}
		}
		long totalCount=(Long) countquery.uniqueResult();
		tx.commit();
		session.close();

		return new PageUtils(totalCount, pageNO, pageSize, items);
	}

}
