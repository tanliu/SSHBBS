package com.bbs;

import java.util.Date;

import com.bbs.dao.BaseDao;
import com.bbs.dao.BaseDaoImpl;
import com.bbs.dao.managerblog.ManagerBlogDao;
import com.bbs.dao.managerblog.impl.ManagerBlogDaoImpl;
import com.bbs.entity.blog.Blog;
import com.bbs.utils.PageUtils;
import com.bbs.utils.QueryUtils;





public class Test {


	public static void main(String[] agrs){
		
		
		 QueryUtils queryUtils=new QueryUtils(Blog.class, "b");
		 
		
		 ManagerBlogDao baseDao=new ManagerBlogDaoImpl();
		 
		 PageUtils<Blog> pageUtils1=baseDao.getPageResult(queryUtils, 0, 3);
		 
         Blog  blog1=new Blog();
         blog1.setId("1");
         blog1.setTime(new Date());
         blog1.setTitle("-��ɿɿ��鯿ɿ�����");
         blog1.setContent("����");
         blog1.setUseId("6666");
         baseDao.update(blog1);
         PageUtils<Blog> pageUtils2=baseDao.getPageResult(queryUtils, 0, 3);
         int i=1;
	}
}
