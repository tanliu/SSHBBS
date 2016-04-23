package com.bbs.action;

import com.bbs.utils.PageUtils;

/** 
 * ��Ŀ���ƣ�SHBBSf
 * �����ƣ�ManagerAction 
 * �������� �����Ϣ��ά��������һ��Action��ĳ��� ��
 * �����ˣ�̳��
 * ����ʱ�䣺2016��4��23�� ����9:17:58
 * �޸��ˣ�TanLiu 
 * �޸�ʱ�䣺2016��4��23�� ����9:17:58
 * �޸ı�ע�� 
 * @version 
 */ 
public abstract class ManagerAction<T> extends BaseAction<T> {
	
	protected PageUtils<T> pageUtils;//��ҳ����
	protected int currentPage;
	protected int pageSize;

	
	

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	/**
	 * ��������:�����б�
	 * @return
	 */
	public abstract String listUI();
	public int getCurrentPage() {
		return currentPage;
	}

	/**
	 * ��������:ɾ����Ϣ
	 * @return
	 */
	public abstract String delete();
	/**
	 * ��������:���б༭����
	 * @return
	 */
	public abstract String editorUI();
	/**
	 * ��������:�ύ�༭�����Ϣ
	 * @return
	 */
	public abstract String editor();
	/**
	 * ��������:ɾ��������Ϣ
	 * @return
	 */
	public abstract String deleteAll();
	/**
	 * ��������:������ӽ���
	 * @return
	 */
	public abstract String addUI();
	/**
	 * ��������:�ύ��Ӻ����Ϣ
	 * @return
	 */
	public abstract String add();
}
