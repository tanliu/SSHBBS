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
 * ��Ŀ���ƣ�Electricity
 * �����ƣ�BaseDaoImpl 
 * �������� Dao��������ݵķ�װ
 * �����ˣ�̳��
 * ����ʱ�䣺2016��4��6�� ����2:55:13
 * �޸��ˣ�TanLiu 
 * �޸�ʱ�䣺2016��4��6�� ����2:55:13
 * �޸ı�ע�� 
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
				//�Ȳ�ѯ
				Object entity = this.findObjectByIds(id);
				//��ɾ��
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
		
		//�жϲ�ѯ�����Ƿ�Ϊ��
		if(queryUtils!=null){
			//��ͨ������ѯһ������
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
			//���÷�ҳ
			if(pageNO<1)pageNO=1;
			query.setFirstResult((pageNO-1)*pageSize);
			query.setMaxResults(pageSize);
			//��ȡ��ҳ�������
			List<T> items=query.list();
			
			//��ȡ�ܼ�¼��
			Query countquery=getSession().createQuery(queryUtils.getQueryCountHql());		
			if(parameters!=null&&parameters.size()>0){
				int i=0;
				for(Object object:parameters){
					countquery.setParameter(i++, object);
				}
			}
			
			//��ȡ��ҳ��
			long totalCount=(Long) countquery.uniqueResult();
			//����һ���ֲ�����
			return new PageUtils(totalCount,pageNO, pageSize, items);
			
			
		}
		
		
		
		
		return null;
	}

}
