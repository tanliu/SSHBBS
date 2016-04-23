package com.bbs.services;

import java.io.Serializable;
import java.util.List;


import com.bbs.utils.PageUtils;
import com.bbs.utils.QueryUtils;

/** 
 * ��Ŀ���ƣ�SHBBSf
 * �����ƣ�BaseServices 
 * �������� Services������ӿ�
 * �����ˣ�̳��
 * ����ʱ�䣺2016��4��23�� ����10:02:27
 * �޸��ˣ�TanLiu 
 * �޸�ʱ�䣺2016��4��23�� ����10:02:27
 * �޸ı�ע�� 
 * @version 
 */ 
public interface BaseServices<T> {

	// ����
	public void save(T entity);

	// ����
	public void update(T entity);

	// ɾ��
	public void deleteObjectByIds(Serializable... ids);


    //�ֲ�����
	public PageUtils<T> getPageResult(QueryUtils queryUtils, int pageNO,
			int pageSize);

	
	/**
	 * ��������:��id���ҵ�����
	 * @param id
	 * @return
	 */
	public T findObjectByIds(Serializable id);

}
