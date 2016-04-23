package com.bbs.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/** 
 * ��Ŀ���ƣ�SHBBSf
 * �����ƣ�HibernateUtils 
 * �������� �������ݿ�Ĺ�����
 * �����ˣ�̳��
 * ����ʱ�䣺2016��4��23�� ����10:03:44
 * �޸��ˣ�TanLiu 
 * �޸�ʱ�䣺2016��4��23�� ����10:03:44
 * �޸ı�ע�� 
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
