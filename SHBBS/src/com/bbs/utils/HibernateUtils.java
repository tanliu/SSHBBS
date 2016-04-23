package com.bbs.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/** 
 * 项目名称：SHBBSf
 * 类名称：HibernateUtils 
 * 类描述： 操作数据库的工具类
 * 创建人：坛子
 * 创建时间：2016年4月23日 下午10:03:44
 * 修改人：TanLiu 
 * 修改时间：2016年4月23日 下午10:03:44
 * 修改备注： 
 * @version 
 */ 
public class HibernateUtils {
	public static SessionFactory sessionFactory;
	static{
		
		Configuration configuration = new Configuration();
		configuration.configure();
		sessionFactory = configuration.buildSessionFactory();
	}
	
	public Session getSession(){
		return sessionFactory.openSession();
	}
}
