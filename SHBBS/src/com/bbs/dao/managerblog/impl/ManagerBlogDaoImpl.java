package com.bbs.dao.managerblog.impl;


import org.springframework.stereotype.Repository;

import com.bbs.dao.BaseDaoImpl;
import com.bbs.dao.managerblog.ManagerBlogDao;
import com.bbs.entity.blog.Blog;

@Repository(value=ManagerBlogDao.DAO_NAME)
public class ManagerBlogDaoImpl extends BaseDaoImpl<Blog> implements
		ManagerBlogDao {



}
