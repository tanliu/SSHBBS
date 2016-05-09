package com.bbs.services.managerblog.impl;

import java.io.Serializable;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

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

@Service(value=ManagerBlogServices.SERVICE_NAME)
public class ManagerBlogServicesImpl extends BaseServicesImpl<Blog> implements
		ManagerBlogServices {
	
	ManagerBlogDao managerBlogDao;
	
	@Resource(name=ManagerBlogDao.DAO_NAME)
	public void setManagerBlogDao(ManagerBlogDao managerBlogDao) {
		super.setBaseDao(managerBlogDao);
		this.managerBlogDao = managerBlogDao;
		
	}


}
