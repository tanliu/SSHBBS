package com.bbs.services;

import java.io.Serializable;
import java.util.List;

import com.bbs.dao.BaseDao;
import com.bbs.utils.PageUtils;
import com.bbs.utils.QueryUtils;


/** 
 * 项目名称：SHBBSf
 * 类名称：BaseServicesImpl 
 * 类描述： Services层的实现BaserServices接口的基层类
 * 创建人：坛子
 * 创建时间：2016年4月23日 下午10:01:33
 * 修改人：TanLiu 
 * 修改时间：2016年4月23日 下午10:01:33
 * 修改备注： 
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
