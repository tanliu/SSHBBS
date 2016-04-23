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
 * 项目名称：SHBBSf
 * 类名称：ManagerBlogServicesImpl 
 * 类描述： 管理博客的Services层
 * 创建人：坛子
 * 创建时间：2016年4月23日 下午10:24:30
 * 修改人：TanLiu 
 * 修改时间：2016年4月23日 下午10:24:30
 * 修改备注： 
 * @version 
 */ 
public class ManagerBlogServicesImpl extends BaseServicesImpl<Blog> implements
		ManagerBlogServices {
	
	static ManagerBlogDao managerBlogDao=new ManagerBlogDaoImpl();
	public ManagerBlogServicesImpl() {
		super(managerBlogDao);
	}


}
