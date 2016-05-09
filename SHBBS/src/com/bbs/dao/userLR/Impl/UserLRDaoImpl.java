package com.bbs.dao.userLR.Impl;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.Date;



import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;




import com.bbs.dao.BaseDaoImpl;
import com.bbs.dao.userLR.UserLRDao;
import com.bbs.entity.user.User1;


public class UserLRDaoImpl extends BaseDaoImpl<User1> implements UserLRDao{
	private static final String Uname = null;
	Configuration cfg=new Configuration().configure();
	SessionFactory sessionFct=cfg.buildSessionFactory();
	Session session=sessionFct.openSession();
	Transaction tx=session.beginTransaction();


/**
 * ·½·¨ÃèÊö:×¢²á
 * @param u
 */
public void register(User1 u){
	save(u);
}

/* 
 * (non-Javadoc)
 * @see com.bbs.dao.userLR.UserLRDao#login(java.lang.String, java.lang.String)
 */
public User1 login(String username,String password) {
	
	User1 user=null;
	Query query=session.createQuery("from User1 u where u.username=? and u.password=? ");
	query.setParameter(0, username);
	query.setParameter(1, password);
	if(query.list().size()>0 && query.list()!=null){
	user=(User1) query.list().get(0);
	}
	return user;
}

}
