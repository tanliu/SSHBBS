package com.bbs.services;

import java.io.Serializable;
import java.util.List;


import com.bbs.utils.PageUtils;
import com.bbs.utils.QueryUtils;

/** 
 * 项目名称：SHBBSf
 * 类名称：BaseServices 
 * 类描述： Services层基础接口
 * 创建人：坛子
 * 创建时间：2016年4月23日 下午10:02:27
 * 修改人：TanLiu 
 * 修改时间：2016年4月23日 下午10:02:27
 * 修改备注： 
 * @version 
 */ 
public interface BaseServices<T> {

	// 增加
	public void save(T entity);

	// 更新
	public void update(T entity);

	// 删除
	public void deleteObjectByIds(Serializable... ids);


    //分布查找
	public PageUtils<T> getPageResult(QueryUtils queryUtils, int pageNO,
			int pageSize);

	
	/**
	 * 方法描述:能id查找到对象
	 * @param id
	 * @return
	 */
	public T findObjectByIds(Serializable id);

}
