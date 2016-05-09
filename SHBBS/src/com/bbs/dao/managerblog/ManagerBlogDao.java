package com.bbs.dao.managerblog;


import com.bbs.dao.BaseDao;
import com.bbs.entity.blog.Blog;


public interface ManagerBlogDao extends BaseDao<Blog> {
	public static final String DAO_NAME="com.bbs.dao.managerblog.impl.ManagerBlogDaoImpl";

}
