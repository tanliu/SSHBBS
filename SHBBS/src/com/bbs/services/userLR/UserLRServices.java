package com.bbs.services.userLR;

import java.io.Serializable;

import com.bbs.entity.blog.Blog;

import com.bbs.entity.user.User1;
import com.bbs.services.BaseServices;
import com.bbs.utils.PageUtils;
import com.bbs.utils.QueryUtils;


public interface UserLRServices extends BaseServices<User1> {

	
	
	/**
	 * ��������:�ڽӿڶ���checkregister����
	 * @return
	 */
	public String checkregister(User1 u);
	
	public User1 checklogin(String username,String password);
	

	}
