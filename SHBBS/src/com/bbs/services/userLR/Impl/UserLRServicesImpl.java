package com.bbs.services.userLR.Impl;



import java.io.Serializable;

import com.bbs.dao.userLR.UserLRDao;
import com.bbs.dao.userLR.Impl.UserLRDaoImpl;

import com.bbs.entity.user.User1;
import com.bbs.services.BaseServicesImpl;

import com.bbs.services.userLR.UserLRServices;

public class UserLRServicesImpl extends BaseServicesImpl<User1> implements
UserLRServices{
	static UserLRDao userLRDao=new UserLRDaoImpl();
	public UserLRServicesImpl() {
		super(userLRDao);
	}
	
	/**
	 * 方法描述:验证注册
	 * @return
	 */
	public String checkregister(User1 u){
		userLRDao.register(u);
		return null;
	}


	public User1 checklogin(String username,String password) {
		User1 user=(User1) userLRDao.login(username,password);
		return user;
	}
}
