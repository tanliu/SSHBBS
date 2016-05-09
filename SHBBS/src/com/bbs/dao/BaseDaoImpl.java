/**
 * 
 */
package com.bbs.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

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
public class BaseDaoImpl<T> extends HibernateDaoSupport  implements BaseDao<T>  {
	
	Class entityClass;
	
	@Resource(name="sessionFactory")
	public void setDi(SessionFactory sessionFactory){
		this.setSessionFactory(sessionFactory);
	}
	
	public BaseDaoImpl(){
		ParameterizedType parameterizedType=(ParameterizedType) this.getClass().getGenericSuperclass();
		entityClass=(Class) parameterizedType.getActualTypeArguments()[0];
	}
	
	@Override
	public void save(T entity) {
		getHibernateTemplate().save(entity);
	}

	@Override
	public void update(T entity) {
		getHibernateTemplate().update(entity);
	}

	@Override
	public void deleteObjectByIds(Serializable... ids) {
		if(ids!=null && ids.length>0){
			for(Serializable id:ids){
				//先查询
				Object entity = this.findObjectByIds(id);
				//再删除
				this.getHibernateTemplate().delete(entity);
			}
		}

		
	}



	@Override
	public T findObjectByIds(Serializable id) {
		return (T) getHibernateTemplate().get(entityClass, id);
	}


	@Override
	public PageUtils<T> getPageResult(QueryUtils queryUtils, int pageNO,
			int pageSize) {
		
		//判断查询工具是否为空
		if(queryUtils!=null){
			//先通过语句查询一个集合
			Query query=getSession().createQuery(queryUtils.getQueryHql());
			List<Object> parameters=queryUtils.getParams();
			if(parameters!=null){
				int i=0;
				for (Object param :parameters) {
					for(Object object:parameters){
						query.setParameter(i++, object);
					}
				}
			}
			//设置分页
			if(pageNO<1)pageNO=1;
			query.setFirstResult((pageNO-1)*pageSize);
			query.setMaxResults(pageSize);
			//获取分页后的数据
			List<T> items=query.list();
			
			//获取总记录数
			Query countquery=getSession().createQuery(queryUtils.getQueryCountHql());		
			if(parameters!=null&&parameters.size()>0){
				int i=0;
				for(Object object:parameters){
					countquery.setParameter(i++, object);
				}
			}
			
			//获取总页数
			long totalCount=(Long) countquery.uniqueResult();
			//返回一个分布工具
			return new PageUtils(totalCount,pageNO, pageSize, items);
			
			
		}
		
		
		
		
		return null;
	}

}
