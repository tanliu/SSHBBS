package com.bbs.services;

import java.io.Serializable;
import java.util.List;

import com.bbs.dao.BaseDao;
import com.bbs.utils.PageUtils;
import com.bbs.utils.QueryUtils;


/** 
 * ��Ŀ���ƣ�SHBBSf
 * �����ƣ�BaseServicesImpl 
 * �������� Services���ʵ��BaserServices�ӿڵĻ�����
 * �����ˣ�̳��
 * ����ʱ�䣺2016��4��23�� ����10:01:33
 * �޸��ˣ�TanLiu 
 * �޸�ʱ�䣺2016��4��23�� ����10:01:33
 * �޸ı�ע�� 
 * @version 
 */ 
public class BaseServicesImpl<T> implements BaseServices<T>  {
	
	private BaseDao<T> baseDao;
	
	public void setBaseDao(BaseDao<T> baseDao) {
		this.baseDao = baseDao;
	}


	@Override
	public void save(T entity) {
		baseDao.save(entity);
	}

	@Override
	public void update(T entity) {
		baseDao.update(entity);
	}

	@Override
	public void deleteObjectByIds(Serializable... ids) {
		baseDao.deleteObjectByIds(ids);
	}


	@Override
	public T findObjectByIds(Serializable id) {
		return baseDao.findObjectByIds(id);
	}

	@Override
	public PageUtils<T> getPageResult(QueryUtils queryUtils, int pageNO,
			int pageSize) {
		// TODO Auto-generated method stub
		return baseDao.getPageResult(queryUtils, pageNO, pageSize);
	}

}
