package com.bbs.dao;

import java.io.Serializable;
import java.util.List;

import com.bbs.utils.PageUtils;
import com.bbs.utils.QueryUtils;



/** 
 * ��Ŀ���ƣ�SHBBSf
 * �����ƣ�BaseDao 
 * �������� Dao��Ļ���ӿ�
 * �����ˣ�̳��
 * ����ʱ�䣺2016��4��23�� ����10:03:21
 * �޸��ˣ�TanLiu 
 * �޸�ʱ�䣺2016��4��23�� ����10:03:21
 * �޸ı�ע�� 
 * @version 
 */ 
public interface BaseDao<T> {
	//����
	public void  save(T entity);
	//����
	public void update(T entity);
	//ɾ��
	public void deleteObjectByIds(Serializable... ids);
	public T findObjectByIds(Serializable id);
	
	//�ֲ�����
	public PageUtils<T> getPageResult(QueryUtils queryUtils, int pageNO,
			int pageSize);
	
	
	

}
