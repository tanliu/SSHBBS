package com.bbs.services.managerblog.impl;

import java.io.Serializable;

import com.bbs.dao.managerblog.ManagerBlogDao;
import com.bbs.dao.managerblog.impl.ManagerBlogDaoImpl;
import com.bbs.entity.blog.Blog;
import com.bbs.services.BaseServicesImpl;
import com.bbs.services.managerblog.ManagerBlogServices;
import com.bbs.utils.PageUtils;
import com.bbs.utils.QueryUtils;

/** 
 * ��Ŀ���ƣ�SHBBSf
 * �����ƣ�ManagerBlogServicesImpl 
 * �������� �����͵�Services��
 * �����ˣ�̳��
 * ����ʱ�䣺2016��4��23�� ����10:24:30
 * �޸��ˣ�TanLiu 
 * �޸�ʱ�䣺2016��4��23�� ����10:24:30
 * �޸ı�ע�� 
 * @version 
 */ 
public class ManagerBlogServicesImpl extends BaseServicesImpl<Blog> implements
		ManagerBlogServices {
	
	static ManagerBlogDao managerBlogDao=new ManagerBlogDaoImpl();
	public ManagerBlogServicesImpl() {
		super(managerBlogDao);
	}


}
